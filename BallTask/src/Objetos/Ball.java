package Objetos;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;


public class Ball extends JPanel{
    
    // Color se hace con 3 atributos, 1 para Red, 1 para Green y 1 para Blue. Los 3 son Ints, y en dentro del constructor meteremos randoms en estas variables, para que se pueda generar así un color diferente.
    
    // Variables para formar un color
    double red=Math.random()*(0-255)+256;
    double green=Math.random()*(0-255)+256;
    double blue=Math.random()*(0-255)+256;
    
    double posX=Math.random()*(0-1960)+1961;
    double posY=Math.random()*(0-1040)+1041;
    
    double radio=Math.random()*(5-50)+51;
    double diametro=radio*2;
    
    
    
    public Ball(){
        
        this.red=red;
        this.green=green;
        this.blue=blue;
        this.radio=radio;
        this.diametro=diametro;
        this.posX=posX;
        this.posY=posY;   
    }

    /* ----------------------------- GETTERS -------------------------------- */
    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getRadio() {
        return radio;
    }

    public double getDiametro() {
        return diametro;
    }
    
    /* ------------------------------- SETTER ------------------------------- */

    public void setRed(double red) {
        this.red = red;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }
    
}
