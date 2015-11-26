package morpion;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Window.*;
import java.awt.GridBagLayout.*;

public class Ecouteur implements MouseListener {

    private graph app;
    private Jeu partit;
    private resultat result;

    public Ecouteur(graph a) {
        app = a;
        partit = new Jeu();
        result = new resultat();
        
    }

    public void joueur1(JButton jb) {
        app.LigneColonne(jb);
        partit.demande(0, app.getLigne(), app.getColonne(), app.opt.getxouy());
        app.changerBouton(jb);
    }

    public void ordi(JButton jb) {
        if (app.opt.getNbrjoueur() == 1) {
            if (app.opt.getDifficulte() == "Facile") {
                Ia.facile();
            }
            if (app.opt.getDifficulte() == "Moyen") {
                Ia.moyen();
            }
            if (app.opt.getDifficulte() == "Difficile") {
                //difficile
            }
            partit.demande(0, Jeu.ligne, Jeu.colonne, app.opt.getxouy());
            app.setJeu();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton jb;
        if (e.getSource() instanceof JButton) {
            jb = (JButton) e.getSource();
            switch (jb.getText()) {
                case "":
                    joueur1(jb);
                    if (result.gagne() != 0) {
                        app.resultat(result.gagne());
                        break;
                    }
                    ordi(jb);
                    if (result.gagne() != 0) {
                        app.resultat(result.gagne());
                    }
                    break;
                case "Options":
                    app.option();
                    break;
                case "1":
                    app.opt.setNbrjoueur(1);
                    app.setjoueur();
                    break;
                case "2":
                    app.opt.setNbrjoueur(2);
                    app.setjoueur();
                    break;
                case "Facile":
                    app.opt.setDifficulte("Facile");
                    app.setdif();
                    break;
                case "Moyen":
                    app.opt.setDifficulte("Moyen");
                    app.setdif();
                    break;
                case "Difficile":
                    app.opt.setDifficulte("Difficile");
                    app.setdif();
                    break;
                case "Suivant":
                    app.verifNom();
                    app.jeu();
                    break;
                case "Retour":
                    app.menu();
                    break;
                case "Quitter":
                    System.exit(0);
                case "Jouer":
                    app.nomJoueur();
                    break;
                case "Règles":
                    app.regle();
                    break;
                case "Recommencer":
                    app.jeu();
                    break;
                case "Menu":
                    app.menu();
                    break;
                case "Joueur 1 (X)":
                    app.opt.setCommence("Joueur 1 (X)");
                    app.setCom();
                    break;
                case "Joueur 2 (O)":
                    app.opt.setCommence("Joueur 2 (O)");
                    app.setCom();
                    break;
                case "Aléatoire":
                    app.opt.setCommence("Aléatoire");
                    app.setCom();
                    break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
}