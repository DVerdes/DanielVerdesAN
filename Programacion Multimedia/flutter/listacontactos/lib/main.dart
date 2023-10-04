import 'package:flutter/material.dart';
import 'package:listacontactos/Contacto.dart';
import 'package:listacontactos/p%C3%A1ginas/segundaPagina.dart';

void main() {
  runApp(Main());
}

class Main extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // ArrayList de objetos Contacto
    List<Contacto> contactos = [
      new Contacto("Pedro", "Martínez León", "24", "678345211",
          "pedromar@gmail.com", "assets/images/pedro.png"),
      new Contacto("Marta", "García Suárez", "35", "654789666",
          "martagarci@gmail.com", "assets/images/marta.png"),
      new Contacto("Roberto", "Varela Hernández", "45", "654333555",
          "robervar@gmail.com", "assets/images/roberto.png"),
      new Contacto("Santiago", "Ramirez Ledesma", "23", "678345345",
          "santiramir@gmail.com", "assets/images/santiago.png"),
      new Contacto("Asier", "Iraola Martín", "36", "654787898",
          "asierirma@gmail.com", "assets/images/asier.png"),
      new Contacto("Vanesa", "Villares Jurado", "31", "654787976",
          "vanesavir@gmail.com", "assets/images/vanesa.png"),
      new Contacto("Luís", "San Pedro Costas", "28", "654345234",
          "luissan@gmail.com", "assets/images/luis.png"),
      new Contacto("Lucía", "Rodríguez Rojo", "32", "654789345",
          "luciarod@gmail.com", "assets/images/lucia.png"),
      new Contacto("Humberto", "Barcia López", "56", "642123123",
          "humbbar@gmail.com", "assets/images/humberto.png"),
      new Contacto("Susana", "Piñeiro Pérez", "25", "675657345",
          "susanapiñe@gmail.com", "assets/images/susana.png")
    ];

    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: "Proyecto 2",
        routes: {
          "/segundaPagina": (BuildContext context) => SegundaClase(),
        },
        home: Scaffold(
          appBar: AppBar(
            title: Text("Agenda de contactos"),
          ),
          body: ListView.builder(
              itemCount: contactos.length,
              itemBuilder: (BuildContext context, index) {
                final persona = contactos[index];
                return ListTile(
                  title: Text((persona).getNombre),
                  leading: Icon(Icons.person),
                  onTap: () {
                    mostrarSegundaV(context, persona);
                  },
                );
              }),
        ));
  }
}

mostrarSegundaV(BuildContext context, info) {
  Navigator.of(context).pushNamed("/segundaPagina", arguments: info);
}
