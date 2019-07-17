package com.parquea.reserve.controllers.dtos;

public class ReserveDTO {
    private long id;
    private String name;
    private int day;

    public ReserveDTO(long id, String name, int day) {
        this.id = id;
        this.name = name;
        this.day = day;
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
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
