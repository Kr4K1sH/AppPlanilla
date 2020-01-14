package capaDatos;


import capaObjetos.Departamento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;


public class DeptoBD {

    private String rutaArchivo = ".\\Archivos\\Departamento.txt";
    private String rutaArchivoTemporal= ".\\Archivos\\DepartamentoTemp.txt";
    private ObjectOutputStream oArchivoOOS= null;
    private ObjectOutputStream oArchivoTempOOS= null;
    private ObjectInputStream oArchivoOIS= null;
    
    //Instancia privada de la misma clase
    //implementa el patr�n Singleton
    private static  DeptoBD oDeptoBD= null;
   
    //Constructor privado, se implementa el patr�n Singleton
    private DeptoBD() {
        rutaArchivo = ".\\Archivos\\Departamento.txt";
        rutaArchivoTemporal = ".\\Archivos\\DepartamentoTemp.txt";
        oArchivoTempOOS = null;
        oArchivoOOS= null;
        oArchivoOIS= null;
    }
    
    //M�todo p�blico que retorna una �nica instancia de la 
    //clase, �nicamnete se construye la primera vez.
    public static DeptoBD getInstance(){
        if(oDeptoBD == null){
            oDeptoBD = new  DeptoBD();
        }
        return oDeptoBD;
    }
    
    //OJO: este tipo de comentario genera la ayuda del m�todo
    /**
     * Abre y retorna el archivo de datos, para escritura (de tipo output) al final del archivo
     * Tipo de Archivo: Secuencial.
     * Lanza la Exception al nivel donde fue llamado
     * @param rutaArchivo String ruta del archivo
     * @return ObjectOutputStream
     */
    public  ObjectOutputStream abrirArchivoOutput(String rutaArchivo) throws Exception {
        ObjectOutputStream oArchivoOutput = null;
        FileOutputStream oArchivoFOS;
           //Abrir el archivo
        try{
        File oArchivo = new File(rutaArchivo);
           if(!oArchivo.exists()){
             //Abrir el archivo de Acceso Secuencial para  escritura
             //La primera vez incluye la cabecera del archivo
             //true indica que se agregar�n registros al final
            
             oArchivoFOS = new FileOutputStream(rutaArchivo,true);
             oArchivoOutput = new ObjectOutputStream(oArchivoFOS);
            
           }
           else{
             //Abrir el archivo de Acceso Secuencial para  escritura
             //La primera vez incluye la cabecera del archivo
              oArchivoFOS = new FileOutputStream(rutaArchivo,true);
              oArchivoOutput = new MiObjectOutputStream(oArchivoFOS);
           }  
        }catch(Exception e){
            throw e;
        }
        return oArchivoOutput;
    }

    /**
     * Abre y retorna el archivo de datos, para lectura (de tipo input)
     * El apuntador del archivo se coloca al inicio del archivo
     * Tipo de Archivo: Secuencial.
     * @param rutaArchivo String ruta del archivo
     * @return ObjectInputStream
     */
    public  ObjectInputStream abrirArchivoInput(String rutaArchivo) throws Exception {
    
        FileInputStream oArchivoFIS;
        ObjectInputStream oArchivoInput = null;    
        //Abrir el archivo
      try{    
        oArchivoFIS = new FileInputStream(rutaArchivo);
        oArchivoInput = new ObjectInputStream(oArchivoFIS);
      }
      catch(Exception e){
         throw e;
      }
      return oArchivoInput;
    }

   
    /**
     * Permite cerrar el archivo de datos que se abri� de salida
    */
    public  void cerrarArchivoOutput(ObjectOutputStream oArchivo) throws Exception { 
        try{
        if (oArchivo != null) {
            oArchivo.close();
            oArchivo = null;
        }  
        }
        catch(Exception e){
           throw e;
        }
    }

    private void cerrarArchivoInput(ObjectInputStream archivo) throws Exception {
        try{     
             if (archivo != null) {
                archivo.close();
                archivo = null;
             }
        }
        catch(Exception e){
           throw e;
        }
    }


    /**
     * Lista de todos los Departamentos que se encuentran en el archivo
     * @return ArrayList
     */
     public ArrayList listaDepartamentos() throws Exception{
        ArrayList listaDeptos= new ArrayList();
        //Ya que habr� bloque finally se debe encerrar el bloque try
        //el throws del encabezado lanza la excepci�n del finally
        try {         
            oArchivoOIS = abrirArchivoInput(rutaArchivo);
           
           //Si al leer del archivo no hay objeto sucede la excepci�n
            while(true){
                Departamento depto1 = (Departamento)oArchivoOIS.readObject();                  
                listaDeptos.add(depto1);
            }
         } //No se indica el catch ya que no se har� nada, solamente se lanzar� por medio del throws  
        catch(Exception ex ){
            
        }
         finally{
            //Ocurra o no ocurra la excepci�n se cierra el archivo
            cerrarArchivoInput(oArchivoOIS);
           
         }
        return listaDeptos;
        
    }

