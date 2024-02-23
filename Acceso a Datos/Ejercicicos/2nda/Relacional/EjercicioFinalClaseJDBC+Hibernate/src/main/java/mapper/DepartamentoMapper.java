package mapper;

import dao.DepartamentoDAO;
import dao.impl.JDBCDepartamentoDAO;
import dao.impl.JDBCEmpleadosDAO;
import dto.DepartamentoDTO;
import model.Departamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoMapper {

    public static List<DepartamentoDTO> convetirDAOaDTO(List<Departamento> listaDAO) throws SQLException {

        DepartamentoDAO dd = new JDBCDepartamentoDAO();

        List<DepartamentoDTO> listaDepartamentosDTO= new ArrayList<>();

        for (Departamento d: listaDAO ) {

            listaDepartamentosDTO.add(conversion(d));

        }

        return listaDepartamentosDTO;

    }

    public static DepartamentoDTO conversion(Departamento d) throws SQLException {


        DepartamentoDTO deptDTO = new DepartamentoDTO(d.getNombre(),d.getUbicacion(),d.getEmail(),d.getTelefono(), JDBCEmpleadosDAO.obtenerNumEmpleados(d.getId()));


        return deptDTO;

    }

    public static Departamento conversionDTOaDPT(DepartamentoDTO d) throws SQLException {


        Departamento dept = new Departamento(d.getId(),d.getNombre(),d.getUbicacion(),d.getEmail(),d.getTelefono());


        return dept;

    }

    public static List<Departamento> resaLista (ResultSet res) throws SQLException {

        List<Departamento> listaDept =  new ArrayList<>();

        while (res.next()){

            listaDept.add(new Departamento(res.getInt("id"),
                    res.getString("nombre"),
                    res.getString("ubicacion"),
                    res.getString("email"),
                    res.getString("telefono")));
        }
        return listaDept;
    }
    public static Departamento resaDept (ResultSet res) throws SQLException {

        Departamento dept = new Departamento();

        while (res.next()){

              dept = new Departamento(res.getInt("id"),
                    res.getString("nombre"),
                    res.getString("ubicacion"),
                    res.getString("email"),
                    res.getString("telefono"));

        }
        return dept;
    }
}
