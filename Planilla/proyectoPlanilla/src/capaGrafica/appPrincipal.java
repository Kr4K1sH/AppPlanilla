package capaGrafica;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;


public class appPrincipal {
    public appPrincipal() {
        JFrame frame = new frmPrincipal();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation( ( screenSize.width - frameSize.width ) / 2, ( screenSize.height - frameSize.height ) / 2 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  sirve para maximizar a una pántalla
        //frame.setUndecorated(true); sirve para quitar el equis de una pantalla y el maximizar y el minimizar
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new appPrincipal();
    }
}
