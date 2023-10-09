import 'package:appcorreo/pages/first_page.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Proyecto_emergentes",
      initialRoute: "/rutaPP",
      routes: {
        "/rutaPP": (BuildContext context) => PrimeraClase(),
      },
    );
  }
}
