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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
    private ArrayList<RevisaAnimal> visitas;
    DefaultComboBoxModel dcm;
    DefaultComboBoxModel dcm2;
    private int opcion;
    private ArrayList<String> options;
    
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
            if(verificarCampos()){
            getRevisiones();
            if(Sql.reporteVisitaMedica(ra)){
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                 limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Registro Fallido");
            }
            }
        }else if(ae.getSource() == rvm.cmbSeleccion){
            ComboSeleccion();
        }else if(ae.getSource() == rvm.cmbOpcion){
            if(rvm.cmbOpcion.getSelectedIndex() != 0 && rvm.cmbSeleccion.getSelectedIndex() != 3){
                Tabla(rvm.cmbOpcion.getSelectedItem().toString(),rvm.cmbSeleccion.getSelectedIndex());
            }else if(rvm.cmbOpcion.getSelectedIndex() != 0 && rvm.cmbSeleccion.getSelectedIndex() == 3){
                v = (Veterinario) rvm.cmbOpcion.getSelectedItem();
               Tabla2(v.getNombre(),v.getNombre2(),v.getApellido1(),v.getApellido2());
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
        
        this.rvm.cmbSeleccion.addActionListener(this);
        this.rvm.cmbOpcion.addActionListener(this);
        
        this.verdeOn = new Color(0, 212, 72);
        this.verdePrincipal = new Color(0, 179, 61);

        this.fontOn = new Font("Segoe UI", Font.PLAIN, 11);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);
        
        dcm = new DefaultComboBoxModel();
        dcm2 = new DefaultComboBoxModel();
        
        dcm.addElement("Seleccione Filtro");
        dcm.addElement("Especie");
        dcm.addElement("Fecha Registro");
        dcm.addElement("Veterinario");
        this.rvm.cmbSeleccion.setModel(dcm);

        dcm2.addElement("Seleccione una opcion");
        this.rvm.cmbOpcion.setModel(dcm2);
        
        iniComboBoxes();
        Tabla("todos",0);
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
    
    private void ComboSeleccion(){
        if(rvm.cmbSeleccion.getSelectedIndex() > 0 && rvm.cmbSeleccion.getSelectedIndex() != 3){
            opcion = rvm.cmbSeleccion.getSelectedIndex();
            ComboOpcion(opcion);
        }else if(rvm.cmbSeleccion.getSelectedIndex() == 0){
                while(dcm2.getSize()>1){
                    dcm2.removeElementAt(1);
                } 
        }else if(rvm.cmbSeleccion.getSelectedIndex() == 3){
            ComboOpcionVeterinario();
        }
        
        Tabla("todos",0);
    }
    
    private void ComboOpcion(int opcion){
         while(dcm2.getSize()>1){
                dcm2.removeElementAt(1);
        } 
        
        options = Sql.filtroVisitas(opcion);
        
        for (int i = 0; i < options.size() ; i++) {
            dcm2.addElement(options.get(i));
        }
        
        this.rvm.cmbOpcion.setModel(dcm2);
    }
    
    private void ComboOpcionVeterinario(){
        while(dcm2.getSize()>1){
                dcm2.removeElementAt(1);
        } 
        
        veterinarios = Sql.verVeterinarios();
        
        for (int i = 0; i < veterinarios.size(); i++) {
            dcm2.addElement(veterinarios.get(i));
        }
        
        this.rvm.cmbOpcion.setModel(dcm2);
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
    
    private void Tabla(String seleccion, int indice){
        Vector vec = new Vector();

        String [] titulos = {"Veterinario", "Animal", "Especie Animal", "Peso Animal", "Observaciones", "Fecha de Registro"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        visitas = Sql.verVisitas(seleccion, indice);
        
        for (int i = 0; i < visitas.size(); i++) {
            vec = new Vector();
            String nombre1 = visitas.get(i).getNombreVeterinario();
            String nombre2 = visitas.get(i).getNombre2Veterinario();
            String apellido1 = visitas.get(i).getApellidoVeterinario();
            String apellido2 = visitas.get(i).getApellido2Veterinario();
            
            vec.add(nombre1+" "+nombre2+" "+apellido1+" "+apellido2);
            vec.add(visitas.get(i).getNombreAnimal());
            vec.add(visitas.get(i).getEspecieAnimal());
            vec.add(visitas.get(i).getPesoAnimal());
            vec.add(visitas.get(i).getObservaciones());
            vec.add(sdf.format(visitas.get(i).getFechaRevision()));
            
            dtm.addRow(vec);
            
        }
        this.rvm.tblRevisionMedica.setModel(dtm);
        this.rvm.tblRevisionMedica.setEnabled(false);
    }
    
     private void Tabla2(String nom1,String nom2,String ap1, String ap2){
        Vector vec = new Vector();

        String [] titulos = {"Veterinario", "Animal", "Especie Animal", "Peso Animal", "Observaciones", "Fecha de Registro"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        visitas = Sql.verVisitaVeterinario(nom1,nom2,ap1,ap2);
        for (int i = 0; i < visitas.size(); i++) {
            vec = new Vector();
            String nombre1 = visitas.get(i).getNombreVeterinario();
            String nombre2 = visitas.get(i).getNombre2Veterinario();
            String apellido1 = visitas.get(i).getApellidoVeterinario();
            String apellido2 = visitas.get(i).getApellido2Veterinario();
            
            vec.add(nombre1+" "+nombre2+" "+apellido1+" "+apellido2);
            vec.add(visitas.get(i).getNombreAnimal());
            vec.add(visitas.get(i).getEspecieAnimal());
            vec.add(visitas.get(i).getPesoAnimal());
            vec.add(visitas.get(i).getObservaciones());
            vec.add(sdf.format(visitas.get(i).getFechaRevision()));
            
            dtm.addRow(vec);
            
        }
        this.rvm.tblRevisionMedica.setModel(dtm);
        this.rvm.tblRevisionMedica.setEnabled(false);
    }
     
    private void limpiar(){
    rvm.cmbAnimal.setSelectedIndex(0);
    rvm.cmbVeterinario.setSelectedIndex(0);
    rvm.txtObservaciones.setText(null);
    rvm.cmbSeleccion.setSelectedIndex(0);
    rvm.cmbOpcion.setSelectedIndex(0);
    }
    
    public boolean verificarCampos(){
        if(rvm.cmbAnimal.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Selecciona un animal");
            return false;
        }else if(rvm.cmbVeterinario.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Selecciona un veterinario");
            return false;
        }else if(rvm.txtObservaciones.getText() == null){
            JOptionPane.showMessageDialog(null, "Ingresa las observaciones");
            return false;
        }else{
            return false;
        }
    }

}
