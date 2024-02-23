import dao.EmpleadosDAO;
import dto.DepartamentoDTO;
import dto.EmpleadoDTO;
import model.Departamento;
import service.DepartamentoService;
import service.EmpleadoService;
import service.impl.DepartamentoServiceImpl;
import service.impl.EmpleadoServiceImpl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        /*
        DepartamentoService dps = new DepartamentoServiceImpl();

        List<DepartamentoDTO> list = dps.obtenerTodos();
        for (DepartamentoDTO d : list             ) {

            System.out.println(d.toString());
        }
        System.out.println("---------------");


        list= dps.obtenerPorNombre("coruña");
        for (DepartamentoDTO d : list             ) {

            System.out.println(d.toString());
        }

        System.out.println("---------------");

        System.out.println(dps.obtenerPorId(2).toString());


        System.out.println("---------------");

        System.out.println(dps.crear(new DepartamentoDTO("xfdsgh","Lugdxfghdo","lugoDept@mail.com","53485645")));

        dps.actualizar(new DepartamentoDTO(2,"Dept Central","Madrid","MadridCentral@mail.com","53485645"));

        dps.elimniar(2);
*/

        EmpleadoService eps = new EmpleadoServiceImpl();
        List<EmpleadoDTO> lista = eps.obtenerTodos();

        System.out.println(eps.obtenerTodos());
        System.out.println("------------");

        System.out.println(eps.obtenerPorNombre("Maria"));
        System.out.println("------------");

        System.out.println(eps.obtenerPorId(1));

        System.out.println(eps.crear(new EmpleadoDTO(35,"jose","garcia",BigDecimal.valueOf(234523),new Date(2023,12,12),"kdjfjgs","374833","kdfnde@gmail.com",1,"coruña")));
        eps.actualizar(new EmpleadoDTO(3,"jose carlos","garcia", BigDecimal.valueOf(234523),new Date(2023,12,12),"kdjfjgs","374833","kdfnde@gmail.com",2,"coruña" ));


        eps.elimniar(2);







    }
}
