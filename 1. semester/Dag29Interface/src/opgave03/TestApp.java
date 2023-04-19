package opgave03;

import java.time.LocalDate;


public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Product p1 = new Product(1, "Telefon", 30);
		Product p2 = new Product(2, "Bil", 45);
		Product p3 = new Product(3, "Hamste", 30);
		Product p4 = new Product(4, "Abe", 50);
		Product p5 = new Product(5, "Kanin", 1000);
		
		Customer c1 = new Customer("Emil", LocalDate.of(2000, 11, 2));
		Customer c2 = new Customer("Magnus", LocalDate.of(1999, 12, 2));
		
		Order o1 = new Order(1);
		Order o2 = new Order(2);
		Order o3 = new Order(3);
		Order o4 = new Order(4);
		Order o5 = new Order(5);
		Order o6 = new Order(6);
		
		o1.createOrderLine(1, p1);
		o1.createOrderLine(2, p1);
		o2.createOrderLine(3, p1);
		o2.createOrderLine(4, p1);
		o3.createOrderLine(5, p1);
		o3.createOrderLine(6, p1);
		o4.createOrderLine(7, p2);
		o4.createOrderLine(8, p3);
		o5.createOrderLine(9, p4);
		o5.createOrderLine(10, p5);
		o6.createOrderLine(11, p3);
		o6.createOrderLine(12, p5);
	
		
		
		
		
		
		c1.addOrder(o1);
		c1.addOrder(o2);
		c2.addOrder(o3);
		c2.addOrder(o4);
		c2.addOrder(o5);
		c2.addOrder(o6);
		
		
		Discount d1 = new DiscountPercent(15);
		Discount d2 = new FixedDiscount(250, 1000);
		Discount d3 = new AgeDiscount(21);
		
		c1.setDiscount(d1);
//		c2.setDiscount(d2);
		c2.setDiscount(d3);
		
		System.out.println("Uden rabat:");
		System.out.println(c1.totalBuy());
		System.out.println("Med rabat:");
		System.out.println(c1.totalBuyWithDiscount());
		System.out.println();
		System.out.println("Uden rabat:");
		System.out.println(c2.totalBuy());
		System.out.println("Med rabat:");
		System.out.println(c2.totalBuyWithDiscount());
		
		
		
		
	}

}
