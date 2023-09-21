import 'package:flutter/material.dart';

void main() {
  runApp(Dam_calculadora());
}

// APLICACIÓN DE CALCULADORA

class Dam_calculadora extends StatelessWidget {
  // VARIABLES
  // Primer operando
  String op1 = "";
  // Segundo operando
  String op2 = "";
  // Tipo operador
  int operador = 0;
  // Estado operador
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
                // Encabezado
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
                // 1era fila botones
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // 7
                    InkWell(
                      onTap: () {
                        print("7");
                        if (operadorPulsado == 0) {
                          op1 += "7";
                        } else if (operadorPulsado == 1) {
                          op2 += "7";
                        } else {
                          op1 = "7";
                          operadorPulsado = 0;
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
                    // 8
                    InkWell(
                      onTap: () {
                        print("8");
                        if (operadorPulsado == 0) {
                          op1 += "8";
                        } else if (operadorPulsado == 1) {
                          op2 += "8";
                        } else {
                          op1 = "8";
                          operadorPulsado = 0;
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
                    // 9
                    InkWell(
                      onTap: () {
                        print("9");

                        if (operadorPulsado == 0) {
                          op1 += "9";
                        } else if (operadorPulsado == 1) {
                          op2 += "9";
                        } else {
                          op1 = "9";
                          operadorPulsado = 0;
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
                    // Operador /
                    InkWell(
                      onTap: () {
                        print("/");
                        if (op1 != "") {
                          operador = 4;
                          operadorPulsado = 1;
                        } else {
                          print("Falta el primer operando");
                        }
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
                // 2nda fila botones
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // 4
                    InkWell(
                      onTap: () {
                        print("4");
                        if (operadorPulsado == 0) {
                          op1 += "4";
                        } else if (operadorPulsado == 1) {
                          op2 += "4";
                        } else {
                          op1 = "4";
                          operadorPulsado = 0;
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
                    // 5
                    InkWell(
                      onTap: () {
                        print("5");
                        if (operadorPulsado == 0) {
                          op1 += "5";
                        } else if (operadorPulsado == 1) {
                          op2 += "5";
                        } else {
                          op1 = "5";
                          operadorPulsado = 0;
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
                    // 6
                    InkWell(
                      onTap: () {
                        print("6");

                        if (operadorPulsado == 0) {
                          op1 += "6";
                        } else if (operadorPulsado == 1) {
                          op2 += "6";
                        } else {
                          op1 = "6";
                          operadorPulsado = 0;
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
                    // Operador *
                    InkWell(
                      onTap: () {
                        print("*");
                        if (op1 != "") {
                          operador = 3;
                          operadorPulsado = 1;
                        } else {
                          print("Falta el primer operando");
                        }
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
                // 3era fila botones
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // 1
                    InkWell(
                      onTap: () {
                        print("1");
                        if (operadorPulsado == 0) {
                          op1 += "1";
                        } else if (operadorPulsado == 1) {
                          op2 += "1";
                        } else {
                          op1 = "1";
                          operadorPulsado = 0;
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
                    // 2
                    InkWell(
                      onTap: () {
                        print("2");

                        if (operadorPulsado == 0) {
                          op1 += "2";
                        } else if (operadorPulsado == 1) {
                          op2 += "2";
                        } else {
                          op1 = "2";
                          operadorPulsado = 0;
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
                    // 3
                    InkWell(
                      onTap: () {
                        print("3");
                        if (operadorPulsado == 0) {
                          op1 += "3";
                        } else if (operadorPulsado == 1) {
                          op2 += "3";
                        } else {
                          op1 = "3";
                          operadorPulsado = 0;
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
                    // Operador -
                    InkWell(
                      onTap: () {
                        print("-");
                        if (op1 != "") {
                          operador = 2;
                          operadorPulsado = 1;
                        } else {
                          print("Falta el primer operando");
                        }
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
                // 4arta fila botones
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // CLEAR
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
                    // 0
                    InkWell(
                      onTap: () {
                        print("0");
                        if (operadorPulsado == 0) {
                          if (op1 != "") {
                            op1 += "0";
                          }
                        } else if (operadorPulsado == 1) {
                          op2 += "0";
                        } else {
                          op1 = "0";
                          operadorPulsado = 0;
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
                    // Operador +
                    InkWell(
                      onTap: () {
                        print("+");
                        if (op1 != "") {
                          operador = 1;
                          operadorPulsado = 1;
                        } else {
                          print("Falta el primer operando");
                        }
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
                    // =
                    InkWell(
                      onTap: () {
                        if (operadorPulsado == 0) {
                          print("Error: selecciona un operador");
                        } else if (op1 == "" || op2 == "") {
                          print("Uno de los operandos no tiene valor");
                        } else {
                          print("=");
                          // Variables cálculo resultado
                          double num1 = double.parse(op1);
                          double num2 = double.parse(op2);
                          double resultado = 0;
                          int resultadoRedondeo = 0;
                          if (operador == 1) {
                            resultadoRedondeo = ((num1 + num2) * 100).toInt();
                            resultado = (resultadoRedondeo / 100).toDouble();
                            print(num1.toString() +
                                " + " +
                                num2.toString() +
                                " = " +
                                resultado.toString());
                          } else if (operador == 2) {
                            resultadoRedondeo = ((num1 - num2) * 100).toInt();
                            resultado = (resultadoRedondeo / 100).toDouble();
                            print(num1.toString() +
                                " - " +
                                num2.toString() +
                                " = " +
                                resultado.toString());
                          } else if (operador == 3) {
                            resultadoRedondeo = ((num1 * num2) * 100).toInt();
                            resultado = (resultadoRedondeo / 100).toDouble();
                            print(num1.toString() +
                                " * " +
                                num2.toString() +
                                " = " +
                                resultado.toString());
                          } else if (operador == 4) {
                            resultadoRedondeo = ((num1 / num2) * 100).toInt();
                            resultado = (resultadoRedondeo / 100).toDouble();
                            print(num1.toString() +
                                " / " +
                                num2.toString() +
                                " = " +
                                resultado.toString());
                          }
                          // Reinicio variables
                          op1 = resultado.toString();
                          op2 = "";
                          operador = 0;
                          operadorPulsado = 2;
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
