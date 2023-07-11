/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import negocio.Carrera;

/**
 *
 * @author Lawdee Norman Narváez B.
 */
public class CtrlListCarrera {
    
    public static ArrayList<String> leer () throws java.lang.ClassNotFoundException,
                                    java.lang.InstantiationException,
                                    java.lang.IllegalAccessException,
                                    java.sql.SQLException
    {
        Carrera c = new Carrera ();
        return c.listar();
    }
    
}//Fin de la clase
