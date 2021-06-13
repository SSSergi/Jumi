package Launcher;


import Lamina.Viewer;
import Objetos.Ball;
import Objetos.BlackHoles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BallTask extends JFrame{
    
    private Viewer viewer;
    
    private ArrayList<Ball> pelotas =new ArrayList<>();
    
    private ArrayList<BlackHoles> agujeros = new ArrayList<>();
    
    public static final int delay = 4;
    
    private Ball pelota;
    
    private Component componente;
    
    public BallTask(){
        
        setTitle ("Rebotes");
        
        this.agujeros.add(new BlackHoles());
        
        this.agujeros.add(new BlackHoles());
	
	this.viewer = new Viewer(pelotas, agujeros, pelota, componente);
        
        Ball.balltask = this;
        
        this.createFrame();
        
        this.setResizable(true);
    }
    
    
    public static void main(String[] args) {
        
	JFrame balltask = new BallTask();
        
	balltask.setVisible(true);
    }
    
    
    public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
        JButton boton=new JButton(titulo);
		
        c.add(boton);
		
        boton.addActionListener(oyente);
    }
    
    public void crear_bola(){
			
        Ball pelota=new Ball();
			
        viewer.add(pelota);
        
        Runnable r = new Viewer(pelotas, agujeros, pelota, viewer);
        
        Thread t = new Thread(r);
        
        t.start();
    }
    
    /* CREAR EL FRAME */
    private void createFrame() {
        
        JPanel laminaBotones=new JPanel();
        
        setBounds(100,0,900,900);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        
        crear_bola();
        
        ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
            public void actionPerformed(ActionEvent evento){
                
                crear_bola();
            }
	});
      
        ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
            public void actionPerformed(ActionEvent evento){
				
                System.exit(0);			
            }		
	});
		
	add(laminaBotones, BorderLayout.SOUTH);
        
        this.add(this.viewer, BorderLayout.CENTER);
    }
}


/*
class BallThreads implements Runnable{
    
    public BallThreads(Ball unaPelota, Component unComponente){
        
        pelota = unaPelota;
        
        componente = unComponente;
    }
    
    public void run(){
        
        while(true){
				
            pelota.mueve_pelota(componente.getBounds());
				
            componente.paint(componente.getGraphics());
            
            try {
                
                Thread.sleep(4);
                
            } catch (InterruptedException ex) {
                
                System.err.println("Algo falla");
            }
        }
    }
    
    private Ball pelota;
    
    private Component componente;
}*/