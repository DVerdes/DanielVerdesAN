package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Clase para gestión de objetos Escena en MongoDB
 */
public class EscenaCRUD {

    /**
     * Convierte Escena a Documento
     * @param escena Escena a convertir
     * @return documento
     */
    public static Document escenaADoc(Escena escena){

        if (escena==null) return null;

        Gson gson = new GsonBuilder().create();
        Document documento = Document.parse(gson.toJson(escena));


        return documento;

    }

    /**
     * Convierte documento a Escena
     * @param documento a convertir
     * @return Escena
     */
    public static Escena docAEscena(Document documento){

        if(documento==null) return null;

        Gson gson = new GsonBuilder().create();
        Escena escena = gson.fromJson(documento.toJson(), Escena.class);

        return escena;
    }

    /**
     * Elimina Escena de colección
     * @param colMongo colección
     * @param id identificador de Escena
     */
    public static void eliminarEscena(MongoCollection<Document> colMongo, int id) {
        try {

            colMongo.deleteOne(eq("id", id));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Consulta Escena de Colección
     * @param colMongo colección
     * @param id identificador de Escena
     * @return Escena a consultar
     */
    public static Escena consultarEscena(MongoCollection<Document> colMongo, int id) {
        Document documento = colMongo.find(eq("id",id)).first();
        return docAEscena(documento);
    }

    /**
     * Actualizar Escena de Colección
     * @param colMongo colección
     * @param escena Escena a actualizar
     */
    public static void actualizarEscena(MongoCollection<Document> colMongo, Escena escena) {
        Document documento = escenaADoc(escena);

        try {
            colMongo.replaceOne(eq("id",escena.getId()), documento);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Listar Escenas de colección Mongo
     * @param colMongo colección
     * @return listado de Escenas
     */
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

    /**
     * Añade Escena a colección
     * @param colMongo colección
     * @param escena Escena a añadir
     */
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
