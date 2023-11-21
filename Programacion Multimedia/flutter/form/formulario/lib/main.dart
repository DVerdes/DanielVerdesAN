import 'package:flutter/material.dart';
import 'package:formulario/inicio.dart';
import 'package:formulario/login.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Formulario',
      initialRoute: '/login',
      routes: {
        "/login": (BuildContext context) => Login(),
        "/inicio": (BuildContext context) => Inicio(),
      },
    );
  }
}
