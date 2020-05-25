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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.*;
import vista.PersonalVeterinarios;
import vista.RegistroVeterinarios;

/**
 *
 * @author beatl
 */
public class ctrlRegistroVeterinarios implements ActionListener, MouseListener{
    
    private RegistroVeterinarios rv;
    private Veterinario vet;
    private PersonalVeterinarios pv;
    private ctrlPersonalVeterinarios ctrlPv;
    private Color verdeOn;
    private Color verdePrincipal;
    private Font fontOn;
    private Font fontNormal;

    public ctrlRegistroVeterinarios(RegistroVeterinarios rv) {
        this.rv = rv;
        iniComponents();
        this.vet = new Veterinario();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rv.btnLimpiar){
            limpiar();
        }else if(e.getSource() == rv.btnGuardar){
            getVeterinario();
            if(Sql.registrarVeterinario(vet)){
                limpiar();
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
            }else{
                JOptionPane.showMessageDialog(null, "Registro Fallido");
            }
        }else if(e.getSource() == rv.btnSelector){
            setSelector();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == rv.btnGuardar){
            rv.btnGuardar.setFont(fontOn);
        }else if(e.getSource() == rv.btnLimpiar){
            rv.btnLimpiar.setFont(fontOn);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == rv.btnGuardar){
            rv.btnGuardar.setFont(fontNormal);
        }else if(e.getSource() == rv.btnLimpiar){
            rv.btnLimpiar.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == rv.btnGuardar){
            rv.btnGuardar.setBackground(verdeOn);
        }else if(e.getSource() == rv.btnLimpiar){
            rv.btnLimpiar.setBackground(verdeOn);
        }else if(e.getSource() == rv.btnSelector){
            rv.btnSelector.setBackground(verdeOn);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == rv.btnGuardar){
            rv.btnGuardar.setBackground(verdePrincipal);
        }else if(e.getSource() == rv.btnLimpiar){
            rv.btnLimpiar.setBackground(verdePrincipal);
        }else if(e.getSource() == rv.btnSelector){
            rv.btnSelector.setBackground(verdePrincipal);
        }
    }
    
    private void iniComponents(){
        
        this.rv.btnGuardar.addActionListener(this);
        this.rv.btnLimpiar.addActionListener(this);
        this.rv.btnSelector.addActionListener(this);
        
        this.rv.btnGuardar.addMouseListener(this);
        this.rv.btnLimpiar.addMouseListener(this);
        this.rv.btnSelector.addMouseListener(this);
        
        this.verdeOn = new Color(0, 212, 72);
        this.verdePrincipal = new Color(0, 179, 61);

        this.fontOn = new Font("Segoe UI", Font.PLAIN, 11);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);
    }
    
    private void getVeterinario(){
        vet.setNombre(rv.txtNombre.getText());
        vet.setNombre2(rv.txtNombre2.getText());
        vet.setApellido1(rv.txtApellido1.getText());
        vet.setApellido2(rv.txtApellido2.getText());
        vet.setCorreo(rv.txtCorreoElectronico.getText());
        vet.setCedulaProfesional(rv.txtCedulaProfesional.getText());
        vet.setTelefono(rv.txtTelefono.getText());
    }
    
    private void limpiar(){
        rv.txtApellido1.setText(null);
        rv.txtApellido2.setText(null);
        rv.txtCedulaProfesional.setText(null);
        rv.txtCorreoElectronico.setText(null);
        rv.txtNombre.setText(null);
        rv.txtNombre2.setText(null);
        rv.txtTelefono.setText(null);
    }
    
    public void setSelector(){
        
        if(rv.btnSelector.isSelected()){
            pv = new PersonalVeterinarios();
            ctrlPv = new ctrlPersonalVeterinarios(pv);
            pv.setVisible(true);
            this.rv.pnlVerVeterinario.removeAll();
            this.rv.pnlVerVeterinario.add(pv);
            this.rv.pnlVerVeterinario.repaint();
            this.rv.pnlVerVeterinario.revalidate();
            this.rv.pnlVerVeterinario.setVisible(true);
            this.rv.pnlPrincipal.setVisible(false);
            this.rv.btnSelector.setText("Registrar");
            this.rv.btnSelector.setIcon(new ImageIcon("src/img/addAni.png"));
        }else{
            rv.pnlVerVeterinario.setVisible(false);
            rv.pnlPrincipal.setVisible(true);
            this.rv.btnSelector.setText("Ver Veterinario");
            this.rv.btnSelector.setIcon(new ImageIcon("src/img/vision.png"));
        }
    }
}
