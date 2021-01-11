package BlancoNegro;

import javax.swing.*;


public class Ventana extends JFrame{
    
    public Ventana(){
        
        setTitle("Modificación imagen a Blanco y Negro");
        
        setBounds(0, 0, 1920, 1080);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        Lamina lamina=new Lamina();
        
        add(lamina);
    }
}
