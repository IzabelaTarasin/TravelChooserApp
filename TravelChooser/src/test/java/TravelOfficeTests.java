import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.travelChooser.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TravelOfficeTests {
    private TravelOffice travelOffice;
    private Customer customerWithoutTrip;
    private Customer customerWithTrip;
    private DomesticTrip domesticTripToWarsaw;
    private DomesticTrip domesticTripToCracow;
    private AbroadTrip abroadTrip;

    @BeforeEach
    void setUpData(){
        travelOffice = new TravelOffice();
        customerWithoutTrip = new Customer(
                UUID.randomUUID(),
                "Alon",
                "Nowak",
                "Green Street 345 Poland");
        customerWithTrip = new Customer(
                UUID.randomUUID(),
                "Emily",
                "Anderson",
                "123 Maple Street Cityville");
        domesticTripToWarsaw = new DomesticTrip(
                LocalDate.now().plusMonths(1),
                LocalDate.now().plusMonths(2),
                "Warsaw",
                "Awesome trip",
                5000,
                800);
        domesticTripToCracow = new DomesticTrip(
                LocalDate.now().plusMonths(1),
                LocalDate.now().plusMonths(2),
                "Cracow",
                "Awesome trip",
                7000,
                500);
        abroadTrip = new AbroadTrip(
                LocalDate.now().plusMonths(4),
                LocalDate.now().plusMonths(5),
                "Italy",
                "Incredible trip to Italy",
                12000,
                1000);
    }

    @Test
    public void addCustomerWithTrip_ShouldReturnValidResult(){
        travelOffice.addCustomer(customerWithTrip);
        int numberOfCustomers = travelOffice.getCustomers().size();
        assertEquals(1, numberOfCustomers);
    }

    @Test
    public void addCustomerWithoutTrip_ShouldReturnValidResult(){
        travelOffice.addCustomer(customerWithoutTrip);
        int numberOfCustomers = travelOffice.getCustomers().size();
        assertEquals(1, numberOfCustomers);
    }

    @Test
    public void addCustomers_ShouldReturnValidResult(){
        travelOffice.addCustomer(customerWithoutTrip);
        travelOffice.addCustomer(customerWithTrip);
        int numberOfCustomers = travelOffice.getCustomers().size();
        assertEquals(2, numberOfCustomers);
    }

    @Test
    public void removeCustomerByName_ShouldReturnValidResult(){
        travelOffice.addCustomer(customerWithTrip);
        travelOffice.removeCustomerByNameOrLastname("Emily");
        int numberOfCustomers = travelOffice.getCustomers().size();
        assertEquals(0, numberOfCustomers);
    }

    @Test
    public void removeCustomerByLastname_ShouldReturnValidResult(){
        travelOffice.addCustomer(customerWithTrip);
        travelOffice.removeCustomerByNameOrLastname("Anderson");
        int numberOfCustomers = travelOffice.getCustomers().size();

        assertEquals(0, numberOfCustomers);
    }

    @Test
    public void removeCustomerByLastname_ShouldReturnInvalidResult(){
        travelOffice.addCustomer(customerWithTrip);
        travelOffice.removeCustomerByNameOrLastname("Anderson");
        int numberOfCustomers = travelOffice.getCustomers().size();
        assertEquals(0, numberOfCustomers);
    }

    @Test
    public void setTripToCustomerId_ShouldReturnValidResult(){
        travelOffice.addCustomer(customerWithoutTrip);
        boolean isSetTripSuccessful = travelOffice.setTripToCustomerId(customerWithoutTrip.getId(), domesticTripToWarsaw);

        assertTrue(isSetTripSuccessful);
    }

    @Test
    public void addTrip_ShouldReturnValidResult(){
        travelOffice.addTrip(domesticTripToWarsaw);
        assertEquals(1, travelOffice.getTrips().size());
    }
    @Test
    public void addTrips_ShouldReturnValidResult(){
        travelOffice.addTrip(domesticTripToWarsaw);
        travelOffice.addTrip(abroadTrip);
        assertEquals(2, travelOffice.getTrips().size());
    }

    @Test
    public void searchTripByName_ShouldReturnValidResult(){
        travelOffice.addTrip(abroadTrip);
        travelOffice.addTrip(domesticTripToWarsaw);
        travelOffice.addTrip(domesticTripToCracow);
        List<Trip> trips = travelOffice.searchTripByName(domesticTripToWarsaw.getName());
        assertEquals(2, trips.size());
    }

    @Test
    public void searchTripsByDate_ShouldReturnValidResult() {
        travelOffice.addTrip(domesticTripToWarsaw);
        travelOffice.addTrip(domesticTripToCracow);
        travelOffice.addTrip(abroadTrip);

        List<Trip> trips = travelOffice.searchTripByStartDate(LocalDate.of(2024,01,01));

        assertEquals(3, trips.size());
    }

    @Test
    public void searchTripByDate_ShouldReturnValidResult() {
        travelOffice.addTrip(domesticTripToWarsaw);
        travelOffice.addTrip(domesticTripToCracow);
        travelOffice.addTrip(abroadTrip);

        List<Trip> trips = travelOffice.searchTripByStartDate(LocalDate.now().plusMonths(3));

        assertEquals(1, trips.size());
    }

    @Test
    public void searchTripByPlace_ShouldReturnValidResult() {
        travelOffice.addTrip(abroadTrip);
        travelOffice.addTrip(domesticTripToWarsaw);
        travelOffice.addTrip(domesticTripToCracow);
        List<Trip> trips = travelOffice.searchTripByPlace("Italy");

        assertEquals(1, trips.size());
    }

}