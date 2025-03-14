// filepath: /Users/sambandamagoramoorthy/Downloads/flutterTask/gamevibe/lib/screens/leaderboard.dart
import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../localization.dart';

class Leaderboard extends StatelessWidget {
  final String game;

  Leaderboard({required this.game});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF212121), // Matte Black
      appBar: AppBar(
        title: Text(AppLocalizations.of(context).translate('top_winners')),
        backgroundColor: Color(0xFF3F51B5), // Royal Blue
      ),
      body: StreamBuilder<QuerySnapshot>(
        stream: FirebaseFirestore.instance
            .collection('high_scores')
            .where('game', isEqualTo: game)
            .snapshots(),
        builder: (context, snapshot) {
          if (!snapshot.hasData) {
            return Center(child: CircularProgressIndicator());
          }
          final scores = snapshot.data!.docs;
          Map<String, int> userWins = {};

          for (var score in scores) {
            int scoreValue = (score['score'] as num).toInt();
            if (score['user'] != 'Computer') {
              userWins[score['user']] = (userWins[score['user']] ?? 0) + scoreValue;
            }
          }

          // Sort users by wins in descending order
          var sortedUserWins = userWins.entries.toList()
            ..sort((a, b) => b.value.compareTo(a.value));

          return ListView(
            padding: EdgeInsets.all(20),
            children: sortedUserWins.map((entry) {
              return ListTile(
                title: Text(
                  entry.key,
                  style: TextStyle(color: Color(0xFFFAFAFA)), // Soft White
                ),
                trailing: Text(
                  '${entry.value}',
                  style: TextStyle(color: Color(0xFFFFD600)), // Bright Yellow
                ),
                tileColor: Colors.grey[800],
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(10),
                ),
                contentPadding: EdgeInsets.symmetric(horizontal: 20, vertical: 10),
              );
            }).toList(),
          );
        },
      ),
    );
  }
}