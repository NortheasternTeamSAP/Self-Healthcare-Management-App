/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PDoctorRole;

import Doctor.Doctor;
import EcoSystem.EcoSystem;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author sravy
 */
public class PDoctorDashBoardJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private EcoSystem ecoSystem;
    private Doctor doctor;
    
    public PDoctorDashBoardJPanel(JPanel workArea, EcoSystem ecoSystem, Doctor doctor) {
        this.workArea = workArea;
        this.ecoSystem = ecoSystem;
        this.doctor = doctor;
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

        btnPrescribeMedicines = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        btnPrescribeMedicines.setText("Prescribe Medicines");
        btnPrescribeMedicines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrescribeMedicinesActionPerformed(evt);
            }
        });

        jLabel1.setText("Doctor Dashboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnPrescribeMedicines))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel1)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnPrescribeMedicines)
                .addContainerGap(437, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrescribeMedicinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrescribeMedicinesActionPerformed
        // TODO add your handling code here:
        PrescribeMedicinesJPanel prescribeMedicinesJPanel = new PrescribeMedicinesJPanel(workArea, ecoSystem, doctor);
        workArea.add("PrescribeMedicinesJPanel", prescribeMedicinesJPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnPrescribeMedicinesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrescribeMedicines;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
