// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, unnecessary_new, sized_box_for_whitespace, avoid_unnecessary_containers, annotate_overrides, prefer_interpolation_to_compose_strings

import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class ListaItems extends StatefulWidget {
  State<ListaItems> createState() => Items();
}

class Items extends State<ListaItems> {
  String url = "";

  @override
  Widget build(BuildContext context) {
    String tipoItem = ModalRoute.of(context)!.settings.arguments as String;

    url = "http://10.0.2.2:8080/api/items/" + tipoItem + "s";
    return Scaffold(
      appBar: AppBar(
        iconTheme: IconThemeData(color: Colors.white),
        backgroundColor: Colors.black,
        elevation: 0.0,
        title: Text((tipoItem + "s").toUpperCase(), style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.white)),
      ),
      body: Stack(children: [
        Container(
          decoration: BoxDecoration(
            image: DecorationImage(image: AssetImage("assets/bgBlack.png"), fit: BoxFit.fill),
          ),
        ),
        FutureBuilder<dynamic>(
            future: hacerPeticion(),
            builder: (context, datos) {
              if (datos.hasData) {
                return ListView(children: [listado(datos.data)]);
              } else if (datos.hasError) {
                return Text(datos.error.toString());
              }
              return CircularProgressIndicator();
            })
      ]),
    );
  }

  mostrarDatos(BuildContext context, info) {
    Navigator.of(context).pushNamed("/listaItems", arguments: info);
  }

  mostrarDatosItem(BuildContext context, info) {
    Navigator.of(context).pushNamed("/datos_item", arguments: info);
  }

  Future<List<Elemento>> hacerPeticion() async {
    Uri uri = Uri.parse(url);
    final respuesta = await http.get(uri);

    List respuestaJson = json.decode(Utf8Decoder().convert(respuesta.bodyBytes).toString());

    List<Elemento> listaElementos = crearListaElementos(respuestaJson);
    return listaElementos;
  }

  List<Elemento> crearListaElementos(List respuestaJson) {
    List<Elemento> lista = [];
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
            title: Text(item.nombre, style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.white)),
            trailing: Text(item.puntuacionMedia.toStringAsFixed(1) + " / 10", style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold, color: Colors.white)),
            onTap: () {
              mostrarDatosItem(context, item);
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
      required this.puntuacionMedia});
}
