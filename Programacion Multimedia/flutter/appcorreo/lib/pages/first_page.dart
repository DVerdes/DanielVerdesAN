import 'package:appcorreo/correo.dart';
import 'package:flutter/material.dart';

class PrimeraClase extends StatefulWidget {
  CorreosGestion createState() => CorreosGestion();
}

class CorreosGestion extends State<PrimeraClase> {
  final TextEditingController emailController = TextEditingController();
  List<Correo> recibidos = [
    new Correo("Aula Nosa", "Tiene un nuevo mensaje en su bandeja de entrada",
        "Nuevo mensaje"),
    new Correo("Pedro Martínez", "Confirmamos la cita de mañana a las 17h",
        "Confirmación de cita")
  ];
  List<Correo> destacados = [
    new Correo("Concesionario Ford",
        "Disfrute de las nuevas financiaciones en el concesionario", "Catálogo")
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
                  onPressed: () {
                    showEditor(context, lista, index);
                  },
                  icon: Icon(Icons.edit),
                ),
                IconButton(
                  onPressed: () {
                    showAlertDialog(context, lista, index);
                  },
                  icon: Icon(Icons.delete),
                ),
              ],
            ),
          );
        });
  }

  showAlertDialog(BuildContext context, List lista, int index) {
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Text("Pregunta"),
            content: Text("¿Seguro que deseas eliminar el elemento?"),
            actions: [
              TextButton(
                  onPressed: () {
                    Navigator.pop(context);
                    eliminados.add(lista[index]);
                    setState(() {
                      lista.remove(lista[index]);
                    });
                    showSnackBar(
                        context, "Has eliminado el correo", Colors.red);
                  },
                  child: Text("Si")),
              TextButton(
                  onPressed: () {
                    Navigator.pop(context);
                    showSnackBar(context, "No has eliminado el correo",
                        Color.fromARGB(255, 255, 174, 0));
                  },
                  child: Text("No"))
            ],
          );
        });
  }

  void showSnackBar(BuildContext context, String mensaje, Color color) {
    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
      content: Text(
        mensaje,
        textAlign: TextAlign.center,
      ),
      backgroundColor: color,
    ));
  }

  showEditor(BuildContext context, List lista, int index) {
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Text("Editar correo"),
            content: TextField(
              controller: emailController,
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                hintText: "Introduzca el nuevo contenido",
              ),
            ),
            actions: [
              TextButton(
                  onPressed: () {
                    setState(() {
                      lista[index].mensaje = emailController.text;
                    });
                    emailController.clear();
                    Navigator.pop(context);
                    showSnackBar(
                        context, "Mensaje editado con éxito", Colors.green);
                  },
                  child: Text("Confirmar")),
              TextButton(
                  onPressed: () {
                    Navigator.pop(context);
                  },
                  child: Text("Cancelar"))
            ],
          );
        });
  }
}
