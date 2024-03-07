// import 'package:flutter/material.dart';
// import 'package:proyecto_reviews/item.dart';

// class ListaItems extends StatefulWidget {
//   State<ListaItems> createState() => Items();
// }

// class Items extends State<ListaItems> {
//   List<Item> listaItems = [
//     Item(
//         1,
//         "pelicula",
//         "Avatar",
//         "Ciencia Ficción",
//         "James Cameron",
//         "150",
//         "assets/icons/avatar.png",
//         2021,
//         "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
//         2),
//     Item(
//         2,
//         "libro",
//         "Harry Potter",
//         "Fantasía",
//         "JK Rowling",
//         "362",
//         "assets/icons/hp.png",
//         1997,
//         "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
//         3),
//     Item(
//         3,
//         "juego",
//         "FIFA 23",
//         "Deportes",
//         "Electronic Arts",
//         "∞",
//         "assets/icons/fifa.png",
//         2022,
//         "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
//         3),
//   ];
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//         appBar: AppBar(
//           title: Text("Lista"),
//         ),
//         body: ListView.builder(
//             physics: NeverScrollableScrollPhysics(),
//             padding: EdgeInsets.only(top: 10),
//             itemExtent: 72.0,
//             shrinkWrap: true,
//             itemCount: listaItems.length,
//             itemBuilder: (BuildContext context, index) {
//               final item = listaItems[index];
//               return ListTile(
//                 title: Text(item.nombre),
//                 leading: Text(item.valoracion.toString() + "/5"),
//                 onTap: () {
//                   mostrarDatos(context, item);
//                 },
//               );
//             }));
//   }

//   mostrarDatos(BuildContext context, info) {
//     Navigator.of(context).pushNamed("/datos_item", arguments: info);
//   }
// }
