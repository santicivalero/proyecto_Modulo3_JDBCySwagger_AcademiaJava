package com.santi.jdbc_swagger.controllers;

import com.santi.jdbc_swagger.models.Usuario;
import com.santi.jdbc_swagger.models.Turno;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

// @Path("/api")
@OpenAPIDefinition(info = @Info(title = "API de Gestión de Turnos", version = "1.0", description = "Simulación de endpoints RESTful para gestionar usuarios y turnos con documentación OpenAPI.", contact = @Contact(name = "Santiago Civalero", email = "santi@example.com")))
@Tag(name = "Simulación API REST", description = "Endpoints REST simulados para gestión de usuarios y turnos")
public class SimuladorAPI {

    // @POST
    // @Path("/usuarios")
    @Operation(summary = "Registrar un nuevo usuario", description = "Crea un nuevo usuario con su nombre y correo electrónico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario registrado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public Usuario registrarUsuario(
            @Parameter(description = "Nombre completo del usuario") String nombre,
            @Parameter(description = "Correo electrónico del usuario") String email) {
        return new Usuario(0, nombre, email); // Simulado
    }

    // @GET
    // @Path("/usuarios")
    @Operation(summary = "Listar todos los usuarios", description = "Retorna una lista de todos los usuarios registrados en el sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de usuarios obtenida correctamente")
    public List<Usuario> listarUsuarios() {
        return List.of(); // Simulado
    }

    // @DELETE
    // @Path("/usuarios/{id}")
    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario del sistema por su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public void eliminarUsuario(
            @Parameter(description = "ID del usuario a eliminar") int id) {
        // Simulado
    }

    // @POST
    // @Path("/turnos")
    @Operation(summary = "Agendar un turno para un usuario", description = "Crea un nuevo turno asociado a un usuario existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Turno creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public Turno agendarTurno(
            @Parameter(description = "ID del usuario") int usuarioId,
            @Parameter(description = "Fecha del turno") LocalDate fecha,
            @Parameter(description = "Hora del turno") LocalTime hora) {
        return new Turno(0, new Usuario(usuarioId, "Simulado", "email@sim.com"), fecha, hora);
    }

    // @GET
    // @Path("/turnos/{usuarioId}")
    @Operation(summary = "Obtener turnos de un usuario", description = "Obtiene todos los turnos asociados a un usuario por ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de turnos obtenida correctamente"),
            @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    public List<Turno> obtenerTurnos(
            @Parameter(description = "ID del usuario") int usuarioId) {
        return List.of(); // Simulado
    }

    // @PUT
    // @Path("/turnos/{id}")
    @Operation(summary = "Actualizar un turno", description = "Modifica la fecha y hora de un turno existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Turno actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Turno no encontrado")
    })
    public void actualizarTurno(
            @Parameter(description = "ID del turno") int turnoId,
            @Parameter(description = "Nueva fecha") LocalDate fecha,
            @Parameter(description = "Nueva hora") LocalTime hora) {
        // Simulado
    }

    // @DELETE
    // @Path("/turnos/{id}")
    @Operation(summary = "Cancelar un turno", description = "Elimina un turno del sistema dado su ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Turno cancelado correctamente"),
            @ApiResponse(responseCode = "404", description = "Turno no encontrado")
    })
    public void cancelarTurno(
            @Parameter(description = "ID del turno a eliminar") int turnoId) {
        // Simulado
    }
}
