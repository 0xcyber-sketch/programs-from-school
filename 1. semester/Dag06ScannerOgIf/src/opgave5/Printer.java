package opgave5;

public class Printer {
	
	private int paper;
	private boolean paperStuck = false;
	
	public Printer() {
		this.paper = 0;
		
	}
	public Printer(int paper) {
		this.paper = paper;
	}
	/**
	 * @return the paper
	 */
	public int getPaper() {
		return paper;
	}
	/**
	 * @param paper the paper to set
	 */
	public void insertPaper(int paper) {
		if ((this.paper + paper) > 500 ) {
			System.out.println("Error! Paper overload");
		}
		else {
			
			this.paper += paper ;
		}
	}
	
	public void makeCopy() {
		if (!paperStuck) 
		{
			if (paper == 0) 
			{
				System.out.println("Error! Machine is out of paper!");
			}
			else 
			{
			paper -= 1;
			}
		}
		else {
			System.out.println("Error! Paper is stuck!");
		}
	}
	
	public void makeCopy(int paper) {
		
		if (paperStuck == false) 
		{
			if (this.paper - paper  >= 0) 
			{
				this.paper -= paper;
				
			
			}
			else {
				System.out.println("Error! You stupid, Don't print more than the total amount of paper");
			}
		
		}
		else {
			System.out.println("Error! Machine is out of paper!");
		}
	}
	
	
	
	
	public void makePaperJam() {
		paperStuck = true;
	}
	public void fixJam() {
		paperStuck = false;
	}
	
	
	

}
