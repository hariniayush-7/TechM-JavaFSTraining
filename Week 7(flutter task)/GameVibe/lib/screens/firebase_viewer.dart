import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class FirebaseViewer extends StatelessWidget {
  final String url;
  const FirebaseViewer({super.key, required this.url});

  Future<void> _launchUrl() async {
    final Uri uri = Uri.parse(url);
    if (!await launchUrl(uri, mode: LaunchMode.externalApplication)) {
      throw Exception('Could not launch $url');
    }
  }

  @override
  Widget build(BuildContext context) {
    _launchUrl(); // Launch URL immediately
    return const Scaffold(
      body: Center(
        child: CircularProgressIndicator(),
      ),
    );
  }
}