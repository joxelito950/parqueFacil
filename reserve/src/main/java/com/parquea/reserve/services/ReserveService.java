package com.parquea.reserve.services;

import com.parquea.reserve.controllers.dtos.HorarioDTO;
import com.parquea.reserve.controllers.dtos.ReserveDTO;
import com.parquea.reserve.entity.dao.IReserveDao;
import com.parquea.reserve.entity.models.Plaza;
import com.parquea.reserve.entity.models.Reserve;
import com.parquea.reserve.exceptions.InvalidDTOException;
import com.parquea.reserve.exceptions.NotFoundException;
import com.parquea.reserve.utils.DateUtils;
import com.parquea.reserve.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.TimeLimitExceededException;
import java.util.List;

@Service
public class ReserveService {
    @Autowired
    private IReserveDao reserveDao;
    @Autowired
    private ParqueaderoService parqueaderoService;
    @Autowired
    private PlazaService plazaService;
    @Autowired
    private HorarioService horarioService;

    public Reserve getReserveById(long id) {
        return reserveDao.findById(id).orElse(new Reserve());
    }

    public List<Reserve> getAllReserves() {
        return (List<Reserve>) reserveDao.findAll();
    }

    public long setReserva(ReserveDTO reserveDTO) throws InvalidDTOException, NotFoundException, TimeLimitExceededException {
        isvalidateReserveDTO(reserveDTO);
        isValidHorario(reserveDTO.getHorario());

        Plaza plazaDisponible = getPlazaDisponible(reserveDTO.getHorario(), reserveDTO.getIdParqueadero());
        HorarioDTO horario = reserveDTO.getHorario();
        horario.setIdPadre(plazaDisponible.getId());
        long horarioId = horarioService.saveHorario(horario);
        plazaDisponible.setIdHorario(horarioId);
        plazaService.updatePlaza(plazaDisponible);

        Reserve modelreserve = new Reserve(plazaDisponible.getId(), reserveDTO.getName());
        return reserveDao.save(modelreserve).getId();
    }

    private Plaza getPlazaDisponible(HorarioDTO horario, long idParqueadero) throws NotFoundException, InvalidDTOException {
        List<Plaza> plazasDisponibles;
        plazasDisponibles = plazaService.getPlazasDisponibles(idParqueadero, horario.getFechaInicio());
        if (plazasDisponibles.isEmpty()) {
            String message = String.format("No hay plazas disponibles para el parqueadero entre %tc y %tc", horario.getFechaInicio(), horario.getFechaFin());
            throw new NotFoundException(message);
        }
        return plazasDisponibles.get(0);
    }

    public void isValidHorario(HorarioDTO horario) throws InvalidDTOException, TimeLimitExceededException {
        horarioService.isValidHorarioDTO(horario);
        StringBuilder message = new StringBuilder();
        message.append("Reserva invalida:\n");
        boolean error = false;
        if (DateUtils.isAfterTime(horario.getFechaInicio())) {
            message.append("La fecha de inicio debe ser mayor a la fecha actual\n");
            error = true;
        }
        if (DateUtils.isAfterTime(horario.getFechaFin())) {
            message.append("La fecha de fin debe ser mayor a la fecha actual\n");
            error = true;
        }
        if (DateUtils.isAfterTime(horario.getFechaInicio(), horario.getFechaFin())) {
            message.append("La fecha de inicio debe ser mayor a la fecha fin\n");
            error = true;
        }
        if(error){
            throw new TimeLimitExceededException(message.toString());
        }
    }

    public void isvalidateReserveDTO(ReserveDTO reserveDTO) throws InvalidDTOException {
        StringBuilder message = new StringBuilder();
        message.append("Reserva invalida falta:\n");
        boolean error = false;
        if (null == reserveDTO) {
            message.append("Todos los datos\n");
            throw new InvalidDTOException(message.toString());
        }
        if (!ValidationUtils.isValidId(reserveDTO.getIdParqueadero())) {
            message.append("El id del parqueadero\n");
            error = true;
        }
        if (error) {
            throw new InvalidDTOException(message.toString());
        }
    }

    public void delete(long id) {
        reserveDao.deleteById(id);
    }
}
