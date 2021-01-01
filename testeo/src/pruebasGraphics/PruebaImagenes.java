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
    
    /*Al meter el TRY CATCH dentro del constructor creamos la instancia con la imagen ya cargada en memoria, NO PINTADA, sino CARGADA en memoria*/
    public LaminaConImagen(){
        
        try{
            // O podemos instanciar la ruta de la imagen dentro del read()
            imagen=ImageIO.read(new File("src\\BibliotecaImagenes\\subnautica.jpg"));
            
        }catch(IOException e){
            
            System.out.println("No se encuentra imagen.");
        }
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        // Se puede cargar la ruta de la imagen en la variable
        //File miimagen=new File("C:\\Users\\Sanitat\\Pictures\\Fondos de pantalla\\pjhin.png");
        
        int anchuraImagen=imagen.getWidth(this);
        
        int alturaImagen=imagen.getHeight(this);
        
        g.drawImage(imagen, 0,0, null);
        
        /*Con est ote montas básicamente un mosaico, haces que se repita la imagen, cuyo tamño a representar marcas con el 3 y 4 valores.*/
        for(int i=0;i<300;i++){
            
            for(int j=0;j<200;j++){
                
                g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*i);
            }
        }
    }
    
    private Image imagen;
}