import 'dart:math';

import 'package:flutter/material.dart';
import 'package:pazaak/carta.dart';

class JuegoPazaak extends StatefulWidget {
  State<JuegoPazaak> createState() => Pazaak();
}

class Pazaak extends State<JuegoPazaak> {
  @override
  Widget build(BuildContext context) {
    String imgCarta1 = 'assets/vacio.png';
    String imgCarta2 = 'assets/vacio.png';
    String imgCarta3 = 'assets/vacio.png';
    String imgCarta4 = 'assets/vacio.png';
    String imgCarta5 = 'assets/vacio.png';
    String imgCarta6 = 'assets/vacio.png';
    String imgCarta7 = 'assets/vacio.png';
    String imgCarta8 = 'assets/vacio.png';
    String imgCarta9 = 'assets/vacio.png';

    String imgCarta1CPU = 'assets/vacio.png';
    String imgCarta2CPU = 'assets/vacio.png';
    String imgCarta3CPU = 'assets/vacio.png';
    String imgCarta4CPU = 'assets/vacio.png';
    String imgCarta5CPU = 'assets/vacio.png';
    String imgCarta6CPU = 'assets/vacio.png';
    String imgCarta7CPU = 'assets/vacio.png';
    String imgCarta8CPU = 'assets/vacio.png';
    String imgCarta9CPU = 'assets/vacio.png';

    Random random = new Random();
    List<Carta> baraja = [
      new Carta(1, "assets/carta1.png"),
      new Carta(1, "assets/carta1.png"),
      new Carta(2, "assets/carta2.png"),
      new Carta(2, "assets/carta2.png"),
      new Carta(3, "assets/carta3.png"),
      new Carta(4, "assets/carta4.png"),
      new Carta(5, "assets/carta5.png"),
      new Carta(-1, "assets/cartam1.png"),
      new Carta(-2, "assets/cartam2.png"),
      new Carta(-3, "assets/cartam3.png")
    ];

    List<Carta> cartasVerdes = [
      new Carta(1, "assets/c1.png"),
      new Carta(2, "assets/c2.png"),
      new Carta(3, "assets/c3.png"),
      new Carta(4, "assets/c4.png"),
      new Carta(5, "assets/c5.png"),
      new Carta(6, "assets/c6.png"),
      new Carta(7, "assets/c7.png"),
      new Carta(8, "assets/c8.png"),
      new Carta(9, "assets/c9.png"),
      new Carta(10, "assets/c10.png")
    ];

    cartasVerdes.shuffle();

    List<Carta> cartasVerdesJugador = cartasVerdes;

    cartasVerdes.shuffle();

    List<Carta> cartasVerdesCPU = cartasVerdes;

    int cartasEnMesaJ = 1;
    int cartasEnMesaCPU = 0;

    int sumaJugador = cartasVerdesJugador.elementAt(0).getModificador;
    int sumaCPU = 0;

    bool cartaJugada = false;

    List<Carta> mano = [];

    for (int i = 0; i < 4; i++) {
      int randomNumber = random.nextInt(baraja.length);
      mano.add(baraja.elementAt(randomNumber));
      baraja.removeAt(randomNumber);
    }

    // Fondo
    return Container(
        decoration: const BoxDecoration(
          image: DecorationImage(
              image: AssetImage('assets/fondo.jpg'), fit: BoxFit.cover),
        ),
        child: Container(
            decoration: BoxDecoration(
                gradient: LinearGradient(
                    begin: Alignment.center,
                    end: Alignment.bottomCenter,
                    colors: [
                  Color.fromARGB(66, 231, 231, 231),
                  Color.fromARGB(0, 206, 206, 235)
                ])),
            // Scaffold
            child: Scaffold(
                backgroundColor: Colors.transparent,
                //appBar
                appBar: AppBar(
                    title: new Center(
                  child: Text("Pazaak"),
                )),
                //Body
                body: Center(
                  child: Container(
                      margin: EdgeInsets.fromLTRB(0, 20, 0, 0),
                      child: Column(
                        children: [
                          Row(
                            children: [
                              Container(
                                margin: EdgeInsets.all(
                                    MediaQuery.of(context).size.width * 0.025),
                                child: Column(
                                  mainAxisAlignment:
                                      MainAxisAlignment.spaceAround,
                                  children: [
                                    Row(
                                      children: [
                                        Column(
                                          children: [
                                            Container(
                                              margin: EdgeInsets.fromLTRB(
                                                  0,
                                                  0,
                                                  MediaQuery.of(context)
                                                          .size
                                                          .width *
                                                      0.05,
                                                  0),
                                              child: Image.asset(
                                                  'assets/indicadoresj1_000.png'),
                                              width: MediaQuery.of(context)
                                                      .size
                                                      .width *
                                                  0.3,
                                            )
                                          ],
                                        ),
                                        Column(
                                          children: [
                                            Text(sumaJugador.toString())
                                          ],
                                        )
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(
                                            context,
                                            cartasVerdesJugador
                                                .elementAt(0)
                                                .getRutaImg),
                                        getCardTile(context, imgCarta2),
                                        getCardTile(context, imgCarta3),
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(context, imgCarta4),
                                        getCardTile(context, imgCarta5),
                                        getCardTile(context, imgCarta6),
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(context, imgCarta7),
                                        getCardTile(context, imgCarta8),
                                        getCardTile(context, imgCarta9),
                                      ],
                                    )
                                  ],
                                ),
                              ),
                              Container(
                                margin: EdgeInsets.all(
                                    MediaQuery.of(context).size.width * 0.025),
                                child: Column(
                                  mainAxisAlignment:
                                      MainAxisAlignment.spaceAround,
                                  children: [
                                    Row(
                                      children: [
                                        Column(
                                          children: [Text("0")],
                                        ),
                                        Column(
                                          children: [
                                            Container(
                                              margin: EdgeInsets.fromLTRB(
                                                  MediaQuery.of(context)
                                                          .size
                                                          .width *
                                                      0.05,
                                                  0,
                                                  MediaQuery.of(context)
                                                          .size
                                                          .width *
                                                      0.01,
                                                  0),
                                              child: Image.asset(
                                                  'assets/indicadoresj2_000.png'),
                                              width: MediaQuery.of(context)
                                                      .size
                                                      .width *
                                                  0.3,
                                            )
                                          ],
                                        )
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(context, imgCarta1CPU),
                                        getCardTile(context, imgCarta2CPU),
                                        getCardTile(context, imgCarta3CPU),
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(context, imgCarta4CPU),
                                        getCardTile(context, imgCarta5CPU),
                                        getCardTile(context, imgCarta6CPU),
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(context, imgCarta7CPU),
                                        getCardTile(context, imgCarta8CPU),
                                        getCardTile(context, imgCarta9CPU),
                                      ],
                                    )
                                  ],
                                ),
                              )
                            ],
                          ),
                          Row(
                            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                            children: [
                              Padding(
                                padding: const EdgeInsets.fromLTRB(0, 10, 0, 0),
                                child: InkWell(
                                  onTap: () {
                                    // Opciones de compra
                                  },
                                  // Cuadrado
                                  child: Container(
                                    decoration: BoxDecoration(
                                      borderRadius: BorderRadius.circular(20.0),
                                      color: Color.fromARGB(255, 167, 142, 1),
                                      border: Border.all(
                                          color:
                                              Color.fromARGB(255, 65, 64, 64),
                                          width: 5),
                                      boxShadow: [
                                        BoxShadow(
                                          color: Colors.grey.withOpacity(0.8),
                                          spreadRadius: 10,
                                          blurRadius: 12,
                                          offset: Offset(0, 3),
                                        ),
                                      ],
                                    ),
                                    height: 60,
                                    width: 155,
                                    child: Column(
                                      mainAxisAlignment:
                                          MainAxisAlignment.center,
                                      children: [
                                        // Imagen objeto

                                        Text(
                                          // Nombre objeto + cantidad?
                                          "Finalizar turno",
                                          style: TextStyle(
                                              fontWeight: FontWeight.bold),
                                        ),
                                        // Precio objeto
                                      ],
                                    ),
                                  ),
                                ),
                              ),
                              Padding(
                                padding: const EdgeInsets.fromLTRB(0, 10, 0, 0),
                                child: InkWell(
                                  onTap: () {
                                    // Opciones de compra
                                  },
                                  // Cuadrado
                                  child: Container(
                                    decoration: BoxDecoration(
                                      borderRadius: BorderRadius.circular(20.0),
                                      color: Color.fromARGB(255, 167, 142, 1),
                                      border: Border.all(
                                          color:
                                              Color.fromARGB(255, 65, 64, 64),
                                          width: 5),
                                      boxShadow: [
                                        BoxShadow(
                                          color: Colors.grey.withOpacity(0.8),
                                          spreadRadius: 10,
                                          blurRadius: 12,
                                          offset: Offset(0, 3),
                                        ),
                                      ],
                                    ),
                                    height: 60,
                                    width: 155,
                                    child: Column(
                                      mainAxisAlignment:
                                          MainAxisAlignment.center,
                                      children: [
                                        // Imagen objeto

                                        Text(
                                          // Nombre objeto + cantidad?
                                          "Plantarse",
                                          style: TextStyle(
                                              fontWeight: FontWeight.bold),
                                        ),
                                        // Precio objeto
                                      ],
                                    ),
                                  ),
                                ),
                              )
                            ],
                          ),
                          Container(
                            margin: EdgeInsets.fromLTRB(0, 30, 0, 30),
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                getCPUCardTile(context, 0.2),
                                getCPUCardTile(context, 0.2),
                                getCPUCardTile(context, 0.2),
                                getCPUCardTile(context, 0.2)
                              ],
                            ),
                          ),
                          Container(
                            margin: EdgeInsets.fromLTRB(0, 30, 0, 30),
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                getPlayerCardTile(
                                    context, 0.24, mano.elementAt(0)),
                                getPlayerCardTile(
                                    context, 0.24, mano.elementAt(1)),
                                getPlayerCardTile(
                                    context, 0.24, mano.elementAt(2)),
                                getPlayerCardTile(
                                    context, 0.24, mano.elementAt(3))
                              ],
                            ),
                          )
                        ],
                      )),
                ))));
  }

  getCardTile(BuildContext context, String rutaImg) {
    return Container(
      width: MediaQuery.of(context).size.width * 0.15,
      child: Image.asset(rutaImg),
    );
  }

  getPlayerCardTile(BuildContext context, double multi, Carta carta) {
    return InkWell(
      onDoubleTap: () {
        setState(() {});
      },
      child: Container(
        width: MediaQuery.of(context).size.width * multi,
        child: Image.asset(carta.getRutaImg),
      ),
    );
  }

  getCPUCardTile(BuildContext context, double multi) {
    return Container(
      width: MediaQuery.of(context).size.width * multi,
      child: Image.asset('assets/vacio.png'),
    );
  }
}
