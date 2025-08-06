package com.santi.jdbc_swagger.services;

import com.santi.jdbc_swagger.models.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioService {
    void registrarUsuario(String nombre, String email) throws SQLException;

    Usuario buscarPorId(int id) throws SQLException;

    List<Usuario> listarUsuarios() throws SQLException;

    void eliminarUsuario(int id) throws SQLException;

    void actualizarUsuario(Usuario usuario) throws SQLException;
}
