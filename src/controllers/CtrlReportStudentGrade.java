/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import negocio.StudentGrade;

/**
 *
 * @author lnarvaezb
 */
public class CtrlReportStudentGrade {
    
   public static ArrayList <StudentGrade> listarStudentGrade (String filtre)
                                       throws java.lang.ClassNotFoundException,
                                       java.lang.InstantiationException,
                                       java.lang.IllegalAccessException,
                                       java.sql.SQLException
   {
       StudentGrade sg = new StudentGrade ();
       return sg.listar(filtre);
   }//Fin de método
   
}//Fin de la clase
