import 'package:flutter/material.dart';
import 'package:proyecto_login/pages/conexion/conectionUser.dart';
import 'package:proyecto_login/pages/inicio.dart';

class Login extends StatelessWidget {
  String usuario = "";
  String contrasena = "";
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
                      contrasena = value!;
                    },
                  ),
                  Row(
                    children: [
                      Container(padding: EdgeInsets.only(top: 30), child: TextButton(onPressed: () => recogerDatos(context), child: Text("Enviar"))),
                      Container(padding: EdgeInsets.only(top: 30), child: TextButton(onPressed: () => irRegistro(context), child: Text("Registro"))),

                    ],
                  ),
                ],
              )),
        ));
  }

  recogerDatos(BuildContext context) async{
    if (formKey.currentState!.validate()) {
      formKey.currentState!.save();

      ConectionUser con = ConectionUser();
      Persona persona = await con.login(usuario, contrasena);

      if(persona.nombre!=''){
          Navigator.of(context).pushNamed("/inicio", arguments: persona);

      }

    }
  }

  irRegistro(BuildContext context){
       if (formKey.currentState!.validate()) {
      formKey.currentState!.save();

      Navigator.of(context).pushNamed("/registro", arguments: Usuario(usuario, contrasena));
    }


  }
}
