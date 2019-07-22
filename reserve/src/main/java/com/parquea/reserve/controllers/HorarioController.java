package com.parquea.reserve.controllers;

import com.parquea.reserve.controllers.dtos.HorarioDTO;
import com.parquea.reserve.entity.models.Horario;
import com.parquea.reserve.exceptions.InvalidDTOException;
import com.parquea.reserve.exceptions.NotFoundException;
import com.parquea.reserve.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
    @Autowired
    HorarioService horarioService;

    @CrossOrigin
    @GetMapping("/{tipo}/{id}")
    public List<Horario> getHorario(@PathVariable(value = "tipo") String tipo, @PathVariable(value = "id") long id) throws NotFoundException {
        return horarioService.getHorariosByIdPagre(tipo, id);
    }

    @PostMapping("/save")
    public void saveHorario(HorarioDTO horarioDTO) throws InvalidDTOException {
        horarioService.saveHorario(horarioDTO);
    }
}

