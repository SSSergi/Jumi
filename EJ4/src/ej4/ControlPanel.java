 package ej4;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ControlPanel extends JPanel{

    private Viewer viewer;
    
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public ControlPanel(Viewer viewer){
        Container container=new Container();
        this.setLayout(new GridBagLayout());
        this.viewer=viewer;
        this.addComponentsToPane(container);
    }
    
    
    public void addComponentsToPane(Container pane){
        
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c=new GridBagConstraints();
        pane.setLocation(0,0);
        if(shouldFill){
            c.fill=GridBagConstraints.HORIZONTAL;
        }
        
        
        JButton b1=new JButton("Botón 1");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
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
        
        JButton b10=new JButton("Botón 10");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=3;
        pane.add(b10, c);
        
        JButton b11=new JButton("Botón 11");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=1;
        c.gridy=3;
        pane.add(b11, c);
        
        JButton b12=new JButton("Botón 12");
        c.fill=GridBagConstraints.HORIZONTAL;
        c.ipady=15;
        c.weightx=0.0;
        c.gridwidth=1;
        c.gridx=2;
        c.gridy=3;
        pane.add(b12, c);
    }
}
