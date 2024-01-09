package org.travelChooser;

import java.time.LocalDate;

public class Trip {
    private LocalDate startTime;
    private LocalDate endTime;
    private String place;
    private String name;
    public double price;

    public Trip(LocalDate startTime, LocalDate endTime, String place, String name, double price) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
        this.name = name;
        this.price = price;
    }

    /* https://testelka.pl/kurs/java-dla-testerow/gettery-i-settery/ */
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public String getPlace() {
        return place;
    }

    /* https://javastart.pl/baza-wiedzy/programowanie-obiektowe/metoda-tostring */
    @Override
    public String toString() {
        return "Start date: " + startTime + ", end date: " + endTime + ", place: " + place + ", price: " + getPrice() + "EUR";
    }
}

