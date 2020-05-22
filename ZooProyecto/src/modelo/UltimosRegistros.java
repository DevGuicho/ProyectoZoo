/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;




/**
 *
 * @author beatl
 */
public class UltimosRegistros {
    // ATRIBUTOS PARA ULTIMA VISITA MEDICA 
    private int idRevision;
    private String nombreVeterinario;
    private String apellido1Veterinario;
    private String apellido2Veterinario;
    private String nombreAnimal;
    private Date fechaRevision;
    //ATRIBUTOS PARA ULTIMO REGISTRO DE TEMPERATURA Y HUMEDAD
    private float temperatura;
    private float humedad;
    private String nombreHabitat;
    private Date fechaRegistro;
    //ATRIBUTO PARA ULTIMA ACTIVIDAD REGISTRADA
    private String nombreActividad;
    private String nombreONG;
    private String nombreActHabitat;

    public int getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }

    public String getNombreVeterinario() {
        return nombreVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }

    public String getApellido1Veterinario() {
        return apellido1Veterinario;
    }

    public void setApellido1Veterinario(String apellido1Veterinario) {
        this.apellido1Veterinario = apellido1Veterinario;
    }

    public String getApellido2Veterinario() {
        return apellido2Veterinario;
    }

    public void setApellido2Veterinario(String apellido2Veterinario) {
        this.apellido2Veterinario = apellido2Veterinario;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(java.sql.Date fechaRevision) {
        
        this.fechaRevision = (java.util.Date) fechaRevision;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getHumedad() {
        return humedad;
    }

    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }

    public String getNombreHabitat() {
        return nombreHabitat;
    }

    public void setNombreHabitat(String nombreHabitat) {
        this.nombreHabitat = nombreHabitat;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(java.sql.Date fechaRegistro) {
        this.fechaRegistro = (java.util.Date) fechaRegistro;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getNombreONG() {
        return nombreONG;
    }

    public void setNombreONG(String nombreONG) {
        this.nombreONG = nombreONG;
    }

    public String getNombreActHabitat() {
        return nombreActHabitat;
    }

    public void setNombreActHabitat(String nombreActHabitat) {
        this.nombreActHabitat = nombreActHabitat;
    }
    
    
}
