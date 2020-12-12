package pruebasGraphics;

import java.awt.*;
import javax.swing.*;

public class CreandoMarcoCentrado {
    
    public static void main(String[] args) {
        
    }
}

class MarcoCentrado extends JFrame{
    
    public MarcoCentrado(){
        
        Toolkit miPantalla=Toolkit.getDefaultToolkit();
        
        Dimension tamPantalla=miPantalla.getScreenSize();
        
        int alturaPantalla=tamPantalla.height;
        
        int anchuraPantalla=tamPantalla.width;
    }
    
}
