package com.test.dao;

import com.test.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaDAO extends JpaRepository<Reserva, Integer> {

}
