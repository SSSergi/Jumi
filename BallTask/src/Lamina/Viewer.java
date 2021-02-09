package Lamina;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Viewer extends Canvas implements Runnable{
    
    private Objetos.Ball ball;
    private Objetos.BlackHole bhole;
    private Viewer viewer;
    private Component componente;
    
 
/*----------------------------------------------------------------------------*/
    
    public void run() {
        
        do {
            this.paint(this.getGraphics());
            
            try {
                
                Thread.sleep(2);
                
            } catch (InterruptedException ex) {
                
            }
        } while (true);                                                                                     
    }
    
/*----------------------------------------------------------------------------*/
    
    public void add(Objetos.Ball b){
		
	pelotas.add(b);
    }
    
    public void paint(Graphics g){
        
        super.paint(g);
        
        Graphics2D circulo=(Graphics2D) g;
        
        for(Objetos.Ball b: pelotas){
            
            circulo.setPaint(new Color((int) b.getRed(), (int) b.getGreen(), (int) b.getBlue()));
            
            circulo.fill(b.getShape());
        }
    }	
    
    private ArrayList<Objetos.Ball> pelotas=new ArrayList<Objetos.Ball>();
}