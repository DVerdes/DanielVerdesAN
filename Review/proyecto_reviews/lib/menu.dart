import 'package:flutter/material.dart';
import 'package:proyecto_reviews/lista_itemsAPI.dart';

class MenuPrincipal extends StatefulWidget {
  State<MenuPrincipal> createState() => Menu();
}

class Menu extends State<MenuPrincipal> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Menú"),
        ),
        body: ListView.builder(
            physics: NeverScrollableScrollPhysics(),
            padding: EdgeInsets.only(top: 10),
            // itemExtent: 72.0,
            shrinkWrap: true,
            itemCount: 1,
            itemBuilder: (BuildContext context, index) {
              return Column(children: [
                // Image.asset(
                //   "assets/icons/dibu.png"
                // ),
                Card(child: ListTile(title: Text("Peliculas", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold)), onTap: () => mostrarDatos(context, "pelicula"))),
                Card(child: ListTile(title: Text("Libros", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold)), onTap: () => mostrarDatos(context, "libro"))),
                Card(child: ListTile(title: Text("Musica", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold)), onTap: () => mostrarDatos(context, "musica"))),
                Card(child: ListTile(title: Text("Juegos", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold)), onTap: () => mostrarDatos(context, "juego"))),
                Card(child: ListTile(title: Text("Series", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold)), onTap: () => mostrarDatos(context, "serie"))),
              ]);
            }));
  }

  mostrarInfo(BuildContext context, String info, String contenido) {
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Text(info),
            content: Text(contenido),
            actions: [
              TextButton(
                  onPressed: () {
                    Navigator.pop(context);
                  },
                  child: Text("OK")),
            ],
          );
        });
  }

  mostrarDatos(BuildContext context, info) {
    Navigator.of(context).pushNamed("/listaItems", arguments: info);
  }
}
