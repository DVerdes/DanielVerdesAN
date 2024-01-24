class Carta {
  int modificador = 0;
  String rutaImg = "";

  Carta(int modificador, String rutaImg) {
    this.modificador = modificador;
    this.rutaImg = rutaImg;
  }

  void set setRutaImg(String rutaImg) {
    this.rutaImg = rutaImg;
  }

  String get getRutaImg {
    return rutaImg;
  }

  void set setModificador(int modificador) {
    this.modificador = modificador;
  }

  int get getModificador {
    return modificador;
  }
}