   //Busca y retorna el objeto Departamento de acuerdo al c�digo que recibe como 
   //par�metro, en caso de que no lo encuentre retorna null
    public Departamento consultarDepartamento(int codigoDepto)throws Exception {
        Departamento deptoBuscado= null ;
        try {
             oArchivoOIS = abrirArchivoInput(rutaArchivo);
             //Si va a leer y no hay objeto Departamento se va por el catch
             while(true){
                deptoBuscado = (Departamento)oArchivoOIS.readObject();
                if (deptoBuscado.getCodigo()==codigoDepto) {
                    return deptoBuscado;
                } 
            }            
        }catch(Exception e){
            deptoBuscado = null;
            return deptoBuscado;
            
        }
        finally{ //Suceda o no suceda la excepci�n se deben cerrar los archivos
             cerrarArchivoInput(oArchivoOIS);
        }        
    }


    /**
     * Agregar un nuevo Departamento al final del archivo
     * @param pDepartamento Objeto Departamento a agregar
     * @return boolean
     */
    public  void agregarDepartamento(Departamento pDepartamento)throws Exception {
        
        try {
            oArchivoOOS= this.abrirArchivoOutput(rutaArchivo);
            if (oArchivoOOS != null) {
              //Ejecutar la escritura del objeto pDepartamento en el archivo
               oArchivoOOS.writeObject(pDepartamento);
               oArchivoOOS.flush();  //Env�a el contenido del buffer al archivo
            }
        
        } catch (Exception e) {
            throw e;
        }
        finally{
            //Ocurra o no la excepci�n se debe cerrar el archivo
            this.cerrarArchivoOutput(oArchivoOOS); //Cierra el archivo
        }
        
    }

    /**
     * Agregar un nuevo Departamento al archivo
     * @param pDepartamento Objeto Departamento a agregar
     * @return boolean
     */
      public void modificarDepartamento(Departamento pDepartamento) throws Exception{
        try {            
            oArchivoOIS = abrirArchivoInput(rutaArchivo);
            //Declara archivo temporal y lo abre de tipo Output            
            oArchivoTempOOS = abrirArchivoOutput(rutaArchivoTemporal);
             //Si va a leer y no hay objeto Departamento se va por el catch
             //Pasar todos los objetos del archivo al temporal modificando el 
            //objeto que se desea modificar
             Departamento depto1=null;
             while(true){
                 depto1 = (Departamento)oArchivoOIS.readObject(); 
                 if(depto1.getCodigo()==pDepartamento.getCodigo()) {
                   depto1=pDepartamento;
                 }
                 oArchivoTempOOS.writeObject(depto1);
             }            
        }
        catch(Exception ex){
        }
        finally{
            cerrarArchivoInput(oArchivoOIS);
            cerrarArchivoOutput(oArchivoTempOOS);
            
        }
        pasarArchivoTemporal_ArchivoOriginal();        
    }
    
    public void eliminarDepartamento(int codigoDepto) throws Exception {
        try {            
            oArchivoOIS = abrirArchivoInput(rutaArchivo);
            //Declara archivo temporal y lo abre de tipo Output            
            oArchivoTempOOS = abrirArchivoOutput(rutaArchivoTemporal);
             //Si va a leer y no hay objeto Departamento se va por el catch
             //Pasar todos los objetos del archivo al temporal modificando el 
            //objeto que se desea modificar
             Departamento depto1 = null;
             while(true){
                 depto1 = (Departamento)oArchivoOIS.readObject();               
                 if(depto1.getCodigo()!=codigoDepto) {
                    oArchivoTempOOS.writeObject(depto1);
                 }
             }            
        }catch(Exception e){
           
        }
        finally{
             cerrarArchivoInput(oArchivoOIS);
             cerrarArchivoOutput(oArchivoTempOOS);
        }
        pasarArchivoTemporal_ArchivoOriginal();
        
    }
    

    private void pasarArchivoTemporal_ArchivoOriginal() {
       //Se elimina el archivo original y se renombra el temporal igual a este.   
       File archivoTemp = new File(rutaArchivoTemporal);
       File archivoOriginal = new File(rutaArchivo);
       //Si los archvos existen borrar el archivo original para volverlo a llamar            
       if(archivoTemp.exists()&& archivoOriginal.exists()){
         archivoOriginal.delete();
         archivoTemp.renameTo(new File(".\\Archivos\\Departamento.txt"));
       }      
    }  
}



