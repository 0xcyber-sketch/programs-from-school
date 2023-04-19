package model;

import java.util.ArrayList;

public class Teacher extends Person{
	private int salary;
	private ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<Subject> subjects = new ArrayList<>();

	public Teacher(String name, String address, String qualification, int salary) {
		super(name, address, qualification);
		this.salary = salary;
	}

}
