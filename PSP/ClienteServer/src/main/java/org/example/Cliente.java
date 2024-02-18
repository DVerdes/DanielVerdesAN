package org.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Clase con parte comunicación del cliente - PROTOCOLO SOSO
 */
public class Cliente {

    public static void main(String[] args) throws Exception {

        // Scanner
        Scanner sc = new Scanner(System.in);

        String Host = "localhost";//Host (local)
        int Puerto = 6000;//puerto
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);//Socket
        String entradaUsuario = "";//Entrada escaneada del usuario
        String respuestaServidor = "";//Respuesta del servidor

// FLUJO DE SALIDA AL SERVIDOR
        DataOutputStream flujoSalida = new
                DataOutputStream(Cliente.getOutputStream());

// FLUJO DE ENTRADA DEL SERVIDOR
        DataInputStream flujoEntrada = new
                DataInputStream(Cliente.getInputStream());


        try {
            // MENSAJE "HOLA"
            flujoSalida.writeUTF("HOLA");
            // Respuesta servidor
            System.out.println("Servidor " + flujoEntrada.readUTF());


            while (true) {
                //Cliente envía instrucción (TRANSFERIR O DESCONECTAR)
                boolean instruccionCorrecta = false;
                while (!instruccionCorrecta) {
                    System.out.println("Escriba TRANSFERIR o DESCONECTAR");
                    entradaUsuario = sc.nextLine();
                    // Comprobación instrucción correcta
                    if (entradaUsuario.equals("TRANSFERIR") || entradaUsuario.equals("DESCONECTAR")) {
                        instruccionCorrecta = true;
                    }
                }
                // Envío de instrucción
                flujoSalida.writeUTF(entradaUsuario);


                // MENSAJE "TRANSFERIR"
                if (entradaUsuario.equals("TRANSFERIR")) {

                    // ACK Servidor
                    respuestaServidor = flujoEntrada.readUTF();
                    System.out.println("Servidor: " + respuestaServidor);

                    // Envío archivo
                    boolean existeArchivo = false;
                    String nombreArchivo = "";
                    while (!existeArchivo) {
                        System.out.println("Escriba nombre de archivo");
                        nombreArchivo = sc.nextLine();
                        // Comprobación fichero existe
                        existeArchivo = comprobarArchivo(nombreArchivo);
                    }
                    // Se envía nombre archivo
                    flujoSalida.writeUTF(nombreArchivo);
                    respuestaServidor = flujoEntrada.readUTF();
                    System.out.println("Servidor: " + respuestaServidor);

                    // Se verifica nombre archivo con servidor
                    if (nombreArchivo.equals(respuestaServidor)) {


                        flujoSalida.writeUTF("OK");
                        // Servidor envía ACK
                        respuestaServidor = flujoEntrada.readUTF();

                        if ("ACK".equals(respuestaServidor)) {
                            // Cliente envía fichero
                            enviarArchivo("ficheros/" + nombreArchivo, Cliente, flujoSalida);

                            // Servidor envía ACK
                            respuestaServidor = flujoEntrada.readUTF();
                            System.out.println("Servidor: " + respuestaServidor);

                            flujoSalida.writeUTF("OK");

                        }
                    }
                }

                // MENSAJE "DESCONECTAR"
                if (entradaUsuario.equals("DESCONECTAR")) {
                    //Cliente recibe confirmación
                    respuestaServidor = flujoEntrada.readUTF();
                    System.out.println("Servidor: " + respuestaServidor);


                    flujoSalida.writeUTF("CONFIRMACIÓN DESCONEXIÓN");

                    // Procesando desconexión
                    respuestaServidor = flujoEntrada.readUTF();
                    System.out.println("Servidor: " + respuestaServidor);

                    // Desconexión activada
                    respuestaServidor = flujoEntrada.readUTF();
                    System.out.println("Servidor: " + respuestaServidor);

                    // ACK + Cierre conexión

                    flujoSalida.writeUTF("ACK");
                    break;
                }


            }
            // CERRAR STREAMS Y SOCKETS
            flujoEntrada.close();
            flujoSalida.close();
            Cliente.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }// main

    /**
     * Comprueba si el fichero existe
     * @param nombreArchivo nombre del fichero
     * @return comprobación
     */
    private static boolean comprobarArchivo(String nombreArchivo) {
        File file = new File("ficheros/" + nombreArchivo);
        if (file.exists()) return true;
        else System.out.println("No existe el archivo indicado");
        return false;

    }

    /**
     * Envía fichero al Servidor
     * @param path ruta del archivo
     * @param socket socket del cliente pertinente
     * @param dataOutputStream dos del cliente
     * @throws IOException
     */
    static void enviarArchivo(String path, Socket socket, DataOutputStream dataOutputStream) throws IOException {

        int bytes = 0;
        // Se crea el fichero
        File file = new File(path);
        FileInputStream fileInputStream
                = new FileInputStream(file);

        // Se manda longitud archivo al servidor
        long longArchivo = file.length();
        dataOutputStream.writeLong(longArchivo);
        // Se envía fichero troceado
        byte[] buffer = new byte[4 * 1024];
        while ((bytes = fileInputStream.read(buffer))
                != -1) {
            // Se envía fichero al ServerSocket
            dataOutputStream.write(buffer, 0, bytes);
            dataOutputStream.flush();
        }
        // Se cierra el fis
        fileInputStream.close();
    }
} //