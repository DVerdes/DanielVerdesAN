package org.example;

import java.io.*;
import java.net.Socket;

/**
 * Clase que implementa parte comunicación servidor en un hilo
 */
public class HiloServidor extends Thread {

    private Socket clienteConectado;// Socket del cliente
    private int idCliente; // Id del cliente

    public HiloServidor(Socket clienteConectado, int idCliente) {
        this.clienteConectado = clienteConectado;
        this.idCliente = idCliente;
    }// Constructor


    @Override
    public void run() {
        boolean desconexion = false;
        try {
            // Flujo de entrada del cliente
            InputStream entrada = null;
            entrada = clienteConectado.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);

            // Flujo de salida al cliente
            OutputStream salida = null;
            salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);


            // MENSAJE "HOLA"
            String mensajeCliente = flujoEntrada.readUTF();

            if ("HOLA".contains(mensajeCliente)) {
                System.out.println("Cliente " + this.idCliente + ": " + mensajeCliente);

                //Enviar ID cliente
                flujoSalida.writeUTF("Número ID Cliente: " + idCliente);
            }

            // Mientras no se desconecte el cliente
            while (!desconexion) {
                //Cliente envia instrucción (TRANSFERIR O DESCONECTAR)
                mensajeCliente = flujoEntrada.readUTF();
                System.out.println("Cliente " + this.idCliente + ": " + mensajeCliente);

                // MENSAJE "TRANSFERIR"
                if ("TRANSFERIR".equals(mensajeCliente)) {
                    flujoSalida.writeUTF("ACK");

                    // Se reenvía nombre de archivo
                    String nombreArchivo = flujoEntrada.readUTF();
                    System.out.println("Cliente " + this.idCliente + ": " + nombreArchivo);
                    flujoSalida.writeUTF(nombreArchivo);

                    // Se verifica nombre fichero
                    mensajeCliente = flujoEntrada.readUTF();
                    if ("OK".equals(mensajeCliente)) {
                        System.out.println("Cliente " + this.idCliente + ": " + mensajeCliente);
                        flujoSalida.writeUTF("ACK");

                        long longitudFichero = flujoEntrada.readLong();
                        // Servidor recibe el fichero
                        recibirArchivo(nombreArchivo, clienteConectado, longitudFichero);

                        // Servidor envía ACK al cliente
                        flujoSalida.writeUTF(("ACK"));
                        String menCliente = flujoEntrada.readUTF();
                        if ("OK".equals(menCliente))
                            System.out.println("Cliente " + this.idCliente + ": " + menCliente);

                    } else {
                        // Archivo no coincidente
                        System.out.println("Fichero no verificado");
                        flujoSalida.writeUTF(nombreArchivo);
                    }
                }

                // MENSAJE "DESCONECTAR"
                if ("DESCONECTAR".equals(mensajeCliente)) {
                    flujoSalida.writeUTF("Desconexión");

                    mensajeCliente = flujoEntrada.readUTF();
                    System.out.println("Cliente " + this.idCliente + ": " + mensajeCliente);

                    flujoSalida.writeUTF("Procesando desconexion");


                    flujoSalida.writeUTF("Desconexión activada");

                    mensajeCliente = flujoEntrada.readUTF();
                    System.out.println("Cliente " + this.idCliente + ": " + mensajeCliente);


                    if ("ACK".equals(mensajeCliente)) {
                        // Cierra conexión cliente
                        System.out.println("Cerrando conexión cliente " + idCliente);
                        desconexion = true;
                    }
                }
            }

        // CERRAR STREAMS Y SOCKETS
            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            clienteConectado.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * Recibe archivo del cliente
     *
     * @param fileName        nombre fichero
     * @param socket          socket cliente
     * @param longitudFichero longitud fichero
     */
    void recibirArchivo(String fileName, Socket socket, long longitudFichero) {
        try {
            InputStream is = socket.getInputStream();//Input Stream
            String ruta = "ficheros/" + "SERVERXXX" + fileName;//Ruta para guardar achivo
            File f = new File(ruta);//File
            FileOutputStream fos = new FileOutputStream(f);//FileOutputStream
            int count;
            // Lectura/guardado fichero
            for (int i = 0; i < longitudFichero; i++) {
                count = is.read();

                fos.write(count);
            }
            // Cerrando recurso
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
