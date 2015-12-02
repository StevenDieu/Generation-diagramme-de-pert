package model;

import java.util.ArrayList;
import java.util.List;

public class Tache {
	private int numero;
	private int duree;
	private String nom;
	private List<Integer> predecesseurs;
	
	
	//Après avoir récuperer tout les resultats
	private int delaiAuPlusTard;
	private int delaiAuPlusTot;
	private List<Tache> predecesseursTache;
	private List<Tache> successeursTache;

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

	public int getDelaiAuPlusTard() {
		return delaiAuPlusTard;
	}

	public void setDelaiAuPlusTard(int delaiAuPlusTard) {
		this.delaiAuPlusTard = delaiAuPlusTard;
	}

	public int getDelaiAuPlusTot() {
		return delaiAuPlusTot;
	}

	public void setDelaiAuPlusTot(int delaiAuPlusTot) {
		this.delaiAuPlusTot = delaiAuPlusTot;
	}

	public List<Tache> getPredecesseursTache() {
		return predecesseursTache;
	}

	public void setPredecesseursTache(List<Tache> allTache) {
		List<Tache> predecesseursTache = new ArrayList<Tache>();
		if(this.getPredecesseurs() != null ){
			for(Integer intTachepredecesseur : this.getPredecesseurs()){
				for(Tache tache : allTache){
					if(tache.getNumero() == intTachepredecesseur){
						predecesseursTache.add(tache);
					}
				}
			}
		}
		this.predecesseursTache = predecesseursTache;
	}

	public List<Tache> getSuccesseursTache() {
		return successeursTache;
	}

	public void setSuccesseursTache(List<Tache> allTache) {
		List<Tache> successeursTache = new ArrayList<Tache>();
		this.getNumero();
		for(Tache tache : allTache){
			if(tache.getPredecesseurs() != null ){
				for(Integer intTachepredecesseur : tache.getPredecesseurs()){
					if(intTachepredecesseur == this.getNumero()){
						successeursTache.add(tache);
					}
				}
			}
		}
		this.successeursTache = successeursTache;
	}
	
	public void afficherTache(){
		System.out.print("Numeros : " + this.getNumero() + " Predecesseurs : " );
		for(Tache tachePredecesseur : this.getPredecesseursTache()){
			System.out.print(tachePredecesseur.getNumero() +  " ");
		}
		System.out.print(" Successeurs : ");
		for(Tache tacheSuccesseur : this.getSuccesseursTache()){
			System.out.print(tacheSuccesseur.getNumero() +  " ");
		}
		System.out.println("");
	}

}
