package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class EscenaCRUD {

    public static Document escenaADoc(Escena escena){

        if (escena==null) return null;

        Gson gson = new GsonBuilder().create();
        Document documento = Document.parse(gson.toJson(escena));


        return documento;

    }


    public static Escena docAEscena(Document documento){

        if(documento==null) return null;

        Gson gson = new GsonBuilder().create();
        Escena escena = gson.fromJson(documento.toJson(), Escena.class);

        return escena;
    }

    public static void eliminarEscena(MongoCollection<Document> colMongo, int id) {
        try {

            colMongo.deleteOne(eq("id", id));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Escena consultarEscena(MongoCollection<Document> colMongo, int id) {
        Document documento = colMongo.find(eq("id",id)).first();
        return docAEscena(documento);
    }

    public static void actualizarEscena(MongoCollection<Document> colMongo, Escena escena) {
        Document documento = escenaADoc(escena);

        try {
            colMongo.replaceOne(eq("id",escena.getId()), documento);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Escena> listarEscenas(MongoCollection<Document> colMongo) {
        List<Escena> escenas = new ArrayList<>();

        List<Document> documentos = colMongo.find().into(new ArrayList<Document>());
        Escena escena;
        for(Document documento : documentos){
            escena = docAEscena(documento);
            escenas.add(escena);
        }

        return escenas;
    }

    public static void insertarEscena(MongoCollection<Document> colMongo, Escena escena) {
        Document documento = escenaADoc(escena);

        try{
            if(consultarEscena(colMongo, escena.getId())==null){
                colMongo.insertOne(documento);
            }else{
                System.out.println("Error: No se puede insertar "+escena.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
