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
    
    double posX=Math.random()*(0-1960)+1961;
    double posY=Math.random()*(0-1040)+1041;
    
    double radio=Math.random()*(5-50)+51;
    double diametro=radio*2;
    
    
    
    public Ball(){
        
        this.red=red;
        this.green=green;
        this.blue=blue;
        this.radio=radio;
        this.diametro=diametro;
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D circulo=(Graphics2D) g;
        
        radio=15.0;
        
        diametro=radio*2; 
        
        circulo.setStroke(new BasicStroke(5.f));
        
        circulo.setPaint(Color.blue);
        
        //radio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio del círculo"));  **Esta línea sirve para introducir el valor del radio. Tenerlo en cuenta                   
        
        circulo.drawOval((int) posX, (int) posY, (int)diametro,(int) diametro);
        
        circulo.setPaint(Color.black);
        
        circulo.fillOval((int) posX, (int)  posY, (int) diametro, (int) diametro);
    }
}
