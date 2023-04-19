package opgave03;

public class AgeDiscount implements Discount{
	private int alder;
	 public AgeDiscount(int alder) {
		this.alder = alder;
	} 
	
	@Override
	public double getDiscount(double price) {
		return price - ((alder*0.01 ) * price) ;
	}

}
