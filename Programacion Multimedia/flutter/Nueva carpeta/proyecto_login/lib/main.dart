import 'package:flutter/material.dart';
import 'package:proyecto_login/pages/inicio.dart';
import 'package:proyecto_login/pages/login.dart';
import 'package:proyecto_login/pages/registro.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Formulario',
      initialRoute: '/registro',
      routes: {
        "/registro": (BuildContext context) => Registro(),
        "/login": (BuildContext context) => Login(),
        "/inicio": (BuildContext context) => Inicio(),
      },
    );
  }
}
