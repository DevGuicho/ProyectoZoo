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
public class Home extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    public Home() {
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
        lblClock = new javax.swing.JLabel();
        lblEstadoZoologico = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblVeterinario = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblFechaVisita = new javax.swing.JLabel();
        lblAnimalRevisado = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblHumedad = new javax.swing.JLabel();
        lblHabitat = new javax.swing.JLabel();
        lblTemperatura = new javax.swing.JLabel();
        lblFechaRegistro = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblNombreActividad = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblNombreONG = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblNombreHabAct = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(212, 255, 204));
        setPreferredSize(new java.awt.Dimension(850, 640));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        lblClock.setBackground(new java.awt.Color(102, 255, 102));
        lblClock.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 255, 255));
        lblClock.setText("00:00:00 PM");

        lblEstadoZoologico.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        lblEstadoZoologico.setForeground(new java.awt.Color(255, 255, 255));
        lblEstadoZoologico.setText("Abierto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(lblClock)
                .addGap(290, 290, 290))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(lblEstadoZoologico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblClock)
                .addGap(18, 18, 18)
                .addComponent(lblEstadoZoologico)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 180));

        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setText("Ultima Visita Medica");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Realizad por: ");

        lblVeterinario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVeterinario.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("El dia:");

        lblFechaVisita.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFechaVisita.setForeground(new java.awt.Color(255, 255, 255));

        lblAnimalRevisado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAnimalRevisado.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Animal Revisado:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFechaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(lblVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel10)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(lblAnimalRevisado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)))
                    .addComponent(jLabel8))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(lblVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFechaVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel9)
                .addGap(27, 27, 27)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAnimalRevisado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 250, 300));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("Ultimo Registro de Temperatura");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel11.setText("Ultimo Registro de Humedad");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setText("Habitat");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lblHumedad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(lblHumedad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 105, 160, 25));

        lblHabitat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(lblHabitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 160, 25));

        lblTemperatura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(lblTemperatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 160, 25));

        lblFechaRegistro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(lblFechaRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 235, 160, 25));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setText("Fecha Registro");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 205, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 250, 280));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setText("Actividades ");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel14.setText("Actividad");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, -1, -1));

        lblNombreActividad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(lblNombreActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 96, 154, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel15.setText("ONG");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 122, -1, -1));

        lblNombreONG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(lblNombreONG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 147, 154, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel16.setText("Habitat");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 185, -1, -1));

        lblNombreHabAct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(lblNombreHabAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 154, 20));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 250, 230));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salud.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/temperatura.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actividades.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background2.jpg"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 850, 650));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel lblAnimalRevisado;
    public javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblEstadoZoologico;
    public javax.swing.JLabel lblFechaRegistro;
    public javax.swing.JLabel lblFechaVisita;
    public javax.swing.JLabel lblHabitat;
    public javax.swing.JLabel lblHumedad;
    public javax.swing.JLabel lblNombreActividad;
    public javax.swing.JLabel lblNombreHabAct;
    public javax.swing.JLabel lblNombreONG;
    public javax.swing.JLabel lblTemperatura;
    public javax.swing.JLabel lblVeterinario;
    // End of variables declaration//GEN-END:variables
}
