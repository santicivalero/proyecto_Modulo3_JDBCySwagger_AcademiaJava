package com.santi.jdbc_swagger.dao;

import com.santi.jdbc_swagger.models.Turno;
import java.sql.SQLException;
import java.util.List;

public interface TurnoDAO {
    void guardar(Turno turno) throws SQLException;

    void actualizar(Turno turno) throws SQLException;

    List<Turno> obtenerPorUsuarioId(int usuarioId) throws SQLException;

    void eliminar(int id) throws SQLException;
}
