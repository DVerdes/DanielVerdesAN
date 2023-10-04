import 'package:flutter/material.dart';

void main() {
  runApp(Dam_calculadora());
}
/*
class Dam extends StatelessWidget{
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: "Aplicación DAM",
      home: Scaffold(appBar: AppBar(
        title: Text("Barra de aplicación") ,
      ),
      body: Center(child: Icon(Icons.account_tree, size: 400, color: Colors.orange,)
      ),
      )
    );

  }

}
*/

/*
class Dam_2 extends StatelessWidget {

  int cont = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Aplicación 2",
      home: Scaffold(
          appBar: AppBar(
            title: Text("Barra de aplicación"),
          ),
          body: Center(
            child: IconButton(
              icon: Icon(Icons.accessibility_rounded),
              onPressed: () {
                cont++;
                print("Hemos pulsado el icono " + cont.toString() + " veces");
              },
            ),
          )),
    );
  }
}

*/

/*
class Dam_3 extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Aplicación 3",
      home: Scaffold(
        appBar: AppBar(
          title: Text("Barra de aplicación"),
        ),
        body: Center(),
        backgroundColor: Color.fromARGB(255, 192, 145, 2),
        drawer: Drawer(),
        endDrawer: Drawer(),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.ac_unit),
          onPressed: (){
            print("Pulsador");
          },
        ),
      ),
    );
  }
}

*/

/*

class Dam_4 extends StatelessWidget {
  int cont1 = 0;
  int cont2 = 0;
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "App 4",
      home: Scaffold(
        appBar: AppBar(
          title: Text("Barra de aplicación"),
          backgroundColor: Colors.indigo,
          actions: [
            IconButton( icon: Icon(Icons.account_balance_sharp), onPressed: pulsadorIzquierda),
            IconButton( icon: Icon(Icons.rice_bowl), onPressed: pulsadorDerecha),
            IconButton( icon: Icon(Icons.abc_outlined), onPressed: pulsadorContador)

          ],
        ),
        body: Center(),
      ),
    );
  }

  void pulsadorIzquierda() {
    print("Estas pulsando el botón de la izquierda");
    cont1++;
  }

  void pulsadorDerecha() {
        print("Estas pulsando el botón de la derecha");
        cont2++;
  }

  void pulsadorContador(){
    print("IZQ: "+cont1.toString());
    print("DCH: "+cont2.toString());
  }

}

*/

/*

class Dam_5 extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: "Grandes columnas",
      home: Scaffold(appBar: AppBar(
        title: Text("Columnas") ,
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          Text("Hola"),
          Container(
            color: Colors.amberAccent,
            height: 100,
            width: 100,
          ),
          Image.network("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLtgQ9FVUtqaWpzgwpRhTtDraQbCH-8pxnlQ&usqp=CAU",
          height: 200,
          width: 100,
          ),
        ],
      )
      ),
    );

  }

}

*/

/*

class Dam_6 extends StatelessWidget{
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: "Filas",
      home: Scaffold(appBar: AppBar(
        title: Text("Filas"),
      ),
      body: Row(
        children: [
          Expanded(child: Text("Activar sonido")),
          Icon(Icons.ac_unit, size: 50,),
          Switch(value: false, onChanged: (value){

          }),
        ],
      )
      )
    );

  }

}

*/

/*

class Dam_7 extends StatelessWidget{
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: "Filas y columnas",
      home: Scaffold(appBar: AppBar(
        title: Text("Combinación de filas y columnas") ,
      ),
      body: Column(
        children: [
          Row(
            children: [
              Container(
                height: 100,
                width: 100,
                margin: EdgeInsets.all(10),
                color: Colors.blueAccent,
              ),
                Container(
                height: 100,
                width: 100,
                margin: EdgeInsets.all(10),
                color: Colors.redAccent,
              ),
                Container(
                height: 100,
                width: 100,
                                margin: EdgeInsets.all(10),

                color: Colors.purpleAccent,
              )
            ],
          ),
          Divider(
            color: Colors.transparent,

          ),
          Row( children: [
              Container(
                height: 100,
                width: 100,
                                margin: EdgeInsets.all(10),

                color: Colors.greenAccent,
              ),
                Container(
                height: 100,
                width: 100,
                                margin: EdgeInsets.all(10),

                color: Colors.grey,
              ),
                Container(
                height: 100,
                width: 100,
                                margin: EdgeInsets.all(10),

                color: Colors.yellowAccent,
              )
            ],),
                      Divider(
                        color: Colors.transparent,
                      ),

          Row( children: [
              Container(
                height: 100,
                width: 100,
                                margin: EdgeInsets.all(10),

                color: Colors.brown,
              ),
                Container(
                height: 100,
                width: 100,
                                margin: EdgeInsets.all(10),
                                child: Center(child: Text("Hey"),),

                color: Colors.lightGreen,
              ),
                Container(
                height: 100,
                width: 100,
                                margin: EdgeInsets.only(
                                  left: 100
                                ),
                                child: Text("Hola",textAlign: TextAlign.center, style: TextStyle(color: Colors.white, fontSize: 20),),

                color: Colors.blueAccent,
              )
            ],),

        ],
      ),
      )
    );

  }

}

*/

