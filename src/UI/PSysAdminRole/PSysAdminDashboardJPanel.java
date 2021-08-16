/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PSysAdminRole;

import DeliveryMan.DeliveryManDirectory;
import EcoSystem.EcoSystem;
import Medicine.MedicineDirectory;
import Pharmacy.PharmacyDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;


/**
 *
 * @author Sravya
 */
public class PSysAdminDashBoardJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private PharmacyDirectory pharmacyDirectory;
    private EcoSystem ecoSystem;
    private MedicineDirectory medicineDirectory;
    private DeliveryManDirectory deliveryManDirectory;
    
    public PSysAdminDashBoardJPanel(JPanel workArea, EcoSystem ecoSystem) {
        this.workArea = workArea;
        this.ecoSystem = ecoSystem;
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

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        btnManagePharmacy = new javax.swing.JButton();
        btnManageDeliveryMan = new javax.swing.JButton();
        btnManageMedicines = new javax.swing.JButton();
        btnMngPharmacist = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("System Admin Dash Board");

        btnManagePharmacy.setBackground(new java.awt.Color(255, 204, 255));
        btnManagePharmacy.setText("Manage Pharmacy");
        btnManagePharmacy.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManagePharmacy.setBorderPainted(false);
        btnManagePharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePharmacyActionPerformed(evt);
            }
        });

        btnManageDeliveryMan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageDeliveryMan.setText("Manage Delivery Men");
        btnManageDeliveryMan.setContentAreaFilled(false);
        btnManageDeliveryMan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnManageDeliveryMan.setOpaque(true);
        btnManageDeliveryMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDeliveryManActionPerformed(evt);
            }
        });

        btnManageMedicines.setText("Manage Medicines");
        btnManageMedicines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageMedicinesActionPerformed(evt);
            }
        });

        btnMngPharmacist.setText("Manage Pharmacist");
        btnMngPharmacist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngPharmacistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnManageDeliveryMan, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(btnManagePharmacy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnManageMedicines, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addComponent(btnMngPharmacist)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnManagePharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMngPharmacist))
                .addGap(28, 28, 28)
                .addComponent(btnManageDeliveryMan)
                .addGap(33, 33, 33)
                .addComponent(btnManageMedicines, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManagePharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePharmacyActionPerformed
        ManagePharmacyDetailsJPanel ms = new ManagePharmacyDetailsJPanel(workArea, ecoSystem);
        workArea.add("ManagePharmacyAdministrative", ms);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnManagePharmacyActionPerformed

    private void btnManageDeliveryManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageDeliveryManActionPerformed
        ManageDeliveryManJPanel manageDeliveryManJPanel = new ManageDeliveryManJPanel(workArea, ecoSystem);
        workArea.add("ManageDeliveryManJPanel",manageDeliveryManJPanel);
        CardLayout layout=(CardLayout)workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnManageDeliveryManActionPerformed

    private void btnManageMedicinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageMedicinesActionPerformed
        // TODO add your handling code here:
        ManageMedicinesJPanel ms = new ManageMedicinesJPanel(workArea, ecoSystem);
        workArea.add("ManageMedicinesJPanel", ms);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnManageMedicinesActionPerformed

    private void btnMngPharmacistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngPharmacistActionPerformed
        // TODO add your handling code here:
        ManagePharmacistJPanel managePharmacistJPanel = new ManagePharmacistJPanel(workArea, ecoSystem);
        workArea.add("ManagePharmacistJPanel", managePharmacistJPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnMngPharmacistActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageDeliveryMan;
    private javax.swing.JButton btnManageMedicines;
    private javax.swing.JButton btnManagePharmacy;
    private javax.swing.JButton btnMngPharmacist;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
