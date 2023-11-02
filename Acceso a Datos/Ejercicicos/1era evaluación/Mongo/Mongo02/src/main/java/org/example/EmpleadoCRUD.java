package org.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class EmpleadoCRUD {

    public static Document empleadoADoc(Empleado empleado){

        if (empleado==null) return null;

        Gson gson = new GsonBuilder().create();
        Document documento = Document.parse(gson.toJson(empleado));


        return documento;

    }


    public static Empleado docAEmpleado(Document documento){

        if(documento==null) return null;

        Gson gson = new GsonBuilder().create();
        Empleado emp = gson.fromJson(documento.toJson(), Empleado.class);

        return emp;
    }

    public static void eliminarEmpleado(MongoCollection<Document> colMongo, String nombre) {
        try {

            colMongo.deleteOne(eq("nombre", nombre));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Empleado consultarEmpleado(MongoCollection<Document> colMongo, String nombre) {
        Document documento = colMongo.find(eq("nombre",nombre)).first();
        return docAEmpleado(documento);
    }

    public static void actualizarEmpleado(MongoCollection<Document> colMongo, Empleado emp) {
        Document documento = empleadoADoc(emp);

        try {
            colMongo.replaceOne(eq("nombre",emp.getNombre()), documento);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Empleado> listarEmpleados(MongoCollection<Document> colMongo) {
        List<Empleado> libros = new ArrayList<>();

        List<Document> documentos = colMongo.find().into(new ArrayList<Document>());
        Empleado libro;
        for(Document documento : documentos){
            libro = docAEmpleado(documento);
            libros.add(libro);
        }

        return libros;
    }

    public static void insertarEmpleado(MongoCollection<Document> colMongo, Empleado empleado) {
        Document documento = empleadoADoc(empleado);

        try{
            if(consultarEmpleado(colMongo, empleado.getNombre())==null){
                colMongo.insertOne(documento);
            }else{
                System.out.println("Error: No se puede insertar "+empleado.getNombre());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
