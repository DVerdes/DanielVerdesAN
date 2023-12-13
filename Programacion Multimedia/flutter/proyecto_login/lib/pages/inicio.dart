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
            Text(persona.nombre + ' ' + persona.contrasena + '\n' + persona.telefono.toString() + '\n' ),
          ],
        ));
  }
}

class Persona {
  String nombre = "";
  String contrasena = "";
  int telefono = 0;

  Persona(String nombre, String contrasena, int telefono) {
    this.nombre = nombre;
    this.contrasena = contrasena;
    this.telefono = telefono;
  }
}

class Usuario {
  String usuario = "";
 String contrasena = "";

  Usuario(String usuario, String contrasena) {
    this.usuario = usuario;
    this.contrasena = contrasena;
  
  }
}
