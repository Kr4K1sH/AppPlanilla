package capaObjetos;
import java.util.Calendar;

public class Empleado {

    //Atributos de instancia de la clase Persona	
    private Departamento departamento;
    private String cedula;
    private String nombre;
    private int mesIngreso;
    private int annoIngreso;
    private double salarioBase;

    private boolean ccss;
    private boolean poliza;
    final double PORC_ANUALIDAD = 3;
    final double MONTO_POLIZA = 5000;
    final double PORC_CCSS = 9;


    public Empleado(String cedula, String nombrep, double salarioBasep, 
                    int mesIngresop, int annoIngresop,boolean ccssp, boolean polizap) {
        this.setCedula(cedula);
        this.setNombre(nombrep);
        this.setSalarioBase(salarioBasep);
        this.setAnnoIngreso(annoIngresop);
        this.setMesIngreso(mesIngresop);
        this.setCcss(ccssp);
        this.setPoliza(polizap);
        
    }
    
    public int calculaAntiguedad() {
        int annosLaborados;
        int annoActual;
        Calendar calendario = Calendar.getInstance();//obtiene la fecha actual del sistema
        annoActual = calendario.get(Calendar.YEAR);
        annosLaborados = annoActual - this.getAnnoIngreso();
        if (calendario.get(Calendar.MONTH) > this.getMesIngreso())
            return annosLaborados;
        else
            return annosLaborados - 1;
    }

    public double calculaSalarioTotal() {
         return this.getSalarioBase() + 
                this.getSalarioBase() * this.calculaAntiguedad() * PORC_ANUALIDAD / 100;
   }
   public double calculaDeducciones(){
     double deducciones=0;
       if (this.isCcss()){
         deducciones += this.PORC_CCSS/100* this.calculaSalarioTotal();
       }
       if (this.isPoliza())  {
         deducciones  += this.MONTO_POLIZA;
       }
       return deducciones;
   }
   public double calculaSalarioNeto(){
       return this.calculaSalarioTotal()-this.calculaDeducciones();
   }

   public String toString() {
        return "\nEmpleado - Cédula: " + this.getCedula() + " Nombre: " + this.getNombre() + 
        "\nAño ingreso: " +  this.getAnnoIngreso() + " Mes de ingreso: " +  this.getMesIngreso() +
        "\nSalario Base: " + this.getSalarioBase() + "\n Antigüedad: " + this.calculaAntiguedad() + " años."+
       "\nSalario Total: " + this.calculaSalarioTotal() +
       "\nSalario Total: " + this.calculaSalarioTotal() +
       "\nDeducciones: " + this.calculaDeducciones() +
       "\nSalario Neto: " + this.calculaSalarioNeto() ;
       
                
   }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombrep) {
        nombre = nombrep;
    }



    public int getAnnoIngreso() {
        return annoIngreso;
    }

    public void setAnnoIngreso(int annoIngres) {
        this.annoIngreso = annoIngres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getMesIngreso() {
        return mesIngreso;
    }

    public void setMesIngreso(int mesIngreso) {
        this.mesIngreso = mesIngreso;
    }

    protected boolean isCcss() {
        return ccss;
    }

    protected void setCcss(boolean ccss) {
        this.ccss = ccss;
    }

    protected boolean isPoliza() {
        return poliza;
    }

    protected void setPoliza(boolean poliza) {
        this.poliza = poliza;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
