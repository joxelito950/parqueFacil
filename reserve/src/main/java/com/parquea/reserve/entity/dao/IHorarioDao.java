package com.parquea.reserve.entity.dao;

import com.parquea.reserve.entity.models.Horario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IHorarioDao extends CrudRepository<Horario, Long> {

    @Query("select h from Horario h where h.idPadre = :id")
    Optional<List<Horario>> findByIdPadre(@Param("id") long id);
}
