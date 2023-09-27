

import 'package:flutter/material.dart';

class PrimeraClase extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Primera página"),)
      , body: Center(
        child: Row(
          children: [
            IconButton(icon: Icon(Icons.arrow_forward), onPressed: () => mostrarSegundaV(context),),
            Text("Pulse aquí")
          ],
        ),
      )
    );
  }

}

mostrarSegundaV(BuildContext context){
  Navigator.of(context).pushNamed("/segundaPagina");
}