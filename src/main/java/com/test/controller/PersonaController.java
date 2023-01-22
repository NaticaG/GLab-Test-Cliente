package com.test.controller;

import com.test.entity.Persona;
import com.test.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class PersonaController {

    @Autowired
    private PersonaService personaService;
    
    @PostMapping(value="/create")
    public ResponseEntity<?> crearPersona(@RequestBody Persona cliente){
        return ResponseEntity.status(HttpStatus.OK).body(personaService.createPerson(cliente));
    }
    
    @GetMapping(value="/find")
    public ResponseEntity<?> buscarPersona(@RequestParam(name="identification") String identification){
        return ResponseEntity.status(HttpStatus.OK).body(personaService.getPerson(identification));
    }
}
