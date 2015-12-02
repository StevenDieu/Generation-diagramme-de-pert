package view;

import java.util.ArrayList;
import java.util.List;

import model.Tache;


public class ViewPert extends FunctionView {

	private static final long serialVersionUID = 1L;

	public ViewPert(List<Tache> allTaches) {
		for(Tache tache : allTaches){
			tache.setPredecesseursTache(allTaches);
			tache.setSuccesseursTache(allTaches);
			tache.afficherTache();
		}
		List<List<Integer>> listInfosGraphs = new ArrayList<>();
		
		int tailleX = 10;
		int tailleY = 10;
		int tailleRayon = 100;
		int tailleXTache = 110;
		int tailleYTache = 110;
		int tamponsX = 0;
		int tamponsY = 0;

		for(Tache tache1 : allTaches){
			tamponsX = 0 ;
				for(Tache tache : allTaches){
					List<Integer> InfosGraphs = new ArrayList<Integer>();
					InfosGraphs.add(tailleX + tamponsX);
					InfosGraphs.add(tailleY + tamponsY);
					InfosGraphs.add(tailleRayon);
					InfosGraphs.add(tache.getNumero());
					InfosGraphs.add(453);
					InfosGraphs.add(78);
					listInfosGraphs.add(InfosGraphs);
					tamponsX = tamponsX + tailleXTache;
				}
			tamponsY = tamponsY + tailleYTache;
		}
		



		this.addCircle(listInfosGraphs,tamponsX,tamponsY);

	}

}
