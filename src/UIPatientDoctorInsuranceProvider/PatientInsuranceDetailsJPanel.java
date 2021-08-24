/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import static Enterprise.EnterpriseType.INSURANCE_COMPANY;
import Insurance.HealthInsurancePlans;
import Insurance.InsuranceDetails;
import Insurance.InsuranceDetails.InsuranceRequestApprovalStatus;
import Insurance.InsurancePlanDetails;
import Organization.HealthInsuranceDepartmentOrganization;
import Organization.Organization;
import static Organization.OrganizationType.HEALTH_INSURANCE_DEPARTMENT;
import Patient.Patient;
import SysAdminUI.CreateRolesJPanel;
import Utils.FieldsDecorator;
import Utils.NextScreen;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mrs.katey
 */
public class PatientInsuranceDetailsJPanel extends javax.swing.JPanel implements NextScreen {

    JPanel WorkAreaPanel;
    EcoSystem ecoSystem;
    Patient patient;
    JPanel backPage;
    
    PatientInsuranceDetailsJPanel(JPanel WorkAreaPanel, EcoSystem ecoSystem, Patient patient, JPanel backPage) {
        initComponents();
        this.setSize(1100,850);
        this.WorkAreaPanel = WorkAreaPanel;
        this.ecoSystem = ecoSystem;
        this.patient = patient;
        this.backPage = backPage;
        updateCurrentInsuranceDetails(patient.getInsuranceDetails());

    }
    
    
    
    void updateCurrentInsuranceDetails(InsuranceDetails insuranceDetails) {
        if (insuranceDetails == null) {
            // No insurance yet set
            lblAddNewInsurance.setText("Add new insurance");
            currentInsuranceFieldsEnableDisable(false);
            populateNewInsuranceDetails();
            jButtonSendInsuranceRequestPlaceHolder.setText("Request New Insurance");
            return;
        }
        
        if (insuranceDetails.getInsuranceRequestApprovalStatus().equals(InsuranceRequestApprovalStatus.APPROVED)) {
            lblAddNewInsurance.setText("Request insurance update?");
            jButtonSendInsuranceRequestPlaceHolder.setText("Update insurance");
            insuranceUpdateFieldsEnableDisable(false);
            currentInsuranceFieldsEnableDisable(true);
            txtPatientName.setText(insuranceDetails.getPatient().getPersonDetails().getFullName());
            txtInsuranceNumber.setText(insuranceDetails.getInsuranceNumber() + "");
            txtGroupNumber.setText(insuranceDetails.getGroupNumber() + "");
            txtInsuranceProviderName.setText(insuranceDetails.getInsuranceProvider().getEnterpriseName());
            txtInsuranceType.setText("General Health Insurance");
            txtInsurancePlanExpiryDate.setText(insuranceDetails.getExpiryDate().toString());
            jTextAreaInsuranceDetails.append(insuranceDetails.getCoverageDetails().getFormattedDetails());
            currentInsuranceFieldsEnableDisable(false);
            populateNewInsuranceDetails();
            return;
        }
    }
    
    void populateNewInsuranceDetails() {
        jComboBoxInsuranceEnterprise.removeAllItems();
        jComboBoxInsuranceHealthPlan.removeAllItems();
        insuranceUpdateFieldsEnableDisable(true);
        updateInsuranceEnterpriseCombo();
        
    }
    
    void updateInsuranceEnterpriseCombo() {
        List<Enterprise> insuranceEnterprises = ecoSystem.enterpriseDirectory.getEnterpriseByType(INSURANCE_COMPANY);
        jComboBoxInsuranceEnterprise.addItem("Select");
        for (Enterprise enterprise : insuranceEnterprises) {
            jComboBoxInsuranceEnterprise.addItem(enterprise.getEnterpriseName() + ":" + enterprise.getEnterpriseId());
        }
        
        Set<String> planNames = new HealthInsurancePlans().getALLPlanNames();
        jComboBoxInsuranceHealthPlan.addItem("Select");
        for (String planName : planNames) {
            jComboBoxInsuranceHealthPlan.addItem(planName);
        }
        
        jComboBoxInsuranceHealthPlan.addItemListener(new ItemListener() {
            
            PatientInsuranceDetailsJPanel parentPanel;
            
            @Override
            public void itemStateChanged(ItemEvent e) {
                String selectedPlan = parentPanel.getSelectedInsurancePlanFromComboList();
                if (selectedPlan == null) {
                    // do nothing
                    return;
                }
                
                parentPanel.populateSelectedPlanDetails(selectedPlan);
            }
            
             private ItemListener init(PatientInsuranceDetailsJPanel parentPanel){
                this.parentPanel = parentPanel;
                return this;
            }
        }.init(this));
    }
    
    String getSelectedInsurancePlanFromComboList() {   
        String selectedPlan = (String) jComboBoxInsuranceHealthPlan.getSelectedItem();
        if (selectedPlan == null) {
            return null;
        }
        
        if ("Select".equals(selectedPlan)) {
            // Do nothing
            return null;
        }
        
        return selectedPlan;
    }
    
