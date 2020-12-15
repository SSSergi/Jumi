
package ej3;

import java.util.Scanner;
import java.util.Random;

public class EJ3 {
    
    /* actualizar vector -> matriz */
    private int posicionVector;
    private int valorNuevoVector;
    /* actualizar matriz -> vector */
    private int[][][] posicionMatriz;
    private int valorNuevoMatriz;
    /* --------------------------- */
    private int[][][] M;
    private int[] Vector;
    private boolean validacion;
    

    public static void main(String[] args) {
        EJ3 ej3=new EJ3();
        ej3.menu();
    }
    
    public void menu(){
        int SioNo=0;
        EJ3 ej3 = new EJ3();
        Scanner sc=new Scanner(System.in);
        int op=0;
        System.out.println("*---------------------------------------*");
        System.out.println("|  **** MATRICES TRIDIMENSIONALES ****  |");
        System.out.println("*---------------------------------------*");
        System.out.println("  ");
        System.out.println("Elige la operación que quieres realizar:");
        System.out.println("1.- Pasar matriz a vector.");
        System.out.println("2.- Pasar vector a matriz.");
        op= sc.nextInt();
        if(op==1){
            ej3.M=llenarMatriz(pedirMatriz());
            ej3.Vector=matrizToVector(ej3.M);
            ej3.mostrarMatriz(ej3.M);
            ej3.mostrarVector(ej3.Vector);
        }else if(op==2){
            ej3.M=pedirMatriz();
            ej3.Vector=llenarVector(pedirVector());
            ej3.validarMatConVec(ej3.Vector, ej3.M);
            if(ej3.validacion){
                ej3.M=vectorToMatriz(ej3.Vector, ej3.M);
                ej3.mostrarMatriz(ej3.M);
                ej3.mostrarVector(ej3.Vector);
            }else{
                System.out.println("Dimensiones de la matriz y tamaño del vector incompatibles.");
            }
        }
        System.out.println("Te gustaría ajustar alguna matriz o vector?");
        System.out.println("1.- Sí.");
        System.out.println("2.- No.");
        SioNo=sc.nextInt();
        if(SioNo==1){
            System.out.println("Elige la manera a proceder:");
            System.out.println("1.- Actualizar posiciones de la matriz, y pasarlas a su vector.");
            System.out.println("2.- Actualizar posiciones del vector, y pasarlas a su matriz.");
            op=sc.nextInt();
            if(op==1){
                ej3.posicionMatriz=pedirPosicionMatriz(ej3.M);
                ej3.posicionVector=convertirPosicionMatrizEnPosicionVector(ej3.M, ej3.posicionMatriz);
                if(ej3.posicionVector>=0 && ej3.posicionVector<ej3.Vector.length){
                    ej3.valorNuevoMatriz=pedirNuevoValorMatriz();
                    ej3.valorNuevoVector=ej3.valorNuevoMatriz;
                    ej3.M=actualizarMatriz(ej3.posicionMatriz, ej3.M, ej3.valorNuevoMatriz);
                    ej3.Vector=ej3.actualizarVectorDesdeMatriz(ej3.Vector, ej3.valorNuevoVector, ej3.posicionVector);
                    System.out.println("/********************/");
                    ej3.mostrarMatriz(ej3.M);
                    System.out.println("/********************/");
                    ej3.mostrarVector(ej3.Vector);
                }else{
                    System.out.println("Valores introducidos mayores que las propias dimensiones de la matriz.");
                }
            }else if(op==2){
                ej3.posicionVector=pedirPosicionVector(ej3.Vector);
                if(ej3.posicionVector>=0 && ej3.posicionVector<=ej3.Vector.length){
                    ej3.valorNuevoVector=pedirNuevoValorVector();
                    ej3.valorNuevoMatriz=ej3.valorNuevoVector;
                    ej3.Vector=actualizarVector(ej3.Vector, ej3.valorNuevoVector, ej3.posicionVector);
                    ej3.M=ej3.actualizarMatrizDesdeVector(ej3.M, ej3.valorNuevoMatriz, ej3.posicionVector);
                    System.out.println("/***********************************/");
                    ej3.mostrarMatriz(ej3.M);
                    System.out.println("/***********************************/");
                    ej3.mostrarVector(ej3.Vector);
                }else{
                    System.out.println("El valor introducido no és válido o excede el tamaño máximo del vector.");
                }
            }else{
                System.out.println("Valor introducido incorrecto.");
            }
        }else if(SioNo==2){
            System.out.println("Que tengas un buen día, nigga.");
        }else{
            System.out.println("Valor introducido incorrecto.");
        }
    }
    
    
/*********--------------------  METODOS MOSTRAR  --------------------**********/
    
    public void mostrarVector(int[] v){
        System.out.print("Vector content: ");
        for(int i=0; i<v.length; i++){
            System.out.print(v[i]);
            System.out.print(" ");
        }
        System.out.println(" ");
    }
     
