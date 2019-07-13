package com.parquea.reserve.entity.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "reservas")
public class Reserve implements Serializable {
    @Id
    private long id;

    @NotEmpty
    private String name;

    @NotNull
    private int dia;

    public Reserve(@NotEmpty String name, @NotNull int dia) {
        this.name = name;
        this.dia = dia;
    }

    public Reserve() {
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

    public int getDay() {
        return dia;
    }

    public void setDay(int dia) {
        this.dia = dia;
    }
}
