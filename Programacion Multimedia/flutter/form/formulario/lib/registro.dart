import 'package:flutter/material.dart';
import 'package:formulario/login.dart';

import 'jugador.dart';

class Registro extends StatelessWidget {
  @override
  String nombre = "";
  String pass = "";

  final formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Registro"),
        ),
        body: Center(
          child: Form(
              key: formKey,
              child: Column(
                children: [
                  TextFormField(
                      decoration: InputDecoration(labelText: "Nombre Usuario"),
                      onSaved: (value) {
                        nombre = value!;
                      },
                      validator: (value) {
                        if (value!.isEmpty) {
                          return "ERROR: Campo vacío";
                        }

                        if (value!.length < 3) {
                          return "Campo no válido";
                        }
                      }),
                  TextFormField(
                    decoration: InputDecoration(labelText: "Contraseña"),
                    onSaved: (value) {
                      pass = value!;
                    },
                  ),
                  Container(
                      padding: EdgeInsets.only(top: 30),
                      child: TextButton(
                          onPressed: () => recogerDatos(context),
                          child: Text("Registrarse"))),
                  Container(
                      padding: EdgeInsets.only(top: 30),
                      child: TextButton(
                          onPressed: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => Login()),
                            );
                          },
                          child: Text("Atrás")))
                ],
              )),
        ));
  }

  recogerDatos(BuildContext context) {
    if (formKey.currentState!.validate()) {
      formKey.currentState!.save();

      Navigator.of(context)
          .pushNamed("/login", arguments: Jugador(nombre, pass));
    }
  }
}
