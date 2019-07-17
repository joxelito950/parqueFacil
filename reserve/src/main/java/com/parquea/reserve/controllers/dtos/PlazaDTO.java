package com.parquea.reserve.controllers.dtos;

public class PlazaDTO {
    private long id;
    private long idParqueadero;
    private String ubicacion;

    public PlazaDTO(long id, long idParqueadero, String ubicacion) {
        this.id = id;
        this.idParqueadero = idParqueadero;
        this.ubicacion = ubicacion;
    }

    public PlazaDTO() {
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
