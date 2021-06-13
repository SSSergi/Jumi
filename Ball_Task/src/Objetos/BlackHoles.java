package Objetos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



public class BlackHoles {
    
    private double tamX = 80;
    
    private double tamY = 80;
    
    private double posX=Math.random()*(0-1080)+1081;
	
    private double posY=Math.random()*(0-600)+601;
    
    private final Rectangle2D.Double rectangle2D;
    
    private boolean isFull;
    
    public BlackHoles(){
        
        this.posX = posX;
        
        this.posY = posY;
        
        this.tamX = tamX;
        
        this.tamY = tamY;
        
        this.isFull = false;
        
        this.rectangle2D = new Rectangle2D.Double(posX, posY, tamX, tamY);
    }

    public boolean isFull() {
        
        return isFull;
    }

    public void setFull(boolean full) {
        
        isFull = full;
    }
    
    public Rectangle2D.Double getRectangle2D(double posX, double posY, double tamX, double tamY) {
        
        return rectangle2D;
    }
    
    
    public void paint(Graphics2D g) {
        
        //g.draw(this.rectangle2D);
        
        g.fill(this.getRectangle2D(posX, posY, tamX, tamY));
        
        g.setColor(Color.red);
    }
}
