package ej4;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;



public class MyBufferedImage extends BufferedImage{
    
    /* Esto será para más adelante */
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
            
    
/*-------------------------------- CONSTRUCTOR --------------------------------*/
    
    public MyBufferedImage(BufferedImage bi){
        super(
                bi.getColorModel(), bi.getRaster(),
                bi.getColorModel().isAlphaPremultiplied(), null);
        
        this.byteListOriginal=MyBufferedImage.copyDataRasterToByteArray(bi.getRaster());
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
    
/*-------------------------------- CONSTRUCTOR --------------------------------*/    
    
    
    private static byte[] copyDataRasterToByteArray(Raster ras){
        byte[] baDataRasterSource;
        
        if (ras.getDataBuffer().getDataType() != DataBuffer.TYPE_BYTE) {
            throw new IllegalArgumentException("RGB data type is not BYTE");
        }
        
        baDataRasterSource=((DataBufferByte) ras.getDataBuffer()).getData();
        return MyBufferedImage.copyByteArray(baDataRasterSource);
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
