package service.impl;

import dao.DepartamentoDAO;
import dao.impl.HibernateDepartamentoDAO;
import dao.impl.JDBCDepartamentoDAO;
import dto.DepartamentoDTO;
import dto.EmpleadoDTO;
import mapper.DepartamentoMapper;
import model.Departamento;
import org.hibernate.cfg.beanvalidation.HibernateTraversableResolver;
import service.DepartamentoService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoServiceImpl implements DepartamentoService {


    @Override
    public List<DepartamentoDTO> obtenerTodos() throws SQLException {

        DepartamentoDAO dd = new HibernateDepartamentoDAO();

        List<Departamento> listaDepartamentos= dd.obtenerTodos();

        return DepartamentoMapper.convetirDAOaDTO(listaDepartamentos);

    }

    public List<DepartamentoDTO> obtenerPorNombre(String nombre) throws SQLException {

        DepartamentoDAO dd = new HibernateDepartamentoDAO();

        List<Departamento> listaDepartamentos= dd.obtenerPorNombre(nombre);

        return DepartamentoMapper.convetirDAOaDTO(listaDepartamentos);

    }

    @Override
    public DepartamentoDTO obtenerPorId(int id) throws SQLException {

        DepartamentoDAO dd = new HibernateDepartamentoDAO();

        Departamento dept = dd.obtenerPorId(id);


        return DepartamentoMapper.conversion(dept);
    }

    @Override
    public int crear(DepartamentoDTO dept) throws SQLException {

        DepartamentoDAO dd = new HibernateDepartamentoDAO();


        return dd.crear(DepartamentoMapper.conversionDTOaDPT(dept));


    }

    @Override
    public void actualizar(DepartamentoDTO dept) throws SQLException {

        DepartamentoDAO dd = new HibernateDepartamentoDAO();

        dd.actualizar(DepartamentoMapper.conversionDTOaDPT(dept));

    }

    @Override
    public void elimniar(int id) throws SQLException {

        DepartamentoDAO dd = new HibernateDepartamentoDAO();

        dd.eliminar(id);
    }




}