    public void mostrarMatriz(int[][][] m){
        for (int y=0; y < m.length; y++){
            for (int x=0; x < m[y].length; x++){
                System.out.print("|");
                for(int z=0; z < m[y][x].length; z++){
                    System.out.print(m[y][x][z]);
                    if(z!=m.length-1){
                        System.out.print("|");
                    }
                }
                System.out.print("|");
                if (x!=m.length-1){
                    System.out.print("  ");
                }
            }
            if (y!=m.length-1){
                System.out.print("\t");
                System.out.println(" ");
            }
        }
    }
    
/*********--------------------  METODOS MOSTRAR  --------------------**********/        

/*********--------------------  MATRIZ TO VECTOR  --------------------**********/    
    public int[][][] pedirMatriz(){
        int mvacia[][][];
        int y;
        int x;
        int z;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número para Y:");
        y=sc.nextInt();
        System.out.println("Introduce el número para X:");
        x=sc.nextInt();
        System.out.println("Introduce el número para Z:");
        z=sc.nextInt();
        mvacia=new int[y][x][z];
        return mvacia;
    }
    
    public int[][][] llenarMatriz(int[][][] m){
        for (int y=0; y < m.length; y++){
            for (int x=0; x < m[y].length; x++){
                for (int z=0; z < m[y][x].length; z++){
                    Random ran = new Random();
                    int k=ran.nextInt(101);
                    m[y][x][z]=k;
                }
            }
        }
        return m;
    }
    
    public int[] matrizToVector(int[][][] m){
        int[] v=new int[(m.length*m[0].length)*m[0][0].length];
        int index=0;
        for(int y=0; y<m.length; y++){
            for(int x=0; x<m[0].length; x++){
                for(int z=0; z < m[0][0].length; z++){
                    int k=m[y][x][z];
                    v[index]=k;
                    index+=1;
                }
            }
        }
        return v;
    }
    
/*********--------------------  MATRIZ TO VECTOR  --------------------**********/ 
    
/*********--------------------  VECTOR TO MATRIZ  --------------------**********/    

    public int[] pedirVector(){
        int tamaño;
        int[] v;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tamaño del vector:");
        tamaño=sc.nextInt();
        v=new int[tamaño];
        return v;
    }

    public int[] llenarVector(int[] v){
        for (int i=0; i < v.length; i++){
            Random ran = new Random();
            int k=ran.nextInt(101);
            v[i]=k;
        }
        return v;
    }
    
    public boolean validarMatConVec(int[] v, int[][][] m){
        boolean val=true;
        int YXZ=m.length*m[0].length*m[0][0].length;
        if(v.length!=YXZ){
            val=false;
        }
        return val;
    }
    
    public int[][][] vectorToMatriz(int[] v, int[][][] m){
        int indice=0;
        for(int y=0; y < m.length; y++){
            for(int x=0; x < m[0].length; x++){
                for(int z=0; z < m[0][0].length; z++){
                    m[y][x][z]=v[indice];
                    indice+=1;
                }
            }
        }
        return m;
    }
    
/*********--------------------  VECTOR TO MATRIZ  --------------------**********/
   
/*********--------------------  ALTERAR POSICIÓN MATRIZ A VECTOR  --------------------**********/
    
    public int[][][] pedirPosicionMatriz(int[][][] m){
        int[][][] pos;
        int y;
        int x;
        int z;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la posición de la casilla que quieres actualizar dentro matriz:");
        System.out.println("Y:");
        y=sc.nextInt();
        System.out.println("X:");
        x=sc.nextInt();
        System.out.println("Z:");
        z=sc.nextInt();
        pos=new int[y][x][z];
        return pos;
    }
    
    public int pedirNuevoValorMatriz(){
        int newvalue;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el nuevo valor que quieres introducir en la posición seleccionada:");
        newvalue=sc.nextInt();
        return newvalue;
    }
    
    public int[][][] actualizarMatriz(int[][][] p, int[][][] m, int newvalue){
        int[][][] update;
        m[p.length][p[0].length][p[0][0].length]=newvalue;
        return m;
    }
    
    public int convertirPosicionMatrizEnPosicionVector( int[][][] m, int[][][] p){
        int posVector;
        posVector=((p.length * m[0].length * m[0][0].length) + ((p[0].length * m[0][0].length)+p[0][0].length));
        return posVector;
    }    

    public int[] actualizarVectorDesdeMatriz(int[] vector, int newvalue, int posicion){
        vector[posicion]=newvalue;
        return vector;
    }
/*********--------------------  ALTERAR POSICIÓN MATRIZ A VECTOR  --------------------**********/
    
/*********--------------------  ALTERAR POSICIÓN VECTOR A MATRIZ  --------------------**********/
    public int pedirPosicionVector(int[] v){
        int pos=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la posición del vector que quieres actualizar:");
        pos=sc.nextInt();
        return pos;
    }
    
    public int pedirNuevoValorVector(){
        int num=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nuevo valor que quieres introducir en la posición deseada:");
        num=sc.nextInt();
        return num;
    }
    
    public int[] actualizarVector(int[] vector, int nvalue, int posicion){
        vector[posicion]=nvalue;
        return vector;
    }
    
    public int[][][] actualizarMatrizDesdeVector(int[][][] matriz, int nvalue, int posicion){
        int Y;
        int X;
        int Z;
        Y=posicion/matriz[0].length;
        Y=Y/matriz[0].length;
        X=posicion/matriz[0].length;
        X=X%matriz[0].length;
        Z=posicion%matriz[0].length;
        matriz[Y][X][Z]=nvalue;
        return matriz;
    }
    
/*********--------------------  ALTERAR POSICIÓN VECTOR A MATRIZ  --------------------**********/

}