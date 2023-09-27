import 'package:flutter/material.dart';
import 'package:segundo_proyecto/pages/first_page.dart';
import 'package:segundo_proyecto/pages/second_page.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    
    return MaterialApp(
      title: "Proyecto 2",
      initialRoute: "/rutaPP",
      routes: {
        "/rutaPP":(BuildContext context) => PrimeraClase(),
        "/segundaPagina": (BuildContext context) => SegundaClase(),
       
      },
      
    );
  }
}



