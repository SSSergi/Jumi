package Lamina;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Viewer extends Canvas implements Runnable{
    
    private Objetos.Ball ball;
    private Objetos.BlackHole bhole;
    private Viewer viewer;
    private Component componente;
    
    
    public Viewer(Objetos.Ball bola, Component unComponente){
        
        ball = bola;
        
        componente = unComponente;
    }
 
/*----------------------------------------------------------------------------*/
    
    public void run() {
        
        ball.mueve_pelota(componente.getBounds());
        
        viewer.paint(viewer.getGraphics());
        
        try {
            Thread.sleep(5); // 
        } catch (InterruptedException ex) {
        }
    }
    
/*----------------------------------------------------------------------------*/
    
    
    public void paint(Graphics g){
        
        super.paint(g);
        
        Graphics2D circulo=(Graphics2D) g; 
        
        circulo.setStroke(new BasicStroke(5.f));
        
        circulo.setPaint(Color.blue);
        
        //radio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio del círculo"));  **Esta línea sirve para introducir el valor del radio. Tenerlo en cuenta                   
        
        circulo.drawOval((int) ball.getPosX(), (int) ball.getPosY(), (int) ball.getDiametro(),(int) ball.getDiametro());
        
        circulo.setPaint(new Color((int) ball.getRed(), (int) ball.getGreen(), (int) ball.getBlue()));
        
        circulo.fillOval((int) ball.getPosX(), (int) ball.getPosY(), (int) ball.getDiametro(),(int) ball.getDiametro());
    }
    
    public void add(Objetos.Ball b){
		
	pelotas.add(b);
    }	
    
    private ArrayList<Objetos.Ball> pelotas=new ArrayList<Objetos.Ball>();
}
