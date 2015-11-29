package controller;

import java.util.ArrayList;
import java.util.List;

import model.Tache;
import view.Accueil;
import view.AjouterTache;

/**
 * @author steven
 *
 */
public class Main {

	private static List<Tache> allTache = new ArrayList<Tache>();
	//private static List<Integer> numerosAllTache = new ArrayList<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tache tache = new Tache(1, 10, "test", null);
		allTache.add(tache);
		new Accueil(allTache);
		
	}

	// Demande terminal
//	private static void initialisationTache() {
//		System.out.println("Bonjour, vous voici dans le terminal de cr�ation de pert : ");
//		demandeUtilisateurPourUneNouvelleTache();
//	}
//
//	private static void demandeUtilisateurPourUneNouvelleTache() {
//		Tache tache = new Tache();
//		demandeNumerosTache(tache, true);
//		demandeDescriptionTache(tache);
//		demandeDureeTache(tache, true);
//		if (allTache.size() > 0) {
//			demandePredecesseurTache(tache, true);
//		}
//		allTache.add(tache);
//		numerosAllTache.add(tache.getNumero());
//
//		demandeUtilisateurPourUneNouvelleTache();
//	}
//
//	private static void demandeNumerosTache(Tache tache, boolean flagInit) {
//		if (flagInit) {
//			System.out.println("Vueillez noter le num�ros de la tache");
//		}
//		Scanner sc = new Scanner(System.in);
//		try {
//			int numerosTache = Integer.parseInt(sc.nextLine());
//			for (Tache uneTache : allTache) {
//				if (uneTache.getNumero() == numerosTache) {
//					System.out.println("Ce num�ro est d�ja utilis�, Vueillez en retaper un autre");
//					demandeNumerosTache(tache, false);
//				}
//			}
//			tache.setNumero(numerosTache);
//		} catch (NumberFormatException e) {
//			System.out.println("Ceci n'est pas un num�ros, Vueillez en retaper un autre");
//			demandeNumerosTache(tache, false);
//		} 
//	}
//
//	private static void demandeDescriptionTache(Tache tache) {
//		System.out.println("Vueillez noter une description");
//		Scanner sc = new Scanner(System.in);
//		tache.setDescription(sc.nextLine());
//	}
//
//	private static void demandeDureeTache(Tache tache, boolean flagInit) {
//		if (flagInit) {
//			System.out.println("Vueillez noter la dur�e de la tache en heure (ex : 10 => 10 heure)");
//		}
//
//		Scanner sc = new Scanner(System.in);
//		try {
//			tache.setDuree(Integer.parseInt(sc.nextLine()));
//		} catch (NumberFormatException e) {
//			System.out.println("Ceci n'est pas une dur�e, vueillez en retaper un autre.");
//			demandeDureeTache(tache, false);
//		}
//	}
//
//	private static void demandePredecesseurTache(Tache tache, boolean flagInit) {
//		if (flagInit) {
//			System.out.println(
//					"Votre tache � t-il des predecesseurs ? (R�pondre 'N' si il n'a pas de predesseur sinon le num�ros de la t�che)");
//			afficherListeDesTaches();
//		}
//
//		Scanner sc = new Scanner(System.in);
//		try {
//			String returnPredec = sc.nextLine();
//			if (!returnPredec.equals("N") || !returnPredec.equals("n")) {
//				int tachePredecesseur = Integer.parseInt(returnPredec);
//				for (Tache uneTache : allTache) {
//					if (uneTache.getNumero() == tachePredecesseur) {
//						if (tache.searchPredecesseur(tachePredecesseur, tache)) {
//							System.out.println("La t�che " + tachePredecesseur
//									+ " est d�ja dans votre liste voici votre liste : ");
//							tache.afficherAllPredecesseur(tache);
//							demandePredecesseurTache(tache, true);
//						} else {
//							System.out.println("La t�che " + tachePredecesseur
//									+ " � �t� rajout�, retapez une tache pour en rajouter une ou taper N");
//							tache.getPredecesseur().add(uneTache);
//							demandePredecesseurTache(tache, true);
//						}
//					}
//				}
//				System.out.println(
//						"La tache selectionner n'existe pas vueillez en repatez une nouvelle dans cette liste ou tapez N");
//				afficherListeDesTaches();
//			}
//
//		} catch (NumberFormatException e) {
//			System.out.println("Ceci n'est pas une tache !");
//			demandePredecesseurTache(tache, false);
//		}
//	}
//
//	private static void afficherListeDesTaches() {
//		System.out.println("Liste des t�ches :");
//		for (int uneTache : numerosAllTache) {
//			if (allTache.get(allTache.size() - 1).getNumero() == uneTache) {
//				System.out.println(uneTache);
//			} else {
//				System.out.print(uneTache + " ; ");
//			}
//		}
//
//	}

}
