package com.example.demo.mapper;

import com.example.demo.dao.SalaDAO;
import com.example.demo.dtos.SalaDTO;
import com.example.demo.model.Cine;
import com.example.demo.model.Sala;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaMapper {

    public static SalaDTO salaADTO (Sala sala){
        return new SalaDTO(sala.getSalaId(),sala.getCineId(),sala.getNombreSala(),sala.getCapacidad(),sala.getFilas(),sala.getButacasPorFila());
    }

    public static Sala dtoASALA (SalaDTO saladto){
        return new Sala(saladto.getSalaId(),saladto.getCineId(),saladto.getNombreSala(),saladto.getCapacidad(),saladto.getFilas(),saladto.getButacasPorFila());
    }

    public static List<Sala> resALista(ResultSet res) throws SQLException {
        List<Sala> salas = new ArrayList<Sala>();
        while (res.next()){
            salas.add(new Sala(res.getInt("SalaID"),res.getInt("CineID"), res.getString("NombreSala"),res.getInt("Capacidad"),res.getInt("Filas"),res.getInt("ButacasPorFila")));
        }
        return salas;
    }



}
