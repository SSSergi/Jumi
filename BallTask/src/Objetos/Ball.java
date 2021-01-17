package Objetos;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;


public class Ball extends JPanel{
    
    // Color se hace con 3 atributos, 1 para Red, 1 para Green y 1 para Blue. Los 3 son Ints, y en dentro del constructor meteremos randoms en estas variables, para que se pueda generar así un color diferente.
    
    // Variables para formar un color
    int red;
    int green;
    int blue;
    
    
    
    public Ball(){
        
        
        
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
    }
}
