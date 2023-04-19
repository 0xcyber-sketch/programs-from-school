package opgave6;

public class Date {

	private String season;
	
	public Date(int month, int day) {
		if (month > 0 && month < 4) {
			season = "Winter";
		}
		else if (month > 3 && month < 7) {
			season = "Spring";
		}
		else if (month > 6 && month < 10) {
			season = "Summer";
		}
		else if ((month > 9 && month < 13)) {
			season = "Fall";
		}
		
		if (month % 3 == 0 && day >= 21) {
			if (season.equals("Winter")) {
				season = "Spring";
			}
			else if (season.equals("Spring")) {
				season = "Summer";
			}
			else if (season.equals("Summer")) {
				season = "Fall";
			}
			else {
				season = "Winter";
			}
		}
	}
	
	public String getSeason() {
		return season;
	}
}
