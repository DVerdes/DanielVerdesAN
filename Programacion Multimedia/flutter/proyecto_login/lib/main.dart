import 'package:flutter/material.dart';
import 'package:proyecto_login/pages/inicio.dart';
import 'package:proyecto_login/pages/login.dart';

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