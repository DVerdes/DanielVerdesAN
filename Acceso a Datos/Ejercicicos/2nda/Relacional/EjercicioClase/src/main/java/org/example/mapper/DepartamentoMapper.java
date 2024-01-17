package org.example.mapper;

import org.example.dao.DepartamentoDao;
import org.example.dao.impl.JbdcDepartamentoDao;
import org.example.dto.DepartamentoDTO;
import org.example.model.Departamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoMapper {



    static DepartamentoDTO convertirADTO(Departamento departamento) throws SQLException {
        DepartamentoDao dd = new JbdcDepartamentoDao();

        return new DepartamentoDTO(departamento.getId(),departamento.getNombre(),departamento.getUbicacion(),departamento.getEmail(),departamento.getTelefono(),dd.contarEmpleadosDepartamento(departamento.getId()));
    }

    public static List<DepartamentoDTO> convertirLista(List<Departamento> departamentos) throws SQLException {

        List <DepartamentoDTO> listaDTO = new ArrayList<DepartamentoDTO>();

        for(Departamento departamento: departamentos){
            listaDTO.add(convertirADTO(departamento));
        }

        return listaDTO;

    }


    public static List<Departamento> resALista(ResultSet res) throws SQLException {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        while (res.next()){
            departamentos.add(new Departamento(res.getInt("id"), res.getString("nombre"),res.getString("ubicacion"),res.getString("email"),res.getString("telefono")));
        }
        return departamentos;
    }





}
