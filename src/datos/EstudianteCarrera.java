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
 * @author Lawdee N. Narváez B.
 */
public class EstudianteCarrera {
    
  private ConexionGenerica cnn;
  
    public EstudianteCarrera () {
        
    }//Fin de constructor
    
    public ArrayList<StudentGrade> leerEstudiantesCarrera (String DptName) 
                                   throws java.lang.ClassNotFoundException,
                                   java.lang.InstantiationException,
                                   java.lang.IllegalAccessException,
                                   java.sql.SQLException
    {
        
      cnn = new MS_SQLServer ();
      boolean rst;
      ArrayList<StudentGrade> lstStudent = new ArrayList<>();
      
      /*Esta vez la sentencia es una cadena que invoca un procedimiento 
        que contiene como parámetro el nombre del departamento para extraer */
        String sql = "{CALL usp_EstudianteCarrera (?)}";
        //Invocar a instancia de la clase CallableStatement que ejecuta consulta
        CallableStatement stmt = cnn.conexion.prepareCall(sql);
        
        //Definir el parámetro del procedimiento almacenado
        stmt.setString(1, DptName);
        //Hacer la ejecución del procedimiento almacenado
        rst = stmt.execute();        
        
        //Procesar los datos del procedimiento si se realizo con exito la sql
        if (rst) {
        //Obtener el resultset obtenido de la consulta
         cnn.resultado = stmt.getResultSet();
         //Llevar a cabo el procesamiento de los registros obtenidos
         while (cnn.resultado.next()) {
             //Acceder al valor de cada fila obtenida en el resultset
             StudentGrade student = new StudentGrade ();
             student.setLicense(cnn.resultado.getString("carnet"));
             student.setStudentName(cnn.resultado.getString("nombres"));
             student.setStudentLastName(cnn.resultado.getString("apellidos"));
             student.setNivel(cnn.resultado.getInt("anio"));
             student.setCareer(cnn.resultado.getString("carrera"));
             lstStudent.add(student); //Agregar el registro a la lista
         }//Fin de la instrucción While
         //Cerrar el resulset y liberar recursos de la base de datos
         cnn.resultado.close();
        }//Fin de condicional if
        //Cerrar el objeto CallableStatement y liberar recursos
        stmt.close();
        //Retornar el ArrayList del reporte
        return lstStudent;        
    }//Fin del espacio
    
    
}//Fin de la clase
