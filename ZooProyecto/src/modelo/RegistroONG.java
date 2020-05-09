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
public class RegistroONG {
    private int actividadId;
    private int habitatId;
    private String aprobacion;
    private String ongNombre;
    private String nombreActividad;
    private String descripcionActividad;
    private Date fechaSolicitud;
    private String horaApertura;
    private String horaCierre;
    
    public RegistroONG(){
        
    }

    public int getActividadId() {
        return actividadId;
    }

    public void setActividadId(int actividadId) {
        this.actividadId = actividadId;
    }

    public int getHabitatId() {
        return habitatId;
    }

    public void setHabitatId(int habitatId) {
        this.habitatId = habitatId;
    }

    public String getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(String aprobacion) {
        this.aprobacion = aprobacion;
    }

    public String getOngNombre() {
        return ongNombre;
    }

    public void setOngNombre(String ongNombre) {
        this.ongNombre = ongNombre;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date  fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    @Override
    public String toString() {
        return "RegistroONG{" + "ongNombre=" + ongNombre + ", nombreActividad=" + nombreActividad + '}';
    }
    
    
}