    void populateSelectedPlanDetails(String selectedPlan) {
        InsurancePlanDetails insurancePlanDetails = new HealthInsurancePlans().getPlanDetails(selectedPlan);
        if (insurancePlanDetails == null) {
            JOptionPane.showMessageDialog(jPanel1, "No insurance plan details found for the selected plan");
            return;
        }
        jTextAreaSelectedPlanCoverageDetails.append(insurancePlanDetails.getFormattedDetails());
    }
    
    void currentInsuranceFieldsEnableDisable(boolean enable) {
        FieldsDecorator.decorate(txtPatientName, enable);
        FieldsDecorator.decorate(txtInsuranceNumber, enable);
        FieldsDecorator.decorate(txtGroupNumber, enable);
        FieldsDecorator.decorate(txtInsuranceProviderName, enable);
        FieldsDecorator.decorate(txtInsuranceType, enable);
        FieldsDecorator.decorate(txtInsurancePlanExpiryDate, enable);
        FieldsDecorator.decorate(jTextAreaInsuranceDetails, enable);
    }
    
    void insuranceUpdateFieldsEnableDisable(boolean enable) {
        jComboBoxInsuranceEnterprise.setEnabled(enable);
        jComboBoxInsuranceHealthPlan.setEnabled(enable);
        jTextAreaSelectedPlanCoverageDetails.setEnabled(enable);
        jButtonSendInsuranceRequestPlaceHolder.setEnabled(enable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPatientDetails = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        lblWeight1 = new javax.swing.JLabel();
        txtGroupNumber = new javax.swing.JTextField();
        lblWeight2 = new javax.swing.JLabel();
        txtInsuranceProviderName = new javax.swing.JTextField();
        lblWeight3 = new javax.swing.JLabel();
        txtInsurancePlanExpiryDate = new javax.swing.JTextField();
        lblWeight4 = new javax.swing.JLabel();
        lblWeight5 = new javax.swing.JLabel();
        txtInsuranceType = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaInsuranceDetails = new javax.swing.JTextArea();
        lblWeight6 = new javax.swing.JLabel();
        txtInsuranceNumber = new javax.swing.JTextField();
        lblWeight7 = new javax.swing.JLabel();
        jComboBoxInsuranceEnterprise = new javax.swing.JComboBox<>();
        lblWeight8 = new javax.swing.JLabel();
        lblWeight9 = new javax.swing.JLabel();
        jComboBoxInsuranceHealthPlan = new javax.swing.JComboBox<>();
        lblWeight10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaSelectedPlanCoverageDetails = new javax.swing.JTextArea();
        jButtonSendInsuranceRequestPlaceHolder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblPatientDetails1 = new javax.swing.JLabel();
        lblAddNewInsurance = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPatientDetails.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPatientDetails.setText("Medical health Insurance Details");
        jPanel1.add(lblPatientDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 12, 500, 40));

        lblWeight.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight.setText("Insurance Provider");
        jPanel1.add(lblWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 195, -1, -1));

