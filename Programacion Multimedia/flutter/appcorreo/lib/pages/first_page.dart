import 'package:appcorreo/correo.dart';
import 'package:flutter/material.dart';

class PrimeraClase extends StatefulWidget {
  CorreosGestion createState() => CorreosGestion();
}

class CorreosGestion extends State<PrimeraClase> {
  // Text Editing Controller
  final TextEditingController emailController = TextEditingController();

  // Listas de correos
  // Recibidos
  List<Correo> recibidos = [
    new Correo("Aula Nosa", "Tiene un nuevo mensaje en su bandeja de entrada",
        "Nuevo mensaje"),
    new Correo("Pedro Martínez", "Confirmamos la cita de mañana a las 17h",
        "Confirmación de cita"),
    new Correo("Amazon compras", "Su pedido llegará antes de las 22h de hoy",
        "Pedido enviado"),
    new Correo("League Pass", "Su suscripción a League Pass está a punto de caducar",
        "Suscripción"),
    new Correo("Seur", "Su envío ha llegado a su destinatario",
        "Envío completado")
  ];
  // Destacados
  List<Correo> destacados = [
    new Correo("Concesionario Ford",
        "Disfrute de las nuevas financiaciones en el concesionario", "Catálogo"),
    new Correo("Facebook", "Tiene tres solicitudes de amistad pendientes",
        "Solicitudes"),
    new Correo("Booking", "Se confirma su reserva en Hesperia Toledo",
        "Reserva confirmada"),
    new Correo("PcComponentes", "Disfruta de precios irrepetibles en los días naranjas",
        "Días naranjas de PcComponentes")
  ];
  //Pospuestos
  List<Correo> pospuestos = [
    new Correo("María Martín",
        "Envío facturas correspondientes al mes de septiembre", "Facturas"),
    new Correo("Ramiro Hernández", "Te mando las facturas remitidas por María",
        "facturas"),
    new Correo("Sergio Sánchez Silva", "Confirmamos la cita de mañana a las 19h",
        "Confirmación de cita")
  ];
  //Enviados
  List<Correo> enviados = [
    new Correo("Sergio Pérez", "Te adjunto el pdf del catálogo que te comenté",
        "pdf catálogo"),
    new Correo("Héctor Sousa", "Adjunto relación de nuevos envíos",
        "Envíos"),
    new Correo("Roberto López", "Confirmamos la cita de mañana a las 20h",
        "Confirmación de cita"),
    new Correo("Taller Miramar", "Me gustaría pedir cita para la semana del 17",
        "Revisión coche"),
    new Correo("Rogelio Rojas", "Hola, me interesa la mesa camilla que anuncias",
        "sin asunto")
  ];
  //Eliminados
  List<Correo> eliminados = [];
  //Lista mostrada en el body, por defecto Recibidos
  List<Correo> listaActiva = [ new Correo("Aula Nosa", "Tiene un nuevo mensaje en su bandeja de entrada",
        "Nuevo mensaje"),
    new Correo("Pedro Martínez", "Confirmamos la cita de mañana a las 17h",
        "Confirmación de cita"),
    new Correo("Amazon compras", "Su pedido llegará antes de las 22h de hoy",
        "Pedido enviado"),
    new Correo("League Pass", "Su suscripcióna League Pass está a punto de caducar",
        "Suscripción")];
  //String para guardar texto appBar
  String barText = "Recibidos";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(barText),
      ),
      body: getLista(context, listaActiva),
      drawer: getDrawer(context),
    );
  }

  //Drawer
  Widget getDrawer(BuildContext context) {
    return Drawer(
      //ListView con ListTiles
      child: ListView(
        children: [
          //Header
          UserAccountsDrawerHeader(
            accountName: Text("Daniel Verdes"),
            accountEmail: Text("dverdesm@gmail.com"),
            currentAccountPicture: FlutterLogo(),
          ),
          //ListTiles
          tileLista(context, "Recibidos", Icon(Icons.mail_sharp), recibidos),
          tileLista(context, "Destacados", Icon(Icons.star), destacados),
          tileLista(context, "Pospuestos", Icon(Icons.hourglass_empty), pospuestos),
          tileLista(context, "Enviados", Icon(Icons.arrow_forward), enviados),
          tileLista(context, "Eliminados", Icon(Icons.delete), eliminados),
        ],
      ),
    );
  }

  //ListView que se muestra en el body
  Widget getLista(BuildContext context, List lista) {
    return ListView.builder(
        itemCount: lista.length,
        itemBuilder: (BuildContext context, index) {
          final correo = lista[index];
          //ListTile (Diseño + contenido)
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
                          color: Colors.black.withOpacity(0.6)),
                          ),
                          
                ],
              ),
            ),
            leading: Icon(Icons.mail),
            //Botones del ListTile
            trailing: Wrap(
              spacing: 12,
              children: <Widget>[
                //Editar
                IconButton(
                  onPressed: () {
                    showEditor(context, lista, index);
                  },
                  icon: Icon(Icons.edit),
                ),
                //Borrar
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

  //ListTile del Drawer
  Widget tileLista(BuildContext context, String texto, Icon icono, List <Correo> lista){
      return ListTile(
            title: Text(texto),
            leading: icono,
            trailing: Text(lista.length.toString()),
            //onTap cambia la Lista activa en el body por la seleccionada por el usuario
            onTap: () {
              Navigator.pop(context);
              setState(() {
                listaActiva = lista;
                barText = texto;
              });
            },
          );

  }

  //Dialog de borrado de correos
  showAlertDialog(BuildContext context, List lista, int index) {
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Text("Pregunta"),
            content: Text("¿Seguro que deseas eliminar el elemento?"),
            actions: [
              //SI
              TextButton(
                  onPressed: () {
                    Navigator.pop(context);
                    //Condicional para eliminar definitivamente los elementos que ya estén en "eliminados"
                    if(lista!=eliminados){
                      eliminados.add(lista[index]);
                    }
                    setState(() {
                      lista.remove(lista[index]);
                    });
                    showSnackBar(
                        context, "Has eliminado el correo", Colors.red);
                  },
                  child: Text("Si")),
              //NO
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

  //Método para mostrar un SnackBar con un mensaje y color
  void showSnackBar(BuildContext context, String mensaje, Color color) {
    ScaffoldMessenger.of(context).showSnackBar(SnackBar(
      content: Text(
        mensaje,
        textAlign: TextAlign.center,
      ),
      backgroundColor: color,
    ));
  }

  //Método de edición del contenido de los correos
  showEditor(BuildContext context, List lista, int index) {
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            title: Text("Editar correo"),
            //TextField
            content: TextField(
              controller: emailController,
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                hintText: "Introduzca el nuevo contenido",
              ),
            ),
            actions: [
              //Confirmar
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
              //Cancelar
              TextButton(
                  onPressed: () {
                    Navigator.pop(context);
                    emailController.clear();
                  },
                  child: Text("Cancelar"))
            ],
          );
        });
  }
}
