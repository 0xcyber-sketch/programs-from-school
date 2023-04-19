package opgave01;

public class Chili implements Measurable{

	private String name;
	private int hotness;
	public Chili(String name, int hotness) {
		this.name = name;
		this.hotness = hotness;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHotness() {
		return hotness;
	}
	public void setHotness(int hotness) {
		this.hotness = hotness;
	}
	@Override
	public double getMeasure() {
		return getHotness();
	}
	
	public String toString() {
		return name;
	}
	
	
}
