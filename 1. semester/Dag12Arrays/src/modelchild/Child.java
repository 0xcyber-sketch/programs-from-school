package modelchild;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy
	private double[] weight; 

	public Child(int age, boolean boy, double[] weight) {
		this.age = age;
		this.boy = boy;
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}
	
	public double getWeight( int age) {
		double current_weight; 
		current_weight = this.weight[age];
		
		return current_weight; 
	}
	
	public double getincrease() {
		double biggestDiff = 0;
		double temp = 0; 
		
		for (int i = 0; i < this.weight.length - 1; i++) {
			temp = weight[ i+ 1] - weight[i];
			if (temp > biggestDiff) {
				biggestDiff = temp;
			}
			
		}
		
		
		return biggestDiff;
	}

}
