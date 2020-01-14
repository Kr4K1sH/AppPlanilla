package capaGrafica;

import capaObjetos.Departamento;

import java.awt.Dimension;

import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import javax.swing.table.DefaultTableModel;

import oracle.jdeveloper.layout.BoxLayout2;

public class frmDepartamento extends JFrame {

    private JToolBar jtoolbarDepartamentos = new JToolBar();
    private JButton jbtnAgregar = new JButton();
    private JButton jbtnModificar = new JButton();
    private JButton jbtnEliminar = new JButton();
    private JButton jbtnConsultar = new JButton();
    private JButton jbtnSalir = new JButton();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTable jtblDepartamento = new JTable();
    private DefaultTableModel modeloTabla;
    //Departamento pra agregar y modificar
    private static Departamento midepto = null;

    public frmDepartamento() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize(new Dimension(501, 337));
        this.setTitle( "Mantenimiento de Departamentos" );
        jtoolbarDepartamentos.setBounds(new Rectangle(125, 20, 230, 65));
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtnAgregar_actionPerformed(e);
                }
            });
        jbtnModificar.setText("Modificar");
        jbtnModificar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtnModificar_actionPerformed(e);
                }
            });
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtnEliminar_actionPerformed(e);
                }
            });
        jbtnConsultar.setText("Consultar");
        jbtnConsultar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtnConsultar_actionPerformed(e);
                }
            });
        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbtnSalir_actionPerformed(e);
                }
            });
        jScrollPane1.setBounds(new Rectangle(30, 110, 425, 160));
        jtoolbarDepartamentos.add(jbtnAgregar, null);
        jtoolbarDepartamentos.add(jbtnModificar, null);
        jtoolbarDepartamentos.add(jbtnEliminar, null);
        jtoolbarDepartamentos.add(jbtnConsultar, null);
        jtoolbarDepartamentos.add(jbtnSalir, null);
        jScrollPane1.getViewport().add(jtblDepartamento, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jtoolbarDepartamentos, null);
        asingamodeloTabla();
        llenaTabla();
        
    }
    private void asingamodeloTabla(){
        String [] Ti = {"Codigo","Nombre"};
        this.modeloTabla = new DefaultTableModel(Ti,0);
        this.jtblDepartamento.setModel(modeloTabla);
    this.jtblDepartamento.setRowSelectionAllowed(true);
    }
    private void llenaTabla(){
        this.modeloTabla.setRowCount(0);
        String dat[]= new String [2];
        ArrayList<Departamento> lista = null;
        try{
            lista = Departamento.listaDeptos();
        }catch(Exception e){
            
        }
     for (Departamento departamento : lista) {
         dat [0]= departamento.getCodigo()+"";
         dat[1]= departamento.getNombre()+"";
         modeloTabla.addRow(dat);
        }
        }

    private void jbtnAgregar_actionPerformed(ActionEvent e) {
   jdlgDepartamento ojdlgDep = new jdlgDepartamento ('A');
        ojdlgDep.setModal(true);
        ojdlgDep.setLocationRelativeTo(null);
        ojdlgDep.setVisible(true);
        // Cuando regresa
        if(this.midepto !=null){
            //Agregar Departamento al archivo
            try{
                Departamento.agregarDepartamento(midepto);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error al guardar");
            }
            llenaTabla();
        }
        
    }
    

    private void jbtnModificar_actionPerformed(ActionEvent e) {
        if(this.jtblDepartamento.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"Seleccione un departamento");
        }else{
   int codigo = Integer.parseInt(this.jtblDepartamento.getValueAt(this.jtblDepartamento.getSelectedRow() , 0).toString());
                
                jdlgDepartamento jdlgdep = new jdlgDepartamento(codigo,'M');
                 jdlgdep.setModal(true);
                 jdlgdep.setLocationRelativeTo(null);
                 jdlgdep.setVisible(true);
                     if(this.midepto !=null){
                         //Agregar Departamento al archivo
                         try{
                             Departamento.ModoficarDepartamento(midepto);
                         }catch(Exception ex){
                             JOptionPane.showMessageDialog(this,"Error al modificar");
                         }
                         llenaTabla();
                     }
   
   
            }
   
   
    }

    private void jbtnEliminar_actionPerformed(ActionEvent e) {
   
           if(this.jtblDepartamento.getSelectedRow() ==-1 ){
            //Agregar Departamento al archivo
            JOptionPane.showMessageDialog(this,"Seleccione un elemento");
           }else{
                int codigo = Integer.parseInt(this.jtblDepartamento.getValueAt(this.jtblDepartamento.getSelectedRow() , 0).toString());
                
               try{
                   Departamento.eliminarDepartamento(codigo);
                    
               }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error al Eliminar");
            }
            llenaTabla();
        }
        
   
    }

    private void jbtnConsultar_actionPerformed(ActionEvent e) {
   
        if(this.jtblDepartamento.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null,"Seleccione un departamento");
        }else{
        int codigo = Integer.parseInt(this.jtblDepartamento.getValueAt(this.jtblDepartamento.getSelectedRow() , 0).toString());
                
                jdlgDepartamento jdlgdep = new jdlgDepartamento(codigo,'C');
                 jdlgdep.setModal(true);
                 jdlgdep.setLocationRelativeTo(null);
                 jdlgdep.setVisible(true);
            }
   
   
   
   
   
   
    }


    public static void setMidepto(Departamento midepto) {
        frmDepartamento.midepto = midepto;
    }

    public static Departamento getMidepto() {
        return midepto;
    }

    private void jbtnSalir_actionPerformed(ActionEvent e) {
        this.dispose();
    }
}
