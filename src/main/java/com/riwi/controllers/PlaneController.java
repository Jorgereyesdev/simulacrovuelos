package com.riwi.controllers;

import com.riwi.entities.Plane;
import com.riwi.models.PlaneModelImpl;
import com.riwi.persistence.imodel.IPlaneModel;

public class PlaneController {
    IPlaneModel planeModel = new PlaneModelImpl();

    public Plane create(Plane request){ return this.planeModel.create(request); }

    public void delete(Integer id) {
        this.planeModel.delete(id);
    }
}
