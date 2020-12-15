package EJ1y2;

import java.util.*;

public class EJ1y2 {
    
    /* actualizar vector -> matriz */
    private int posicionVector;
    private int valorNuevoVector;
    /* actualizar matriz -> vector */
    private int[][] posicionMatriz;
    private int valorNuevoMatriz;
    /* --------------------------- */
    private int[][] A;
    private int[] Vector;
    private boolean validado;
    
    public static void main(String[] args) {
        EJ1y2 ej2 = new EJ1y2();
        ej2.menu();
    }
    
    
/*----------------------------------------------------------------------------*/

    public void menu(){
        int SioNo=0;
        EJ1y2 ej2 = new EJ1y2();
        Scanner sc=new Scanner(System.in);
        int op=0;
        System.out.println("Elige la operación que quieres realizar:");
        System.out.println("1.- Pasar matriz a vector.");
        System.out.println("2.- Pasar vector a matriz.");
        op= sc.nextInt();
        if(op==1){
            ej2.A=llenarMatriz(pedirMatriz());
            ej2.Vector=matrizToVector(ej2.A);
            ej2.mostrarMatriz(ej2.A);
            ej2.mostrarVector(ej2.Vector);
        }else if(op==2){
            ej2.A=pedirMatriz();
            ej2.Vector=llenarVector(pedirVector());
            ej2.validado=validarMatconVec(ej2.Vector, ej2.A);
            if(ej2.validado){
                ej2.VectorToMatriz(ej2.Vector, ej2.A);
                ej2.mostrarVector(ej2.Vector);
                ej2.mostrarMatriz(ej2.A);
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
                ej2.posicionMatriz=pedirPosicionMatriz(ej2.A);
                ej2.posicionVector=convertirPosicionMatrizEnPosicionVector(ej2.A, ej2.posicionMatriz);
                if(ej2.posicionVector>=0 && ej2.posicionVector<ej2.Vector.length){
                    ej2.valorNuevoMatriz=pedirNuevoValorMatriz();
                    ej2.valorNuevoVector=ej2.valorNuevoMatriz;
                    ej2.A=actualizarMatriz(ej2.posicionMatriz, ej2.A, ej2.valorNuevoMatriz);
                    ej2.Vector=ej2.actualizarVectorDesdeMatriz(ej2.Vector, ej2.valorNuevoVector, ej2.posicionVector);
                    System.out.println("/********************/");
                    ej2.mostrarMatriz(ej2.A);
                    System.out.println("/********************/");
                    ej2.mostrarVector(ej2.Vector);
                }else{
                    System.out.println("Valores introducidos mayores que las propias dimensiones de la matriz.");
                }
                
            }else if(op==2){
                ej2.posicionVector=pedirPosicionVector(ej2.Vector);
                if(ej2.posicionVector>=0 && ej2.posicionVector<=ej2.Vector.length){
                    ej2.valorNuevoVector=pedirNuevoValorVector();
                    ej2.valorNuevoMatriz=ej2.valorNuevoVector;
                    ej2.Vector=actualizarVector(ej2.Vector, ej2.valorNuevoVector, ej2.posicionVector);
                    ej2.A=ej2.actualizarMatrizDesdeVector(ej2.A, ej2.valorNuevoMatriz, ej2.posicionVector);
                    System.out.println("/***********************************/");
                    ej2.mostrarMatriz(ej2.A);
                    System.out.println("/***********************************/");
                    ej2.mostrarVector(ej2.Vector);
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

/*********--------------------  MATRIZ TO VECTOR  --------------------**********/    
    public int[][] pedirMatriz(){
        int mvacia[][];
        int fil;
        int col;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número de filas:");
        fil=sc.nextInt();
        System.out.println("Introduce el número de columnas:");
        col=sc.nextInt();
        mvacia=new int[fil][col];
        return mvacia;
    }
    
    public int[][] llenarMatriz(int[][] m){
        int Mllena[][];
        Mllena = new int[m.length][m[0].length];
        for (int i=0; i < m.length; i++){
            for (int j=0; j < m[i].length; j++){
                Random ran = new Random();
                int k=ran.nextInt(101);
                Mllena[i][j]=k;
            }
        }
        return Mllena;
    }
    
    public int[] matrizToVector(int[][] m){
        int[] v=new int[m.length*m[0].length];
        int index=0;
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[0].length; j++){
                int k=m[i][j];
                v[index]=k;
                index+=1;
            }
        }
        return v;
    }
    
    public void mostrarVector(int[] v){
        System.out.print("Vector content: ");
        for(int i=0; i<v.length; i++){
            System.out.print(v[i]);
            System.out.print(" ");
        }
        System.out.println(" ");
    }
     
    public void mostrarMatriz(int[][] m){
        for (int i=0; i < m.length; i++){
            for (int j=0; j < m[i].length; j++){
                System.out.print(m[i][j]);
                System.out.print(" ");
            }
            if (i!=m.length-1) System.out.print("\t");
                System.out.println(" ");
        }
    }
    
/*********--------------------  MATRIZ TO VECTOR  --------------------**********/ 
    
/*********--------------------  VECTOR TO MATRIZ  --------------------**********/    

    public int[] pedirVector(){
        int t;
        int[] v;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tamaño del vector:");
        t=sc.nextInt();
        v=new int[t];
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
    
    public boolean validarMatconVec(int[] v, int[][] m){
        boolean val=true;
        int FxC=m.length*m[0].length;
        if(v.length!=FxC){
            val=false;
        }
        return val;
    }
    
    public int[][] VectorToMatriz(int[] v, int[][] m){
        int indice=0;
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                m[i][j]=v[indice];
                indice+=1;
            }
        }
        return m;
    }
    
/*********--------------------  VECTOR TO MATRIZ  --------------------**********/
    
/*********--------------------  ALTERAR POSICIÓN MATRIZ A VECTOR  --------------------**********/
    
    public int[][] pedirPosicionMatriz(int[][] m){
        int[][] pos;
        int fil;
        int col;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce la posición de la casilla que quieres actualizar dentro matriz:");
        System.out.println("Fila:");
        fil=sc.nextInt();
        System.out.println("Columna:");
        col=sc.nextInt();
        pos=new int[fil][col];
        return pos;
    }
    
    public int pedirNuevoValorMatriz(){
        int newvalue;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el nuevo valor que quieres introducir en la posición seleccionada:");
        newvalue=sc.nextInt();
        return newvalue;
    }
    
    public int[][] actualizarMatriz(int[][] p, int[][] m, int newvalue){
        int[][] update;
        m[p.length][p[0].length]=newvalue;
        return m;
    }
    
    public int convertirPosicionMatrizEnPosicionVector( int[][] m, int[][] p){
        int posVector;
        posVector=(((p.length) * m[0].length) + p[0].length);
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
    
    public int[][] actualizarMatrizDesdeVector(int[][] matriz, int nvalue, int posicion){
        int filas;
        int columnas;
        filas=posicion/matriz[0].length;
        columnas=posicion%matriz[0].length;
        matriz[filas][columnas]=nvalue;
        return matriz;
    }
    
/*********--------------------  ALTERAR POSICIÓN VECTOR A MATRIZ  --------------------**********/

}