import 'package:flutter/material.dart';

final _rowHeight = 100.0;
final _borderRadius = BorderRadius.circular(_rowHeight / 2);

/// A custom [Category] widget.
///
/// The widget is composed on an [Icon] and [Text]. Tapping on the widget shows
/// a colored [InkWell] animation.
class Category extends StatelessWidget {
  final String name;
  final ColorSwatch color;
  final IconData iconLocation;
  /// Creates a [Category].
  ///
  /// A [Category] saves the name of the Category (e.g. 'Length'), its color for
  /// the UI, and the icon that represents it (e.g. a ruler).
  // DONE: You'll need the name, color, and iconLocation from main.dart
  const Category({
    Key key,
    this.name,
    this.color,
    this.iconLocation,
  }) : assert(name != null && color != null && iconLocation != null ), super(key: key);

  /// Builds a custom widget that shows [Category] information.
  ///
  /// This information includes the icon, name, and color for the [Category].
  @override
  // This `context` parameter describes the location of this widget in the
  // widget tree. It can be used for obtaining Theme data from the nearest
  // Theme ancestor in the tree. Below, we obtain the display1 text theme.
  // See https://docs.flutter.io/flutter/material/Theme-class.html
    // DONE: Build the custom widget here, referring to the Specs.
  Widget build(BuildContext context) {
      return Material( // where the container resides
        color: Colors.lightGreen[200], // Sets background color of material widget to transparent
        elevation: 2.0, // elevates pixels for this material
        child: Container( // paints, positions, sizes widgets, and takes size of the child
          height: _rowHeight, 
          child: InkWell(
            borderRadius: _borderRadius, // effects InkWell behavior when pressed
            highlightColor: color,
            splashColor: color,
            // We can use either the () => function() or the () { function(); }
            // syntax.
            onTap: () {
              print('I was tapped!');
            },
            child: Padding(
              padding: EdgeInsets.all(8.0), // sets all cardinal (left, right, top, bottom) padding to 8px
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.stretch, // cause children to stretch to fill everything
                // There are two ways to denote a list: `[]` and `List()`.
                // Prefer to use the literal syntax, i.e. `[]`, instead of `List()`.
                // You can add the type argument if you'd like, i.e. <Widget>[].
                // See https://www.dartlang.org/guides/language/effective-dart/usage#do-use-collection-literals-when-possible
                children: [ // children of Row starting from left
                  Padding(
                    padding: EdgeInsets.all(16.0),
                    child: Icon(
                      iconLocation, // where to find icon (uses darts built in icon)
                      size: 60.0, // what size is the icon
                      color: Colors.white, // changes the color of the built in icon
                    ),
                  ),
                  Center(
                    child: Text(
                      name, // uses string name to create text widget
                      textAlign: TextAlign.center, // centers text vertically relative to container
                      style: Theme.of(context).textTheme.headline,
                    ),
                  ),
                ],
              ),
            ),
          ),
        ),
      );
    }
}