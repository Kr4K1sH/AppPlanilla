package capaGrafica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class frmPrincipal extends JFrame {
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenu jMenu1 = new JMenu();
    private JMenuItem jMenuItem1 = new JMenuItem();
    private JMenu jMenu2 = new JMenu();
    private JMenuItem jMenuItem2 = new JMenuItem();

    public frmPrincipal() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize( new Dimension(800, 600) );
        this.setTitle("Sistema de Planillas");
        this.setJMenuBar(menuBar);
        menuFile.setText("Archivo");
        menuFileExit.setText("Salir");
        menuFileExit.addActionListener( new ActionListener() { public void actionPerformed( ActionEvent ae ) { fileExit_ActionPerformed( ae ); } } );
        jMenu1.setText("Procesos");
        jMenuItem1.setText("Planilla");
        jMenuItem1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jMenuItem1_actionPerformed(e);
                    }
                });
        jMenu2.setText("Mantenimiento");
        jMenuItem2.setText("Departamento");
        jMenuItem2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jMenuItem2_actionPerformed(e);
                }
            });
        menuFile.add( menuFileExit );
        menuBar.add( menuFile );
        jMenu1.add(jMenuItem1);
        menuBar.add(jMenu1);
        jMenu2.add(jMenuItem2);
        menuBar.add(jMenu2);
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void jMenuItem1_actionPerformed(ActionEvent e) {
       frmPlanilla ventana1 = new frmPlanilla();
       ventana1.setVisible(true);
    }

    private void jMenuItem2_actionPerformed(ActionEvent e) {
        frmDepartamento depto = new   frmDepartamento ();
        depto.setVisible(true);
    }
}
