package com.parquea.reserve.entity.dao;

import com.parquea.reserve.entity.models.Plaza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IPlazaDao extends CrudRepository<Plaza, Long> {

    @Query("select p from Plaza p where idParqueadero = :id")
    List<Plaza> getPlazaByIdParqueadero(long id);

    @Query("select p from Plaza p where p.idHorario = null and p.idParqueadero = :id and p.id = (select h.idPadre from Horario h where h.fechaFin < :fechaInicial)")
    List<Plaza> getPlazasDisponibles(long id, LocalDateTime fechaInicial);
}
