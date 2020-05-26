/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import vista.HistorialActividades;
import modelo.*;


/**
 *
 * @author beatl
 */
public class ctrlHistorialActividades implements ActionListener{
    
    private HistorialActividades ha;
    private int opcion;
    ArrayList<String> opciones;
    DefaultComboBoxModel comboSeleccionAux;
    DefaultComboBoxModel comboOpcionesAux;
    DefaultTableModel dtm;

    public ctrlHistorialActividades(HistorialActividades ha) {
        this.ha = ha;
        iniComponents();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == ha.cmbSeleccion){
            comboSeleccion();
        }else if(ae.getSource() == ha.cmbOpciones){
            if(ha.cmbOpciones.getSelectedIndex() > 0){
                
            }
        }else if(ae.getSource() == ha.btnEliminar){
            //Eliminar();
            ha.cmbSeleccion.setSelectedIndex(0);
        }
    }
    
    private void iniComponents(){
        this.ha.cmbSeleccion.addActionListener(this);
        this.ha.cmbOpciones.addActionListener(this);
        this.ha.btnEliminar.addActionListener(this);
        
         comboOpcionesAux = new DefaultComboBoxModel();
         comboSeleccionAux = new DefaultComboBoxModel();
         
         comboSeleccionAux.addElement("Seleccione un filtro");
         comboSeleccionAux.addElement("Dia");
         comboSeleccionAux.addElement("Habitat");
         comboSeleccionAux.addElement("Status");
         
         this.ha.cmbSeleccion.setModel(comboSeleccionAux);
        
         comboOpcionesAux.addElement("Seleccione una opcion");
         this.ha.cmbOpciones.setModel(comboOpcionesAux);
    }
    
    private void comboSeleccion(){
        if(ha.cmbSeleccion.getSelectedIndex() > 0){
            opcion = ha.cmbSeleccion.getSelectedIndex();
            comboOpciones(opcion);
        }else if(ha.cmbSeleccion.getSelectedIndex() == 0){
                while(comboOpcionesAux.getSize()>1){
                    comboOpcionesAux.removeElementAt(1);
                } 
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

    private void Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
