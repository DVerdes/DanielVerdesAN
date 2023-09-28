import 'package:flutter/material.dart';
import 'package:listacontactos/Contacto.dart';
import 'package:listacontactos/p%C3%A1ginas/segundaPagina.dart';

void main() {
  runApp(Main());
}

class Main extends StatelessWidget{
  @override
  Widget build(BuildContext context) {

          List <Contacto> contactos = [new Contacto("Pedro", "Martínez León", "24", "678345211", "pman@gmail.com"),
          new Contacto("Marta", "García Suárez", "35", "654789666", "martagarcia@gmail.com"),
          new Contacto("Roberto", "Varela Hernández", "45", "654333555", "robervar@gmail.com"),
          new Contacto("Santiago", "Ramirez Ledesma", "23", "678345345", "santiramirez@gmail.com"),
          new Contacto("Asier", "Iraola Martín", "36", "654787898", "asierirma@gmail.com"),
          new Contacto("Vanesa", "Villares Jurado", "31", "654787976", "vanesavir@gmail.com"),
          new Contacto("Luís", "San Pedro Costas", "28", "654345234", "luissan@gmail.com"),
          new Contacto("Lucía", "Rodríguez Rojo", "32", "654789345", "luciarod@gmail.com"),
          new Contacto("Humberto", "Barcia López", "56", "642123123", "humbbar@gmail.com"),
          new Contacto("Susana", "Piñeiro Pérez", "25", "675657345", "susanapiñeiro@gmail.com")];






  
      return MaterialApp(
      title: "Proyecto 2", 
      routes: {
        "/segundaPagina": (BuildContext context) => SegundaClase(),
      },
      home: Scaffold(appBar: AppBar(title: Text("Agenda de contactos"),),
      body: ListView.builder(itemCount: contactos.length, itemBuilder: (BuildContext context, index) {
        final persona = contactos[index];
         return ListTile(
          title: Text((persona).getNombre),
          leading: Icon(Icons.person),
          onTap: () {
            mostrarSegundaV(context, persona);
          },
          
         );
      }),)
      
     
      
    );
    
  }

}

mostrarSegundaV(BuildContext context, info){
  Navigator.of(context).pushNamed("/segundaPagina", arguments: info);
}