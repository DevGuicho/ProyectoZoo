/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author beatl
 */
public class PersonalVeterinarios extends javax.swing.JPanel {

    /**
     * Creates new form PersonalVeterinarios
     */
    public PersonalVeterinarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeterianrios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(212, 255, 204));
        setMinimumSize(new java.awt.Dimension(850, 560));
        setPreferredSize(new java.awt.Dimension(850, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVeterianrios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVeterianrios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 770, 380));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 810, 440));

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));
        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 810, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblVeterianrios;
    // End of variables declaration//GEN-END:variables
}
