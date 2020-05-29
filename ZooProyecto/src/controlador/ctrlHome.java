/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import modelo.Reloj;
import modelo.Sql;
import modelo.UltimosRegistros;
import vista.Home;

/**
 *
 * @author beatl
 */
public class ctrlHome implements ActionListener {

    private Home h;
    private Reloj r;
    private UltimosRegistros ur = new UltimosRegistros();

    public ctrlHome(Home h) {
        this.h = h;
        this.r = new Reloj(h.lblClock);
        iniComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void iniComponents() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Sql.ultimaVisitaMedica(ur);
        h.lblVeterinario.setText(ur.getNombreVeterinario() + " " + ur.getApellido1Veterinario() + " " + ur.getApellido2Veterinario());
        h.lblAnimalRevisado.setText(ur.getNombreAnimal());
        h.lblFechaVisita.setText(sdf.format(ur.getFechaRevision()));
        Sql.ultimoRegistroTempHum(ur);
        h.lblTemperatura.setText(String.valueOf(ur.getTemperatura())+" °C");
        h.lblHumedad.setText(String.valueOf(ur.getHumedad())+" %");
        h.lblHabitat.setText(ur.getNombreHabitat());
        h.lblFechaRegistro.setText(sdf.format(ur.getFechaRegistro()));
        Sql.ultimaActividad(ur);
        h.lblNombreActividad.setText(ur.getNombreActividad());
        h.lblNombreONG.setText(ur.getNombreONG());
        h.lblNombreHabAct.setText(ur.getNombreActHabitat());
    }

    public Reloj getR() {
        return r;
    }

    public void setR(Reloj r) {
        this.r = r;
    }

}
