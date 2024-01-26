import 'package:flutter/material.dart';
import 'package:pazaak/partidaUtils.dart';
import 'package:pazaak/pazaak.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    PartidaUtils.repartirManos();
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: "Pazaak",
      initialRoute: "/pazaak",
      routes: {
        "/pazaak": (BuildContext context) => JuegoPazaak(),
      },
    );
  }
}
