import 'package:flutter/material.dart';
import 'package:proyecto_reviews/datos_review.dart';
import 'package:proyecto_reviews/lista_items.dart';
import 'package:proyecto_reviews/lista_itemsAPI.dart';
import 'package:proyecto_reviews/datos_item.dart';
import 'package:proyecto_reviews/lista_reviews.dart';
import 'package:proyecto_reviews/menu.dart';
import 'package:proyecto_reviews/resena.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(title: 'Reviews', debugShowCheckedModeBanner: false, initialRoute: "/listaMenu", routes: {
      "/listaMenu": (BuildContext context) => MenuPrincipal(),
      "/listaItems": (BuildContext context) => ListaItems(),
      "/datos_item": (BuildContext context) => DatosItem(),
      "/listaReviews": (BuildContext context) => ListaReviews(),
      "/datos_review": (BuildContext context) => DatosReview()
    });
  }
}
