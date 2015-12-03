package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TacheArray {
	private List<Tache> tachesFirst;
	List<Map<String, Object>> tableauTache = new ArrayList<Map<String, Object>>();
	private int nbrColonne;

	public TacheArray() {
		super();
	}

	public List<Tache> getTachesFirst() {
		return tachesFirst;
	}

	public void setTachesFirst(List<Tache> tacheFirst) {
		this.tachesFirst = tacheFirst;
	}

	public List<Map<String, Object>> getTableauTache() {
		return tableauTache;
	}

	public void setTableauTache(List<Map<String, Object>> tableauTache) {
		this.tableauTache = tableauTache;
	}
	
	public int getNbrColonne() {
		return nbrColonne;
	}

	public void setNbrColonne(int nbrColonne) {
		this.nbrColonne = nbrColonne;
	}

	public void generateTableau() {
		int colonne = 1;
		Map<String, Object> colonneTache = new HashMap<String, Object>();
		List<Integer> predeccesseursDejaParcouru = new ArrayList<>();

		for (Tache tache : tachesFirst) {
			tache.setDelaiAuPlusTot(tache.getDuree());
			predeccesseursDejaParcouru.add(tache.getNumero());
		}

		colonneTache.put("taches", tachesFirst);
		colonneTache.put("colonne", colonne);
		tableauTache.add(colonneTache);
		recursiveTableau(colonne + 1, tachesFirst, predeccesseursDejaParcouru);

	}

	private void recursiveTableau(int colonne, List<Tache> taches, List<Integer> predeccesseursDejaParcouru) {
		List<Tache> nextTaches = new ArrayList<Tache>();
		Map<String, Object> colonneTache = new HashMap<String, Object>();
		List<Integer> tmpPredeccesseursDejaParcouru = new ArrayList<Integer>();

		for (Tache tache : taches) {
			if (tache.getSuccesseursTache().size() != 0) {
				for (Tache successeur : tache.getSuccesseursTache()) {
					if (successeur.isLastPredeccesseur(predeccesseursDejaParcouru, tache.getNumero())) {
						if (successeur.isNotContainIn(nextTaches)) {
							successeur.searchAddDelaiAuPlusTot();
							nextTaches.add(successeur);
							tmpPredeccesseursDejaParcouru.add(successeur.getNumero());
						}
					}
				}
			}
		}
		if (tmpPredeccesseursDejaParcouru.size() != 0) {
			predeccesseursDejaParcouru.addAll(tmpPredeccesseursDejaParcouru);
			colonneTache.put("taches", nextTaches);
			colonneTache.put("colonne", colonne);
			tableauTache.add(colonneTache);

			nbrColonne = colonne;
		}
		if (nextTaches.size() != 0) {
			recursiveTableau(colonne + 1, nextTaches, predeccesseursDejaParcouru);
		}
	}



}
