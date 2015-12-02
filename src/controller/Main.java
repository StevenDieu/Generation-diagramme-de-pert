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
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		Tache tache2 = new Tache(2,6,"test2",l1);
		Tache tache3 = new Tache(3,15,"test3",null);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(2);
		l2.add(3);
		Tache tache4 = new Tache(4,1,"test4",l2);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(2);
		l3.add(4);
		Tache tache5 = new Tache(5,7,"test5",l2);
		Tache tache6 = new Tache(6,4,"test6",null);
		Tache tache7 = new Tache(2,6,"test2",l1);
		Tache tache8 = new Tache(3,15,"test3",null);
		Tache tache9 = new Tache(4,1,"test4",l2);
		Tache tache10 = new Tache(5,7,"test5",l2);
		Tache tache11 = new Tache(6,4,"test6",null);
		
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

		new ViewPert(allTache);
	}


}
