package opgave5;

public class BugApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bug bugsy = new Bug(10);
		bugsy.move();
		bugsy.move();
		System.out.println(bugsy.getPosition());
		bugsy.turn();
		bugsy.move();
		System.out.println(bugsy.getPosition());

		
		
	}

}
