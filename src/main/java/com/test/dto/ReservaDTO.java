package com.test.dto;

import com.test.entity.Persona;
import com.test.entity.Reserva;

public class ReservaDTO {
    private Reserva booking;
    private Persona client;

    public Reserva getBooking() {
        return booking;
    }

    public void setBooking(Reserva booking) {
        this.booking = booking;
    }

    public Persona getClient() {
        return client;
    }

    public void setClient(Persona client) {
        this.client = client;
    }
}
