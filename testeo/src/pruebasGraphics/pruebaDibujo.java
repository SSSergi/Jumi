package pruebasGraphics;

import java.awt.*;

import javax.swing.*;


public class pruebaDibujo {
    
    public static void main(String[] args) {
        
        MarcoConDibujos mimarco=new MarcoConDibujos();
        // Hacemos que el marco sea visible
        mimarco.setVisible(true);
        // Que al darle a cerrar ventana se termine el programa
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

//Con esto creamos el marco/ventana/frame (los tres son sinónimos en este caso)
class MarcoConDibujos extends JFrame{
    
    public MarcoConDibujos(){
        
        setTitle("prueba de dibujo");
        
        setSize(400, 400);
        
        LaminaConFiguras miLamina=new LaminaConFiguras();
        
        add(miLamina);
    }
    
}


class LaminaConFiguras extends JPanel{
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        g.drawRect(50, 50, 200, 200);
        
        g.drawLine(250, 50, 50, 250);
        
        g.drawLine(250, 250, 50, 50);
        
        g.drawArc(25, 25, 250, 250, 135, 90);
        
        g.drawArc(25, 25, 250, 250, -45, 90);
    }
    
}
