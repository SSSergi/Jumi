package Lamina;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Viewer extends Canvas{
    
    private Objetos.Ball ball;
    private Objetos.BlackHole bhole;
    
    
    public Viewer(){       
    }
 
/*----------------------------------------------------------------------------*/
    
    public void run() {
        this.createBufferStrategy(2);
        
        this.paintComponent(g);
        try {
            Thread.sleep(5); // 
        } catch (InterruptedException ex) {
        }
    }
    
/*----------------------------------------------------------------------------*/
    
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D circulo=(Graphics2D) g; 
        
        circulo.setStroke(new BasicStroke(5.f));
        
        circulo.setPaint(Color.blue);
        
        //radio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio del círculo"));  **Esta línea sirve para introducir el valor del radio. Tenerlo en cuenta                   
        
        circulo.drawOval((int) ball.getPosX(), (int) ball.getPosY(), (int) ball.getDiametro(),(int) ball.getDiametro());
        
        circulo.setPaint(new Color((int) ball.getRed(), (int) ball.getGreen(), (int) ball.getBlue()));
        
        circulo.fillOval((int) ball.getPosX(), (int) ball.getPosY(), (int) ball.getDiametro(),(int) ball.getDiametro());
    }
}
