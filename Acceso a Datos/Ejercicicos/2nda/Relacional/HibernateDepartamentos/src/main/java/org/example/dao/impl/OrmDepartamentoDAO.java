package org.example.dao.impl;

import org.example.dao.DepartamentoDao;
import org.example.model.Departamento;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class OrmDepartamentoDAO implements DepartamentoDao {
    @Override
    public List<Departamento> listar() throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Departamento> query = session.createNativeQuery("Select * from Departamento" ,Departamento.class);
            List<Departamento> departamentos = query.list();

            transaction.commit();
            return departamentos;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
        return null;
    }

    @Override
    public List<Departamento> listarPorNombre(String nombre) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Departamento> query = session.createNativeQuery("Select * from Departamento WHERE nombre like =:nombre" ,Departamento.class);
            query.setString("nombre","%"+nombre+"%");
            List<Departamento> departamentos = query.list();

            transaction.commit();
            return departamentos;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
        return null;
    }

    @Override
    public Departamento obtenerDepartamento(int id) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Departamento departamento = session.get(Departamento.class,id);
            transaction.commit();
            return departamento;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }   return null; }

    @Override
    public int insertarDepartamento(Departamento departamento) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(departamento);
            transaction.commit();
            return departamento.getId();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }

    @Override
    public int contarEmpleadosDepartamento(int id) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Departamento> query = session.createNativeQuery("SELECT COUNT(*) FROM Empleados WHERE idDepartamento like =:idDep" ,Departamento.class);
            query.setString("idDep", String.valueOf(id));
            List<Departamento> departamentos = query.list();

            transaction.commit();
            return 1;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
        return 1;
    }

    @Override
    public void elimarDepartamento(int id) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Departamento departamento = session.get(Departamento.class,id);
            session.delete(departamento);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void actualizarDepartamento(Departamento departamento) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Departamento departamento1 = session.get(Departamento.class,departamento.getId());
            departamento1.setNombre(departamento.getNombre());
            departamento1.setEmail(departamento.getEmail());
            departamento1.setTelefono(departamento.getTelefono());
            departamento1.setUbicacion(departamento.getUbicacion());
            session.update(departamento1);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
