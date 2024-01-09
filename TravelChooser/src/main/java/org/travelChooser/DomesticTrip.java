package org.travelChooser;

import java.time.LocalDate;

public class DomesticTrip extends Trip {
    private double ownTransportDiscount;

    public DomesticTrip(LocalDate start, LocalDate end, String place, String name, double price, double ownTransportDiscount){
        super(start, end, place, name, price);

        this.ownTransportDiscount = ownTransportDiscount;
    }

    @Override
    public double getPrice(){
        return price - ownTransportDiscount;
    }
}
