package opgave03;

public class DiscountPercent implements Discount{

	private int discountPercentage;

	public DiscountPercent( int discountPercent) {
		this.discountPercentage = discountPercent;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	@Override
	public double getDiscount(double price) {
		return price * (1 -(discountPercentage * 0.01));
		
	}
	
	
	
	
	
}
