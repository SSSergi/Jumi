package PrototipoModificadorImagen;

import javax.swing.*;


public class Window extends JFrame{
    
    public Window(){
        
        setTitle("Editor de imagen");
        
        setBounds(250, 250, 500, 500);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        Viewer lienzo=new Viewer();
        
        add(lienzo);
    }
    
    public static void main(String[] args) {
        
        Window w=new Window();
        
        w.setVisible(true);
        
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
