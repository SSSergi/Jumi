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
    
    
    public void paint(){
        BufferStrategy bs;
        
        bs=this.getBufferStrategy();
        if (bs==null){
            System.out.println("kgd");
            return;
        }

        Graphics g=bs.getDrawGraphics();
        g.drawImage(this.readImage(file), 100,100,100,100,null);
        //this.;
        //this.fireThree.paint(g);

        bs.show();
        g.dispose();
    }
}
