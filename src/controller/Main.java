package controller;

import java.util.ArrayList;
import java.util.List;

import model.Tache;
import view.ViewHome;
import view.ViewPert;

public class Main {

	private static List<Tache> allTache = new ArrayList<Tache>();

	public static void main(String[] args) {
		Tache tache1 = new Tache(1,2,"test1",null);
		Tache tache2 = new Tache(6,7,"test2",null);
		Tache tache3 = new Tache(9,3,"test2",null);

		List<Integer> l4 = new ArrayList<>();
		l4.add(1);
		Tache tache4 = new Tache(2,15,"test2",l4);
		
		List<Integer> l5 = new ArrayList<>();
		l5.add(1);
		l5.add(9);
		Tache tache5 = new Tache(3,11,"test2",l5);
		
		List<Integer> l6 = new ArrayList<>();
		l6.add(6);
		l6.add(9);
		Tache tache6 = new Tache(4,4,"test2",l6);
		
		List<Integer> l7 = new ArrayList<>();
		l7.add(9);
		Tache tache7 = new Tache(5,6,"test2",l7);
		
		List<Integer> l8 = new ArrayList<>();
		l8.add(2);
		Tache tache8 = new Tache(8,18,"test2",l8);
		
		List<Integer> l9 = new ArrayList<>();
		l9.add(3);
		l9.add(5);
		Tache tache9 = new Tache(7,2,"test2",l9);
		
		List<Integer> l10 = new ArrayList<>();
		l10.add(8);
		l10.add(7);
		Tache tache10 = new Tache(10,4,"test2",l10);
		
		List<Integer> l11 = new ArrayList<>();
		l11.add(10);
		Tache tache11 = new Tache(12,6,"test2",l11);
		
		List<Integer> l12 = new ArrayList<>();
		l12.add(4);
		l12.add(12);
		Tache tache12 = new Tache(11,7,"test2",l12);
		
		List<Integer> l13 = new ArrayList<>();
		l13.add(11);
		Tache tache13 = new Tache(13,9,"test2",l13);

		allTache.add(tache1);
		allTache.add(tache2);
		allTache.add(tache3);
		allTache.add(tache4);
		allTache.add(tache5);
		allTache.add(tache6);
		allTache.add(tache7);
		allTache.add(tache8);
		allTache.add(tache9);
		allTache.add(tache10);
		allTache.add(tache11);
		allTache.add(tache12);
		allTache.add(tache13);


		new ViewHome(allTache);
	}


}
