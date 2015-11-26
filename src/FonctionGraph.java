/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.Window.*;
import java.awt.GridBagLayout.*;

/**
 *
 * @author Steven Dieu
 */
public class FonctionGraph {
    
    public JButton boutonPosition(int x,int y,int w,int h,graph appli,String s){
        JButton j = new JButton(s);
        Ecouteur ec = new Ecouteur(appli);
        
        j.setBounds(x,y,w,h); // 40 70 50 50
        
        appli.add (j);
        j.addMouseListener(ec);
        
        return j;
    }
        
    public JButton setText(int x,int y,int w,int h,graph appli,String s){
        JButton j = new JButton(s);
        Ecouteur ec = new Ecouteur(appli);
        
        j.setBounds(x,y,w,h); // 40 70 50 50
        
        appli.add (j);
        j.addMouseListener(ec);
        
        return j;
    }
    
    
   public JLabel textePosition(int x,int y,int w,int h,graph appli,String s){
        JLabel l = new JLabel (s);
        Ecouteur ec = new Ecouteur(appli);
        appli.add(l); 
        l.setBounds(x,y,w,h); // 90 30 150 20
        return l;
    }
   
   public  JTextField TexteFieldPostion(int x,int y,int w,int h,graph appli,int i){
           JTextField t = new JTextField(i);
        appli.add (t); 
        t.setBounds(x,y,w,h); // 90 30 150 20
        return t;
   }
}
