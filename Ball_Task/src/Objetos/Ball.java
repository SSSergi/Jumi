package Objetos;

import Launcher.BallTask;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball implements Runnable{
    
    private Ball pelota;
    
    private final Thread t;
    
    public static BallTask balltask;
    
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
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.posX = posX;
        this.posY = posY;   
        this.t = new Thread(this);
    }
    
    /* -------- GETTERS -------- */
    
    public Thread getT() {
        return t;
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getTamX() {
        return tamX;
    }

    public double getTamY() {
        return tamY;
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
    
    /* -------- SETTERS -------- */

    public void setRed(double red) {
        this.red = red;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    public void setTamX(double tamX) {
        this.tamX = tamX;
    }

    public void setTamY(double tamY) {
        this.tamY = tamY;
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
	
    public Ellipse2D getShape(double posX, double posY, double tamX, double tamY){
		
	return new Ellipse2D.Double(posX,posY,tamX,tamY);
		
    }
    
    public void crearBola(){
        
        this.t.start();
    }
    
    public void paint(Graphics2D g){
		
        Graphics2D g2=(Graphics2D)g;
        
        g.fill(this.getShape(posX, posY, tamX, tamY));
        
        g.setColor(Color.BLACK);
        /*for(Ball b: pelotas){
            
            g2.fill(b.getShape());
        }*/	
    }
    
    @Override
    public void run(){
        
        try {
            this.t.sleep(balltask.delay);
            
        } catch (InterruptedException e) {
            
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}