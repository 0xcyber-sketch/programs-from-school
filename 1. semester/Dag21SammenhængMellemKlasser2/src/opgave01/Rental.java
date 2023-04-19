package opgave01;

import java.util.ArrayList;

public class Rental {
	
	private int number; 
	private int days;
	private String date;
	
	private ArrayList<Car> cars = new ArrayList<>();
	
	public Rental(int number, String date, int days) {
		this.number = number;
		this.days = days;
		this.date = date;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	public void addCar(Car car) {
		if (!cars.contains(car)) {
			cars.add(car);
			car.addRental(this);
		}
		
	}
	
	public void removeCar(Car car) {
		if (cars.contains(car)) {
			cars.remove(car);
			car.removeRental(this);
		}
		
	}
	
	public ArrayList<Car> getCars(){
		return new ArrayList<>(cars);
	}
	
	public double getPrice() {
		double sum = 0;
		for(Car c : cars) {
			sum += c.getDayPrice();
		}
		
		return sum * this.days;
	}
	
	

}
