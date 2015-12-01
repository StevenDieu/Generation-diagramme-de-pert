package controller;

import java.util.ArrayList;
import java.util.List;


import model.Tache;
import view.ViewHome;
import view.ViewPert;

public class Main {

	private static List<Tache> allTache = new ArrayList<Tache>();

	public static void main(String[] args) {
		//new ViewHome(allTache);
		new ViewPert();
	}


}
