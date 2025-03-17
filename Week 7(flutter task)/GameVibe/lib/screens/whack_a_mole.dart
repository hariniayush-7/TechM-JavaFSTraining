import 'package:flutter/material.dart';
import 'dart:async';
import 'dart:math';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../localization.dart';
import 'package:audioplayers/audioplayers.dart';
import 'whack_a_mole_leaderboard.dart';
import 'firebase_viewer.dart';

class WhackAMole extends StatefulWidget {
  final String username;
  const WhackAMole({super.key, required this.username});

  @override
  _WhackAMoleState createState() => _WhackAMoleState();
}

class _WhackAMoleState extends State<WhackAMole> {
  final AudioPlayer _audioPlayer = AudioPlayer();
  final Random _random = Random();
  
  List<bool> moles = List.generate(9, (_) => false);
  List<bool> bombs = List.generate(9, (_) => false);
  int score = 0;
  int timeLeft = 60;
  bool isPlaying = false;
  Timer? gameTimer;
  Timer? moleTimer;
  final int maxTime = 60;
  // Change initial speed (higher number = slower speed)
  double moleSpeed = 2000;  // Changed from 1200

  void startGame() {
    setState(() {
      score = 0;
      timeLeft = maxTime;
      isPlaying = true;
      moleSpeed = 2000;  // Match the initial speed
      moles = List.generate(9, (_) => false);
      bombs = List.generate(9, (_) => false);
    });

    gameTimer = Timer.periodic(Duration(seconds: 1), (timer) {
      setState(() {
        if (timeLeft > 0) {
          timeLeft--;
          if (timeLeft % 10 == 0 && moleSpeed > 900) {  // Changed minimum speed
            moleSpeed -= 300;  // Smaller speed reduction
            _updateMoleTimer();
          }
        } else {
          endGame();
        }
      });
    });

    _updateMoleTimer();
  }

  void _updateMoleTimer() {
    moleTimer?.cancel();
    moleTimer = Timer.periodic(Duration(milliseconds: moleSpeed.toInt()), (timer) {
      if (isPlaying) {
        showRandomMole();
      }
    });
  }

  void showRandomMole() {
    setState(() {
      for (int i = 0; i < moles.length; i++) {
        moles[i] = false;
        bombs[i] = false;
      }
      if (_random.nextDouble() < 0.2) {
        bombs[_random.nextInt(9)] = true;
      } else {
        moles[_random.nextInt(9)] = true;
      }
    });
  }

  void whackMole(int index) {
    if (!isPlaying) return;

    if (bombs[index]) {
      _audioPlayer.play(AssetSource('sounds/error_sound.mp3'));
      setState(() {
        score = score > 2 ? score - 2 : 0;
        bombs[index] = false;
      });
    } else if (moles[index]) {
      _audioPlayer.setPlaybackRate(2.0); // Speed up the sound to 2x
      _audioPlayer.play(AssetSource('sounds/bonk-sound.mp3'));
      setState(() {
        score++;
        moles[index] = false;
      });
    }
  }

  void endGame() {
    isPlaying = false;
    gameTimer?.cancel();
    moleTimer?.cancel();

    FirebaseFirestore.instance.collection('mole_scores').add({
      'username': widget.username,
      'score': score,
      'timestamp': FieldValue.serverTimestamp(),
    }).then((_) {
      showDialog(
        context: context,
        barrierDismissible: false,
        builder: (BuildContext context) {
          return AlertDialog(
            backgroundColor: Color(0xFF424242),
            title: Text(
              AppLocalizations.of(context).translate('game_over'),
              style: TextStyle(color: Colors.white),
            ),
            content: Text(
              '${AppLocalizations.of(context).translate('score')}: $score',
              style: TextStyle(color: Colors.white),
            ),
            actions: <Widget>[
              TextButton(
                child: Text(
                  AppLocalizations.of(context).translate('view_scoreboard'),
                  style: TextStyle(color: Color(0xFFFF4081)),
                ),
                onPressed: () {
                  Navigator.of(context).pushReplacement(
                    MaterialPageRoute(
                      builder: (context) => WhackAMoleLeaderboard(
                        username: widget.username,
                      ),
                    ),
                  );
                },
              ),
              TextButton(
                child: Text(
                  'View in Firebase',
                  style: TextStyle(color: Color(0xFFFF4081)),
                ),
                onPressed: () {
                  Navigator.of(context).push(
                    MaterialPageRoute(
                      builder: (context) => FirebaseViewer(
                        url: 'https://console.firebase.google.com/project/fluttertask-6ca3e/firestore/databases/-default-/data/~2Fmole_scores?fb_gclid=Cj0KCQjwkN--BhDkARIsAD_mnIrMiyV7aiBgO_YFAvTt4LfVHBMxgbk2qmqxqWhhAUrGfKoBg1cWz4kaAlzYEALw_wcB',
                      ),
                    ),
                  );
                },
              ),
              TextButton(
                child: Text(
                  AppLocalizations.of(context).translate('play_again'),
                  style: TextStyle(color: Color(0xFFFF4081)),
                ),
                onPressed: () {
                  Navigator.of(context).pop();
                  startGame();
                },
              ),
            ],
          );
        },
      );
    });
  }

