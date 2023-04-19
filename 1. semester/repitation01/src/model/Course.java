package model;

import java.util.ArrayList;

public class Course {
	private String semester;
	private Room room;
	private ArrayList<Enrollment> enrollments = new ArrayList<>();

	public Course(Room room, String semester) {
		this.room = room ; 
		this.semester = semester;
	}

	public Room getRoom() {
		return room;
	}
	
	public Enrollment createEnrollment(Student s) {
		Enrollment e = new Enrollment(s);
		enrollments.add(e);
		return e;
	}
	

}
