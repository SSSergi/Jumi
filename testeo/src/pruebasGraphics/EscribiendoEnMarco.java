package pruebasGraphics;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {
    
    public static void main(String[] args) {
        
        MarcoConTexto mct=new MarcoConTexto();
    
        mct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConTexto extends JFrame{
    
    public MarcoConTexto(){
        
        setVisible(true);
        
        setSize(600, 450);
        
        setLocation(400, 200);
        
        setTitle("Escribiendo en la ventana");
        
        Lamina milamina=new Lamina();
        
        add(milamina);
    }
}

class Lamina extends JPanel{
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        g.drawString("Haha que pasa bro", 100, 100);
    }
}