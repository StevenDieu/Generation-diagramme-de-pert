package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import model.Tache;

public class Accueil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tablePert;
	private JFrame frame;
	private List<Tache> allTache;

	public Accueil(List<Tache> taches) {
		allTache = taches;
		setLayout(null);
		frame = new JFrame("Tableau de Pert");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 600, 300);
		frame.getContentPane().setLayout(null);

		createTablePert();

		JButton btnAjouter = new JButton("Ajouter une t\u00E2che");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new AjouterTache(allTache);
			}
		});
		btnAjouter.setBounds(48, 203, 159, 23);
		frame.getContentPane().add(btnAjouter);
		
		JButton btnLancerLeDiagramme = new JButton("Lancer le diagramme");
		btnLancerLeDiagramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnLancerLeDiagramme.setBounds(353, 203, 159, 23);
		frame.getContentPane().add(btnLancerLeDiagramme);

		frame.setVisible(true);
	}

	public void createTablePert() {
		tablePert = new JTable(new DefaultTableModel(new Object[][] {},
				new String[] { "Numeros", "Nom de t\u00E2che", "Dur\u00E9e en jours", "T\u00E2che ant\u00E9rieurs" }));

		for (Tache tache : allTache) {
			String stringPredecesseur = "";
			if(tache.getPredecesseurs() != null){
				for (int predecesseur : tache.getPredecesseurs()) {
					stringPredecesseur += predecesseur + ";";
				}
				stringPredecesseur = stringPredecesseur.substring(0,stringPredecesseur.length()-1);
			}

			String numero = Integer.toString(tache.getNumero());
			String duree = Integer.toString(tache.getDuree());
			addRowInTablePert(numero, tache.getNom(), duree, stringPredecesseur);
		}

		JScrollPane scrollPane = new JScrollPane(tablePert);
		scrollPane.setBounds(0, 42, 584, 134);
		frame.getContentPane().add(scrollPane);

		JLabel lblDiagrammeDeGant = new JLabel("Diagramme de PERT");
		lblDiagrammeDeGant.setBounds(217, 11, 151, 14);
		frame.getContentPane().add(lblDiagrammeDeGant);
	}

	public void addRowInTablePert(String column1, String column2, String column3, String column4) {
		DefaultTableModel model = (DefaultTableModel) tablePert.getModel();
		model.addRow(new Object[] { column1, column2, column3, column4 });
	}
}
