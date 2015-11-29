package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Tache;

public class AjouterTache extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField numerosTache;
	private JTextField nomTache;
	private JTextField dureeTache;
	private JTable table;
	private JFrame frame;
	private List<Tache> allTache;
	private JLabel erroMessage;

	/**
	 * Create the frame.
	 */
	public AjouterTache(List<Tache> taches) {
		allTache = taches;
		getContentPane().setLayout(null);

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 656, 463);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);

		JLabel titrePage = new JLabel("Ajouter une tache");
		titrePage.setBounds(266, 11, 144, 14);
		frame.getContentPane().add(titrePage);

		JLabel labelNumerosTache = new JLabel("Numeros de la tache :");
		labelNumerosTache.setBounds(34, 89, 123, 14);
		frame.getContentPane().add(labelNumerosTache);

		JLabel labelNomTache = new JLabel("Nom de la tache :");
		labelNomTache.setBounds(34, 135, 102, 14);
		frame.getContentPane().add(labelNomTache);

		JLabel labelDureeTache = new JLabel("Duree de la tache : ");
		labelDureeTache.setBounds(34, 180, 102, 14);
		frame.getContentPane().add(labelDureeTache);

		JLabel labelPredesseurs = new JLabel("Predesseurs : ");
		labelPredesseurs.setBounds(34, 226, 89, 14);
		frame.getContentPane().add(labelPredesseurs);

		erroMessage = new JLabel("");
		erroMessage.setBounds(60, 41, 511, 37);
		frame.getContentPane().add(erroMessage);

		numerosTache = new JTextField();
		numerosTache.setBounds(146, 86, 123, 20);
		frame.getContentPane().add(numerosTache);
		numerosTache.setColumns(10);

		nomTache = new JTextField();
		nomTache.setBounds(146, 132, 123, 20);
		frame.getContentPane().add(nomTache);
		nomTache.setColumns(10);

		dureeTache = new JTextField();
		dureeTache.setBounds(146, 177, 123, 20);
		frame.getContentPane().add(dureeTache);
		dureeTache.setColumns(10);

		JButton btnAjouterTache = new JButton("Ajouter tache");
		btnAjouterTache.setBounds(445, 361, 137, 23);
		btnAjouterTache.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkNumerosTache() && checkNomTache() && checkDureeTache()) {
					List<Integer> predecesseurs = getPredecesseurCheck();
					Tache tache = new Tache(Integer.parseInt(numerosTache.getText()),
							Integer.parseInt(dureeTache.getText()), nomTache.getText(), predecesseurs);
					allTache.add(tache);
					frame.dispose();
					new Accueil(allTache);
				}
			}

			private List<Integer> getPredecesseurCheck() {
				List<Integer> predecesseurs = new ArrayList<Integer>();
				for (int i = 0; i < table.getRowCount(); i++) {
					boolean isChecked = (Boolean) table.getValueAt(i, 4);

					if (isChecked) {
						predecesseurs.add((Integer) Integer.parseInt((String) table.getValueAt(i, 0)));
					}
				}
				return predecesseurs;
			}

			private boolean checkDureeTache() {
				String stringDureeTache = dureeTache.getText();
				if (!stringDureeTache.equals(null) && !stringDureeTache.equals("")) {
					try {
						Integer.parseInt(stringDureeTache);
						return true;
					} catch (Exception e) {
						erroMessage.setText("La duree de la tache doit être un chiffre.");
						return false;
					}
				}
				erroMessage.setText("Le champ duree de la tache doit être rempli.");
				return false;
			}

			private boolean checkNomTache() {
				String stringNomTache = nomTache.getText();

				if (!stringNomTache.equals(null) && !stringNomTache.equals("")) {
					return true;
				}
				erroMessage.setText("Le champ nom de la tache doit être rempli.");
				return false;
			}

			private boolean checkNumerosTache() {
				String stringNumerosTache = numerosTache.getText();

				if (!stringNumerosTache.equals(null) && !stringNumerosTache.equals("")) {
					try {
						int numerostache = Integer.parseInt(stringNumerosTache);
						for (Tache tache : allTache) {
							if (tache.getNumero() == numerostache) {
								erroMessage.setText("Le numeros de la tache existe déja.");
								return false;
							}
						}
						return true;
					} catch (Exception e) {
						erroMessage.setText("Le numeros de la tache doit être un chiffre.");
						return false;
					}
				}
				erroMessage.setText("Le champ numero de la tache doit être rempli.");
				return false;
			}
		});
		frame.getContentPane().add(btnAjouterTache);

		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(34, 361, 137, 23);
		frame.getContentPane().add(btnAnnuler);
		btnAjouterTache.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Accueil(allTache);
			}
		});

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(152, 225, 447, 99);
		frame.getContentPane().add(scrollPane);

		createTablePredecesseurs(scrollPane);

		frame.setVisible(true);
	}

	private void createTablePredecesseurs(JScrollPane scrollPane) {
		Object[] columnNames = { "Numeros", "Nom de t\u00E2che", "Dur\u00E9e en jours", "T\u00E2che ant\u00E9rieurs",
				"Cocher" };
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		table = new JTable(model) {

			private static final long serialVersionUID = 1L;

			@Override
			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				default:
					return Boolean.class;
				}
			}

		};

		table.getColumnModel().getColumn(4).setPreferredWidth(22);
		scrollPane.setViewportView(table);

		for (Tache tache : allTache) {
			String stringPredecesseur = "";
			if (tache.getPredecesseurs() != null) {
				for (int predecesseur : tache.getPredecesseurs()) {
					stringPredecesseur += predecesseur + ";";
				}
				stringPredecesseur = stringPredecesseur.substring(0, stringPredecesseur.length() - 1);
			}

			String numero = Integer.toString(tache.getNumero());
			String duree = Integer.toString(tache.getDuree());
			addRowInTablePert(numero, tache.getNom(), duree, stringPredecesseur);
		}

		JLabel lblenJour = new JLabel("( En jour )");
		lblenJour.setBounds(294, 180, 66, 14);
		getContentPane().add(lblenJour);
	}

	public void addRowInTablePert(String column1, String column2, String column3, String column4) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { column1, column2, column3, column4, false });
	}
}
