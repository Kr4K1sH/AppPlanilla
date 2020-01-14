package capaObjetos;

public class Vendedor extends Empleado {

    private double porcentajeComision = 10;
    private double montoVentas;

    public Vendedor(String cedula, String nombrep, double salarioBasep, 
                    int mesIngresop, int annoIngresop, boolean ccssp, boolean polizap, double montoVentasp) {
        super(cedula, nombrep, salarioBasep, mesIngresop, annoIngresop,ccssp,polizap);
        this.setMontoVentas(montoVentasp);  
    }

    public double calculaSalarioTotal() {
     return super.calculaSalarioTotal() + montoVentas * porcentajeComision / 100;        
     
     }

    public String toString() {

        return super.toString() + "\n Vendedor - Porcentaje de Comisión: " + 
            this.getPorcentajeComision() + "% Monto de sus ventas: " + 
            this.getMontoVentas();


    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public double getMontoVentas() {
        return montoVentas;
    }

    public void setMontoVentas(double montoVentas) {
        this.montoVentas = montoVentas;
    }
}
