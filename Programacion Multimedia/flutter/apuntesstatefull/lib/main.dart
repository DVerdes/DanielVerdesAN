import 'package:flutter/material.dart';

void main() {
  runApp(ClaseEstado());
}

class ClaseEstado extends StatefulWidget{


  @override
  State<StatefulWidget> createState() => Contenido2();
   
  


}

class Contenido extends State<ClaseEstado>{

  String nombre = "Nelson";
  double contador = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Primer Proyecto StateFull",
      home: Scaffold(
        appBar: AppBar(
          title: Text("Datos variables"),
        ),
        body: Center(
          child: Column(
            children: [
              Text(nombre),
              LinearProgressIndicator(
                value: contador,
              )
            ],
          ),
        ),
        floatingActionButton: FloatingActionButton(child: Icon(Icons.abc_rounded), onPressed: (){

          setState(() {
            if(nombre=="Nelson"){
            nombre="Dani";
          }else{
            nombre = "Nelson";
          }

          contador+= 0.01;
          });
          

        }),
      ),
    );
  }

}

class Contenido2 extends State<ClaseEstado>{

  bool bombilla = false;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Estado bombilla",
      home: Scaffold(appBar: AppBar(title: Text("Bombilla"),),
      body: Column(children: [
        Padding(
          padding: const EdgeInsets.all(8.0),
          child: Icon(Icons.lightbulb_outline, size: 60, color: bombilla ? Colors.yellow:Colors.black),
        ), 
        GestureDetector(
          onTap: (){

            setState(() {
                          bombilla = !bombilla;

            });
          }
          ,child: Container(child: Text(bombilla ? "Apagar":"Encender"),))
      ]),),
    );
   
  }


}

