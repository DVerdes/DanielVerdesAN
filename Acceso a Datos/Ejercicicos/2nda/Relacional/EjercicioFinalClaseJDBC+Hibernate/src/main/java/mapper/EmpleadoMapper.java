package mapper;

import dao.DepartamentoDAO;
import dao.EmpleadosDAO;
import dao.impl.JDBCDepartamentoDAO;
import dao.impl.JDBCEmpleadosDAO;
import dto.DepartamentoDTO;
import dto.EmpleadoDTO;
import model.Departamento;
import model.Empleado;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoMapper {
    public static List<EmpleadoDTO> convetirDAOaDTO(List<Empleado> listaDAO) throws SQLException {

        DepartamentoDAO dd = new JDBCDepartamentoDAO();

        List<EmpleadoDTO> listaEmpleadosDTO= new ArrayList<>();

        for (Empleado d: listaDAO ) {

            listaEmpleadosDTO.add(conversion(d));

        }

        return listaEmpleadosDTO;

    }

    public static EmpleadoDTO conversion(Empleado d) throws SQLException {


        EmpleadoDTO empDTO = new EmpleadoDTO(d.getId(),d.getNombre(),d.getApellido(),d.getSalario(),d.getFechaContratacion(),d.getDireccion(),d.getTelefono(),d.getEmail(), d.getIdDepartamento(),d.getNombreDepartamento());


        return empDTO;

    }

    public static Empleado conversionDTOaDAO(EmpleadoDTO d) throws SQLException {


        Empleado e = new Empleado(d.getId(),d.getNombre(),d.getApellido(),d.getSalario(), d.getFechaContratacion(),d.getDireccion(),d.getTelefono(),d.getEmail(),d.getIdDepartamento());


        return e;

    }

    public static List<Empleado> resaLista (ResultSet res) throws SQLException {

        EmpleadosDAO edao = new JDBCEmpleadosDAO();
        List<Empleado> listaemp =  new ArrayList<>();


        while (res.next()){

            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            listaemp.add(new Empleado(res.getInt("id"),
                    res.getString("nombre"),
                    res.getString("apellido"),
                    res.getString("pinAcceso"),
                    res.getBigDecimal("salario"),
                    res.getDate("fechaContratacion"),
                    res.getString("direccion"),
                    res.getString("telefono"),
                    res.getString("email"),
                    res.getInt("idDepartamento"),
                    edao.obtenerDepartamento(nombre,apellido)));
        }
        return listaemp;
    }
    public static Empleado resaEmp (ResultSet res) throws SQLException {
        EmpleadosDAO edao = new JDBCEmpleadosDAO();
        Empleado e = new Empleado();

        while (res.next()){


            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");

            e =  new Empleado(res.getInt("id"),
                    res.getString("nombre"),
                    res.getString("apellido"),
                    res.getString("pinAcceso"),
                    res.getBigDecimal("salario"),
                    res.getDate("fechaContratacion"),
                    res.getString("direccion"),
                    res.getString("telefono"),
                    res.getString("email"),
                    res.getInt("idDepartamento"),
                    edao.obtenerDepartamento(nombre,apellido));

        }
        return e;
    }
}
