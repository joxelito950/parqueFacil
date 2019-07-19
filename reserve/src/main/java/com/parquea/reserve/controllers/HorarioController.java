package com.parquea.reserve.controllers;

import com.parquea.reserve.controllers.dtos.HorarioDTO;
import com.parquea.reserve.entity.models.Horario;
import com.parquea.reserve.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
    @Autowired
    HorarioService horarioService;


    @GetMapping("/{id}")
    public List<Horario> getHorario(@PathVariable(value = "id") long id) {
        return horarioService.getHorariosByIdPagre(id);
    }

    @PostMapping("/save")
    public void saveHorario(HorarioDTO horarioDTO) {
        horarioService.saveHorario(horarioDTO);
    }
}

