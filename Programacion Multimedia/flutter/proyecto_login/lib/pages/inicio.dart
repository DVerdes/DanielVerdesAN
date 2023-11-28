import 'package:flutter/material.dart';

class Inicio extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final persona = ModalRoute.of(context)!.settings.arguments as Persona;

    return Scaffold(
        appBar: AppBar(
          title: Text("Inicio"),
        ),
        body: Column(
          children: [
            SizedBox(height: 100),
            Text(persona.nombre + ' ' + persona.apellidos + '\n' + persona.telefono.toString() + '\n' + persona.correo),
          ],
        ));
  }
}

class Persona {
  String nombre = "";
  String apellidos = "";
  int telefono = 0;
  String correo = "";

  Persona(String nombre, String apellidos, int telefono, String correo) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.telefono = telefono;
    this.correo = correo;
  }
}
