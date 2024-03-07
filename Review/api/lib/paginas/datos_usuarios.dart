import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class DatosUsuarios extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: MostrarUsuarios());
  }
}

class MostrarUsuarios extends StatefulWidget {
  @override
  DatosUsuariosAPI createState() => DatosUsuariosAPI();
}

class DatosUsuariosAPI extends State<MostrarUsuarios> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text("Listado API")),
        body: Container(
            child: FutureBuilder<dynamic>(
          future: hacerPeticion(),
          builder: (context, datos) {
            if (datos.hasData) {
              return Column(
                children: [
                  Card(child: ListTile(leading: Icon(Icons.person), title: Text(datos.data.userId.toString() + ", " + datos.data.id.toString() + ", " + datos.data.title + ", " + datos.data.body)))
                ],
              );
            } else if (datos.hasError) {
              return Text(datos.error.toString());
            }
            return CircularProgressIndicator();
          },
        )));
  }

  String url = "https://jsonplaceholder.typicode.com/posts/1";
  Future<Usuario> hacerPeticion() async {
    Uri uri = Uri.parse(url);
    final respuesta = await http.get(uri);

    Map<String, dynamic> respuestaJson = json.decode(respuesta.body.toString());
    Usuario usuario = Usuario(userId: respuestaJson['userId'], id: respuestaJson['id'], title: respuestaJson['title'], body: respuestaJson['body']);
    return usuario;
  }
}

class Usuario {
  int userId;
  int id;
  String title;
  String body;

  Usuario({required this.userId, required this.id, required this.title, required this.body});
}
