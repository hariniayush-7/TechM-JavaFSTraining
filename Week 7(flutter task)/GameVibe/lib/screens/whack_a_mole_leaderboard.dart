import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../localization.dart';

class WhackAMoleLeaderboard extends StatelessWidget {
  final String username;
  
  const WhackAMoleLeaderboard({super.key, required this.username});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.green[100],
      appBar: AppBar(
        title: Text(AppLocalizations.of(context).translate('mole_leaderboard')),
        backgroundColor: Colors.brown,
      ),
      body: StreamBuilder<QuerySnapshot>(
        stream: FirebaseFirestore.instance
            .collection('mole_scores')
            .orderBy('score', descending: true)
            .limit(10)
            .snapshots(),
        builder: (context, snapshot) {
          if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          }

          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          }

          final scores = snapshot.data!.docs;

          return Column(
            children: [
              Container(
                padding: EdgeInsets.all(16),
                color: Colors.brown,
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
                  itemCount: scores.length,
                  itemBuilder: (context, index) {
                    final score = scores[index].data() as Map<String, dynamic>;
                    final isCurrentUser = score['username'] == username;

                    return Container(
                      color: isCurrentUser ? Colors.brown[100] : null,
                      child: ListTile(
                        leading: Text(
                          '${index + 1}',
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 18,
                            color: Colors.brown,
                          ),
                        ),
                        title: Text(
                          score['username'] ?? 'Unknown',
                          style: TextStyle(
                            fontWeight: isCurrentUser ? FontWeight.bold : FontWeight.normal,
                          ),
                        ),
                        trailing: Text(
                          '${score['score']}',
                          style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                            color: Colors.brown,
                          ),
                        ),
                      ),
                    );
                  },
                ),
              ),
            ],
          );
        },
      ),
    );
  }
}