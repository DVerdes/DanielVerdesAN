package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

public class PedidoDAO {


    public static int crearPedido   (Pedido pedido) {

        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(pedido);
            transaction.commit();
            System.out.println(pedido.toString());
            return pedido.getPedidoId();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return  0;

        }finally {
            session.close();
        }
    }

    public static Pedido obtenerPedido(int id) throws SQLException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Pedido pedido = session.get(Pedido.class,id);
            transaction.commit();
            //pedido.setCliente(ClienteDAO.obtenerCliente(pedido.getClienteId()));
            return pedido;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }   return null; }

}
