package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        MongoClient cliente = MongoClients.create("mongodb://localhost:27017/pruebas");

        try{
            MongoDatabase conexion = cliente.getDatabase("Aventura");
            MongoCollection<Document> colMongo = conexion.getCollection("Escenas");







            Escena escenaConsultada = EscenaCRUD.consultarEscena(colMongo,1);
            System.out.println("\nEscena consultada -> "+escenaConsultada.toString());



        }finally {

            if(cliente!=null){
                cliente.close();
            }
        }





    }
}
