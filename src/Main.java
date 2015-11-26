import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author steven
 *
 */
public class Main {

	private static List<Tache> allTache = new ArrayList<Tache>();
	private static List<Integer> numerosAllTache = new ArrayList<Integer>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        setTitle("Morpion");
        this.setSize(taillex, tailley);
        Container c = this.getContentPane();
        setLocationRelativeTo(c.getParent());
        setLayout(null);
        this.setResizable(false);
        FonctionGraph FG = new FonctionGraph();

        appli = new graph(300, 400, opt);
        FG.boutonPosition(70, 50, 150, 50, appli, "Jouer");
        FG.boutonPosition(70, 120, 150, 50, appli, "Options");
        FG.boutonPosition(70, 190, 150, 50, appli, "Règles");
        FG.boutonPosition(70, 260, 150, 50, appli, "Quitter");
        appli.setVisible(true);
		initialisationTache();
	}

	private static void initialisationTache() {
		System.out.println("Bonjour, vous voici dans le terminal de création de pert : ");
		demandeUtilisateurPourUneNouvelleTache();
	}

	private static void demandeUtilisateurPourUneNouvelleTache() {
		Tache tache = new Tache();
		demandeNumerosTache(tache, true);
		demandeDescriptionTache(tache);
		demandeDureeTache(tache, true);
		if (allTache.size() > 0) {
			demandePredecesseurTache(tache, true);
		}
		allTache.add(tache);
		numerosAllTache.add(tache.getNumero());

		demandeUtilisateurPourUneNouvelleTache();
	}

	private static void demandeNumerosTache(Tache tache, boolean flagInit) {
		if (flagInit) {
			System.out.println("Vueillez noter le numéros de la tache");
		}
		Scanner sc = new Scanner(System.in);
		try {
			int numerosTache = Integer.parseInt(sc.nextLine());
			for (Tache uneTache : allTache) {
				if (uneTache.getNumero() == numerosTache) {
					System.out.println("Ce numéro est déja utilisé, Vueillez en retaper un autre");
					demandeNumerosTache(tache, false);
				}
			}
			tache.setNumero(numerosTache);
		} catch (NumberFormatException e) {
			System.out.println("Ceci n'est pas un numéros, Vueillez en retaper un autre");
			demandeNumerosTache(tache, false);
		} 
	}

	private static void demandeDescriptionTache(Tache tache) {
		System.out.println("Vueillez noter une description");
		Scanner sc = new Scanner(System.in);
		tache.setDescription(sc.nextLine());
	}

	private static void demandeDureeTache(Tache tache, boolean flagInit) {
		if (flagInit) {
			System.out.println("Vueillez noter la durée de la tache en heure (ex : 10 => 10 heure)");
		}

		Scanner sc = new Scanner(System.in);
		try {
			tache.setDuree(Integer.parseInt(sc.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("Ceci n'est pas une durée, vueillez en retaper un autre.");
			demandeDureeTache(tache, false);
		}
	}

	private static void demandePredecesseurTache(Tache tache, boolean flagInit) {
		if (flagInit) {
			System.out.println(
					"Votre tache à t-il des predecesseurs ? (Répondre 'N' si il n'a pas de predesseur sinon le numéros de la tâche)");
			afficherListeDesTaches();
		}

		Scanner sc = new Scanner(System.in);
		try {
			String returnPredec = sc.nextLine();
			if (!returnPredec.equals("N") || !returnPredec.equals("n")) {
				int tachePredecesseur = Integer.parseInt(returnPredec);
				for (Tache uneTache : allTache) {
					if (uneTache.getNumero() == tachePredecesseur) {
						if (tache.searchPredecesseur(tachePredecesseur, tache)) {
							System.out.println("La tâche " + tachePredecesseur
									+ " est déja dans votre liste voici votre liste : ");
							tache.afficherAllPredecesseur(tache);
							demandePredecesseurTache(tache, true);
						} else {
							System.out.println("La tâche " + tachePredecesseur
									+ " à été rajouté, retapez une tache pour en rajouter une ou taper N");
							tache.getPredecesseur().add(uneTache);
							demandePredecesseurTache(tache, true);
						}
					}
				}
				System.out.println(
						"La tache selectionner n'existe pas vueillez en repatez une nouvelle dans cette liste ou tapez N");
				afficherListeDesTaches();
			}

		} catch (NumberFormatException e) {
			System.out.println("Ceci n'est pas une tache !");
			demandePredecesseurTache(tache, false);
		}
	}

	private static void afficherListeDesTaches() {
		System.out.println("Liste des tâches :");
		for (int uneTache : numerosAllTache) {
			if (allTache.get(allTache.size() - 1).getNumero() == uneTache) {
				System.out.println(uneTache);
			} else {
				System.out.print(uneTache + " ; ");
			}
		}

	}

}
