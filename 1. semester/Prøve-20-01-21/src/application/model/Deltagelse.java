package application.model;

public class Deltagelse {
	private boolean registreret;
	private DeltagerStatus status;
	private Lektion lektion;
	private Studerende studerende;
	Deltagelse(Lektion lektion, Studerende studerende) {
		this.status = DeltagerStatus.TILSTEDE;
		this.registreret = false;
		this.lektion = lektion;
		setStuderende(studerende);
		
	}
	 Deltagelse(DeltagerStatus status, boolean registreret,  Lektion lektion, Studerende studerende) {
		this.status = status;
		this.registreret = registreret;
		this.lektion = lektion;
		setStuderende(studerende);

	}
	public Studerende getStuderende() {
		return studerende;
	}
	public Lektion getLektion() {
		return lektion;
	}
	public boolean isRegistreret() {
		return registreret;
	}
	
	public void setRegistreret(boolean registreret) {
		this.registreret = registreret;
	}
	public DeltagerStatus getStatus() {
		return status;
	}
	
	
	public void setStatus(DeltagerStatus status) {
		this.status = status;
	}
	public void setStuderende(Studerende s) {
		if (this.studerende != s) {
			if (this.studerende != null) {
				this.studerende.removeDeltagelser(this);
			}
			this.studerende = s;
			if (s != null) {
				s.addDeltagelser(this);
			}
		}
	}
	
	public boolean erRegistreretFraværende() {
		boolean fravær = false;
		if (this.status == DeltagerStatus.FRAVÆR) {
			fravær = true;
		}
		return fravær;
	}
	@Override
	public String toString() {
		return "" + getStuderende().getNavn() + " " + registreret + " " + status;
	}
	
	

}
