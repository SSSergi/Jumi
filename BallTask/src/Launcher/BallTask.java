package Launcher;


import Lamina.Viewer;
import java.awt.Frame;
import javax.swing.JFrame;

public class BallTask extends JFrame{
    
    public static void main(String[] args) {
        
        BallTask bt=new BallTask();
        
        bt.setVisible(true);
        
        bt.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
    public BallTask(){
        
        setTitle("Ball and holes");
        
        setBounds(0, 0, 800, 600);
        
        setExtendedState(Frame.MAXIMIZED_BOTH);
        
        Viewer lamina=new Viewer();
        
        add(lamina);
    }
}
