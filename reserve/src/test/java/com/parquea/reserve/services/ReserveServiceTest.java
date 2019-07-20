package com.parquea.reserve.services;

import com.parquea.reserve.entity.dao.IReserveDao;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class ReserveServiceTest {
    @InjectMocks
    private ReserveService reserveService;

    @Mock
    private HorarioService horarioService;
    @Mock
    private PlazaService plazaService;
    @Mock
    private ParqueaderoService parqueaderoService;
    @Mock
    private IReserveDao reserveDao;

    @Test
    public void setReservaValida() {

    }
}