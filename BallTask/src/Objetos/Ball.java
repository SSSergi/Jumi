package Objetos;

import java.awt.*;
import java.awt.geom.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


public class Ball implements Runnable{
    
    // Color se hace con 3 atributos, 1 para Red, 1 para Green y 1 para Blue. Los 3 son Ints, y en dentro del constructor meteremos randoms en estas variables, para que se pueda generar así un color diferente.
    
    // Variables para formar un color
    private double red=Math.random()*(0-255)+256;
    private double green=Math.random()*(0-255)+256;
    private double blue=Math.random()*(0-255)+256;
    
    private double posX=Math.random()*(0-1960)+1961;
    private double posY=Math.random()*(0-1040)+1041;
    
    private double movX=1;
    private double movY=1;
    
    private double tamX=Math.random()*(10-80)+81;
    private double tamY=tamX;
    
    private Lamina.Viewer componente;
    
  
    public Ball(){
        
        this.tamX = tamX;
        this.tamY = tamY;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.posX = posX;
        this.posY = posY;   
    }

    /* ----------------------------- GETTERS -------------------------------- */
    
    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getMovX() {
        return movX;
    }

    public double getMovY() {
        return movY;
    }

    public double getTamX() {
        return tamX;
    }

    public double getTamY() {
        return tamY;
    }

     
    
    /* ------------------------------- SETTER ------------------------------- */

    public void setRed(double red) {
        this.red = red;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setMovX(double movX) {
        this.movX = movX;
    }

    public void setMovY(double movY) {
        this.movY = movY;
    }

    public void setTamX(double tamX) {
        this.tamX = tamX;
    }

    public void setTamY(double tamY) {
        this.tamY = tamY;
    }
  
   
    public void mueve_pelota(Rectangle2D limites){
		
	posX = posX + movX;
        
	posY = posY + movY;
		
	if(posX < limites.getMinX()){
			
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
			
		posY=limites.getMaxY()- tamY;
			
		movY=-movY;
			
	}
		
    }
    
    public Ellipse2D getShape(){
	
        return new Ellipse2D.Double(posX,posY,tamX,tamY);	
    }
    
    public void run() {
        
        while (true) {            
            
            mueve_pelota(componente.getBounds());                     
            
            try {
                
                Thread.sleep(2);
                
            } catch (InterruptedException ex) {
                
                
            }
        }     
    }
}
