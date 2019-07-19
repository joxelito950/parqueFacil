package com.parquea.reserve.services;

import com.parquea.reserve.controllers.dtos.HorarioDTO;
import com.parquea.reserve.entity.dao.IHorarioDao;
import com.parquea.reserve.entity.models.Horario;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {
    @Autowired
    private IHorarioDao horarioDao;

    public Horario getHorarioById(long id) {
        return horarioDao.findById(id).orElse(new Horario());
    }

    public List<Horario> getHorariosByIdPagre(long id) {
        return horarioDao.findByIdPadre(id);
    }

    public long saveHorario(HorarioDTO horarioDTO) {
        Horario horario = new Horario();
        BeanUtils.copyProperties(horarioDTO, horario);
        return horarioDao.save(horario).getId();
    }

    public void deleteHorarioById(long id) {
        horarioDao.deleteById(id);
    }
}
