import 'package:flutter/material.dart';
import 'package:proyecto_login/pages/conexion/connectionUser.dart';
import 'package:proyecto_login/pages/inicio.dart';

class Login extends StatefulWidget {
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  String usuario = "";

  String contrasenha = "";

  String mensajeError = "";

  final formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Login"),
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
                  SizedBox(
                    height: 50,
                  ),
                  if (mensajeError.isNotEmpty)
                    Text(
                      mensajeError,
                      style: TextStyle(color: Colors.red, fontWeight: FontWeight.bold),
                      textAlign: TextAlign.center,
                    ),
                  Container(padding: EdgeInsets.only(top: 30), child: TextButton(onPressed: () => recogerDatos(context), child: Text("Enviar"))),
                ],
              )),
        ));
  }

  recogerDatos(BuildContext context) async {
    if (formKey.currentState!.validate()) {
      formKey.currentState!.save();

      ConnectionUser con = ConnectionUser();
      Persona persona = await con.login(usuario, contrasenha);

      if (!persona.usuario.isEmpty) {
        Navigator.of(context).pushNamed("/inicio", arguments: persona);
      } else {
        setState(() {
          mensajeError = "Usuario o contraseña incorrectos.";
        });
      }
    }
  }
}
