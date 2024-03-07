// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, unnecessary_new, sized_box_for_whitespace, avoid_unnecessary_containers, annotate_overrides, prefer_interpolation_to_compose_strings

import 'package:flutter/material.dart';
import 'package:proyecto_reviews/review.dart';

class ListaReviews extends StatefulWidget {
  Reviews createState() => Reviews();
}

class Reviews extends State<ListaReviews> {
  String textBar = 'Tu correo electrónico';
// crear la listas de correos, una para cada bandeja
  List<Review> listaReviews = [
    Review(3, "caco97", "muy cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccbueno"),
    Review(5, "daniverdes", "top"),
    Review(1, "manucarro97", "horrible"),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(textBar),
        backgroundColor: Colors.red[400],
        elevation: 0,
      ),
      floatingActionButton: FloatingActionButton.extended(
        onPressed: () {},
        label: Text(' Añadir reseña'),
        icon: Icon(Icons.add),
        backgroundColor: Colors.black87,
        shape: LinearBorder(),
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
      body: ListView.separated(
        padding: EdgeInsets.only(top: 10, bottom: 10),
        shrinkWrap: true,
        itemCount: listaReviews.length,
        itemBuilder: (BuildContext context, index) {
          final review = listaReviews[index];
          return ListTile(
              leading: Icon(Icons.person),
// llamar al widget showText para mostrarlo
              title: Column(crossAxisAlignment: CrossAxisAlignment.start, children: <Widget>[
                showText(review.usuario, FontWeight.bold, 18),
                showText(review.contenido, FontWeight.normal, 15),
              ]),
// poner botones en cada item de la lista para poder moverlos de página o eliminarlos
              trailing: Text(review.puntuacion.toString() + "/10"),
              onTap: () {
                mostrarDatos(context, review);
              });
        },
        separatorBuilder: (BuildContext context, int index) {
          return Divider();
        },
      ),
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

  mostrarDatos(BuildContext context, info) {
    Navigator.of(context).pushNamed("/datos_review", arguments: info);
  }
}
