package sockets;

import java.awt.BorderLayout;
import java.io.*;
import java.net.ServerSocket;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Servidor {
    
    public static void main(String[] args) {
        
        MarcoServidor server = new MarcoServidor();
        
        server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoServidor extends JFrame implements Runnable{
    
    public MarcoServidor(){
        
        setBounds(404,0,1080,1080);
        
        JPanel server_lamina = new JPanel();
        
        server_lamina.setLayout(new BorderLayout());
        
        areaTexto = new JTextArea();
        
        server_lamina.add(areaTexto, BorderLayout.CENTER);
        
        add(server_lamina);
        
        setVisible(true);
        
        Thread mihilo = new Thread(this);
        
        mihilo.start();
    }
    
    private JTextArea areaTexto;

    @Override
    public void run() {
        
        try {
            
            ServerSocket servidor = new ServerSocket(9999);
            
            Socket misocket = servidor.accept();
            
            DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
            
            String mensaje_texto = flujo_entrada.readUTF();
            
            areaTexto.append("/n" + mensaje_texto);
            
            misocket.close();
            
        } catch (IOException ex) {
            
            ex.printStackTrace();
        }
    }
}
