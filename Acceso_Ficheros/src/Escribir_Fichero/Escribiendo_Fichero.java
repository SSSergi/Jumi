package Escribir_Fichero;

import java.io.*;

public class Escribiendo_Fichero {
    
    public static void main(String[] args) {
        
        Escribiendo es = new Escribiendo();
        
        es.escribir();
    }
}


class Escribiendo{
    
    public void escribir(){
        
        String frase = "Agarrame el badajo, el que tengo aquí colgado.  ";
        
        try {
            
            FileWriter escritura = new FileWriter("C:/Users/Usuario/Desktop/escriturakun.txt");
            
            for(int i = 0; i < frase.length(); i++) {
                
                escritura.write(frase.charAt(i));
                
            }
            
            escritura.close();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }
    }
}