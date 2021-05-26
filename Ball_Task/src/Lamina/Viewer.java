package Lamina;

import Objetos.Ball;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;



public class Viewer extends Canvas{
    
    private ArrayList<Ball> pelotas=new ArrayList<Ball>();
    
    private static final int anchuraViewer = 700;
    
    private static final int alturaViewer = 700;
    
    public Viewer(ArrayList<Ball> pelotas){
        
        Dimension dimension = new Dimension(anchuraViewer, alturaViewer);
        this.setPreferredSize(dimension);
        this.setVisible(true);
    }
    
    //Añadimos pelota a la lámina
	
    public void add(Ball b){
		
        pelotas.add(b);
    }
	
    public void paint(Graphics g){

        Graphics2D g2=(Graphics2D) g;
        
        for (int i = 0; i < this.pelotas.size(); i++) this.pelotas.get(i).paint(g2);
    }
}
