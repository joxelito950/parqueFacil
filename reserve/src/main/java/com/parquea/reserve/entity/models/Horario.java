package com.parquea.reserve.entity.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "horarios")
public class Horario implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "id_padre")
    private Long idPadre;

    private String tipo;

    @NotNull
    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @NotNull
    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    public Horario() {
    }

    public Horario(String tipo, @NotNull LocalDateTime fechaInicio, @NotNull LocalDateTime fechaFin) {
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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
