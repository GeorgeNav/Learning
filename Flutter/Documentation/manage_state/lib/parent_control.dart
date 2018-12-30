import 'package:flutter/material.dart';

class ParentB extends StatefulWidget {
  _ParentBState createState() => _ParentBState();
}

class _ParentBState extends State<ParentB> {
  bool _active = false;

  void _handleParentChange(bool newValue) => setState(() {
    print('change parent bool _active to $newValue');
    _active = newValue;
  });

  @override
  Widget build(BuildContext context) => Container(
    margin: EdgeInsets.all(8),
    decoration: BoxDecoration(
      color: Colors.blue
    ),
    child: ChildB(
      active: _active,
      onChanged: _handleParentChange,
    ),
  );
}

class ChildB extends StatelessWidget {
  ChildB({Key key, this.active: false, @required this.onChanged}) : super(key: key);
  final bool active;
  final ValueChanged<bool> onChanged;

  void _handleTap() {
    print('calling function from child to parent inorder to...');
    onChanged(!active);
  }

   Widget build(BuildContext context) => GestureDetector(
    onTap: _handleTap,
    child: Card(
      margin: EdgeInsets.all(16),
      color: active ? Colors.lightGreen[700] : Colors.grey[600],
      child: Center(
        child: Text(
          active ? 'Active' : 'Inactive',
          style: TextStyle(
            fontSize: 32,
            color: Colors.white
          ),
        ),
      ),
    ),
  );
}