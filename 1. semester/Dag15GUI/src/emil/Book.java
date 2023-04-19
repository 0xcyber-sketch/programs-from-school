package emil;

//Opgave 2
public class Book {

	private String title;
	private boolean paperback;
	private double price;
	
	public Book(String title, boolean paperback, double price) {
		this.title = title;
		this.paperback = paperback;
		this.price = price;
		
	}

	public String getTitle() {
		return title;
	}

	public boolean isPaperback() {
		return paperback;
	}

	public double getPrice() {
		return price;
	}
	
	public double sale() {
		double newPrice = 0;
		
		if (this.isPaperback()) {
			newPrice = this.getPrice() * 0.60;
		} 
		else {
		newPrice = this.getPrice() * 0.80;
		}
		
		return newPrice;
	}
	
	public void printBook() {
		System.out.println("*******************************");
		System.out.println("Title : " + this.title + " Paperback: " + this.isPaperback());
		System.out.println("Price :          " + this.getPrice() );
		System.out.println("Sale  :          " + this.sale());
		System.out.println("*******************************");
		
		
	}
}
