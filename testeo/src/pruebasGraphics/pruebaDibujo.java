package pruebasGraphics;

import java.awt.*;
import java.awt.geom.*;

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
    
    public double calcularRadio(Rectangle2D r){
        
        double A=r.getWidth()/2;
        
        double B=r.getHeight()/2;
        
        double h=Math.sqrt((A*A)+(B*B));
        
        double radio=h;
        
        return radio;
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        /*
        g.drawRect(50, 50, 200, 200);
        
        g.drawLine(250, 50, 50, 250);
        
        g.drawLine(250, 250, 50, 50);
        
        g.drawArc(25, 25, 250, 250, 135, 90);
        
        g.drawArc(25, 25, 250, 250, -45, 90);
        */
        Graphics2D g2d=(Graphics2D) g;
        
        Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
        
        //g2d.draw(rectangulo);
        
        //Ellipse2D elipse=new Ellipse2D.Double();
        
        //elipse.setFrame(rectangulo);
        
        //g2d.draw(elipse);
        
        //g2d.draw(new Line2D.Double(100,100,300,250));
        
        double centroEnX=rectangulo.getCenterX();
        
        double centroEnY=rectangulo.getCenterY();
        
        double radio=calcularRadio(rectangulo);
        
        Ellipse2D circulo=new Ellipse2D.Double();
        
        circulo.setFrameFromCenter(centroEnX, centroEnY, centroEnX+radio, centroEnY+radio);
        
        g2d.draw(circulo);
    }
    
} 
