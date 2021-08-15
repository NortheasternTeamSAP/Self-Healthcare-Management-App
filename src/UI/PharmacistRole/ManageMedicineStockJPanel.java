/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.PharmacistRole;

import DataStore.ItemTuple;
import EcoSystem.EcoSystem;
import Medicine.Medicine;
import Pharmacy.Pharmacy;
import java.awt.CardLayout;
import java.util.Map.Entry;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sravya
 */
public class ManageMedicineStockJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private Pharmacy pharmacy;
    private EcoSystem ecoSystem;
    
    public ManageMedicineStockJPanel(JPanel workArea, Pharmacy pharmacy, EcoSystem ecoSystem) {
        initComponents();
        workArea = workArea;
        pharmacy = pharmacy;
        ecoSystem = ecoSystem;
        lblPharmacy.setText("Pharmacy: " + pharmacy.getPharmacyName());
        refreshTable();
    }
    
    public void refreshTable() {

        DefaultTableModel model = (DefaultTableModel) tblMedicineCatalog.getModel();
        model.setRowCount(0);

        for (Entry<Medicine, Integer> tup : pharmacy.getMedicineStockMap().entrySet()) {
            Object row[] = new Object[4];
            row[0] = tup.getKey().getMedicineId();
            row[1] = tup.getKey().getMedicineName();
            row[2] = tup.getKey().getPrice();
            row[3] = tup.getValue();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedicineCatalog = new javax.swing.JTable();
        lblPharmacy = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnAddStock = new javax.swing.JButton();

        tblMedicineCatalog.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblMedicineCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Medicine Name", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMedicineCatalog);

        lblPharmacy.setText("Pharmacy:");

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitle.setText("Manage Medicine Stock");

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setText("Delete ");
        btnDelete.setBorderPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAddStock.setText("Add Stock");
        btnAddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(lblTitle))
                    .addComponent(lblPharmacy, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddStock, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(lblPharmacy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnAddStock))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        int selectedRowIndex = tblMedicineCatalog.getSelectedRow();

        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Medicine med = (Medicine) tblMedicineCatalog.getValueAt(selectedRowIndex, 0);
        ecoSystem.getMedicineDirectory().deleteMedicine(med);
        refreshTable();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddMedicineStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMedicineStockActionPerformed


    }//GEN-LAST:event_btnAddMedicineStockActionPerformed

    private void btnAddStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStockActionPerformed
        // TODO add your handling code here:
        AddMedicineStockJPanel amsjp = new AddMedicineStockJPanel(workArea, pharmacy, ecoSystem);
        workArea.add("AddMedicineStockJPanel", amsjp);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnAddStockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStock;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPharmacy;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblMedicineCatalog;
    // End of variables declaration//GEN-END:variables
}
