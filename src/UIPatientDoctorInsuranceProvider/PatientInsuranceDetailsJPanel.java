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
import Utils.NextScreen;
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
        jComboBoxInsuranceEnterprise.addItem("Select Insurance Provider");
        for (Enterprise enterprise : insuranceEnterprises) {
            jComboBoxInsuranceEnterprise.addItem(enterprise.getEnterpriseName() + ":" + enterprise.getEnterpriseId());
        }
        
        Set<String> planNames = new HealthInsurancePlans().getALLPlanNames();
        jComboBoxInsuranceHealthPlan.addItem("Select Health Insurance Plan");
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
        
        if ("Select Health Insurance Plan".equals(selectedPlan)) {
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
        txtPatientName.setEditable(enable);
        txtPatientName.setEnabled(enable);
    
        txtInsuranceNumber.setEditable(enable);
        txtInsuranceNumber.setEnabled(enable);
        
        txtGroupNumber.setEditable(enable);
        txtGroupNumber.setEnabled(enable);

        txtInsuranceProviderName.setEditable(enable);
        txtInsuranceProviderName.setEnabled(enable);
        
        txtInsuranceType.setEditable(enable);
        txtInsuranceType.setEnabled(enable);
        
        txtInsurancePlanExpiryDate.setEditable(enable);
        txtInsurancePlanExpiryDate.setEnabled(enable);
        
        jTextAreaInsuranceDetails.setEditable(enable);
        jTextAreaInsuranceDetails.setEnabled(enable);
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

        lblPatientDetails.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblPatientDetails.setText("Medical health Insurance Details");

        lblWeight.setText("Insurance Provider");

        txtPatientName.setBackground(new java.awt.Color(0, 204, 204));
        txtPatientName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        txtPatientName.setForeground(new java.awt.Color(255, 255, 255));

        lblWeight1.setText("Group Number");

        lblWeight2.setText("Insurance Number ");

        lblWeight3.setText("Insurance plan expiry date");

        lblWeight4.setText("Insurance  Type");

        lblWeight5.setText("Insurance Coverage Details");

        jTextAreaInsuranceDetails.setColumns(20);
        jTextAreaInsuranceDetails.setRows(5);
        jScrollPane1.setViewportView(jTextAreaInsuranceDetails);

        lblWeight6.setText("Patient Name");

        jComboBoxInsuranceEnterprise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Insurance Provider" }));

        lblWeight8.setText("Select Insurance Provider");

        lblWeight9.setText("Select Health Insurance Plan");

        jComboBoxInsuranceHealthPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Health Insurance Plan" }));

        lblWeight10.setText("Selected Plan Coverage");

        jTextAreaSelectedPlanCoverageDetails.setColumns(20);
        jTextAreaSelectedPlanCoverageDetails.setRows(5);
        jScrollPane2.setViewportView(jTextAreaSelectedPlanCoverageDetails);

        jButtonSendInsuranceRequestPlaceHolder.setText("Send Request");
        jButtonSendInsuranceRequestPlaceHolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendInsuranceRequestPlaceHolderActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));

        lblPatientDetails1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblPatientDetails1.setText("Current Insurance Details");

        lblAddNewInsurance.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblAddNewInsurance.setText("Request Insurance Update?");

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonBack)
                .addGap(232, 232, 232)
                .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jButtonSendInsuranceRequestPlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblWeight7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAddNewInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPatientDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblWeight2)
                                    .addComponent(lblWeight)
                                    .addComponent(lblWeight1)
                                    .addComponent(lblWeight3)
                                    .addComponent(lblWeight4)
                                    .addComponent(lblWeight5)
                                    .addComponent(lblWeight6)
                                    .addComponent(lblWeight8)
                                    .addComponent(lblWeight9)
                                    .addComponent(lblWeight10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBoxInsuranceHealthPlan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxInsuranceEnterprise, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPatientName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGroupNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInsuranceProviderName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInsurancePlanExpiryDate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInsuranceType)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtInsuranceNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPatientDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight6)
                    .addComponent(txtPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight2)
                    .addComponent(txtInsuranceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight1)
                    .addComponent(txtGroupNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight)
                    .addComponent(txtInsuranceProviderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWeight3)
                    .addComponent(txtInsurancePlanExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight4)
                    .addComponent(txtInsuranceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWeight5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddNewInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeight7))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxInsuranceEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeight8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight9)
                    .addComponent(jComboBoxInsuranceHealthPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWeight10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSendInsuranceRequestPlaceHolder, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSendInsuranceRequestPlaceHolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendInsuranceRequestPlaceHolderActionPerformed
        // TODO add your handling code here:
        
        String selectedEnterprise = (String) jComboBoxInsuranceEnterprise.getSelectedItem();
        if (selectedEnterprise.equals("Select Insurance Provider")) {
            JOptionPane.showMessageDialog(jPanel1, "Select an insurance provider");
            return; 
        }
        
        Enterprise insuranceCompany = ecoSystem.enterpriseDirectory.getEnterprise(Integer.parseInt(selectedEnterprise.split(":")[1]));
        if (insuranceCompany == null) {
            JOptionPane.showMessageDialog(jPanel1, "No insurance provider found for selected item: " + selectedEnterprise);
            return; 
        }
        
        String selectedPlan = (String) jComboBoxInsuranceHealthPlan.getSelectedItem();     
        if ("Select Health Insurance Plan".equals(selectedPlan)) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonSendInsuranceRequestPlaceHolder;
    private javax.swing.JComboBox<String> jComboBoxInsuranceEnterprise;
    private javax.swing.JComboBox<String> jComboBoxInsuranceHealthPlan;
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
