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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.HistorialActividades;
import controlador.ctrlRegistroActividades;
import modelo.*;


/**
 *
 * @author beatl
 */
public class ctrlHistorialActividades implements ActionListener, MouseListener{
    
    private HistorialActividades ha;
    private int opcion;
    ArrayList<String> opciones;
    DefaultComboBoxModel comboSeleccionAux;
    DefaultComboBoxModel comboOpcionesAux;
    DefaultTableModel dtm;
    ArrayList<RegistroONG> actividades;
    RegistroONG rong;
    
    private Color verdeOn;
    private Color verdePrincipal;
    private Font fontOn;
    private Font fontNormal;

    public ctrlHistorialActividades(HistorialActividades ha) {
        this.ha = ha;
        iniComponents();
        this.rong = new RegistroONG();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == ha.cmbSeleccion){
            comboSeleccion();
        }else if(ae.getSource() == ha.cmbOpciones){
            if(ha.cmbOpciones.getSelectedIndex() != 0){
                TablaActividades(ha.cmbOpciones.getSelectedItem().toString(),ha.cmbSeleccion.getSelectedIndex());
            }
        }else if(ae.getSource() == ha.btnEliminar){
            if(validarEliminar()){
            Eliminar();
            if(Sql.eliminarActividad(rong)){
                ha.cmbSeleccion.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
            }
        }
    }
    
    private void iniComponents(){
        this.ha.cmbSeleccion.addActionListener(this);
        this.ha.cmbOpciones.addActionListener(this);
        this.ha.btnEliminar.addActionListener(this);
        this.ha.btnEliminar.addMouseListener(this);
        
         comboOpcionesAux = new DefaultComboBoxModel();
         comboSeleccionAux = new DefaultComboBoxModel();
         
         comboSeleccionAux.addElement("Seleccione un filtro");
         comboSeleccionAux.addElement("Dia");
         comboSeleccionAux.addElement("Habitat");
         comboSeleccionAux.addElement("Status");
         
         this.ha.cmbSeleccion.setModel(comboSeleccionAux);
        
         comboOpcionesAux.addElement("Seleccione una opcion");
         this.ha.cmbOpciones.setModel(comboOpcionesAux);
         
        this.verdeOn = new Color(0, 102, 102);
        this.verdePrincipal = new Color(0, 51, 51);

        this.fontOn = new Font("Segoe UI", Font.PLAIN, 11);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);
         
         TablaActividades("todos",0);
 
    }
    
    private void comboSeleccion(){
        if(ha.cmbSeleccion.getSelectedIndex() > 0){
            opcion = ha.cmbSeleccion.getSelectedIndex();
            comboOpciones(opcion);
        }else if(ha.cmbSeleccion.getSelectedIndex() == 0){
                while(comboOpcionesAux.getSize()>1){
                    comboOpcionesAux.removeElementAt(1);
                } 
            TablaActividades("todos",0);
        }
    }
    
    private void comboOpciones(int opcion){
        while(comboOpcionesAux.getSize()>1){
                comboOpcionesAux.removeElementAt(1);
        } 
        
        opciones = Sql.OpcionesActividades(opcion);
        
        for (int i = 0; i < opciones.size() ; i++) {
            comboOpcionesAux.addElement(opciones.get(i));
        }
        
        this.ha.cmbOpciones.setModel(comboOpcionesAux);
    }
    
    private void TablaActividades(String seleccion, int indice){
        Vector vec = new Vector();
        String [] titulos = {"Actividad","ONG", "Descripción", "Fecha Solicitud", "Hora Apertura", "Hora Cierre", "Habitat", "Status"};
        dtm = new DefaultTableModel(null, titulos);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        actividades = Sql.llamarActividades(seleccion,indice);
        
        for (int i = 0; i < actividades.size(); i++) {
            vec = new Vector();
            vec.add(actividades.get(i).getNombreActividad());
            vec.add(actividades.get(i).getOngNombre());
            vec.add(actividades.get(i).getDescripcionActividad());
            vec.add(sdf.format(actividades.get(i).getFechaSolicitud()));
            vec.add(actividades.get(i).getHoraApertura());
            vec.add(actividades.get(i).getHoraCierre());
            vec.add(actividades.get(i).getNombreHabitat());
            vec.add(actividades.get(i).getAprobacion());
            
            dtm.addRow(vec);
        }
        
        this.ha.tblActividades.setModel(dtm);
    }

    private void Eliminar() {
        rong.setNombreActividad(String.valueOf(dtm.getValueAt(ha.tblActividades.getSelectedRow(), 0)));
    }

    @Override
    public void mouseClicked(MouseEvent me) {
      
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == ha.btnEliminar){
            ha.btnEliminar.setFont(fontOn);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if (me.getSource() == ha.btnEliminar){
            ha.btnEliminar.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == ha.btnEliminar){
            ha.btnEliminar.setBackground(verdeOn);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == ha.btnEliminar){
            ha.btnEliminar.setBackground(verdePrincipal);
        }
    }
    
    private boolean validarEliminar(){
        if(ha.tblActividades.isColumnSelected(0) || ha.tblActividades.isColumnSelected(1) || ha.tblActividades.isColumnSelected(2) || ha.tblActividades.isColumnSelected(3) || ha.tblActividades.isColumnSelected(4) || ha.tblActividades.isColumnSelected(5) || ha.tblActividades.isColumnSelected(6) || ha.tblActividades.isColumnSelected(7)){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Selecciona una actividad");
            return false;
        }
    }
}
