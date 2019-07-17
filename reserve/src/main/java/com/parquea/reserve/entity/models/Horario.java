package com.parquea.reserve.entity.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.repository.query.Param;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "horarios")
public class Horario {
    @Id
    private Long id;

    @NotNull
    @Column(name = "id_padre")
    private Long idPadre;

    private String tipo;

    @NotNull
    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @NotNull
    @Column(name = "fecha_fin")
    private Date fechaFin;

    public Horario(String tipo, @NotNull Date fechaInicio, @NotNull Date fechaFin) {
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Horario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
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
