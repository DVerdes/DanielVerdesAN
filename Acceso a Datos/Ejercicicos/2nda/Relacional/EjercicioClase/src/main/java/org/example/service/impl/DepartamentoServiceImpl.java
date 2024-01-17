package org.example.service.impl;

import org.example.dao.DepartamentoDao;
import org.example.dao.impl.JbdcDepartamentoDao;
import org.example.dto.DepartamentoDTO;
import org.example.model.Departamento;
import org.example.service.DepartamentoService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoServiceImpl implements DepartamentoService {


    @Override
    public List<DepartamentoDTO> obtenerTodos() throws SQLException {

        DepartamentoDao dd = new JbdcDepartamentoDao();

        List<Departamento> departamentos = dd.listar();
        List <DepartamentoDTO> departamentoDTOS = new ArrayList<DepartamentoDTO>();

        for(Departamento departamento: departamentos){
            departamentoDTOS.add(new DepartamentoDTO(departamento.getId(),departamento.getNombre(),departamento.getUbicacion(),departamento.getEmail(),departamento.getTelefono(),dd.contarEmpleadosDepartamento(departamento.getId())));


        }

        return departamentoDTOS;
    }

    @Override
    public List<DepartamentoDTO> obtenerPorNombre(String nombre) {
        return null;
    }

    @Override
    public DepartamentoDTO obtenerPorId(int id) {
        return null;
    }

    @Override
    public int crear(DepartamentoDTO entidad) {
        return 0;
    }

    @Override
    public void actualizar(DepartamentoDTO entidad) {

    }

    @Override
    public void eliminar(int id) {

    }
}
