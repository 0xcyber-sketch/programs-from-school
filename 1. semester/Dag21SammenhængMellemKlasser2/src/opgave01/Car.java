package opgave01;

import java.util.ArrayList;

public class Car {
	private String license;
	private double pricePerDay;
	private int purchaseYear;
	
	private final ArrayList<Rental> rentals = new ArrayList<>();
	
	public Car(String license, int year) {
		this.license = license;
		this.purchaseYear = year;
	}
	
	public void setDayPrice(double price) {
		this.pricePerDay = price;
	}
	
	public double getDayPrice() {
		return this.pricePerDay;
	}
	
	public String getLicense() {
		return this.license;
	}
	
	public int getYear() {
		return purchaseYear;
	}
	
	public void addRental( Rental r) {
		if (!rentals.contains(r)) {
			rentals.add(r);
			r.addCar(this);
		}
		
	}
	
	public void removeRental (Rental r) {
		if (rentals.contains(r)) {
			rentals.remove(r);
			r.removeCar(this);
		}
	}
	
	public ArrayList<Rental> getRental(){
		return new ArrayList<>(rentals);
	}
	
	public int getBiggestAmountOfDays() {
		int max = Integer.MIN_VALUE;
		for (Rental r : rentals) {
			if (r.getDays() > max) {
				max = r.getDays();
			}
		}
		return max;
	}
}
