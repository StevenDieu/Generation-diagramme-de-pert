package model;

import java.util.List;

public class Tache {
	private int numero;
	private int duree;
	private String nom;
	private List<Integer> predecesseurs;

	public Tache(int numero, int duree, String nom, List<Integer> predecesseurs) {
		super();
		this.numero = numero;
		this.duree = duree;
		this.nom = nom;
		this.predecesseurs = predecesseurs;
	}

	public Tache() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Integer> getPredecesseurs() {
		return predecesseurs;
	}

	public void setPredecesseurs(List<Integer> predecesseurs) {
		this.predecesseurs = predecesseurs;
	}

}
