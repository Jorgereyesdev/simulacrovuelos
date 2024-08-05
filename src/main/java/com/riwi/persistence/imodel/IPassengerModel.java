package com.riwi.persistence.imodel;

import com.riwi.entities.Passenger;
import com.riwi.persistence.crud.CreateModel;
import com.riwi.persistence.crud.DeleteModel;
import com.riwi.persistence.crud.UpdateModel;

import java.util.List;

public interface IPassengerModel extends
        CreateModel<Passenger>,
        UpdateModel<Passenger>,
        DeleteModel<Integer> {
    List<Passenger> findByName(String name);
}
