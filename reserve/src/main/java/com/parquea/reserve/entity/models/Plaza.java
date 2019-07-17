package com.parquea.reserve.entity.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "palzas")
public class Plaza {
    @Id
    private long id;

    @NotNull
    @Column(name = "id_parqueadero")
    private long idParqueadero;

    @NotEmpty
    private String ubicacion;

    public Plaza(@NotNull long idParqueadero, @NotEmpty String ubicacion) {
        this.idParqueadero = idParqueadero;
        this.ubicacion = ubicacion;
    }

    public Plaza() {
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
}
