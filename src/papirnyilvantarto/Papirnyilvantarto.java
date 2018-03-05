/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papirnyilvantarto;

/**
 *
 * @author Darázsi Márk
 */
public class Papirnyilvantarto extends javax.swing.JFrame {

    DB ab;
    
    /**
     * Creates new form Papirnyilvantarto
     */
    public Papirnyilvantarto() {
        initComponents();
        ab = new DB();
        ab.keszlet_be(tblKeszlet);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblKeszlet = new javax.swing.JTable();
        btnKereses = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKereso = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblKeszlet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblKeszlet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblKeszlet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tárhely", "Megnevezés", "Grammsúly", "Méret", "Szálirány", "Mennyiség"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKeszlet.setColumnSelectionAllowed(true);
        tblKeszlet.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblKeszlet.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblKeszlet.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblKeszlet);
        tblKeszlet.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblKeszlet.getColumnModel().getColumnCount() > 0) {
            tblKeszlet.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblKeszlet.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblKeszlet.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblKeszlet.getColumnModel().getColumn(3).setPreferredWidth(40);
            tblKeszlet.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        btnKereses.setBackground(new java.awt.Color(0, 204, 0));
        btnKereses.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnKereses.setText("Keresés");
        btnKereses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeresesActionPerformed(evt);
            }
        });

        txtKereso.setColumns(20);
        txtKereso.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtKereso.setRows(1);
        txtKereso.setTabSize(10);
        txtKereso.setAutoscrolls(false);
        jScrollPane2.setViewportView(txtKereso);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKereses)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKereses, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKeresesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeresesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKeresesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Papirnyilvantarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Papirnyilvantarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Papirnyilvantarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Papirnyilvantarto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Papirnyilvantarto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKereses;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKeszlet;
    private javax.swing.JTextArea txtKereso;
    // End of variables declaration//GEN-END:variables
}