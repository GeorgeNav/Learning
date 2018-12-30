import 'package:flutter/material.dart';

var gestureText = TextEditingController();

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  var _wh = 50; // base width and height for BoxWidget

  Widget build(BuildContext context) {
    return MaterialApp( // This is the root of the widget tree
      home: Scaffold( // layout for material components
        appBar: AppBar(
          title: Center(
            child: Text('Widgets'),
          ),
          actions: <Widget>[
            getButton(context, () {
  /*             Navigator.of(context).pushNamed(routeName); */
            }),
          ],
        ),
        body: Column(
          children: <Widget>[
            Stack( // first added on top by default
              children: <Widget>[
                getSizedBox(context, 3.5, Colors.red),
                getSizedBox(context, 3, Colors.green),
                getSizedBox(context, 2.5, Colors.yellow),
                getSizedBox(context, 2, Colors.pink),
                getSizedBox(context, 1.5, Colors.blue),
                getSizedBox(context, 1, Colors.orange),
                Container(
                  padding: EdgeInsets.all(2),
                  decoration: BoxDecoration(
                    color: Colors.teal,
                  ),
                  child: getRow(context, 'This is a TextWidget'),
                ),
              ],
            ),
            Expanded(child: GestureArea()),

          ],
        ),
        floatingActionButton: FloatingActionButton(
          tooltip: 'Add',
          child: Icon(Icons.add),
        ),
      ),
    );
  }

  Widget getText(BuildContext context, String text) => /* Center( // This is the root of the widget tree
    child:  */Text(
      text,
      textDirection: TextDirection.ltr, // MaterialApp widget would normally take care of this so it must be done manually here
    ); // This is part of the widget tree
/*   ); */

  Widget getButton(BuildContext context, fn) => IconButton(
    color: Colors.black,
    tooltip: 'This is a button',
    icon: Icon(Icons.widgets),
    onPressed: () {
      // Navigator.of(context).pushNamed(routeName);
    },
  );

  Widget getRow(BuildContext context, String text) => Row(
    children: <Widget>[
      getText(context, text),
    ],
  );

  Widget getColumn(BuildContext context) => Column(
    children: <Widget>[
      getRow(context, 'This is a text widget'),
      getRow(context, 'This is another text widget'),
    ],
  );

  Widget getSizedBox(BuildContext context, double scale, Color color) => SizedBox(
    width: _wh * scale,
    height: _wh * scale,
    child: Card(color: color),
  );
}

class GestureArea extends StatefulWidget {
  @override
  _GestureAreaState createState() => _GestureAreaState();
}

class _GestureAreaState extends State<GestureArea> {
  @override
  Widget build(BuildContext context) => GestureDetector(
    onTap: () => setState(() =>
        gestureText.text = 'Tap: tapped'),
    onTapCancel: () => setState(() =>
        gestureText.text = 'Tap: not clicked after all!'),// tap, hold and drag away from child
    onTapDown: (xy) => setState(() =>
        gestureText.text = 'Tap: currently down at ${xy.globalPosition}'), // xy contains information about tap down
    onTapUp: (xy) => setState(() =>
      gestureText.text = 'Tap: currently letgo at ${xy.globalPosition}'), // xy contains information about letting go tap (does not occur after tap hold)
    onDoubleTap: () => setState(() =>
      gestureText.text = 'Tap: Double tap!'),
    onLongPress: () => setState(() =>
      gestureText.text = 'Long press!'),
    onHorizontalDragDown: (xy) => setState(() =>
      gestureText.text = 'HorDrag: Drag Down here $xy'), // where xy is (x,y) coordinates of start of drag (will happen even if it's not a horizontal drag)
    onHorizontalDragEnd: (xy) => setState(() =>
      gestureText.text = 'HorDrag: Drag velocity $xy'), // where xy is (x,y) velocity vector at end of drag
    onHorizontalDragCancel: () => setState(() =>
      gestureText.text = 'HorDrag: Dragged but canceled!'), // single/long press and letgo (will happen even if it's not a horizontal drag)
    onHorizontalDragUpdate: (xy) => setState(() =>
      gestureText.text = 'HorDrag: pointer position during horizontal drag'), // Keeps track of pointer position during horizontal drag
    onPanStart: (xy) => setState(() =>
      gestureText.text = 'Pan: started here: $xy'), // happens no matter what
    onPanDown: (xy) => setState(() =>
      gestureText.text = 'Pan: pointer location where pan might start $xy'), // happens no matter what
    onPanCancel: () => setState(() =>
      gestureText.text = 'Pan: panned by canceled!'), // tap, hold, let go without moving pointer location
    onPanUpdate: (xy) => setState(() =>
      gestureText.text = 'Pan: pointer that\'s panning is currently at $xy'), // Keeps track of where pointer is during pan (either x or y is 0 depeneding on direction of pan)
    child: Container(
      height: 36.0,
      padding: EdgeInsets.all(8),
      margin: EdgeInsets.symmetric(horizontal: 8),
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(5),
        color: Colors.lightGreen[500],
      ),
      child: Center(
        child: Text(
          gestureText.text != null ? gestureText.text : 'Nothing has happened yet'
        ),
      ),
    ),
  );
}
