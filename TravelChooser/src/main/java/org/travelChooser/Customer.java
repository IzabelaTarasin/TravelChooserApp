package org.travelChooser;

public class Customer {
    private String name;
    private String surname;
    private String address;
    Trip trip;

    public Customer(String name, String surname, String  address, Trip trip){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.trip = trip;
    }
    public Customer(String name, String surname, String  address){
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    private boolean isTrip(){
        if(trip == null){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", surname: " + surname + ", address: " + address + ", tour: " + (isTrip() ? trip : "no trip for this customer");
    }
}
