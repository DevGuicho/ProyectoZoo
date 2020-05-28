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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.Cuidador;
import modelo.Sql;
import modelo.Veterinario;
import vista.PersonalVeterinarios;

/**
 *
 * @author beatl
 */
public class ctrlPersonalVeterinarios implements ActionListener, MouseListener{
   
    private PersonalVeterinarios pv;
    private ArrayList<Veterinario> vets;
    private Veterinario vet;
    private DefaultTableModel dtm;
    private Vector vec = new Vector();
    private Font fontOn;
    private Font fontNormal;
    
    public ctrlPersonalVeterinarios(PersonalVeterinarios pv) {
        this.pv = pv;
        vets = Sql.verVeterinarios();
        int i = vets.size();
        Veterinario v;
        dtm = new DefaultTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido Paterno");
        dtm.addColumn("Apellido Materno");
        dtm.addColumn("Correo Electronico");
        dtm.addColumn("Telefono");
        dtm.addColumn("Cedula Profesional");
        
        
        for(i = 0;i<vets.size();i++){
            vec.add(vets.get(i).getId());
            vec.add(vets.get(i).getNombre());
            vec.add(vets.get(i).getApellido1());
            vec.add(vets.get(i).getApellido2());
            vec.add(vets.get(i).getCorreo());
            vec.add(vets.get(i).getTelefono());
            vec.add(vets.get(i).getCedulaProfesional());
            
            
            dtm.addRow(vec);
            vec = new Vector();
        }
        pv.tblVeterianrios.setModel(dtm);
        pv.tblVeterianrios.getColumnModel().getColumn(0).setWidth(0);
        pv.tblVeterianrios.getColumnModel().getColumn(0).setMaxWidth(0);
        pv.tblVeterianrios.getColumnModel().getColumn(0).setMinWidth(0);
        pv.tblVeterianrios.getColumnModel().getColumn(0).setPreferredWidth(0);
        pv.tblVeterianrios.getColumnModel().getColumn(0).setResizable(false);
        pv.tblVeterianrios.addMouseListener(this);
        pv.btnEditar.addActionListener(this);
        pv.btnEditar.addMouseListener(this);
        
        this.fontOn = new Font("Segoe UI", Font.PLAIN, 11);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pv.btnEditar){
            
            Veterinario c = new Veterinario();
            int row = pv.tblVeterianrios.getSelectedRow();
            c.setId(Integer.parseInt(pv.tblVeterianrios.getValueAt(row, 0).toString()));
            c.setNombre(pv.tblVeterianrios.getValueAt(row, 1).toString());
            c.setApellido1(pv.tblVeterianrios.getValueAt(row, 2).toString());
            c.setApellido2(pv.tblVeterianrios.getValueAt(row, 3).toString());
            c.setCorreo(pv.tblVeterianrios.getValueAt(row, 4).toString());
            c.setTelefono(pv.tblVeterianrios.getValueAt(row, 5).toString());
            c.setCedulaProfesional(pv.tblVeterianrios.getValueAt(row, 6).toString());
            if(Sql.actualizarVeterinario(c)){
                JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "Actualizacion Fallida");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()== pv.tblVeterianrios){

            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == pv.btnEditar){
            pv.btnEditar.setFont(fontOn);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == pv.btnEditar){
            pv.btnEditar.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == pv.btnEditar){
            pv.btnEditar.setBackground(new Color(0,102,102));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == pv.btnEditar){
           pv.btnEditar.setBackground(new Color(0,51,51));
        }
    }
    
    
}
