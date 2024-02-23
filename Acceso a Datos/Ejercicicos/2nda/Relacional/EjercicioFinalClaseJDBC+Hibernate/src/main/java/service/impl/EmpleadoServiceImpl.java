package service.impl;

import dao.DepartamentoDAO;
import dao.EmpleadosDAO;
import dao.impl.HibernateEmpleadoDAO;
import dao.impl.JDBCDepartamentoDAO;
import dao.impl.JDBCEmpleadosDAO;
import dto.DepartamentoDTO;
import dto.EmpleadoDTO;
import mapper.DepartamentoMapper;
import mapper.EmpleadoMapper;
import model.Departamento;
import model.Empleado;
import service.EmpleadoService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoServiceImpl implements EmpleadoService {
    public List<EmpleadoDTO> obtenerTodos() throws SQLException {

        EmpleadosDAO ed = new HibernateEmpleadoDAO();

        List<Empleado> listaEmps= ed.obtenerTodos();

        return EmpleadoMapper.convetirDAOaDTO(listaEmps);

    }

    public List<EmpleadoDTO> obtenerPorNombre(String nombre) throws SQLException {

        EmpleadosDAO ed = new HibernateEmpleadoDAO();

        List<Empleado> listaDepartamentos= ed.obtenerPorNombre(nombre);

        return EmpleadoMapper.convetirDAOaDTO(listaDepartamentos);

    }

    @Override
    public EmpleadoDTO obtenerPorId(int id) throws SQLException {
        EmpleadosDAO ed = new HibernateEmpleadoDAO();

        Empleado e = ed.obtenerPorID(id);

        return EmpleadoMapper.conversion(e);
    }

    @Override
    public int crear(EmpleadoDTO e) throws SQLException {
        EmpleadosDAO ed = new HibernateEmpleadoDAO();


        return ed.crear(EmpleadoMapper.conversionDTOaDAO(e));
    }

    @Override
    public void actualizar(EmpleadoDTO e) throws SQLException {
        EmpleadosDAO dd = new HibernateEmpleadoDAO();

        dd.actualizar(EmpleadoMapper.conversionDTOaDAO(e));
    }

    @Override
    public void elimniar(int id) throws SQLException {
        EmpleadosDAO dd = new HibernateEmpleadoDAO();

        dd.eliminar(id);
    }

    @Override
    public void moverEmpleados(int id, List<EmpleadoDTO> listaDTO) throws SQLException {
        EmpleadosDAO dd = new HibernateEmpleadoDAO();

        List<Empleado> lista = new ArrayList<>();

        for (EmpleadoDTO e: listaDTO ) {
            lista.add(EmpleadoMapper.conversionDTOaDAO(e));
        }

        dd.moverEmpleados(id ,lista);

    }

}
