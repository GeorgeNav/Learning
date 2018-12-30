import 'package:flutter/material.dart';
import 'parent_control.dart';
import 'child_control.dart';
import 'mix_control.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) => MaterialApp(
    title: 'Flutter Demo',
    theme: ThemeData(
      primarySwatch: Colors.blue,
    ),
    home: Column(
      children: <Widget>[
        Expanded(child: ParentA()),
        Expanded(child: ParentB()),
        Expanded(child: ParentC()),
      ],
    ),
  );
}
