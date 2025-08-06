package com.santi.jdbc_swagger.dao;

import com.santi.jdbc_swagger.models.Turno;
import com.santi.jdbc_swagger.models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurnoDAOJDBC implements TurnoDAO {
    private final Connection conexion;

    public TurnoDAOJDBC(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void guardar(Turno turno) throws SQLException {
        String sql = "INSERT INTO turnos (usuario_id, fecha, hora) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, turno.getUsuario().getId());
            ps.setDate(2, Date.valueOf(turno.getFecha()));
            ps.setTime(3, Time.valueOf(turno.getHora()));
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Turno turno) throws SQLException {
        String sql = "UPDATE turnos SET usuario_id = ?, fecha = ?, hora = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, turno.getUsuario().getId());
            ps.setDate(2, Date.valueOf(turno.getFecha()));
            ps.setTime(3, Time.valueOf(turno.getHora()));
            ps.setInt(4, turno.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Turno> obtenerPorUsuarioId(int usuarioId) throws SQLException {
        List<Turno> lista = new ArrayList<>();
        String sql = "SELECT * FROM turnos WHERE usuario_id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(usuarioId, "", "");
                Turno turno = new Turno(
                        rs.getInt("id"),
                        usuario,
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora").toLocalTime());
                lista.add(turno);
            }
        }
        return lista;
    }

    @Override
    public void eliminar(int id) throws SQLException {
        String sql = "DELETE FROM turnos WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
