package model;

import java.util.ArrayList;

public class Subject {
	private String name;
	private String description;
	private int numberOfLessons;
	private String litterature;
	private ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<Teacher> teachers = new ArrayList<>();
	private Education education;
	

	public Subject(Education education, String name, String des, int number) {
		this.education = education;
		this.name = name;
		description = des;
		numberOfLessons = number;	
	}
	
	
	

}
