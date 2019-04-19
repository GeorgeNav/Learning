import 'dart:html';
/*
  Commands:
    stagehand folder_name
    pub get
  Site:
    localhost:8080
*/
void main() {
  Element output = querySelector('#output');
  output.children.addAll(thingsTodo().map(newLI));
  // querySelector('#output').text = 'Your Dart app is running.';
}

LIElement newLI(String itemText) => LIElement()..text = itemText;

Iterable<String> thingsTodo() sync* {
  var actions = ['Walk', 'Wash', 'Feed'];
  var pets = ['cats', 'dogs'];

  for (var action in actions) {
    for (var pet in pets) {
      if (pet == 'cats' && action != 'Feed') continue;
      yield '$action the $pet';
    }
  }
}
