/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.*;
import vista.RegistroActividades;

/**
 *
 * @author beatl
 */
public class ctrlRegistroActividades implements ActionListener, MouseListener{
    
    private RegistroActividades ra;
    private RegistroONG rong;
    private Habitat ht;
    private Habitat h;
    private Sql ch;
    private Sql ca;
 
    private Color verdeOn;
    private Color verdePrincipal;
    private Font fontOn;
    private Font fontNormal;
    
    

    public ctrlRegistroActividades(RegistroActividades ra) {
        this.ra = ra;
        iniComponents();
        this.rong = new RegistroONG();
        this.ht = new Habitat();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == ra.btnLimpiar){
            limpiar();
        }else if(ae.getSource() == ra.btnGuardar){
            getActividad();
            getActividadDias();
            if(Sql.registrarActividad(rong,ht)){
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                 limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Registro Fallido");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
       if (me.getSource() == ra.btnGuardar){
            ra.btnGuardar.setFont(fontOn);
        }else if(me.getSource() == ra.btnLimpiar){
            ra.btnLimpiar.setFont(fontOn);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       if (me.getSource() == ra.btnGuardar){
            ra.btnGuardar.setFont(fontNormal);
        }else if(me.getSource() == ra.btnLimpiar){
            ra.btnLimpiar.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == ra.btnGuardar){
            ra.btnGuardar.setBackground(verdeOn);
        }else if(me.getSource() == ra.btnLimpiar){
            ra.btnLimpiar.setBackground(verdeOn);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == ra.btnGuardar){
            ra.btnGuardar.setBackground(verdePrincipal);
        }else if(me.getSource() == ra.btnLimpiar){
            ra.btnLimpiar.setBackground(verdePrincipal);
        }
    }
    
     private void iniComponents(){
        this.ra.btnGuardar.addActionListener(this);
        this.ra.btnLimpiar.addActionListener(this);
        
        this.ra.btnGuardar.addMouseListener(this);
        this.ra.btnLimpiar.addMouseListener(this);
        
        this.verdeOn = new Color(0, 212, 72);
        this.verdePrincipal = new Color(0, 179, 61);

        this.fontOn = new Font("Segoe UI", Font.PLAIN, 11);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);

        iniComboBoxes();
        
    }
    
    private void iniComboBoxes(){
        this.ra.cmbAprobacion.addItem("Seleccione una opción");
        this.ra.cmbAprobacion.addItem("Aprobado");
        this.ra.cmbAprobacion.addItem("No Aprobado");
        
        DefaultComboBoxModel cmbHabitatAux = new DefaultComboBoxModel();
        //cmbHabitatAux.addElement("Seleccione habitat");
        
        for (int i = 0; i < ch.verHabitat().size(); i++) {
            cmbHabitatAux.addElement(ch.verHabitat().get(i));
        }
        
        
       for (int j = 0; j < ca.verActividades().size(); j++) {
            for (int i = 0; i < ch.verHabitat().size(); i++) {
                if(ca.verActividades().get(j).getHabitatId() == ch.verHabitat().get(i).getId()){
                    cmbHabitatAux.removeElementAt(i);
                }
            }
        }
 
       this.ra.cmbHabitat.setModel(cmbHabitatAux);   
    }
   
    
    private void getActividad(){
       Date FechaSolicitud = new Date();
       rong.setFechaSolicitud(FechaSolicitud);
       rong.setOngNombre(ra.txtNombreONG.getText());
       rong.setNombreActividad(ra.txtNombreActividad.getText());
       rong.setDescripcionActividad(ra.txtDescripcion.getText());
       rong.setAprobacion((String) ra.cmbAprobacion.getSelectedItem());
       rong.setHoraApertura(ra.txtHoraApertura.getText());
       rong.setHoraCierre(ra.txtHoraCierre.getText());
       h = (Habitat) ra.cmbHabitat.getSelectedItem();
       rong.setHabitatId(h.getId());
       ra.cmbHabitat.removeItem(ra.cmbHabitat.getSelectedItem());
    }
    
    private void getActividadDias(){
        ArrayList<String> DiasAux = new ArrayList(); 
        if(ra.ckbMartes.isSelected()){
            DiasAux.add(ra.ckbMartes.getText());
        }
        if(ra.ckbMiercoles.isSelected()){
            DiasAux.add(ra.ckbMiercoles.getText());
        }
        if(ra.ckbJueves.isSelected()){
            DiasAux.add(ra.ckbJueves.getText());
        }
        if(ra.ckbViernes.isSelected()){
            DiasAux.add(ra.ckbViernes.getText());
        }
        if(ra.ckbSabado.isSelected()){
            DiasAux.add(ra.ckbSabado.getText());
        }
        if(ra.ckbDomingo.isSelected()){
            DiasAux.add(ra.ckbDomingo.getText());
        }
        
        ht.setDiasActividad(DiasAux);
    }
    
    private void limpiar(){
    ra.txtNombreONG.setText(null);
    ra.txtNombreActividad.setText(null);
    ra.txtHoraApertura.setText(null);
    ra.txtDescripcion.setText(null);
    ra.cmbHabitat.setSelectedIndex(0);
    ra.cmbAprobacion.setSelectedIndex(0);
    ra.txtHoraApertura.setText(null);
    ra.txtHoraCierre.setText(null);
    ra.ckbDomingo.setSelected(false);
    ra.ckbMartes.setSelected(false);
    ra.ckbMiercoles.setSelected(false);
    ra.ckbJueves.setSelected(false);
    ra.ckbViernes.setSelected(false);
    ra.ckbSabado.setSelected(false);
    }
    
}
