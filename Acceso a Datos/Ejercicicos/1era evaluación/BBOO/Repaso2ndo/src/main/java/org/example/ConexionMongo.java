package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConexionMongo {


    public static MongoCollection<Document> conectar(){

        MongoClient cliente = null;


            cliente = MongoClients.create("mongodb://localhost:27017/pruebas");
            MongoDatabase conexion = cliente.getDatabase("Repaso");

            //Colección mongo
            MongoCollection<Document> colMongo = conexion.getCollection("Usuarios");

            return colMongo;

    }

    public static void desconectarMongo(){

        MongoClient cliente = null;

        try{
            cliente = MongoClients.create("mongodb://localhost:27017/pruebas");
            MongoDatabase conexion = cliente.getDatabase("Repaso");

            //Colección mongo
            MongoCollection<Document> colMongo = conexion.getCollection("Usuarios");

        }finally {
            if(cliente!=null){
                cliente.close();
            }
        }






    }

}
