package com.parquea.reserve.controllers.dtos;


import java.time.LocalDateTime;

public class HorarioDTO {
    private long idPadre;
    private String tipo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    public HorarioDTO(long idPadre, String tipo, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.idPadre = idPadre;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public HorarioDTO() {
    }

    public long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(long idPadre) {
        this.idPadre = idPadre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
}
