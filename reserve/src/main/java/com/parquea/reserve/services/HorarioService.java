package com.parquea.reserve.services;

import com.parquea.reserve.controllers.dtos.HorarioDTO;
import com.parquea.reserve.entity.dao.IHorarioDao;
import com.parquea.reserve.entity.models.Horario;
import com.parquea.reserve.exceptions.InvalidDTOException;
import com.parquea.reserve.exceptions.NotFoundException;
import com.parquea.reserve.utils.ValidationUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {
    @Autowired
    private IHorarioDao horarioDao;

    public Horario getHorarioById(long id) {
        return horarioDao.findById(id).orElse(new Horario());
    }

    public List<Horario> getHorariosByIdPagre(String tipo, long id) throws NotFoundException {
        Optional<List<Horario>> optionalHorarios = horarioDao.findByIdPadre(tipo, id);
        if (optionalHorarios.isPresent()) {
            return optionalHorarios.get();
        } else
            throw new NotFoundException("No se encontraron horarios");
    }

    public long saveHorario(HorarioDTO horarioDTO) throws InvalidDTOException {
        isValidHorarioDTO(horarioDTO);
        Horario horario = new Horario();
        BeanUtils.copyProperties(horarioDTO, horario);
        return horarioDao.save(horario).getId();
    }

    public void isValidHorarioDTO(HorarioDTO horarioDTO) throws InvalidDTOException {
        StringBuilder message = new StringBuilder();
        message.append("Horario invalido falta:\n");
        boolean error = false;
        if (null == horarioDTO) {
            message.append("Todos los datos.\n");
            throw new InvalidDTOException(message.toString());
        }
        if (null == horarioDTO.getFechaFin()) {
            message.append("La fecha fin.\n");
            error = true;
        }
        if (null == horarioDTO.getFechaInicio()) {
            message.append("La fecha inicio.\n");
            error = true;
        }
        if (!ValidationUtils.isValidId(horarioDTO.getIdPadre())) {
            message.append("El id padre.\n");
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
