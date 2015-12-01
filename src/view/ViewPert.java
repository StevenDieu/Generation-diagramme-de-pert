package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.List;

import model.Tache;


public class ViewPert extends FunctionView {

	private static final long serialVersionUID = 1L;

	public ViewPert() {
		JFrame frame = addFrame(100,100,700,700,"Pert");

		this.addCircle(10, 10, 100, frame,1,1,1);

	}

}
