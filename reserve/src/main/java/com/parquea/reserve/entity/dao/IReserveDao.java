package com.parquea.reserve.entity.dao;

import com.parquea.reserve.entity.models.Reserve;
import org.springframework.data.repository.CrudRepository;

public interface IReserveDao extends CrudRepository<Reserve, Long> {
}
