package capaObjetos;

import capaDatos.DeptoBD;

import java.io.Serializable;

import java.util.ArrayList;

public class Departamento implements Serializable {
private int codigo;
private String nombre;

public Departamento(int codigo, String nombre){
    this.codigo = codigo;
    this.nombre = nombre;
}

public String toString(){
    return nombre;
}


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public static ArrayList listaDeptos() throws Exception{
        ArrayList lista = DeptoBD.getInstance().listaDepartamentos();
        return lista;
    }
    public static void agregarDepartamento(Departamento depto) throws Exception{
        DeptoBD.getInstance().agregarDepartamento(depto);
    }
    public static void ModoficarDepartamento(Departamento depto) throws Exception{
        DeptoBD.getInstance().modificarDepartamento(depto);
    }
    public static void eliminarDepartamento(int codigoDepto) throws Exception{
        DeptoBD.getInstance().eliminarDepartamento(codigoDepto);
    }   
}
