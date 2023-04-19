package opgave02;

import java.time.LocalDate;

/**
 * A rental 
 *
 */

//TODO write specifications
public class Rental {
	private int number;
	private int days;
	private LocalDate startDate;
	private double price;
	
	

	/**
	 * A constructor that inializes the rental object with a number, some days
	 * a price and a start date
	 */
	public Rental(int number, int days, double price, LocalDate startDate) {
		this.number = number;
		this.price = price; 
		this.startDate = startDate;
		this.days = days;

	}
	
	/**
	 * Gets how expensive the rental is a day
	 * @return the price
	 */
	public double getPricePrDay() {
		return price;
	}

	/**
	 * Get how many days the renter wants to rent
	 */
	public int getDays() {
		return days;
	}

	/**
	 * Set the days you want on the rental
	 * @param days amount of days
	 */
	public void setDays(int days) {
		this.days = days;
	}

	/** 
	 * Get the start date for the rental
	 * @return start date
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	
	/**
	 * Gets the end date for the rental
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		
		return this.startDate.plusDays(days); // -1 
	}
	
	/**
	 * Gets the total price the rental cots
	 * @return the total price pr day
	 */
	public double getTotalPrice() {
		return price * days;
	}
	

}
