package opgave02;

import java.util.ArrayList;



public class Person {
	private String name;
	private int age;
	
	private final ArrayList<Gift> gifts = new ArrayList<>();
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Adds gift to Person if not already connected to a person
	 * Pre: The gift is not connected to a person
	 */
	
	public void addGift(Gift gift) {
		if (!gifts.contains(gift)) {
			gifts.add(gift);
		}
		
	}
	
	public void removeGift(Gift gift) {
		if (gifts.contains(gift)) {
			gifts.remove(gift);
		}
		
	}
	
	public ArrayList<Gift> getGifts(){
		return new ArrayList<>(gifts);
	}
	
	public double getSumValue() {
		int sum = 0; 
		for (Gift g : gifts) {
		sum += g.getPrice();
		}
		return sum;
	}
	
	public ArrayList<Person> getPersonsThatGaveAGift(){
		ArrayList<Person> tempList = new ArrayList<>();
		for (Gift g: gifts) {
			if (!tempList.contains(g.getPerson())) {
				tempList.add(g.getPerson());
			}
		}
		return tempList;
	}

}
