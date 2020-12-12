
package practicando;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Practicando {
    
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public static void main(String[] args) {
        /* Crear y mostrar el GUI de la app */
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
           public void run(){
               createAndShowGUI();
           } 
        });
    }
    
    public static void addComponentsToPane(Container pane){
        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        if(shouldFill){
            c.fill=GridBagConstraints.HORIZONTAL;
        }
        
        button = new JButton("Crear");
        if(shouldWeightX){
            c.weightx=0.5;
        }
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=0;
        pane.add(button, c);
        
        button = new JButton("Agregar");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=0;
        pane.add(button, c);
        
        button = new JButton("Eliminar");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.gridx=2;
        c.gridy=0;
        pane.add(button, c);
        
        button = new JButton("Modificar archivo");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=40;  /* <-- Esto hace que el componente sea más alto */
        c.weightx=0.0;
        c.gridwidth=3;
        c.gridx=0;
        c.gridy=1;
        pane.add(button, c);
        
        button = new JButton("Cerrar programa");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=0; /* Esto resetea la "altura" adicional que se da al componente */
        c.weighty=1.0;  /* Solicita espacio extra verticalmente */
        c.anchor=GridBagConstraints.PAGE_END;
        c.insets=new Insets(10,0,0,0);
        c.gridx=1; /* Así queda alineado con el botón 2, los dos botones empiezan desde la misma posición X */
        c.gridwidth=2;  /* Le da dos columnas de ancho */ 
        c.gridy=2;  /* Coloca el botón en la tercera fila */
        pane.add(button, c);
    }
    
    private static void createAndShowGUI(){
        /* Esta parte crea y prepara la ventana */
        JFrame frame=new JFrame("Practicando");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Configurar el panel */
        addComponentsToPane(frame.getContentPane());
        
        /* Mostrar la ventana */
        frame.pack();
        frame.setVisible(true);
    }
    
    public void llamar(){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
           public void run(){
               createAndShowGUI();
           } 
        });
    }
}
