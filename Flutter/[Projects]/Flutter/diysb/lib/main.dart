import 'package:flutter/material.dart';
import 'package:diysb/routes/splash.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'DIYSB',
      theme: ThemeData(
        primarySwatch: Colors.grey,
      ),
      home: Splash(),
    );
  }
}
