package opgave3;

public class Name {

	private String fName;
	private String mName;
	private String lName;
	
	public Name(String fname, String mname, String lname) {
		this.fName = fname;
		this.mName = mname;
		this.lName = lname;
	}
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getInit() {
		
		
		return "" + fName.charAt(0) + mName.charAt(0) + lName.charAt(0);
	}
	
	
	public String getUsername() {
		
		return fName.substring(0,2).toUpperCase() + mName.length() + lName.substring(lName.length()-2).toLowerCase();
		
	}
}
