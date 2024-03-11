// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, unnecessary_new, sized_box_for_whitespace, avoid_unnecessary_containers

import 'package:flutter/material.dart';
import 'package:proyecto_reviews/review.dart';

class DatosReview extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    Review review = ModalRoute.of(context)!.settings.arguments as Review;
    return Scaffold(
        appBar: AppBar(
          iconTheme: IconThemeData(color: Colors.black),
          backgroundColor: Theme.of(context).scaffoldBackgroundColor,
          elevation: 0.0,
          title: Text("Reseña", style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold, color: Colors.black)),
        ),
        body: Padding(
            padding: EdgeInsets.only(top: 10),
            child: ListView(children: <Widget>[
              SizedBox(height: 20),
              Container(
                padding: EdgeInsets.only(left: 5, right: 5),
                child: Card(
                  color: Colors.transparent,
                  elevation: 0.0,
                  child: Column(
                    children: [
                      campo(
                        Icon(Icons.person_outline, color: Colors.black),
                        "Usuario: ",
                        review.usuario,
                      ),
                      divider(),
                      campo(Icon(Icons.star, color: Colors.black), "Puntuación: ", review.puntuacion.toString()),
                      divider(),
                      campo(Icon(Icons.text_snippet_outlined, color: Colors.black), "Reseña: ", review.contenido),
                    ],
                  ),
                ),
              )
            ])));
  }

  Widget divider() {
    return Divider(
      indent: 15,
      endIndent: 15,
      color: Colors.black,
    );
  }

  Widget campo(Icon icon, String campo, String valor) {
    return Container(
      child: ListTile(
        leading: icon,
        title: RichText(
          text: TextSpan(
            children: <TextSpan>[
              TextSpan(
                text: campo,
                style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
              ),
              TextSpan(
                text: valor,
                style: TextStyle(fontSize: 16),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
