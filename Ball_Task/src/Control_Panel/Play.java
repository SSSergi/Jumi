package Control_Panel;


import Lamina.Viewer;
import Launcher.BallTask;
import Objetos.Ball;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;



public class Play extends JPanel{
    
    public Play(){
        
        JPanel laminaBotones = new JPanel();
        
        ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
            public void actionPerformed(ActionEvent evento){
				
                BallTask lanzador = new BallTask();
                
                lanzador.crear_bola();
            }
	});
    }
    
    
    public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
        JButton boton=new JButton(titulo);
		
        c.add(boton);
		
        boton.addActionListener(oyente);
    }
}
