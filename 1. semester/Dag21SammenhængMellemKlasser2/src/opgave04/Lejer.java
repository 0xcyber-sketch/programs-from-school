package opgave04;

public class Lejer {
	private String lejer;
	private String uddannelse;
	public Lejer(String lejer, String uddannelse) {
		super();
		this.lejer = lejer;
		this.uddannelse = uddannelse;
	}
	public String getLejer() {
		return lejer;
	}
	public void setLejer(String lejer) {
		this.lejer = lejer;
	}
	public String getUddannelse() {
		return uddannelse;
	}
	public void setUddannelse(String uddannelse) {
		this.uddannelse = uddannelse;
	}
	
}
