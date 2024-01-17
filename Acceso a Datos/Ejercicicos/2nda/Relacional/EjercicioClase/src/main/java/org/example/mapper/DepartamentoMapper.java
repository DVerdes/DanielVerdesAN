package org.example.mapper;

import org.example.dao.DepartamentoDao;
import org.example.dao.impl.JbdcDepartamentoDao;
import org.example.dto.DepartamentoDTO;
import org.example.model.Departamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DepartamentoMapper {



    public static DepartamentoDTO convertirADTO(Departamento departamento, Integer numEmpleados) throws SQLException {

        return new DepartamentoDTO(departamento.getId(),departamento.getNombre(),departamento.getUbicacion(),departamento.getEmail(),departamento.getTelefono(),numEmpleados);
    }

    public static Departamento convertirADepartamento(DepartamentoDTO departamentodto){
        return new Departamento(departamentodto.getId(), departamentodto.getNombre(), departamentodto.getUbicacion(), departamentodto.getEmail(), departamentodto.getTelefono());
    }

    public static List<DepartamentoDTO> convertirLista(HashMap<Departamento, Integer> departamentos) throws SQLException {

        List <DepartamentoDTO> listaDTO = new ArrayList<DepartamentoDTO>();

        for (Departamento i : departamentos.keySet()) {
            listaDTO.add(convertirADTO(i,departamentos.get(i)));
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
