import 'package:flutter/material.dart';

void main() {
  runApp(calculadora());
}

// APLICACIÓN DE CALCULADORA

class calculadora extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => Dam_calculadora();
}

class Dam_calculadora extends State<calculadora> {
  // VARIABLES
  // Primer operando
  String op1 = "";
  // Segundo operando
  String op2 = "";
  // Tipo operador
  int operador = 0;
  // Estado operador
  int operadorPulsado = 0;

  String pantalla = "";

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
                      color: Color.fromARGB(255, 214, 214, 214),
                      width: 250,
                      height: 80,
                      child: Center(
                        child: Text(
                          pantalla,
                          style: TextStyle(
                              fontSize: 30, fontWeight: FontWeight.bold),
                        ),
                      ),
                    )
                  ],
                ),
                // 1era fila botones
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // 7
                    accionBoton("7"),
                    // 8
                    accionBoton("8"),
                    // 9
                    accionBoton("9"),
                    // Operador /
                    accionOperador("/"),
                  ],
                ),
                // 2nda fila botones
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // 4
                    accionBoton("4"),
                    // 5
                    accionBoton("5"),
                    // 6
                    accionBoton("6"),
                    // Operador *
                    accionOperador("*"),
                  ],
                ),
                // 3era fila botones
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // 1
                    accionBoton("1"),
                    // 2
                    accionBoton("2"),
                    // 3
                    accionBoton("3"),
                    // Operador -
                    accionOperador("-"),
                  ],
                ),
                // 4arta fila botones
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // CLEAR
                    InkWell(
                      onTap: () {
                        setState(() {
                          pantalla = "";
                        });
                        print("Clear");
                        op1 = "";
                        op2 = "";
                        operador = 0;
                        operadorPulsado = 0;
                      },
                      child: mostrarContenedor("C", true),
                    ),
                    // 0
                    accionBoton("0"),
                    // Operador +
                    accionOperador("+"),
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
                          setState(() {
                            pantalla = resultado.toString();
                          });
                          // Reinicio variables
                          op1 = resultado.toString();
                          op2 = "";
                          operador = 0;
                          operadorPulsado = 2;
                        }
                      },
                      child: mostrarContenedor("=", true),
                    ),
                  ],
                )
              ],
            )));
  }

  Widget accionBoton(String num) {
    return InkWell(
      onTap: () {
        setState(() {
          pantalla += num;
        });

        print(num);
        if (operadorPulsado == 0) {
          op1 += num;
        } else if (operadorPulsado == 1) {
          op2 += num;
        } else {
          op1 = num;
          operadorPulsado = 0;
          setState(() {
            pantalla = num;
          });
        }
      },
      child: mostrarContenedor(num, false),
    );
  }

  Widget accionOperador(String signo) {
    int operadorSelec = 0;
    if (signo == "+") {
      operadorSelec = 1;
    } else if (signo == "-") {
      operadorSelec = 2;
    } else if (signo == "*") {
      operadorSelec = 3;
    } else {
      operadorSelec = 4;
    }

    return InkWell(
        onTap: () {
          setState(() {
            pantalla += signo;
          });
          print(signo);
          if (op1 != "") {
            operador = operadorSelec;
            operadorPulsado = 1;
          } else {
            print("Falta el primer operando");
          }
        },
        child: mostrarContenedor(signo, true));
  }
}

Widget mostrarContenedor(String texto, bool blanco) {
  return Container(
    width: 100,
    height: 100,
    margin: EdgeInsets.all(10),
    child: Center(child: Text(texto, style: TextStyle(fontSize: 20))),
    decoration: BoxDecoration(
        color: blanco ? Colors.white : const Color.fromARGB(255, 174, 174, 174),
        border: Border.all(color: Colors.black, width: 2),
        borderRadius: BorderRadius.all(Radius.circular(15.0))),
  );
}



