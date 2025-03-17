// filepath: /Users/sambandamagoramoorthy/Downloads/flutterTask/gamevibe/lib/screens/home_screen.dart
import 'package:flutter/material.dart';
import '../localization.dart';
import 'rock_paper_scissors.dart';
import 'snake_game.dart';
import 'whack_a_mole.dart';

class HomeScreen extends StatefulWidget {
  final VoidCallback onLanguageSwitch;

  const HomeScreen({super.key, required this.onLanguageSwitch});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final TextEditingController _usernameController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF212121),
      appBar: AppBar(
        title: Text(AppLocalizations.of(context).translate('app_title')),
        backgroundColor: Color(0xFF3F51B5),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              AppLocalizations.of(context).translate('welcome') ,
              style: TextStyle(
                fontSize: 40,
                fontWeight: FontWeight.bold,
                color: Color(0xFFFAFAFA),
              ),
            ),
            SizedBox(height: 15),
            Text(
              AppLocalizations.of(context).translate('tagline'),
              style: TextStyle(
                fontSize: 20,
                color: Color(0xFFFF4081),
                fontStyle: FontStyle.italic,
                letterSpacing: 1.2,
              ),
            ),
            SizedBox(height: 50),
            // Update Snake game container
            GestureDetector(
              onTap: () => _showNameDialog(context, 'snake'),
              child: Container(
                padding: EdgeInsets.all(20),
                decoration: BoxDecoration(
                  color: Color(0xFF424242),
                  borderRadius: BorderRadius.circular(15),
                ),
                child: Row(
                  children: [
                    ClipRRect(
                      borderRadius: BorderRadius.circular(8),
                      child: Image.asset(
                        'assets/images/Snake_icon.png',
                        width: 40,
                        height: 40,
                        fit: BoxFit.cover,
                      ),
                    ),
                    SizedBox(width: 20),
                    Text(
                      AppLocalizations.of(context).translate('snake_game'),
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                        color: Color(0xFFFAFAFA),
                      ),
                    ),
                  ],
                ),
              ),
            ),
            SizedBox(height: 20),
            // Update Rock Paper Scissors container
            GestureDetector(
              onTap: () => _showNameDialog(context, 'rps'),
              child: Container(
                padding: EdgeInsets.all(20),
                decoration: BoxDecoration(
                  color: Color(0xFF424242),
                  borderRadius: BorderRadius.circular(15),
                ),
                child: Row(
                  children: [
                    ClipRRect(
                      borderRadius: BorderRadius.circular(8),
                      child: Image.asset(
                        'assets/images/RockPaperScissor_icon.png',
                        width: 40,
                        height: 40,
                        fit: BoxFit.cover,
                      ),
                    ),
                    SizedBox(width: 20),
                    Text(
                      AppLocalizations.of(context).translate('rock_paper_scissors'),
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                        color: Color(0xFFFAFAFA),
                      ),
                    ),
                  ],
                ),
              ),
            ),
            // After Rock Paper Scissors container
            SizedBox(height: 20),
            GestureDetector(
              onTap: () => _showNameDialog(context, 'mole'),
              child: Container(
                padding: EdgeInsets.all(20),
                decoration: BoxDecoration(
                  color: Color(0xFF424242),
                  borderRadius: BorderRadius.circular(15),
                ),
                child: Row(
                  children: [
                    ClipRRect(
                      borderRadius: BorderRadius.circular(8),
                      child: Image.asset(
                        'assets/images/whack-a-mole_icon.png',
                        width: 40,
                        height: 40,
                        fit: BoxFit.cover,
                      ),
                    ),
                    SizedBox(width: 20),
                    Text(
                      AppLocalizations.of(context).translate('whack_a_mole'),
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.bold,
                        color: Color(0xFFFAFAFA),
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
      floatingActionButton: SizedBox(
        width: 150,
        height: 60,
        child: FloatingActionButton(
          onPressed: widget.onLanguageSwitch,
          backgroundColor: Color(0xFFFF4081),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10),
          ),
          child: Text(
            Localizations.localeOf(context).languageCode == 'en'
                ? AppLocalizations.of(context).translate('switch_to_espanol') 
                : AppLocalizations.of(context).translate('switch_to_english') ,
            textAlign: TextAlign.center,
            style: TextStyle(color: Color(0xFFFAFAFA), fontSize: 14),
          ),
        ),
      ),
    );
  }

  void _showNameDialog(BuildContext context, String gameType) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          backgroundColor: Color(0xFF424242),
          title: Text(
            AppLocalizations.of(context).translate('enter_name_dialog'),
            style: TextStyle(color: Color(0xFFFAFAFA)),
          ),
          content: TextField(
            controller: _usernameController,
            style: TextStyle(color: Color(0xFFFAFAFA)),
            decoration: InputDecoration(
              hintText: AppLocalizations.of(context).translate('your_name'),
              hintStyle: TextStyle(color: Color(0xFF9E9E9E)),
              enabledBorder: UnderlineInputBorder(
                borderSide: BorderSide(color: Color(0xFF3F51B5)),
              ),
            ),
          ),
          actions: [
            TextButton(
              child: Text(
                AppLocalizations.of(context).translate('play_button'),
                style: TextStyle(color: Color(0xFFFF4081)),
              ),
              onPressed: () {
                if (_usernameController.text.trim().isNotEmpty) {
                  Navigator.of(context).pop();
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) {
                        switch (gameType) {
                          case 'snake':
                            return SnakeGame(username: _usernameController.text);
                          case 'rps':
                            return RockPaperScissors(username: _usernameController.text);
                          case 'mole':
                            return WhackAMole(username: _usernameController.text);
                          default:
                            return SnakeGame(username: _usernameController.text);
                        }
                      },
                    ),
                  );
                }
              },
            ),
          ],
        );
      },
    );
  }
}