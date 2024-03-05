package org.example;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
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
        System.setProperty("javax.net.ssl.keyStore", "AlmacenSSL");
        System.setProperty("javax.net.ssl.keyStorePassword", "1234567");


        //SSLServerSocketFactory
        SSLServerSocketFactory ssfact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault ();

        // ServerSocket
        SSLServerSocket servidorSSL = (SSLServerSocket) ssfact.createServerSocket(numeroPuerto);


        SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault () ;//SSLSocketFactory

        // Socket del cliente
        SSLSocket clienteConectado =  null; //SSLSocket
        // Bucle para estar a la espera de nuevos clientes
        while (true){
            System.out.println("Esperando al cliente ");
            // Socket aceptado
            clienteConectado = (SSLSocket) servidorSSL.accept();
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