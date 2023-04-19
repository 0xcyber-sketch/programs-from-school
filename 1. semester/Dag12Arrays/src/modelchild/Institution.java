package modelchild;

public class Institution {
	private String navn;
	private String adressse;
	private static final int MAX_CHILDREN = 34;
	private Child[] børn;
	private int nuværendeBørn;
	
	public Institution(String navn, String adressse) {
		this.navn = navn;
		this.adressse = adressse;
		this.børn = new Child[MAX_CHILDREN];
		nuværendeBørn = 0;
	}
	
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getAdressse() {
		return adressse;
	}

	public void setAdressse(String adressse) {
		this.adressse = adressse;
	}

	public void addChild (Child child) {
	
			if ( nuværendeBørn < MAX_CHILDREN) {
				børn[nuværendeBørn] = child;
				nuværendeBørn++;
				
			}
				
				
		
	}

	public int getNuværendeBørn() {
		return nuværendeBørn;
	}

	
	public double averageAge() {
		int sum = 0;
		double average = 0.0;
		
		for (int i = 0; i < nuværendeBørn; i++) {
			sum += børn[i].getAge();
			if (nuværendeBørn > 0) {
				average = (double) sum / nuværendeBørn; 
			}
			
		}
		return average;
	}
	
	public int numberOfGirls() {
		int piger = 0;
		for (int i = 0; i < nuværendeBørn; i++) {
			if (!børn[i].isBoy()) {
				piger++;
			}
			
		}
		
		return piger;
	}
	public int numberOfBoys() {
		int drenge = 0;
		for (int i = 0; i < nuværendeBørn; i++) {
			if (børn[i].isBoy()) {
				drenge++;
			}

		}
		
		return drenge;
	}
	
}
