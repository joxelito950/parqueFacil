package com.parquea.reserve.services;

import com.parquea.reserve.controllers.dtos.ParqueaderoDTO;
import com.parquea.reserve.entity.dao.IParqueaderoDao;
import com.parquea.reserve.entity.models.Parqueadero;
import com.parquea.reserve.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParqueaderoService {
    @Autowired
    private IParqueaderoDao parqueaderoDao;

    public List<Parqueadero> getAllParqueaderos() {
        return (List<Parqueadero>) parqueaderoDao.findAll();
    }

    public Parqueadero getParqueadero(long id) throws NotFoundException {
        Optional<Parqueadero> optionalParqueadero = parqueaderoDao.findById(id);
        if (optionalParqueadero.isPresent()) {
            return optionalParqueadero.get();
        } else {
            throw new NotFoundException(String.format("No existe parqueadero con el id: %d", id));
        }
    }

    public void saveParqueadero(ParqueaderoDTO parqueaderoDto) {
        Parqueadero parqueadero = new Parqueadero();
        BeanUtils.copyProperties(parqueaderoDto, parqueadero);
        parqueaderoDao.save(parqueadero);
    }
}
