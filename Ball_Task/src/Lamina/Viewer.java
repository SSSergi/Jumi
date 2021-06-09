package Lamina;

import Objetos.Ball;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;



public class Viewer extends JPanel{
    
    private ArrayList<Ball> pelotas=new ArrayList<Ball>();
    
    //Añadimos pelota a la lámina
	
    public void add(Ball b){
		
        pelotas.add(b);
    }	
}
