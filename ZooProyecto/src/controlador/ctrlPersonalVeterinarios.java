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
import modelo.Sql;
import modelo.Veterinario;
import vista.PersonalVeterinarios;

/**
 *
 * @author beatl
 */
public class ctrlPersonalVeterinarios implements ActionListener, MouseListener {

    private PersonalVeterinarios pv;
    private ArrayList<Veterinario> vets;
    private Veterinario vet;
    private DefaultTableModel dtm;
    private Vector vec = new Vector();
    private Font fontOn;
    private Font fontNormal;

    public ctrlPersonalVeterinarios(PersonalVeterinarios pv) {
        this.pv = pv;
        iniComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pv.btnEditar) {
            actualizar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == pv.tblVeterianrios) {

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == pv.btnEditar) {
            pv.btnEditar.setFont(fontOn);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == pv.btnEditar) {
            pv.btnEditar.setFont(fontNormal);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == pv.btnEditar) {
            pv.btnEditar.setBackground(new Color(0, 102, 102));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == pv.btnEditar) {
            pv.btnEditar.setBackground(new Color(0, 51, 51));
        }
    }

    public void iniComponents() {
        iniTable();

        pv.tblVeterianrios.addMouseListener(this);
        pv.btnEditar.addActionListener(this);
        pv.btnEditar.addMouseListener(this);

        this.fontOn = new Font("Segoe UI", Font.PLAIN, 11);
        this.fontNormal = new Font("Segoe UI", Font.PLAIN, 14);
    }

    public void actualizar() {
        int row = pv.tblVeterianrios.getSelectedRow();
        vet = new Veterinario();
        vet.setId(Integer.parseInt(pv.tblVeterianrios.getValueAt(row, 0).toString()));
        vet.setNombre(pv.tblVeterianrios.getValueAt(row, 1).toString());
        vet.setNombre2(pv.tblVeterianrios.getValueAt(row, 2).toString());
        vet.setApellido1(pv.tblVeterianrios.getValueAt(row, 3).toString());
        vet.setApellido2(pv.tblVeterianrios.getValueAt(row, 4).toString());
        vet.setCorreo(pv.tblVeterianrios.getValueAt(row, 5).toString());
        vet.setTelefono(pv.tblVeterianrios.getValueAt(row, 6).toString());
        vet.setCedulaProfesional(pv.tblVeterianrios.getValueAt(row, 7).toString());
        if (Sql.actualizarVeterinario(vet)) {
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa");
        } else {
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida");
        }
    }

    public void setColumnT(int col, int width) {
        pv.tblVeterianrios.getColumnModel().getColumn(col).setWidth(width);
        pv.tblVeterianrios.getColumnModel().getColumn(col).setMaxWidth(width);
        pv.tblVeterianrios.getColumnModel().getColumn(col).setMinWidth(width);
        pv.tblVeterianrios.getColumnModel().getColumn(col).setPreferredWidth(width);
    }

    public void iniTable() {

        vets = Sql.verVeterinarios();
        int i = vets.size();

        dtm = new DefaultTableModel();
        dtm.addColumn("Id");
        dtm.addColumn("Nombre");
        dtm.addColumn("2do Nombre");
        dtm.addColumn("Apellido Paterno");
        dtm.addColumn("Apellido Materno");
        dtm.addColumn("Correo Electronico");
        dtm.addColumn("Telefono");
        dtm.addColumn("Cedula Profesional");

        for (i = 0; i < vets.size(); i++) {
            vec.add(vets.get(i).getId());
            vec.add(vets.get(i).getNombre());
            vec.add(vets.get(i).getNombre2());
            vec.add(vets.get(i).getApellido1());
            vec.add(vets.get(i).getApellido2());
            vec.add(vets.get(i).getCorreo());
            vec.add(vets.get(i).getTelefono());
            vec.add(vets.get(i).getCedulaProfesional());

            dtm.addRow(vec);
            vec = new Vector();
        }
        pv.tblVeterianrios.setModel(dtm);
        pv.tblVeterianrios.getColumnModel().getColumn(0).setResizable(false);
        setColumnT(0, 0);
        setColumnT(1, 90);
        setColumnT(2, 90);
        setColumnT(5, 150);
        setColumnT(6, 80);

    }
}
