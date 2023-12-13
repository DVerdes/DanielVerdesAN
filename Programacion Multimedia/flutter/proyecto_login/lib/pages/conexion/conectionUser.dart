import 'package:mysql1/mysql1.dart';
import 'package:proyecto_login/pages/inicio.dart';



class ConectionUser{


  Future<Persona> login(String nombre, String contrasena) async{
        final con = await MySqlConnection.connect(ConnectionSettings(
          host: '10.0.0.2', port: 3307, user: 'root', db: 'dam2'
        ));

        String sql = "SELECT * FROM usuario WHERE nombre = '" +nombre + "' and contrasena = '"+contrasena+"';";

        var resultado = await con.query(sql);

        Persona persona = new Persona("", "", 0);

        for(var row in resultado){
          persona = new Persona(row[1], row[2],row[3]);
        }

       return persona;
  }


}