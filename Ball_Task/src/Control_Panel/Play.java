package Control_Panel;


import Lamina.Viewer;
import Launcher.Lanzador;
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
				
                Lanzador lanzador = new Lanzador();
                
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
