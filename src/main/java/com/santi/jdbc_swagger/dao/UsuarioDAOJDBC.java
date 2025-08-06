package com.santi.jdbc_swagger.dao;

import com.santi.jdbc_swagger.models.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOJDBC implements UsuarioDAO {
    private final Connection conexion;

    public UsuarioDAOJDBC(Connection conexion) {
        this.conexion = conexion;
    }

    public void guardar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nombre, email) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.executeUpdate();
        }
    }

    public Usuario obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"));
            }
        }
        return null;
    }

    public Usuario obtenerPorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"));
            }
        }
        return null;
    }

    public List<Usuario> listarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
            }
        }
        return lista;
    }

    public void actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuarios SET nombre = ?, email = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setInt(3, usuario.getId());
            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
