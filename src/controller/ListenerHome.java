package controller;

import javax.swing.*;

import view.ViewAddTache;
import view.ViewPert;
import model.Tache;

import java.awt.event.*;
import java.util.List;

public class ListenerHome implements MouseListener {
	
	private List<Tache> allTache;
	private JFrame frame;

	public ListenerHome(List<Tache> allTache, JFrame frame) {
		this.allTache = allTache;
		this.frame = frame;
	}

    @Override
    public void mouseClicked(MouseEvent e) {
    }

	@Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
        	JButton jb = (JButton) e.getSource();
            switch (jb.getText()) {
                case "Ajouter une t\u00E2che":
                	addTache();
                    break;
                case "Lancer le diagramme":
                	lauchDiagramme();
                    break;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

	private void addTache() {
		frame.dispose();
    	new ViewAddTache(allTache);
	}
    
    private void lauchDiagramme() {
    	if(allTache.size() != 0){
    		frame.dispose();
        	new ViewPert(allTache);
    	}
	}
}