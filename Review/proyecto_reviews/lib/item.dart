// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, unnecessary_new, sized_box_for_whitespace, avoid_unnecessary_containers, prefer_initializing_formals

import 'review.dart';

class Item {
  int idItem = 0;
  String tipo = "";
  String nombre = "";
  String genero = "";
  String autor = "";
  int duracion = 0;
  String rutaPortada = "";
  int estreno = 0;
  String sinopsis = "";
  double puntuacionMedia = 0.0;

  Item(
      int idItem,
      String tipo,
      String nombre,
      String genero,
      String autor,
      int duracion,
      String rutaPortada,
      int estreno,
      String sinopsis,
      double puntuacionMedia) {
    this.idItem = idItem;
    this.tipo = tipo;
    this.nombre = nombre;
    this.genero = genero;
    this.autor = autor;
    this.duracion = duracion;
    this.rutaPortada = rutaPortada;
    this.estreno = estreno;
    this.sinopsis = sinopsis;
    this.puntuacionMedia = puntuacionMedia;
  }

  void setIdItem(int idItem) {
    this.idItem = idItem;
  }

  int getIdItem() {
    return idItem;
  }

  void setTipo(String tipo) {
    this.tipo = tipo;
  }

  String getTipo() {
    return tipo;
  }

  void setNombre(String nombre) {
    this.nombre = nombre;
  }

  String getNombre() {
    return nombre;
  }

  void setGenero(String genero) {
    this.genero = genero;
  }

  String getGenero() {
    return genero;
  }

  void setAutor(String autor) {
    this.autor = autor;
  }

  String getAutor() {
    return autor;
  }

  void setDuracion(int duracion) {
    this.duracion = duracion;
  }

  int getDuracion() {
    return duracion;
  }

  void setRutaPortada(String rutaPortada) {
    this.rutaPortada = rutaPortada;
  }

  String getRutaPortada() {
    return rutaPortada;
  }

  void setEstreno(int estreno) {
    this.estreno = estreno;
  }

  int getEstreno() {
    return estreno;
  }

  void setSinopsis(String sinopsis) {
    this.sinopsis = sinopsis;
  }

  String getSinopsis() {
    return sinopsis;
  }

  void setPuntuacionMedia(double puntuacionMedia) {
    this.puntuacionMedia = puntuacionMedia;
  }

  double getPuntuacionMedia() {
    return puntuacionMedia;
  }
}
