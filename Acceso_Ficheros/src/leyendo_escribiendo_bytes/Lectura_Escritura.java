package leyendo_escribiendo_bytes;

import java.io.*;

public class Lectura_Escritura {
    
    public static void main(String[] args) {
        
        int contador = 0;

        int datos_entrada[] = new int[16832330];

        try {

            FileInputStream archivo_lectura = new FileInputStream("C:\\Users\\Usuario\\Pictures\\PROYECTO TEMAS\\proyectoJhin.png");

            BufferedInputStream mbuffInStream = new BufferedInputStream(archivo_lectura);

            boolean final_ar = false;

            while(!final_ar){

                int byte_entrada = mbuffInStream.read(); // RECUERDA** El método -read- lee BYTE a BYTE el archivo, o File, que le pasamos.

                if(byte_entrada != -1){

                    datos_entrada[contador]=byte_entrada;

                }else{

                    final_ar = true;
                }

                System.out.println(datos_entrada[contador]);

                contador++;
            }

            archivo_lectura.close();

        } catch (IOException e) {
            
            System.out.println("No se puede acceder a la imagen.");
        }
        
        System.out.println(contador);
        
        crea_fichero(datos_entrada);
    }
    
    static void crea_fichero(int datos_nuevo_fichero[]){
        
        try {
            
            FileOutputStream fichero_nuevo = new FileOutputStream("C:\\Users\\Usuario\\Pictures\\PROYECTO TEMAS\\proyectoJhin_copia.png");
            
            for (int i = 0; i < datos_nuevo_fichero.length; i++) {
                
                fichero_nuevo.write(datos_nuevo_fichero[i]);
                
            }
            
            fichero_nuevo.close();
            
        } catch (Exception e) {
            
            System.out.println("Error al crear el archivo.");
        }
    }
}
