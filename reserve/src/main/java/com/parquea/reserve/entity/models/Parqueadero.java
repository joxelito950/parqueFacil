package com.parquea.reserve.entity.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "parqueaderos")
public class Parqueadero implements Serializable {
    @Id
    private Long id;

    @NotEmpty
    private String nombre;

    public Parqueadero() {
    }

    public Parqueadero(@NotEmpty String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
