package model;

public class Person {
	private String name;
	private String address;
	private String qualification;
	

	public Person(String name, String address, String qual) {
	this.name = name;
	this.address = address;
	this.qualification = qual;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

}
