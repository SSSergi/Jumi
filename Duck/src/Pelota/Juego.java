package Pelota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Box.Filler;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Juego //simulacion
{
public static void main(String[] args) 
{
// TODO Auto-generated method stub
JFrame marco=new MarcoRebote();
//marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
marco.setVisible(true);
}
}
class Pelota
{
private float TAMX=15;//eje x elipse (en el circulo si son 

private float masa;
private float TAMY=15;//eje y elipse
private double x=0;
private double y=0;
private double dx=1;// desplazamiento en x (velocidad)
private double dy=1;// desplazamiento en y (velocidad)
Color color=Color.GREEN;
Rectangle2D limites;


public Pelota(Color color){
    this.color=color;
    x=(int)(Math.random()*200);
    y=(int)(Math.random()*200);
}

public Pelota(Color color,int diametro){

    TAMX=diametro;
    TAMY=diametro;
    masa=diametro*10;
    this.color=color;
    x=(int)(Math.random()*200);
    y=(int)(Math.random()*200);
}

public Pelota(){
    
    x=(int)(Math.random()*200);
    y=(int)(Math.random()*200);
}

// Mueve la pelota invirtiendo posición si choca con límites
public void mueve_pelota(Rectangle2D limites){
    
    this.limites=limites;
    x=dx+x;
    y=dy+y;
    if(x+TAMX>=limites.getMaxX()){
        x=limites.getMaxX() - TAMX;
        dx=-dx;
    }
    if(y + TAMY>=limites.getMaxY()){
        y=limites.getMaxY()-TAMY;
        dy=-dy;
    }
    if(x<limites.getMinX()){
        x=limites.getMinX();
        dx=-dx;
    }
    if(y<limites.getMinY()){
        y=limites.getMinY();
        dy=-dy;
    }
}

//Forma de la pelota en su posición inicial
public Ellipse2D getShape()
{
 return new Ellipse2D.Double(x,y,TAMX,TAMY);
}
    public Color getColor()
    {
        return color;
    }
    void pintar_bola(Graphics g)
    {
g.setColor(color);
//int x1 =(int)x;
     //int y1 =(int)y;
     //g.fillOval(x1,y1,TAMX,TAMY);
Graphics2D g2=(Graphics2D) g;
g2.fill(new Ellipse2D.Double(x,y,TAMX,TAMY));
     mueve_pelota(limites);
    }
    public double getX()
    {  
     return x;
    }
    public double getY()
    {  
     return y;
    }
    public float getRadio()
    {  
     return TAMX/2;
    }
    public double getDx()
    {  
     return dx;
    }
    public double getDy()
    {  
     return dy;
    }
    public float getMasa()
    {  
     return masa;
    }
    public void setDx(double desplazamientox)
    {  
     dx=desplazamientox;
    }
public void setDy(double desplazamientoy)
    {  
     dy=desplazamientoy;
    }
public static boolean choque(Pelota pelota1,Pelota pelota2){
    double x1=pelota1.getX();
    double y1=pelota1.getY();
    float radio1=pelota1.getRadio();
    double x2=pelota2.getX();
    double y2=pelota2.getY();
    float radio2=pelota2.getRadio();
    if((Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2))<=Math.pow((radio1+radio2),2)){
        return true;
    }else
        return false;
    }
}
class LaminaPelota extends JPanel
{
private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
//Añadimos pelota a la lámina
public void add(Pelota b)
{
pelotas.add(b);
}
public void eliminar()
{
if(!pelotas.isEmpty()) 
    pelotas.remove(pelotas.size()-1);
}
public int contar()
{
return(pelotas.size());
}
public void paintComponent(Graphics g) 
{
super.paintComponent(g);
g.setColor(new Color( 245, 245, 220 ));
g.fillRect(0,0,getWidth(),getHeight());
try
{
for(int i=0; i < pelotas.size(); i++)
{
        if(pelotas.size()>=2)
        {
         for(int j=i+1;j<pelotas.size(); j++)
         
if(Pelota.choque(pelotas.get(i),pelotas.get(j)))
          {
				System.out.println("Choque: "+i+" , "+j);
                         	  double masa1=pelotas.get(i).getMasa();
		        		  double velocidadx1=pelotas.get(i).getDx();
		        		  double velocidady1=pelotas.get(i).getDy();
		        		  
		        		  double masa2=pelotas.get(j).getMasa();
		        		  double velocidadx2=pelotas.get(j).getDx();
		        		  double velocidady2=pelotas.get(j).getDy();
		        		  
		        		  double sumaMasas=masa1+masa2;
		        		  
		        		  double velocidadF1x=((masa1-masa2)*velocidadx1+2*masa2*velocidadx2)/sumaMasas;
		        		  double velocidadF1y=((masa1-masa2)*velocidady1+2*masa2*velocidady2)/sumaMasas;
		        		  
		        		  double velocidadF2x=((masa2-masa1)*velocidadx2+2*masa1*velocidadx1)/sumaMasas;
		        		  double velocidadF2y=((masa2-masa1)*velocidady2+2*masa1*velocidady1)/sumaMasas;
		        		  
		        		  pelotas.get(i).setDx(velocidadF1x);
		        		  pelotas.get(i).setDy(velocidadF1y);
		        		  pelotas.get(j).setDx(velocidadF2x);
		        		  pelotas.get(j).setDy(velocidadF2y);
  }
pelotas.get(i).pintar_bola(g);
        }
else
        {
pelotas.get(i).pintar_bola(g);
        }
}
Thread.sleep(5);
}
catch(InterruptedException e)
{
//System.out.println("Error al intentar pintar la 
//bola"+e);
}
repaint();
}
}
class MarcoRebote extends JFrame
{
private LaminaPelota lamina;
JTextField ventana=new JTextField(2);
public MarcoRebote()
{
setBounds(600,300,400,350);
setTitle ("Juego Rebotes");
lamina=new LaminaPelota();
this.add(lamina, BorderLayout.CENTER);
JPanel laminaBotones=new JPanel();
ventana.setText("10");
laminaBotones.add(ventana);
ponerBoton(laminaBotones, "Empezar", new
ActionListener(){
public void actionPerformed(ActionEvent evento){
comienza_el_juego();
}
});
ponerBoton(laminaBotones, "Eliminar", new
ActionListener(){
public void actionPerformed(ActionEvent evento){
lamina.eliminar();
 }
});
ponerBoton(laminaBotones, "Salir", new ActionListener()
{
public void actionPerformed(ActionEvent evento){
System.exit(0);
}
});
add(laminaBotones, BorderLayout.SOUTH);
}
public void ponerBoton(Container c, String titulo, 
ActionListener oyente)
{
JButton boton=new JButton(titulo);
c.add(boton);
boton.addActionListener(oyente);
}
//Añade pelota y la bota nuchas veces
public void comienza_el_juego ()
{
Random rand=new Random();
int r=rand.nextInt(255);
int g=rand.nextInt(255);
int b=rand.nextInt(255);
int radio=Integer.parseInt(ventana.getText());
Pelota pelota=new Pelota(new Color(r,g,b),radio);
HiloPelota hilo=new HiloPelota(pelota,lamina);
hilo.start();
}
}
class HiloPelota extends Thread implements Runnable
{
    private Pelota pelota;
    private static LaminaPelota lamina;
HiloPelota(Pelota pelota, LaminaPelota lamina)
    {
     this.pelota=pelota;
     this.lamina=lamina;
    }
public void run()
    {
lamina.add(pelota);
pelota.mueve_pelota(lamina.getBounds());
    }
}
