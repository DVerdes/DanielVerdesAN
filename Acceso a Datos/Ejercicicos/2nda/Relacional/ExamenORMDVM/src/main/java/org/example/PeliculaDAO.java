package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase para operaciones con BBDD referidas a Pelicula
 */
public class PeliculaDAO {

    /**
     * Inserta pelicula en BBDD
     * @param pelicula pelicula a insertar
     * @return id de la pelicula insertada
     */
    public static int crearPelicula(Pelicula pelicula) {

        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(pelicula);
            transaction.commit();
            return pelicula.getId();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return  0;

        }finally {
            session.close();
        }
    }

    /**
     * Lee pelicula de la BBDD
     * @param id de la pelicula a leer
     * @return Pelicula leída
     * @throws SQLException
     */
    public static Pelicula obtenerPelicula(int id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Pelicula pelicula = session.get(Pelicula.class,id);
            transaction.commit();

            return pelicula;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }   return null; }

    /**
     * Borra pelicula de la BBDD
     * @param id de la pelicula a borrar
     * @throws SQLException
     */
    public static void eliminarPelicula(int id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Pelicula pelicula = session.get(Pelicula.class,id);
            session.delete(pelicula);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * Actualiza pelicula de la BBDD
     * @param pelicula pelicula a actualizar
     * @throws SQLException
     */
    public static  void actualizarPelicula(Pelicula pelicula) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Se obtiene pelicula
            Pelicula p1 = session.get(Pelicula.class,pelicula.getId());
            // Se setean nuevos valores
            p1.setTitulo(pelicula.getTitulo());
            p1.setEstreno(pelicula.getEstreno());
            p1.setGenero(pelicula.getGenero());



            session.update(p1);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * Lista peliculas que contienen una cadena de texto determinada
     * @param letra cadena de texto
     * @return listado de peliculas que cumplen la condicion
     * @throws SQLException
     */
    public static List<Pelicula> listarPorLetra(String letra) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Pelicula> query = session.createNativeQuery("Select * from Peliculas WHERE Titulo like :nombre" ,Pelicula.class);
            query.setString("nombre","%"+letra+"%");
            List<Pelicula> peliculas = query.list();

            transaction.commit();
            return peliculas;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    /**
     * Lista peliculas anteriores a un año
     * @param year año de referencia
     * @return listado de peliculas  que cumplen la condicion
     */
    public static List<Pelicula> consultarPeliculasAnteriores(String year){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            // en HQL se pasa en nombre del objeto mapeado no de la TABLA de la BBDD
            Query query = session.createQuery("from Pelicula where estreno <:anho");
            query.setString("anho",year);
            List<Pelicula> peliculas = query.list();
            for(Pelicula tarea : peliculas){
                System.out.println(tarea);
            }
            transaction.commit();

            return peliculas;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return null;
        }finally {

            session.close();

        }
    }



}
