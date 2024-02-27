package org.example;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

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


        /*
        System.out.println("-----------");
        System.out.println(c.getPedidos().size());
        for(Pedido pedido : c.getPedidos()) System.out.println(pedido.toString());




        int id = ClienteDAO.crearCliente(new Cliente("Pepe","Garcia","asdfadsf","sdfds","sdfds","pepe@gmail","678", new HashSet<Pedido>()));
        System.out.println("Insertado cliente: "+id);
       ClienteDAO.crearCliente(new Cliente("paco","Garcia","asdfadsf","sdfds","sdfds","pepe@gmail","678", new HashSet<Pedido>()));


        java.sql.Date d = new java.sql.Date(2023,12,12);

        BigDecimal decimal = new BigDecimal("123.444");

        int idPedido = PedidoDAO.crearPedido(new Pedido(2,d,decimal,"En proceso"));
        PedidoDAO.crearPedido(new Pedido(3,d,decimal,"Finalizado"));

        System.out.println(ClienteDAO.obtenerCliente(2).toString());

        Pedido pedido = PedidoDAO.obtenerPedido(23);
        System.out.println(pedido.toString());


        for(Cliente cliente: ClienteDAO.listar()){
            System.out.println(cliente.toString());
        }

        for(Cliente cliente: ClienteDAO.listarPorNombre("paco")){
            System.out.println(cliente.toString());
        }


        ClienteDAO.eliminarCliente(id);
        ClienteDAO.actualizarCliente(new Cliente(7,"Jose","Pérez","asdfadsf","sdfds","sdfds","pepe@gmail","678", new HashSet<Pedido>()));
*/
    }
}
