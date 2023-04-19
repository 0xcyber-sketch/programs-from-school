package flight;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * A flight with an airline between airports. 
 */
public class Flight {
    private String flightNumber;
    private String destination;
    private LocalDateTime departDate;
    private LocalDateTime arrivalDate;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    
    /**
     * Constructor that creates a flight for an airline.
     * @param flightNumber the number of the flight
     * @param destination the destination of the flight
     */
    // TODO: implement!
    public Flight(String flightNumber, String destination) {
    	this.flightNumber = flightNumber;
    	this.destination = destination;
    	
	}

    /**
     * Gets the destination.
     * @return the destination or null if not set
     */
    // TODO: implement!
    public String getDestination() {
    	return destination;
    	
    }
    
    /**
     * Gets the flight number.
     * @return the flight number
     */
    // TODO: implement!
    public String flightNumber() {
    	return flightNumber;
    }
    
    /**
     * Gets the LocalDateTime when the flight will depart
     * @return departure date, can be null
     */
    // TODO: implement!
    public LocalDateTime getDepartDate() {
    	return departDate;
    }

    /**
     * Sets the LocalDateTime when the flight will depart.
     * Precondition: cannot be later than the land time.
     * @param departDate
     */
    public void setDepartDate(LocalDateTime departDate) {
        this.departDate = departDate;
    }

    /**
     * Gets the LocalDateTime for when the flight will land.
     * @return arrival date, can be null
     */
    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the LocalDateTime for when the flight will land.
     * Precondition: cannot be before the depart time.
     * @param landDate arrival date
     */
    // TODO: implement!
    public void setArrivalDate (LocalDateTime landDate) {
    	arrivalDate = landDate;
    }
    
    /**
     * Creates a passenger with name and age
     * Precondition: name is not empty or null and age >= 0.
     * @param name name of the passenger
     * @param age the age of the passenger
     * @return the newly created passenger object
     */
    // TODO: implement!
    public Passenger createPassenger(String name, int age) {
    	Passenger p1 = new Passenger(name, age);
    	passengers.add(p1);
		return p1;
    	
    }
    
    /**
     * Removes the passenger.
     * Precondition: the passenger must exists on this flight.
     * @param passenger
     */
    // TODO: implement!
    public void removePassenger(Passenger passenger) {
    	passengers.remove(passengers.indexOf(passenger));
//    	passengers.remove(passenger);
    }
    
    /**
     * Gets the current list of passengers on this flight
     * @return list of passengers
     */
    // TODO: implement!
    public ArrayList<Passenger> getPassengers(){
    	return passengers;
    }
    
    /**
     * The duration of the flight measured in hours
     * Precondition: the depart and arrival dates must have been set
     * @return how many hours
     */
    public double flightDurationInHours() {
        
        // TODO: implement!
        // Hint: 
        // You can use the following to get hours between two LocalDates:
        //        ChronoUnit.HOURS.between(startDate, endDate)
        // ...and ChronoUnit.MINUTES for minutes...
    	long hours = ChronoUnit.HOURS.between(departDate, arrivalDate);
    	
//    	double temp = (double) hours;
    	return hours;
//        return temp;
    }
    
    /**
     * Returns true if the flight happens during midnight of the day of departure.
     * Precondition: depart and arrival dates must have been set
     * @return true if midnight is included in the flight period, otherwise false.
     */
    public boolean midnightFlight() {
    	//This shit wass a struggle apx. 2 hours
    	long hours = ChronoUnit.HOURS.between(departDate, arrivalDate);
    	LocalTime midnight = LocalTime.MIDNIGHT;
    	//System.out.println(departDate.plus(hours,ChronoUnit.HOURS).toLocalTime());
    	
    	
    	
        // TODO: implement!
    	if((departDate.plus(hours,ChronoUnit.HOURS).toLocalTime()).isBefore(midnight) || arrivalDate.getDayOfMonth() > departDate.getDayOfMonth() ) {
    		return true;
    	}
    	else {
        return false;
        } // and don't just return false :)
    }
    
    /**
     * Gets the average age of all the passengers
     * Precondition: there must exists passengers on this flight
     * @return average age of passengers
     */
    // TODO: implement!
    double getAverageAge() {
    	double sum = 0;
    for (int i = 0; i < passengers.size(); i++) {
    	sum += passengers.get(i).getAge();
    }
    return (double) sum/passengers.size();
    }
    
}
