package com.parquea.reserve.entity.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "plazas")
public class Plaza implements Serializable {
    @Id
    private long id;

    @NotNull
    @Column(name = "id_parqueadero")
    private long idParqueadero;

    @NotEmpty
    private String ubicacion;

    @Column(name = "id_horario")
    private Long idHorario;

    public Plaza() {
    }

    public Plaza(@NotNull long idParqueadero, @NotEmpty String ubicacion, @NotNull long idHorario) {
        this.idParqueadero = idParqueadero;
        this.ubicacion = ubicacion;
        this.idHorario = idHorario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(long idParqueadero) {
        this.idParqueadero = idParqueadero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(long idHorario) {
        this.idHorario = idHorario;
    }
}
