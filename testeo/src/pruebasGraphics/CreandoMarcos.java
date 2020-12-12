package pruebasGraphics;

import java.awt.Frame;
import javax.swing.*;

public class CreandoMarcos {
    
    public static void main(String[] args) {
        
        MiMarco marco1=new MiMarco();
        
        marco1.setVisible(true);
        
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MiMarco extends JFrame{
    
    public MiMarco(){
        //setSize(444, 444);
        
        //setLocation(500, 200);
        
        // Al usar setBound, damos tanto el tamaño del ancho y la altura como
        // las coordenadas en las que queremos que aparezca la ventana.
        setBounds(500, 200, 444, 444);
        
        // setResizable se usa para impedir o permitir que el usuario puede modi-
        //ficar el tamaño de la ventana.
        //setResizable(false);
        
        // setExtendedState, maximizas el tamaño de la ventana al máximo al
        // crear la ventana.
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}