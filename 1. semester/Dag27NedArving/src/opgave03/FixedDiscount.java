package opgave03;

public class FixedDiscount extends Discount{

	private int fixedDiscount;
	private int discountLimit;
	public FixedDiscount(int fixedDiscount, int discountLimit) {
		super();
		this.fixedDiscount = fixedDiscount;
		this.discountLimit = discountLimit;
		
	}
	public int getFixedDiscount() {
		return fixedDiscount;
	}
	public void setFixedDiscount(int fixedDiscount) {
		this.fixedDiscount = fixedDiscount;
	}
	public int getDiscountLimit() {
		return discountLimit;
	}
	public void setDiscountLimit(int discountLimit) {
		this.discountLimit = discountLimit;
	}
	
	
	/**
	 * 
	 * @param price > 1000
	 * @return new price
	 */
	@Override 
	public double getDiscount(double price) {
		return price - 250;
	}
	
	

	
}
