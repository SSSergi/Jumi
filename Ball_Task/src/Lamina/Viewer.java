package Lamina;

import Objetos.Ball;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;



public class Viewer extends JPanel{
    
    //Añadimos pelota a la lámina
	
    public void add(Ball b){
		
        pelotas.add(b);
    }
	
    public void paintComponent(Graphics g){
		
        super.paintComponent(g);
		
        Graphics2D g2=(Graphics2D)g;
		
        for(Ball b: pelotas){
			
            g2.fill(b.getShape());
        }	
    }	
    private ArrayList<Ball> pelotas=new ArrayList<Ball>();
}
