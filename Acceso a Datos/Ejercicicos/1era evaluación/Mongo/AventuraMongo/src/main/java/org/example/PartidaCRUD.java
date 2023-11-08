package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 *  Clase para gestión de objetos Partida en MongoDB
 */
public class PartidaCRUD {

    /**
     * Partida a documento
     * @param partida a convertir
     * @return documento
     */
    public static Document partidaADoc(Partida partida){

        if (partida==null) return null;

        Gson gson = new GsonBuilder().create();
        Document documento = Document.parse(gson.toJson(partida));


        return documento;

    }

    /**
     * Documento a Partida
     * @param documento a convertir
     * @return Partida
     */
    public static Partida docAPartida(Document documento){

        if(documento==null) return null;

        Gson gson = new GsonBuilder().create();
        Partida partida = gson.fromJson(documento.toJson(), Partida.class);

        return partida;
    }

    /**
     * Elimina Partida de colección
     * @param colMongo colección
     * @param id identificador de Partida
     */
    public static void eliminarPartida(MongoCollection<Document> colMongo, int id) {
        try {

            colMongo.deleteOne(eq("id", id));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Consulta Partida de colección
     * @param colMongo colección
     * @param id identificador de Partida
     * @return Partida a consultar
     */
    public static Partida consultarPartida(MongoCollection<Document> colMongo, int id) {
        Document documento = colMongo.find(eq("id",id)).first();
        return docAPartida(documento);
    }

    /**
     * Actualiza Partida de colección
     * @param colMongo colección
     * @param partida Partida a actualizar
     */
    public static void actualizarPartida(MongoCollection<Document> colMongo, Partida partida) {
        Document documento = partidaADoc(partida);

        try {
            colMongo.replaceOne(eq("id",partida.getId()), documento);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Lista Partidas de colección
     * @param colMongo colección
     * @return listado de partidas
     */
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

    /**
     * Añade Partida a colección
     * @param colMongo colección
     * @param partida Partida a insertar
     */
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
