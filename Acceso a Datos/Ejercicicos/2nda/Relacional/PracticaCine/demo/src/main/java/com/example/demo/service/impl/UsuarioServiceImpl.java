package com.example.demo.service.impl;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.dao.impl.JdbcUsuarioDAO;
import com.example.demo.dtos.UsuarioDTO;
import com.example.demo.mapper.UsuarioMapper;
import com.example.demo.service.UsuarioService;

import java.sql.SQLException;

public class UsuarioServiceImpl implements UsuarioService {
    @Override
    public int introducirUsuario(UsuarioDTO usuarioDTO) throws SQLException {

        UsuarioDAO ud = new JdbcUsuarioDAO();

        return ud.insertarUsuario(UsuarioMapper.DTOaUsuario(usuarioDTO));



    }
}
