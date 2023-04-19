package gui;

import java.util.ArrayList;

import application.controller.Controller;
import application.model.Uddannelse;
import storage.Storage;


public class App {


	public static void main(String[] args) {
		Controller.init();
		System.out.println(Controller.holdUdenTutorer());
		Uddannelse u1 = Storage.getUddannelser().get(0);
		ArrayList<String> tutorTeams = u1.tutorOversigt();
		for (String s : tutorTeams) {
			System.out.println(s);
		}
		Controller.tutorOversigtTilFil("C:\\Users\\Emil\\Desktop\\1. Semester\\PRO1\\TextFiler\\rep\\test1.txt");
	}
}

