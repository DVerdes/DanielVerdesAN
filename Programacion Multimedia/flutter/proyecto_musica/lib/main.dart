import 'package:audioplayers/audioplayers.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Sonido',
      home: Sonido(),
    );
  }
}

class Sonido extends StatefulWidget {
  @override
  State<Sonido> createState() => _MyAppState();
}

class _MyAppState extends State<Sonido> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Sonidos')),
      body: Container(
          child: Stack(
        children: [
          Padding(
              padding: EdgeInsets.only(left: 30),
              child: IconButton(
                icon: Icon(Icons.volume_up),
                onPressed: () => playMusic('a.mp3'),
              )),
          Padding(
              padding: EdgeInsets.only(left: 160),
              child: IconButton(
                icon: Icon(Icons.pause),
                onPressed: () => player.pause(),
              )),
          Padding(
              padding: EdgeInsets.only(left: 290),
              child: IconButton(
                icon: Icon(Icons.stop),
                onPressed: () => player.stop(),
              )),
          Padding(
              padding: EdgeInsets.only(left: 420),
              child: IconButton(
                icon: Icon(Icons.play_arrow),
                onPressed: () => playMusic('b.mp3'),
              )),
        ],
      )),
    );
  }

  AudioPlayer player = AudioPlayer();

  playMusic(String ruta) {
    player.play(AssetSource(ruta));
  }
}
