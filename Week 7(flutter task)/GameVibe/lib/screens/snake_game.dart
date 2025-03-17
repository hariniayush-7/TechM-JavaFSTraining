import '../localization.dart';
import 'package:flutter/material.dart';
import 'dart:async';
import 'dart:math';
import 'package:flutter/services.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import 'Snake_scoreboard_screen.dart';
import 'package:audioplayers/audioplayers.dart';
import 'firebase_viewer.dart';

class SnakeGame extends StatefulWidget {
  final String username;
  const SnakeGame({super.key, required this.username});

  @override
  _SnakeGameState createState() => _SnakeGameState();
}

class _SnakeGameState extends State<SnakeGame> {
  final AudioPlayer _audioPlayer = AudioPlayer();
  final int squaresPerRow = 20;
  final int squaresPerCol = 40;
  final fontStyle = TextStyle(color: Colors.white, fontSize: 20);
  final randomGen = Random();

  var snake = [[0, 0]];
  var food = [0, 2];
  var direction = 'right';
  var isPlaying = false;
  var score = 0;

  void startGame() {
    int countdown = 3;
    late StateSetter dialogState;
    
    showDialog(
      context: context,
      barrierDismissible: false,
      builder: (BuildContext context) {
        return StatefulBuilder(
          builder: (context, setDialogState) {
            dialogState = setDialogState;
            return AlertDialog(
              backgroundColor: Color(0xFF424242),
              content: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  Text(
                    AppLocalizations.of(context).translate('game_starts_in'),
                    style: TextStyle(color: Colors.white, fontSize: 24),
                  ),
                  SizedBox(height: 20),
                  Text(
                    countdown.toString(),
                    style: TextStyle(color: Colors.white, fontSize: 40, fontWeight: FontWeight.bold),
                  ),
                ],
              ),
            );
          },
        );
      },
    );

    Timer.periodic(Duration(seconds: 1), (Timer timer) {
      if (countdown > 0) {
        dialogState(() => countdown--);
      }
      if (countdown == 0) {
        timer.cancel();
        Navigator.of(context).pop();
        _startGamePlay();
      }
    });
  }

  void _startGamePlay() {
    const duration = Duration(milliseconds: 300);
    snake = [[(squaresPerRow / 2).floor(), (squaresPerCol / 2).floor()]];
    snake.add([snake.first[0], snake.first[1] - 1]);
    generateNewFood();
    isPlaying = true;

    Timer.periodic(duration, (Timer timer) {
      if (!isPlaying) {
        timer.cancel();
        return;
      }
      moveSnake();
      if (checkGameOver()) {
        isPlaying = false;
        timer.cancel();
        endGame();
      }
    });
  }

  void generateNewFood() {
    food = [randomGen.nextInt(squaresPerRow), randomGen.nextInt(squaresPerCol)];
  }

  void moveSnake() {
    if (!isPlaying) return;

    setState(() {
      String previousDirection = direction;
      switch (direction) {
        case 'up':
          snake.insert(0, [snake.first[0], snake.first[1] - 1]);
          break;
        case 'down':
          snake.insert(0, [snake.first[0], snake.first[1] + 1]);
          break;
        case 'left':
          snake.insert(0, [snake.first[0] - 1, snake.first[1]]);
          break;
        case 'right':
          snake.insert(0, [snake.first[0] + 1, snake.first[1]]);
          break;
      }

      if (snake.first[0] == food[0] && snake.first[1] == food[1]) {
        generateNewFood();
        score += 1;
        _audioPlayer.play(AssetSource('sounds/pop.mp3'));
      } else {
        snake.removeLast();
        if (previousDirection != direction) {
          _audioPlayer.play(AssetSource('sounds/swish.wav'));
        }
      }
    });
  }

  bool checkGameOver() {
    if (!isPlaying) return false;

    if (snake.first[1] < 0 ||
        snake.first[1] >= squaresPerCol ||
        snake.first[0] < 0 ||
        snake.first[0] >= squaresPerRow) {
      _audioPlayer.play(AssetSource('sounds/thud.wav'));
      return true;
    }

    for (var i = 1; i < snake.length; i++) {
      if (snake[i][0] == snake.first[0] && snake[i][1] == snake.first[1]) {
        _audioPlayer.play(AssetSource('sounds/thud.wav'));
        return true;
      }
    }
    return false;
  }

  void endGame() {
    FirebaseFirestore.instance.collection('snake_scores').add({
      'username': widget.username,
      'score': score,
      'timestamp': FieldValue.serverTimestamp(),
    }).then((_) {
      showDialog(
        context: context,
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
                      builder: (context) => ScoreboardScreen(
                        username: widget.username,
                        gameType: 'snake',
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
                        url: 'https://console.firebase.google.com/project/fluttertask-6ca3e/firestore/databases/-default-/data/~2Fsnake_scores?fb_gclid=Cj0KCQjwkN--BhDkARIsAD_mnIrMiyV7aiBgO_YFAvTt4LfVHBMxgbk2qmqxqWhhAUrGfKoBg1cWz4kaAlzYEALw_wcB',
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
                  setState(() {
                    score = 0;
                    startGame();
                  });
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
        }
        return true;
      },
      child: Scaffold(
        backgroundColor: Colors.black,
        body: RawKeyboardListener(
          focusNode: FocusNode(),
          autofocus: true,
          onKey: (RawKeyEvent event) {
            if (event is RawKeyDownEvent) {
              switch (event.logicalKey.keyLabel) {
                case 'Arrow Left':
                  if (direction != 'right') direction = 'left';
                  break;
                case 'Arrow Right':
                  if (direction != 'left') direction = 'right';
                  break;
                case 'Arrow Up':
                  if (direction != 'down') direction = 'up';
                  break;
                case 'Arrow Down':
                  if (direction != 'up') direction = 'down';
                  break;
              }
            }
          },
          child: Column(
            children: [
              Expanded(
                child: GestureDetector(
                  onVerticalDragUpdate: (details) {
                    if (direction != 'up' && details.delta.dy > 0) {
                      direction = 'down';
                    } else if (direction != 'down' && details.delta.dy < 0) {
                      direction = 'up';
                    }
                  },
                  onHorizontalDragUpdate: (details) {
                    if (direction != 'left' && details.delta.dx > 0) {
                      direction = 'right';
                    } else if (direction != 'right' && details.delta.dx < 0) {
                      direction = 'left';
                    }
                  },
                  child: AspectRatio(
                    aspectRatio: squaresPerRow / (squaresPerCol + 5),
                    child: GridView.builder(
                      physics: NeverScrollableScrollPhysics(),
                      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                        crossAxisCount: squaresPerRow,
                      ),
                      itemCount: squaresPerRow * squaresPerCol,
                      itemBuilder: (BuildContext context, int index) {
                        var color = Colors.grey[900];
                        var x = index % squaresPerRow;
                        var y = (index / squaresPerRow).floor();

                        if (snake.any((pos) => pos[0] == x && pos[1] == y)) {
                          color = Colors.green;
                        } else if (food[0] == x && food[1] == y) {
                          color = Colors.red;
                        }

                        return Container(
                          margin: EdgeInsets.all(1),
                          decoration: BoxDecoration(
                            color: color,
                            shape: BoxShape.circle,
                          ),
                        );
                      },
                    ),
                  ),
                ),
              ),
              Padding(
                padding: EdgeInsets.only(bottom: 20),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    Text(
                      '${AppLocalizations.of(context).translate('score')}: $score',
                      style: fontStyle
                    ),
                    TextButton(
                      child: Text(
                        isPlaying 
                          ? AppLocalizations.of(context).translate('end')
                          : AppLocalizations.of(context).translate('start'),
                        style: fontStyle,
                      ),
                      onPressed: () {
                        if (isPlaying) {
                          setState(() => isPlaying = false);
                        } else {
                          startGame();
                        }
                      },
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}