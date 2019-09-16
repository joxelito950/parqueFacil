package com.parquea.reserve.services;

import com.parquea.reserve.controllers.dtos.HorarioDTO;
import com.parquea.reserve.entity.dao.IHorarioDao;
import com.parquea.reserve.entity.models.Horario;
import com.parquea.reserve.exceptions.InvalidDTOException;
import com.parquea.reserve.exceptions.NotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HorarioServiceTest {
    public static final long ID_HORARIO = 1L;
    @InjectMocks
    private HorarioService horarioService;

    @Mock
    private IHorarioDao horarioDao;

    @Captor
    ArgumentCaptor<Horario> horarioArgumentCaptor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Horario horario;
    private HorarioDTO horarioDTO;

    @Before
    public void inicializarTest() {
        horario = new Horario();
        horarioDTO = new HorarioDTO();
    }

    @Test
    public void getHorariosByIdPagreExist() throws NotFoundException {

        Optional<List<Horario>> optinalHorarios = Optional.of(Arrays.asList(horario));
        Mockito.when(horarioDao.findByIdPadre("parqueadero", 1L)).thenReturn(optinalHorarios);

        List<Horario> horarios = horarioService.getHorariosByIdPagre("parqueadero", 1L);

        assertFalse("se espera una lista con horarios", horarios.isEmpty());
    }

    @Test
    public void getHorariosByIdPagreNoExist() throws NotFoundException {
        expectedException.expect(NotFoundException.class);
        expectedException.expectMessage("No se encontraron horarios");

        horarioService.getHorariosByIdPagre("plaza", 1L);
    }

    @Test
    public void saveHorario() throws InvalidDTOException {
        horarioDTO.setFechaInicio(LocalDateTime.now().plusHours(1));
        horarioDTO.setIdPadre(1L);
        horarioDTO.setTipo("prueba");
        horarioDTO.setFechaFin(LocalDateTime.now().plusHours(2L));

        horario.setId(ID_HORARIO);
        Mockito.when(horarioDao.save(horarioArgumentCaptor.capture())).thenReturn(horario);

        long idHorario = horarioService.saveHorario(horarioDTO);

        assertEquals("se espera sea el IdHorario retornado por el DAO", ID_HORARIO, idHorario);
        assertEquals("se espera que el tipo sea", horarioDTO.getTipo(), horarioArgumentCaptor.getValue().getTipo());
        assertNotNull("se espera guarde fecha inicial", horarioArgumentCaptor.getValue().getFechaInicio());
        assertNotNull("se espera guarde fecha final", horarioArgumentCaptor.getValue().getFechaFin());
        assertEquals("se espera que la fecha de inicio sea", horarioDTO.getFechaInicio(), horarioArgumentCaptor.getValue().getFechaInicio());
        assertEquals("se espera que la fecha de fin sea", horarioDTO.getFechaFin(), horarioArgumentCaptor.getValue().getFechaFin());
    }

    @Test
    public void isValidHorarioDTO() throws InvalidDTOException {
        horarioDTO.setFechaInicio(LocalDateTime.now().plusHours(1));
        horarioDTO.setIdPadre(1L);
        horarioDTO.setTipo("prueba");
        horarioDTO.setFechaFin(LocalDateTime.now().plusHours(2L));

        horarioService.isValidHorarioDTO(horarioDTO);
    }

    @Test
    public void isInvalidHorarioDto() throws InvalidDTOException {
        expectedException.expect(InvalidDTOException.class);
        expectedException.expectMessage("Horario invalido falta:\nTodos los datos.");

        horarioService.isValidHorarioDTO(null);
    }

    @Test
    public void isInvalidHorarioDtoByfechaInicial() throws InvalidDTOException {
        expectedException.expect(InvalidDTOException.class);
        expectedException.expectMessage("Horario invalido falta:\nLa fecha inicio.");

        horarioDTO.setFechaFin(LocalDateTime.now());
        horarioDTO.setIdPadre(1);
        horarioService.isValidHorarioDTO(horarioDTO);
    }

    @Test
    public void isInvalidHorarioDtoByfechaFin() throws InvalidDTOException {
        expectedException.expect(InvalidDTOException.class);
        expectedException.expectMessage("Horario invalido falta:\nLa fecha fin.");

        horarioDTO.setFechaInicio(LocalDateTime.now());
        horarioDTO.setTipo("prueba");
        horarioDTO.setIdPadre(1);
        horarioService.isValidHorarioDTO(horarioDTO);
    }

    @Test
    public void isInvalidHorarioDtoByidPadre() throws InvalidDTOException {
        expectedException.expect(InvalidDTOException.class);
        expectedException.expectMessage("Horario invalido falta:\nEl id padre.");

        horarioDTO.setFechaInicio(LocalDateTime.now());
        horarioDTO.setFechaFin(LocalDateTime.now());
        horarioService.isValidHorarioDTO(horarioDTO);
    }
}