package com.santi.jdbc_swagger.models;

import java.time.LocalDate;
import java.time.LocalTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Entidad que representa un turno asociado a un usuario.")
public class Turno {
    @Schema(description = "ID del turno", example = "10")
    private int id;

    @Schema(description = "Usuario asignado al turno")
    private Usuario usuario;

    @Schema(description = "Fecha del turno", example = "2025-08-10")
    private LocalDate fecha;

    @Schema(description = "Hora del turno", example = "15:30")
    private LocalTime hora;

    public Turno(int id, Usuario usuario, LocalDate fecha, LocalTime hora) {
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Turno(Usuario usuario, LocalDate fecha, LocalTime hora) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    // Método utilitario para obtener el ID del usuario (para guardar en DB)
    public int getUsuarioId() {
        return usuario.getId();
    }
}
