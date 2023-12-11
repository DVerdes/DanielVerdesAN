package org.example;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import org.bson.Document;


import static com.mongodb.client.model.Filters.eq;


public class UsuarioCRUD {





        /**
         * Convierte Escena a Documento
         * @param escena Escena a convertir
         * @return documento
         */
        public static Document usuarioADoc(Usuario escena){

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
        public static Usuario docAUsuario(Document documento){

            if(documento==null) return null;

            Gson gson = new GsonBuilder().create();
            Usuario escena = gson.fromJson(documento.toJson(), Usuario.class);

            return escena;
        }

        /**
         * Elimina Escena de colección

         * @param codigo identificador de Escena
         */
        public static void eliminarUsuario( int codigo) {
            try {

                ConexionMongo.conectar().deleteOne(eq("codigo", codigo));

                ConexionMongo.desconectarMongo();

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        /**
         * Consulta Escena de Colección

         * @param codigo identificador de Escena
         * @return Escena a consultar
         */
        public static Usuario consultarUsuario( int codigo) {
            Document documento = ConexionMongo.conectar().find(eq("codigo",codigo)).first();

            ConexionMongo.desconectarMongo();
            return docAUsuario(documento);
        }

        /**
         * Actualizar Escena de Colección
         * @param escena Escena a actualizar
         */
        public static void actualizarUsuario( Usuario escena) {
            Document documento = usuarioADoc(escena);

            try {
                ConexionMongo.conectar().replaceOne(eq("codigo",escena.getCodigo()), documento);

                ConexionMongo.desconectarMongo();

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        /**
         * Listar Escenas de colección Mongo
         * @return listado de Escenas
         */
        public static List<Usuario> listarUsuario() {
            List<Usuario> escenas = new ArrayList<>();

            List<Document> documentos = ConexionMongo.conectar().find().into(new ArrayList<Document>());
            Usuario escena;
            for(Document documento : documentos){
                escena = docAUsuario(documento);
                escenas.add(escena);
            }

            return escenas;
        }

        /**
         * Añade Escena a colección

         * @param escena Escena a añadir
         */
        public static void insertarUsuario( Usuario escena) {
            Document documento = usuarioADoc(escena);

            try{
                if(consultarUsuario(escena.getCodigo())==null){
                    ConexionMongo.conectar().insertOne(documento);
                }else{
                    System.out.println("Error: No se puede insertar "+escena.getCodigo());
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }


