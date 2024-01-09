package org.travelChooser;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TravelOffice {
    //    Customer[] customers = new Customer[2];
    ArrayList<Customer> customers = new ArrayList<>();
    Set<Trip> trips = new HashSet<>();

    private int numberOfCustomers = 0;

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String getCustomersInfo() {
        String infoCustomer = "";

        for (int i = 0; i < customers.size(); i++) {
            infoCustomer += customers.get(i);
        }
        return infoCustomer;
    }

    public void removeCustomerByNameOrLastname(String name){
        customers.removeIf(n -> (n.getName().contains(name) || n.getLastname().contains(name)));
    }

    public boolean setTripToCustomerId(UUID id, Trip trip){
        List<Customer> customersById = customers
                .stream()
                .filter(n -> n.getId() == id)
                .toList();

        if(customersById.isEmpty()){
            return false;
        }
        customersById.get(0).setTrip(trip);
        return true;
    }

    public void addTrip(Trip trip){
        trips.add(trip);
    }

    public List<Trip> searchTripByName(String name){
        List<Trip> tripsByName = trips
                .stream()
                .filter(n  -> n.getName() == name)
                .toList();
        return tripsByName;
    }

    public List<Trip> searchTripByStartDate(LocalDate date){
        List<Trip> tripsByStartDate = trips
                .stream()
                .filter(n -> n.getStartTime().isAfter(date))
                .collect(Collectors.toList());

        return tripsByStartDate;
    }

    public List<Trip> searchTripByPlace(String place){
        List<Trip> tripsByPlace = trips
                .stream()
                .filter(n -> n.getPlace().contains(place))
                .collect(Collectors.toList());

        return tripsByPlace;
    }

}