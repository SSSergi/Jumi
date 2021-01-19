package Objetos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class BlackHole extends JPanel{
    
    // **De momento los atributos de color no se usan, pero lo dejo aquí ya puesto para más tarde, si da tiempo**
    int red;
    int green;
    int blue;
    
    double posX=Math.random()*(0-1960)+1961;
    double posY=Math.random()*(0-1040)+1041;
    
    double costadoCorto=Math.random()*(5-50)+51;
    double costadoLargo=Math.random()*(5-50)+51;
    
    
    public BlackHole(){
        
        this.red=red;
        this.green=green;
        this.blue=blue;
        this.costadoCorto=costadoCorto;
        this.costadoLargo=costadoLargo;
        this.posX=posX;
        this.posY=posY;
    }
    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        Graphics2D rectangulo=(Graphics2D) g;        
        
        rectangulo.setStroke(new BasicStroke(5.f));
        
        rectangulo.setPaint(Color.blue);
        
        //radio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el radio del círculo"));  **Esta línea sirve para introducir el valor del radio. Tenerlo en cuenta                   
        
        rectangulo.drawRect((int) posX, (int) posY, (int) costadoLargo, (int) costadoCorto);
        
        rectangulo.setPaint(Color.black);        
        
        rectangulo.fillRect(30, 30, (int) costadoLargo, (int) costadoCorto);
    }
}
