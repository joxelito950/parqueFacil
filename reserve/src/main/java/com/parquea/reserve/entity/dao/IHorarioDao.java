package com.parquea.reserve.entity.dao;

import com.parquea.reserve.entity.models.Horario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IHorarioDao extends CrudRepository<Horario, Long> {

    @Query("select h from Horario h where c.idPadre = :id")
    List<Horario> findByIdPadre(long id);
}
