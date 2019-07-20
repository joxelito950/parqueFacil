package com.parquea.reserve.services;

import com.parquea.reserve.controllers.dtos.HorarioDTO;
import com.parquea.reserve.controllers.dtos.ReserveDTO;
import com.parquea.reserve.entity.dao.IReserveDao;
import com.parquea.reserve.entity.models.Reserve;
import com.parquea.reserve.exceptions.InvalidDTOException;
import com.parquea.reserve.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public long setReserva(ReserveDTO reserveDTO) throws InvalidDTOException {
        isvalidateReserveDTO(reserveDTO);
        
        Reserve modelreserve = new Reserve();
        modelreserve.setName(reserveDTO.getName());

        return reserveDao.save(modelreserve).getId();
    }

    private void isvalidateReserveDTO(ReserveDTO reserveDTO) throws InvalidDTOException {
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
