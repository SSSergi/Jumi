package Objetos;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
    
    private double red=Math.random()*(0-255)+256;
    
    private double green=Math.random()*(0-255)+256;
    
    private double blue=Math.random()*(0-255)+256;
    
    private double tamX=Math.random()*(10-80)+81;
    
    private double tamY=tamX;
    
    private double posX=Math.random()*(0-1920)+1921;
	
    private double posY=Math.random()*(0-1080)+1081;
	
    private double movX=1;
	
    private double movY=1;
    
    public Ball(){
        
        this.tamX = tamX;
        this.tamY = tamY;
        /*this.red = red;
        this.green = green;
        this.blue = blue;*/
        this.posX = posX;
        this.posY = posY;   
    }
    
//Movimiento de la pelota-----------------------------------------------------------------------------------------
    
    public void mueve_pelota(Rectangle2D limites){
		
	posX=posX + movX;
		
	posY=posY + movY;
		
	if(posX<limites.getMinX()){
			
            posX=limites.getMinX();
			
            movX=-movX;
	}
		
	if(posX + tamX>=limites.getMaxX()){
			
            posX=limites.getMaxX() - tamX;
			
            movX=-movX;
	}
		
	if(posY<limites.getMinY()){
			
            posY=limites.getMinY();
			
            movY=-movY;
	}
		
	if(posY + tamY>=limites.getMaxY()){
			
            posY=limites.getMaxY() - tamY;
			
            movY=-movY;
			
	}
    }
	
    //Forma de la pelota en su posición inicial
	
    public Ellipse2D getShape(){
		
	return new Ellipse2D.Double(posX,posY,tamX,tamY);
		
    }
}

class BallThreads implements Runnable{
    
    public BallThreads(Ball unaPelota, Component unComponente){
        
        pelota = unaPelota;
        
        componente = unComponente;
    }
    
    public void run(){
        
        while(true){
				
            pelota.mueve_pelota(componente.getBounds());
				
            componente.paint(componente.getGraphics());
            
            try {
                
                Thread.sleep(4);
                
            } catch (InterruptedException ex) {
                System.err.println("Algo falla");
            }
        }
    }
    
    private Ball pelota;
    
    private Component componente;
}