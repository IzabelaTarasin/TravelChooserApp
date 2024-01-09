package org.travelChooser;

import java.time.LocalDate;

public class AbroadTrip extends Trip {
    private double insurance;

    public AbroadTrip(LocalDate start, LocalDate end, String place, String name, double price, double insurance){
        super(start, end, place, name, price);
        this.insurance = insurance;
    }

    @Override
    public double getPrice(){
        return price + insurance;
    }
}
