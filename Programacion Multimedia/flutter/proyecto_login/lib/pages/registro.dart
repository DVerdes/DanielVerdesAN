import 'package:flutter/material.dart';
import 'package:proyecto_login/pages/inicio.dart';

class Registro extends StatelessWidget {
  String nombre = "";
  String contrasena = "";
  int telefono = 0;
 

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
                      decoration: InputDecoration(labelText: "Nombre"),
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
                      contrasena = value!;
                    },
                  ),
                  TextFormField(
                    decoration: InputDecoration(labelText: "Telefono"),
                    keyboardType: TextInputType.phone,
                    onSaved: (value) {
                      telefono = int.parse(value!);
                    },
                  ),
                 
                  Container(padding: EdgeInsets.only(top: 30), child: TextButton(onPressed: () => recogerDatos(context), child: Text("Enviar"))),
                ],
              )),
        ));
  }

  recogerDatos(BuildContext context) {
    if (formKey.currentState!.validate()) {
      formKey.currentState!.save();

      Navigator.of(context).pushNamed("/inicio", arguments: Persona(nombre, contrasena, telefono));
    }
  }
}
