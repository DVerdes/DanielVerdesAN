// clase Contacto

class Contacto {
  String nombre = "";
  String apellidos = "";
  String edad = "";
  String telefono = "";
  String correo = "";
  String rutaImg = "";

  Contacto(String nombre, String apellidos, String edad, String telefono,
      String correo, String rutaImg) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.telefono = telefono;
    this.correo = correo;
    this.rutaImg = rutaImg;
  }

  void set setNombre(String nombre) {
    this.nombre = nombre;
  }

  String get getNombre {
    return nombre;
  }
}
