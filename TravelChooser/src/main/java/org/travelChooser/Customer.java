package org.travelChooser;

import java.util.UUID;

public class Customer {
    private UUID id;
    private String name;
    private String lastname;
    private String address;
    Trip trip;

    public Customer(UUID id, String name, String surname, String  address, Trip trip){
        this.id = id;
        this.name = name;
        this.lastname = surname;
        this.address = address;
        this.trip = trip;
    }
    public Customer(UUID id, String name, String surname, String  address){
        this.name = name;
        this.lastname = surname;
        this.address = address;
    }

    private boolean isTrip(){
        if(trip == null){
            return false;
        }
        return true;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", name: " + name +
                ", surname: " + lastname +
                ", address: " + address +
                ", tour: " + (isTrip() ? trip : "no trip for this customer");
    }
}
