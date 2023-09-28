import 'package:flutter/material.dart';
import 'package:listacontactos/Contacto.dart';

class SegundaClase extends StatelessWidget{
  @override
  Widget build(BuildContext context) {


      Contacto contacto = ModalRoute.of(context)!.settings.arguments as Contacto;
    
    
    return Scaffold(
      appBar: AppBar(title: Text("Contacto")),
      body: Column(
        children: [
          Row(
             children: [
             
               Container(
                // foto
                height: 500,
                width: 840,
                color: Color.fromARGB(255, 32, 106, 162),
                child: Center(child: Icon(Icons.accessibility_new_sharp, size: 300,),),
              ),
               
            ],
          ),
          Row(
             children: [
              
               Container(
                // nombre
                child: Center(child: Text(contacto.nombre + " " + contacto.apellidos, style: TextStyle(fontSize: 30)),),
                height: 120,
                width: 840,
                color: const Color.fromARGB(255, 179, 199, 215),
              ),
            ],
          ),
          Row(
            children: [
              
               Container(
                child: Center(child: Text(contacto.telefono, style: TextStyle(fontSize: 20),),),
                height: 120,
                width: 840,
                color: Color.fromARGB(255, 62, 87, 170),
              ),
            ],
          ),
          Row(
            children: [
              Container(
                child: Center(child: Text(contacto.correo, style: TextStyle(fontSize: 20),),),
                height: 120,
                width: 840,
                color: Color.fromARGB(255, 84, 102, 140),
              )
            ],
          )
        ],
      ),
      
      
    );
    
  }

}