package Launcher;


import Lamina.Viewer;
import PanelControl.ControlPanel;
import Lamina.Viewer;
import Objetos.Ball;
import java.awt.Frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallTask extends JFrame{
    
    private PanelControl.ControlPanel controlPanel;
    private Objetos.Ball ball;
    private Lamina.Viewer lamina;
    private Thread viewerThread;
    
    public static void main(String[] args) {
        
        BallTask bt=new BallTask();
        
        bt=new BallTask();
        
        bt.setVisible(true);
    }
    
    public BallTask(){
        
        createFrame();                
        
        JPanel laminaBotones=new JPanel();
        
        ponerBoton(laminaBotones, "Pulsar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                comienza_el_juego();
            }
        });
        
        ponerBoton(laminaBotones, "Salir", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                System.exit(0);
            }
        });
        
        add(laminaBotones, BorderLayout.SOUTH);
    }
    /*
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
    }*/
    
    public void createFrame(){
        
        //Container panel;
        
        setTitle("Balls and holes");    
        
        //this.setLayout(new GridBagLayout());
        
        //panel=this.getContentPane();
        
        //this.addViewerToPane(panel);
        
        this.setVisible(true);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setBounds(0, 0, 800, 600);
        
        setExtendedState(Frame.MAXIMIZED_BOTH);
        
        lamina = new Viewer();
        
        add(lamina, BorderLayout.CENTER);
    }
    
    public void ponerBoton(Container c, String nboton, ActionListener listener){
        
        JButton boton = new JButton(nboton);
        
        c.add(boton);
        
        boton.addActionListener(listener);
    }
    
    public void comienza_el_juego (){
						
        ball=new Objetos.Ball();
                        
        lamina.add(ball);
            
        Runnable r1 =new Viewer();
        
        Runnable r2 = new Ball();
            
        Thread t1 = new Thread(r1);
        
        Thread t2 = new Thread(r2);
            
        t1.start();
        
        t2.start();              
    }
}