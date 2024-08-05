package com.riwi.entities;

public class Passenger {
    private Integer id;
    private String name;
    private String lastname;
    private String document;

    public Passenger() {
    }

    public Passenger(String name, String lastname, String document) {
        this.name = name;
        this.lastname = lastname;
        this.document = document;
    }

    public Passenger(int id, String name, String lastname, String document) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", lastName='" + this.lastname + '\'' +
                ", document='" + this.document + '\'' +
                '}';
    }
}
