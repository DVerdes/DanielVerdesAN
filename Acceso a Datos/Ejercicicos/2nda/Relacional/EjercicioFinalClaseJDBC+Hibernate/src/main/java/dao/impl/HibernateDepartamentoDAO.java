package dao.impl;


import dao.DepartamentoDAO;
import model.Departamento;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class HibernateDepartamentoDAO implements DepartamentoDAO {

    static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<Departamento> obtenerTodos(){

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();
        Query<Departamento> query = session.createNativeQuery("select * from Departamento" , Departamento.class);

        List<Departamento> list = query.list();
        try {

            transaction.commit();
            return  list;

        }
        catch (Exception e){

            transaction.rollback();
            throw new RuntimeException(e);

        }finally {
            session.close();
        }


    }

    @Override
    public List<Departamento> obtenerPorNombre(String nombre) throws SQLException {

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();
        Query<Departamento> query = session.createQuery("from Departamento where nombre = :nombre", Departamento.class);
        query.setString("nombre",nombre);

        List<Departamento> list = query.list();
        try {
            transaction.commit();
            return list;
        }
        catch (Exception e){

            transaction.rollback();
            throw new RuntimeException(e);

        }finally {
            session.close();
        }
    }

    @Override
    public Departamento obtenerPorId(int id) throws SQLException {


        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();
        Query<Departamento> query = session.createNativeQuery(" select * from Departamento where id = :id", Departamento.class);
        query.setInteger("id",id);
        Departamento departamento = session.get(Departamento.class , id);
        try {
            transaction.commit();
            return departamento;
        }
        catch (Exception e){

            transaction.rollback();
            throw new RuntimeException(e);

        }finally {
            session.close();
        }
    }

    @Override
    public int crear(Departamento dept) throws SQLException {

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();

        try {

            session.save(dept);
            System.out.println(dept.toString());
            transaction.commit();
            return  dept.getId();

        }catch (Exception e){

            transaction.rollback();
            throw new RuntimeException(e);
        }



    }

    @Override
    public void actualizar(Departamento dept) throws SQLException {

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();

        Departamento departamento = session.get(Departamento.class , dept.getId());

        try {

            departamento.setNombre(dept.getNombre());
            departamento.setEmail(dept.getEmail());
            departamento.setTelefono(dept.getTelefono());
            departamento.setUbicacion(dept.getUbicacion());
            session.update(departamento);
            transaction.commit();

        }
        catch (Exception e){

            transaction.rollback();
            throw new RuntimeException(e);

        }finally {
            session.close();
        }

    }

    @Override
    public void eliminar(int id) throws SQLException {

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();

        Departamento departamento = session.get(Departamento.class , id);

        try {

            session.delete(departamento);
            transaction.commit();


        }
        catch (Exception e){

            transaction.rollback();
            throw new RuntimeException(e);

        }finally {
            session.close();
        }
    }

}
