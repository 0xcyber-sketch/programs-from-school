package opgave03;


public class TestApp {
	
	public static void main(String[] args) {
		 Car c1 = new Car("hahah", 2000);
		 Car c2 = new Car("hsh", 1827);
		 Car c3 = new Car("7wwho", 2192);
		 Car c4 = new Car("73hs", 3742);
		 Car c5 = new Car("jsjs", 8332);
		
		 Rental r1 = new Rental(1, "Monday", 52 );
		 Rental r2 = new Rental(3, "Friday", 13 );
		 
		 r1.addCar(c1);
		 r1.addCar(c2);
		 
		 r2.addCar(c3);
		 r2.addCar(c4);
		 r2.addCar(c5);
		 
		 c1.setDayPrice(53.3);
		 c2.setDayPrice(82.3);
		 c3.setDayPrice(92.3);
		 c4.setDayPrice(100);
		 c5.setDayPrice(2000);
		 
		 
		 System.out.println(r2.getPrice());
		 
		 
		 
		
	}

	
	
	
	}

	

