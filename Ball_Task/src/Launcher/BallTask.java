package Launcher;


import Lamina.Viewer;
import Objetos.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BallTask extends JFrame{
    
    private Viewer lamina;
    
    private ArrayList<Ball> pelotas=new ArrayList<Ball>();
    
    public static final int delay = 4;
    
    public BallTask(){
        
        setBounds(700,340,600,500);
		
	setTitle ("Rebotes");
		
	lamina=new Viewer();
		
	add(lamina, BorderLayout.CENTER);
        
	JPanel laminaBotones=new JPanel();
        
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
    }
    
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
        
	JFrame launcher=new BallTask();
		
	launcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	launcher.setVisible(true);
    }
    
    
    
    
    
    
    public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
        JButton boton=new JButton(titulo);
		
        c.add(boton);
		
        boton.addActionListener(oyente);
    }
    
    public void crear_bola(){
			
        Ball pelota=new Ball();
			
        lamina.add(pelota);
        
        Runnable r = new BallThreads(pelota, lamina);
        
        Thread t = new Thread(r);
        
        t.start();
    }
}

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
}