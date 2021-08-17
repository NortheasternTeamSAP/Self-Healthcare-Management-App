/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PSysAdminRole;

import EcoSystem.EcoSystem;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sravy
 */
public class ManagePharmacistJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private EcoSystem ecoSystem;
    
    public ManagePharmacistJPanel(JPanel workArea, EcoSystem ecoSystem) {
        this.workArea = workArea;
        this.ecoSystem = ecoSystem;
        initComponents();
        populatePharmacistTable();
    }
    
    public void populatePharmacistTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblMngPharmacist.getModel();
        dtm.setRowCount(0);
        
        for(Pharmacist pharmacist: ecoSystem.)
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDeletePharmacist = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMngPharmacist = new javax.swing.JTable();
        btnAddPharmacist = new javax.swing.JButton();
        btnUpdatePharmacist = new javax.swing.JButton();

        btnDeletePharmacist.setText("Delete ");
        btnDeletePharmacist.setContentAreaFilled(false);
        btnDeletePharmacist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePharmacistActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Pharmacist Details");

        btnBack.setText("Back");
        btnBack.setToolTipText("Back");
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Manage Pharmacist");

        tblMngPharmacist.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblMngPharmacist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pharmacy Name", "Pharmacist"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMngPharmacist);

        btnAddPharmacist.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnAddPharmacist.setText("Add");
        btnAddPharmacist.setToolTipText("");
        btnAddPharmacist.setContentAreaFilled(false);
        btnAddPharmacist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPharmacistActionPerformed(evt);
            }
        });

        btnUpdatePharmacist.setText("Update");
        btnUpdatePharmacist.setContentAreaFilled(false);
        btnUpdatePharmacist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePharmacistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1)
                        .addGap(334, 334, 334))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddPharmacist, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnUpdatePharmacist, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnDeletePharmacist, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddPharmacist, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdatePharmacist, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletePharmacist, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(320, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletePharmacistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePharmacistActionPerformed

    }//GEN-LAST:event_btnDeletePharmacistActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddPharmacistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPharmacistActionPerformed

    }//GEN-LAST:event_btnAddPharmacistActionPerformed

    private void btnUpdatePharmacistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePharmacistActionPerformed

    }//GEN-LAST:event_btnUpdatePharmacistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPharmacist;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeletePharmacist;
    private javax.swing.JButton btnUpdatePharmacist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMngPharmacist;
    // End of variables declaration//GEN-END:variables
}
