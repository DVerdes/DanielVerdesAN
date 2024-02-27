package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ClienteDAO {

    public static int crearCliente(Cliente cliente) {

        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(cliente);
            transaction.commit();
            System.out.println(cliente.toString());
            return cliente.getClienteId();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return  0;

        }finally {
            session.close();
        }
    }

    public static Cliente obtenerCliente(int id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Cliente cliente = session.get(Cliente.class,id);
            for(Pedido p : cliente.getPedidos()) System.out.println(p.toString());
            transaction.commit();

            return cliente;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }   return null; }

    public static List<Cliente> listar() throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Cliente> query = session.createNativeQuery("Select * from Clientes" ,Cliente.class);
            List<Cliente> clientes = query.list();

            transaction.commit();
            return clientes;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
        return null;
    }

    public static List<Cliente> listarPorNombre(String nombre) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {

            Query<Cliente> query = session.createNativeQuery("Select * from Clientes WHERE Nombre like :nombre" ,Cliente.class);
            query.setString("nombre","%"+nombre+"%");
            List<Cliente> clientes = query.list();

            transaction.commit();
            return clientes;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {

            session.close();

        }
        return null;
    }

    public static void eliminarCliente(int id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Cliente cliente = session.get(Cliente.class,id);
            session.delete(cliente);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static  void actualizarCliente(Cliente cliente) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Cliente cliente1 = session.get(Cliente.class,cliente.getClienteId());
            cliente1.setNombre((cliente.getNombre()));
            cliente1.setApellido(cliente.getApellido());
            cliente1.setCiudad(cliente.getCiudad());
            cliente1.setDireccion(cliente.getDireccion());
            cliente1.setPais(cliente.getPais());
            cliente1.setEmail(cliente.getEmail());
            cliente1.setTelefono(cliente.getTelefono());

            session.update(cliente1);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


}
