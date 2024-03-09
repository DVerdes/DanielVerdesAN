// ignore_for_file: use_key_in_widget_constructors, prefer_const_constructors, unnecessary_new, sized_box_for_whitespace, avoid_unnecessary_containers, prefer_initializing_formals

class Review {
  int idReview = 0;
  int idItem = 0;
  int puntuacion = 0;
  String usuario = "";
  String contenido = "";

  Review({
    required this.idReview,
    required this.idItem,
    required this.puntuacion,
    required this.usuario,
    required this.contenido,
  });

  void setIdReview(int idReview) {
    this.idReview = idReview;
  }

  int getIdReview() {
    return idReview;
  }

  void setIdItem(int idItem) {
    this.idItem = idItem;
  }

  int getIdItem() {
    return idItem;
  }

  void setPuntuacion(int puntuacion) {
    this.puntuacion = puntuacion;
  }

  int getPuntuacion() {
    return puntuacion;
  }

  void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  String getUsuatio() {
    return usuario;
  }

  void setContenido(String contenido) {
    this.contenido = contenido;
  }

  String getContenido() {
    return contenido;
  }
}
