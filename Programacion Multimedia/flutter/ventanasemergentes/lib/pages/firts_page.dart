
import 'package:flutter/gestures.dart';
import 'package:flutter/material.dart';

class PrimeraClase extends StatefulWidget{

  //MostrarSnackBar createState() => MostrarSnackBar();
  //MostrarDrawer createState() => MostrarDrawer();
  //MostrarSimpleDialog createState() => MostrarSimpleDialog();
  MostrarAlertDialog createState() => MostrarAlertDialog();

  
}

/*
class MostrarDrawer extends State<PrimeraClase>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Drawer"),
      ),
      body: Center(child: Text("Hola mundo")),
      drawer: getDrawer(context),
    );
  }
  
  Widget getDrawer(BuildContext context) {

    return Drawer(
      child: ListView(
        children: [
          // DrawerHeader(
          //   decoration: BoxDecoration(color: Colors.teal),
          //   child: Row(
          //     mainAxisAlignment: MainAxisAlignment.spaceBetween,
          //     children: [FlutterLogo(size: 50,),
          //   Text("Esta es la cabecera", style: TextStyle(color: Colors.white, fontSize: 20, fontWeight: FontWeight.bold),),
          // ],)),
          UserAccountsDrawerHeader(accountName: Text("Daniel Verdes"), accountEmail: Text("dverdesm@gmail.com"),
          currentAccountPicture: FlutterLogo(),),
          ListTile(
            title: Text("Inicio"),
            leading: Icon(Icons.home),
            onTap: () {      
              Navigator.pop(context);
            },
          )
        ],
      ),
    );
  }
}
*/

/*
class MostrarSnackBar extends State<PrimeraClase>{
  @override
  Widget build(BuildContext context) {
   return Scaffold(
    appBar: AppBar(
      title: Text("Mostrar SnackBar"),
    ),
    body: Center(child: TextButton(
      onPressed: () {
        final snb = SnackBar(content: Row(
          children: [
            Icon(Icons.thumb_up),
            SizedBox(width: 30,),
            Text("Elemento eliminado")
          ],
        ),
        backgroundColor: Colors.orange,
        );
        ScaffoldMessenger.of(context).showSnackBar(snb);
      },
      child: Text("Mostrar SnackBar")),),
   );
  }
}
*/

/** 
class MostrarSimpleDialog extends State<PrimeraClase>{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Uso simple Dialog")),
      body: Center(
        child: TextButton(
          onPressed:() => showSimpleDialog(context),

          child: Text("mostrar simpleDialog")),
      ),
    );
  }
  
  showSimpleDialog(BuildContext context) {
    String mensaje = "";

    showDialog(context: context, builder: (BuildContext context){
      return SimpleDialog(
        title: Text("Seleccione"),
        children: [
          ListTile(
            title: Text("Editar"),
            leading: Icon(Icons.edit, color: Colors.orange,),
            onTap: () {
              mensaje = "Has editado el elemento";
              Navigator.pop(context);
              showSnackBar(context, mensaje, Colors.orange);

            },
            
          ),
            ListTile(
            title: Text("Eliminar"),
            leading: Icon(Icons.delete, color: Colors.red,),
            onTap: () {
              mensaje = "Has eliminado el elemento";
              Navigator.pop(context);
              showSnackBar(context, mensaje, Colors.red);

            },
            
          )
        ],
      );
    });
  }
  
  void showSnackBar(BuildContext context, String mensaje, Color color) {


      ScaffoldMessenger.of(context).showSnackBar(

      SnackBar(content: Text(mensaje, textAlign: TextAlign.center,),backgroundColor: color,)
    );

  }

   
}

*/

class MostrarAlertDialog extends State<PrimeraClase>{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Uso de Alert Dialog")),
      body: Center(child: TextButton(
        child: Text("Mostrar Alert Dialog"), 
        onPressed: () { showAlertDialog(context); },
  

      ),
      ),
    );
  }
  
  showAlertDialog(BuildContext context) {
    showDialog(context: context, builder: (BuildContext context) {
      return AlertDialog(
        title: Text("Pregunta"),
        content: Text("¿Seguro que deseas eliminar el elemento?"),
        actions: [
          TextButton(onPressed: (){
            Navigator.pop(context);

          }, child: Text("Si")),
          TextButton(onPressed: (){
            Navigator.pop(context);

          }, child: Text("No"))
        ],
      );
    });

  }

}
