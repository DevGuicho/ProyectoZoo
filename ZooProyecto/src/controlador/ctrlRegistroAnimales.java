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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.*;
import vista.PersonalAnimales;
import vista.RegistroAnimales;

/**
 *
 * @author beatl
 */
public class ctrlRegistroAnimales implements ActionListener, MouseListener {

    private RegistroAnimales ra;
    private String procedencia;
    private Color verdeOn;
    private Color verdePrincipal;
    private Font fontOn;
    private Font fontNormal;
    private DefaultComboBoxModel dcbm;
    private ArrayList<Cuidador> cuidadores;
    private ArrayList<Habitat> habitats;
    private ArrayList<Veterinario> veterinarios;
    private Animal ani;
    private Habitat h;
    private Cuidador c;
    private Veterinario v;
    private PersonalAnimales pv;
    private ctrlPersonalAnimales ctrlPv;
    private String mensaje;

    public ctrlRegistroAnimales(RegistroAnimales ra) {
        this.ra = ra;
        
        iniComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ra.btnGuardar) {
            guardar();
        } else if (e.getSource() == ra.btnSelector) {
            setPanel();

        } else if (e.getSource() == ra.btnProcedenciaLocal) {
            ra.pnlLocal.setVisible(true);
            ra.pnlRescate.setVisible(false);
            ra.pnlForanea.setVisible(false);
            ra.pnlDefault.setVisible(false);
            procedencia = "Local";
        } else if (e.getSource() == ra.btnProcedenciaRescate) {
            ra.pnlLocal.setVisible(false);
            ra.pnlRescate.setVisible(true);
            ra.pnlForanea.setVisible(false);
            ra.pnlDefault.setVisible(false);
            procedencia = "Rescate";
        } else if (e.getSource() == ra.btnProcedenciaForanea) {
            ra.pnlLocal.setVisible(false);
            ra.pnlRescate.setVisible(false);
            ra.pnlForanea.setVisible(true);
            ra.pnlDefault.setVisible(false);
            procedencia = "Foranea";
        } else if (e.getSource() == ra.btnLimpiar) {
            limpiar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == ra.btnSelector) {
            ra.btnSelector.setFont(fontOn);
        } else if (e.getSource() == ra.btnGuardar) {
            ra.btnGuardar.setFont(fontOn);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == ra.btnSelector) {
            ra.btnSelector.setFont(fontNormal);
        } else if (e.getSource() == ra.btnGuardar) {
            ra.btnGuardar.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == ra.btnGuardar) {
            ra.btnGuardar.setBackground(verdeOn);
        } else if (e.getSource() == ra.btnSelector) {
            ra.btnSelector.setBackground(verdeOn);
        } else if (e.getSource() == ra.btnProcedenciaForanea) {
            ra.btnProcedenciaForanea.setBackground(verdeOn);
        } else if (e.getSource() == ra.btnProcedenciaLocal) {
            ra.btnProcedenciaLocal.setBackground(verdeOn);
        } else if (e.getSource() == ra.btnProcedenciaRescate) {
            ra.btnProcedenciaRescate.setBackground(verdeOn);
        } else if (e.getSource() == ra.btnLimpiar) {
            ra.btnLimpiar.setBackground(verdeOn);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == ra.btnGuardar) {
            ra.btnGuardar.setBackground(verdePrincipal);
        } else if (e.getSource() == ra.btnSelector) {
            ra.btnSelector.setBackground(verdePrincipal);
        } else if (e.getSource() == ra.btnProcedenciaForanea) {
            ra.btnProcedenciaForanea.setBackground(verdePrincipal);
        } else if (e.getSource() == ra.btnProcedenciaLocal) {
            ra.btnProcedenciaLocal.setBackground(verdePrincipal);
        } else if (e.getSource() == ra.btnProcedenciaRescate) {
            ra.btnProcedenciaRescate.setBackground(verdePrincipal);
        } else if (e.getSource() == ra.btnLimpiar) {
            ra.btnLimpiar.setBackground(verdePrincipal);
        }
    }

    private void limpiar() {
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

    private void iniComponents() {
        this.ani = new Animal();
        
        this.ra.btnProcedenciaForanea.addActionListener(this);
        this.ra.btnProcedenciaLocal.addActionListener(this);
        this.ra.btnProcedenciaRescate.addActionListener(this);
        this.ra.btnGuardar.addActionListener(this);
        this.ra.btnSelector.addActionListener(this);
        this.ra.btnLimpiar.addActionListener(this);

        this.ra.btnGuardar.addMouseListener(this);
        this.ra.btnSelector.addMouseListener(this);
        this.ra.btnProcedenciaForanea.addMouseListener(this);
        this.ra.btnProcedenciaLocal.addMouseListener(this);
        this.ra.btnProcedenciaRescate.addMouseListener(this);
        this.ra.btnLimpiar.addMouseListener(this);

        ra.pnlLocal.setVisible(false);
        ra.pnlRescate.setVisible(false);
        ra.pnlForanea.setVisible(false);
        ra.pnlDefault.setVisible(true);
        
        this.ra.pnlVistaAnimales.setVisible(false);
        this.verdeOn = new Color(0, 212, 72);
        this.verdePrincipal = new Color(0, 179, 61);

        this.fontOn = new Font("Segoe UI", Font.PLAIN, 11);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);
        
        this.procedencia = "";
        iniComboBoxes();
    }

    private void iniComboBoxes() {

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
        while (ih.hasNext()) {
            h = ih.next();
            dcbm.addElement(h);

        }
        this.ra.cmbHabitat.setModel(dcbm);

        dcbm = new DefaultComboBoxModel();
        dcbm.addElement("Seleccione Cuidador");
        cuidadores = Sql.verCuidadores();

        Iterator<Cuidador> ic = cuidadores.iterator();
        Cuidador c;
        while (ic.hasNext()) {
            c = ic.next();
            dcbm.addElement(c);

        }
        this.ra.cmbCuidador.setModel(dcbm);

        dcbm = new DefaultComboBoxModel();
        dcbm.addElement("Seleccione Veterinario");
        veterinarios = Sql.verVeterinarios();

        Iterator<Veterinario> iv = veterinarios.iterator();
        Veterinario v;
        while (iv.hasNext()) {
            v = iv.next();
            dcbm.addElement(v);

        }
        this.ra.cmbVeterinarioNacimeinto.setModel(dcbm);
    }

    private void guardar() {

        
        if (validar()) {
            getAnimal();
            if (Sql.registrarAnimal(ani)) {
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Registro Fallido");
            }
        }else {
            JOptionPane.showMessageDialog(null, mensaje);
        }

    }

    public void setPanel() {
        if (ra.btnSelector.isSelected()) {
            pv = new PersonalAnimales();
            ctrlPv = new ctrlPersonalAnimales(pv);
            this.ra.pnlVistaAnimales.removeAll();
            this.ra.pnlVistaAnimales.add(pv);
            this.ra.pnlVistaAnimales.repaint();
            this.ra.pnlVistaAnimales.revalidate();
            this.ra.pnlVistaAnimales.setVisible(true);
            this.ra.pnlRegistroAnimales.setVisible(false);
            this.ra.btnSelector.setText("Registrar");
            this.ra.btnSelector.setIcon(new ImageIcon("src/img/addAni.png"));
            this.ra.btnProcedenciaForanea.setVisible(false);
            this.ra.btnProcedenciaLocal.setVisible(false);
            this.ra.btnProcedenciaRescate.setVisible(false);
            this.ra.btnGuardar.setEnabled(false);
            this.ra.btnLimpiar.setEnabled(false);
        } else {
            this.ra.pnlVistaAnimales.setVisible(false);
            this.ra.pnlRegistroAnimales.setVisible(true);
            this.ra.btnSelector.setText("Ver Animales");
            this.ra.btnSelector.setIcon(new ImageIcon("src/img/vision.png"));
            this.ra.btnProcedenciaForanea.setVisible(true);
            this.ra.btnProcedenciaLocal.setVisible(true);
            this.ra.btnProcedenciaRescate.setVisible(true);
            this.ra.btnGuardar.setEnabled(true);
            this.ra.btnLimpiar.setEnabled(true);
        }
    }

    public void getAnimal() {
        h = (Habitat) ra.cmbHabitat.getSelectedItem();
        c = (Cuidador) ra.cmbCuidador.getSelectedItem();
        if (ra.cmbVeterinarioNacimeinto.getSelectedIndex() > 0) {
            v = (Veterinario) ra.cmbVeterinarioNacimeinto.getSelectedItem();
        }

        ani.setNombre(ra.txtNombre.getText());
        ani.setPeso(Float.parseFloat(ra.txtPeso.getText()));
        ani.setEdad(Integer.parseInt(ra.txtEdad.getText()));
        ani.setSexo(ra.cmbSexo.getSelectedItem().toString().charAt(0) + "");
        ani.setEspecie(ra.txtEspecie.getText());
        ani.setAnyoCautiverio(Integer.parseInt(ra.txtAniosCautiverio.getText()));
        ani.setAlimentacion(ra.txtAlimentacion.getText());
        ani.setIdHabitat(h.getId());
        ani.setIdCuidador(c.getId());
        ani.setObservaciones(ra.txtObservaciones.getText());

        if (procedencia.equals("Local")) {
            ani.setIdVeterinario(v.getId());
            ani.setFechaNacimiento(ra.cldFechaNacimientos.getDate());
            ani.setPesoNacimientp(Float.parseFloat(ra.txtPesoNacimiento.getText()));
            ani.setProcedencia(1);

        } else if (procedencia.equals("Rescate")) {
            ani.setFechaRescate(ra.cldFechaRescate.getDate());
            ani.setEdadRescate(Integer.parseInt(ra.txtEdadRescate.getText()));
            ani.setCondicion(ra.cmbCondicionRescate.getSelectedItem().toString());
            ani.setProcedencia(2);
        } else {
            ani.setNombreZoologico(ra.txtNombreZoologico.getText());
            ani.setFechaTraslado(ra.cldFechaTraslado.getDate());
            ani.setProcedencia(3);
        }
    }
    
    public boolean validar(){
        if(ra.txtNombre.getText().equals("")){
            mensaje = "Ingrese Nombre";
            return false;
        }else if(ra.txtPeso.getText().equals("")){
            mensaje = "Ingrese Peso";
            return false;
        }else if(ra.txtEdad.getText().equals("")){
            mensaje = "Ingrese Edad";
            return false;
        }else if(ra.cmbSexo.getSelectedIndex()==0){
            mensaje = "Seleccione Sexo";
            return false;
        }else if(ra.txtEspecie.getText().equals("")){
            mensaje = "Ingrese Especie";
            return false;
        }else if(ra.txtAniosCautiverio.getText().equals("")){
            mensaje = "Ingrese Años en cautiverio";
            return false;
        }else if(ra.txtAlimentacion.getText().equals("")){
            mensaje = "Ingrese Alimentacion";
            return false;
        }else if(ra.cmbHabitat.getSelectedIndex()==0){
            mensaje = "Seleccione Habitat";
            return false;
        }else if(ra.cmbCuidador.getSelectedIndex() == 0){
            mensaje = "Seleccione Cuidador";
            return false;
        }else if(ra.txtObservaciones.getText().equals("")){
            mensaje = "Ingrese Observaciones";
            return false;
        }else if(procedencia.equals("")){
            mensaje ="Ingrese Procedencia";
            return false;
        }else{
            return true;
        }
    }
}
