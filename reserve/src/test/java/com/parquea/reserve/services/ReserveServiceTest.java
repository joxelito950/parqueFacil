package com.parquea.reserve.services;

import com.parquea.reserve.controllers.dtos.HorarioDTO;
import com.parquea.reserve.controllers.dtos.ReserveDTO;
import com.parquea.reserve.entity.dao.IReserveDao;
import com.parquea.reserve.entity.models.Parqueadero;
import com.parquea.reserve.entity.models.Reserve;
import com.parquea.reserve.exceptions.InvalidDTOException;
import com.parquea.reserve.exceptions.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import javax.naming.TimeLimitExceededException;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class ReserveServiceTest {
    public static final int ID_PARQUEADERO = 1;
    public static final int ID_RESERVA = 2;
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

    @Captor
    public ArgumentCaptor<Reserve> reserveArgumentCaptor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ReserveDTO reserveDTO;
    private HorarioDTO horario;
    private Reserve reserve;
    private Parqueadero parqueadero;

    @Before
    public void inicializarTest() {
        reserveDTO = new ReserveDTO();
        horario = new HorarioDTO();
        reserve = new Reserve();
        parqueadero = new Parqueadero();
    }

    @Test
    public void setReservaValida() throws InvalidDTOException, NotFoundException, TimeLimitExceededException {
        long currentTime = new Date().getTime();
        //TODO: crear utilidad para generar fechas validas, ¿posible cambiar Date a LocalDate?
        horario.setFechaInicio(new Date(currentTime + 1));
        horario.setFechaFin(new Date(currentTime + 9));
        reserveDTO.setHorario(horario);
        reserveDTO.setIdParqueadero(ID_PARQUEADERO);
        parqueadero.setId(ID_PARQUEADERO);
        reserve.setId(ID_RESERVA);


        Mockito.when(parqueaderoService.getParqueadero(ID_PARQUEADERO)).thenReturn(parqueadero);
        Mockito.when(reserveDao.save(reserveArgumentCaptor.capture())).thenReturn(reserve);

        long idReserva = reserveService.setReserva(reserveDTO);

        Assert.assertEquals("se esperaba el id de la reserva", ID_RESERVA, idReserva);
    }

    @Test
    public void isinvalidateReserveDTOAll() throws InvalidDTOException, NotFoundException, TimeLimitExceededException {
        expectedException.expect(InvalidDTOException.class);
        expectedException.expectMessage("Reserva invalida falta:\nTodos los datos");
        reserveService.setReserva(null);
    }

    @Test
    public void isinvalidateReserveDTO() throws InvalidDTOException, NotFoundException, TimeLimitExceededException {
        expectedException.expect(InvalidDTOException.class);
        expectedException.expectMessage("Reserva invalida falta:\nEl id del parqueadero");
        reserveService.setReserva(reserveDTO);
    }
}