package modelchild;

public class ChildApp {

	public static void main(String[] args) {
		double[] vægt = {4.2, 9.3, 12.4, 17.5, 23.2, 25.3, 28.6, 30.4, 33.9, 35.1,37.3};
		Child c1 = new Child(3, true, vægt);// boy 4 years old
		//Child c2 = new Child(2, false);// girl 2 years old

		System.out.println("Et barn på " + c1.getAge());
		//System.out.println(c1.getWeight(c1.getAge()));
		//System.out.println(c1.getincrease());
		
		Institution børnehave = new Institution("Solvej", "Solvejen 2)");
		børnehave.addChild(c1);
		
		System.out.println(børnehave.getNuværendeBørn());
		System.out.println(børnehave.averageAge());
				

	}

}
