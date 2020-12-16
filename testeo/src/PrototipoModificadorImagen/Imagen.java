package PrototipoModificadorImagen;

import java.awt.*;
import java.awt.image.*;

public class Imagen extends BufferedImage{
    
    public byte[] byteListOriginal; //Byte array con pixels de la imagen
    public boolean gray;
    public boolean squareGray;
    public Rectangle square;
    public String name;
    
    public int bright;
    public int blueBright;
    public int greeBright;
    public int redBright;
    public int squareBright;
    public int squareRedBright;
    public int squareGreenBright;
    public int squareBlueBright;
    public int pixelLength;
    public int focusLevel;
    public int squareFocusLevel;
    public int contrast;
    
    
    /* ------------- CONSTRUCTOR ------------- */
    public Imagen(BufferedImage bi){
        super(
                bi.getColorModel(), bi.getRaster(),
                bi.getColorModel().isAlphaPremultiplied(), null);
        
        this.byteListOriginal=Imagen.copyDataRasterToByteArray(bi.getRaster());
        
        //this.resetBright();
        //this.resetSquareBright();
        //this.resetFocusLevel();
        
        this.gray = false;
        
        this.square = new Rectangle(0, 0, 0, 0);
        
        if (this.getAlphaRaster()!= null) {
            
            this.pixelLength=4;
            
        } else {
            
            this.pixelLength=3;
        }
    }
    /* ------------- CONSTRUCTOR ------------- */
    
    
    private static byte[] copyDataRasterToByteArray(Raster ras){
        
        byte[] baDataRasterSource;
        
        if (ras.getDataBuffer().getDataType() != DataBuffer.TYPE_BYTE) {
            
            throw new IllegalArgumentException("RGB data type is not BYTE");
        }
        
        baDataRasterSource=((DataBufferByte) ras.getDataBuffer()).getData();
        
        return Imagen.copyByteArray(baDataRasterSource);
    }
    
    
    private static Integer[] copyIntArray (Integer[] iaSource){
        
        Integer[] iaCopy;
        
        if (iaSource == null) {
            
            throw new IllegalArgumentException("Int array is null.");
        }
        
        iaCopy=new Integer[iaSource.length];
        
        System.arraycopy(iaSource, 0, iaCopy, 0, iaSource.length);
        
        return iaCopy;
    }
    
    
    private static byte[] copyByteArray(byte[] baSource){
        
        byte[] baCopy;
        
        if (baSource == null) {
            
            throw new IllegalArgumentException("Byte array is null.");
        }
        
        baCopy=new byte[baSource.length];
        
        System.arraycopy(baSource, 0, baCopy, 0, baSource.length);
        
        return baCopy;
    }
    
}
