/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PSysAdminRole;

import DataStore.ItemTuple;
import EcoSystem.EcoSystem;
import Medicine.Medicine;
import Medicine.MedicineDirectory;
import Enterprise.PharmacyEnterprise;
import Pharmacy.PharmacyDirectory;
import java.awt.CardLayout;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sravy
 */
public class ManageMedicinesJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private EcoSystem ecoSystem;
    public ManageMedicinesJPanel(JPanel workArea, EcoSystem ecoSystem) {
        initComponents();
        this.workArea = workArea;
        this.ecoSystem = ecoSystem;
        populateMngMedicinesTable();
    }
    
    
    private void populateMngMedicinesTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblManageMedicines.getModel();
        dtm.setRowCount(0);
        
        for(ItemTuple tup : ecoSystem.getMedicineDirectory().medicineCatalogMap.getAllItems()) {
                Object [] row = new Object[3];
                Medicine medicine = (Medicine) tup.getValue();
                row[0] = tup.getKey();
                row[1] = medicine.getMedicineName();
                row[3] = medicine.getPrice();
                dtm.addRow(row);
        }
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
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMedicineName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMedicinePrice = new javax.swing.JTextField();
        btnAddMedicine = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblManageMedicines = new javax.swing.JTable();
        btnUpdateMedicine = new javax.swing.JButton();
        lblMfgDateAddMedicine = new javax.swing.JLabel();
        chooserMfgDate = new com.toedter.calendar.JDateChooser();
        jLblexpDate = new javax.swing.JLabel();
        jDateChooserExpDateManageMedicine = new com.toedter.calendar.JDateChooser();

        jLabel1.setText("Manage Medicines");

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Medicine Name:");

        jLabel4.setText("Price:");

        txtMedicinePrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedicinePriceActionPerformed(evt);
            }
        });

        btnAddMedicine.setText("Add");
        btnAddMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMedicineActionPerformed(evt);
            }
        });

        tblManageMedicines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Medicine Name", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblManageMedicines);

        btnUpdateMedicine.setText("Update");
        btnUpdateMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMedicineActionPerformed(evt);
            }
        });

        lblMfgDateAddMedicine.setText("Mfg Date");

        jLblexpDate.setText("Exp Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(84, 84, 84)
                                .addComponent(txtMedicinePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMfgDateAddMedicine)
                                .addGap(18, 18, 18)
                                .addComponent(chooserMfgDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLblexpDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooserExpDateManageMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(btnAddMedicine))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnBack)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1)))
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateMedicine))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateMedicine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMedicineName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMfgDateAddMedicine)
                            .addComponent(jLblexpDate)
                            .addComponent(jDateChooserExpDateManageMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtMedicinePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(chooserMfgDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddMedicine)
                .addGap(61, 61, 61))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        workArea.remove(this);
        CardLayout layout=(CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtMedicinePriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedicinePriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedicinePriceActionPerformed

    private void btnAddMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMedicineActionPerformed
        // TODO add your handling code here:
        try{            
           Date mfg = chooserMfgDate.getDate();

           LocalDate mfgDate = Instant.ofEpochMilli(mfg.getTime())
           .atZone(ZoneId.systemDefault())
           .toLocalDate();

           Date exp = chooserMfgDate.getDate();

           LocalDate expDate = Instant.ofEpochMilli(exp.getTime())
           .atZone(ZoneId.systemDefault())
           .toLocalDate();

            
            ecoSystem.getMedicineDirectory().addMedicine(
                    txtMedicineName.getText(),
                    Double.parseDouble(txtMedicinePrice.getText()),
                    expDate,
                    mfgDate
                    );
            
            
            JOptionPane.showMessageDialog(null, "Medicine added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
            populateMngMedicinesTable();
        } catch(Exception e){
            JOptionPane.showInternalMessageDialog(this, "Kindly fill in the details in correct format.");
        }
    }//GEN-LAST:event_btnAddMedicineActionPerformed

    private void btnUpdateMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMedicineActionPerformed
        // TODO add your handling code here:
        UpdateMedicineJPanel ump = new UpdateMedicineJPanel(workArea, ecoSystem);
        workArea.add("UpdateMedicineJPanel", ump);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
        
    }//GEN-LAST:event_btnUpdateMedicineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMedicine;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdateMedicine;
    private com.toedter.calendar.JDateChooser chooserMfgDate;
    private com.toedter.calendar.JDateChooser jDateChooserExpDateManageMedicine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblexpDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMfgDateAddMedicine;
    private javax.swing.JTable tblManageMedicines;
    private javax.swing.JTextField txtMedicineName;
    private javax.swing.JTextField txtMedicinePrice;
    // End of variables declaration//GEN-END:variables
}
