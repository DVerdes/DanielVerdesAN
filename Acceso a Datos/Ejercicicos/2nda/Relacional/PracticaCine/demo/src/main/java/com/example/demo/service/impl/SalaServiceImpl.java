package com.example.demo.service.impl;

import com.example.demo.dao.SalaDAO;
import com.example.demo.dao.impl.JdbcSalaDAO;
import com.example.demo.dtos.SalaDTO;
import com.example.demo.mapper.SalaMapper;
import com.example.demo.service.SalaService;

import java.sql.SQLException;

public class SalaServiceImpl implements SalaService {
    @Override
    public SalaDTO insertarSala(SalaDTO salaDTO) throws SQLException {
        SalaDAO sd = new JdbcSalaDAO();

        return SalaMapper.salaADTO(sd.insertarSala(SalaMapper.dtoASALA(salaDTO)));

    }
}
