/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.CallableStatement;
import java.util.ArrayList;
import negocio.StudentGrade;
import servicios.ConexionGenerica;
import servicios.MS_SQLServer;

/**
 *
 * @author lnarvaezb
 */
public class BD_Carrera {
    
    private ConexionGenerica cnn;

    public BD_Carrera() {
        
    }
    
    public ArrayList<String> leerCarrera () 
                                   throws java.lang.ClassNotFoundException,
                                   java.lang.InstantiationException,
                                   java.lang.IllegalAccessException,
                                   java.sql.SQLException
    {
        
      cnn = new MS_SQLServer ();
      boolean rst;
      ArrayList<String> lstCarrera = new ArrayList<>();
      
      /*Esta vez la sentencia es una cadena que invoca un procedimiento 
        que contiene como parámetro el nombre del departamento para extraer */
        String sql = "{CALL usp_ListCarrera}";
        //Invocar a instancia de la clase CallableStatement que ejecuta consulta
        CallableStatement stmt = cnn.conexion.prepareCall(sql);
        //Hacer la ejecución del procedimiento almacenado
        rst = stmt.execute();
        
        //Procesar los datos del procedimiento si se realizó con exito la sql
        if (rst) {
        //Obtener el resultset obtenido de la consulta
         cnn.resultado = stmt.getResultSet();
         //Llevar a cabo el procesamiento de los registros obtenidos
         while (cnn.resultado.next()) {
             //Acceder al valor de cada fila obtenida en el resultset
             String c = cnn.resultado.getString("nombreCarrera");             
             lstCarrera.add(c); //Agregar el registro a la lista
         }//Fin de la instrucción While
         //Cerrar el resulset y liberar recursos de la base de datos
         cnn.resultado.close();
        }//Fin de condicional if
        //Cerrar el objeto CallableStatement y liberar recursos
        stmt.close();
        //Retornar el ArrayList del reporte
        return lstCarrera;     
    }//Fin del espacio
}//Fi de la clase
