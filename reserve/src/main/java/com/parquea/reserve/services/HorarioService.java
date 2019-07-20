package com.parquea.reserve.services;

import com.parquea.reserve.controllers.dtos.HorarioDTO;
import com.parquea.reserve.entity.dao.IHorarioDao;
import com.parquea.reserve.entity.models.Horario;
import com.parquea.reserve.exceptions.InvalidDTOException;
import com.parquea.reserve.utils.ValidationUtils;
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

    public long saveHorario(HorarioDTO horarioDTO) throws InvalidDTOException {
        isValidHorarioDTO(horarioDTO);
        Horario horario = new Horario();
        BeanUtils.copyProperties(horarioDTO, horario);
        return horarioDao.save(horario).getId();
    }

    public void isValidHorarioDTO(HorarioDTO horarioDTO) throws InvalidDTOException {
        StringBuilder message = new StringBuilder();
        message.append("Horario invalido falta:");
        boolean error = false;
        if (null == horarioDTO) {
            message.append("Todos los datos");
            throw new InvalidDTOException(message.toString());
        }
        if (null != horarioDTO.getFechaFin()) {
            message.append("La fecha fin");
            error = true;
        }
        if (null != horarioDTO.getFechaInicio()) {
            message.append("La fecha inicio");
            error = true;
        }
        if (ValidationUtils.isValidId(horarioDTO.getIdPadre())) {
            message.append("El id padre");
            error = true;
        }
        if (error) {
            throw new InvalidDTOException(message.toString());
        }
    }

    public void deleteHorarioById(long id) {
        horarioDao.deleteById(id);
    }
}
