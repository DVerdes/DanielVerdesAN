package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {

        //---------------MONGO-----------------




        UsuarioCRUD.insertarUsuario( new Usuario(5,"Hector Fuentes",35,"hf@gmail.com",true));

        System.out.println(UsuarioCRUD.consultarUsuario(2));

        UsuarioCRUD.actualizarUsuario( new Usuario(2,"Pepe Garcia",67,"ppg@gmail.com",false));

        System.out.println(UsuarioCRUD.consultarUsuario(2));

        System.out.println(UsuarioCRUD.listarUsuario());

        UsuarioCRUD.eliminarUsuario(3);

        System.out.println(UsuarioCRUD.listarUsuario());


        //---------NEODATIS------------
        System.out.println();
        System.out.println("NEODATIS");


        UsuarioDAO.borrarBBDD();

        UsuarioDAO.crearInstancia(new Usuario(1,"Pedro Martinez",23,"om@gmail.com",true));
        UsuarioDAO.crearInstancia(new Usuario(2,"Juan Varela",56,"jv@gmail.com",true));
        UsuarioDAO.crearInstancia(new Usuario(3,"Marian perez",45,"ommmm@gmail.com",false));

        System.out.println(UsuarioDAO.consulta());

        UsuarioDAO.consultaCondicion(2);

        UsuarioDAO.borrar(1);


        System.out.println(UsuarioDAO.consulta());







    }
}
