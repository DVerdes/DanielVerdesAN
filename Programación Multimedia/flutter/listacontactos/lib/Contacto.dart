class Contacto{

  String nombre = "";
  String apellidos = "";
  String edad = "";
  String telefono = "";
  String correo = "";


  Contacto(String nombre, String apellidos, String edad, String telefono, String correo){
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.telefono = telefono;
    this.correo = correo;
  }

  void set setNombre(String nombre){
    this.nombre = nombre;

  }

  String get getNombre{
    return nombre;
  }

}