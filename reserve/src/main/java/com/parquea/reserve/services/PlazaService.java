package com.parquea.reserve.services;

import com.parquea.reserve.controllers.dtos.PlazaDTO;
import com.parquea.reserve.entity.dao.IPlazaDao;
import com.parquea.reserve.entity.models.Plaza;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlazaService {
    @Autowired
    private IPlazaDao plazaDao;

    public Plaza getPlazaById(long id) {
        return plazaDao.findById(id).orElse(new Plaza());
    }

    public List<Plaza> getPlazasByIdParqueadero(long id) {
        return plazaDao.getPlazaByIdParqueadero(id);
    }

    public List<Plaza> getPlazasDisponibles(long idParqueadero, LocalDateTime fechaInicial) {
        return plazaDao.getPlazasDisponibles(idParqueadero, fechaInicial);
    }

    public long savePlaza(PlazaDTO plazaDTO) {
        Plaza plaza = new Plaza();
        BeanUtils.copyProperties(plazaDTO, plaza);
        return plazaDao.save(plaza).getId();
    }

    public void deletePlazaById(long id) {
        plazaDao.deleteById(id);
    }

    public void updatePlaza(Plaza plaza) {
        plazaDao.save(plaza);
    }
}
