/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author beatl
 */
public class Clima {
    
    private int id;
    private String nombre;
    private int humedadMin;
    private int humedadMax;
    private int temperaturaMin;
    private int temperaturaMax;
    
    public Clima(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHumedadMin() {
        return humedadMin;
    }

    public void setHumedadMin(int humedadMin) {
        this.humedadMin = humedadMin;
    }

    public int getHumedadMax() {
        return humedadMax;
    }

    public void setHumedadMax(int humedadMax) {
        this.humedadMax = humedadMax;
    }

    public int getTemperaturaMin() {
        return temperaturaMin;
    }

    public void setTemperaturaMin(int temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public int getTemperaturaMax() {
        return temperaturaMax;
    }

    public void setTemperaturaMax(int temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

   
    

    @Override
    public String toString() {
        return ""+ nombre ;
    }
    
    
}
