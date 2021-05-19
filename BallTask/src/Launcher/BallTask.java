package Launcher;


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
    
    public void createFrame(){
        
        //Container panel;
        
        setTitle("Balls and holes");
        
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