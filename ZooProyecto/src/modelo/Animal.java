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
public class Animal {
    
    private int id;
    private String nombre;
    private String nombreCuidador;
    private String nombreHabitat;
    private float peso;
    private int edad;
    private String sexo;
    private String especie;
    private int anyoCautiverio;
    private String alimentacion;
    private String observaciones;
    private int idCuidador;
    private int procedencia;
    private String nombreZoologico;
    private Date fechaTraslado;
    private int edadRescate;
    private String condicion;
    private Date fechaRescate;
    private Date fechaNacimiento;
    private float pesoNacimientp;
    private int idVeterinario;
    private int idHabitat;

    public Animal() {
        
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getAnyoCautiverio() {
        return anyoCautiverio;
    }

    public void setAnyoCautiverio(int anyoCautiverio) {
        this.anyoCautiverio = anyoCautiverio;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    public int getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(int procedencia) {
        this.procedencia = procedencia;
    }

    public String getNombreZoologico() {
        return nombreZoologico;
    }

    public void setNombreZoologico(String nombreZoologico) {
        this.nombreZoologico = nombreZoologico;
    }

    public java.sql.Date getFechaTraslado() {
        return new java.sql.Date(((Date) fechaTraslado).getTime());
    }

    public void setFechaTraslado(Date fechaTraslado) {
        this.fechaTraslado = fechaTraslado;
    }

    public int getEdadRescate() {
        return edadRescate;
    }

    public void setEdadRescate(int edadRescate) {
        this.edadRescate = edadRescate;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public java.sql.Date getFechaRescate() {
        return new java.sql.Date(((Date) fechaRescate).getTime());
    }

    public void setFechaRescate(Date fechaRescate) {
        this.fechaRescate = fechaRescate;
    }

    public java.sql.Date getFechaNacimiento() {
        return new java.sql.Date(((Date) fechaNacimiento).getTime());
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getPesoNacimientp() {
        return pesoNacimientp;
    }

    public void setPesoNacimientp(float pesoNacimientp) {
        this.pesoNacimientp = pesoNacimientp;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public int getIdHabitat() {
        return idHabitat;
    }

    public void setIdHabitat(int idHabitat) {
        this.idHabitat = idHabitat;
    }

    public String getNombreCuidador() {
        return nombreCuidador;
    }

    public void setNombreCuidador(String nombreCuidador) {
        this.nombreCuidador = nombreCuidador;
    }

    public String getNombreHabitat() {
        return nombreHabitat;
    }

    public void setNombreHabitat(String nombreHabitat) {
        this.nombreHabitat = nombreHabitat;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    
    
}
