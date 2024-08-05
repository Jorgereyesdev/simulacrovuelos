package com.riwi.entities;

import java.util.Date;

public class Reservation {
    private Integer id;
    private String date;
    private Integer seat;
    private Integer idPassenger;
    private Integer idFlight;

    public Reservation() {
    }

    public Reservation(Integer id, String date, Integer seat, Integer idPassenger, Integer idFlight) {
        this.id = id;
        this.date = date;
        this.seat = seat;
        this.idPassenger = idPassenger;
        this.idFlight = idFlight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(Integer idPassenger) {
        this.idPassenger = idPassenger;
    }

    public Integer getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Integer idFlight) {
        this.idFlight = idFlight;
    }

    @Override
    public String toString() {
        return "Reservation: " +
                "id=" + id +
                ", date='" + date + '\'' +
                ", seat=" + seat +
                ", idPassenger=" + idPassenger +
                ", idFlight=" + idFlight + "\n";
    }
}
