package PruebasThreads;

import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);
	}
}


class PelotaThreads implements Runnable{
    
    public PelotaThreads(Pelota unaPelota, Component unComponente){
        
        pelota = unaPelota;
        
        componente = unComponente;
    }
    
    public void run(){  //el método run no recibe argumentos
        
        for (int i=1; i<=3000; i++){
				
            pelota.mueve_pelota(componente.getBounds());
            
            componente.paint(componente.getGraphics());
            
            try {	
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(MarcoRebote.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private Pelota pelota;
    private Component componente;
}


//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
	
	// Mueve la pelota invirtiendo posiciÃ³n si choca con lÃ­mites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posiciÃ³n inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final double TAMX=Math.random()*(0-75)+76;
	
	private static final double TAMY=Math.random()*(0-75)+76;
	
	private double x=Math.random()*(0-1920)+1921;
	  
	private double y=Math.random()*(0-1080)+1081;
	
	private double dx=1;
	
	private double dy=1;
	
	
}
    
// LÃ¡mina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//AÃ±adimos pelota a la lÃ¡mina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lÃ¡mina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(600,300,400,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				comienza_el_juego();
			}
			
		});
		
		
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				System.exit(0);
				
			}
			
		});
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//Ponemos botones
	
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
		
	}
	
	//AÃ±ade pelota y la bota 1000 veces
	
	public void comienza_el_juego (){
						
            Pelota pelota=new Pelota();
                        
            lamina.add(pelota);
            
            Runnable r =new PelotaThreads(pelota, lamina);
            
            Thread t = new Thread(r);
            
            t.start();
	}
	private LaminaPelota lamina;
}

