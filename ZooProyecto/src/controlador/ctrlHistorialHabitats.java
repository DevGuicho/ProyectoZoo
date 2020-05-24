/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.table.DefaultTableModel;
import vista.HistorialHabitats;

/**
 *
 * @author beatl
 */
public class ctrlHistorialHabitats {
    
    HistorialHabitats hh;
    DefaultTableModel dtm;

    public ctrlHistorialHabitats(HistorialHabitats hh) {
        this.hh = hh;
        setTable(); 
       
    }
    
    public void setTable(){
        this.dtm = new DefaultTableModel();
        dtm.addColumn("Habitat");
        dtm.addColumn("Responsable");
        dtm.addColumn("Temperatura");
        dtm.addColumn("Humedad");
        dtm.addColumn("Clima");
        hh.tblHabitats.setModel(dtm);
    }
}
