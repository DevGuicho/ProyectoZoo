/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author beatl
 */
public class Habitat {
    
    private int id;
    private int ClimaId;
    private int CuidadorId;
    private String nombre;
    private ArrayList<String> diasActividad;
    private String disponibilidad;
    
    public Habitat(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClimaId() {
        return ClimaId;
    }

    public void setClimaId(int ClimaId) {
        this.ClimaId = ClimaId;
    }

    public int getCuidadorId() {
        return CuidadorId;
    }

    public void setCuidadorId(int CuidadorId) {
        this.CuidadorId = CuidadorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getDiasActividad() {
        return diasActividad;
    }

    public void setDiasActividad(ArrayList<String> diasActividad) {
        this.diasActividad = diasActividad;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
    @Override
    public String toString() {
        return "" + nombre;
    }
    
    
}
