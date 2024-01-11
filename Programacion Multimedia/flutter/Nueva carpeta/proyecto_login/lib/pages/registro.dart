import 'package:flutter/material.dart';
import 'package:proyecto_login/pages/conexion/connectionUser.dart';
import 'package:proyecto_login/pages/inicio.dart';

class Registro extends StatefulWidget {
  State<Registro> createState() => _RegistroState();
}

class _RegistroState extends State<Registro> {
  String usuario = "";

  String contrasenha = "";

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
                      decoration: InputDecoration(labelText: "Usuario"),
                      onSaved: (value) {
                        usuario = value!;
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
                      contrasenha = value!;
                    },
                    obscureText: true,
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

  recogerDatos(BuildContext context) async {
    if (formKey.currentState!.validate()) {
      formKey.currentState!.save();

      Persona persona = new Persona(usuario, contrasenha, telefono);
      ConnectionUser connection = new ConnectionUser();
      bool comprobar = await connection.register(persona);
      if (comprobar) {
        Navigator.of(context).pushNamed("/login", arguments: Persona(usuario, contrasenha, telefono));
      }
    }
  }
}
