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
import java.util.logging.Level;
import java.util.logging.Logger;



public class Cliente {
    
    public static void main(String[] args) {
        
        MarcoCliente marco = new MarcoCliente();
        
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoCliente extends JFrame{
    
    public MarcoCliente(){
        
        setBounds(404,0,1080,1080);
        
        LaminaMarcoCliente lamina = new LaminaMarcoCliente();
        
        add(lamina);
        
        setVisible(true);
    }
}


class LaminaMarcoCliente extends JPanel{
    
    public LaminaMarcoCliente(){
        
        JLabel texto = new JLabel("Cliente");
        
        add(texto);
        
        campo1 = new JTextField(20);
        
        add(campo1);
        
        JButton enviar = new JButton("Enviar");
        
        EnviaTexto mievento = new EnviaTexto();
        
        enviar.addActionListener(mievento);
        
        add(enviar);
    }
    
    private class EnviaTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ev) {
            
            //System.err.println(campo1.getText());
            
            try {

                Socket misocket = new Socket("192.168.1.118",9999);
                
                DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
                
                flujo_salida.writeUTF(campo1.getText());
                
                flujo_salida.close();
                
            } catch (IOException ex) {
                
                System.out.println(ex.getMessage());
            }
        }
        
        
    }
    
    private JTextField campo1;
}