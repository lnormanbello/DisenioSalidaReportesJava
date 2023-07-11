/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.EstudianteCarrera;
import java.util.ArrayList;

/**
 *
 * @author lnarvaezb
 */
public class StudentGrade {
    private String license;
    private String StudentName;
    private String StudentLastName;
    private int nivel;
    private String career;
    
    public StudentGrade (){
        license = "";
        StudentName = "";
        StudentLastName = "";
        nivel = 0;
        career = "";
    }//Fin constructo

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getStudentLastName() {
        return StudentLastName;
    }

    public void setStudentLastName(String StudentLastName) {
        this.StudentLastName = StudentLastName;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
    
    public ArrayList<StudentGrade> listar (String filter) 
                                        throws java.lang.ClassNotFoundException,
                                        java.lang.InstantiationException,
                                        java.lang.IllegalAccessException,
                                        java.sql.SQLException
    {
        EstudianteCarrera ec = new EstudianteCarrera ();
        return ec.leerEstudiantesCarrera(StudentName);
    } //Fin método
}//Fin de la clase
