import 'package:flutter/material.dart';
import 'package:formulario/inicio.dart';
import 'package:formulario/jugador.dart';
import 'registro.dart';

class Login extends StatelessWidget {
  String nombre = "";
  String pass = "";

  final formKey = GlobalKey<FormState>();
  TextEditingController nombreController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Container(
        decoration: const BoxDecoration(
          image: DecorationImage(
              image: AssetImage('assets/fondo.png'), fit: BoxFit.cover),
        ),
        child: Container(
            decoration: BoxDecoration(
                gradient: LinearGradient(
                    begin: Alignment.center,
                    end: Alignment.bottomCenter,
                    colors: [
                  Color.fromARGB(153, 231, 194, 194),
                  Color.fromARGB(229, 11, 11, 11)
                ])),
            child: Scaffold(
              appBar: AppBar(
                title: Text("Log In"),
              ),
              body: Center(
                child: Form(
                  key: formKey,
                  child: Padding(
                    padding:
                        const EdgeInsets.symmetric(horizontal: 8, vertical: 16),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Padding(
                          padding: const EdgeInsets.symmetric(
                              horizontal: 8, vertical: 16),
                          child: TextFormField(
                            controller: nombreController,
                            decoration: const InputDecoration(
                                border: OutlineInputBorder(),
                                labelText: "Nombre de usuario"),
                            validator: (value) {
                              if (value == null || value.isEmpty) {
                                return 'Por favor, introduzca un valor válido';
                              }
                              return null;
                            },
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.symmetric(
                              horizontal: 8, vertical: 16),
                          child: TextFormField(
                            controller: passwordController,
                            obscureText: true,
                            decoration: const InputDecoration(
                                border: OutlineInputBorder(),
                                labelText: "Contraseña"),
                            validator: (value) {
                              if (value == null || value.isEmpty) {
                                return 'Por favor, introduzca su contraseña';
                              }
                              return null;
                            },
                          ),
                        ),
                        Padding(
                          padding: const EdgeInsets.symmetric(
                              horizontal: 8, vertical: 16.0),
                          child: Center(
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                              children: [
                                ElevatedButton(
                                  onPressed: () {
                                    if (formKey.currentState!.validate()) {
                                      
           
                                    } else {
                                      ScaffoldMessenger.of(context)
                                          .showSnackBar(
                                        const SnackBar(
                                          content: Text(
                                              'Por favor, rellene los campos'),
                                          backgroundColor: Colors.orangeAccent,
                                        ),
                                      );
                                    }
                                  },
                                  child: const Text('Jugar'),
                                ),
                                ElevatedButton(
                                  onPressed: () {
                                    Navigator.push(
                                      context,
                                      MaterialPageRoute(
                                          builder: (context) => Registro()),
                                    );
                                  },
                                  child: const Text('Registrarse'),
                                )
                              ],
                            ),
                          ),
                        ),
                      ],
                    ),
                  ),
                ),
              ),
            )));
  }

  recogerDatos(BuildContext context) {
    if (formKey.currentState!.validate()) {
      formKey.currentState!.save();

      Navigator.of(context)
          .pushNamed("/inicio", arguments: Jugador(nombre, pass));
    }
  }
}
