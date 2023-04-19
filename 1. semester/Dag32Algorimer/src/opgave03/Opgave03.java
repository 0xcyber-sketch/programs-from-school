package opgave03;

public class Opgave03 {

	public Opgave03() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Jubiiii";
		System.out.println(kEns(s,4));
		System.out.println(kEns(s,5));

	}
	
	public static boolean kEns( String s, int k) {
		boolean found = false;
		int i = 0;
		
		while (!found && i <= s.length() - k) {
			if (match(s, i, k)) {
				found = true;
			}
			else {
				i++;
				
			}
		}
		
		
		return found;
	
	}
	
	private static boolean match(String s, int i, int k) {
		boolean foundDiff = false;
		int j = 1;
		while(j < k && !foundDiff) {
			if (s.charAt(i) != s.charAt(i + j)){
				foundDiff = true;
			}
			else {
				j++;
			}
		}
		
		
		return !foundDiff;
	}
	


}
