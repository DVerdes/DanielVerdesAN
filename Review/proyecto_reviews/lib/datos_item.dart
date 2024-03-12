// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, unnecessary_new, sized_box_for_whitespace, avoid_unnecessary_containers

import 'package:flutter/material.dart';
import 'package:insta_image_viewer/insta_image_viewer.dart';
import 'package:proyecto_reviews/lista_items.dart';

class DatosItem extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    Elemento el = ModalRoute.of(context)!.settings.arguments as Elemento;
    return Scaffold(
        appBar: AppBar(
          iconTheme: IconThemeData(color: Colors.white),
          backgroundColor: Colors.black,
          elevation: 0.0,
          title: Text(el.nombre.toUpperCase(), style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold, color: Colors.white)),
        ),
        floatingActionButton: FloatingActionButton.extended(
          onPressed: () {
            mostrarDatos(context, el.idItem);
          },
          label: Text(' Ver reseñas'),
          icon: Icon(Icons.star),
          backgroundColor: Colors.black,
          shape: LinearBorder(),
        ),
        floatingActionButtonLocation: FloatingActionButtonLocation.centerFloat,
        body: Container(
            decoration: BoxDecoration(
              image: DecorationImage(image: AssetImage("assets/bgBlack.png"), fit: BoxFit.fill),
            ),
            child: Padding(
                padding: EdgeInsets.only(top: 10),
                child: ListView(children: <Widget>[
                  InstaImageViewer(
                      child: Container(
                    height: 270,
                    width: 270,
                    child: Image.asset(el.rutaPortada),
                  )),
                  SizedBox(height: 20),
                  if (el.tipo == "pelicula")
                    tipoVentana(context, el, "Género: ", "Director: ", "Duración: ", "Año: ", "Sinopsis: ", Icon(Icons.timer_outlined, color: Colors.white), " minutos")
                  else if (el.tipo == "musica")
                    tipoVentana(context, el, "Género: ", "Artista: ", "Duración: ", "Año: ", "Album: ", Icon(Icons.timer_outlined, color: Colors.white), " minutos")
                  else if (el.tipo == "libro")
                    tipoVentana(context, el, "Género: ", "Autor: ", "Páginas: ", "Año: ", "Sinopsis: ", Icon(Icons.copy, color: Colors.white), " páginas")
                  else if (el.tipo == "juego")
                    tipoVentana(context, el, "Género: ", "Desarrolladora: ", "Duración aproximada: ", "Año: ", "Argumento: ", Icon(Icons.timer_outlined, color: Colors.white), " horas")
                  else if (el.tipo == "serie")
                    tipoVentana(context, el, "Género: ", "Director: ", "Capítulos: ", "Año: ", "Sinopsis: ", Icon(Icons.live_tv_outlined, color: Colors.white), "")
                ]))));
  }

  Widget tipoVentana(BuildContext context, Elemento e, String campo1, String campo2, String campo3, String campo4, String campo5, Icon icon3, String unidad) {
    return Container(
      padding: EdgeInsets.only(left: 5, right: 5),
      child: Card(
        color: Colors.transparent,
        elevation: 0.0,
        child: Column(
          children: [
            campo(
              Icon(Icons.theater_comedy_outlined, color: Colors.white),
              campo1,
              e.genero,
            ),
            divider(),
            campo(Icon(Icons.person_outline, color: Colors.white), campo2, e.autor),
            divider(),
            campo(icon3, campo3, e.duracion.toString() + unidad),
            divider(),
            campo(Icon(Icons.calendar_month, color: Colors.white), campo4, e.estreno.toString()),
            divider(),
            campo(Icon(Icons.text_snippet_outlined, color: Colors.white), campo5, e.sinopsis)
          ],
        ),
      ),
    );
  }

  Widget divider() {
    return Divider(
      indent: 15,
      endIndent: 15,
      color: Colors.white,
    );
  }

  Widget campo(Icon icon3, String campo, String valor) {
    return Container(
      child: ListTile(
        leading: icon3,
        title: RichText(
          text: TextSpan(
            children: <TextSpan>[
              TextSpan(
                text: campo,
                style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.white),
              ),
              TextSpan(
                text: valor,
                style: TextStyle(fontSize: 16, color: Colors.white),
              ),
            ],
          ),
        ),
      ),
    );
  }

  mostrarDatos(BuildContext context, info) {
    Navigator.of(context).pushNamed("/listaReviews", arguments: info);
  }
}
