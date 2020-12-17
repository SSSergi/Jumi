package PrototipoModificadorImagen;

import java.awt.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;


public class Viewer extends Canvas{
    
    private BufferedImage imgOriginal;
    private String file="C:\\Users\\Sanitat\\Pictures\\Fondos de pantalla\\pjhin.png";
    
    private Image readImage(String file){
        
        BufferedImage img;
        
        try{
            
            img=ImageIO.read(new File("C:\\Users\\Sanitat\\Pictures\\Fondos de pantalla\\pjhin.png"));
            
            return img;  /* Se ha encontrado la imagen y todo va correcto */
            
        }catch (IOException e){
            
            System.err.println("Img Error("+e+")");
        }
        
        return null;
    }
    
    public void paint(Graphics g){
        
        super.paint(g);
        
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
