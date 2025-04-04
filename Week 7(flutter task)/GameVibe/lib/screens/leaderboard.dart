import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../localization.dart';

class Leaderboard extends StatelessWidget {
  final String game;
  final String username;

  const Leaderboard({
    super.key, 
    required this.game,
    required this.username,  // Make sure this is required
  });

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
          Map<String, int> userTotalScores = {};

          // Calculate total scores for each user
          for (var score in scores) {
            String user = score['user'] ?? 'Unknown';
            int scoreValue = (score['score'] as num).toInt();
            userTotalScores[user] = (userTotalScores[user] ?? 0) + scoreValue;
          }

          // Convert to list and sort by total score
          var sortedScores = userTotalScores.entries.toList()
            ..sort((a, b) => b.value.compareTo(a.value));

          return Column(
            children: [
              Container(
                padding: EdgeInsets.all(16),
                color: Color(0xFF3F51B5),
                child: Row(
                  children: [
                    Expanded(
                      flex: 1,
                      child: Text(
                        AppLocalizations.of(context).translate('rank'),
                        style: TextStyle(
                          color: Colors.white,
                          fontWeight: FontWeight.bold,
                          fontSize: 18,
                        ),
                      ),
                    ),
                    Expanded(
                      flex: 2,
                      child: Text(
                        AppLocalizations.of(context).translate('players'),
                        style: TextStyle(
                          color: Colors.white,
                          fontWeight: FontWeight.bold,
                          fontSize: 18,
                        ),
                      ),
                    ),
                    Expanded(
                      flex: 1,
                      child: Text(
                        AppLocalizations.of(context).translate('score'),
                        style: TextStyle(
                          color: Colors.white,
                          fontWeight: FontWeight.bold,
                          fontSize: 18,
                        ),
                        textAlign: TextAlign.center,
                      ),
                    ),
                  ],
                ),
              ),
              Expanded(
                child: ListView.builder(
                  itemCount: sortedScores.length,
                  itemBuilder: (context, index) {
                    final entry = sortedScores[index];
                    final isCurrentUser = entry.key == username;  // Check if current user

                    return Container(
                      color: isCurrentUser ? Color(0xFF3F51B5).withOpacity(0.2) : Colors.transparent,
                      child: ListTile(
                        leading: Text(
                          '${index + 1}',
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 18,
                            color: Colors.white,
                          ),
                        ),
                        title: Text(
                          entry.key,
                          style: TextStyle(
                            color: Colors.white,
                            fontWeight: isCurrentUser ? FontWeight.bold : FontWeight.normal,
                          ),
                        ),
                        trailing: Text(
                          '${entry.value}',
                          style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                            color: Colors.white,
                          ),
                        ),
                      ),
                    );
                  },
                ),
              ),
              Padding(
                padding: EdgeInsets.all(16.0),
                child: ElevatedButton(
                  onPressed: () => Navigator.of(context).pop(),
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Color(0xFFFF4081),
                    padding: EdgeInsets.symmetric(horizontal: 40, vertical: 15),
                  ),
                  child: Text(AppLocalizations.of(context).translate('back_to_game')),
                ),
              ),
            ],
          );
        },
      ),
    );
  }
}