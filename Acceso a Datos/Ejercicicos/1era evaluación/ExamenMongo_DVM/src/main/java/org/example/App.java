package org.example;

/**
 * EXAMEN MONGO
 * MAIN
 */
public class App 
{
    public static void main( String[] args )
    {

        // Insertar libros
        LibroDAO.insertar(new Libro("1","El Hobbit",1957,240,"Fantasía"));
        LibroDAO.insertar(new Libro("2","La última legión",2001,450,"Histórica"));
        LibroDAO.insertar(new Libro("3","El capitán Alatriste",1993,323,"Histórica"));

        // Consultar libro con isbn 2
        System.out.println(LibroDAO.obtener("2"));

        // Actualizar libro con isbn 2
        LibroDAO.actualizar(new Libro("2","El Señor de los Anillos",1966,689,"Fantasía"));

        // Listar todos los libros
        System.out.println(LibroDAO.listar());

        // Elimiar libro
        LibroDAO.eliminar("1");

        // Listar todos los libros
        System.out.println(LibroDAO.listar());

    }
}
