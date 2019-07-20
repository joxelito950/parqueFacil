package com.parquea.reserve.entity.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "reservas")
public class Reserve implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column(name = "id_plaza")
    private long idPlaza;

    @NotEmpty
    private String name;

    @NotNull
    @Column(name = "id_horario")
    private long idHorario;

    public Reserve() {
    }

    public Reserve(@NotNull long idPlaza, @NotEmpty String name, @NotNull long idHorario) {
        this.idPlaza = idPlaza;
        this.name = name;
        this.idHorario = idHorario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(long idHorario) {
        this.idHorario = idHorario;
    }

    public long getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(long idPlaza) {
        this.idPlaza = idPlaza;
    }
}
