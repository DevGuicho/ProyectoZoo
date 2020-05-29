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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cuidador;
import modelo.Sql;
import vista.RegistroCuidadores;

/**
 *
 * @author beatl
 */
public class ctrlRegistroCuidadores implements ActionListener, MouseListener{
    
    private RegistroCuidadores rc;
    private ArrayList<Cuidador> cuidadores;
    private Color verdeOn;
    private Color verdePrincipal;
    private Font fontClick;
    private Font fontNormal;
    
    private DefaultTableModel dtm;
    private String mensaje;
    
    public ctrlRegistroCuidadores(RegistroCuidadores rc) {
        this.rc = rc;
        iniComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rc.btnGuardar){
            guardar();
        }else if(e.getSource() == rc.btnLimpiar){
            limpiar();
        }else if (e.getSource() == rc.btnEditar){
            actualizar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == rc.btnGuardar){
            rc.btnGuardar.setFont(fontClick);
        }else if(e.getSource() == rc.btnLimpiar){
            rc.btnLimpiar.setFont(fontClick);
        }else if(e.getSource() == rc.btnEditar){
            rc.btnEditar.setFont(fontClick);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == rc.btnGuardar){
            rc.btnGuardar.setFont(fontNormal);
        }else if(e.getSource() == rc.btnLimpiar){
            rc.btnLimpiar.setFont(fontNormal);
        }else if(e.getSource() == rc.btnEditar){
            rc.btnEditar.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == rc.btnGuardar){
            rc.btnGuardar.setBackground(verdeOn);
        }else if(e.getSource() == rc.btnLimpiar){
            rc.btnLimpiar.setBackground(verdeOn);
        }else if(e.getSource() == rc.btnEditar){
            rc.btnEditar.setBackground(new Color(0,102,102));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == rc.btnGuardar){
            rc.btnGuardar.setBackground(verdePrincipal);
        }else if(e.getSource() == rc.btnLimpiar){
            rc.btnLimpiar.setBackground(verdePrincipal);
        }else if(e.getSource() == rc.btnEditar){
            rc.btnEditar.setBackground(new Color(0,51,51));
        }
    }
    
    public Cuidador getData(){
        Cuidador c = new Cuidador();
        c.setNombre(rc.txtNombre.getText());
        c.setNombre2(rc.txt2doNombre.getText());
        c.setApellido1(rc.txtApellidoPaterno.getText());
        c.setApellido2(rc.txtApellidoMaterno.getText());
        c.setSueldo(Float.parseFloat(rc.txtSueldo.getText()));
        
        return c;
    }
    
    public void limpiar(){
        rc.txtNombre.setText(null);
        rc.txt2doNombre.setText(null);
        rc.txtApellidoPaterno.setText(null);
        rc.txtApellidoMaterno.setText(null);
        rc.txtSueldo.setText(null);
    }
    public void iniComponents(){
        
        this.verdeOn = new Color(0, 212, 72);
        this.verdePrincipal = new Color(0, 179, 61);
        this.fontClick = new Font("Segoe UI", Font.PLAIN, 12);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);
        this.rc.btnGuardar.addActionListener(this);
        this.rc.btnGuardar.addMouseListener(this);
        this.rc.btnLimpiar.addActionListener(this);
        this.rc.btnLimpiar.addMouseListener(this);
        this.rc.btnEditar.addActionListener(this);
        this.rc.btnEditar.addMouseListener(this);
        
        iniTable();
    }
    
    public void iniTable(){
        
        Vector vec = new Vector();
        dtm = new DefaultTableModel();
        cuidadores = Sql.verCuidadores();
        dtm.addColumn("id");
        dtm.addColumn("Nombre");
        dtm.addColumn("Nombre 2");
        dtm.addColumn("Apellido Paterno");
        dtm.addColumn("Apellido Materno");
        dtm.addColumn("Sueldo");
        
        for (int i = 0; i < cuidadores.size(); i++) {
            vec = new Vector();
            
            
        
            vec.add(cuidadores.get(i).getId());
            vec.add(cuidadores.get(i).getNombre());
            vec.add(cuidadores.get(i).getNombre2());
            vec.add(cuidadores.get(i).getApellido1());
            vec.add(cuidadores.get(i).getApellido2());
            vec.add(cuidadores.get(i).getSueldo());
            dtm.addRow(vec);
        }
        
        this.rc.tblCuidadores.setModel(dtm);
        this.rc.tblCuidadores.getColumnModel().getColumn(0).setMaxWidth(0);
        this.rc.tblCuidadores.getColumnModel().getColumn(0).setMinWidth(0);
        this.rc.tblCuidadores.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.rc.tblCuidadores.getColumnModel().getColumn(0).setWidth(0);
        this.rc.tblCuidadores.getColumnModel().getColumn(0).setResizable(false);
        
    }
    
    public void actualizar(){
        Cuidador c = new Cuidador();
        int row = rc.tblCuidadores.getSelectedRow();
        
        c.setId(Integer.parseInt(rc.tblCuidadores.getValueAt(row, 0).toString()));
        c.setNombre(rc.tblCuidadores.getValueAt(row, 1).toString());
        c.setNombre2(rc.tblCuidadores.getValueAt(row, 2).toString());
        c.setApellido1(rc.tblCuidadores.getValueAt(row, 3).toString());
        c.setApellido2(rc.tblCuidadores.getValueAt(row,4).toString());
        c.setSueldo(Float.parseFloat(rc.tblCuidadores.getValueAt(row, 5).toString()));
        if(Sql.actualizarCuidador(c))
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");   
        else 
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida");
        
    }
    
    public boolean validar(){
        if(rc.txtNombre.getText().equals("")){
            mensaje = "Ingrese Nombre";
            return false;
        }else if(rc.txtApellidoPaterno.getText().equals("")){
            mensaje = "Ingrese Apellido Paterno";
            return false;
        }else if(rc.txtApellidoMaterno.getText().equals("")){
            mensaje = "Ingrese Apellido Materno";
            return false;
        }else if(rc.txtSueldo.getText().equals("")){
            mensaje = "Ingrese Sueldo";
            return false;
        }else{
            mensaje = "Registro Exitoso";
            return true;
        }
    }
    
    public void guardar() {
        if (validar()) {
            if (Sql.registrarCuidadores(getData())) {
                JOptionPane.showMessageDialog(null, mensaje);
                iniTable();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Registro Fallido");
            }
        } else {
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}
