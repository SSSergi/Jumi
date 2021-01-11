package BlancoNegro;


import javax.swing.JFrame;



public class Launcher{
    
    public static void main(String[] args) {
        
        Ventana frame=new Ventana();
        
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

