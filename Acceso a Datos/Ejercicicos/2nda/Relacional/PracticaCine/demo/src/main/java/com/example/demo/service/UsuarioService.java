package com.example.demo.service;

import com.example.demo.dtos.UsuarioDTO;

import java.sql.SQLException;

public interface UsuarioService {

    int introducirUsuario(UsuarioDTO usuarioDTO) throws SQLException;

}
