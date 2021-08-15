/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PDoctorRole;

import DataStore.ItemTuple;
import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Medicine.Medicine;
import Order.Order;
import Patient.Patient;
import Personnel.Person;
import Personnel.Role;
import Pharmacy.Pharmacy;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sravy
 */
public class PrescribeMedicinesJPanel extends javax.swing.JPanel {

    private EcoSystem ecosys;
    private Doctor doctor;
    private JPanel workArea;
    private ArrayList<String> currentOrders;
    /**
     * Creates new form ViewPPatientsJPanel
     */
    public PrescribeMedicinesJPanel(JPanel workArea, EcoSystem ecoSystem, Doctor doctor) {
        this.workArea = workArea;
        this.ecosys = ecoSystem;
        this.doctor = doctor;
        this.currentOrders = new ArrayList<>();
        initComponents();
        populateCmbSelectPatientName();
        populateTblMedicineTableAddPres();
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
        jLabel3 = new javax.swing.JLabel();
        txtViewPatientInsuranceID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtViewPatientDOB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtViewPatientAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSendPrescription = new javax.swing.JButton();
        lblSelectPatient1 = new javax.swing.JLabel();
        cmbSelectPatientName1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMedicineTableAddPres = new javax.swing.JTable();
        jSpinQuantity = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        btnAddQuantity = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCurrentPres = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtPatientPharmName = new javax.swing.JTextField();

        jLabel1.setText("Patient Details");

        jLabel3.setText("Insurance ID:");

        jLabel4.setText("DOB:");

        jLabel5.setText("Address:");

        jLabel7.setText("Preferred Pharmacy:");

        btnSendPrescription.setText("Send Prescription");
        btnSendPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendPrescriptionActionPerformed(evt);
            }
        });

        lblSelectPatient1.setText("Select Patient:");

        cmbSelectPatientName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectPatientName1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Prescribe Medicine");

        tblMedicineTableAddPres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Medicine Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblMedicineTableAddPres);

        jLabel2.setText("Quantity");

        btnAddQuantity.setText("Add Quantity");
        btnAddQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQuantityActionPerformed(evt);
            }
        });

        jLabel6.setText("Medicines Table:");

        tblCurrentPres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Medicine Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblCurrentPres);

        jLabel8.setText("Current Prescription Table:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtViewPatientDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtViewPatientAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(txtPatientPharmName)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblSelectPatient1)
                                                .addGap(13, 13, 13)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbSelectPatientName1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtViewPatientInsuranceID, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jSpinQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddQuantity))
                            .addComponent(jLabel8)
                            .addComponent(btnSendPrescription)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel9)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSelectPatientName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelectPatient1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtViewPatientInsuranceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtViewPatientDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtViewPatientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPatientPharmName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddQuantity)))
                .addGap(43, 43, 43)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSendPrescription)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSelectPatientName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectPatientName1ActionPerformed
        // TODO add your handling code here:
        if (cmbSelectPatientName1.getSelectedItem() == null){
            ;
        } else {
                 
            Patient p = (Patient) cmbSelectPatientName1.getSelectedItem();

            try {
                txtPatientPharmName.setText(p.getPreferredPharmacy().toString());
                txtViewPatientAddress.setText(p.getPersonDetails().getAddress().toString());
                txtViewPatientDOB.setText(p.getPersonDetails().getDob().toString());
                txtViewPatientInsuranceID.setText(p.getPatientDetails().getId());
            }  catch(Exception err) {
                JOptionPane.showMessageDialog(null, "Unable to select the patient due to an error. Shimatta :/(", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_cmbSelectPatientName1ActionPerformed

    private void btnAddQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddQuantityActionPerformed
        // TODO add your handling code here:
        
        int quantity = Integer.parseInt(jSpinQuantity.getValue().toString());
        
        int selectedRow = tblMedicineTableAddPres.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Please Select a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Patient patient = (Patient) cmbSelectPatientName1.getSelectedItem();
        Medicine med = ecosys
                .getMedicineDirectory()
                .getMedicineCatalogMap()
                .get(tblMedicineTableAddPres
                        .getValueAt(selectedRow, 0)
                        .toString()
                );
        
        Pharmacy pharmacy = patient.getPreferredPharmacy();

        this.currentOrders.add(ecosys
                .getOrderDirectory()
                .addOrder(pharmacy, doctor, patient, quantity, med));

    }//GEN-LAST:event_btnAddQuantityActionPerformed

    private void btnSendPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendPrescriptionActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSendPrescriptionActionPerformed

    private void populateCmbSelectPatientName(){
        
        cmbSelectPatientName1.addItem(null);
        for(Person p: ecosys.globalUserDirectory.getByRole(Role.PATIENT)){
            cmbSelectPatientName1.addItem(p);
        }
    }
    
    
        public void populateTblMedicineTableAddPres(){
        
            DefaultTableModel model = (DefaultTableModel) tblMedicineTableAddPres.getModel();

            model.setRowCount(0);

            for (ItemTuple tup: ecosys.getMedicineDirectory().medicineCatalogMap.getAllItems()){
                Object[] row = new Object[2];
                row[0] = tup.getKey().toString();
                row[1] = tup.getValue().toString();

                model.addRow(row);
            }
        }
        
        
        
        public void populateTblCurrentPrescriptions(){
        
            DefaultTableModel model = (DefaultTableModel) tblCurrentPres.getModel();

            model.setRowCount(0);

            for (String orderId: this.currentOrders){
                Order order = ecosys.getOrderDirectory().orderMap.get(orderId);
                Object[] row = new Object[3];
                row[0] = order.getMedicine().getMedicineId();
                row[1] = order.getMedicine().getMedicineName();
                row[2] = order.getQuantity();
                model.addRow(row);
            }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddQuantity;
    private javax.swing.JButton btnSendPrescription;
    private javax.swing.JComboBox<Person> cmbSelectPatientName1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinQuantity;
    private javax.swing.JLabel lblSelectPatient1;
    private javax.swing.JTable tblCurrentPres;
    private javax.swing.JTable tblMedicineTableAddPres;
    private javax.swing.JTextField txtPatientPharmName;
    private javax.swing.JTextField txtViewPatientAddress;
    private javax.swing.JTextField txtViewPatientDOB;
    private javax.swing.JTextField txtViewPatientInsuranceID;
    // End of variables declaration//GEN-END:variables
}