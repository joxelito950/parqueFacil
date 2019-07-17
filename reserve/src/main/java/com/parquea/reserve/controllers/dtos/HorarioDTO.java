package com.parquea.reserve.controllers.dtos;

import java.util.Date;

public class HorarioDTO {
    private long id;
    private long idPadre;
    private String tipo;
    private Date fechaInicio;
    private Date fechaFin;

    public HorarioDTO(long id, long idPadre, String tipo, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.idPadre = idPadre;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public HorarioDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
