package com.example.demo.dao;

import com.example.demo.model.Acceso;

import java.sql.SQLException;

public interface AccesoDAO {


    boolean comprobarInicioSesion(Acceso acceso) throws SQLException;


}
