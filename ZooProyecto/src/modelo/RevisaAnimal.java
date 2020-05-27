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
public class RevisaAnimal {
    
    private int id;
    private int veterinarioId;
    private int animalId;
    private String observaciones;
    private String nombreVeterinario;
    private String nombre2Veterinario;
    private String apellidoVeterinario;
    private String apellido2Veterinario;
    private String nombreAnimal;
    private String especieAnimal;
    private float pesoAnimal;
    private Date fechaRevision;
    private String fechaRev;
    
    public RevisaAnimal(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(int veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNombreVeterinario() {
        return nombreVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }

    public String getApellidoVeterinario() {
        return apellidoVeterinario;
    }

    public void setApellidoVeterinario(String apellidoVeterinario) {
        this.apellidoVeterinario = apellidoVeterinario;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getEspecieAnimal() {
        return especieAnimal;
    }

    public void setEspecieAnimal(String especieAnimal) {
        this.especieAnimal = especieAnimal;
    }

    public float getPesoAnimal() {
        return pesoAnimal;
    }

    public void setPesoAnimal(float pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    public String getNombre2Veterinario() {
        return nombre2Veterinario;
    }

    public void setNombre2Veterinario(String nombre2Veterinario) {
        this.nombre2Veterinario = nombre2Veterinario;
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

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getFechaRev() {
        return fechaRev;
    }

    public void setFechaRev(String fechaRev) {
        this.fechaRev = fechaRev;
    }

   

    
    
    
    @Override
    public String toString() {
        return "RevisaAnimal{" + "id=" + id + ", veterinarioId=" + veterinarioId + ", animalId=" + animalId + '}';
    }
    
    
}