class Dam_calculadora extends StatelessWidget {
  String op1 = "";
  String op2 = "";
  int operador = 0;
  int operadorPulsado = 0;
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: "CALCULADORA",
        home: Scaffold(
            appBar: AppBar(
              title: Text("Calculadora"),
            ),
            body: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Container(
                      child: Text(
                        "Calculadora",
                        style: TextStyle(
                            fontSize: 30, fontWeight: FontWeight.bold),
                      ),
                    )
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "7";
                        } else {
                          op2 += "7";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text(
                          "7",
                          style: TextStyle(fontSize: 20),
                        )),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "8";
                        } else {
                          op2 += "8";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("8", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "9";
                        } else {
                          op2 += "9";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("9", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        operador = 4;
                        operadorPulsado = 1;
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("/", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.white,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "4";
                        } else {
                          op2 += "4";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text(
                          "4",
                          style: TextStyle(fontSize: 20),
                        )),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "5";
                        } else {
                          op2 += "5";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("5", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "6";
                        } else {
                          op2 += "6";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("6", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        operador = 3;
                        operadorPulsado = 1;
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("*", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.white,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "1";
                        } else {
                          op2 += "1";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text(
                          "1",
                          style: TextStyle(fontSize: 20),
                        )),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "2";
                        } else {
                          op2 += "2";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("2", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "3";
                        } else {
                          op2 += "3";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("3", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        operador = 2;
                        operadorPulsado = 1;
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("-", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.white,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                  ],
                ),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    InkWell(
                      onTap: () {
                        print("Clear");
                        op1 = "";
                        op2 = "";
                        operador = 0;
                        operadorPulsado = 0;
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text(
                          "C",
                          style: TextStyle(fontSize: 20),
                        )),
                        decoration: BoxDecoration(
                            color: Colors.white,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          op1 += "0";
                        } else {
                          op2 += "0";
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("0", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.grey,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        operador = 0;
                        operadorPulsado = 1;
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("+", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.white,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          print("Error: selecciona un operador");
                        } else if (op1 == "" || op2 == "") {
                          print("Uno de los operadores no tiene valor");
                        } else {
                          int num1 = int.parse(op1);
                          int num2 = int.parse(op2);
                          int resultado = 0;
                          double resultadoDividir = 0;

                          if (operador == 1) {
                            resultado = num1 + num2;
                            print(num1.toString() +
                                " + " +
                                num2.toString() +
                                " = " +
                                resultado.toString());
                          } else if (operador == 2) {
                            resultado = num1 - num2;
                            print(num1.toString() +
                                " - " +
                                num2.toString() +
                                " = " +
                                resultado.toString());
                          } else if (operador == 3) {
                            resultado = num1 * num2;
                            print(num1.toString() +
                                " * " +
                                num2.toString() +
                                " = " +
                                resultado.toString());
                          } else if (operador == 4) {
                            resultadoDividir = num1 / num2;
                            print(num1.toString() +
                                " / " +
                                num2.toString() +
                                " = " +
                                resultadoDividir.toString());
                          }

                          if (operador != 4) {
                            op1 = resultado.toString();
                          } else {
                            op1 = resultadoDividir.toString();
                          }
                          op2 = "";
                          operador = 0;
                          operadorPulsado = 0;
                        }
                      },
                      child: Container(
                        width: 100,
                        height: 100,
                        margin: EdgeInsets.all(10),
                        child: Center(
                            child: Text("=", style: TextStyle(fontSize: 20))),
                        decoration: BoxDecoration(
                            color: Colors.white,
                            border: Border.all(color: Colors.black, width: 2),
                            borderRadius:
                                BorderRadius.all(Radius.circular(15.0))),
                      ),
                    ),
                  ],
                )
              ],
            )));
  }
}


/*
  Container(
    decoration: BoxDecoration(
      color: Colors.yellow,
      border: Border.all(
        color: colors.black,
        width: 6,
      ),
      borderRadius...
    )
  )

*/


/*

El contenedor es estático, pero podemos hacer q ejecute algo mediante el widget INKWELL (lo convierte en dináminco)

InkWell(
  onTap: (){
    print('7');
  },
  child: container(...)
)




*/