// ignore_for_file: prefer_const_constructors, prefer_const_literals_to_create_immutables

import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';

class PaginaPrincipal extends StatefulWidget {
  @override
  MostrarContenido createState() => MostrarContenido();
}

class MostrarContenido extends State<PaginaPrincipal> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Uso de API")),
      body: Center(
        child: Text("Hola mundo"),
      ),
      drawer: getDrawer(context),
    );
  }

  getDrawer(BuildContext context) {
    return Drawer(
        child: ListView(
      children: [
        DrawerHeader(
            decoration: BoxDecoration(color: Colors.teal.shade300),
            child: Row(
              children: [
                FlutterLogo(size: 50),
                SizedBox(
                  width: 20,
                ),
                Text("Esta es la cabecera", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 20))
              ],
            )),
        ListTile(title: Text('Inicio'), leading: Icon(Icons.home), onTap: () => mostrarHome(context)),
        ListTile(
          title: Text("Ver datos usuarios"),
          leading: Icon(Icons.verified_user),
          onTap: () => verUsuarios(context),
        ),
        ListTile(title: Text('Ver otros datos'), leading: Icon(Icons.apple), onTap: () => verOtrosDatos(context)),
      ],
    ));
  }

  mostrarHome(conetxt) {
    Navigator.pop(context);
  }

  verUsuarios(BuildContext context) {
    Navigator.of(context).pushNamed("/segundaPagina");
  }

  verOtrosDatos(BuildContext context) {
    Navigator.of(context).pushNamed("/terceraPagina");
  }
}
