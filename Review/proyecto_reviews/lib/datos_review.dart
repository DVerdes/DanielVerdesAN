// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, unnecessary_new, sized_box_for_whitespace, avoid_unnecessary_containers

import 'package:flutter/material.dart';
import 'package:proyecto_reviews/review.dart';

class DatosReview extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    Review review = ModalRoute.of(context)!.settings.arguments as Review;
    return Scaffold(
        appBar: AppBar(
          iconTheme: IconThemeData(color: Colors.white),
          backgroundColor: Colors.black,
          elevation: 0.0,
          title: Text("RESEÑA", style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.white)),
        ),
        body: Container(
            decoration: BoxDecoration(
              image: DecorationImage(image: AssetImage("assets/bgBlack.png"), fit: BoxFit.fill),
            ),
            child: Padding(
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
                            Icon(Icons.person_outline, color: Colors.white),
                            "Usuario:     ",
                            review.usuario,
                          ),
                          divider(),
                          campo(Icon(Icons.star, color: Colors.white), "Puntuación:     ", review.puntuacion.toString() + " / 10"),
                          divider(),
                          campo(Icon(Icons.text_snippet_outlined, color: Colors.white), "Reseña:     ", review.contenido),
                        ],
                      ),
                    ),
                  )
                ]))));
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
                style: TextStyle(color: Colors.white, fontSize: 16, fontWeight: FontWeight.bold),
              ),
              TextSpan(
                text: valor,
                style: TextStyle(color: Colors.white, fontSize: 16),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
