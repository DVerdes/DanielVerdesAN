package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class PartidaCRUD {

    public static Document partidaADoc(Partida partida){

        if (partida==null) return null;

        Gson gson = new GsonBuilder().create();
        Document documento = Document.parse(gson.toJson(partida));


        return documento;

    }


    public static Partida docAPartida(Document documento){

        if(documento==null) return null;

        Gson gson = new GsonBuilder().create();
        Partida partida = gson.fromJson(documento.toJson(), Partida.class);

        return partida;
    }

    public static void eliminarPartida(MongoCollection<Document> colMongo, int id) {
        try {

            colMongo.deleteOne(eq("id", id));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Partida consultarPartida(MongoCollection<Document> colMongo, int id) {
        Document documento = colMongo.find(eq("id",id)).first();
        return docAPartida(documento);
    }

    public static void actualizarPartida(MongoCollection<Document> colMongo, Partida partida) {
        Document documento = partidaADoc(partida);

        try {
            colMongo.replaceOne(eq("id",partida.getId()), documento);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Partida> listarPartidas(MongoCollection<Document> colMongo) {
        List<Partida> partidas = new ArrayList<>();

        List<Document> documentos = colMongo.find().into(new ArrayList<Document>());
        Partida partida;
        for(Document documento : documentos){
            partida = docAPartida(documento);
            partidas.add(partida);
        }

        return partidas;
    }

    public static void insertarPartida(MongoCollection<Document> colMongo, Partida partida) {
        Document documento = partidaADoc(partida);

        try{
            if(consultarPartida(colMongo, partida.getId())==null){
                colMongo.insertOne(documento);
            }else{
                System.out.println("Error: No se puede insertar "+partida.getId());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
