package view;
import java.awt.*;
import javax.swing.*;

public class JCanvas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x,y,r;
	String c1,c2,c3;
	Graphics g;
	
	public JCanvas (int x, int y, int r, int c1, int c2, int c3){
		this.x = x;
		this.y = y;
		this.r = r;
		this.c1 = Integer.toString(c1);
		this.c2 = Integer.toString(c2);
		this.c3 =  Integer.toString(c3);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.g = g;
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillOval(x,y,r,r);
		g.setColor(c);
		g.setColor(Color.WHITE);
		g.fillOval(x+3,y+3,r-6,r-6);
		g.setColor(c);
		g.drawLine(x, y+r/2, x+r, y+r/2);
		g.drawLine(x+r/2, y+r/2, x+r/2, y+r);
		
		int hC1 = 0;
		for(int i = 0; i <= c1.length(); i++){
			 hC1 += 2 ;
		}
		int hC2 = 0;
		for(int i = 0; i <= c2.length(); i++){
			hC2 += 2 ;
		}
		
		int hC3 = 0;
		for(int i = 0; i <= c3.length(); i++){
			hC3 += 2 ;
		}
		g.drawString(c1, x+r/2-hC1, y+r/3);
		g.drawString(c2, x+r*2/3-hC2, y+r*3/4);
		g.drawString(c3, x+r/3-hC3, y+r*3/4);
	}
	
 

}
   