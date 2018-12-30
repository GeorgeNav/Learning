import 'package:flutter/material.dart';

class ParentC extends StatefulWidget {
  @override
  _ParentCState createState() => _ParentCState();
}

class _ParentCState extends State<ParentC> {
  bool _active = false;

  void _handleParentChange(bool newValue) => setState((){
    _active = newValue;
  });

  @override
  Widget build(BuildContext context) => Container(
    margin: EdgeInsets.all(8),
    decoration: BoxDecoration(
      color: Colors.blue
    ),
    child: ChildC(
      active: _active,
      onChanged: _handleParentChange,
    ),
  );
}

class ChildC extends StatefulWidget {
  ChildC({Key key, this.active: false, @required this.onChanged}) : super(key: key);
  final bool active;
  final ValueChanged<bool> onChanged;

  _ChildCState createState() => _ChildCState();
}

class _ChildCState extends State<ChildC> {
  bool _highlight = false;

  void _handleTapDown(_) => setState(() { _highlight = true; });
  void _handleTapUp(_) => setState(() { _highlight = false; });
  void _handleTapCancel() => setState(() { _highlight = false; });
  void _handleTap() => setState(() { widget.onChanged(!widget.active); });

  @override
  Widget build(BuildContext context) => GestureDetector(
    onTapDown: _handleTapDown, // Handle the tap events in the order that
    onTapUp: _handleTapUp, // they occur: down, up, tap, cancel
    onTap: _handleTap,
    onTapCancel: _handleTapCancel, 
    child: Container(
      child: Card(
        margin: EdgeInsets.all(16),
        color: widget.active ? Colors.lightGreen[700] : Colors.grey[600],
        child: Center(
          child: Text(
            widget.active ? 'Active' : 'Inactive',
            style: TextStyle(
              fontSize: 32,
              color: Colors.white
            ),
          ),
        ),
      ),
      decoration: BoxDecoration(
        color: widget.active ? Colors.lightGreen[700] : Colors.grey[600],
        border: _highlight ? Border.all(
          color: Colors.teal[700],
          width: 16
        ) : null,
      ),
    ),
  );
}