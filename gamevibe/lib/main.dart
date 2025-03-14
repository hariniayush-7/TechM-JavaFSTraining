import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'localization.dart';
import 'screens/home_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(GameVibeApp());
}

class GameVibeApp extends StatefulWidget {
  @override
  _GameVibeAppState createState() => _GameVibeAppState();
}

class _GameVibeAppState extends State<GameVibeApp> {
  Locale _locale = Locale('en', '');

  void _switchLanguage() {
    setState(() {
      if (_locale.languageCode == 'en') {
        _locale = Locale('es', '');
      } else {
        _locale = Locale('en', '');
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'GameVibe',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: HomeScreen(onLanguageSwitch: _switchLanguage),
      locale: _locale,
      localizationsDelegates: [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      supportedLocales: [
        Locale('en', ''), // English
        Locale('es', ''), // Spanish
      ],
    );
  }
}