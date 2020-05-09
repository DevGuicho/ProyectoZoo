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
    private Date fechaRevision;
    
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

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    @Override
    public String toString() {
        return "RevisaAnimal{" + "id=" + id + ", veterinarioId=" + veterinarioId + ", animalId=" + animalId + ", fechaRevision=" + fechaRevision + '}';
    }
    
    
}
