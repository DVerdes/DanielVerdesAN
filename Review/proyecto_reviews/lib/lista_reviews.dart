// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, unnecessary_new, sized_box_for_whitespace, avoid_unnecessary_containers, annotate_overrides, prefer_interpolation_to_compose_strings

import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:proyecto_reviews/review.dart';
import 'package:http/http.dart' as http;

class ListaReviews extends StatefulWidget {
  Reviews createState() => Reviews();
}

class Reviews extends State<ListaReviews> {
  String textBar = 'Tu correo electrónico';
// crear la listas de correos, una para cada bandeja
  String url = "";

  @override
  Widget build(BuildContext context) {
    int id = ModalRoute.of(context)!.settings.arguments as int;
    url = "http://10.0.2.2:8080/api/reviews/" + id.toString() + "/reviews";

    return Scaffold(
      appBar: AppBar(
        title: Text(textBar),
        backgroundColor: Colors.red[400],
        elevation: 0,
      ),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: () {
                        mostrarDatos(context);

        },
        label: Text(' Añadir reseña'),
        icon: Icon(Icons.add),
        backgroundColor: Colors.black87,
        shape: LinearBorder(),
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
      body: Container(
          child: FutureBuilder<dynamic>(
              future: hacerPeticion(),
              builder: (context, datos) {
                if (datos.hasData) {
                  return ListView(children: [listado(datos.data)]);
                } else if (datos.hasError) {
                  return Text(datos.error.toString());
                }
                return CircularProgressIndicator();
              })),
    );
  }

// crear widget showText
  Widget showText(dynamic tipoTexto, FontWeight weight, double size) {
    return Text(
      tipoTexto,
      style: TextStyle(fontWeight: weight, fontSize: size),
      overflow: TextOverflow.ellipsis,
    );
  }

  mostrarDatos(BuildContext context) {
    Navigator.of(context).pushNamed("/datos_review");
  }

  Future<List<Review>> hacerPeticion() async {
    Uri uri = Uri.parse(url);
    final respuesta = await http.get(uri);

    List respuestaJson = json.decode(respuesta.body.toString());
    List<Review> listaElementos = crearListaElementos(respuestaJson);
    return listaElementos;
  }

  List<Review> crearListaElementos(List respuestaJson) {
    List<Review> lista = [];
    for (int i = 0; i < respuestaJson.length; i++) {
      int idReview = respuestaJson[i]['reviewID'];
      int idItem = respuestaJson[i]['idItem'];
      int puntuacion = respuestaJson[i]['puntuacion'];
      String usuario = respuestaJson[i]['usuario'];
      String contenido = respuestaJson[i]['contenido'];

      Review datos = Review(
        idReview: idReview,
        idItem: idItem,
        puntuacion: puntuacion,
        usuario: usuario,
        contenido: contenido,
      );
      lista.add(datos);
    }
    return lista;
  }

  ListView listado(List<dynamic> listadoDatos) {
    return ListView.separated(
      padding: EdgeInsets.only(top: 10, bottom: 10),
      shrinkWrap: true,
      itemCount: listadoDatos.length,
      itemBuilder: (BuildContext context, index) {
        final review = listadoDatos[index];
        return ListTile(
            leading: Icon(Icons.person),
            // llamar al widget showText para mostrarlo
            title: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  showText(review.usuario, FontWeight.bold, 18),
                  showText(review.contenido, FontWeight.normal, 15),
                ]),
            // poner botones en cada item de la lista para poder moverlos de página o eliminarlos
            trailing: Text(review.puntuacion.toString() + "/10"),
            onTap: () {
            });
      },
      separatorBuilder: (BuildContext context, int index) {
        return Divider();
      },
    );
  }
}
