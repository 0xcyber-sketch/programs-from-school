package opgaver;
import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> players;

	public Team(String name) {
		this.name = name;
		this.players = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addPlayer(Player player) {
		players.add(player);

	}

	public void printPlayers() {
		/*for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName());
			System.out.println(players.get(i).getAge());
			System.out.println(players.get(i).getScore());
		}*/
		for (Player player : this.players) {
			System.out.println(player.getName());
			System.out.println(player.getAge());
			System.out.println(player.getScore());

		}
	}

	public double calcAverageAge() {
		double sum = 0;
		for (Player age : players) {
			sum += age.getAge();
		}

		return sum / players.size();
	}

	public int calcTotalScore() {
		int sum = 0;
		for (Player score : players) {
			sum += score.getScore();
		}
		return sum;
	}

	public int calcOldPlaterScoreint (int ageLimit) {
		int sum = 0;
		for (Player score : players) {
			if (score.getAge() >= ageLimit) {
				sum += score.getScore();
			}
		}

		return sum;
	}
	
	public int maxScore () {
		int max = Integer.MIN_VALUE;
		for (Player score : players) {
			if (score.getScore() > max) {
				max = score.getScore();
			}
		}

		return max;
	}
	
	public String  bestPlayer() {
		int max = Integer.MIN_VALUE;
		String navn = "";
		for (Player score : players) {
			if (score.getScore() > max) {
				max = score.getScore();
				navn = score.getName();
			}
		}

		return navn;
	}


}
