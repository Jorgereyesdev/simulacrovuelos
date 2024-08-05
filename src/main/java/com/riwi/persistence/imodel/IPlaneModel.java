package com.riwi.persistence.imodel;

import com.riwi.entities.Plane;
import com.riwi.persistence.crud.CreateModel;
import com.riwi.persistence.crud.DeleteModel;

public interface IPlaneModel extends
        CreateModel<Plane>,
        DeleteModel<Integer>{
}
