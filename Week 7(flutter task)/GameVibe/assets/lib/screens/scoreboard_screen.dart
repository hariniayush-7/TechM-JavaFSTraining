import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../localization.dart';

class ScoreboardScreen extends StatelessWidget {
  final String username;
  final String gameType;

  const ScoreboardScreen({super.key, required this.username, required this.gameType});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF212121),
      appBar: AppBar(
        title: Text(AppLocalizations.of(context).translate('leaderboard')),
      ),
      body: StreamBuilder<QuerySnapshot>(
        stream: FirebaseFirestore.instance
            .collection(gameType == 'snake' ? 'snake_scores' : 'rps_scores')
            .orderBy('score', descending: true)
            .snapshots(),  // Removed the .limit(10)
        builder: (context, snapshot) {
          if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          }

          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          }

          final scores = snapshot.data!.docs;

          return Padding(
            padding: EdgeInsets.all(16.0),
            child: Column(
              children: [
                Text(
                  AppLocalizations.of(context).translate('snake_leaderboard'),
                  style: TextStyle(
                    fontSize: 24,
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                ),
                SizedBox(height: 20),
                Expanded(
                  child: ListView.builder(
                    itemCount: scores.length,
                    itemBuilder: (context, index) {
                      final data = scores[index].data() as Map<String, dynamic>;
                      final isCurrentUser = data['username'] == username;

                      return Card(
                        color: isCurrentUser ? Colors.blue[900] : Colors.grey[800],
                        child: ListTile(
                          leading: Text(
                            '#${index + 1}',
                            style: TextStyle(color: Colors.white, fontSize: 18),
                          ),
                          title: Text(
                            data['username'] ?? AppLocalizations.of(context).translate('player'),
                            style: TextStyle(
                              color: Colors.white,
                              fontWeight: isCurrentUser ? FontWeight.bold : FontWeight.normal,
                            ),
                          ),
                          trailing: Text(
                            '${AppLocalizations.of(context).translate('score')}: ${data['score']}',
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
                  child: Text(AppLocalizations.of(context).translate('stay')),
                ),
              ],
            ),
          );
        },
      ),
    );
  }
}