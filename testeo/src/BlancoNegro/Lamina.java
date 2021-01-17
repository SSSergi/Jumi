package BlancoNegro;


import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.Arrays;

import javax.imageio.*;
import javax.swing.*;

public class Lamina extends JPanel{
    
    private static BufferedImage bi;
    private static int[] imagenOriginal;
    private static int[] imagenCopia;
    private static byte[] bytes;
    private static int kernelIndex; 
    private static final int[][] kernel = {{-1, -1, -1}, {0, 0, 0}, {1, 1, 1}}; // Definicion encontrada de KERNEL: es un filtro, para extraer datos de caracteristicas que queramos de una imagen
                                                                                // que por lo general tiene este aspecto:
                                                                                // Forma vector={{-1,-1,-1},{0,0,0},{1,1,1}}    Forma Matriz:  | -1 | 0 | 1 |                |-1 |-1 |-1 |       
                                                                                //                                                Vertical     | -1 | 0 | 1 |   Horizontal   | 0 | 0 | 0 |
                                                                                //                                                             | -1 | 0 | 1 |                | 1 | 1 | 1 |                                                                                                                                                                                        

    
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        leerImagen();
        
        imagenData();
        
        kernelIndex();
        
        boolean alpha=bi.isAlphaPremultiplied(); //Comprobar si la imagen tiene Alpha
        
        System.err.println("Alphaa"+ alpha);
        
        g.drawImage(bi, 5, 5, null);
        
        if(!alpha){
            
            elegirPixel();
            
            g.drawImage(crearImagen(), bi.getWidth() + 44, 5, null);
            
        }else{
            
            System.err.println("Tiene alpha.");
        }
    }
    
    
    public static void leerImagen(){
        
        try{
            
            bi=ImageIO.read(new File("src\\BibliotecaImagenes\\subnautica.jpg"));
            
        }catch(IOException e){
            
            System.err.println("No se encuentra la imagen.");
        }
    }
    
    
    public static void imagenData(){
        
        Raster raster=bi.getRaster(); //Obtenemos el Raster de la imagen que hay en la variable "bi", o lo que es lo mismo, obtenemos una matriz de los pixeles que componen la imagen
        
        DataBufferByte bancoDatos=(DataBufferByte) raster.getDataBuffer();
        
        bytes=bancoDatos.getData();
        
        imagenOriginal=new int [bytes.length];
                                                // Le damos tamaño a los vectores de la imagen original y la copia, usando la longitud del array/vector bytes, y pasamos los de vector de bytes a vector de int
        imagenCopia=new int [bytes.length];
        
       for(int i=0; i<bytes.length;i++){
           
           imagenOriginal[i]=Byte.toUnsignedInt(bytes[i]);
       } 
    }
    
    
    public static void kernelIndex(){
        
        for(int i=0; i < kernel.length; i++){
            
            for(int j=0; j < kernel.length; j++){
                
                kernelIndex=kernelIndex + kernel[i][j];
            }
        }
        
        if(kernelIndex==0){
            kernelIndex=1;
        }
    }
    
    
    public static void elegirPixel(){
        
        for(int i=1; i<bi.getHeight()-1; i++){
            
            for(int j=1; j<bi.getWidth()-1; j++){
                
                for(int k=0; k<3; k++){
                    
                    convertirPixelEnVector(i,j,k);
                }
            }
        }
    }
    
    
    public static BufferedImage crearImagen(){
        
        BufferedImage mbi=new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        
        Raster raster = mbi.getRaster();
        
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        
        byte newBytes[] = data.getData();
        
        for(int i=0; i < newBytes.length; i++){
            
            newBytes[i]=(byte) imagenCopia[i];
        }
        
        return mbi;
    }
    
    
    public static void convertirPixelEnVector(int i, int j, int k){
        
        int pVectorEnd=(3 * bi.getWidth() * i) + (3 * j) + k;
        
        for(int l=0; l < kernel.length; l++){
            
            for(int m=0; m < kernel[l].length; m++){
                
                int pVectorStart=(3 * bi.getWidth() * (i - 1 + l)) + (3 *(j - 1 + m)) + k;
                
                imagenCopia[pVectorEnd] += imagenOriginal[pVectorStart] * kernel[l][m];
            }
        }
        
        imagenCopia[pVectorEnd]=imagenCopia[pVectorEnd]/kernelIndex;
        
        imagenCopia[pVectorEnd]=verificar255(imagenCopia[pVectorEnd]);
    }
    
    
    public static int verificar255(int x){
        
        if(x > 255){
            
            x=255;
            
        }else if(x<0){
            
            x=0;
            
        }
        
        return x;
    }
}