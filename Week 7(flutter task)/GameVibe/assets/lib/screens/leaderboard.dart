import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../localization.dart';

class Leaderboard extends StatelessWidget {
  final String game;

  const Leaderboard({super.key, required this.game});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF212121),
      appBar: AppBar(
        title: Text(AppLocalizations.of(context).translate('leaderboard')),
        backgroundColor: Color(0xFF3F51B5),
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

          var sortedUserWins = userWins.entries.toList()
            ..sort((a, b) => b.value.compareTo(a.value));

          return Padding(
            padding: EdgeInsets.all(16.0),
            child: Column(
              children: [
                Text(
                  AppLocalizations.of(context).translate('top_winners'),
                  style: TextStyle(
                    fontSize: 24,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                ),
                SizedBox(height: 20),
                Expanded(
                  child: ListView.builder(
                    itemCount: sortedUserWins.length,
                    itemBuilder: (context, index) {
                      final entry = sortedUserWins[index];
                      return Card(
                        color: Colors.grey[800],
                        child: ListTile(
                          leading: Text(
                            '#${index + 1}',
                            style: TextStyle(color: Colors.white, fontSize: 18),
                          ),
                          title: Text(
                            entry.key,
                            style: TextStyle(
                              color: Colors.white,
                              fontWeight: FontWeight.normal,
                            ),
                          ),
                          trailing: Text(
                            '${AppLocalizations.of(context).translate('score')}: ${entry.value}',
                            style: TextStyle(color: Colors.white, fontSize: 16),
                          ),
                        ),
                      );
                    },
                  ),
                ),
                SizedBox(height: 20),
                ElevatedButton(
                  onPressed: () => Navigator.of(context).pop(),
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Color(0xFFFF4081),
                    padding: EdgeInsets.symmetric(horizontal: 40, vertical: 15),
                  ),
                  child: Text(AppLocalizations.of(context).translate('back_to_game')),
                ),
              ],
            ),
          );
        },
      ),
    );
  }
}