package opgave02;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan {
	private char level;
	private int weeklyWaterHours;
	private int weeklyStrengthHours;
	
	private final ArrayList<Swimmer> swimmers = new ArrayList<>();
	
	public TrainingPlan(char level, int weeklyWaterHours, int weeklyStrengthHours) {
		this.level = level;
		this.weeklyWaterHours = weeklyWaterHours;
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public char getLevel() {
		return level;
	}
	
	public void setLevel(char niveau) {
		this.level = niveau;
	}
	
	public int getWeeklyStrengthHours() {
		return weeklyStrengthHours;
	}
	
	public void setWeeklyStrengthHours(int weeklyStrengthHours) {
		this.weeklyStrengthHours = weeklyStrengthHours;
	}
	
	public int getWeeklyWaterHours() {
		return weeklyWaterHours;
	}
	
	public void setWeeklyWaterHours(int weeklyWaterHours) {
		this.weeklyWaterHours = weeklyWaterHours;
	}
	/*** Adds the swimmer to this Training plan,
	 * if they aren't connected.
	 * Pre: The person isn't connected to another Training plan.
	 */
	public void addSwimmer(Swimmer swimmer) {
		if (!swimmers.contains(swimmer)) {
			swimmers.add(swimmer);
		}
	}
	
	/** Removes the person from this group,
	 * if they are connected.
	 */
	public void removeSwimmer(Swimmer swimmer) {
		if (swimmers.contains(swimmer)) {
			swimmers.remove(swimmer);
		}
	}
	
	public ArrayList<Swimmer> getSwimmers(){
		return new ArrayList<>(swimmers);
	}
	
}
