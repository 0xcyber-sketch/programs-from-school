package opgave5;

public class Bug {

	private int position; //x value 
	private int direction; 

	
	public Bug(int position) {
		this.position = position;
		this.direction = 1;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void move() {
		this.position = this.position + this.direction;
		
	}
	
	public void turn() {
		this.direction *= -1; 
	}
}
