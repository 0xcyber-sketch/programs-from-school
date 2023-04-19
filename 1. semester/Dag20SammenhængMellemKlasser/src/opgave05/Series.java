package opgave05;

import java.util.ArrayList;

public class Series {
	private String title;
	private ArrayList<String> cast;
	private final ArrayList<Episode> episodes = new ArrayList<>();
	
	public Series(String title, ArrayList<String> cast) {
		
		this.cast = cast;
		this.title = title;
		
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<String> getCast() {
		return new ArrayList<>(cast);
	}
	
	public ArrayList<Episode> getEpisodes() {
		return new ArrayList<>(episodes);
	}
	
	public Episode createEpisode(int number,ArrayList<String> guestActors, int lengthMinutes ) {
		Episode episode = new Episode(number, guestActors, lengthMinutes);
		episodes.add(episode);
		return episode;
	}
	
	public void removeEpisode(Episode episode) {
		if (episodes.contains(episode)) {
			episodes.remove(episode);
		}
	}
	/** *
	 * Return the total length(in minutes)of all the episodes in the series.
	 */
	public int totalLength() {
		int sum = 0;
		for (Episode e : episodes) {
			sum += e.getLengthMinutes();
		}
		return sum;
	}
	
	/**
	 * Return the total list of all guest actors from all episodes.
	 */
	
	public ArrayList<String> getGuestActors(){
		ArrayList<String> tempList = new ArrayList<>();
		for (Episode e : episodes) {
			for (String g : e.getGuestActors()) {
				if (!tempList.contains(g))
				tempList.add(g);
				
			}
		}
		return tempList;
	}
	
}
