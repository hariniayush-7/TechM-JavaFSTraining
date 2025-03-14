// filepath: /Users/sambandamagoramoorthy/Downloads/flutterTask/gamevibe/lib/screens/home_screen.dart
import 'package:flutter/material.dart';
import '../localization.dart';
import 'rock_paper_scissors.dart';

class HomeScreen extends StatefulWidget {
  final VoidCallback onLanguageSwitch;

  HomeScreen({required this.onLanguageSwitch});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final TextEditingController _usernameController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF212121), // Matte Black
      appBar: AppBar(
        title: Text(AppLocalizations.of(context).translate('welcome')),
        backgroundColor: Color(0xFF3F51B5), // Royal Blue
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Text(
              AppLocalizations.of(context).translate('welcome'),
              style: TextStyle(
                fontSize: 28,
                fontWeight: FontWeight.bold,
                color: Color(0xFFFAFAFA), // Soft White
              ),
            ),
            SizedBox(height: 10),
            Text(
              AppLocalizations.of(context).translate('unleash_gamer'),
              style: TextStyle(
                fontSize: 18,
                color: Colors.grey[600],
              ),
            ),
            SizedBox(height: 40),
            Text(
              AppLocalizations.of(context).translate('play'),
              style: TextStyle(
                fontSize: 22,
                fontWeight: FontWeight.w600,
                color: Color(0xFFFAFAFA), // Soft White
              ),
            ),
            SizedBox(height: 20),
            TextField(
              controller: _usernameController,
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                labelText: AppLocalizations.of(context).translate('enter_name'),
                labelStyle: TextStyle(color: Color(0xFFFAFAFA)), // Soft White
                filled: true,
                fillColor: Colors.grey[800],
              ),
              style: TextStyle(color: Color(0xFFFAFAFA)), // Soft White
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                if (_usernameController.text.isNotEmpty) {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => RockPaperScissors(
                        username: _usernameController.text,
                      ),
                    ),
                  );
                } else {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(content: Text('Please enter your name')),
                  );
                }
              },
              style: ElevatedButton.styleFrom(
                backgroundColor: Color(0xFFFF4081), // Vivid Pink
                padding: EdgeInsets.symmetric(horizontal: 40, vertical: 15),
                textStyle: TextStyle(fontSize: 20),
              ),
              child: Text(AppLocalizations.of(context).translate('rock_paper_scissors')),
            ),
          ],
        ),
      ),
      floatingActionButton: Container(
        width: 150,
        height: 60,
        child: FloatingActionButton(
          onPressed: widget.onLanguageSwitch,
          backgroundColor: Color(0xFFFF4081), // Vivid Pink
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10),
          ),
          child: Text(
            Localizations.localeOf(context).languageCode == 'en'
                ? 'Switch to Español'
                : 'Switch to English',
            textAlign: TextAlign.center,
            style: TextStyle(
              color: Color(0xFFFAFAFA), // Soft White
              fontSize: 14,
            ),
          ),
        ),
      ),
    );
  }
}