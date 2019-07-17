package com.parquea.reserve.controllers;

import com.parquea.reserve.controllers.dtos.ParqueaderoDTO;
import com.parquea.reserve.entity.models.Parqueadero;
import com.parquea.reserve.entity.services.ParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parqueadero")
public class ParqueaderoController {
    @Autowired
    private ParqueaderoService parqueaderoService;

    @GetMapping("/all")
    public List<Parqueadero> getAll() {
        return parqueaderoService.getAllParqueaderos();
    }

    @GetMapping("/{id}")
    public Parqueadero getParqueadero(@PathVariable(value = "id") long id) {
        return parqueaderoService.getParqueadero(id);
    }

    @PostMapping("/save")
    public void saveParqueadero(ParqueaderoDTO parqueaderoDTO) {
        parqueaderoService.saveParqueadero(parqueaderoDTO);
    }
}
