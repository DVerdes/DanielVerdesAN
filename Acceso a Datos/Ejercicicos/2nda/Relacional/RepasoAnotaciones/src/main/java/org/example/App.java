package org.example;

import java.sql.SQLException;
import java.util.HashSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        int id = ClienteDAO.crearCliente(new Cliente("Jesus","Garcia","asdfadsf","sdfds","sdfds","pepe@gmail","678", new HashSet<Pedido>()));

        Cliente c = ClienteDAO.obtenerCliente(3);

        System.out.println(c.toString());

        Pedido p = PedidoDAO.obtenerPedido(20);
        System.out.println(p.toString());

        System.out.println("-----------");
        System.out.println(c.getPedidos().size());
        for(Pedido pedido : c.getPedidos()) System.out.println(pedido.toString());

    }
}
