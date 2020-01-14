package capaObjetos;

public class Operario extends Empleado {
    private double piezasProducidas;
    private double salarioPorPieza;

    public Operario(String cedula, String nombrep, double salarioBasep, 
                    int mesIngresop, int annoIngresop,boolean ccssp, boolean polizap, int piezasProducidasp, double salarioPiezap) {
        super(cedula, nombrep, salarioBasep, mesIngresop, annoIngresop, ccssp,polizap);
        this.setPiezasProducidas(piezasProducidasp);
        this.setSalarioPorPieza(salarioPiezap);

    }

    public double calculaSalarioTotal() {
      return  super.calculaSalarioTotal() 
              + 
            this.getPiezasProducidas() 
            * this.getSalarioPorPieza();
       
        
    }

    public String toString() {

        return super.toString() + 
            "\n Operario de Planta - Piezas producidas: " + 
            this.getPiezasProducidas() + " Salario por pieza: " + 
            this.getSalarioPorPieza();


    }

    public double getPiezasProducidas() {
        return piezasProducidas;
    }

    public void setPiezasProducidas(double piezasProducidas) {
        this.piezasProducidas = piezasProducidas;
    }

    public double getSalarioPorPieza() {
        return salarioPorPieza;
    }

    public void setSalarioPorPieza(double precioPorPieza) {
        this.salarioPorPieza = precioPorPieza;
    }
}
