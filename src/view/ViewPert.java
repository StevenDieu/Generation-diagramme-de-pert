package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Tache;
import model.TacheArray;

public class ViewPert extends FunctionView {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public ViewPert(List<Tache> allTaches) {
		TacheArray tacheFirst = new TacheArray();
		List<Tache> tachesFirst = new ArrayList<>();
		for (Tache tache : allTaches) {
			tache.setPredecesseursTache(allTaches);
			tache.setSuccesseursTache(allTaches);
			tache.afficherTache();
			if (tache.getPredecesseursTache().size() == 0) {
				tachesFirst.add(tache);
			}
		}
		tacheFirst.setTachesFirst(tachesFirst);

		int widhtFrame = 0;
		int heightFrame = 0;

		tacheFirst.generateTableau();
		List<Map<String, Object>> tableauTaches = tacheFirst.getTableauTache();
		
		for(int i = tacheFirst.getNbrColonne() - 1; i > 0; i--){
			for(Tache tache : (List<Tache>) tacheFirst.getTableauTache().get(i).get("taches")){
				if(tache.getSuccesseursTache().size() == 0){
					tache.setDelaiAuPlusTard(tache.getDelaiAuPlusTot());
				}else{
					int delaiPlusTard =  tache.getDuree();
					for(Tache successeur: tache.getSuccesseursTache()){
						int tmpDelaiPlusTard = successeur.getDelaiAuPlusTard() - successeur.getDuree();
						if(delaiPlusTard < tmpDelaiPlusTard){
							delaiPlusTard = tmpDelaiPlusTard;
						}
					}
					tache.setDelaiAuPlusTard(delaiPlusTard);
				}
			}
		}

		int tailleX = 50;
		int tailleY = 50;
		int tailleRayon = 120;
		int tailleXTache = tailleRayon + tailleX;
		int tailleYTache = tailleRayon + tailleY;
		int tamponsX = 0;
		int tamponsY = 0;
		List<List<Integer>> listInfosGraphs = new ArrayList<>();

		for (Map<String, Object> tableau : tableauTaches) {
			tamponsY = 0;
			
			for (Tache tache : (List<Tache>) tableau.get("taches")) {
				
				List<Integer> InfosGraphs = new ArrayList<Integer>();
				InfosGraphs.add(tailleX + tamponsX);
				InfosGraphs.add(tailleY + tamponsY);
				InfosGraphs.add(tailleRayon);
				InfosGraphs.add(tache.getNumero());
				InfosGraphs.add(tache.getDelaiAuPlusTard());
				InfosGraphs.add(tache.getDelaiAuPlusTot());
				listInfosGraphs.add(InfosGraphs);
				tamponsY = tamponsY + tailleYTache;
			}
			
			if(tamponsY > heightFrame){
				heightFrame = tamponsY;
			}
			
			tamponsX = tamponsX + tailleXTache;
			
		}
		widhtFrame = tamponsX - tailleRayon + tailleX;

		this.addCircle(listInfosGraphs, widhtFrame + 110, heightFrame + 110);

	}

}
