package model;

import java.util.ArrayList;

public class SchoolClass {

	private String name;
	private Education education;
	private ArrayList<Student> students = new ArrayList<>(); 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SchoolClass(String name, Education education) {
	this.name = name;
	this.education = education;
	}

	public Education getEducation() {
		return education;
	}
	
	public ArrayList<Student> getStudents(){
		return new ArrayList<>(students);
	}

}
