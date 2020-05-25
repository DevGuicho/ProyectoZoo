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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.*;
import vista.ReporteVisitaMedica;

/**
 *
 * @author beatl
 */
public class ctrlReporteVisitaMedica implements ActionListener, MouseListener {
    
    private ReporteVisitaMedica rvm;
    private ArrayList<Veterinario> veterinarios;
    private ArrayList<Animal> animales;
    private RevisaAnimal ra;
    private Animal a;
    private Veterinario v;
    
    private Color verdeOn;
    private Color verdePrincipal;
    private Font fontOn;
    private Font fontNormal;

    public ctrlReporteVisitaMedica(ReporteVisitaMedica rvm) {
        this.rvm = rvm;
        iniComponents();
        this.ra = new RevisaAnimal();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == rvm.btnLimpiar){
            limpiar();
        }else if(ae.getSource() == rvm.btnGuardar){
            getRevisiones();
            if(Sql.reporteVisitaMedica(ra)){
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
        if (me.getSource() == rvm.btnGuardar){
            rvm.btnGuardar.setFont(fontOn);
        }else if(me.getSource() == rvm.btnLimpiar){
            rvm.btnLimpiar.setFont(fontOn);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == rvm.btnGuardar){
            rvm.btnGuardar.setFont(fontNormal);
        }else if(me.getSource() == rvm.btnLimpiar){
            rvm.btnLimpiar.setFont(fontNormal);
        }    
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == rvm.btnGuardar){
            rvm.btnGuardar.setBackground(verdeOn);
        }else if(me.getSource() == rvm.btnLimpiar){
            rvm.btnLimpiar.setBackground(verdeOn);
        }    
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == rvm.btnGuardar){
            rvm.btnGuardar.setBackground(verdePrincipal);
        }else if(me.getSource() == rvm.btnLimpiar){
            rvm.btnLimpiar.setBackground(verdePrincipal);
        }    
    }
    
    private void iniComponents(){
        this.rvm.btnGuardar.addActionListener(this);
        this.rvm.btnLimpiar.addActionListener(this);
        
        this.rvm.btnGuardar.addMouseListener(this);
        this.rvm.btnLimpiar.addMouseListener(this);
        
        this.verdeOn = new Color(0, 212, 72);
        this.verdePrincipal = new Color(0, 179, 61);

        this.fontOn = new Font("Segoe UI", Font.PLAIN, 11);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);

        iniComboBoxes();
    }

    private void iniComboBoxes() {
        DefaultComboBoxModel cmbVeterinarioAux = new DefaultComboBoxModel();
        cmbVeterinarioAux.addElement("Seleccione una opción");
        
        veterinarios = Sql.verVeterinarios();
        
        for (int i = 0; i < veterinarios.size(); i++) {
            cmbVeterinarioAux.addElement(veterinarios.get(i));
        }
        
        this.rvm.cmbVeterinario.setModel(cmbVeterinarioAux);
        
        
        DefaultComboBoxModel cmbAnimalAux = new DefaultComboBoxModel();
        cmbAnimalAux.addElement("Seleccione una opción");
        
        animales = Sql.verAnimales();
        
        for (int i = 0; i < animales.size(); i++) {
            cmbAnimalAux.addElement(animales.get(i));
        }
        
        this.rvm.cmbAnimal.setModel(cmbAnimalAux);
    }
    
    private void getRevisiones(){
        if(rvm.cmbVeterinario.getSelectedIndex()>0){
            v = (Veterinario) rvm.cmbVeterinario.getSelectedItem();
        }
        ra.setVeterinarioId(v.getId());
        
        if(rvm.cmbAnimal.getSelectedIndex()>0){
            a = (Animal) rvm.cmbAnimal.getSelectedItem();
        }
        ra.setAnimalId(a.getId());
        
        Date FechaRevision = new Date(); 
        ra.setFechaRevision(FechaRevision); 
        
        ra.setObservaciones(rvm.txtObservaciones.getText());
    }
    
    private void limpiar(){
    rvm.cmbAnimal.setSelectedIndex(0);
    rvm.cmbVeterinario.setSelectedIndex(0);
    rvm.txtObservaciones.setText(null);
    }
}
