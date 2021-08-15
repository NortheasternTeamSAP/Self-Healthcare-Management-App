/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PharmacistRole;

import EcoSystem.EcoSystem;
import Medicine.Medicine;
import Pharmacy.Pharmacy;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Sravya
 */
public class ViewMedicineDetailsJPanel extends javax.swing.JPanel {
    private JPanel workArea;
    private EcoSystem ecoSystem;
    private Medicine medicine;
    private Pharmacy pharmacy;
    
    public ViewMedicineDetailsJPanel(JPanel workArea, EcoSystem ecoSystem, Medicine medicine) {
        initComponents();
        this.workArea = workArea;
        this.ecoSystem = ecoSystem;
        this.medicine = medicine;
        this.pharmacy = pharmacy;
        displayMedicineDetails();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        backButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtViewMedicineName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtViewMedicineID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtViewPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtViewAvailability = new javax.swing.JTextField();

        jLabel1.setText("View Medicine Details");

        backButton1.setText("<< Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Medicine Name:");

        jLabel3.setText("Medicine ID:");

        jLabel4.setText("Price:");

        jLabel5.setText("Available Quantity:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(backButton1)
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtViewMedicineName)
                            .addComponent(txtViewMedicineID)
                            .addComponent(txtViewPrice)
                            .addComponent(txtViewAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                .addContainerGap(217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton1)
                    .addComponent(jLabel1))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtViewMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtViewMedicineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtViewPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtViewAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(247, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        workArea.remove(this);
        CardLayout layout=(CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_backButton1ActionPerformed

    private void displayMedicineDetails(){
        txtViewMedicineName.setText(medicine.getMedicineName());
        txtViewMedicineID.setText(medicine.getMedicineId());
        txtViewPrice.setText(String.valueOf(medicine.getPrice()));
        txtViewAvailability.setText(String.valueOf(pharmacy.getMedicineStockMap().get(medicine)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtViewAvailability;
    private javax.swing.JTextField txtViewMedicineID;
    private javax.swing.JTextField txtViewMedicineName;
    private javax.swing.JTextField txtViewPrice;
    // End of variables declaration//GEN-END:variables
}