package com.test.service;

import com.test.entity.Reserva;
import com.test.utl.EnumEstados;
import com.test.dao.ReservaDAO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaDAO reservaDAO;

    public Reserva generarReserva(Reserva booking){
        booking.setEstado(EnumEstados.PENDIENTE.getEstado());
        booking.setFechaLog(new Date());
        return reservaDAO.saveAndFlush(booking);
    }

    public Reserva actualizarReserva(Reserva booking){
        System.out.println("ReservaService - actualizarReserva");
        booking.setFechaLog(new Date());
        return reservaDAO.saveAndFlush(booking);
    }
    public List<Reserva> listarReservas(){
        return reservaDAO.findAll();
    }
}
