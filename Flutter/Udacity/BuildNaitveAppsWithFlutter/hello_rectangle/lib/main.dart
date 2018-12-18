// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'package:flutter/material.dart';

class HelloRectangle extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Container(
        color: Colors.greenAccent,
        height: 400,
        width: 300,
        child: Center(
          child: Text(
            'Hello!',
            style: TextStyle(fontSize: 40),
          ),
        ),
      ),
    );
  }
}

void main() {
  runApp(
    MaterialApp( // title, home, theme, text directionality, back button press action, remove slow mode banner, etc
      debugShowCheckedModeBanner: false,
      home: Scaffold( // drawers, app bars, bottom navigation, tabs, floating action buttons
        appBar: AppBar(
          title: Text('Hello Rectangle'),
        ),
        body: HelloRectangle(),
      ),
    ),
  );
}
