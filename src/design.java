import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class design extends JPanel {
	private JTable table;
    private static int columnNumber = 1;

	/**
	 * Create the panel.
	 */
	public design() {
		setLayout(null);
		
		DefaultTableModel  tableModel = new DefaultTableModel(new Object[] { "Initial Column" }, 5);
        JTable table = new JTable(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        		{null, null, null, null},
        	},
        	new String[] {
        		"Lettre", "Nom de t\u00E2che", "Dur\u00E9e en jours", "T\u00E2che ant\u00E9rieurs"
        	}
        ));
        JFrame frame = new JFrame("Table Column Add");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 600, 300);
        frame.getContentPane().setLayout(null);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 42, 584, 134);
        frame.getContentPane().add(scrollPane);
        
        JLabel lblDiagrammeDeGant = new JLabel("Diagramme de PERT");
        lblDiagrammeDeGant.setBounds(234, 11, 110, 14);
        frame.getContentPane().add(lblDiagrammeDeGant);
        
        JButton btnAjouter = new JButton("Ajouter une t\u00E2che");
        btnAjouter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        btnAjouter.setBounds(38, 203, 159, 23);
        frame.getContentPane().add(btnAjouter);
        
        JButton btnLancerLeDiagramme = new JButton("Lancer le diagramme");
        btnLancerLeDiagramme.setBounds(345, 203, 159, 23);
        frame.getContentPane().add(btnLancerLeDiagramme);
        frame.setVisible(true);

	}
}
