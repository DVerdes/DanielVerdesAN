package com.example.demo.service;

import com.example.demo.dtos.AccesoDTO;

import java.sql.SQLException;

public interface AccesoService {

    boolean validarInicioSesion(AccesoDTO adto) throws SQLException;

}
