package com.example.demo.dao;

import com.example.demo.model.Usuario;

import java.sql.SQLException;

public interface UsuarioDAO {

        int insertarUsuario(Usuario usuario) throws SQLException;

        void actualizarContrasena(int idUsuario, String nuevaContrasena) throws SQLException;



}
