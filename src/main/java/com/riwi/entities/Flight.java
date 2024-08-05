package com.riwi.entities;

import java.sql.Time;

public class Flight {
    private Integer id;
    private String destination;
    private String departureDate;
    private Time departureHour;
    private Integer idPlane;

    public Flight() {
    }

    public Flight(String destination, String departureDate, Time departureHour, Integer idPlane) {
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureHour = departureHour;
        this.idPlane = idPlane;
    }

    public Flight(Integer id, String destination, String departureDate, Time departureHour, Integer idPlane) {
        this.id = id;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureHour = departureHour;
        this.idPlane = idPlane;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(Time departureHour) {
        this.departureHour = departureHour;
    }

    public Integer getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(Integer idPlane) {
        this.idPlane = idPlane;
    }

    @Override
    public String toString() {
        return "Flight: " +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureHour=" + departureHour +
                ", idPlane=" + idPlane + "\n";
    }
}
