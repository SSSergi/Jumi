package sockets;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextArea;


public class Cliente {
    
    public static void main(String[] args) {
        
        MarcoCliente marco = new MarcoCliente();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoCliente extends JFrame{
    
    public MarcoCliente(){
        
        setBounds(404,0,300,300);
        
        LaminaMarcoCliente lamina = new LaminaMarcoCliente();
        
        add(lamina);
        
        setVisible(true);
    }
}


class LaminaMarcoCliente extends JPanel{
    
    public LaminaMarcoCliente(){
        
        JLabel texto = new JLabel("***--CHAT--***");
        
        add(texto);
        
        campochat = new JTextArea(12,20);
        
        add(campochat);
        
        campo1 = new JTextField(20);
        
        add(campo1);
        
        enviar = new JButton("Enviar");
        
        EnviaTexto mievento = new EnviaTexto();
        
        enviar.addActionListener(mievento);
        
        add(enviar);
    }
    
    private class EnviaTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ev) {
            
            try {

                Socket misocket = new Socket("192.168.56.1",9999);
                
                DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                
                flujo_salida.writeUTF(campo1.getText());
                
                flujo_salida.close();
                
            } catch (IOException ex) {
                
                System.out.println(ex.getMessage());
            }
        }
        
        
    }
    
    private JTextField campo1;
    
    private JTextArea campochat;
    
    private JButton enviar;
}