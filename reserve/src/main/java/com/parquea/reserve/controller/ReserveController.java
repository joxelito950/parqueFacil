package com.parquea.reserve.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @PostMapping("/save")
    public String saveReserve() {
        return "saved.";
    }
}
