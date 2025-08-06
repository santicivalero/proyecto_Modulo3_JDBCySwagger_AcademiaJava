package com.santi.jdbc_swagger.services;

import com.santi.jdbc_swagger.models.Turno;
import com.santi.jdbc_swagger.models.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TurnoService {
    void agendarTurno(Usuario usuario, LocalDate fecha, LocalTime hora) throws SQLException;

    List<Turno> obtenerTurnosDeUsuario(int usuarioId) throws SQLException;

    void cancelarTurno(int id) throws SQLException;

    void actualizarTurno(Turno turno) throws SQLException;
}
