package flight;

import java.time.LocalDateTime;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        System.out.println(flight.getDestination());
        flight.createPassenger("Arnold", 31);
        flight.createPassenger("Bruce", 59);
        flight.createPassenger("Dolph", 24);
        flight.createPassenger("Linda", 59);
        flight.createPassenger("Jennifer", 65);
        flight.setDepartDate(LocalDateTime.now());     
        flight.setArrivalDate(LocalDateTime.now().plusHours(17)); 
        
        System.out.println("The average age of the passengers is: " + flight.getAverageAge());
        System.out.println("The flight takes " + flight.flightDurationInHours() + " hours");
        System.out.println("The flight flies at midnight: " + flight.midnightFlight());
    }

}
