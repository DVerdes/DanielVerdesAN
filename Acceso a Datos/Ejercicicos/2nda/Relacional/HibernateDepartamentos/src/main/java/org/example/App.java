package org.example;

import org.example.dto.DepartamentoDTO;
import org.example.dto.EmpleadoDTO;
import org.example.model.Empleado;
import org.example.service.DepartamentoService;
import org.example.service.EmpleadoService;
import org.example.service.impl.DepartamentoServiceImpl;
import org.example.service.impl.EmpleadoServiceImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        DepartamentoService ds = new DepartamentoServiceImpl();





        EmpleadoService es = new EmpleadoServiceImpl();

        java.sql.Date d = new java.sql.Date(2023,12,12);





       ds.crear(new DepartamentoDTO("SAP","Ferrol","sap@gmail.com","675887777",6));






       // ds.eliminar(7);

        ds.actualizar(new DepartamentoDTO(5,"Dep actualizado","Malpica","act@gmail.com","678575757",7));


        //listar todos
        List<DepartamentoDTO> lista = ds.obtenerTodos();





        for(DepartamentoDTO dep : lista){
            System.out.println(dep.toString());
        }


        /*


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
        ds.actualizar(new DepartamentoDTO(3,"Inventario","Ourense","invt@gmail.com","687934123",0));


        //eliminar
        ds.eliminar(1);

        //EMPLEADOS
        //
        //listar todos
        List<EmpleadoDTO> listaEmp = es.obtenerTodos();

        for(EmpleadoDTO emp : listaEmp){
            System.out.println(emp.toString());
        }

        //listar x nombre
        List<EmpleadoDTO> listaEMP2 = es.obtenerPorNombre("paco");

        for(EmpleadoDTO empleado : listaEMP2){
            System.out.println(empleado.toString());
        }

        // obtener por id

        EmpleadoDTO emp = es.obtenerPorId(1);
        System.out.println(emp.toString());

        // crear empleado

        es.crear(new EmpleadoDTO("Jacinto","García",12000,d,"Betanzos","676998765","jacinto@gmail.com",2,"daigual"));

        // actualizar empleado

        es.actualizar(new EmpleadoDTO(3,"Pedro","Suarez",11000,d,"Cabanas","675435343","ps@gmail.com",3,"sa"));

        // eliminar empleado

        //es.eliminar(2);

        */
    }

    public static Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }
}
