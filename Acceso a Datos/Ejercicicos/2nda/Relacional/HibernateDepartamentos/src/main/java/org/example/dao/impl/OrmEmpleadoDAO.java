package org.example.dao.impl;

import org.example.dao.EmpleadoDao;
import org.example.model.Departamento;
import org.example.model.Empleado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class OrmEmpleadoDAO implements EmpleadoDao {

    @Override
    public List<Empleado> listar() throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Empleado> query = session.createNativeQuery("SELECT * FROM Empleados" , Empleado.class);
            List<Empleado> empleados = query.list();
            System.out.println(empleados.toString());



            transaction.commit();
            return empleados;

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
        return null;
    }

    @Override
    public List<Empleado> listarPorNombre(String nombre) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Empleado> query = session.createNativeQuery("SELECT * FROM Empleados WHERE nombre like =:Nombre" , Empleado.class);
            query.setString("nombre","%"+nombre+"%");
            List<Empleado> empleados = query.list();
            System.out.println(empleados.toString());



            transaction.commit();
            return empleados;

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
        return null;
    }

    @Override
    public Empleado obtenerEmpleado(int id) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Empleado empleado = session.get(Empleado.class,id);



            transaction.commit();
            return empleado;

        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
        return null;
    }

    @Override
    public int insertarEmpleado(Empleado empleado) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(empleado);
            transaction.commit();
            return empleado.getId();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }

    @Override
    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Empleado empleado1 = session.get(Empleado.class,empleado.getId());
            empleado1.setNombre(empleado.getNombre());
            empleado1.setApellido(empleado.getApellido());
            empleado1.setPinAcceso(empleado.getPinAcceso());
            empleado1.setSalario(empleado.getSalario());
            empleado1.setFechaContratacion(empleado.getFechaContratacion());
            empleado1.setTelefono(empleado.getTelefono());
            empleado1.setEmail(empleado.getEmail());
            empleado1.setDireccion(empleado.getDireccion());
            empleado1.setIdDepartamento(empleado.getIdDepartamento());
            session.update(empleado1);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void elimarEmpleado(int id) throws SQLException {
        Session session = HibernateConexion.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Empleado empleado = session.get(Empleado.class,id);
            session.delete(empleado);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
