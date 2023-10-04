import 'package:flutter/material.dart';
import 'package:listacontactos/Contacto.dart';

class SegundaClase extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    Contacto contacto = ModalRoute.of(context)!.settings.arguments as Contacto;

    return Scaffold(
        appBar: AppBar(title: Text("Contacto")),
        body: Column(
          children: [
            Container(
              // foto
              height: 380,
              margin: EdgeInsets.fromLTRB(0, 40, 0, 0),
              color: Color.fromARGB(255, 255, 255, 255),
              child: CircleAvatar(
                radius: 150,
                backgroundColor: const Color.fromARGB(255, 0, 0, 0),
                child: Padding(
                  padding: const EdgeInsets.all(3), // Border radius
                  child: ClipOval(child: Image.asset(contacto.rutaImg)),
                ),
              ),
            ),
            Container(
              height: 150,
              child: Center(
                child: Text(contacto.nombre + " " + contacto.apellidos,
                    style: TextStyle(
                        fontSize: 40,
                        letterSpacing: 3,
                        decorationThickness: 2.8)),
              ),
              margin: EdgeInsets.all(20),
            ),
            cardContainer(true, contacto),
            cardContainer(false, contacto)
          ],
        ));
  }

Widget cardContainer(bool tipo, Contacto contacto){
   return Container(
              height: 120,
              child: Card(child: Center(
                child: ListTile(
                  leading: Padding(
                    padding: const EdgeInsets.fromLTRB(20,0,0,0),
                    child: Icon(tipo ? Icons.add_call: Icons.mail, size: 30,),
                  ),
                  title: Padding(
                    padding: tipo? EdgeInsets.fromLTRB(240, 0, 0, 0) : EdgeInsets.fromLTRB(220, 0,0, 0),
                    child: Text(tipo ? contacto.telefono : contacto.correo, style: TextStyle(fontSize: tipo ? 30:20),),
                  ),                    
                ),
              ),
                color: Color.fromARGB(255, 210, 210, 211),
                margin: EdgeInsets.all(20),
                elevation: 20,
                surfaceTintColor: Color.fromARGB(255, 255, 255, 255),
                shadowColor: const Color.fromARGB(255, 0, 90, 164),
              ),
            );
}


}

