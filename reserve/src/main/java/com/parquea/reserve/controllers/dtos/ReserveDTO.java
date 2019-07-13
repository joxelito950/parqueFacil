package com.parquea.reserve.controllers.dtos;

import com.parquea.reserve.entity.models.Reserve;

public class ReserveDTO extends Reserve {
    private long id;
    private String name;
    private int day;

    public ReserveDTO(long id, String name, int day) {
        this.id = id;
        this.name = name;
        this.day = day;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getDay() {
        return day;
    }

    @Override
    public void setDay(int day) {
        this.day = day;
    }
}
