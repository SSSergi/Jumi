package Lamina;

import Objetos.Ball;
import Objetos.BlackHoles;
import Launcher.BallTask;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.geometry.Rectangle2D;
import javax.imageio.*;


public class Viewer extends Canvas implements Runnable{
    
    private Thread viewerThread;
    
    private boolean pintando;
    
    private ArrayList<Ball> pelotas;
    
    private ArrayList<BlackHoles> agujeros;
    
    private static final int anchuraViewer = 700;
    
    private static final int alturaViewer = 700;
    
    private Ball pelota;
    
    private Component componente;

    private Image imagen;
    
    public Viewer(ArrayList<Ball> pelotas, ArrayList<BlackHoles> agujeros, Ball unaPelota, Component unComponente){
        
        Dimension dimension = new Dimension(anchuraViewer, alturaViewer);
        
        pelota = unaPelota;
        
        componente = unComponente;
        
        this.setPreferredSize(dimension);
        
        this.setVisible(true);
        
        this.pelotas = pelotas;
        
        this.agujeros = agujeros;
        
        this.viewerThread = new Thread(this);
        
        this.pintando = true;
        
        this.viewerThread.start();
        
    }
	
    public void add(Ball b){
		
        pelotas.add(b);
    }
    
    public void paint(Graphics g){
        
        Graphics2D g2  = (Graphics2D) g;
        
        paintComponent(g2);
        
        for (int i = 0; i < this.pelotas.size(); i++) {
            
            this.pelotas.get(i).paint(g2);
        }
        
        for (int i = 0; i < this.agujeros.size(); i++) {
            
            this.agujeros.get(i).paint(g2);
        }
    }
    
    public void paintComponent(Graphics g){
        
        Graphics2D g2 = (Graphics2D) g;
        
        try {
            
            imagen = ImageIO.read(new File("src/img/background2.png"));
            
        } catch (IOException e) {
            
            System.err.println("Error al cargar imagen");
            
        }
        g2.drawImage(imagen, 0, 0, 1450, 1080, null);
    }
    
    
    public void run(){
        
        while(true){
            
            //paintComponent(componente2.getGraphics());
            /*for (int i = 0; i < pelotas.size(); i++) {
                
                Ball pelota = pelotas.get(i);
                
                pelota.mueve_pelota(componente.getBounds());
                
            }*/
            pelota.mueve_pelota(componente.getBounds());
            
            paint(componente.getGraphics());
            
            try {
                
                viewerThread.sleep(6);
                
            } catch (Exception e) {
                
                System.err.println("Error en Thread Viewer");
            }
        }
    }
}
