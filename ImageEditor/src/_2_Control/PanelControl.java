package _2_Control;


import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;


public class PanelControl extends JPanel{
    
    public PanelControl(){
        
        Controlador();
        
    }
    
    
    public void Regulador(){
        
        JSlider regulador = new JSlider(0,100,50);
        
        regulador.setMajorTickSpacing(25);
        
        regulador.setMinorTickSpacing(5);
        
        regulador.setPaintTicks(true);
        
        regulador.setPaintLabels(true);
        
        regulador.setSnapToTicks(true); // "Imantar" las rayas del slider y que la aguja quede encima de ellas
        
        add(regulador);
    }
    
    public void Controlador(){
        
        setLayout(new GridBagLayout());
        
        JButton boton1 = new JButton("1");
        
        add(boton1);
        
        JButton boton2 = new JButton("2");
        
        add(boton2);
        
        JButton boton3 = new JButton("3");
        
        add(boton3);
        
        JButton boton4 = new JButton("4");
        
        add(boton4);
        
        JButton boton5 = new JButton("5");
        
        add(boton5);
        
        JButton boton6 = new JButton("6");
        
        add(boton6);
        
        JButton boton7 = new JButton("7");
        
        add(boton7);
        
        JButton boton8 = new JButton("8");
        
        add(boton8);
        
        JButton boton9 = new JButton("9");
        
        add(boton9);
        
        JButton boton10 = new JButton("10");
        
        add(boton10);
        
        JButton boton11 = new JButton("11");
        
        add(boton11);
        
        JButton boton12 = new JButton("12");
        
        add(boton12);
        
        JButton boton13 = new JButton("13");
        
        add(boton13);
        
        JButton boton14 = new JButton("14");
        
        add(boton14);
        
        JButton boton15 = new JButton("15");
        
        add(boton15);
        
        JButton boton16 = new JButton("16");
        
        add(boton16);
    }
}
