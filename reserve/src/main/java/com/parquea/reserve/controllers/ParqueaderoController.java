package com.parquea.reserve.controllers;

import com.parquea.reserve.entity.models.Parqueadero;
import com.parquea.reserve.exceptions.NotFoundException;
import com.parquea.reserve.services.ParqueaderoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/parqueaderos")
public class ParqueaderoController {
    @Autowired
    private ParqueaderoService parqueaderoService;

    @GetMapping("/all")
    public List<Parqueadero> getAll() {
        return parqueaderoService.getAllParqueaderos();
    }

    @GetMapping("/{id}")
    public Parqueadero getParqueadero(@PathVariable(value = "id") long id) throws NotFoundException {
        return parqueaderoService.getParqueadero(id);
    }
}
