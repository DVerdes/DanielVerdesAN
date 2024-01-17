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

        List<DepartamentoDTO> lista = ds.obtenerTodos();

        for(DepartamentoDTO dep : lista){
            System.out.println(dep.toString());
        }

    }
}
