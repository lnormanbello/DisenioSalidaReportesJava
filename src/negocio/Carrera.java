/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.BD_Carrera;
import java.util.ArrayList;

/**
 *
 * @author lnarvaezb
 */
public class Carrera {
    /* Variables de instancia */
    private String codigo;
    private String carrera;
    private int planEst;
    private String observacion;
    private int estado;

    public Carrera(String codigo, String carrera, int planEst, String observacion, int estado) {
        this.codigo = codigo;
        this.carrera = carrera;
        this.planEst = planEst;
        this.observacion = observacion;
        this.estado = estado;
    }

    public Carrera() {
    }
    
    public ArrayList<String> listar () throws java.lang.ClassNotFoundException,
                                              java.lang.InstantiationException,
                                              java.lang.IllegalAccessException,
                                              java.sql.SQLException
    {        
        BD_Carrera carr = new BD_Carrera ();
        return carr.leerCarrera();
    }
    
}//Fin de la clase
