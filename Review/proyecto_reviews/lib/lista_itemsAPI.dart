// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, unnecessary_new, sized_box_for_whitespace, avoid_unnecessary_containers, annotate_overrides, prefer_interpolation_to_compose_strings

import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:proyecto_reviews/item.dart';
import 'package:http/http.dart' as http;
import 'package:proyecto_reviews/review.dart';

class ListaItems extends StatefulWidget {
  State<ListaItems> createState() => Items();
}

class Items extends State<ListaItems> {
  // List<Item> listaItems = [
  // Item(
  //     1,
  //     "pelicula",
  //     "Avatar",
  //     "Ciencia Ficción",
  //     "James Cameron",
  //     "150",
  //     "assets/icons/avatar.png",
  //     2021,
  //     "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
  //     2),
  // Item(
  //     2,
  //     "libro",
  //     "Harry Potter",
  //     "Fantasía",
  //     "JK Rowling",
  //     "362",
  //     "assets/icons/hp.png",
  //     1997,
  //     "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
  //     3),
  // Item(
  //     3,
  //     "juego",
  //     "FIFA 23",
  //     "Deportes",
  //     "Electronic Arts",
  //     "∞",
  //     "assets/icons/fifa.png",
  //     2022,
  //     "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
  //     3),
  // ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Lista"),
        ),
        body: Container(
            child: FutureBuilder<dynamic>(
                future: hacerPeticion(),
                builder: (context, datos) {
                  if (datos.hasData) {
                    return ListView(children:[ listado(datos.data)]);
                  } else if (datos.hasError) {
                    return Text(datos.error.toString());
                  }
                  return CircularProgressIndicator();
                })));
  }

  mostrarDatos(BuildContext context, info) {
    Navigator.of(context).pushNamed("/datos_item", arguments: info);
  }

    String url = "http://10.0.2.2:8080/api/items/peliculas";

  Future<List<Elemento>> hacerPeticion() async {
    Uri uri = Uri.parse(url);
    final respuesta = await http.get(uri);

    List respuestaJson = json.decode(respuesta.body.toString());
    List<Elemento> listaElementos = crearListaElementos(respuestaJson);
    return listaElementos;
  }

  List<Elemento> crearListaElementos(List respuestaJson) {
    List<Elemento> lista = [];
    List<Review> listaRev = [];
    for (int i = 0; i < respuestaJson.length; i++) {
      int idItem = respuestaJson[i]['idItem'];
      String tipo = respuestaJson[i]['tipo'];
      String nombre = respuestaJson[i]['nombre'];
      String genero = respuestaJson[i]['genero'];
      String autor = respuestaJson[i]['autor'];
      int duracion = respuestaJson[i]['duracion'];
      String rutaPortada = respuestaJson[i]['rutaPortada'];
      int estreno = respuestaJson[i]['estreno'];
      String sinopsis = respuestaJson[i]['sinopsis'];
       List<dynamic> lista2 = respuestaJson[i]['reviewList'];
      int reviewId = 0;
      int itemID = 0;
      String usuario = "";
      int puntuacion= 0;
      String contenido = "";
      for(int j = 0; j< lista2.length; j++){
          reviewId = lista2[j]['reviewID'];
          itemID = lista2[j]['idItem'];
          usuario = lista2[j]['usuario'];
          puntuacion = lista2[j]['puntuacion'];
          contenido = lista2[j]['contenido'];
          listaRev.add(new Review(puntuacion, usuario, contenido));
      }
      double puntuacionMedia = respuestaJson[i]['puntuacionMedia'];

      Elemento datos = Elemento(
          idItem: idItem,
          tipo: tipo,
          nombre: nombre,
          genero: genero,
          autor: autor,
          duracion: duracion,
          rutaPortada: rutaPortada,
          estreno: estreno,
          sinopsis: sinopsis,
          reviews: listaRev,
          puntuacionMedia: puntuacionMedia);
      lista.add(datos);
    }
    return lista;
  }

  ListView listado(List<dynamic> listadoDatos) {
    return ListView.builder(
        physics: NeverScrollableScrollPhysics(),
        padding: EdgeInsets.only(top: 10),
        itemExtent: 72.0,
        shrinkWrap: true,
        itemCount: listadoDatos.length,
        itemBuilder: (BuildContext context, index) {
          final item = listadoDatos[index];
          return ListTile(
            title: Text(item.nombre),
            leading: Text(item.puntuacionMedia.toString() + "/5"),
            onTap: () {
              mostrarDatos(context, item);
            },
          );
        });
  }
}

class Elemento {
  int idItem = 0;
  String tipo = "";
  String nombre = "";
  String genero = "";
  String autor = "";
  int duracion = 0;
  String rutaPortada = "";
  int estreno = 0;
  String sinopsis = "";
  List<Review> reviews = List.empty();
  double puntuacionMedia = 0.0;

  Elemento(
      {required this.idItem,
      required this.tipo,
      required this.nombre,
      required this.genero,
      required this.autor,
      required this.duracion,
      required this.rutaPortada,
      required this.estreno,
      required this.sinopsis,
      required this.reviews,
      required this.puntuacionMedia});
}
