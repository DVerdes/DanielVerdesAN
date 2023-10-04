import 'package:flutter/material.dart';
import 'package:listacontactos/Contacto.dart';

class SegundaClase extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    Contacto contacto = ModalRoute.of(context)!.settings.arguments as Contacto;

    return Scaffold(
        // appBar
        appBar: AppBar(title: Text("Contacto")),
        body: Column(
          children: [
            Container(
              // Foto contacto
              height: 250,
              margin: EdgeInsets.fromLTRB(0, 40, 0, 20),
              color: Color.fromARGB(255, 255, 255, 255),
              child: CircleAvatar(
                radius: 150,
                backgroundColor: Color.fromARGB(255, 170, 170, 170),
                child: Padding(
                  padding: const EdgeInsets.all(1), // Border radius
                  child: ClipOval(child: Image.asset(contacto.rutaImg)),
                ),
              ),
            ),
            Container(
              // Contenedor nombre
              height: 100,
              child: Center(
                child: Text(contacto.nombre + " " + contacto.apellidos,
                    style: TextStyle(
                        fontSize: 25,
                        letterSpacing: 1,
                        decorationThickness: 4)),
              ),
              margin: EdgeInsets.all(10),
              color: const Color.fromARGB(255, 235, 235, 235),
            ),
            // Contenedores teléfono y contacto
            cardContainer(true, contacto),
            cardContainer(false, contacto)
          ],
        ));
  }

/**
 * Devuelve Container con Card anidado
 * tipo: si se trata de tipo teléfono o de tipo correo
 * contacto: el objeto Contacto del que obtener parámetros
 */
  Widget cardContainer(bool tipo, Contacto contacto) {
    return Container(
      height: 100,
      child: Card(
        child: Center(
          child: ListTile(
            leading: Padding(
              padding: const EdgeInsets.fromLTRB(20, 0, 0, 0),
              child: Icon(
                tipo ? Icons.add_call : Icons.mail,
                size: 30,
              ),
            ),
            title: Padding(
              padding: EdgeInsets.fromLTRB(20, 0, 0, 0),
              child: Text(
                tipo ? contacto.telefono : contacto.correo,
                style: TextStyle(fontSize: tipo ? 20 : 15),
              ),
            ),
          ),
        ),
        color: Color.fromARGB(255, 210, 210, 211),
        margin: EdgeInsets.all(20),
        elevation: 10,
        surfaceTintColor: Color.fromARGB(255, 255, 255, 255),
        shadowColor: Color.fromARGB(255, 121, 121, 121),
      ),
    );
  }
}
