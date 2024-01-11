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
            Text(persona.usuario + ' ' + persona.contrasenha + '\n' + persona.telefono.toString() + '\n'),
          ],
        ));
  }
}

class Persona {
  String usuario = "";
  String contrasenha = "";
  int telefono = 0;

  Persona(String usuario, String contrasenha, int telefono) {
    this.usuario = usuario;
    this.contrasenha = contrasenha;
    this.telefono = telefono;
  }
}
