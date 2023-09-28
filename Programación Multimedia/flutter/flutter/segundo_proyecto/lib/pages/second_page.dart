import 'package:flutter/material.dart';
import 'package:segundo_proyecto/pages/alumno.dart';

class SegundaClase extends StatelessWidget{
  @override
  Widget build(BuildContext context) {


      Alumno alumno = ModalRoute.of(context)!.settings.arguments as Alumno;
    
    
    return Scaffold(
      appBar: AppBar(title: Text("Segunda página")),
      body: Text("Bienvenido a la segunda página " + 
      alumno.nombre+" "+ alumno.apellido),
    );
    
  }

}