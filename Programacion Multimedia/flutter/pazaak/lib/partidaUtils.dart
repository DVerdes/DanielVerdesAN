import 'dart:math';

import 'package:pazaak/carta.dart';

class PartidaUtils {
  static List<Carta> baraja = [
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

  static List<Carta> cartasVerdes = [
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

  static List<Carta> cartasVerdes2 = [
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

  static List<Carta> cartasVerdesJugador = [];

  static List<Carta> cartasVerdesCPU = [];

  static List<Carta> mano = [];

  static List<Carta> manoCPU = [];

  static List<Carta> cartasJugadasJ = [
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png")
  ];
  static List<Carta> cartasJugadasCPU = [
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png"),
    new Carta(0, "assets/vacio.png")
  ];

  static int cartasEnMesaJ = 1;
  static int cartasEnMesaCPU = 0;

  static int sumaJugador = 0;
  static int sumaCPU = 0;

  static bool cartaJugada = false;
  static int ronda = 1;

  static void repartirManos() {
    Random random = new Random();

    cartasVerdes.shuffle();
    cartasVerdesJugador = cartasVerdes;
    cartasVerdes2.shuffle();
    cartasVerdesCPU = cartasVerdes2;

    for (int i = 0; i < 4; i++) {
      int randomNumber = random.nextInt(baraja.length);
      mano.add(baraja.elementAt(randomNumber));
      baraja.removeAt(randomNumber);
    }

    for (int i = 0; i < 4; i++) {
      int randomNumber = random.nextInt(baraja.length);
      manoCPU.add(baraja.elementAt(randomNumber));
      baraja.removeAt(randomNumber);
    }

    cartasJugadasJ[0] = cartasVerdesJugador.elementAt(0);
  }
}