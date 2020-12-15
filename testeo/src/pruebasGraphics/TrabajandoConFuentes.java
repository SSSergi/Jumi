package pruebasGraphics;

import java.awt.*;
import java.awt.Graphics2D;

import javax.swing.*;

public class TrabajandoConFuentes {
    
    public static void main(String[] args) {
        
        MarcoConFuentes mimarco=new MarcoConFuentes();
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mimarco.setVisible(true);
    }
    
}

class MarcoConFuentes extends JFrame{
    
    public MarcoConFuentes(){
        
        setTitle("Prueba con Fuentes");
        
        setSize(400, 400);
        
        LaminaConFuentes milamina=new LaminaConFuentes();
        
        add(milamina);
        
        // Parte para hacer que toda la fuente en el frame sea de un mismo color.
        milamina.setForeground(Color.BLUE);
    }
}

class LaminaConFuentes extends JPanel{
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D g2d=(Graphics2D) g;
        
        Font mifuente=new Font("Courier", Font.BOLD, 26);
        
        g2d.setFont(mifuente);
        
        //g2d.setColor(Color.RED);
        
        g2d.drawString("Sergio", 100, 100);
        
        g2d.setFont(new Font("Arial", Font.ITALIC, 14));
        
        //g2d.setColor(new Color(128, 90, 50));
        
        g2d.drawString("Curso de Java", 100, 200);
    }
}