package testeo;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    
    private double radio=0.0;
    private double diametro;
    
    public double calcularRadio(Rectangle2D r){
        
        double A=r.getWidth()/2;
        
        double B=r.getHeight()/2;
        
        double h=Math.sqrt((A*A)+(B*B));
        
        double radio=h;
        
        return radio;
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D circulo=(Graphics2D) g;
        
        radio=Math.random()*(5-50)+50;
        
        diametro=radio*2; 
        
        circulo.setStroke(new BasicStroke(2.f));
        
        circulo.setPaint(Color.blue);
        
        // radio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio del círculo"));  **Esta línea sirve para introducir el valor del radio. Tenerlo en cuenta                   
        
        circulo.drawOval(30, 30, (int)diametro,(int) diametro);
        
        circulo.setPaint(Color.CYAN);
        
        circulo.fillOval(30, 30, (int) diametro, (int) diametro);
        
        /*
        super.paintComponents(g);
        
        Graphics2D g2d=(Graphics2D) g;
        
        Rectangle2D rectangulo=new Rectangle2D.Double(20,20,20,20);
        
        Ellipse2D bola=new Ellipse2D.Double();
        
        double centroEnX=rectangulo.getCenterX();
        
        double centroEnY=rectangulo.getCenterY();
        
        double radio=calcularRadio(rectangulo);
        
        bola.setFrameFromCenter(centroEnX, centroEnY, centroEnX+radio, centroEnY+radio);

        g2d.setPaint(Color.blue.brighter());
        
        g2d.fill(bola);
        
        g2d.setPaint(Color.BLACK);        
                
        g2d.draw(bola);
        */
    }
}