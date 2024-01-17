package org.example;

import org.example.dto.DepartamentoDTO;
import org.example.service.DepartamentoService;
import org.example.service.impl.DepartamentoServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        DepartamentoService ds = new DepartamentoServiceImpl();

        //listar todos
        List<DepartamentoDTO> lista = ds.obtenerTodos();

        for(DepartamentoDTO dep : lista){
            System.out.println(dep.toString());
        }

        //listar x nombre
        List <DepartamentoDTO> listaPorNombre = ds.obtenerPorNombre("Marketing");
        for(DepartamentoDTO dep : listaPorNombre){
            System.out.println(dep.toString());
        }

        //obtener por id
        System.out.println(ds.obtenerPorId(3).toString());

        // crear
        DepartamentoDTO depDTO =  new DepartamentoDTO("Contabilidad","Barcelona","log@gmail.com","654123123",0);
        System.out.println("Id insertado: "+ds.crear(depDTO));


        //actualizar
        ds.actualizar(new DepartamentoDTO(2,"Inventario","Ourense","invt@gmail.com","687934123",0));


        //eliminar
        ds.eliminar(1);



    }
}
