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
public class RegistroActividades extends javax.swing.JPanel {

    /**
     * Creates new form RegistroActividades
     */
    public RegistroActividades() {
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

        pnlBarraTitulo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlBarraOpciones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        pnlRegistroActividad = new javax.swing.JPanel();
        pnlImagen = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pnlSelDias = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ckbMartes = new javax.swing.JCheckBox();
        ckbMiercoles = new javax.swing.JCheckBox();
        ckbViernes = new javax.swing.JCheckBox();
        ckbSabado = new javax.swing.JCheckBox();
        ckbJueves = new javax.swing.JCheckBox();
        ckbDomingo = new javax.swing.JCheckBox();
        pnlPrincipal1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreActividad = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtHoraApertura = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        cmbAprobacion = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbHabitat = new javax.swing.JComboBox<>();
        txtNombreONG = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtHoraCierre = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(212, 255, 204));
        setFont(new java.awt.Font("Segoe UI Black", 0, 11)); // NOI18N
        setPreferredSize(new java.awt.Dimension(850, 640));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBarraTitulo.setBackground(new java.awt.Color(0, 179, 61));
        pnlBarraTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlBarraTitulo.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlBarraTitulo.setPreferredSize(new java.awt.Dimension(850, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Actividades");
        jLabel1.setMaximumSize(new java.awt.Dimension(282, 33));
        jLabel1.setMinimumSize(new java.awt.Dimension(282, 33));
        jLabel1.setPreferredSize(new java.awt.Dimension(282, 33));

        javax.swing.GroupLayout pnlBarraTituloLayout = new javax.swing.GroupLayout(pnlBarraTitulo);
        pnlBarraTitulo.setLayout(pnlBarraTituloLayout);
        pnlBarraTituloLayout.setHorizontalGroup(
            pnlBarraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarraTituloLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );
        pnlBarraTituloLayout.setVerticalGroup(
            pnlBarraTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        add(pnlBarraTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 40));
        pnlBarraTitulo.getAccessibleContext().setAccessibleName("");
        pnlBarraTitulo.getAccessibleContext().setAccessibleDescription("");

        pnlBarraOpciones.setBackground(new java.awt.Color(0, 179, 61));
        pnlBarraOpciones.setAlignmentX(0.0F);
        pnlBarraOpciones.setAlignmentY(0.0F);
        pnlBarraOpciones.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        pnlBarraOpciones.setMinimumSize(new java.awt.Dimension(200, 40));
        pnlBarraOpciones.setPreferredSize(new java.awt.Dimension(200, 40));
        pnlBarraOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setBackground(new java.awt.Color(0, 179, 61));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setDefaultCapable(false);
        btnGuardar.setFocusable(false);
        btnGuardar.setMaximumSize(new java.awt.Dimension(86, 32));
        btnGuardar.setMinimumSize(new java.awt.Dimension(86, 32));
        btnGuardar.setOpaque(true);
        btnGuardar.setPreferredSize(new java.awt.Dimension(86, 32));
        btnGuardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saveOn.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlBarraOpciones.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        btnLimpiar.setBackground(new java.awt.Color(0, 179, 61));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setDefaultCapable(false);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setFocusable(false);
        btnLimpiar.setOpaque(true);
        btnLimpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiarOn.png"))); // NOI18N
        pnlBarraOpciones.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 100, 40));

