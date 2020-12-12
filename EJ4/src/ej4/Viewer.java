package ej4;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Dimension;



public class Viewer extends Canvas implements Runnable{
    
    private BufferedImage imgOriginal;
    private String name="EJ4/jhinoc.png";
    
    
    public Viewer (int pixWidth, int pixHeight){
        Dimension d = new Dimension(pixWidth, pixHeight);
        
        this.setPreferredSize(d);
        
        this.loadImage();
    }
    
    
    private BufferedImage readImage(String n){
        BufferedImage img;
        
        try{
            img=ImageIO.read(new File("jhinoc.png"));
            return img;  /* Se ha encontrado la imagen y todo va correcto */
        }catch (IOException e){
            System.err.println("Img Error("+e+")");
        }
        
        return null;
    }
    
    public void loadImage(){
        float ratio;
        float w, h;
        
        this.imgOriginal=new MyBufferedImage(this.readImage(name));
        //this.modImg[Viewer.pic1]=new MyBufferedImage(this.readImage(name));
        //this.modImg[Viewer.pic2]=new MyBufferedImage(this.readImage(name));
        //this.modImg[Viewer.pic3]=new MyBufferedImage(this.readImage(name));
        
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        ratio=(float) this.imgOriginal.getWidth() / (float) this.imgOriginal.getHeight();
        h=(float) d.height * 0.70f;
        w=h * ratio;
    }
    
    
    public void paint(){
        BufferStrategy bs;
        
        bs=this.getBufferStrategy();
        if (bs==null){
            System.out.println("kgd");
            return;
        }

        Graphics g=bs.getDrawGraphics();
        g.drawImage(this.imgOriginal, 100,100,100,100,null);
        //this.;
        //this.fireThree.paint(g);

        bs.show();
        g.dispose();
    }
    
    @Override
    public void run(){
        this.createBufferStrategy(2);
        System.out.println("hola");
        
        while (!Window.isEnd()) {
            System.out.println("hola");
            this.paint();
            
            do {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                }
            } while(Window.isPaused());
        }
    }
}
