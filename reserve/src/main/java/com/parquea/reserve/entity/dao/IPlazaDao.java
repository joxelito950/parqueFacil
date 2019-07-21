package com.parquea.reserve.entity.dao;

import com.parquea.reserve.entity.models.Plaza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IPlazaDao extends CrudRepository<Plaza, Long> {

    @Query("select p from Plaza p where idParqueadero = :id")
    Optional<List<Plaza>> getPlazasByIdParqueadero(long id);

    @Query("select p from Plaza p where p.idParqueadero = :id and p.idHorario is null or p.idParqueadero = :id and p.id in (select h.idPadre from Horario h where h.fechaFin < :fechaInicial)")
    Optional<List<Plaza>> getPlazasDisponibles(@Param("id") long id, @Param("fechaInicial") LocalDateTime fechaInicial);
}
