import java.util.List;

public class Tache {
	private int numero;
	private int duree;
	private String description;
	private List<Tache> predecesseur;

	public Tache() {
		super();
	}
	
	public void afficherAllPredecesseur(Tache tache){
		for(Tache predesseurTache : tache.getPredecesseur()){
			if (tache.getPredecesseur().get(tache.getPredecesseur().size() - 1).getNumero() == predesseurTache.getNumero()) {
				System.out.println(predesseurTache.getNumero());
			} else {
				System.out.print(predesseurTache.getNumero() + " ; ");
			}
		}
	}
	
	public boolean searchPredecesseur(int numero,Tache tache){
		for(Tache predesseurTache : tache.getPredecesseur()){
			if(predesseurTache.getNumero() == numero){
				return true;
			}
		}
		return false;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Tache> getPredecesseur() {
		return predecesseur;
	}

	public void setPredecesseur(List<Tache> predecesseur) {
		this.predecesseur = predecesseur;
	}

}
