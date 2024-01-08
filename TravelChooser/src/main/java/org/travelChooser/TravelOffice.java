package org.travelChooser;

public class TravelOffice {
    Customer[] customers = new Customer[2];

    private int numberOfCustomers = 0;
    public void addCustomer(Customer customer) {
        if (numberOfCustomers == customers.length - 1) {
            Customer[] copy = new Customer[customers.length + 2];
            System.arraycopy(customers, 0, copy, 0, customers.length);
            customers = copy;
        }
        customers[numberOfCustomers] = customer;
        numberOfCustomers++;
    }

    public String getCustomersInfo(){
        String infoCustomer = "";
        for(int i = 0; i < numberOfCustomers; i++){
            Customer customer = customers[i];
            infoCustomer += customer + "\n";
        }
        return infoCustomer;
    }
    }
