package com.parquea.reserve.entity.services;

import com.parquea.reserve.controllers.dtos.ParqueaderoDTO;
import com.parquea.reserve.entity.dao.IParqueaderoDao;
import com.parquea.reserve.entity.models.Parqueadero;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParqueaderoService {
    @Autowired
    private IParqueaderoDao parqueaderoDao;

    public List<Parqueadero> getAllParqueaderos() {
        return (List<Parqueadero>) parqueaderoDao.findAll();
    }

    public Parqueadero getParqueadero(long id) {
        return parqueaderoDao.findById(id).orElse(null);
    }

    public void saveParqueadero(ParqueaderoDTO parqueaderoDto) {
        Parqueadero parqueadero = new Parqueadero();
        BeanUtils.copyProperties(parqueaderoDto, parqueadero);
        parqueaderoDao.save(parqueadero);
    }
}
