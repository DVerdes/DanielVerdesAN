// ignore_for_file: use_key_in_widget_constructors
// ctr + shift + r para ENVOLVER


import 'package:flutter/material.dart';

void main() {
  runApp(Dam_gridView());
}

/*
class Dam extends StatelessWidget{
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: "Margenes externo e interno",
      home: Scaffold(appBar: AppBar(
        title: Text("Margen y padding") ,
      ),
      body: Container(
        width: 500,
        height: 500,
        // color en hexadecimal + opacidad
        color: Color(0xff944433).withOpacity(0.3),
        // margen, izquierdo y superior
        margin: EdgeInsets.only(left: 10, top:20),
        // padding, (margen interno) por todos lados
        padding: EdgeInsets.all(20),
        child: Text("Hola mundo", style: TextStyle(backgroundColor: Colors.black, fontSize: 30, color: Colors.white),
      ),
      )
    )
    );

  }

}    
*/


/*

class Dam_listView extends StatelessWidget{
  Widget build(BuildContext context){
    
    List <String> alumnos = ['Simon','Manuel','Dani','Carlos','Angel','Roi','Sara','Alejandro','Martin','Dario','Alex','Daniel','Daniel','Vinicius','Matías'];
    String nombrePersona = "";
    int contador = 0;


    return MaterialApp(
      title: "Lista",
      home: Scaffold(appBar: AppBar(title: Text("ListView"),
      ),
      body: ListView.builder(itemCount: alumnos.length ,itemBuilder: (BuildContext context, index) {
        final nombre = alumnos[index];
        return ListTile(
          title: Text(nombre),
          leading: Icon(Icons.person),
          onTap: () {
            print(nombre); 
            
            // ejercicio
            if(contador == 0){
              contador ++;
              nombrePersona = nombre;
            }else if(contador > 0 && nombre == nombrePersona){
              contador++;
              if(contador==3){
               print("Has pulsado "+nombre+" 3 veces");
               contador = 0;
              }
            }else if(nombre!=nombrePersona){
              nombrePersona = nombre;
              contador = 1;
            }




          },
        );
        
      })),
      
    );

  }

}

*/

/*
class Dam_grid extends StatelessWidget{
  Widget build(BuildContext context){

    return MaterialApp(
      title: "ListView",
      home: Scaffold(appBar: AppBar(title: Text("Contiunamos con ListView"),),body: ListView(children: [
        Card(
          child: ListTile(
            leading: FlutterLogo(),
            title: Text("Texto 1"),
          ),
        ),
        Card(
          child: ListTile(
            title: Text("Texto 3"),
            trailing: Icon(Icons.more_vert),
          ),
        ),
        Card(
          child: ListTile(
            leading: FlutterLogo(),
            title: Text("Texto 4"),
            trailing: Icon(Icons.account_balance_wallet),
            onTap: (){
              print("4");
            },
          ),
        ),
        Card(
          child: ListTile(
            leading: FlutterLogo(size: 60, ),
            title: Text("Texto5"),
            subtitle: Text("Subtitulo"),
          ),
        )
      ]),),

    );

  }
}
*/

class Dam_gridView extends StatelessWidget{
  Widget build(BuildContext context){
    return MaterialApp(
      title: "GridView",
      home: Scaffold(appBar: AppBar(title: Text("Uso de gridView")),
      body: GridView.count(crossAxisCount: 3,
      mainAxisSpacing: 10,
      crossAxisSpacing: 10,
      padding: EdgeInsets.all(10),
      children: [
        Container(
          child: Text("Primer contenedor"), color: Colors.blue[100], padding: EdgeInsets.all(8),
        ),
        Container(
          child: Center(child: Text("Segundo contenedor")), color: Colors.blue[400], padding: EdgeInsets.all(8),
        ),
         Container(
          child: Text("Tercer contenedor"), color: Colors.blue[700], padding: EdgeInsets.all(8),
        ),
         Container(
          child: Text("Cuarto contenedor"), color: Colors.blue[500], padding: EdgeInsets.all(8),
        ),
         Container(
          child: Text("Quinto contenedor"), color: Colors.blue[900], padding: EdgeInsets.all(8),
        ),
         Container(
          child: Text("Sexto contenedor"), color: Colors.blue[200], padding: EdgeInsets.all(8),
        )
      ],),)
    );
  }
}