package com.parquea.reserve.entity.services;

import com.parquea.reserve.controllers.dtos.ReserveDTO;
import com.parquea.reserve.entity.dao.IReserveDao;
import com.parquea.reserve.entity.models.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {
    @Autowired
    private IReserveDao reserveDao;

    public Reserve getReserveById(long id) {
        return reserveDao.findById(id).orElse(new Reserve());
    }

    public List<Reserve> getAllReserves() {
        return (List<Reserve>) reserveDao.findAll();
    }

    public void setReserva(ReserveDTO reserveDTO) {
        Reserve modelreserve = new Reserve();
        modelreserve.setDay(reserveDTO.getDay());
        modelreserve.setId(reserveDTO.getId());
        modelreserve.setName(reserveDTO.getName());
        reserveDao.save(modelreserve);
    }

    public void delete(long id) {
        reserveDao.deleteById(id);
    }
}
