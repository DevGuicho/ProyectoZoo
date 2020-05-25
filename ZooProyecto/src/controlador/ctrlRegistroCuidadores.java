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
    
    public ctrlRegistroCuidadores(RegistroCuidadores rc) {
        this.rc = rc;
        iniComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rc.btnGuardar){
            if(Sql.registrarCuidadores(getData())){
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                iniTable();
                limpiar();
                
            }else{
                JOptionPane.showMessageDialog(null, "Registro Fallido");
            }
        }else if(e.getSource() == rc.btnLimpiar){
            limpiar();
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
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == rc.btnGuardar){
            rc.btnGuardar.setFont(fontNormal);
        }else if(e.getSource() == rc.btnLimpiar){
            rc.btnLimpiar.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == rc.btnGuardar){
            rc.btnGuardar.setBackground(verdeOn);
        }else if(e.getSource() == rc.btnLimpiar){
            rc.btnLimpiar.setBackground(verdeOn);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == rc.btnGuardar){
            rc.btnGuardar.setBackground(verdePrincipal);
        }else if(e.getSource() == rc.btnLimpiar){
            rc.btnLimpiar.setBackground(verdePrincipal);
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
        
        iniTable();
    }
    
    public void iniTable(){
        
        Vector vec = new Vector();
        dtm = new DefaultTableModel();
        cuidadores = Sql.verCuidadores();
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido Paterno");
        dtm.addColumn("Apellido Materno");
        dtm.addColumn("Sueldo");
        
        for (int i = 0; i < cuidadores.size(); i++) {
            vec = new Vector();
            String nombre = cuidadores.get(i).getNombre2();
            
        
                
            vec.add(cuidadores.get(i).getNombre()+" "+nombre);
            vec.add(cuidadores.get(i).getApellido1());
            vec.add(cuidadores.get(i).getApellido2());
            vec.add(cuidadores.get(i).getSueldo());
            dtm.addRow(vec);
        }
        this.rc.tblCuidadores.setModel(dtm);
    }
}
