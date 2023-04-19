package opgave02;

public class TestApp {
	public static void main(String[] args) {
		Person p1 = new Person("Emil", 20);
		Person p2 = new Person("Anders", 21);
		Person p3 = new Person("Martin", 26);
		
		Gift g1 = new Gift ("Hat1", p2);
		Gift g2 = new Gift ("Hat3", p2);
		Gift g3 = new Gift ("Hat2", p3);
		
		g1.setPrice(50);
		g2.setPrice(30);
		g3.setPrice(69);
		
		p1.addGift(g1);
		p1.addGift(g2);
		p1.addGift(g3);
		
		for (Gift g : p1.getGifts()) {
			System.out.println(g.getDescription());
		}
		
		System.out.println(p1.getSumValue());
		
		for (Person p : p1.getPersonsThatGaveAGift()) {
			System.out.println(p);
		}
		
	}

}
