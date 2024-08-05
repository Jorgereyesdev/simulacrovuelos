package com.riwi.controllers;

import com.riwi.entities.Passenger;
import com.riwi.models.PassengerModelImpl;
import com.riwi.persistence.imodel.IPassengerModel;

import java.util.List;

public class PassengerController {
    IPassengerModel passengerModel = new PassengerModelImpl();

    public Passenger create(Passenger request){
        return this.passengerModel.create(request);
    }

    public void delete(Integer id) {
        this.passengerModel.delete(id);
    }

    public Passenger update(Passenger request) {
        return this.passengerModel.update(request);
    }

    public List<Passenger> findByName(String name) {
        return this.passengerModel.findByName(name);
    }
}
