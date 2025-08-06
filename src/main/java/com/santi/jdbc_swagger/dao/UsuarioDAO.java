package com.santi.jdbc_swagger.dao;

import com.santi.jdbc_swagger.models.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    void guardar(Usuario usuario) throws SQLException;

    Usuario obtenerPorId(int id) throws SQLException;

    Usuario obtenerPorEmail(String email) throws SQLException;

    List<Usuario> listarTodos() throws SQLException;

    void actualizar(Usuario usuario) throws SQLException;

    void eliminar(int id) throws SQLException;
}
