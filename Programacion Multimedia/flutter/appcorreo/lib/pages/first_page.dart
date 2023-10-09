import 'package:appcorreo/correo.dart';
import 'package:flutter/material.dart';

class PrimeraClase extends StatefulWidget {
  CorreosGestion createState() => CorreosGestion();
}

class CorreosGestion extends State<PrimeraClase> {
  List<Correo> recibidos = [
    new Correo("Aula Nosa", "Tiene un nuevo mensaje en su bandeja de entrada",
        "Nuevo mensaje"),
    new Correo("Pedro Martínez", "Confirmamos la cita de mañana a las 17h",
        "Confirmación de cita")
  ];
  List<Correo> destacados = [
    new Correo("Concesionario Ford",
        "Disfrute de las nuevas finanziaciones en el concesionario", "Catálogo")
  ];
  List<Correo> pospuestos = [
    new Correo("María Martín",
        "Envío facturas correspondientes al mes de septiembre", "Facturas")
  ];
  List<Correo> enviados = [
    new Correo("Sergio Pérez", "Te adjunto el pdf del catálogo que te comenté",
        "pdf catálogo")
  ];
  List<Correo> eliminados = [];
  List<Correo> listaActiva = [];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Gestión de correos"),
      ),
      body: getLista(context, listaActiva),
      drawer: getDrawer(context),
    );
  }

  Widget getDrawer(BuildContext context) {
    return Drawer(
      child: ListView(
        children: [
          UserAccountsDrawerHeader(
            accountName: Text("Daniel Verdes"),
            accountEmail: Text("dverdesm@gmail.com"),
            currentAccountPicture: FlutterLogo(),
          ),
          ListTile(
            title: Text("Recibidos"),
            leading: Icon(Icons.mail_sharp),
            tileColor: Color.fromARGB(255, 236, 236, 236),
            onTap: () {
              Navigator.pop(context);
              setState(() {
                listaActiva = recibidos;
              });
            },
          ),
          ListTile(
            title: Text("Destacados"),
            leading: Icon(Icons.star),
            onTap: () {
              Navigator.pop(context);
              setState(() {
                listaActiva = destacados;
              });
            },
          ),
          ListTile(
            title: Text("Pospuestos"),
            leading: Icon(Icons.hourglass_empty),
            onTap: () {
              Navigator.pop(context);
              setState(() {
                listaActiva = pospuestos;
              });
            },
          ),
          ListTile(
            title: Text("Enviados"),
            leading: Icon(Icons.arrow_forward),
            onTap: () {
              Navigator.pop(context);
              setState(() {
                listaActiva = enviados;
              });
            },
          ),
          ListTile(
            title: Text("Eliminados"),
            leading: Icon(Icons.delete),
            onTap: () {
              Navigator.pop(context);
              setState(() {
                listaActiva = eliminados;
              });
            },
          )
        ],
      ),
    );
  }

  Widget getLista(BuildContext context, List lista) {
    return ListView.builder(
        itemCount: lista.length,
        itemBuilder: (BuildContext context, index) {
          final correo = lista[index];
          return ListTile(
            title: RichText(
              text: TextSpan(
                // Note: Styles for TextSpans must be explicitly defined.
                // Child text spans will inherit styles from parent
                style: const TextStyle(
                  fontSize: 14.0,
                  color: Colors.black,
                ),
                children: <TextSpan>[
                  TextSpan(text: correo.remitente + "      "),
                  TextSpan(
                      text: correo.asunto,
                      style: const TextStyle(fontWeight: FontWeight.bold)),
                  TextSpan(
                      text: "   -   " + correo.mensaje,
                      style: TextStyle(
                          fontStyle: FontStyle.italic,
                          color: Colors.black.withOpacity(0.6))),
                ],
              ),
            ),
            leading: Icon(Icons.mail),
            trailing: Wrap(
              spacing: 12,
              children: <Widget>[
                IconButton(
                  onPressed: () {},
                  icon: Icon(Icons.edit),
                ),
                IconButton(
                  onPressed: () {
                    eliminados.add(lista[index]);
                    setState(() {
                      lista.remove(lista[index]);
                    });
                  },
                  icon: Icon(Icons.delete),
                ),
              ],
            ),
          );
        });
  }
}
