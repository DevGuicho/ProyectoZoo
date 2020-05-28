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
public class Habitats {
    
    private String nombreHabitat;
    private String nombreCuidador;
    private String apellidoCuidador;
    private String clima;
    private int id;
    public String getNombreHabitat() {
        return nombreHabitat;
    }

    public void setNombreHabitat(String nombreHabitat) {
        this.nombreHabitat = nombreHabitat;
    }

    public String getNombreCuidador() {
        return nombreCuidador;
    }

    public void setNombreCuidador(String nombreCuidador) {
        this.nombreCuidador = nombreCuidador;
    }

    public String getApellidoCuidador() {
        return apellidoCuidador;
    }

    public void setApellidoCuidador(String apellidoCuidador) {
        this.apellidoCuidador = apellidoCuidador;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
