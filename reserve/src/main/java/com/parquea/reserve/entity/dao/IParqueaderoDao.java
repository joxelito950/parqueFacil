package com.parquea.reserve.entity.dao;

import com.parquea.reserve.entity.models.Parqueadero;
import org.springframework.data.repository.CrudRepository;

public interface IParqueaderoDao extends CrudRepository<Parqueadero, Long> {

}
