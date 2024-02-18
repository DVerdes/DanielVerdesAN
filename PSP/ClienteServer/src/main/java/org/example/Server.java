package org.example;

import java.io.*;
import java.net.*;

/**
 * Clase del Servidor - PROTOCOLO SOSO
 */
public class Server {

    // Contador para generar Ids autoincrementales
    static int idCliente = 0;

    public static void main(String[] arg) throws IOException {

        int numeroPuerto = 6000;// Puerto
        // ServerSocket
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        // Socket del cliente
        Socket clienteConectado = null;
        // Bucle para estar a la espera de nuevos clientes
        while (true){
            System.out.println("Esperando al cliente ");
            // Socket aceptado
            clienteConectado = servidor.accept();
            // Nuevo hilo con el código de la parte de servidor y el socket del cliente relacionado
            new HiloServidor(clienteConectado, obtenerIdCliente()).start();
        }

}

    /**
     * Genera id autoincremental para el cliente
     * @return id autoincremental
     */
    private static int obtenerIdCliente() {
        idCliente++;
        return idCliente;
    }

}