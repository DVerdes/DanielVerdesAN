import 'dart:async';
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:pazaak/carta.dart';
import 'package:pazaak/partidaUtils.dart';
import 'package:audioplayers/audioplayers.dart';

class JuegoPazaak extends StatefulWidget {
  static bool botonActivo = true;
  static String rutaContadorJ = 'assets/indicadoresj1_000.png';
  static String rutaContadorCPU = 'assets/indicadoresj2_000.png';

  State<JuegoPazaak> createState() => Pazaak();
}

class Pazaak extends State<JuegoPazaak> {
  @override
  Widget build(BuildContext context) {
    sumaPuntosJugador();
    sumaPuntosCPU();
    actualizarContadores();

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

                //Body
                body: Center(
                  child: Container(
                      margin: EdgeInsets.fromLTRB(0, 50, 0, 0),
                      child: Column(
                        children: [
                          Row(
                            children: [
                              Container(
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(10.0),
                                  color: Color.fromARGB(255, 167, 142, 1),
                                  border: Border.all(
                                      color: PartidaUtils.jugadorPlantado
                                          ? Color.fromARGB(255, 2, 74, 207)
                                          : Color.fromARGB(255, 65, 64, 64),
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
                                margin: EdgeInsets.fromLTRB(
                                    MediaQuery.of(context).size.width * 0.005,
                                    0,
                                    MediaQuery.of(context).size.width * 0.007,
                                    0),
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
                                              child: Container(
                                                margin: EdgeInsets.fromLTRB(
                                                    0,
                                                    MediaQuery.of(context)
                                                            .size
                                                            .height *
                                                        0.003,
                                                    0,
                                                    0),
                                                decoration: BoxDecoration(
                                                  borderRadius:
                                                      BorderRadius.circular(
                                                          5.0),
                                                  color: Color.fromARGB(
                                                      255, 167, 142, 1),
                                                  border: Border.all(
                                                      color: Color.fromARGB(
                                                          255, 109, 102, 1),
                                                      width: 1),
                                                ),
                                                child: Image.asset(
                                                    JuegoPazaak.rutaContadorJ),
                                              ),
                                              width: MediaQuery.of(context)
                                                      .size
                                                      .width *
                                                  0.3,
                                            )
                                          ],
                                        ),
                                        Column(
                                          children: [
                                            Container(
                                                margin: EdgeInsets.fromLTRB(
                                                    0,
                                                    MediaQuery.of(context)
                                                            .size
                                                            .height *
                                                        0.003,
                                                    0,
                                                    0),
                                                padding: EdgeInsets.fromLTRB(
                                                    MediaQuery.of(context)
                                                            .size
                                                            .width *
                                                        0.03,
                                                    MediaQuery.of(context)
                                                            .size
                                                            .height *
                                                        0.01,
                                                    MediaQuery.of(context)
                                                            .size
                                                            .width *
                                                        0.03,
                                                    MediaQuery.of(context)
                                                            .size
                                                            .height *
                                                        0.01),
                                                decoration: BoxDecoration(
                                                  borderRadius:
                                                      BorderRadius.circular(
                                                          100.0),
                                                  color: Color.fromARGB(
                                                      255, 0, 0, 0),
                                                  border: Border.all(
                                                      color: Color.fromARGB(
                                                          255, 153, 153, 153),
                                                      width: 2),
                                                ),
                                                child: Text(
                                                  PartidaUtils.sumaJugador >= 10
                                                      ? PartidaUtils.sumaJugador
                                                          .toString()
                                                      : "0" +
                                                          PartidaUtils
                                                              .sumaJugador
                                                              .toString(),
                                                  style: TextStyle(
                                                      color: Color.fromARGB(
                                                          202, 255, 255, 255)),
                                                ))
                                          ],
                                        )
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasJ
                                                .elementAt(0)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasJ
                                                .elementAt(1)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasJ
                                                .elementAt(2)
                                                .getRutaImg),
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasJ
                                                .elementAt(3)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasJ
                                                .elementAt(4)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasJ
                                                .elementAt(5)
                                                .getRutaImg),
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasJ
                                                .elementAt(6)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasJ
                                                .elementAt(7)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasJ
                                                .elementAt(8)
                                                .getRutaImg),
                                      ],
                                    )
                                  ],
                                ),
                              ),
                              Container(
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(10.0),
                                  color: Color.fromARGB(255, 167, 142, 1),
                                  border: Border.all(
                                      color: PartidaUtils.cpuPlantado
                                          ? Color.fromARGB(255, 180, 2, 2)
                                          : Color.fromARGB(255, 65, 64, 64),
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
                                margin: EdgeInsets.fromLTRB(
                                    MediaQuery.of(context).size.width * 0.007,
                                    0,
                                    MediaQuery.of(context).size.width * 0.005,
                                    0),
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
                                                    MediaQuery.of(context).size.height *
                                                        0.003,
                                                    0,
                                                    0),
                                                padding: EdgeInsets.fromLTRB(
                                                    MediaQuery.of(context).size.width *
                                                        0.03,
                                                    MediaQuery.of(context).size.height *
                                                        0.01,
                                                    MediaQuery.of(context)
                                                            .size
                                                            .width *
                                                        0.03,
                                                    MediaQuery.of(context)
                                                            .size
                                                            .height *
                                                        0.01),
                                                decoration: BoxDecoration(
                                                  borderRadius:
                                                      BorderRadius.circular(
                                                          100.0),
                                                  color: Color.fromARGB(
                                                      255, 0, 0, 0),
                                                  border: Border.all(
                                                      color: Color.fromARGB(
                                                          255, 153, 153, 153),
                                                      width: 2),
                                                ),
                                                child: Text(
                                                    PartidaUtils.sumaCPU >= 10
                                                        ? PartidaUtils.sumaCPU
                                                            .toString()
                                                        : "0" +
                                                            PartidaUtils.sumaCPU
                                                                .toString(),
                                                    style: TextStyle(color: Color.fromARGB(202, 255, 255, 255))))
                                          ],
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
                                                    0,
                                                    0),
                                                child: Container(
                                                  margin: EdgeInsets.fromLTRB(
                                                      0,
                                                      MediaQuery.of(context)
                                                              .size
                                                              .height *
                                                          0.003,
                                                      0,
                                                      0),
                                                  decoration: BoxDecoration(
                                                    borderRadius:
                                                        BorderRadius.circular(
                                                            5.0),
                                                    color: Color.fromARGB(
                                                        255, 167, 142, 1),
                                                    border: Border.all(
                                                        color: Color.fromARGB(
                                                            255, 109, 102, 1),
                                                        width: 1),
                                                  ),
                                                  child: Image.asset(JuegoPazaak
                                                      .rutaContadorCPU),
                                                  width: MediaQuery.of(context)
                                                          .size
                                                          .width *
                                                      0.3,
                                                ))
                                          ],
                                        )
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasCPU
                                                .elementAt(0)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasCPU
                                                .elementAt(1)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasCPU
                                                .elementAt(2)
                                                .getRutaImg),
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasCPU
                                                .elementAt(3)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasCPU
                                                .elementAt(4)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasCPU
                                                .elementAt(5)
                                                .getRutaImg),
                                      ],
                                    ),
                                    Row(
                                      children: [
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasCPU
                                                .elementAt(6)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasCPU
                                                .elementAt(7)
                                                .getRutaImg),
                                        getCardTile(
                                            context,
                                            PartidaUtils.cartasJugadasCPU
                                                .elementAt(8)
                                                .getRutaImg),
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
                                padding: const EdgeInsets.fromLTRB(0, 30, 0, 0),
                                child: InkWell(
                                  onTap: () {
                                    if (PartidaUtils.jugadorPlantado) {
                                      print("Te has plantado");
                                    } else {
                                      JuegoPazaak.botonActivo
                                          ? finTurno()
                                          : print(
                                              "Botón bloqueado"); //aqui turno cpu
                                    }
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
                                              fontWeight: FontWeight.bold,
                                              fontSize: 18),
                                        ),
                                        // Precio objeto
                                      ],
                                    ),
                                  ),
                                ),
                              ),
                              Padding(
                                padding: const EdgeInsets.fromLTRB(0, 30, 0, 0),
                                child: InkWell(
                                  onTap: () {
                                    PartidaUtils.jugadorPlantado
                                        ? print("")
                                        : plantarse();
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
                                              fontWeight: FontWeight.bold,
                                              fontSize: 18),
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
                            width: MediaQuery.of(context).size.width * 0.83,
                            decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(10.0),
                              color: Color.fromARGB(255, 167, 142, 1),
                              border: Border.all(
                                  color: Color.fromARGB(255, 65, 64, 64),
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
                            margin: EdgeInsets.fromLTRB(0, 30, 0, 30),
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                getCPUCardTile(context, 0.2, 0),
                                getCPUCardTile(context, 0.2, 1),
                                getCPUCardTile(context, 0.2, 2),
                                getCPUCardTile(context, 0.2, 3)
                              ],
                            ),
                          ),
                          Container(
                            width: MediaQuery.of(context).size.width * 0.99,
                            decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(10.0),
                              color: Color.fromARGB(255, 167, 142, 1),
                              border: Border.all(
                                  color: Color.fromARGB(255, 65, 64, 64),
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
                            margin: EdgeInsets.fromLTRB(0, 10, 0, 30),
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                getPlayerCardTile(context, 0.24,
                                    PartidaUtils.mano.elementAt(0), 0),
                                getPlayerCardTile(context, 0.24,
                                    PartidaUtils.mano.elementAt(1), 1),
                                getPlayerCardTile(context, 0.24,
                                    PartidaUtils.mano.elementAt(2), 2),
                                getPlayerCardTile(context, 0.24,
                                    PartidaUtils.mano.elementAt(3), 3)
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

  getPlayerCardTile(
      BuildContext context, double multi, Carta carta, int posicion) {
    return InkWell(
      onDoubleTap: () {
        bajarCarta(carta, posicion);
        setState(() {});
      },
      child: Container(
        width: MediaQuery.of(context).size.width * multi,
        child: Image.asset(carta.getRutaImg),
      ),
    );
  }

  getCPUCardTile(BuildContext context, double multi, int posicion) {
    String rutaImg = 'assets/vacio.png';
    if (PartidaUtils.manoCPU.elementAt(posicion).getModificador != 0) {
      rutaImg = 'assets/backcard.png';
    }

    return Container(
      width: MediaQuery.of(context).size.width * multi,
      child: Image.asset(rutaImg),
    );
  }

  void sumaPuntosJugador() {
    PartidaUtils.sumaJugador =
        PartidaUtils.cartasJugadasJ.elementAt(0).getModificador +
            PartidaUtils.cartasJugadasJ.elementAt(1).getModificador +
            PartidaUtils.cartasJugadasJ.elementAt(2).getModificador +
            PartidaUtils.cartasJugadasJ.elementAt(3).getModificador +
            PartidaUtils.cartasJugadasJ.elementAt(4).getModificador +
            PartidaUtils.cartasJugadasJ.elementAt(5).getModificador +
            PartidaUtils.cartasJugadasJ.elementAt(6).getModificador +
            PartidaUtils.cartasJugadasJ.elementAt(7).getModificador +
            PartidaUtils.cartasJugadasJ.elementAt(8).getModificador +
            PartidaUtils.cartasJugadasJ.elementAt(9).getModificador;
  }

  void sumaPuntosCPU() {
    PartidaUtils.sumaCPU =
        PartidaUtils.cartasJugadasCPU.elementAt(0).getModificador +
            PartidaUtils.cartasJugadasCPU.elementAt(1).getModificador +
            PartidaUtils.cartasJugadasCPU.elementAt(2).getModificador +
            PartidaUtils.cartasJugadasCPU.elementAt(3).getModificador +
            PartidaUtils.cartasJugadasCPU.elementAt(4).getModificador +
            PartidaUtils.cartasJugadasCPU.elementAt(5).getModificador +
            PartidaUtils.cartasJugadasCPU.elementAt(6).getModificador +
            PartidaUtils.cartasJugadasCPU.elementAt(7).getModificador +
            PartidaUtils.cartasJugadasCPU.elementAt(8).getModificador +
            PartidaUtils.cartasJugadasCPU.elementAt(9).getModificador;
  }

  void bajarCarta(Carta carta, int posicion) {
    if (carta.getModificador == 0) {
      print("carta vacia...");
    } else if (PartidaUtils.cartasEnMesaJ >= 9 ||
        PartidaUtils.cartaJugada ||
        PartidaUtils.jugadorPlantado) {
      print("No se pueden bajar más");
    } else {
      playMusic("jugar_carta.wav");

      PartidaUtils.cartasJugadasJ[PartidaUtils.cartasEnMesaJ] = carta;
      PartidaUtils.cartaJugada = true;
      PartidaUtils.cartasEnMesaJ++;
      PartidaUtils.mano[posicion] = new Carta(0, 'assets/vacio.png');
    }
  }

  void bajarCartaVerdeJugador() {
    //sleep(1000 as Duration);
    if (PartidaUtils.cartasEnMesaJ >= 9) {
      print("No bjar más");
    } else if (PartidaUtils.sumaJugador >= 20) {
    } else {
      playMusic("carta_verde.wav");

      PartidaUtils.cartasJugadasJ[PartidaUtils.cartasEnMesaJ] =
          PartidaUtils.cartasVerdesJugador.elementAt(PartidaUtils.ronda);
      PartidaUtils.ronda++;
      PartidaUtils.cartasEnMesaJ++;
    }
  }

  void bajarCartaVerdeCPU() {
    //sleep(1000 as Duration);
    if (PartidaUtils.cartasEnMesaCPU >= 9) {
      print("No bjar más");
    } else {
      PartidaUtils.cartasJugadasCPU[PartidaUtils.cartasEnMesaCPU] =
          PartidaUtils.cartasVerdesCPU.elementAt(PartidaUtils.ronda);
      playMusic("carta_verde.wav");
      PartidaUtils.cartaJugadaCPU = false;

      PartidaUtils.cartasEnMesaCPU++;
      //AQUI DECISIÓN CPU
      sumaPuntosCPU();
      if (decisionCPU() == 1) PartidaUtils.cpuPlantado = true;
      sumaPuntosCPU();
    }
  }

  int decisionCPU() {
    for (int i = 0; i < 4; i++) {
      int valorCarta = PartidaUtils.manoCPU.elementAt(i).getModificador;
      if (valorCarta + PartidaUtils.sumaCPU == 20 && valorCarta != 0) {
        //jugar carta
        bajarCartaCPU(PartidaUtils.manoCPU.elementAt(i), i);
        print("Bajar carta " + valorCarta.toString());
        return 1;
      }
    }
    for (int i = 0; i < 4; i++) {
      int valorCarta = PartidaUtils.manoCPU.elementAt(i).getModificador;
      if (valorCarta + PartidaUtils.sumaCPU == 19 && valorCarta != 0) {
        //jugar carta y plantarse??
        bajarCartaCPU(PartidaUtils.manoCPU.elementAt(i), i);

        return 1;
      }
    }
    if (PartidaUtils.sumaCPU >= 20) return 1;

    if (PartidaUtils.sumaCPU >= 18 &&
        PartidaUtils.sumaJugador <= PartidaUtils.sumaCPU) return 1;

    return 0;
  }

  void bajarCartaCPU(Carta carta, int posicion) {
    if (carta.getModificador == 0) {
      print("carta vacia...");
    } else if (PartidaUtils.cartasEnMesaCPU >= 9 ||
        PartidaUtils.cartaJugadaCPU) {
      print("No se pueden bajar más");
    } else {
      PartidaUtils.cartaJugadaCPU = true;
      PartidaUtils.cartasJugadasCPU[PartidaUtils.cartasEnMesaCPU] = carta;
      PartidaUtils.cartasEnMesaCPU++;
      PartidaUtils.manoCPU[posicion] = new Carta(0, 'assets/vacio.png');
    }
  }

  finTurno() {
    JuegoPazaak.botonActivo = false;
    if (!PartidaUtils.cpuPlantado) {
      bajarCartaVerdeCPU();
      setState(() {});
    }
    setState(() {});

    //vuelta turno jugador
    PartidaUtils.cartaJugada = false;

    Timer(Duration(seconds: 1), () {
      bajarCartaVerdeJugador();
      setState(() {});
      JuegoPazaak.botonActivo = true;
    });

    setState(() {});
    print("Mano CPU: " +
        PartidaUtils.manoCPU.elementAt(0).getModificador.toString() +
        " " +
        PartidaUtils.manoCPU.elementAt(1).getModificador.toString() +
        " " +
        PartidaUtils.manoCPU.elementAt(2).getModificador.toString() +
        " " +
        PartidaUtils.manoCPU.elementAt(3).getModificador.toString());

    if (PartidaUtils.sumaJugador >= 20) plantarse();
  }

  plantarse() async {
    //playMusic("plantarse.wav");
    PartidaUtils.jugadorPlantado = true;
    while (!PartidaUtils.cpuPlantado) {
      bajarCartaVerdeCPU();
      PartidaUtils.ronda++;
      setState(() {});
      await Future.delayed(const Duration(seconds: 2));
    }

    print("CPU plantada");

    comprobarVictoriaRonda();
  }

  void comprobarVictoriaRonda() {
    int distanciaJugador = 0;
    int distanciaCPU = 0;
    if (PartidaUtils.sumaJugador > 20) {
      distanciaJugador = PartidaUtils.sumaJugador - 20;
    } else if (PartidaUtils.sumaJugador < 20)
      distanciaJugador = 20 - PartidaUtils.sumaJugador;

    if (PartidaUtils.sumaCPU > 20) {
      distanciaCPU = PartidaUtils.sumaCPU - 20;
    } else if (PartidaUtils.sumaCPU < 20)
      distanciaCPU = 20 - PartidaUtils.sumaCPU;

    print(distanciaJugador);
    print(distanciaCPU);

    if (distanciaJugador == distanciaCPU) {
      print("Ronda empatada");

      ventanaEmergente("Ronda empatada");
    } else if (distanciaJugador < distanciaCPU) {
      print("Gana la ronda el jugador");
      playMusic("ganar_ronda.wav");
      ventanaEmergente("El jugador gana la ronda!");

      PartidaUtils.victoriasJugador++;
      PartidaUtils.puntuacionMinijuego += 50;
    } else {
      print("Gana la ronda la cpu");
      playMusic("perder_ronda.wav");

      ventanaEmergente("La CPU gana la ronda");

      PartidaUtils.victoriasCPU++;
    }

    if (PartidaUtils.victoriasJugador >= 3) {
      PartidaUtils.puntuacionMinijuego += 50;
      playMusic("ganar_partida.wav");

      ventanaFinPartida("¡El jugador gana la partida!");
    }

    if (PartidaUtils.victoriasCPU >= 3) {
      playMusic("perder_partida.wav");

      ventanaFinPartida("¡Has perdido!");
    }

    setState(() {});
  }

  Future ventanaEmergente(String ganador) => showDialog(
      context: this.context,
      builder: ((context) => AlertDialog(
            shape: BeveledRectangleBorder(
                side: BorderSide(
                    color: Color.fromARGB(255, 65, 64, 64), width: 5),
                borderRadius:
                    BorderRadius.only(bottomLeft: Radius.circular(30))),
            backgroundColor: Color.fromARGB(255, 167, 142, 1),
            title: Text("Fin de ronda"),
            content: Text(ganador),
            actions: [
              TextButton(
                  onPressed: () {
                    PartidaUtils.reiniciarRonda();
                    setState(() {});
                    Navigator.pop(context);
                  },
                  child: Text(
                    "Continuar",
                    style: TextStyle(color: Color.fromARGB(255, 65, 64, 64)),
                  ))
            ],
          )));

  void actualizarContadores() {
    switch (PartidaUtils.victoriasJugador) {
      case 0:
        JuegoPazaak.rutaContadorJ = 'assets/indicadoresj1_000.png';
        break;
      case 1:
        JuegoPazaak.rutaContadorJ = 'assets/indicadoresj1_100.png';
        break;
      case 2:
        JuegoPazaak.rutaContadorJ = 'assets/indicadoresj1_110.png';
        break;
      case 3:
        JuegoPazaak.rutaContadorJ = 'assets/indicadoresj1_111.png';
        break;
    }

    switch (PartidaUtils.victoriasCPU) {
      case 0:
        JuegoPazaak.rutaContadorCPU = 'assets/indicadoresj2_000.png';
        break;
      case 1:
        JuegoPazaak.rutaContadorCPU = 'assets/indicadoresj2_100.png';
        break;
      case 2:
        JuegoPazaak.rutaContadorCPU = 'assets/indicadoresj2_110.png';
        break;
      case 3:
        JuegoPazaak.rutaContadorCPU = 'assets/indicadoresj2_111.png';
        break;
    }
  }

  Future ventanaFinPartida(String ganador) => showDialog(
      context: this.context,
      builder: ((context) => AlertDialog(
            shape: BeveledRectangleBorder(
                side: BorderSide(
                    color: Color.fromARGB(255, 65, 64, 64), width: 5),
                borderRadius:
                    BorderRadius.only(bottomLeft: Radius.circular(30))),
            backgroundColor: Color.fromARGB(255, 167, 142, 1),
            title: Text("Fin de partida"),
            content: Text(ganador +
                "\nTu puntuación ha sido de " +
                PartidaUtils.puntuacionMinijuego.toString() +
                "."),
            actions: [
              TextButton(
                  onPressed: () => exit(0),
                  child: Text(
                    "Salir",
                    style: TextStyle(color: Color.fromARGB(255, 65, 64, 64)),
                  ))
            ],
          )));

  AudioPlayer player = AudioPlayer();

  playMusic(String ruta) {
    player.play(AssetSource(ruta));
  }
}
