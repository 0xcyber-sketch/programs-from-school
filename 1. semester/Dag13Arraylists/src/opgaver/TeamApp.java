package opgaver;

public class TeamApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Player p1 = new Player("Sarah", 19);
		Player p2 = new Player("Ida", 20);
		Player p3 = new Player("Julie", 18);
		Player p4 = new Player("Sarah b.", 21);
		
		p1.addScore(2);
		p2.addScore(7);
		p4.addScore(3);
		
		
		Team team = new Team("FC Engle");
		
		team.addPlayer(p1);
		team.addPlayer(p2);
		team.addPlayer(p3);
		team.addPlayer(p4);
		
		System.out.println(team.calcAverageAge());

		System.out.println(team.calcTotalScore());
		
		System.out.println(team.calcOldPlaterScoreint(20));
		
		System.out.println(team.maxScore());
		
		System.out.println(team.bestPlayer());
		
		
	}

}
