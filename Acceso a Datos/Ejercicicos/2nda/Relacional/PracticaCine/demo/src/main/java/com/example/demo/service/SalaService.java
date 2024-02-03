package com.example.demo.service;

import com.example.demo.dtos.SalaDTO;

import java.sql.SQLException;

public interface SalaService {

    public SalaDTO insertarSala (SalaDTO salaDTO) throws SQLException;
}
