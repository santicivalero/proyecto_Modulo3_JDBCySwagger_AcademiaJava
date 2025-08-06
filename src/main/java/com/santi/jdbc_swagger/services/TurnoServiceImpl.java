package com.santi.jdbc_swagger.services;

import com.santi.jdbc_swagger.dao.TurnoDAO;
import com.santi.jdbc_swagger.models.Turno;
import com.santi.jdbc_swagger.models.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TurnoServiceImpl implements TurnoService {
    private final TurnoDAO turnoDAO;

    public TurnoServiceImpl(TurnoDAO dao) {
        this.turnoDAO = dao;
    }

    @Override
    public void agendarTurno(Usuario usuario, LocalDate fecha, LocalTime hora) throws SQLException {
        List<Turno> turnos = turnoDAO.obtenerPorUsuarioId(usuario.getId());
        for (Turno t : turnos) {
            if (t.getFecha().equals(fecha) && t.getHora().equals(hora)) {
                throw new IllegalArgumentException("Turno duplicado.");
            }
        }
        turnoDAO.guardar(new Turno(usuario, fecha, hora));
    }

    @Override
    public List<Turno> obtenerTurnosDeUsuario(int usuarioId) throws SQLException {
        return turnoDAO.obtenerPorUsuarioId(usuarioId);
    }

    @Override
    public void cancelarTurno(int id) throws SQLException {
        turnoDAO.eliminar(id);
    }

    @Override
    public void actualizarTurno(Turno turno) throws SQLException {
        if (turno.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido.");
        }
        turnoDAO.actualizar(turno);
    }
}
