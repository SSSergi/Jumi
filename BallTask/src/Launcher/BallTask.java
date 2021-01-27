package Launcher;


import Lamina.Viewer;
import PanelControl.ControlPanel;
import Lamina.Viewer;
import java.awt.Frame;
import java.awt.*;
import javax.swing.JFrame;

public class BallTask extends JFrame{
    
    private PanelControl.ControlPanel controlPanel;
    private Lamina.Viewer viewer;
    private Objetos.Ball ball;
    private Thread viewerThread;
    
    public static void main(String[] args) {
        
        BallTask bt=new BallTask();
        
        bt=new BallTask();
        
        bt.setVisible(true);
    }
    
    public BallTask(){
        
    }
    
    public void addViewerToPane(Container panel){
        
        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1F;
        c.weighty = 0;
        c.gridheight = 10;
        c.gridwidth = 8;
        panel.add(this.viewer, c);
    }
    
    public void createFrame(){
        
        Container panel;
        
        setTitle("Balls and holes");    
        
        this.setLayout(new GridBagLayout());
        
        panel=this.getContentPane();
        
        this.addViewerToPane(panel);
        
        this.setVisible(true);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setBounds(0, 0, 800, 600);
        
        setExtendedState(Frame.MAXIMIZED_BOTH);
    }
    
    public void comienza_el_juego (){
						
        ball=new Objetos.Ball();
                        
        viewer.add(ball);
            
        Runnable r =new Viewer(ball, viewer);
            
        Thread t = new Thread(r);
            
        t.start();
    }
}
