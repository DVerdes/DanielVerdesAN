// ignore_for_file: use_key_in_widget_constructors, must_be_immutable

import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class OtrosDatos extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text("Datos otros uaurios")),
        body: Container(
          child: FutureBuilder<dynamic>(
              future: recogerDatos(),
              builder: (context, datos) {
                if (datos.hasData) {
                  return ListView(
                    children: listado(datos.data),
                  );
                } else if (datos.hasError) {
                  return Text(datos.error.toString());
                }
                return CircularProgressIndicator();
              }),
        ));
  }

  String url = "https://api.github.com/users";
  Future<List<Datos>> recogerDatos() async {
    Uri uri = Uri.parse(url);
    final respuesta = await http.get(uri);
    List respuestaJson = json.decode(respuesta.body.toString());
    List<Datos> listaDatos = crearListaDatos(respuestaJson);
    return listaDatos;
  }

  List<Datos> crearListaDatos(List respuestaJson) {
    List<Datos> lista = [];
    for (int i = 0; i < respuestaJson.length; i++) {
      String nombre = respuestaJson[i]['login'];
      int id = respuestaJson[i]['id'];
      String img = respuestaJson[i]['avatar_url'];

      Datos datos = Datos(nombre: nombre, id: id, img: img);
      lista.add(datos);
    }
    return lista;
  }

  List<Widget> listado(List<dynamic> listadoDatos) {
    List<Widget> lista = [];
    listadoDatos.forEach((elemento) {
      lista.add(Card(
          shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(30)),
          margin: EdgeInsets.all(15),
          elevation: 10,
          child: ClipRRect(
              borderRadius: BorderRadius.circular(30),
              child: Column(
                children: [Image(image: NetworkImage(elemento.img), height: 150), Container(padding: EdgeInsets.all(10), child: Text(elemento.nombre + ", " + elemento.id.toString()))],
              ))));
    });
    return lista;
  }
}

class Datos {
  String nombre;
  int id;
  String img;

  Datos({required this.nombre, required this.id, required this.img});
}
