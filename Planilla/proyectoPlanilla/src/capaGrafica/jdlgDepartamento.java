package capaGrafica;

import capaDatos.DeptoBD;

import capaObjetos.Departamento;

import java.awt.Dimension;
import java.awt.Frame;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class jdlgDepartamento extends JDialog {
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JEditorPane jtxtCod = new JEditorPane();
    private JEditorPane jtxtNom = new JEditorPane();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
   
   private int codigoDepto;
   private char tipoMantenimiento;
 
    public jdlgDepartamento(int codigoDepto,char tipoMantenimiento) {
        this(null, "", false);
        this.codigoDepto = codigoDepto;
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public jdlgDepartamento(char tipoMantenimiento) {
        this(null, "", false);
        this.tipoMantenimiento = tipoMantenimiento;
    }
    
    public jdlgDepartamento(Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(340, 266));
        this.getContentPane().setLayout( null );
        this.addWindowListener(new WindowAdapter() {
                public void windowOpened(WindowEvent e) {
                    this_windowOpened(e);
                }
            });
        jLabel1.setText("Codigo");
        jLabel1.setBounds(new Rectangle(40, 10, 70, 35));
        jLabel2.setText("Nombre");
        jLabel2.setBounds(new Rectangle(35, 60, 70, 35));
        jtxtCod.setBounds(new Rectangle(95, 15, 160, 30));
        jtxtNom.setBounds(new Rectangle(95, 65, 160, 30));
        jButton1.setText("Aceptar");
        jButton1.setBounds(new Rectangle(25, 135, 115, 25));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jButton2.setText("Cancelar");
        jButton2.setBounds(new Rectangle(170, 135, 115, 25));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jtxtNom, null);
        this.getContentPane().add(jtxtCod, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
    }

    private void this_windowOpened(WindowEvent e) {
     this.jtxtCod.setText(codigoDepto+"");
     this.jtxtNom.setText("");
    //BUscar en el Archivo
     Departamento deptoBuscar = null;
     try{
         deptoBuscar = DeptoBD.getInstance().consultarDepartamento(codigoDepto);
     }catch (Exception ex){
         JOptionPane.showMessageDialog(null,"Error al buscar el codigo del departamento: "+ ex.toString()+"\n"+ex.getMessage());
     }
     if(deptoBuscar !=null){
        jtxtNom.setText(deptoBuscar.getNombre());
     }
     switch(tipoMantenimiento){
     case 'A': 
         jtxtCod.setEditable(true);
         this.jtxtCod.setText("");
         this.jtxtNom.setText("");
         this.setTitle("Nuevo Departamento");
         break;
         case 'M': 
             jtxtCod.setEditable(false);
             this.jtxtNom.setText("");
             this.setTitle("Modificar Departamento");
             break;
         case 'C': 
             jtxtCod.setEditable(false);
             this.jtxtNom.setEditable(false);
             this.setTitle("Consultar Departamento");
             break;
     
     }
     
     
     
     
     
    }

    private void jButton1_actionPerformed(ActionEvent e) {
    int codigo = Integer.parseInt(this.jtxtCod.getText());
    String nombre = this.jtxtNom.getText();
    
    frmDepartamento.setMidepto(new Departamento(codigo,nombre));
    this.dispose();


    }

    private void jButton2_actionPerformed(ActionEvent e) {
        frmDepartamento.setMidepto(null);
        this.dispose();
    }
}
