package pruebasGraphics;

import java.awt.geom.*;
import java.awt.*;

import javax.swing.*;

public class TrabajandoColores {
    
    public static void main(String[] args) {
        
        MarcoConColor mcc=new MarcoConColor();
        
        mcc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mcc.setVisible(true);
    }
    
}

class MarcoConColor extends JFrame{
    
    public MarcoConColor(){
        
        setTitle("Prueba con colores");
        
        setSize(400, 400);
        
        LaminaConColor milamina=new LaminaConColor();
        
        add(milamina);
        
        milamina.setBackground(Color.RED);
    }
    
}

class LaminaConColor extends JPanel{
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d=(Graphics2D) g;
        
        Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
        
        g2d.setPaint(Color.CYAN);
        
        g2d.fill(rectangulo);
        
        g2d.setPaint(Color.BLACK);
        
        g2d.draw(rectangulo);
        
        Ellipse2D elipse=new Ellipse2D.Double();
        
        elipse.setFrame(rectangulo);
        
        g2d.setPaint(new Color(180,100,154).brighter());
        
        g2d.fill(elipse);
        
        g2d.setPaint(Color.BLACK);
        
        g2d.draw(elipse);
    }
}