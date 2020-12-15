package pruebasGraphics;

import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class UtillidadesConFuentes {
    
    public static void main(String[] args) {
        
        String fuente=JOptionPane.showInputDialog("Introduce fuente: ");
        
        boolean estalafuente=false;
        
        String [] nombreDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        for(String nombredelafuente: nombreDeFuentes){
            
            if(nombredelafuente.equals(fuente)){
                
                estalafuente=true;
            }
        }
        
        if(estalafuente){
            
            System.out.println("Fuente instalada.");
            
        }else{
            
            System.out.println("No está instalada la fuente.");
        }
    }
}
