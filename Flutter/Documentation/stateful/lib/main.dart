import 'package:flutter/material.dart';
import 'package:english_words/english_words.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Stateful Widget',
      theme: ThemeData(
        primaryColor: Colors.white,
      ),
      home: RandomWords(),
    );
  }
}

class RandomWords extends StatefulWidget { // Creates an immutable instance of the widget
  // Requires at least 2 classes
  RandomWords({Key keyInput, this.title}) : super(key: keyInput);
  final String title;

  @override
  _RandomWordsState createState() => _RandomWordsState();
}

class _RandomWordsState extends State<RandomWords> { // State class persists as long as the immutable widget does
  final _suggestions = <WordPair>[];
  final _saved = Set<WordPair>(); // does not allow duplicated entries (possible to love 2 of the same WordPairs)
  final _biggerFont = const TextStyle(fontSize: 18.0);

  // State<RandomWords> = _RandomWordsState will be using State (specialized for RandomWords)
  // Inside this class is where most of the widget's logic and state resides (maintains RandomWord's state)
  // This class depends on RandomWords class
  @override
  Widget build(BuildContext context) => Scaffold(
    appBar: AppBar(
      title: Text('Startup Name Generator'),
      actions: <Widget>[
        IconButton(
          icon: const Icon(
            Icons.list,
          ),
          onPressed: _pushSaved,
        ),
      ],
    ),
    body: _buildSuggestions(),
  );

  Widget _buildSuggestions() => ListView.builder(
    padding: const EdgeInsets.all(16.0), // adds padding to all sides (left,right,top,bot)
    itemBuilder: (context, i) { // i is the amount of elements in ListView (dividers and rows)
      if(i.isOdd)
        return Divider(); // divider before each row
      final index = i ~/ 2; // counts wordpairs in ListView and ~/ makes sure division gives an int (not rounded)
      if(index >= _suggestions.length) // if reached end of avalible word pairings in _suggestions...
        _suggestions.addAll(generateWordPairs().take(10)); // generate 10 more word pairings and add to _suggestions List so scrolling can keep going infinitely
      return _buildRow(_suggestions[index]);
    },
  );

  Widget _buildRow(WordPair wordPair) {
    final bool alreadySaved = _saved.contains(wordPair);
    return ListTile(
      title: Text(
        wordPair.asPascalCase,
        style: _biggerFont,
      ),
      trailing: IconButton( // if this didn't wrap the Icon, the whole row would be clickable
        icon: Icon(
          alreadySaved ? Icons.favorite : Icons.favorite_border,
          color: alreadySaved ? Colors.red : null, 
        ),
        onPressed: () => setState(() => // setState triggers the build() method for the state object (updates UI)
          alreadySaved ? _saved.remove(wordPair) : _saved.add(wordPair)),
      ),
    );
  }

  void _pushSaved() {
    // Navigator is a stack
    Navigator.of(context).push(
      MaterialPageRoute(
        builder: (context) {
          final /* Iterable<ListTile> */ tiles = _saved.map( // creates a Map of ListTiles from _saved TODO: explain to where
            (WordPair pair) => ListTile(
              title: Text(
                pair.asPascalCase,
                style: _biggerFont,
              ),
            ),
          );
          final /* List<Widget> */ divided = ListTile.divideTiles(
            context: context,
            tiles: tiles,            
          ).toList();
          return Scaffold(
            appBar: AppBar(
              title: Text('Loved Suggestions'),
            ),
            body: ListView(
              children: divided, // takes in an array of widgets
            ),
          );
        },
      ),
    );
  }
}
