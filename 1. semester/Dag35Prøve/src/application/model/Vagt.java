package application.model;

public class Vagt {

	private int timer;
	private Job job;
	private Frivillig frivillig;

	Vagt(int timer, Job job ) {
		this.timer = timer;
		this.job = job;
		setFrivillig(frivillig);
	}



	public void setFrivillig(Frivillig frivillig) {
		this.frivillig = frivillig;
	}



	public Frivillig getFrivillig() {
		return frivillig;
	}

	public Job getJob() {
		return job;
	}

	public int getTimer() {
		return timer;
	}

}
