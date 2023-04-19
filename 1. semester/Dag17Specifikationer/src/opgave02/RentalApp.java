package opgave02;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
public class RentalApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rental r1 = new Rental(2, 3, 200.0, LocalDate.of(2020, 11, 1));
		Rental r2 = new Rental(2,100,300,  LocalDate.now().plusMonths(10));
		
		System.out.println("Renter 1:");
		System.out.println("Total pris: " + r1.getTotalPrice());
		System.out.println("Sidste dag: " + r1.getEndDate());
		System.out.println("Næst sidste dag: " + r1.getEndDate().minusDays(1));
		
		System.out.println();
		
		System.out.println("Renter 2:");
		System.out.println("Total pris: " + r2.getTotalPrice());
		System.out.println("Sidste dag: " + r2.getEndDate());
		System.out.println("Næst sidste dag: " + r2.getEndDate().minusDays(1));
		
		System.out.println();
		
		Period per = LocalDate.of(2020, 11, 1).until(LocalDate.now().plusMonths(10));
		long days = per.getDays();
        
  
        long months = per.getMonths();
        
        long years = per.getYears();
		System.out.println(
	            "Fra " + LocalDate.of(2020, 11, 1) + " til " + LocalDate.now().plusMonths(10) + " er der " + years + " år " + months + " måneder "
	                + days + " dage");
		
		
		
		days = ChronoUnit.DAYS.between(LocalDate.of(2020, 11, 1), LocalDate.now().plusMonths(10));
        System.out.println("Dage: " + days);

		
		
		
		
		
	}

}
