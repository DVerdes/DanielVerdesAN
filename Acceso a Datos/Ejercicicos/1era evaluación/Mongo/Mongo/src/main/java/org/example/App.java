package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import static com.mongodb.client.model.Filters.eq;

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
            MongoDatabase conexion = cliente.getDatabase("Prueba");
            MongoCollection<Document> colMongo = conexion.getCollection("Libros");

            Libro libro1 = new Libro ("El Señor de los Anillos","Tolkien",1956);
            insertarLibro(colMongo,libro1);

            Libro libro2 = new Libro("Don Quijote","Cervantes",1604);
            insertarLibro(colMongo, libro2);

            List <Libro> libros = listarLibros(colMongo);
            System.out.println("\nLista de libros\n------------");
            for (Libro libro: libros){
                System.out.println(libro.toString());
            }

            libro2.setEdicion(1605);
            actualizarLibro(colMongo, libro2);

            Libro libroConsultado = consultarLibro(colMongo,"Don Quijote");
            System.out.println("\nLibro consultado -> "+libroConsultado.toString());


            eliminarLibro(colMongo, "Don Quijote");

            libros = listarLibros(colMongo);
            System.out.println("\nLista de libros\n--------");
            for(Libro libro:libros){
                System.out.println(libro.toString());
            }

        }finally {

            if(cliente!=null){
                cliente.close();
            }
        }

    }


    private static Document libroADoc(Libro libro){

        Document documento = null;

        if (libro!=null){
            documento = new Document();
            documento.put("titulo",libro.getTitulo());
            documento.put("autor",libro.getAutor());
            documento.put("edicion",libro.getEdicion());

        }
        return documento;

    }


    private static Libro docALibro(Document documento){
        Libro libro = null;

        if(documento!=null){
            libro = new Libro();

            libro.setTitulo(documento.getString("titulo"));
            libro.setAutor(documento.getString("autor"));
            libro.setEdicion(documento.getInteger("edicion"));


        }

        return libro;
    }

    private static void eliminarLibro(MongoCollection<Document> colMongo, String titulo) {
        try {

                colMongo.deleteOne(eq("titulo", titulo));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Libro consultarLibro(MongoCollection<Document> colMongo, String titulo) {
        Document documento = colMongo.find(eq("titulo",titulo)).first();
        return docALibro(documento);
    }

    private static void actualizarLibro(MongoCollection<Document> colMongo, Libro libro) {
        Document documento = libroADoc(libro);

        try {
            colMongo.replaceOne(eq("titulo",libro.getTitulo()), documento);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static List<Libro> listarLibros(MongoCollection<Document> colMongo) {
        List<Libro> libros = new ArrayList<>();

        List<Document> documentos = colMongo.find().into(new ArrayList<Document>());
        Libro libro;
        for(Document documento : documentos){
            libro = docALibro(documento);
            libros.add(libro);
        }

        return libros;
    }

    private static void insertarLibro(MongoCollection<Document> colMongo, Libro libro) {
        Document documento = libroADoc(libro);

        try{
            if(consultarLibro(colMongo, libro.getTitulo())==null){
                colMongo.insertOne(documento);
            }else{
                System.out.println("Error: No se puede insertar "+libro.getTitulo());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
