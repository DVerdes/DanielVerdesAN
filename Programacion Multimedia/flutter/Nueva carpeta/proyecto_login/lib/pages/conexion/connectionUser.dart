import 'package:mysql1/mysql1.dart';
import 'package:proyecto_login/pages/inicio.dart';

class ConnectionUser {
  Future<Persona> login(String nombre, String contrasenha) async {
    final con = await MySqlConnection.connect(ConnectionSettings(host: '10.0.2.2', port: 3307, user: 'root', db: 'DAM2'));
    String sql = "SELECT * FROM usuario WHERE nombre LIKE'" + nombre + "' AND contrasenha LIKE '" + contrasenha + "';";
    var resultado = await con.query(sql);
    Persona persona = new Persona("", "", 0);

    for (var row in resultado) {
      persona = new Persona(row[1], row[2], row[3]);
    }
    await con.close();
    return persona;
  }

  Future<bool> register(Persona persona) async {
    final con = await MySqlConnection.connect(ConnectionSettings(host: '10.0.2.2', port: 3307, user: 'root', db: 'DAM2'));
    bool comprobar = false;
    var result = await con.query("INSERT INTO usuario (nombre, contrasenha, telefono) VALUES (?,?,?)", [persona.usuario, persona.contrasenha, persona.telefono]);
    comprobar = true;
    await con.close();
    return comprobar;
  }
}
