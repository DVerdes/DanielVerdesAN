package dao.impl;


import dao.EmpleadosDAO;
import model.Departamento;
import model.Empleado;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class HibernateEmpleadoDAO implements EmpleadosDAO {

    static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public  int crear(Empleado st){

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();

        try {
            session.save(st);
            System.out.println(st);


        }catch (Exception e){

            transaction.rollback();
            throw new RuntimeException(e);
        }

        transaction.commit();
        return st.getId();
    }


    public List<Empleado> obtenerTodos(){

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();
        Query<Empleado> query = session.createNativeQuery("select * from Empleados" , Empleado.class);

        List<Empleado> list = query.list();
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
    public List<Empleado> obtenerPorNombre(String nombre) throws SQLException {

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();
        Query<Empleado> query = session.createNativeQuery("select * from Empleados where nombre = :nombre" , Empleado.class);
        query.setString("nombre",nombre);

        List<Empleado> list = query.list();
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
    public String obtenerDepartamento(String nombre, String apellidos) throws SQLException {

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();
        Query<Empleado> query = session.createQuery("select d.nombre from departamento as d join empleados as e on d.id = e.idDepartamento where e.nombre = :nombre and e.apellido = :apellido", Empleado.class);
        query.setString("nombre",nombre);
        query.setString("apellido",apellidos);

        String nombreDEPT = query.toString();

        try {
            transaction.commit();
            return nombreDEPT;
        }
        catch (Exception e){

            transaction.rollback();
            throw new RuntimeException(e);

        }finally {
            session.close();
        }
    }

    public Empleado obtenerPorID(int id){

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();

        Empleado emp = session.get(Empleado.class , id);

        try {


            transaction.commit();

        }
        catch (Exception e){


            transaction.rollback();
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
        return emp;
    }

    public void actualizar( Empleado e){

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();

        Empleado empleadoR = session.get(Empleado.class ,e.getId());

        try {

            empleadoR.setNombre(e.getNombre());
            empleadoR.setApellido(e.getApellido());
            empleadoR.setDireccion(e.getDireccion());
            empleadoR.setEmail(e.getEmail());
            empleadoR.setIdDepartamento(e.getIdDepartamento());

            empleadoR.setSalario(e.getSalario());
            empleadoR.setPinAcceso(e.getPinAcceso());
            empleadoR.setTelefono(e.getTelefono());

            session.update(empleadoR);
            transaction.commit();

        }
        catch (Exception ex){

            transaction.rollback();
            throw new RuntimeException(ex);

        }finally {
            session.close();
        }

    }

    public  void eliminar(int id){

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction  = session.beginTransaction();

        Empleado stRec = session.get(Empleado.class , id);

        try {

            session.delete(stRec);
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
    public void moverEmpleados(int id, List<Empleado> listaEmp) throws SQLException {

    }


}
