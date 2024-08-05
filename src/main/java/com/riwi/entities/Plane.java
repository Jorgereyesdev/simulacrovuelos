package com.riwi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Plane {
    private Integer id;
    private String model;
    private Integer capacity;

    public Plane() {
    }

    public Plane(String model, Integer capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public Plane(Integer id, String model, Integer capacity) {
        this.id = id;
        this.model = model;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + this.id +
                ", model='" + this.model + '\'' +
                ", capacity=" + this.capacity +
                '}';
    }
}
