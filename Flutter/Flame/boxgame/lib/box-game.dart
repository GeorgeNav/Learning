import 'dart:ui';
import 'package:flame/game.dart';
import 'package:flutter/gestures.dart';

class BoxGame extends Game {
  Size screenSize; // initialized to null
  bool hasWon = false;

  @override
  void render(Canvas canvas) {
    // Draws a black background on the whole screen
    Rect bgRect = Rect.fromLTRB(0, 0, screenSize.width, screenSize.height);
    Paint bgPaint = Paint();
    bgPaint.color = Color(0xff000000);
    canvas.drawRect(bgRect, bgPaint);

    // Draws a box (turns green if won, white otherwise)
    double screenCenterX = screenSize.width / 2;
    double screenCenterY = screenSize.height / 2;
    Rect boxRect = Rect.fromLTWH(
      screenCenterX - 75,
      screenCenterY - 75,
      150,
      150      
    );
    Paint boxPaint = Paint();
    boxPaint.color = hasWon ? Color(0xffff0000) : Color(0xffffffff);
    canvas.drawRect(boxRect, boxPaint);
}

  @override
  void update(double t) {
    // TODO: implement update

  }

  @override
  void resize(Size size) {
    screenSize = size;
    super.resize(size);
  }

  void onTapDown(TapDownDetails d) { // handle taps
  double screenCenterX = screenSize.width / 2;
  double screenCenterY = screenSize.height / 2;
  print("dx: " + d.globalPosition.dx.toString());
  print("dy: " + d.globalPosition.dy.toString());
  print("width: " + screenSize.width.toString());
  print("height: " + screenSize.height.toString());
  print(d.globalPosition.dy);
    if( d.globalPosition.dx >= screenCenterX - 75 &&
        d.globalPosition.dx <= screenCenterX + 75 &&
        d.globalPosition.dy >= screenCenterY - 75 &&
        d.globalPosition.dy <= screenCenterY + 75) {
      print('You won!');
      hasWon = hasWon ? false : true;
    }
  }
}