package editorImage;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;



public class Viewer extends Canvas{
    
    public Viewer (int pixWidth, int pixHeight){
        Dimension d = new Dimension(pixWidth, pixHeight);
        
        this.setPreferredSize(d);
        
        // this.loadImage();
    }
    
}
