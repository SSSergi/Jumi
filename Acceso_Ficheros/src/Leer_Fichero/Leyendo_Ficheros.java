package Leer_Fichero;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Leyendo_Ficheros {
    
    public static void main(String[] args) {
        
        Leer_Fichero lf = new Leer_Fichero();
        
        lf.lee();
    }    
}

class Leer_Fichero{
    
    public void lee(){
        
        try {
            
            archivo = new FileReader("C:/Users/Usuario/Desktop/ejemplokun.txt");
            
            BufferedReader mibuffer = new BufferedReader(archivo);
            
            //int c = 0; Para la parte que queríamos ir CARÁCTER a CARÁCTER
            
            String linea = "";
            
            while(linea != null){
                
                //c = archivo.read();  Este de quí y el de abajo se usan para leer CARÁCTER a CARÁCTER
                
                //char letra = (char)c;
                
                linea = mibuffer.readLine();
                
                if(linea != null){
                    
                    System.out.println(linea);
                }
            }
            
            //archivo.close();
            
        } catch (IOException e) {
            System.out.println("No se encotró el archivo");
        }finally{
            
            try {
                
                archivo.close();
                
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }
    }
    
    FileReader archivo;
    
    
}