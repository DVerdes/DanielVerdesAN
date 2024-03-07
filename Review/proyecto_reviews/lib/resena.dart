


// ignore_for_file: prefer_const_constructors, camel_case_types, use_key_in_widget_constructors

import 'package:flutter/material.dart';

class Resena extends StatefulWidget{
  @override
  State<StatefulWidget> createState() => mostrarDrawer();
}


class mostrarDrawer extends State<Resena>{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Reseñas"),),
       body: ListView.builder(
        itemCount: 10,
        itemBuilder: (context, index){
          return ListTile(
            leading: Icon(Icons.verified_user), // Icono para representar el mensaje
            title: Text('Mensaje $index'), // Título del mensaje
            subtitle: Text('Contenido del mensaje $index'),
            onTap: (){
              
            },
          );
        }
       )
      );
  }
}



