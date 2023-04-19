package eksempler;
public class ExerP1_03 
{
	public static double roundDown6 (double d) {
		return ((long)(d*1e6)) / 1e6;
	}
	
	public static String formula = "";
	public static void main(String[] args) 
	{
		
		
		// TODO Auto-generated method stub
		double pi = 0;
		double pi6 = 1;
		boolean check = false;
		int i = 0;
		
		
		//System.out.println(pi);
		double denominator  = 1;
		double numerator = 1 ;
		double x = 0;
		
		while (check == false) {
			
			x = (numerator/denominator) * 4 ;
			pi = pi + x;
			numerator = numerator * -1;
			denominator = denominator + 2;
			if (pi6 == roundDown6(pi)) {
				check = true;
			}
			pi6 = roundDown6(pi);
			i = i + 1;
			
			
			
			
			
			}
		System.out.println(i);
		System.out.println(pi6);
		
		 
			
			
			
		
	}

}
