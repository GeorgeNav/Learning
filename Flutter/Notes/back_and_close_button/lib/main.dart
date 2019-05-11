import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) => MaterialApp(
    title: 'Flutter Demo',
    theme: ThemeData(
      primarySwatch: Colors.blue,
    ),
    home: OnePage(),
  );
}

class OnePage extends StatefulWidget {
  @override
  _OnePageState createState() =>  _OnePageState();
}

class _OnePageState extends State<OnePage> {
  @override
  Widget build(BuildContext context) => Scaffold(
    appBar:  AppBar(
      leading: Container(
        child: IconButton(
          icon: Icon(CupertinoIcons.back),
          onPressed: () => Navigator.of(context).pop(null),
        ),
      ),
      title:  Text('Page Title'),
      actions: <Widget>[
        IconButton(
          icon:  Icon(Icons.close),
          onPressed: () => Navigator.of(context).pop(null),
        ),
      ],
    ),
    body:  Container(),
  );
}
