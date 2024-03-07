import 'package:api/paginas/datos_otros_usuarios.dart';
import 'package:api/paginas/datos_usuarios.dart';
import 'package:api/paginas/pag_principal.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(title: 'Ejemplo API', initialRoute: "/paginaPrincipal", routes: {
      "/paginaPrincipal": (BuildContext context) => PaginaPrincipal(),
      "/segundaPagina": (BuildContext context) => DatosUsuarios(),
      "/terceraPagina": (BuildContext context) => OtrosDatos(),
    });
  }
}
