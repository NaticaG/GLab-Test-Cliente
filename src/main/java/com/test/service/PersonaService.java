package com.test.service;

import com.test.dao.PersonaDAO;
import com.test.entity.Persona;
import com.test.utl.EnumEstados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    @Autowired
    private PersonaDAO personaDAO;

    public Persona getPerson(String identification){
        return personaDAO.getPerson(identification);
    }

    public Persona createPerson(Persona cliente){
        System.out.println("createPerson");
        cliente.setIdRol(2);
        cliente.setEstado(EnumEstados.ACTIVO.getEstado());
        return personaDAO.saveAndFlush(cliente);
    }

}
