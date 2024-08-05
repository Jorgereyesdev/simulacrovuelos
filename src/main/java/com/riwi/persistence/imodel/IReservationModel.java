package com.riwi.persistence.imodel;

import com.riwi.entities.Reservation;
import com.riwi.persistence.crud.CreateModel;
import com.riwi.persistence.crud.DeleteModel;
import com.riwi.persistence.crud.UpdateModel;

import java.util.List;

public interface IReservationModel extends
        CreateModel<Reservation>,
        UpdateModel<Reservation>,
        DeleteModel<Integer> {
    List<Reservation> getAllReservationsByFlight(Integer idFlight);
}
