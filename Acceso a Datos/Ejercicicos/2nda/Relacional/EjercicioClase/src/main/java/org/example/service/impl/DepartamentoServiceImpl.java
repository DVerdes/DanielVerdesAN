package org.example.service.impl;

import org.example.dao.DepartamentoDao;
import org.example.dao.impl.JbdcDepartamentoDao;
import org.example.dto.DepartamentoDTO;
import org.example.mapper.DepartamentoMapper;
import org.example.model.Departamento;
import org.example.service.DepartamentoService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DepartamentoServiceImpl implements DepartamentoService {


    @Override
    public List<DepartamentoDTO> obtenerTodos() throws SQLException {

        DepartamentoDao dd = new JbdcDepartamentoDao();


        HashMap<Departamento, Integer> departamentosHashMap = new HashMap<Departamento, Integer>();

        for(Departamento dep : dd.listar()){
            departamentosHashMap.put(dep,dd.contarEmpleadosDepartamento(dep.getId()));
        }




        return DepartamentoMapper.convertirLista(departamentosHashMap);



    }

    @Override
    public List<DepartamentoDTO> obtenerPorNombre(String nombre) throws SQLException {

        DepartamentoDao dd = new JbdcDepartamentoDao();


        HashMap<Departamento, Integer> departamentosHashMap = new HashMap<Departamento, Integer>();

        for(Departamento dep : dd.listarPorNombre(nombre)){
            departamentosHashMap.put(dep,dd.contarEmpleadosDepartamento(dep.getId()));
        }




        return DepartamentoMapper.convertirLista(departamentosHashMap);



    }

    @Override
    public DepartamentoDTO obtenerPorId(int id) throws SQLException {

        DepartamentoDao dd = new JbdcDepartamentoDao();

        return DepartamentoMapper.convertirADTO(dd.obtenerDepartamento(id),dd.contarEmpleadosDepartamento(dd.obtenerDepartamento(id).getId()));

    }

    @Override
    public int crear(DepartamentoDTO entidad) throws SQLException {
        DepartamentoDao dd = new JbdcDepartamentoDao();


        return dd.insertarDepartamento(DepartamentoMapper.convertirADepartamento(entidad));
    }

    @Override
    public void actualizar(DepartamentoDTO entidad) throws SQLException {
        DepartamentoDao dd = new JbdcDepartamentoDao();

        dd.actualizarDepartamento(DepartamentoMapper.convertirADepartamento(entidad));

    }

    @Override
    public void eliminar(int id) throws SQLException {
        DepartamentoDao dd = new JbdcDepartamentoDao();
        dd.elimarDepartamento(id);
    }
}
