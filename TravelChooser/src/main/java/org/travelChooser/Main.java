package org.travelChooser;

import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        TravelOffice travelOffice = new TravelOffice();

        Trip trip = new Trip(
                LocalDate.of(2024, 5, 12),
                LocalDate.of(2024, 5, 27),
                "Rome",
                "Beautiful Rome",
                12000);
        AbroadTrip abroadTrip = new AbroadTrip(
                LocalDate.of(2024, 7, 5),
                LocalDate.of(2024, 7, 17),
                "Warsaw",
                "Your Warsaw",
                7000,
                1000);
        DomesticTrip domesticTrip = new DomesticTrip(
                LocalDate.of(2024, 2, 13),
                LocalDate.of(2024, 2, 20),
                "Helsinki",
                "Helsinki in few days",
                16000,
                4000);

        Customer customer1 =  new Customer(
                UUID.randomUUID(),
                "Diana",
                "Doe",
                "123 Main St, New York",
                abroadTrip);

        Customer customer2 =  new Customer(
                UUID.randomUUID(),
                "Bella",
                "Smith",
                "456 Elm St, Paris",
                domesticTrip);

        Customer customerWithoutTrip =  new Customer(
                UUID.randomUUID(),
                "Diego",
                "Johnson",
                "89 Oak St, London");

        travelOffice.addCustomer(customer1);
        travelOffice.addCustomer(customer2);
        travelOffice.addCustomer(customerWithoutTrip);

        System.out.println(travelOffice.getCustomersInfo());


    }
}