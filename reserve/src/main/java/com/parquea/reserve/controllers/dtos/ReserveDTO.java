package com.parquea.reserve.controllers.dtos;

public class ReserveDTO {
    private String name;
    private HorarioDTO horario;
    private long idParqueadero;

    public ReserveDTO(String name, HorarioDTO horario, long idParqueadero) {
        this.name = name;
        this.horario = horario;
        this.idParqueadero = idParqueadero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HorarioDTO getHorario() {
        return horario;
    }

    public void setHorario(HorarioDTO horario) {
        this.horario = horario;
    }

    public long getIdParqueadero() {
        return idParqueadero;
    }

    public void setIdParqueadero(long idParqueadero) {
        this.idParqueadero = idParqueadero;
    }
}
