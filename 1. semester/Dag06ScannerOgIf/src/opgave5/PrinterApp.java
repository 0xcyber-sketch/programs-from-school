package opgave5;

public class PrinterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer p1 = new Printer(50);
		p1.insertPaper(450);
		p1.makeCopy();
		System.out.println(p1.getPaper());
		p1.makePaperJam();
		p1.makeCopy();
		p1.makeCopy();
		
		p1.fixJam();
		p1.makeCopy(2);
		System.out.println(p1.getPaper());

		p1.makeCopy(497);
				
		System.out.println(p1.getPaper());
		
		p1.makeCopy(2);
		
		
	}

}