        txtPatientName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPatientName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 104, 244, -1));

        lblWeight1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight1.setText("Group Number");
        jPanel1.add(lblWeight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 157, -1, -1));

        txtGroupNumber.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtGroupNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtGroupNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGroupNumberActionPerformed(evt);
            }
        });
        jPanel1.add(txtGroupNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 157, 244, -1));

        lblWeight2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight2.setText("Insurance Number ");
        jPanel1.add(lblWeight2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 131, -1, -1));

        txtInsuranceProviderName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtInsuranceProviderName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtInsuranceProviderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 195, 244, -1));

        lblWeight3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight3.setText("Insurance plan expiry date");
        jPanel1.add(lblWeight3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 221, -1, -1));

        txtInsurancePlanExpiryDate.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtInsurancePlanExpiryDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtInsurancePlanExpiryDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 221, 244, -1));

        lblWeight4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight4.setText("Insurance  Type");
        jPanel1.add(lblWeight4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 253, -1, -1));

        lblWeight5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight5.setText("Insurance Coverage Details");
        jPanel1.add(lblWeight5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 285, -1, -1));

        txtInsuranceType.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtInsuranceType.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtInsuranceType, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 253, 244, -1));

        jTextAreaInsuranceDetails.setColumns(20);
        jTextAreaInsuranceDetails.setRows(5);
        jScrollPane1.setViewportView(jTextAreaInsuranceDetails);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 285, 244, 105));

        lblWeight6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight6.setText("Patient Name");
        jPanel1.add(lblWeight6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 104, -1, -1));

        txtInsuranceNumber.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtInsuranceNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txtInsuranceNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 131, 244, -1));
        jPanel1.add(lblWeight7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 438, -1, -1));

        jComboBoxInsuranceEnterprise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jPanel1.add(jComboBoxInsuranceEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 484, 244, -1));

        lblWeight8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight8.setText("Insurance Provider");
        jPanel1.add(lblWeight8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 487, -1, -1));

        lblWeight9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight9.setText("Health Insurance Plan");
        jPanel1.add(lblWeight9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 519, -1, -1));

        jComboBoxInsuranceHealthPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jPanel1.add(jComboBoxInsuranceHealthPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 516, 244, -1));

        lblWeight10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeight10.setText("Plan Coverage");
        jPanel1.add(lblWeight10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 554, -1, -1));

        jTextAreaSelectedPlanCoverageDetails.setColumns(20);
        jTextAreaSelectedPlanCoverageDetails.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSelectedPlanCoverageDetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 554, 244, 96));

        jButtonSendInsuranceRequestPlaceHolder.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSendInsuranceRequestPlaceHolder.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonSendInsuranceRequestPlaceHolder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/send_mail.png"))); // NOI18N
        jButtonSendInsuranceRequestPlaceHolder.setText("Send Request");
        jButtonSendInsuranceRequestPlaceHolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendInsuranceRequestPlaceHolderActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSendInsuranceRequestPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 670, 310, 40));

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 408, 1096, 24));

        lblPatientDetails1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblPatientDetails1.setForeground(new java.awt.Color(51, 153, 255));
        lblPatientDetails1.setText("Current Insurance Details");
        jPanel1.add(lblPatientDetails1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 58, 319, 40));

        lblAddNewInsurance.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblAddNewInsurance.setForeground(new java.awt.Color(51, 153, 255));
        lblAddNewInsurance.setText("Request Insurance Update?");
        jPanel1.add(lblAddNewInsurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 444, 319, 28));

        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        jButtonBack.setContentAreaFilled(false);
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, -4, 1100, 850));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSendInsuranceRequestPlaceHolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendInsuranceRequestPlaceHolderActionPerformed
        // TODO add your handling code here:
        
        String selectedEnterprise = (String) jComboBoxInsuranceEnterprise.getSelectedItem();
        if (selectedEnterprise.equals("Select")) {
            JOptionPane.showMessageDialog(jPanel1, "Select an insurance provider");
            return; 
        }
        
        Enterprise insuranceCompany = ecoSystem.enterpriseDirectory.getEnterprise(Long.parseLong(selectedEnterprise.split(":")[1]));
        if (insuranceCompany == null) {
            JOptionPane.showMessageDialog(jPanel1, "No insurance provider found for selected item: " + selectedEnterprise);
            return; 
        }
        
        String selectedPlan = (String) jComboBoxInsuranceHealthPlan.getSelectedItem();     
        if ("Select".equals(selectedPlan)) {
            JOptionPane.showMessageDialog(jPanel1, "Select an insurance plan");
            return; 
        }
        
        InsurancePlanDetails planDetails = new HealthInsurancePlans().getPlanDetails(selectedPlan);
        if (planDetails == null) {
            JOptionPane.showMessageDialog(jPanel1, "No insurance plan found for selected plan: " + selectedPlan);
            return; 
        }
        
        InsuranceDetails insuranceDetails = new InsuranceDetails(insuranceCompany, 
                planDetails, patient, InsuranceRequestApprovalStatus.PENDING, LocalDate.now());

        Organization healthInsuranceOrg = null;  
        for (Organization organization : insuranceCompany.getOrganizations()) {
            if (organization.getOrganizationType().equals(HEALTH_INSURANCE_DEPARTMENT)) {
                healthInsuranceOrg = organization;
            }
        }
        
        ((HealthInsuranceDepartmentOrganization)healthInsuranceOrg).addInsuranceRequest(insuranceDetails);
        jButtonSendInsuranceRequestPlaceHolder.setEnabled(false);
    }//GEN-LAST:event_jButtonSendInsuranceRequestPlaceHolderActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        
        nextScreen(WorkAreaPanel, backPage, "Patient home page");
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void txtGroupNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGroupNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGroupNumberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSendInsuranceRequestPlaceHolder;
    private javax.swing.JComboBox<String> jComboBoxInsuranceEnterprise;
    private javax.swing.JComboBox<String> jComboBoxInsuranceHealthPlan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaInsuranceDetails;
    private javax.swing.JTextArea jTextAreaSelectedPlanCoverageDetails;
    private javax.swing.JLabel lblAddNewInsurance;
    private javax.swing.JLabel lblPatientDetails;
    private javax.swing.JLabel lblPatientDetails1;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel lblWeight1;
    private javax.swing.JLabel lblWeight10;
    private javax.swing.JLabel lblWeight2;
    private javax.swing.JLabel lblWeight3;
    private javax.swing.JLabel lblWeight4;
    private javax.swing.JLabel lblWeight5;
    private javax.swing.JLabel lblWeight6;
    private javax.swing.JLabel lblWeight7;
    private javax.swing.JLabel lblWeight8;
    private javax.swing.JLabel lblWeight9;
    private javax.swing.JTextField txtGroupNumber;
    private javax.swing.JTextField txtInsuranceNumber;
    private javax.swing.JTextField txtInsurancePlanExpiryDate;
    private javax.swing.JTextField txtInsuranceProviderName;
    private javax.swing.JTextField txtInsuranceType;
    private javax.swing.JTextField txtPatientName;
    // End of variables declaration//GEN-END:variables
}
