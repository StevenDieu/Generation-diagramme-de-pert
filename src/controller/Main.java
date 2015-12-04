package controller;

import java.util.ArrayList;
import java.util.List;

import model.Task;
import view.ViewHome;

public class Main {

	private static List<Task> allTask = new ArrayList<Task>();

	public static void main(String[] args) {
//		Tache task1 = new Tache(1,2,"test1",null);
//		Tache task2 = new Tache(6,7,"test2",null);
//		Tache task3 = new Tache(9,3,"test2",null);
//
//		List<Integer> l4 = new ArrayList<>();
//		l4.add(1);
//		Tache task4 = new Tache(2,15,"test2",l4);
//		
//		List<Integer> l5 = new ArrayList<>();
//		l5.add(1);
//		l5.add(9);
//		Tache task5 = new Tache(3,11,"test2",l5);
//		
//		List<Integer> l6 = new ArrayList<>();
//		l6.add(6);
//		l6.add(9);
//		Tache task6 = new Tache(4,4,"test2",l6);
//		
//		List<Integer> l7 = new ArrayList<>();
//		l7.add(9);
//		Tache task7 = new Tache(5,6,"test2",l7);
//		
//		List<Integer> l8 = new ArrayList<>();
//		l8.add(2);
//		l8.add(9);
//
//		Tache task8 = new Tache(8,18,"test2",l8);
//		
//		List<Integer> l9 = new ArrayList<>();
//		l9.add(3);
//		l9.add(5);
//		Tache task9 = new Tache(7,2,"test2",l9);
//		
//		List<Integer> l10 = new ArrayList<>();
//		l10.add(8);
//		l10.add(7);
//		Tache task10 = new Tache(10,4,"test2",l10);
//		
//		List<Integer> l11 = new ArrayList<>();
//		l11.add(10);
//		Tache task11 = new Tache(12,6,"test2",l11);
//		
//		List<Integer> l12 = new ArrayList<>();
//		l12.add(4);
//		l12.add(12);
//		Tache task12 = new Tache(11,7,"test2",l12);
//		
//		List<Integer> l13 = new ArrayList<>();
//		l13.add(11);
//		Tache task13 = new Tache(13,9,"test2",l13);
//
//		allTache.add(task1);
//		allTache.add(task2);
//		allTache.add(task3);
//		allTache.add(task4);
//		allTache.add(task5);
//		allTache.add(task6);
//		allTache.add(task7);
//		allTache.add(task8);
//		allTache.add(task9);
//		allTache.add(task10);
//		allTache.add(task11);
//		allTache.add(task12);
//		allTache.add(task13);
		
		
		Task task1 = new Task(1,120,"test1",null);
		List<Integer> l2 = new ArrayList<>();
		l2.add(1);
		Task task2 = new Task(2,180,"test1",l2);
		List<Integer> l3 = new ArrayList<>();
		l3.add(2);
		Task task3 = new Task(3,3,"test1",l3);
		List<Integer> l4 = new ArrayList<>();
		l4.add(2);
		Task task4 = new Task(4,30,"test1",l4);
		List<Integer> l5 = new ArrayList<>();
		l5.add(2);
		Task task5 = new Task(5,60,"test1",l5);
		List<Integer> l6 = new ArrayList<>();
		l6.add(4);
		Task task6 = new Task(6,90,"test1",l6);
		List<Integer> l7 = new ArrayList<>();
		l7.add(3);
		l7.add(4);
		Task task7 = new Task(7,240,"test1",l7);
		List<Integer> l8 = new ArrayList<>();
		l8.add(5);
		l8.add(6);
		l8.add(7);

		Task task8 = new Task(8,180,"test1",l8);
		List<Integer> l9 = new ArrayList<>();
		l9.add(8);
		l9.add(10);

		Task task9 = new Task(9,3,"test1",l9);

		List<Integer> l10 = new ArrayList<>();
		l10.add(5);
		l10.add(6);
		l10.add(7);
		Task task10 = new Task(10,240,"test1",l10);
		
		List<Integer> l11 = new ArrayList<>();
		l11.add(10);
		l11.add(8);
		Task task11 = new Task(11,360,"test1",l11);
		
		List<Integer> l12 = new ArrayList<>();
		l12.add(8);
		l12.add(10);
		Task task12 = new Task(12,240,"test1",l12);
		
		allTask.add(task1);
		allTask.add(task2);
		allTask.add(task3);
		allTask.add(task4);
		allTask.add(task5);
		allTask.add(task6);
		allTask.add(task7);
		allTask.add(task8);
		allTask.add(task9);
		allTask.add(task10);
		allTask.add(task11);
		allTask.add(task12);

		new ViewHome(allTask);
	}


}
