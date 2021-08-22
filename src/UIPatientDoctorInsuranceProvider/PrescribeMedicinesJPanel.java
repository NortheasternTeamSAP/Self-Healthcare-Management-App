/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import DataStore.Appointment;
import DataStore.ItemTuple;
import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Medicine.Medicine;
import Order.Order;
import Patient.Patient;
import Personnel.Person;
import Personnel.Role;
import Enterprise.PharmacyEnterprise;
import Prescription.Dosage;
import Utils.NextScreen;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sravy
 */
public class PrescribeMedicinesJPanel extends javax.swing.JPanel implements NextScreen {

    private EcoSystem ecosys;
    private Doctor doctor;
    private JPanel workArea;
    private ArrayList<String> currentOrders;
    private Appointment appointment;
    private JPanel backPage;
    /**
     * Creates new form ViewPPatientsJPanel
     */
    public PrescribeMedicinesJPanel(JPanel workArea, EcoSystem ecoSystem, Appointment appointment, JPanel backPage) {
        this.workArea = workArea;
        this.ecosys = ecoSystem;
        this.doctor = (Doctor) appointment.getDoctor();
        this.currentOrders = new ArrayList<>();
        this.appointment = appointment;
        this.backPage = backPage;
        initComponents();
        this.setSize(1100,850);
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
        jButtonBack = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldDosage = new javax.swing.JTextField();
        jCheckBoxPostLunch = new javax.swing.JCheckBox();
        jCheckBoxPostDinner = new javax.swing.JCheckBox();
        jTextFieldDosageNotes = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jCheckBoxPreLunch = new javax.swing.JCheckBox();
        jCheckBoxPreDinner = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Patient Details");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 73, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Insurance ID:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 150, -1, -1));

        txtViewPatientInsuranceID.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtViewPatientInsuranceID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtViewPatientInsuranceID, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 148, 138, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Date Of Birth:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 188, -1, -1));

        txtViewPatientDOB.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtViewPatientDOB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtViewPatientDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 186, 138, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("Address:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 224, -1, -1));

        txtViewPatientAddress.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtViewPatientAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtViewPatientAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 224, 138, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel7.setText("Preferred Pharmacy:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 140, -1));

        lblSelectPatient1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblSelectPatient1.setText("Select Patient:");
        add(lblSelectPatient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 109, -1, -1));

        cmbSelectPatientName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectPatientName1ActionPerformed(evt);
            }
        });
        add(cmbSelectPatientName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 104, 138, -1));

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel9.setText("Prescribe Medicine");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 23, -1, -1));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 680, 140));
        add(jSpinQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, 76, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Quantity");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, -1, 30));

        btnAddQuantity.setBackground(new java.awt.Color(255, 255, 255));
        btnAddQuantity.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAddQuantity.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/check_avail.png"))); // NOI18N
        btnAddQuantity.setText("Add Prescription");
        btnAddQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQuantityActionPerformed(evt);
            }
        });
        add(btnAddQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 630, -1, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setText("Medicines Table:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 305, -1, -1));

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

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 710, 670, 130));

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel8.setText("Current Prescription Table:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 180, 30));

        txtPatientPharmName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtPatientPharmName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtPatientPharmName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 138, -1));

        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        jButtonBack.setContentAreaFilled(false);
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 13, -1, -1));

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel10.setText("Notes");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, -1, -1));

        jTextFieldDosage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(jTextFieldDosage, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 76, -1));

        jCheckBoxPostLunch.setText("PostLunch");
        add(jCheckBoxPostLunch, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, -1, -1));

        jCheckBoxPostDinner.setText("PostDinner");
        add(jCheckBoxPostDinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, -1, -1));
        add(jTextFieldDosageNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 165, 69));

        jLabel11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel11.setText("Dosage");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, -1, 30));

        jCheckBoxPreLunch.setText("PreLunch");
        add(jCheckBoxPreLunch, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, -1));

        jCheckBoxPreDinner.setText("PreDinner");
        add(jCheckBoxPreDinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1100, 850));
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
        
        PharmacyEnterprise pharmacy = patient.getPreferredPharmacy();
        
        int dosageCount = 0;
        try {
            dosageCount = Integer.parseInt(jTextFieldDosage.getText());
            if (dosageCount < 1 && dosageCount > 5) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Invalid dosage value. Please add a numeric value between 1 and 5", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Dosage dosage = new Dosage(
                dosageCount, 
                -1, 
                jTextFieldDosageNotes.getText(), 
                jCheckBoxPreLunch.isSelected(), 
                jCheckBoxPostLunch.isSelected(), 
                jCheckBoxPreDinner.isSelected(), 
                jCheckBoxPostDinner.isSelected());
        
        this.currentOrders.add(ecosys
                .getOrderDirectory()
                .addOrder(pharmacy, doctor, patient, quantity, med, dosage, appointment));
        populateTblCurrentPrescriptions();

    }//GEN-LAST:event_btnAddQuantityActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        nextScreen(workArea, backPage, "PatientAppoiontmentDetailsPage");
    }//GEN-LAST:event_jButtonBackActionPerformed

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
    private javax.swing.JComboBox<Person> cmbSelectPatientName1;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JCheckBox jCheckBoxPostDinner;
    private javax.swing.JCheckBox jCheckBoxPostLunch;
    private javax.swing.JCheckBox jCheckBoxPreDinner;
    private javax.swing.JCheckBox jCheckBoxPreLunch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField jTextFieldDosage;
    private javax.swing.JTextField jTextFieldDosageNotes;
    private javax.swing.JLabel lblSelectPatient1;
    private javax.swing.JTable tblCurrentPres;
    private javax.swing.JTable tblMedicineTableAddPres;
    private javax.swing.JTextField txtPatientPharmName;
    private javax.swing.JTextField txtViewPatientAddress;
    private javax.swing.JTextField txtViewPatientDOB;
    private javax.swing.JTextField txtViewPatientInsuranceID;
    // End of variables declaration//GEN-END:variables
}
