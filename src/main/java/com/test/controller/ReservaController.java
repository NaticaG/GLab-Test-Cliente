package com.test.controller;

import com.test.dto.EmailBody;
import com.test.dto.ReservaDTO;
import com.test.entity.Persona;
import com.test.entity.Reserva;
import com.test.service.EmailService;
import com.test.service.PersonaService;
import com.test.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/booking")
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> generarReserva(@RequestBody ReservaDTO bookingDTO){
        if(bookingDTO.getClient().getIdPersona() == 0){
            Persona cliente = personaService.createPerson(bookingDTO.getClient());
            bookingDTO.getBooking().setIdPersona(cliente.getIdPersona());
            bookingDTO.getBooking().setUserLog(cliente.getIdPersona());
            return ResponseEntity.status(HttpStatus.OK).body(reservaService.generarReserva(bookingDTO.getBooking()));
        }
        bookingDTO.getBooking().setIdPersona(bookingDTO.getClient().getIdPersona());
        bookingDTO.getBooking().setUserLog(bookingDTO.getClient().getIdPersona());
        bookingDTO.setBooking(reservaService.generarReserva(bookingDTO.getBooking()));

        System.out.println("bookingDTO.getBooking().getIdReserva() -> " + bookingDTO.getBooking().getIdReserva());
        if(bookingDTO.getBooking() != null){
            System.out.println("Ingresó a (bookingDTO.getBooking() != null)");
            EmailBody email = new EmailBody();
            email.setContent("Reserva Generada Exitosamente");
            email.setSubject("Confirmación Reserva");
            email.setEmail(bookingDTO.getClient().getEmail());
            emailService.sendEmail(email);
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookingDTO.getBooking());
    }

    @GetMapping
    public ResponseEntity<?> listarReservas(){
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.listarReservas());
    }
}
