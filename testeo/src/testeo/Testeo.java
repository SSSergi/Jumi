
package testeo;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Testeo extends Canvas{
    
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    public String img="jhinoc.png";

    public static void main(String[] args) {
        llamar();
    }
    
    public static void hacercanvas(Container c){
        try{
        BufferedImage img=ImageIO.read(new File("C:/MultiPlatCurso2/2.Prgoramacion Jumi/EJ4/src/imagenes/jhinoc.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
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
    
    public static void llamar(){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
           public void run(){
               createAndShowGUI();
           } 
        });
    }
    
    public static void addComponentsToPane(Container pane){
        
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        if(shouldFill){
            c.fill=GridBagConstraints.HORIZONTAL;
        }
        
        JLabel imagen1=new JLabel();
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=10;
        c.ipadx=10;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=0;
        
        JButton b1=new JButton("Botón 1");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.ipadx=70;
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=0;
        pane.add(b1, c);
        
        
        JButton b2=new JButton("Botón 2");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=1;
        c.gridy=0;
        pane.add(b2, c);
        
        
        JButton b3=new JButton("Botón 3");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=2;
        c.gridy=0;
        pane.add(b3, c);
        
        
        JButton b4=new JButton("Botón 4");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=1;
        pane.add(b4, c);
        
        
        JButton b5=new JButton("Botón 5");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=1;
        c.gridy=1;
        pane.add(b5, c);
        
        
        JButton b6=new JButton("Botón 6");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=2;
        c.gridy=1;
        pane.add(b6, c);
        
        
        JButton b7=new JButton("Botón 7");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=2;
        pane.add(b7, c);
        
        
        JButton b8=new JButton("Botón 8");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=1;
        c.gridy=2;
        pane.add(b8, c);
        
        
        JButton b9=new JButton("Botón 9");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=2;
        c.gridy=2;
        pane.add(b9, c);
    }
    
}
