package com.santi.jdbc_swagger.services;

import com.santi.jdbc_swagger.dao.UsuarioDAO;
import com.santi.jdbc_swagger.models.Usuario;
import java.sql.SQLException;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(UsuarioDAO dao) {
        this.usuarioDAO = dao;
    }

    @Override
    public void registrarUsuario(String nombre, String email) throws SQLException {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacío.");
        }
        Usuario existente = usuarioDAO.obtenerPorEmail(email);
        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un usuario con ese email.");
        }
        usuarioDAO.guardar(new Usuario(nombre, email));
    }

    @Override
    public Usuario buscarPorId(int id) throws SQLException {
        return usuarioDAO.obtenerPorId(id);
    }

    @Override
    public List<Usuario> listarUsuarios() throws SQLException {
        return usuarioDAO.listarTodos();
    }

    @Override
    public void eliminarUsuario(int id) throws SQLException {
        usuarioDAO.eliminar(id);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws SQLException {
        if (usuario.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        usuarioDAO.actualizar(usuario);
    }
}
