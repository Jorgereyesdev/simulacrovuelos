package com.riwi.controllers;

import com.riwi.entities.Reservation;
import com.riwi.models.ReservationModelImpl;
import com.riwi.persistence.imodel.IReservationModel;

import java.util.List;


public class ReservationController {
    IReservationModel reservationModel = new ReservationModelImpl();

    public Reservation create(Reservation request) {
        return this.reservationModel.create(request);
    }

    public void delete(Integer id) {
        this.reservationModel.delete(id);
    }

    public void update(Reservation request) {
        this.reservationModel.update(request);
    }

    public List<Reservation> findByFlight(Integer flightId) {
        return this.reservationModel.getAllReservationsByFlight(flightId);
    }
}
