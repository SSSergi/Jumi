package testeo;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ball {
    
    public static void main(String[] args) {
        
        marco m=new marco();
        
        m.setVisible(true);
        
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class marco extends JFrame{
    
    public marco(){
        
        setSize(600, 600);
        
        lamina l=new lamina();
        
        add(l);
    }
}

class lamina extends JPanel{
    
    public double calcularRadio(Rectangle2D r){
        
        double A=r.getWidth()/2;
        
        double B=r.getHeight()/2;
        
        double h=Math.sqrt((A*A)+(B*B));
        
        double radio=h;
        
        return radio;
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponents(g);
        
        Graphics2D g2d=(Graphics2D) g;
        
        Rectangle2D rectangulo=new Rectangle2D.Double(20,20,20,20);
        
        Ellipse2D bola=new Ellipse2D.Double();        
        
        double centroEnX=rectangulo.getCenterX();
        
        double centroEnY=rectangulo.getCenterY();
        
        double radio=calcularRadio(rectangulo);
        
        bola.setFrameFromCenter(centroEnX, centroEnY, centroEnX+radio, centroEnY+radio);
                
        g2d.draw(bola);
    }
}