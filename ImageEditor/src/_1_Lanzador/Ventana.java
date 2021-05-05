package _1_Lanzador;


import _2_Control.PanelControl;
import javax.swing.JFrame;



public class Ventana extends JFrame{
    
    private final int vWidth=960;
    private final int vHeigth=540;
    
    
    public Ventana(){
        
        PanelControl PanCon = new PanelControl();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setVisible(true);
        
        add(PanCon);
    }
    
    
    public static void main(String[] args) {
        Ventana v = new Ventana();
    }
}
