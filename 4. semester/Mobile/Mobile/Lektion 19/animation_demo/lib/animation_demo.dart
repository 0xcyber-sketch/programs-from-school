import 'dart:math';

import 'package:flutter/material.dart';

class AnimationDemo extends StatefulWidget {
  const AnimationDemo({Key? key}) : super(key: key);

  @override
  State<AnimationDemo> createState() => _AnimationDemoState();
}

class _AnimationDemoState extends State<AnimationDemo> {
  final List<Color> colors = [
    Colors.red,
    Colors.black,
    Colors.blue,
    Colors.grey,
    Colors.blueGrey,
    Colors.yellow,
    Colors.amber,
    Colors.orange,
    Colors.purple
  ];

  final List<double> sizes = [100, 200, 30, 150, 15, 39, 73, 80, 90];
  final List<double> tops = [10, 28, 400, 150, 15, 39, 73, 33, 90];

  int colorIterarion = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Animation demo"),
        actions: [
          IconButton(
              onPressed: () {
                colorIterarion < colors.length - 1
                    ? colorIterarion++
                    : colorIterarion = 0;
                setState(() {
                  colorIterarion = colorIterarion;
                });
              },
              icon: Icon(Icons.run_circle))
        ],
      ),
      body: Center(
          child: AnimatedRotation(
        turns: colorIterarion * pi,
        duration: Duration(seconds: 1),
        child: AnimatedContainer(
          width: sizes[colorIterarion],
          height: sizes[colorIterarion],
          duration: Duration(milliseconds: 200),
          color: colors[colorIterarion],
          margin: EdgeInsets.only(top: tops[colorIterarion]),
        ),
      )),
    );
  }
}
