package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Clase DAO de libro con operaciones CRUD
 */
public class LibroDAO {


    /**
     * Convierte Libro a Documento
     *
     * @param libro Libro a convertir
     * @return documento
     */
    public static Document libroADoc(Libro libro) {

        if (libro == null) return null;

        Gson gson = new GsonBuilder().create();
        Document documento = Document.parse(gson.toJson(libro));


        return documento;

    }

    /**
     * Convierte documento a Libro
     *
     * @param documento a convertir
     * @return Libro
     */
    public static Libro docALibro(Document documento) {

        if (documento == null) return null;

        Gson gson = new GsonBuilder().create();
        Libro libro = gson.fromJson(documento.toJson(), Libro.class);

        return libro;
    }


    /**
     * Añade Libro a colección
     *
     * @param libro Escena a añadir
     */
    public static void insertar(Libro libro) {
        Document documento = libroADoc(libro);
        MongoClient cliente = null;

        try {
            cliente = MongoClients.create("mongodb://localhost:27017/pruebas");
            MongoDatabase conexion = cliente.getDatabase("Examen");

            //Colección mongo
            MongoCollection<Document> colMongo = conexion.getCollection("Libros");

            try {
                if (obtener(libro.getIsbn()) == null) {
                    colMongo.insertOne(documento);
                } else {
                    // Ya existe un libro con ese isbn
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (cliente != null) {
                cliente.close();
            }
        }
    }

    /**
     * Consulta Libro de Colección
     *
     * @param isbn identificador de Libro
     * @return Escena a consultar
     */
    public static Libro obtener(String isbn) {

        MongoClient cliente = null;

        try {
            cliente = MongoClients.create("mongodb://localhost:27017/pruebas");
            MongoDatabase conexion = cliente.getDatabase("Examen");

            //Colección mongo
            MongoCollection<Document> colMongo = conexion.getCollection("Libros");
            Document documento = colMongo.find(eq("isbn", isbn)).first();

            return docALibro(documento);

        } finally {
            if (cliente != null) {
                cliente.close();
            }
        }
    }

    /**
     * Actualizar Libro de Colección
     *
     * @param libro Libro a actualizar
     */
    public static void actualizar(Libro libro) {
        Document documento = libroADoc(libro);

        MongoClient cliente = null;

        try {
            cliente = MongoClients.create("mongodb://localhost:27017/pruebas");
            MongoDatabase conexion = cliente.getDatabase("Examen");

            //Colección mongo
            MongoCollection<Document> colMongo = conexion.getCollection("Libros");

            try {
                colMongo.replaceOne(eq("isbn", libro.getIsbn()), documento);


            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (cliente != null) {
                cliente.close();
            }
        }
    }

    /**
     * Elimina Libro de colección
     *
     * @param isbn identificador de Libro
     */
    public static void eliminar(String isbn) {

        MongoClient cliente = null;

        try {
            cliente = MongoClients.create("mongodb://localhost:27017/pruebas");
            MongoDatabase conexion = cliente.getDatabase("Examen");

            //Colección mongo
            MongoCollection<Document> colMongo = conexion.getCollection("Libros");
            try {

                colMongo.deleteOne(eq("isbn", isbn));


            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (cliente != null) {
                cliente.close();
            }
        }
    }


    /**
     * Listar Escenas de colección Mongo
     *
     * @return listado de Escenas
     */
    public static List<Libro> listar() {
        List<Libro> libros = new ArrayList<>();

        MongoClient cliente = null;

        try {
            cliente = MongoClients.create("mongodb://localhost:27017/pruebas");
            MongoDatabase conexion = cliente.getDatabase("Examen");

            //Colección mongo
            MongoCollection<Document> colMongo = conexion.getCollection("Libros");

            List<Document> documentos = colMongo.find().into(new ArrayList<Document>());
            Libro libro;
            for (Document documento : documentos) {
                libro = docALibro(documento);
                libros.add(libro);
            }

            return libros;

        } finally {
            if (cliente != null) {
                cliente.close();
            }
        }
    }


}
