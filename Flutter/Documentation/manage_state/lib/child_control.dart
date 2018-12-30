import 'package:flutter/material.dart';

class ParentA extends StatelessWidget {
  @override
  Widget build(BuildContext context) => Container(
    margin: EdgeInsets.all(8),
    decoration: BoxDecoration(
      color: Colors.blue
    ),
    child: ChildA(),
  );
}

class ChildA extends StatefulWidget {
  ChildA({Key key}) : super(key: key);

  _ChildAState createState() => _ChildAState();
}

class _ChildAState extends State<ChildA> {
  bool _active = false;

  void _handleTap() => setState((){
      _active = !_active;
  });

  @override
  Widget build(BuildContext context) => GestureDetector(
    onTap: _handleTap,
    child: Card(
      margin: EdgeInsets.all(16),
      color: _active ? Colors.lightGreen[700] : Colors.grey[600],
      child: Center(
        child: Text(
          _active ? 'Active' : 'Inactive',
          style: TextStyle(
            fontSize: 32,
            color: Colors.white
          ),
        ),
      ),
    ),
  );
}