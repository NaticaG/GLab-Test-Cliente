package com.test.dao;

import com.test.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaDAO extends JpaRepository<Persona, Integer> {
    @Query(value = "SELECT * FROM persona WHERE identificacion = :identification", nativeQuery=true)
    Persona getPerson(String identification);

}
