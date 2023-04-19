package model;

import java.util.ArrayList;

public class Education {
	private String name;
	private ArrayList<Subject> subjects;
	public Education(String name) {
		this.name = name;
	}
	
	public ArrayList<Subject> getSubjects(){
		return new ArrayList<>(subjects);
	}
	
	public String getName() {
		return name;
	}
	
	public void addSubjects(Subject s) {
		if (!subjects.contains(s)) {
			subjects.add(s);
		}
	}
	
	public void removeSubject(Subject s) {
		if (subjects.contains(s)) {
			subjects.remove(s);
		}
	}

}
