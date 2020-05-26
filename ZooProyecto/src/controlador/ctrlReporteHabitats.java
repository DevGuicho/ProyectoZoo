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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Clima;
import modelo.Cuidador;
import modelo.Habitat;
import modelo.Habitats;
import modelo.Sql;
import modelo.UltimosRegistros;
import vista.ReporteHabitats;

/**
 *
 * @author beatl
 */
public class ctrlReporteHabitats implements ActionListener, MouseListener, FocusListener{
    
    private ReporteHabitats rh;
    private Color verdePrincipal;
    private Color verdeOn;
    private Font normal;
    private Font click;
    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcb;
    public ctrlReporteHabitats(ReporteHabitats rh) {
        this.rh = rh;
        iniComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rh.btnGuardar){
            guardar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == rh.txtTemperatura){
            if(rh.txtTemperatura.getText().equals("Temperatura"))
                rh.txtTemperatura.setText(null);
        }else if(e.getSource() == rh.txtHumedad){
            if(rh.txtHumedad.getText().equals("Humedad"))
                rh.txtHumedad.setText(null);
        }else if(e.getSource() == rh.tblHabitats){
            String habitat=rh.tblHabitats.getValueAt(rh.tblHabitats.getSelectedRow(), 0).toString();
            iniTableRegistros(habitat);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == rh.btnGuardar){
            rh.btnGuardar.setFont(click);
        }else if(e.getSource() == rh.btnLimpiar){
            rh.btnLimpiar.setFont(click);
        }else if(e.getSource() == rh.btnGuardar1){
            rh.btnGuardar1.setFont(click);
        }else if(e.getSource() == rh.btnLimpiar1){
            rh.btnLimpiar1.setFont(click);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == rh.btnGuardar){
            rh.btnGuardar.setFont(normal);
        }else if(e.getSource() == rh.btnLimpiar){
            rh.btnLimpiar.setFont(normal);
        }else if(e.getSource() == rh.btnGuardar1){
            rh.btnGuardar1.setFont(normal);
        }else if(e.getSource() == rh.btnLimpiar1){
            rh.btnLimpiar1.setFont(normal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == rh.btnGuardar){
            rh.btnGuardar.setBackground(verdeOn);
        }else if(e.getSource() == rh.btnLimpiar){
            rh.btnLimpiar.setBackground(verdeOn);
        }else if(e.getSource() == rh.btnGuardar1){
            rh.btnGuardar1.setBackground(verdeOn);
        }else if(e.getSource() == rh.btnLimpiar1){
            rh.btnLimpiar1.setBackground(verdeOn);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == rh.btnGuardar){
            rh.btnGuardar.setBackground(verdePrincipal);
        }else if(e.getSource() == rh.btnLimpiar){
            rh.btnLimpiar.setBackground(verdePrincipal);
        }else if(e.getSource() == rh.btnGuardar1){
            rh.btnGuardar1.setBackground(verdePrincipal);
        }else if(e.getSource() == rh.btnLimpiar1){
            rh.btnLimpiar1.setBackground(verdePrincipal);
        }
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource() == rh.txtTemperatura){
            if(rh.txtTemperatura.getText().equals("")){
                rh.txtTemperatura.setText("Temperatura");
            }
        }else if (e.getSource() == rh.txtHumedad){
            if(rh.txtHumedad.getText().equals("")){
                rh.txtHumedad.setText("Humedad");
            }
            
        }
    }
    
    public void iniComponents(){
        this.verdeOn = new Color(0, 102, 102);
        this.verdePrincipal = new Color(0, 51, 51);

        this.click = new Font("Segoe UI", Font.PLAIN, 11);
        this.normal = new Font("Segoe UI", Font.PLAIN, 14);
        
        this.rh.btnGuardar.addActionListener(this);
        this.rh.btnLimpiar.addActionListener(this);
        this.rh.btnGuardar1.addActionListener(this);
        this.rh.btnLimpiar1.addActionListener(this);
          
        this.rh.btnGuardar.addMouseListener(this);
        this.rh.btnLimpiar.addMouseListener(this);
        this.rh.btnGuardar1.addMouseListener(this);
        this.rh.btnLimpiar1.addMouseListener(this);
        this.rh.txtHumedad.addMouseListener(this);
        this.rh.txtTemperatura.addMouseListener(this);
        this.rh.tblHabitats.addMouseListener(this);
        
        this.rh.txtTemperatura.addFocusListener(this);
        this.rh.txtHumedad.addFocusListener(this);
        iniRegistroHabitat();
        iniReporteHabitat();
        iniTableHabitats();
        iniTableRegistros("todos");
    }
    
    public void iniRegistroHabitat(){
        ArrayList<Clima> climas = Sql.verClimas();
        dcb = new DefaultComboBoxModel();
        dcb.addElement("Seleccione Clima");
        for (int i = 0; i < climas.size(); i++) {
            dcb.addElement(climas.get(i));
        }
        rh.cmbClima.setModel(dcb);
        
        ArrayList<Cuidador> cuidadores = Sql.verCuidadores();
        dcb = new DefaultComboBoxModel();
        dcb.addElement("Seleccione Cuidador");
        for (int i = 0; i < cuidadores.size(); i++) {
            dcb.addElement(cuidadores.get(i));
        }
        rh.cmbResponsable.setModel(dcb);
    }
    
    public void iniReporteHabitat(){
        ArrayList<Habitat> habitats = Sql.verHabitat();
        dcb = new DefaultComboBoxModel();
        dcb.addElement("Seleccione Habitat");
        for (int i = 0; i < habitats.size(); i++) {
            dcb.addElement(habitats.get(i));
        }
        
        rh.cmbHabitats.setModel(dcb);
    }
    public void guardar(){
        Habitat h = new Habitat();
        Clima c = (Clima) rh.cmbClima.getSelectedItem();
        Cuidador cui = (Cuidador) rh.cmbResponsable.getSelectedItem();
        h.setNombre(rh.txtNombre.getText());
        h.setClimaId(c.getId());
        h.setCuidadorId(cui.getId());
        h.setDisponibilidad("disponible");
        if(Sql.registrarHabitat(h)){
            JOptionPane.showMessageDialog(null, "Registroso Exitoso");
            iniTableHabitats();
            iniReporteHabitat();
        }else{
            JOptionPane.showMessageDialog(null, "Registroso Fallido");
        }
    }

    public void iniTableRegistros(String habitat){
        Vector vec = new Vector();
        dtm = new DefaultTableModel();
        dtm.addColumn("Temperatura");
        dtm.addColumn("Humedad");
        dtm.addColumn("Fecha");
        
        
        ArrayList<UltimosRegistros> ultimosRegistros = Sql.verRegistrosHabitats(habitat);
        for (int i = 0; i < ultimosRegistros.size(); i++) {
            vec = new Vector();
            vec.add(ultimosRegistros.get(i).getTemperatura()+"°");
            vec.add(ultimosRegistros.get(i).getHumedad()+"%");
            vec.add(ultimosRegistros.get(i).getFechaRegistro());
            vec.add(ultimosRegistros.get(i).getFechaRegistro());
            dtm.addRow(vec);
        }
        rh.tblReporte.setModel(dtm);
    }
    
    public void iniTableHabitats(){
        Vector vec;
        ArrayList<Habitats> h = Sql.verHabitats();
        dtm = new DefaultTableModel();
        dtm.addColumn("Habitat");
        dtm.addColumn("Responsable");
        dtm.addColumn("Clima");
        
        for (int i = 0; i < h.size(); i++) {
            vec = new Vector();
            vec.add(h.get(i).getNombreHabitat());
            vec.add(h.get(i).getNombreCuidador()+" "+h.get(i).getApellidoCuidador());
            vec.add(h.get(i).getClima());
            dtm.addRow(vec);
        }
        rh.tblHabitats.setModel(dtm);
    }
    
    
}
