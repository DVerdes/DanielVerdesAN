import 'package:flutter/material.dart';

class MenuPrincipal extends StatefulWidget {
  State<MenuPrincipal> createState() => Menu();
}

class Menu extends State<MenuPrincipal> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Bienvenido, ¿qué quieres consultar?"),
          backgroundColor: Colors.black,
        ),
        body: Container(
            decoration: BoxDecoration(
              image: DecorationImage(image: AssetImage("assets/bgBlack.png"), fit: BoxFit.fill),
            ),
            child: ListView.builder(
                physics: NeverScrollableScrollPhysics(),
                padding: EdgeInsets.only(top: 10),
                itemCount: 1,
                itemBuilder: (BuildContext context, index) {
                  return Column(children: [
                    Card(
                        color: Colors.transparent,
                        child: ListTile(
                          tileColor: Colors.transparent,
                          title: Text("Peliculas", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)),
                          onTap: () => mostrarDatos(context, "pelicula"),
                          trailing: Icon(Icons.movie_creation, color: Colors.white),
                        )),
                    divider(),
                    Card(
                        color: Colors.transparent,
                        child: ListTile(
                          tileColor: Colors.transparent,
                          title: Text("Libros", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)),
                          onTap: () => mostrarDatos(context, "libro"),
                          trailing: Icon(Icons.menu_book_outlined, color: Colors.white),
                        )),
                    divider(),
                    Card(
                        color: Colors.transparent,
                        child: ListTile(
                          tileColor: Colors.transparent,
                          title: Text("Musica", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)),
                          onTap: () => mostrarDatos(context, "musica"),
                          trailing: Icon(Icons.music_note, color: Colors.white),
                        )),
                    divider(),
                    Card(
                        color: Colors.transparent,
                        child: ListTile(
                          tileColor: Colors.transparent,
                          title: Text("Juegos", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)),
                          onTap: () => mostrarDatos(context, "juego"),
                          trailing: Icon(Icons.gamepad, color: Colors.white),
                        )),
                    divider(),
                    Card(
                        color: Colors.transparent,
                        child: ListTile(
                          tileColor: Colors.transparent,
                          title: Text("Series", style: TextStyle(fontFamily: 'JetBrains', fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white)),
                          onTap: () => mostrarDatos(context, "serie"),
                          trailing: Icon(Icons.tv, color: Colors.white),
                        )),
                  ]);
                })));
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

  Widget divider() {
    return Divider(
      thickness: 1,
      indent: 15,
      endIndent: 15,
      color: Colors.white,
    );
  }
}
