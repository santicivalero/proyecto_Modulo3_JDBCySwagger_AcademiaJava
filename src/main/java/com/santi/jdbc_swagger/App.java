package com.santi.jdbc_swagger;

import com.santi.jdbc_swagger.dao.*;
import com.santi.jdbc_swagger.models.*;
import com.santi.jdbc_swagger.services.*;
import com.santi.jdbc_swagger.utils.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            Connection conn = ConexionBD.obtenerConexion();

            UsuarioDAO usuarioDAO = new UsuarioDAOJDBC(conn);
            TurnoDAO turnoDAO = new TurnoDAOJDBC(conn);

            UsuarioService usuarioService = new UsuarioServiceImpl(usuarioDAO);
            TurnoService turnoService = new TurnoServiceImpl(turnoDAO);

            // Crear usuario
            usuarioService.registrarUsuario("Juan Pérez", "juan@mail.com");

            // Obtener el usuario recién creado
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            Usuario juan = usuarios.get(usuarios.size() - 1); // último usuario

            System.out.println("Usuario creado: " + juan.getId() + " - " + juan.getNombre());

            // Agendar turno
            turnoService.agendarTurno(juan, LocalDate.of(2025, 8, 6), LocalTime.of(15, 0));

            // Listar turnos
            List<Turno> turnos = turnoService.obtenerTurnosDeUsuario(juan.getId());
            for (Turno t : turnos) {
                System.out.println("Turno ID: " + t.getId() + " | Usuario: " + t.getUsuario().getNombre() + " | Fecha: "
                        + t.getFecha() + " | Hora: " + t.getHora());
            }

            // Actualizar turno
            Turno turno = turnos.get(0);
            turno.setHora(LocalTime.of(16, 30));
            turnoService.actualizarTurno(turno);
            System.out.println("Turno actualizado.");

            // Cancelar turno
            turnoService.cancelarTurno(turno.getId());
            System.out.println("Turno eliminado.");

            // Eliminar usuario
            usuarioService.eliminarUsuario(juan.getId());
            System.out.println("Usuario eliminado.");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
