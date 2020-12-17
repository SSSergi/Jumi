package pruebasGraphics;

import java.awt.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class PruebaImagenes {
    
    public static void main(String[] args) {
        
        MarcoImagen mimarco=new MarcoImagen();
        
        mimarco.setVisible(true);
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoImagen extends JFrame{
    
    public MarcoImagen(){
        
        setTitle("Marco con Imagen");
        
        setBounds(300, 300, 1300, 750);
        
        LaminaConImagen milamina=new LaminaConImagen();
        
        add(milamina);
        
        //setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}

class LaminaConImagen extends JPanel{
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        // Se puede cargar la ruta de la imagen en la variable
        //File miimagen=new File("C:\\Users\\Sanitat\\Pictures\\Fondos de pantalla\\pjhin.png");
        
        try{
            // O podemos instanciar la ruta de la imagen dentro del read()
            imagen=ImageIO.read(new File("C:\\Users\\Usuario\\Pictures\\Fondos de pantalla\\subnautica.jpg"));
            
        }catch(IOException e){
            
            System.out.println("No se encuentra imagen.");
        }
        
        g.drawImage(imagen, 0,0, null);
        
        g.copyArea(0, 0, 894, 894, 200, 200);
    }
    
    private Image imagen;
}