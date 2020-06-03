/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.Animal;
import modelo.Sql;
import vista.PersonalAnimales;

/**
 *
 * @author beatl
 */
public class ctrlPersonalAnimales implements ActionListener{

    private PersonalAnimales pa;
    private DefaultTableModel dtm;
    private ArrayList<Animal> animales;
    private ArrayList<String> opciones;
    private Vector vec;
    private DefaultComboBoxModel dcm;
    private DefaultComboBoxModel dcm2;
    private int filtroSelected;

    public ctrlPersonalAnimales(PersonalAnimales pa) {
        this.pa = pa;
        ini();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pa.cmbFiltro) {
            if (pa.cmbFiltro.getSelectedIndex() == 3) {
                int l = dcm2.getSize();
                while (dcm2.getSize() != 1) {
                    dcm2.removeElementAt(1);
                    
                }
                pa.cmbSeleccion.addActionListener(this);
                dcm2.addElement("Local");
                dcm2.addElement("Foranea");
                dcm2.addElement("Rescate");
                this.pa.cmbSeleccion.setModel(dcm2);
                this.pa.cmbSeleccion.repaint();
                opciones = null;
                setTable("todos", 1);
            } else {
                opciones = Sql.filtros(pa.cmbFiltro.getSelectedIndex());

                int l = dcm2.getSize();
                while (dcm2.getSize()!=1 ) {
                    dcm2.removeElementAt(1);
                }

                pa.cmbSeleccion.addActionListener(this);
                for (int i = 0; i < opciones.size(); i++) {
                    dcm2.addElement(opciones.get(i));
                }
                this.pa.cmbSeleccion.setModel(dcm2);
                this.pa.cmbSeleccion.repaint();
                opciones = null;
                setTable("todos", 1);
            }

        } else if (e.getSource() == pa.cmbSeleccion) {
            if (pa.cmbSeleccion.getSelectedIndex() != 0) {
                if(pa.cmbFiltro.getSelectedIndex()==3)
                    setTable("procedencia", pa.cmbSeleccion.getSelectedIndex());
                else 
                    setTable(pa.cmbSeleccion.getSelectedItem().toString(), pa.cmbFiltro.getSelectedIndex());
            }

        }
    }
    
    public void ini(){
        this.pa.cmbFiltro.addActionListener(this);
        this.pa.cmbSeleccion.addActionListener(this);
        
        dcm = new DefaultComboBoxModel();
        dcm2 = new DefaultComboBoxModel();
        dcm.addElement("Seleccione Filtro");
        dcm.addElement("Especie");
        dcm.addElement("Habitat");
        dcm.addElement("Procedencia");
        dcm2.addElement("Selecciones una Opcion");
        this.pa.cmbFiltro.setModel(dcm);
        this.pa.cmbSeleccion.setModel(dcm2);
        setTable("todos",1);
        
    }
    
    public void setTable(String Selector, int sel){
        vec = new Vector();
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Cuidador");
        dtm.addColumn("Habitat");
        dtm.addColumn("Alimentacion");
        dtm.addColumn("Año Cautiverio");
        dtm.addColumn("Especie");
        dtm.addColumn("Sexo");
        dtm.addColumn("Edad");
        dtm.addColumn("Peso");
        dtm.addColumn("Observaciones");
        
        
       
        animales = Sql.verAnimales(Selector,sel);
        
        
        for(int i = 0;i<animales.size();i++){
            
            vec.add(animales.get(i).getNombre());
            vec.add(animales.get(i).getNombreCuidador());
            vec.add(animales.get(i).getNombreHabitat());
            vec.add(animales.get(i).getAlimentacion());
            vec.add(animales.get(i).getAnyoCautiverio());
            vec.add(animales.get(i).getEspecie());
            vec.add(animales.get(i).getSexo());
            vec.add(animales.get(i).getEdad()+" años");
            vec.add(animales.get(i).getPeso()+"Kg");
            vec.add(animales.get(i).getObservaciones());
            dtm.addRow(vec);
            vec = new Vector();
        }
        
        this.pa.tblAnimales.setModel(dtm);
        this.pa.tblAnimales.repaint();
    }
}
