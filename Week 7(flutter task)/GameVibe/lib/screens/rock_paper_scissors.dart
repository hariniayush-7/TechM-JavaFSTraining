import 'dart:math';
import 'package:flutter/material.dart';
import 'package:audioplayers/audioplayers.dart';
import '../localization.dart';
import 'leaderboard.dart';
import 'firestore_service.dart';

class RockPaperScissors extends StatefulWidget {
  final String username;

  const RockPaperScissors({super.key, required this.username});

  @override
  _RockPaperScissorsState createState() => _RockPaperScissorsState();
}

class _RockPaperScissorsState extends State<RockPaperScissors> {
  final List<String> _choices = ['Rock', 'Paper', 'Scissors'];
  String _playerChoice = '';
  String _computerChoice = '';
  String _result = '';
  final AudioPlayer _audioPlayer = AudioPlayer();
  final FirestoreService _firestoreService = FirestoreService();
  int _playCount = 0;
  final int _maxPlays = 7;

  void _playGame(String playerChoice) {
    if (_playCount < _maxPlays) {
      _playerChoice = playerChoice;
      _computerChoice = _choices[Random().nextInt(3)];
      _result = _determineWinner(_playerChoice, _computerChoice);
      _playSound(_result);
      _saveScore(_result);
      _playCount++;
      setState(() {});
    }
  }

  String _determineWinner(String player, String computer) {
    if (player == computer) {
      return AppLocalizations.of(context).translate('draw');
    } else if ((player == 'Rock' && computer == 'Scissors') ||
        (player == 'Paper' && computer == 'Rock') ||
        (player == 'Scissors' && computer == 'Paper')) {
      return AppLocalizations.of(context).translate('win');
    } else {
      return AppLocalizations.of(context).translate('lose');
    }
  }

  void _playSound(String result) async {
    if (result == AppLocalizations.of(context).translate('win')) {
      await _audioPlayer.play(AssetSource('sounds/happy_sound.wav'));
    } else if (result == AppLocalizations.of(context).translate('lose')) {
      await _audioPlayer.play(AssetSource('sounds/sad_sound.mp3'));
    } else if (result == AppLocalizations.of(context).translate('draw')) {
      await _audioPlayer.play(AssetSource('sounds/draw_sound.wav'));
    }
  }

  void _saveScore(String result) {
    if (result == AppLocalizations.of(context).translate('win')) {
      _firestoreService.saveHighScore('Rock-Paper-Scissors', widget.username, 1);
    }
  }

  void _showAlert(String title, String message) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text(title),
          content: Text(message),
          actions: [
            TextButton(
              child: Text(AppLocalizations.of(context).translate('ok')),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return PopScope(
      canPop: _playCount == 0 || _playCount >= _maxPlays,
      onPopInvoked: (didPop) async {
        if (didPop) {
          return;
        }
        
        final bool shouldPop = await showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: Text(AppLocalizations.of(context).translate('quit_game')),
            content: Text(AppLocalizations.of(context).translate('quit_warning')),
            actions: [
              TextButton(
                onPressed: () => Navigator.of(context).pop(false),
                child: Text(AppLocalizations.of(context).translate('stay')),
              ),
              TextButton(
                onPressed: () => Navigator.of(context).pop(true),
                child: Text(AppLocalizations.of(context).translate('leave')),
              ),
            ],
          ),
        ) ?? false;

        if (shouldPop) {
          Navigator.of(context).pop();
        }
      },
      child: Scaffold(
        backgroundColor: Color(0xFF212121),
        appBar: AppBar(
          title: Text(AppLocalizations.of(context).translate('rock_paper_scissors')),
          backgroundColor: Color(0xFF3F51B5),
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              AppLocalizations.of(context).translate('choose_move'),
              style: TextStyle(
                fontSize: 24,
                color: Color(0xFFFAFAFA),
              ),
            ),
            SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: _choices.map((choice) {
                return GestureDetector(
                  onTap: _playCount < _maxPlays ? () => _playGame(choice) : null,
                  child: Image.asset(
                    'assets/images/${choice.toLowerCase()}.jpeg',
                    width: 100,
                    height: 100,
                  ),
                );
              }).toList(),
            ),
            SizedBox(height: 20),
            Text(
              '${AppLocalizations.of(context).translate('your_choice')} $_playerChoice',
              style: TextStyle(
                fontSize: 20,
                color: Color(0xFFFAFAFA),
              ),
            ),
            Text(
              '${AppLocalizations.of(context).translate('computer_choice')} $_computerChoice',
              style: TextStyle(
                fontSize: 20,
                color: Color(0xFFFAFAFA),
              ),
            ),
            SizedBox(height: 20),
            Text(
              _result,
              style: TextStyle(
                fontSize: 24,
                fontWeight: FontWeight.bold,
                color: Color(0xFFFAFAFA),
              ),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                if (_playCount < _maxPlays) {
                  _showAlert(
                    AppLocalizations.of(context).translate('alert_title'),
                    AppLocalizations.of(context).translate('alert_message'),
                  );
                } else {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => Leaderboard(game: 'Rock-Paper-Scissors'),
                    ),
                  );
                }
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Color(0xFFFF4081),
              ),
              child: Text(AppLocalizations.of(context).translate('view_leaderboard')),
            ),
            SizedBox(height: 20),
            if (_playCount >= _maxPlays)
              Text(
                AppLocalizations.of(context).translate('game_over'),
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: Color(0xFFFF4081),
                ),
              ),
          ],
        ),
      ),
    );
  }

  @override
  void dispose() {
    _audioPlayer.dispose();
    super.dispose();
  }
}