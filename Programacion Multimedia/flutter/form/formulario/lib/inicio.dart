import 'package:flutter/material.dart';
import 'package:formulario/jugador.dart';

class Inicio extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final persona = ModalRoute.of(context)!.settings.arguments as Jugador;

    return Scaffold(
        appBar: AppBar(
          title: Text("Inicio"),
        ),
        body: Column(
          children: [
            SizedBox(height: 100),
            Text(persona.nombre_usuario + ' ' + persona.pass),
          ],
        ));
  }
}
