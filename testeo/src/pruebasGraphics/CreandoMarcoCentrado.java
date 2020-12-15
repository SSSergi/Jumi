package pruebasGraphics;

import java.awt.*;
import javax.swing.*;

public class CreandoMarcoCentrado {
    
    public static void main(String[] args) {
        
        MarcoCentrado mcentrado=new MarcoCentrado();
        
        mcentrado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mcentrado.setVisible(true);
    }
}

class MarcoCentrado extends JFrame{
    
    public MarcoCentrado(){
        
        Toolkit miPantalla=Toolkit.getDefaultToolkit();
        
        Dimension tamPantalla=miPantalla.getScreenSize();
        
        int alturaPantalla=tamPantalla.height;
        
        int anchuraPantalla=tamPantalla.width;
        
        setSize(anchuraPantalla/2, alturaPantalla/2);
        
        setLocation(anchuraPantalla/4, alturaPantalla/4);
        
        setTitle("Marco Centrado");
        
        // Metemos en la variable de tipo Image, el getImage del objeto Toolkit que creamos antes, que es miPantalla, y le metemos la ruta del archivo que queremos mostrar como icono.
        Image miIcono=miPantalla.getImage("C:\\Users\\Usuario\\Pictures\\Vigilantes del abismo.jpg");
        // Actualizamos el icono.
        setIconImage(miIcono);
    }
    
}
