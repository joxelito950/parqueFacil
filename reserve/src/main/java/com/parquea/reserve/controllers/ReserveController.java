package com.parquea.reserve.controllers;

import com.parquea.reserve.controllers.dtos.ReserveDTO;
import com.parquea.reserve.entity.models.Reserve;
import com.parquea.reserve.entity.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    @GetMapping("/all")
    public List<Reserve> getAllReserves() {
        return reserveService.getAllReserves();
    }

    @GetMapping("/{id}")
    public Reserve getReserve(@PathVariable(value = "id") long id) {
        return reserveService.getReserveById(id);
    }

    @PostMapping("/save")
    public void saveReserve(ReserveDTO reserve) {
        reserveService.setReserva(reserve);
    }

    @DeleteMapping("/{id}")
    public void deleteReserve(@PathVariable(value = "id") long id) {
        reserveService.delete(id);
    }
}
