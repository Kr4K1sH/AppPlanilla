package capaGrafica;


import capaObjetos.Departamento;
import capaObjetos.Empleado;
import capaObjetos.Operario;
import capaObjetos.Vendedor;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class frmPlanilla extends JFrame {
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLblSalarioNeto = new JLabel();
    private JTextField jTxtCedula = new JTextField();
    private JTextField jTxtNombre = new JTextField();
    private JTextField jTxtSalarioBase = new JTextField();
    private JTextField jTxtSalarioNeto = new JTextField();
    private JButton jBtnAceptar = new JButton();
    private JButton jBtnLimpiar = new JButton();
    private JButton jBtnSalir = new JButton();
    private JRadioButton jRbVendedor = new JRadioButton();
    private JRadioButton jRbOperario = new JRadioButton();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    private JTextField jTxtMontoVentas = new JTextField();
    private JTextField jTxtPiezasProducidas = new JTextField();
    private JLabel jLblMontoVentas = new JLabel();
    private JLabel jLblPiezasProducidas = new JLabel();
    private ButtonGroup grupoBotonesOpcion = new ButtonGroup();
    private JTextField jTxtSalarioPieza = new JTextField();
    private JLabel jLbLSalarioPieza = new JLabel();
    private JCheckBox jCkBCcSs = new JCheckBox();
    private JCheckBox jCkBPoliza = new JCheckBox();
    private JLabel jLabel7 = new JLabel();
    private JSeparator jSeparator1 = new JSeparator();
    private JLabel jLabel10 = new JLabel();
    private JTextField jTxtSalarioTotal = new JTextField();
    private JLabel jLabel11 = new JLabel();
    private JTextField jTxtDeducciones = new JTextField();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea jTxaResultado = new JTextArea();
    private JComboBox jCboDepartamento = new JComboBox();
    private JLabel jLabel12 = new JLabel();
    private JComboBox jCboMes = new JComboBox();
    private JComboBox jCboAnno = new JComboBox();
    private JLabel jLabel13 = new JLabel();


    public frmPlanilla() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        this.setSize(new Dimension(634, 576));
        this.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                this_windowOpened(e);
            }
        });
        jLabel1.setText("Sistema de Planilla");
        jLabel1.setBounds(new Rectangle(219, 0, 190, 15));
        jLabel1.setFont(new Font("Dialog", 1, 14));
        jLabel2.setText("Cédula");
        jLabel2.setBounds(new Rectangle(20, 35, 55, 15));
        jLabel2.setFont(new Font("Tahoma", 0, 12));
        jLabel3.setText("Nombre");
        jLabel3.setBounds(new Rectangle(20, 65, 70, 15));
        jLabel3.setFont(new Font("Tahoma", 0, 12));
        jLabel4.setText("Tipo de Empleado");
        jLabel4.setBounds(new Rectangle(275, 30, 110, 15));
        jLabel4.setFont(new Font("Tahoma", 0, 12));
        jLabel5.setText("Salario Base");
        jLabel5.setBounds(new Rectangle(20, 105, 75, 15));
        jLabel5.setFont(new Font("Tahoma", 0, 12));
        jLabel6.setText("Fecha de Ingreso:");
        jLabel6.setBounds(new Rectangle(20, 240, 105, 15));
        jLabel6.setFont(new Font("Tahoma", 0, 12));
        jLblSalarioNeto.setText("Salario Neto");
        jLblSalarioNeto.setBounds(new Rectangle(290, 320, 80, 15));
        jLblSalarioNeto.setFont(new Font("Tahoma", 0, 12));
        jTxtCedula.setBounds(new Rectangle(120, 35, 90, 20));
        jTxtNombre.setBounds(new Rectangle(120, 65, 135, 20));
        jTxtSalarioBase.setBounds(new Rectangle(120, 105, 110, 20));
        jTxtSalarioNeto.setBounds(new Rectangle(375, 320, 100, 20));
        jTxtSalarioNeto.setEditable(false);
        jTxtSalarioNeto.setFont(new Font("Tahoma", 0, 12));
        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.setBounds(new Rectangle(495, 225, 110, 35));

        jBtnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnAceptar_actionPerformed(e);
            }
        });
        jBtnLimpiar.setText("Limpiar");
        jBtnLimpiar.setBounds(new Rectangle(495, 265, 110, 35));
        jBtnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnLimpiar_actionPerformed(e);
            }
        });
        jBtnSalir.setText("Salir");
        jBtnSalir.setBounds(new Rectangle(495, 310, 110, 35));
        jBtnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jBtnSalir_actionPerformed(e);
            }
        });
        jRbVendedor.setText("Vendedor");
        jRbVendedor.setBounds(new Rectangle(285, 50, 84, 19));
        jRbVendedor.setFont(new Font("Tahoma", 0, 12));
        jRbVendedor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jRbVendedor_actionPerformed(e);
            }
        });
        jRbOperario.setText("Operario");
        jRbOperario.setBounds(new Rectangle(285, 75, 84, 19));
        jRbOperario.setFont(new Font("Tahoma", 0, 12));
        jRbOperario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jRBOperario_actionPerformed(e);
            }
        });
        jLabel8.setText("Mes");
        jLabel8.setBounds(new Rectangle(130, 240, 34, 15));
        jLabel8.setFont(new Font("Tahoma", 0, 12));
        jLabel9.setText("Año");
        jLabel9.setBounds(new Rectangle(130, 270, 34, 15));
        jLabel9.setFont(new Font("Tahoma", 0, 12));
        jTxtMontoVentas.setBounds(new Rectangle(530, 45, 75, 20));
        jTxtMontoVentas.setFont(new Font("Tahoma", 0, 12));
        jTxtPiezasProducidas.setBounds(new Rectangle(530, 75, 75, 20));
        jTxtPiezasProducidas.setFont(new Font("Tahoma", 0, 12));
        jLblMontoVentas.setText("Monto Ventas:");
        jLblMontoVentas.setBounds(new Rectangle(400, 45, 100, 15));
        jLblMontoVentas.setFont(new Font("Tahoma", 0, 12));
        jLblPiezasProducidas.setText("Piezas Producidas:");
        jLblPiezasProducidas.setBounds(new Rectangle(400, 75, 115, 15));
        jLblPiezasProducidas.setFont(new Font("Tahoma", 0, 12));
        jTxtSalarioPieza.setBounds(new Rectangle(530, 105, 75, 20));
        jTxtSalarioPieza.setFont(new Font("Tahoma", 0, 12));
        jLbLSalarioPieza.setText("Salario por Pieza: ");
        jLbLSalarioPieza.setBounds(new Rectangle(400, 100, 100, 15));
        jLbLSalarioPieza.setFont(new Font("Tahoma", 0, 12));
        jCkBCcSs.setText("CCSS");
        jCkBCcSs.setBounds(new Rectangle(325, 165, 75, 19));
        jCkBCcSs.setFont(new Font("Tahoma", 0, 12));
        jCkBPoliza.setText("Poliza");
        jCkBPoliza.setBounds(new Rectangle(325, 190, 75, 19));
        jCkBPoliza.setFont(new Font("Tahoma", 0, 12));
        jLabel7.setText("Deducciones");
        jLabel7.setBounds(new Rectangle(320, 145, 90, 15));
        jLabel7.setFont(new Font("Tahoma", 0, 12));
        jSeparator1.setBounds(new Rectangle(0, 350, 645, 5));
        jLabel10.setText("Salario Total");
        jLabel10.setBounds(new Rectangle(290, 240, 80, 15));
        jLabel10.setFont(new Font("Tahoma", 0, 12));
        jTxtSalarioTotal.setBounds(new Rectangle(375, 235, 100, 20));
        jTxtSalarioTotal.setEditable(false);
        jTxtSalarioTotal.setFont(new Font("Tahoma", 0, 12));
        jLabel11.setText("Deducciones");
        jLabel11.setBounds(new Rectangle(290, 280, 75, 15));
        jLabel11.setFont(new Font("Tahoma", 0, 12));
        jTxtDeducciones.setBounds(new Rectangle(375, 275, 100, 20));
        jTxtDeducciones.setEditable(false);
        jTxtDeducciones.setFont(new Font("Tahoma", 0, 12));
        jScrollPane1.setBounds(new Rectangle(15, 385, 605, 150));
        jCboDepartamento.setBounds(new Rectangle(120, 140, 155, 20));
        jCboDepartamento.setFont(new Font("Tahoma", 0, 12));
        jLabel12.setText("Departamento");
        jLabel12.setBounds(new Rectangle(20, 145, 115, 15));
        jLabel12.setFont(new Font("Tahoma", 0, 12));
        jCboMes.setBounds(new Rectangle(175, 240, 55, 20));
        jCboMes.setFont(new Font("Tahoma", 0, 12));
        jCboAnno.setBounds(new Rectangle(170, 280, 60, 20));
        jCboAnno.setFont(new Font("Tahoma", 0, 12));
        jLabel13.setText("Empleado");
        jLabel13.setBounds(new Rectangle(25, 360, 190, 15));
        jLabel13.setFont(new Font("Dialog", 1, 14));
        this.getContentPane().add(jLabel13, null);
        this.getContentPane().add(jCboAnno, null);
        this.getContentPane().add(jCboMes, null);
        this.getContentPane().add(jLabel12, null);
        this.getContentPane().add(jCboDepartamento, null);
        jScrollPane1.getViewport().add(jTxaResultado, null);
        this.getContentPane().add(jScrollPane1, null);
        this.getContentPane().add(jTxtDeducciones, null);
        this.getContentPane().add(jLabel11, null);
        this.getContentPane().add(jTxtSalarioTotal, null);
        this.getContentPane().add(jLabel10, null);
        this.getContentPane().add(jSeparator1, null);
        this.getContentPane().add(jLabel7, null);
        this.getContentPane().add(jCkBPoliza, null);
        this.getContentPane().add(jCkBCcSs, null);
        this.getContentPane().add(jLbLSalarioPieza, null);
        this.getContentPane().add(jTxtSalarioPieza, null);
        this.getContentPane().add(jLblPiezasProducidas, null);
        this.getContentPane().add(jLblMontoVentas, null);
        this.getContentPane().add(jTxtPiezasProducidas, null);
        this.getContentPane().add(jTxtMontoVentas, null);
        this.getContentPane().add(jLabel9, null);
        this.getContentPane().add(jLabel8, null);
        this.getContentPane().add(jRbOperario, null);
        this.getContentPane().add(jRbVendedor, null);
        this.getContentPane().add(jBtnSalir, null);
        this.getContentPane().add(jBtnLimpiar, null);
        this.getContentPane().add(jBtnAceptar, null);
        this.getContentPane().add(jTxtSalarioNeto, null);
        this.getContentPane().add(jTxtSalarioBase, null);
        this.getContentPane().add(jTxtNombre, null);
        this.getContentPane().add(jTxtCedula, null);
        this.getContentPane().add(jLblSalarioNeto, null);
        this.getContentPane().add(jLabel6, null);
        this.getContentPane().add(jLabel5, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel1, null);
        // Está parte acá es para agrupar los radiobuttons
        // si no se hace no deselecciona los radiobuttons
        grupoBotonesOpcion.add(this.jRbOperario);
        grupoBotonesOpcion.add(this.jRbVendedor);
    }


    private void this_windowOpened(WindowEvent e) {
        esconderDatos();
        llenarComboDepartamentos();
        llenarCombosFechaNacimiento();
        this.jBtnLimpiar.setEnabled(false);
        this.jTxtCedula.requestFocus();
    }

    private void llenarComboDepartamentos() {
        this.jCboDepartamento.addItem(new Departamento(1, "Call Center"));
        this.jCboDepartamento.addItem(new Departamento(2, "Empaque"));
        this.jCboDepartamento.addItem(new Departamento(3, "Control de Calidad"));
        this.jCboDepartamento.addItem(new Departamento(4, "Ventas en línea"));
        this.jCboDepartamento.addItem(new Departamento(5, "Manufactura"));
    }

    private void llenarCombosFechaNacimiento() {
        Calendar calendario = Calendar.getInstance();
     
        int annoActual = calendario.get(Calendar.YEAR);
        for (int i = 1; i <= 12; i++) {
            this.jCboMes.addItem(i);
        }

        for (int i = 1995; i <= annoActual; i++) {
            this.jCboAnno.addItem(i);
        }

        this.jCboAnno.setSelectedIndex(-1);
        this.jCboMes.setSelectedIndex(-1);
    }

    private void esconderDatos() {
        //Deshabilitar los datos que dependen del tipo de vendedor

        this.jLblMontoVentas.setVisible(false);
        this.jLblPiezasProducidas.setVisible(false);
        this.jTxtPiezasProducidas.setVisible(false);
        this.jTxtMontoVentas.setVisible(false);
        this.jLbLSalarioPieza.setVisible(false);
        this.jTxtSalarioPieza.setVisible(false);
    }

    private void jRbVendedor_actionPerformed(ActionEvent e) {
        if (this.jRbVendedor.isSelected()) {
            this.jLblMontoVentas.setVisible(true);
            this.jTxtMontoVentas.setVisible(true);
            this.jLblPiezasProducidas.setVisible(false);
            this.jTxtPiezasProducidas.setVisible(false);
            this.jLbLSalarioPieza.setVisible(false);
            this.jTxtSalarioPieza.setVisible(false);
       }
    }


    private void jRBOperario_actionPerformed(ActionEvent e) {
        this.jLblPiezasProducidas.setVisible(true);
        this.jTxtPiezasProducidas.setVisible(true);
        this.jLblMontoVentas.setVisible(false);
        this.jTxtMontoVentas.setVisible(false);
        this.jLbLSalarioPieza.setVisible(true);
        this.jTxtSalarioPieza.setVisible(true);

    }

    private void jBtnAceptar_actionPerformed(ActionEvent e) {
        Empleado unEmpleado;
        boolean rebajaCaja = false, rebajaPoliza = false;
        double salarioBase = Double.parseDouble(jTxtSalarioBase.getText());
        
        Departamento miDepartamento = (Departamento)this.jCboDepartamento.getSelectedItem();
        
        int mesIngreso = (Integer)this.jCboMes.getSelectedItem();
        int annoIngreso = (Integer)this.jCboAnno.getSelectedItem();
        
        if (this.jCkBCcSs.isSelected()) {
            rebajaCaja = true;
        }
        if (this.jCkBPoliza.isSelected()) {
            rebajaPoliza = true;
        }

        if (this.jRbOperario.isSelected()) {
            int piezas = Integer.parseInt(this.jTxtPiezasProducidas.getText());
            double salarioPieza = Double.parseDouble(this.jTxtSalarioPieza.getText());
            unEmpleado =
                    new Operario(this.jTxtCedula.getText(), this.jTxtNombre.getText(), 
                                 salarioBase, mesIngreso, annoIngreso,
                                 rebajaCaja, rebajaPoliza, piezas, salarioPieza);
        } else {
            double montoVentas = Double.parseDouble(jTxtMontoVentas.getText());
            unEmpleado =
                    new Vendedor(this.jTxtCedula.getText(), this.jTxtNombre.getText(), 
                                 salarioBase, mesIngreso, annoIngreso,
                                 rebajaCaja, rebajaPoliza, montoVentas);        }
        unEmpleado.setDepartamento(miDepartamento);

        this.jTxtSalarioTotal.setText(Double.toString(unEmpleado.calculaSalarioTotal()));
        this.jTxtDeducciones.setText(Double.toString(unEmpleado.calculaDeducciones()));
        this.jTxtSalarioNeto.setText(Double.toString(unEmpleado.calculaSalarioNeto()));
        this.jTxaResultado.setText(unEmpleado.toString());
        
        this.jBtnLimpiar.setEnabled(true);

    }

    private void jBtnLimpiar_actionPerformed(ActionEvent e) {
        this.jCboAnno.setSelectedIndex(-1);
        this.jCboMes.setSelectedIndex(-1);
        this.jTxtCedula.setText("");
        this.jTxtMontoVentas.setText("");
        this.jTxtNombre.setText("");
        this.jTxtPiezasProducidas.setText("");
        this.jTxtSalarioBase.setText("");
        this.jTxtSalarioNeto.setText("");
        this.jTxtSalarioPieza.setText("");
        this.jTxtSalarioTotal.setText("");
        this.jTxtDeducciones.setText("");
        this.jCkBCcSs.setSelected(false);
        this.jCkBPoliza.setSelected(false);
        this.jCboDepartamento.setSelectedIndex(0);
        this.grupoBotonesOpcion.clearSelection();
        this.jTxaResultado.setText("");
        this.jTxtCedula.requestFocus();
        esconderDatos();
    }

    private void jBtnSalir_actionPerformed(ActionEvent e) {
        this.dispose();
    }

}