  @override
  void dispose() {
    gameTimer?.cancel();
    moleTimer?.cancel();
    _audioPlayer.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return WillPopScope(
      onWillPop: () async {
        if (isPlaying) {
          return await showDialog(
            context: context,
            builder: (context) => AlertDialog(
              backgroundColor: Color(0xFF424242),
              title: Text(
                AppLocalizations.of(context).translate('quit_game'),
                style: TextStyle(color: Colors.white),
              ),
              content: Text(
                AppLocalizations.of(context).translate('quit_warning'),
                style: TextStyle(color: Colors.white),
              ),
              actions: [
                TextButton(
                  onPressed: () => Navigator.of(context).pop(false),
                  child: Text(
                    AppLocalizations.of(context).translate('stay'),
                    style: TextStyle(color: Color(0xFFFF4081)),
                  ),
                ),
                TextButton(
                  onPressed: () => Navigator.of(context).pop(true),
                  child: Text(
                    AppLocalizations.of(context).translate('leave'),
                    style: TextStyle(color: Color(0xFFFF4081)),
                  ),
                ),
              ],
            ),
          ) ?? false;
        }
        return true;
      },
      child: Scaffold(
        backgroundColor: Colors.green[100],
        appBar: AppBar(
          title: Text(AppLocalizations.of(context).translate('whack_a_mole')),
          backgroundColor: Colors.brown,
        ),
        body: Column(
          children: [
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  Text(
                    '${AppLocalizations.of(context).translate('score')}: $score',
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                  ),
                  Text(
                    '${AppLocalizations.of(context).translate('time')}: $timeLeft',
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                  ),
                   Text(
                    'Speed: ${((2000 - moleSpeed) / 300).round() + 1}x',  // Updated calculation
                    style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                  ),
                ],
              ),
            ),
            Expanded(
              child: GridView.builder(
                padding: EdgeInsets.all(16),
                gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 3,
                  crossAxisSpacing: 10,
                  mainAxisSpacing: 10,
                ),
                itemCount: 9,
                itemBuilder: (context, index) {
                  return GestureDetector(
                    onTap: () => whackMole(index),
                    child: Container(
                      decoration: BoxDecoration(
                        color: Colors.brown,
                        borderRadius: BorderRadius.circular(15),
                      ),
                      child: Center(
                        // Update image paths to use correct asset directory
                        child: bombs[index]
                            ? Image.asset('assets/images/bomb.jpg')
                            : moles[index]
                                ? Image.asset('assets/images/mole.png')
                                : Container(
                                    decoration: BoxDecoration(
                                      color: Colors.brown[600],
                                      borderRadius: BorderRadius.circular(15),
                                    ),
                                  ),
                      ),
                    ),
                  );
                },
              ),
            ),
            if (!isPlaying)
              Padding(
                padding: const EdgeInsets.all(20.0),
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.brown[600],  // Changed color
                    padding: EdgeInsets.symmetric(horizontal: 50, vertical: 20),
                  ),
                  onPressed: startGame,
                  child: Text(
                    AppLocalizations.of(context).translate('start_game'),
                    style: TextStyle(fontSize: 24, color: Colors.white),  // Added explicit text color
                  ),
                ),
              ),
          ],
        ),
      ),
    );
  }
}