package com.riwi.controllers;

import com.riwi.entities.Flight;
import com.riwi.persistence.imodel.IFlightModel;
import com.riwi.models.FlightModelImpl;

import java.util.List;

public class FlightController {
    IFlightModel flightModel = new FlightModelImpl();

    public Flight create(Flight request) {
        return this.flightModel.create(request);
    }

    public void delete(Integer id) {
        this.flightModel.delete(id);
    }

    public Flight update(Flight request) {
        return this.flightModel.update(request);
    }

    public List<Flight> readByDestination(String destination) {
        return this.flightModel.readByDestination(destination);
    }
}
