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
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.*;
import vista.RegistroAnimales;

/**
 *
 * @author beatl
 */
public class ctrlRegistroAnimales implements ActionListener, MouseListener{
    
    private RegistroAnimales ra;
    private String procedencia;
    private Color verdeOn;
    private Color verdePrincipal;
    private Font fontOn;
    private Font fontNormal;
    private Slide sl;
    private DefaultComboBoxModel dcbm;
    private ArrayList<Cuidador> cuidadores;
    private ArrayList<Habitat> habitats;
    private ArrayList<Veterinario> veterinarios;
    private Animal ani;
    private Habitat h;
    private Cuidador c;
    private Veterinario v;
    
    public ctrlRegistroAnimales(RegistroAnimales ra) {
        this.ra = ra;
        this.ani = new Animal();
        iniComponents();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ra.btnGuardar){
            guardar();
        }else if (e.getSource() == ra.btnLimpiar){
            limpiar();
        }else if(e.getSource() == ra.btnProcedenciaLocal){
            ra.pnlLocal.setVisible(true);
            ra.pnlRescate.setVisible(false);
            ra.pnlForanea.setVisible(false);
            procedencia = "Local";
        }else if(e.getSource() == ra.btnProcedenciaRescate){
            ra.pnlLocal.setVisible(false);
            ra.pnlRescate.setVisible(true);
            ra.pnlForanea.setVisible(false);
            procedencia = "Rescate";
        }else if(e.getSource() == ra.btnProcedenciaForanea){
            ra.pnlLocal.setVisible(false);
            ra.pnlRescate.setVisible(false);
            ra.pnlForanea.setVisible(true);
            procedencia = "Foranea";
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == ra.btnLimpiar){
            ra.btnLimpiar.setFont(fontOn);
        }else if(e.getSource() == ra.btnGuardar){
            ra.btnGuardar.setFont(fontOn);
        }
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == ra.btnLimpiar){
            ra.btnLimpiar.setFont(fontNormal);
        }else if(e.getSource() == ra.btnGuardar){
            ra.btnGuardar.setFont(fontNormal);
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == ra.btnGuardar){
            ra.btnGuardar.setBackground(verdeOn);
        }else if(e.getSource() == ra.btnLimpiar){
            ra.btnLimpiar.setBackground(verdeOn);
        }else if(e.getSource() == ra.btnProcedenciaForanea){
            ra.btnProcedenciaForanea.setBackground(verdeOn);
        }else if(e.getSource() == ra.btnProcedenciaLocal){
            ra.btnProcedenciaLocal.setBackground(verdeOn);
        }else if(e.getSource() == ra.btnProcedenciaRescate){
            ra.btnProcedenciaRescate.setBackground(verdeOn);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == ra.btnGuardar){
            ra.btnGuardar.setBackground(verdePrincipal);
        }else if(e.getSource() == ra.btnLimpiar){
            ra.btnLimpiar.setBackground(verdePrincipal);
        }else if(e.getSource() == ra.btnProcedenciaForanea){
            ra.btnProcedenciaForanea.setBackground(verdePrincipal);
        }else if(e.getSource() == ra.btnProcedenciaLocal){
            ra.btnProcedenciaLocal.setBackground(verdePrincipal);
        }else if(e.getSource() == ra.btnProcedenciaRescate){
            ra.btnProcedenciaRescate.setBackground(verdePrincipal);
        }
    }
    private void limpiar(){
        ra.txtAlimentacion.setText(null);
        ra.txtAniosCautiverio.setText(null);
        ra.txtEdad.setText(null);;
        ra.txtEspecie.setText(null);
        ra.txtNombre.setText(null);
        ra.txtEdadRescate.setText(null);
        ra.txtNombreZoologico.setText(null);
        ra.txtObservaciones.setText(null);
        ra.txtPeso.setText(null);
        ra.txtPesoNacimiento.setText(null);
        ra.cmbCuidador.setSelectedIndex(0);
        ra.cmbHabitat.setSelectedIndex(0);
        ra.cmbSexo.setSelectedIndex(0);
        ra.cmbVeterinarioNacimeinto.setSelectedIndex(0);
    }
    private void iniComponents(){
        this.ra.btnProcedenciaForanea.addActionListener(this);
        this.ra.btnProcedenciaLocal.addActionListener(this);
        this.ra.btnProcedenciaRescate.addActionListener(this);
        this.ra.btnGuardar.addActionListener(this);
        this.ra.btnLimpiar.addActionListener(this);

        this.ra.btnGuardar.addMouseListener(this);
        this.ra.btnLimpiar.addMouseListener(this);
        this.ra.btnProcedenciaForanea.addMouseListener(this);
        this.ra.btnProcedenciaLocal.addMouseListener(this);
        this.ra.btnProcedenciaRescate.addMouseListener(this);
       
        ra.pnlLocal.setVisible(false);
        ra.pnlRescate.setVisible(false);
        ra.pnlForanea.setVisible(false);

        this.verdeOn = new Color(0, 212, 72);
        this.verdePrincipal = new Color(0, 179, 61);

        this.fontOn = new Font("Segoe UI", Font.PLAIN, 11);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);
        sl = new Slide();
        
        iniComboBoxes();
    }
    
    private void iniComboBoxes(){
        
        this.ra.cmbSexo.addItem("Seleccione Sexo");
        this.ra.cmbSexo.addItem("Hembra");
        this.ra.cmbSexo.addItem("Macho");
        this.ra.cmbCondicionRescate.addItem("Seleccione Condicion");
        this.ra.cmbCondicionRescate.addItem("Buena");
        this.ra.cmbCondicionRescate.addItem("Mala");
        
        
        dcbm = new DefaultComboBoxModel();
        dcbm.addElement("Seleccione Habitat");
        habitats = Sql.verHabitat();
    
        Iterator<Habitat> ih = habitats.iterator();
        Habitat h;
        while(ih.hasNext()){
            h = ih.next();
            dcbm.addElement(h);    
            
        }
        this.ra.cmbHabitat.setModel(dcbm);
        
        dcbm = new DefaultComboBoxModel();
        dcbm.addElement("Seleccione Cuidador");
        cuidadores = Sql.verCuidadores();
    
        Iterator<Cuidador> ic = cuidadores.iterator();
        Cuidador c;
        while(ic.hasNext()){
            c = ic.next();
            dcbm.addElement(c);    
            
        }
        this.ra.cmbCuidador.setModel(dcbm);
        
        dcbm = new DefaultComboBoxModel();
        dcbm.addElement("Seleccione Veterinario");
        veterinarios = Sql.verVeterinarios();
    
        Iterator<Veterinario> iv = veterinarios.iterator();
        Veterinario v;
        while(iv.hasNext()){
            v = iv.next();
            dcbm.addElement(v);    
            
        }
        this.ra.cmbVeterinarioNacimeinto.setModel(dcbm);
    }
    
    private void guardar(){
        h = (Habitat)ra.cmbHabitat.getSelectedItem();
        c = (Cuidador) ra.cmbCuidador.getSelectedItem();
        v = (Veterinario) ra.cmbVeterinarioNacimeinto.getSelectedItem();
        ani.setNombre(ra.txtNombre.getText());
        ani.setPeso(Float.parseFloat(ra.txtPeso.getText()));
        ani.setEdad(Integer.parseInt(ra.txtEdad.getText()));
        ani.setSexo(ra.cmbSexo.getSelectedItem().toString().charAt(0)+"");
        ani.setEspecie(ra.txtEspecie.getText());
        ani.setAnyoCautiverio(Integer.parseInt(ra.txtAniosCautiverio.getText()));
        ani.setAlimentacion(ra.txtAlimentacion.getText());
        ani.setIdHabitat(h.getId());
        ani.setIdCuidador(c.getId());
        ani.setObservaciones(ra.txtObservaciones.getText());
        
        if(procedencia.equals("Local")){
            ani.setIdVeterinario(v.getId());
            ani.setFechaNacimiento(ra.cldFechaNacimientos.getDate());
            ani.setPesoNacimientp(Float.parseFloat(ra.txtPesoNacimiento.getText()));
            ani.setProcedencia(1);
            
        }else if(procedencia.equals("Rescate")){
            ani.setFechaRescate(ra.cldFechaRescate.getDate());
            ani.setEdadRescate(Integer.parseInt(ra.txtEdadRescate.getText()));
            ani.setCondicion(ra.cmbCondicionRescate.getSelectedItem().toString());
            ani.setProcedencia(2);
        }else {
            ani.setNombreZoologico(ra.txtNombreZoologico.getText());
            ani.setFechaTraslado(ra.cldFechaTraslado.getDate());
            ani.setProcedencia(3);
        }
        
        if(Sql.registrarAnimal(ani)){
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        }else{
            JOptionPane.showMessageDialog(null, "Registro Fallido");
        }
    }
}
