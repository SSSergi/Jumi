package editorImage;


import java.awt.GridBagLayout;
import java.awt.Container;
import javax.swing.JFrame;


public class Window extends JFrame{
    
    private Viewer viewer;
    private final int vWidth=960;
    private final int vHeigth=540;
    
    public Window(){
        viewer=new Viewer(vWidth, vHeigth);
        // ctrlpanel=new ControlPanel(viewer);
        crearFrame();
    }
    
    public static void main(String[] args) {
        Window w = new Window();
        w.setVisible(true);
    }
    
    private void crearFrame(){
        /* Esta parte crea y prepara la ventana */

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridBagLayout());

        Container contenedor = getContentPane();

        // addViewerToPane(contenedor);
        // ControlPanel cp=new ControlPanel(viewer);
        // cp.addComponentsToPane(contenedor);
        pack();
    }
    
    
}
