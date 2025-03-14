// filepath: lib/services/firestore_service.dart
import 'package:cloud_firestore/cloud_firestore.dart';

class FirestoreService {
  final FirebaseFirestore _db = FirebaseFirestore.instance;

  Future<void> saveHighScore(String game, String user, int score) async {
    await _db.collection('high_scores').add({
      'game': game,
      'user': user,
      'score': score,
      'timestamp': FieldValue.serverTimestamp(),
    });
  }

  Stream<QuerySnapshot> getHighScores(String game) {
    return _db
        .collection('high_scores')
        .where('game', isEqualTo: game)
        .orderBy('score', descending: true)
        .snapshots();
  }
}
