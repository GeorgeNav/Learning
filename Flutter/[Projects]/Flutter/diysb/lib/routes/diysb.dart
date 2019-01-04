import 'dart:io';
import 'dart:async';
import 'package:path_provider/path_provider.dart';
import 'package:flutter/services.dart' show rootBundle;
import 'package:flutter/material.dart';
import 'package:audioplayer/audioplayer.dart';

class DIYSB extends StatelessWidget {
  @override
  Widget build(BuildContext context) => Scaffold(
    appBar: AppBar(
      title: Text('DIYSB'),
      centerTitle: true,
      // TODO: add action for uploading files to database
    ),
    body: GridView(
      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: 4,
      ),
      children: _buildSoundboard(),
    ),
    backgroundColor: Colors.blueGrey,
  );

  _buildSoundboard() {
    _getFiles(<String>['What.mp3']);
    var soundBoard = <Widget>[
      GridCell('https://firebasestorage.googleapis.com/v0/b/diysb-2403c.appspot.com/o/Audio%2FKripparian%2FWhat.mp3?alt=media&token=48bda24a-c2c4-4b27-89fd-4ab8ac646ed7'),
      GridCell('https://firebasestorage.googleapis.com/v0/b/diysb-2403c.appspot.com/o/Audio%2FKripparian%2FAirhorn.mp3?alt=media&token=f062297c-7417-49fb-9534-0dabe72c72ce'),
    ];
    return soundBoard;
  }

  _getFiles(List<String> sounds) async {
    final localDir = await getApplicationDocumentsDirectory();
    final localAssetFile = File('${localDir.path}/${sounds[0]}');
    final fileExists = await localAssetFile.exists();
    if(fileExists)
      localAssetFile.delete();
    final data = await rootBundle.load('assets/${sounds[0]}');
    final bytes = data.buffer.asUint8List();
    await localAssetFile.writeAsBytes(bytes, flush: true);
  }
}

class GridCell extends StatefulWidget {
  GridCell(this.url, {Key key}) : super(key: key);
  final String url;

  _GridCellState createState() => _GridCellState();
}

class _GridCellState extends State<GridCell> {
  AudioPlayer audioPlugin = AudioPlayer();

  @override
  Widget build(BuildContext context) => Card(
    color: Colors.black,
    child: Container(
      margin: EdgeInsets.all(8),
      child: RaisedButton(
        color: Colors.red,
        onPressed: () {
          audioPlugin.play(widget.url);
        },
        child: Text('Test'),
      ),
    ),
  );
}