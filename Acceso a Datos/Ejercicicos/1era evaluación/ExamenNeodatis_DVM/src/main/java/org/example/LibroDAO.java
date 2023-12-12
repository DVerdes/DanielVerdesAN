package org.example;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO para acceso a métodos Neodatis
 */
public class LibroDAO {


    /**
     * Inserta libro en BDOO
     *
     * @param libro libro a insertar
     * @throws Exception
     */
    public static void insertar(Libro libro) throws Exception {

        ODB odb = null;
        try {

            odb = ODBFactory.open("examenNeo.db");


            odb.store(libro);




        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }


    /**
     * Lista todos los libros en BDOO
     *
     * @return lista de libros
     * @throws Exception
     */
    public static List<Libro> listar() throws Exception {

        ODB odb = null;
        List<Libro> libros = new ArrayList<Libro>();

        try {
            odb = ODBFactory.open("examenNeo.db");
            Objects conjunto = odb.getObjects(Libro.class);

            while (conjunto.hasNext()) {
                libros.add((Libro) conjunto.next());
            }

            return libros;
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

    /**
     * Obtiene un libro de BDOO
     *
     * @param isbn codigo del libro a obtener
     * @return Libro consultado
     * @throws Exception
     */
    public static Libro obtener(String isbn) throws Exception {

        ODB odb = null;

        try {
            odb = ODBFactory.open("examenNeo.db");
            IQuery query = new CriteriaQuery(Libro.class, Where.equal("isbn", isbn));
            Objects libros = odb.getObjects(query);
            return (Libro) libros.getFirst();

        } finally {
            if (odb != null) {
                odb.close();
            }
        }

    }


    /**
     * Elimina libro de BDOO
     *
     * @param isbn codigo del libro a eliminar
     * @throws Exception
     */
    public static void eliminar(String isbn) throws Exception {

        ODB odb = null;

        try {
            odb = ODBFactory.open("examenNeo.db");
            IQuery query = new CriteriaQuery(Libro.class, Where.equal("isbn", isbn));

            Objects libros = odb.getObjects(query);
            Libro libro = (Libro) libros.getFirst();
            odb.delete(libro);


        } finally {
            if (odb != null) {
                odb.close();
            }
        }


    }

    /**
     * Actualiza libro requerido
     *
     * @param libro libro actualizado
     * @throws Exception
     */
    public static void actualizar(Libro libro) throws Exception {

        eliminar(libro.getIsbn());

        insertar(libro);


    }





}
