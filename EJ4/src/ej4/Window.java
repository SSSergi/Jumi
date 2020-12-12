package ej4;

import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Container;


public class Window extends JFrame implements  Runnable{
    
    private Viewer viewer;
    private ControlPanel ctrlpanel;
    private final int vWidth=400;
    private final int vHeigth=400;
    private static boolean terminado;
    private static boolean pausado;

    public Window(){
        this.viewer=new Viewer(this.vWidth, this.vHeigth);
        this.ctrlpanel=new ControlPanel(this.viewer);
        this.crearFrame();
    }
    
    public static void main(String[] args) {
        Window w = new Window();
        w.setVisible(true);
    }
   
    
/* ---------------- MÉTODOS DE WINDOW ---------------- */
 
    public static boolean isEnd(){
        return Window.terminado;
    }
        
    public static boolean isPaused(){
        return Window.pausado;
    }
    
    public static void Play(){
        Window.terminado=false;
        Window.pausado=false;
    }
    
    public static void Pause(){
        Window.pausado=true;
    }
    
    
    private void crearFrame(){
        /* Esta parte crea y prepara la ventana */

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new GridBagLayout());

        Container contenedor = this.getContentPane();

        this.addViewerToPane(contenedor);
        ControlPanel cp=new ControlPanel(viewer);
        cp.addComponentsToPane(contenedor);
        this.pack();
    }

    
    private void addViewerToPane(Container panel){
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        gc.gridheight = 5;
        gc.gridwidth = 5;
        panel.add(this.viewer, gc);
    }
    @Override
    public void run(){
        while (!Window.isEnd()) {
            if (!Window.isPaused()) {
                this.showStatistics();
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    private void showStatistics() {
        
    } 
}
