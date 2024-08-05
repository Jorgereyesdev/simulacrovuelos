package com.riwi.persistence.imodel;

import com.riwi.entities.Flight;
import com.riwi.persistence.crud.*;

import java.util.List;

public interface IFlightModel extends
        CreateModel<Flight>,
        DeleteModel<Integer>,
        UpdateModel<Flight> {
    List<Flight> readByDestination(String destination);
}