        add(pnlBarraOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 850, 40));

        pnlRegistroActividad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg5.jpg"))); // NOI18N

        javax.swing.GroupLayout pnlImagenLayout = new javax.swing.GroupLayout(pnlImagen);
        pnlImagen.setLayout(pnlImagenLayout);
        pnlImagenLayout.setHorizontalGroup(
            pnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
            .addGroup(pnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlImagenLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlImagenLayout.setVerticalGroup(
            pnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
            .addGroup(pnlImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlImagenLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlRegistroActividad.add(pnlImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        pnlSelDias.setBackground(new java.awt.Color(212, 255, 204));
        pnlSelDias.setAlignmentX(0.0F);
        pnlSelDias.setAlignmentY(0.0F);
        pnlSelDias.setOpaque(false);
        pnlSelDias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 179, 61));
        jLabel10.setText("Días ");
        pnlSelDias.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        ckbMartes.setBackground(new java.awt.Color(212, 255, 204));
        ckbMartes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ckbMartes.setForeground(new java.awt.Color(0, 179, 61));
        ckbMartes.setText("Martes");
        ckbMartes.setBorder(null);
        ckbMartes.setContentAreaFilled(false);
        pnlSelDias.add(ckbMartes, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 100, 33));

        ckbMiercoles.setBackground(new java.awt.Color(212, 255, 204));
        ckbMiercoles.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ckbMiercoles.setForeground(new java.awt.Color(0, 179, 61));
        ckbMiercoles.setText("Miércoles");
        ckbMiercoles.setBorder(null);
        ckbMiercoles.setContentAreaFilled(false);
        ckbMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbMiercolesActionPerformed(evt);
            }
        });
        pnlSelDias.add(ckbMiercoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 100, 33));

        ckbViernes.setBackground(new java.awt.Color(212, 255, 204));
        ckbViernes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ckbViernes.setForeground(new java.awt.Color(0, 179, 61));
        ckbViernes.setText("Viernes");
        ckbViernes.setBorder(null);
        ckbViernes.setContentAreaFilled(false);
        pnlSelDias.add(ckbViernes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 100, 33));

        ckbSabado.setBackground(new java.awt.Color(212, 255, 204));
        ckbSabado.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ckbSabado.setForeground(new java.awt.Color(0, 179, 61));
        ckbSabado.setText("Sábado");
        ckbSabado.setBorder(null);
        ckbSabado.setContentAreaFilled(false);
        ckbSabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbSabadoActionPerformed(evt);
            }
        });
        pnlSelDias.add(ckbSabado, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 100, 33));

        ckbJueves.setBackground(new java.awt.Color(212, 255, 204));
        ckbJueves.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ckbJueves.setForeground(new java.awt.Color(0, 179, 61));
        ckbJueves.setText("Jueves");
        ckbJueves.setBorder(null);
        ckbJueves.setContentAreaFilled(false);
        pnlSelDias.add(ckbJueves, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 100, 33));

        ckbDomingo.setBackground(new java.awt.Color(212, 255, 204));
        ckbDomingo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ckbDomingo.setForeground(new java.awt.Color(0, 179, 61));
        ckbDomingo.setText("Domingo");
        ckbDomingo.setBorder(null);
        ckbDomingo.setContentAreaFilled(false);
        ckbDomingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbDomingoActionPerformed(evt);
            }
        });
        pnlSelDias.add(ckbDomingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 100, 33));

        pnlRegistroActividad.add(pnlSelDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 350, 250));

        pnlPrincipal1.setBackground(new java.awt.Color(212, 255, 204));
        pnlPrincipal1.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlPrincipal1.setOpaque(false);
        pnlPrincipal1.setPreferredSize(new java.awt.Dimension(850, 850));
        pnlPrincipal1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 179, 61));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Aprobación");
        pnlPrincipal1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, -1));

        txtNombreActividad.setBackground(new java.awt.Color(212, 255, 204));
        txtNombreActividad.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombreActividad.setForeground(new java.awt.Color(0, 204, 51));
        txtNombreActividad.setToolTipText("");
        txtNombreActividad.setBorder(null);
        txtNombreActividad.setOpaque(false);
        txtNombreActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActividadActionPerformed(evt);
            }
        });
        pnlPrincipal1.add(txtNombreActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 230, 25));

        jSeparator2.setBackground(new java.awt.Color(0, 179, 61));
        jSeparator2.setForeground(new java.awt.Color(0, 179, 61));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnlPrincipal1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 230, 26));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 179, 61));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ONG");
        pnlPrincipal1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 179, 61));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Actividad");
        pnlPrincipal1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 120, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        pnlPrincipal1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 330, 80));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 179, 61));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descripción");
        pnlPrincipal1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 120, -1));

        txtHoraApertura.setBackground(new java.awt.Color(212, 255, 204));
        txtHoraApertura.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtHoraApertura.setForeground(new java.awt.Color(0, 204, 51));
        txtHoraApertura.setToolTipText("");
        txtHoraApertura.setBorder(null);
        txtHoraApertura.setOpaque(false);
        txtHoraApertura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraAperturaActionPerformed(evt);
            }
        });
        pnlPrincipal1.add(txtHoraApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 230, 25));

        jSeparator4.setBackground(new java.awt.Color(0, 179, 61));
        jSeparator4.setForeground(new java.awt.Color(0, 179, 61));
        jSeparator4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnlPrincipal1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 230, 25));

        cmbAprobacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAprobacionActionPerformed(evt);
            }
        });
        pnlPrincipal1.add(cmbAprobacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 230, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 179, 61));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Habitat");
        pnlPrincipal1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 179, 61));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Hora Apertura");
        pnlPrincipal1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 120, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 179, 61));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Hora Cierre");
        pnlPrincipal1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 120, -1));

        cmbHabitat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHabitatActionPerformed(evt);
            }
        });
        pnlPrincipal1.add(cmbHabitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 230, 30));

        txtNombreONG.setBackground(new java.awt.Color(212, 255, 204));
        txtNombreONG.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombreONG.setForeground(new java.awt.Color(0, 204, 51));
        txtNombreONG.setToolTipText("");
        txtNombreONG.setBorder(null);
        txtNombreONG.setOpaque(false);
        txtNombreONG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreONGActionPerformed(evt);
            }
        });
        pnlPrincipal1.add(txtNombreONG, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 230, 25));

        jSeparator5.setBackground(new java.awt.Color(0, 179, 61));
        jSeparator5.setForeground(new java.awt.Color(0, 179, 61));
        jSeparator5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnlPrincipal1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 230, 26));

        txtHoraCierre.setBackground(new java.awt.Color(212, 255, 204));
        txtHoraCierre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtHoraCierre.setForeground(new java.awt.Color(0, 204, 51));
        txtHoraCierre.setToolTipText("");
        txtHoraCierre.setBorder(null);
        txtHoraCierre.setOpaque(false);
        txtHoraCierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraCierreActionPerformed(evt);
            }
        });
        pnlPrincipal1.add(txtHoraCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 230, 25));

        jSeparator6.setBackground(new java.awt.Color(0, 179, 61));
        jSeparator6.setForeground(new java.awt.Color(0, 179, 61));
        jSeparator6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pnlPrincipal1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 230, 26));

        pnlRegistroActividad.add(pnlPrincipal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 530));

        add(pnlRegistroActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 850, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActividadActionPerformed

    private void txtHoraAperturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraAperturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraAperturaActionPerformed

    private void cmbAprobacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAprobacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAprobacionActionPerformed

    private void cmbHabitatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHabitatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHabitatActionPerformed

    private void txtNombreONGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreONGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreONGActionPerformed

    private void txtHoraCierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraCierreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraCierreActionPerformed

    private void ckbMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbMiercolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbMiercolesActionPerformed

    private void ckbSabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbSabadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbSabadoActionPerformed

    private void ckbDomingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbDomingoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckbDomingoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JCheckBox ckbDomingo;
    public javax.swing.JCheckBox ckbJueves;
    public javax.swing.JCheckBox ckbMartes;
    public javax.swing.JCheckBox ckbMiercoles;
    public javax.swing.JCheckBox ckbSabado;
    public javax.swing.JCheckBox ckbViernes;
    public javax.swing.JComboBox<String> cmbAprobacion;
    public javax.swing.JComboBox<String> cmbHabitat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel pnlBarraOpciones;
    private javax.swing.JPanel pnlBarraTitulo;
    private javax.swing.JPanel pnlImagen;
    private javax.swing.JPanel pnlPrincipal1;
    private javax.swing.JPanel pnlRegistroActividad;
    private javax.swing.JPanel pnlSelDias;
    public javax.swing.JTextArea txtDescripcion;
    public javax.swing.JTextField txtHoraApertura;
    public javax.swing.JTextField txtHoraCierre;
    public javax.swing.JTextField txtNombreActividad;
    public javax.swing.JTextField txtNombreONG;
    // End of variables declaration//GEN-END:variables
}
