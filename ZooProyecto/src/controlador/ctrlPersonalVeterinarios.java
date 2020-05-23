/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import modelo.Sql;
import modelo.Veterinario;
import vista.PersonalVeterinarios;

/**
 *
 * @author beatl
 */
public class ctrlPersonalVeterinarios {
   
    private PersonalVeterinarios pv;
    private ArrayList<Veterinario> vets;
    private Veterinario vet;
    private DefaultTableModel dtm;
    private Vector vec = new Vector();
    public ctrlPersonalVeterinarios(PersonalVeterinarios pv) {
        this.pv = pv;
        vets = Sql.verVeterinarios();
        int i = vets.size();
        Veterinario v;
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellido Paterno");
        dtm.addColumn("Apellido Materno");
        dtm.addColumn("Correo Electronico");
        dtm.addColumn("Telefono");
        dtm.addColumn("Cedula Profesional");
        
        for(i = 0;i<vets.size();i++){
            vec.add(vets.get(i).getNombre());
            vec.add(vets.get(i).getApellido1());
            vec.add(vets.get(i).getApellido2());
            vec.add(vets.get(i).getCorreo());
            vec.add(vets.get(i).getCedulaProfesional());
            vec.add(vets.get(i).getTelefono());
            
            dtm.addRow(vec);
            vec = new Vector();
        }
        pv.tblVeterianrios.setModel(dtm);
        
    }
    
    
}
