/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import DataStore.Appointment;
import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import Insurance.PrimaryCareInsuranceClaim;
import Organization.HealthInsuranceDepartmentOrganization;
import Organization.Organization;
import Organization.OrganizationType;
import Patient.Patient;
import Utils.NextScreen;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ankur Bywar
 */
public class GeneratePatientBillJPanel extends javax.swing.JPanel implements NextScreen {

    JPanel workAreaPanel;
    EcoSystem ecosystem;
    Appointment appointment;
    JPanel backPage;
    
    double totalAppointmentCharges = 0.0;

    public GeneratePatientBillJPanel(JPanel workAreaPanel, EcoSystem ecosystem, Appointment appointment, JPanel backPage) {
        initComponents();
        this.setSize(1100,850);
        this.workAreaPanel= workAreaPanel;
        this.ecosystem = ecosystem;
        this.appointment = appointment;
        this.backPage = backPage;
        
        populateAppointmentDetailsPlaceHolder();
        populateBillingCharges();
        
        if (appointment.getTotalAppointmentCharges() != 0.0) {
            jLabelClaimAlreadySubmittedMessage.setText("Claim of " + appointment.getTotalAppointmentCharges() + 
                    " USD has been submitted to the insurance provider. Cannot be changed now.");
            jButtonSubmitInsuranceClaim.setEnabled(false);
            jTextFieldInsuranceCompanyCode.setEnabled(false);
            jTextFieldPrimaryCareCost.setEnabled(false);
            jTextFieldPrimaryCareOtherCharges.setEnabled(false);
            jButtonCalculateTotalCost.setEnabled(false);
        }
        
    }
    
    void populateAppointmentDetailsPlaceHolder() {
        String placeHolderValue = 
                "<html>" +
                "Patient Name: " + appointment.getPatient().getPersonDetails().getFullName() + ", </br>" +
                "Health Care Provider Name: " + appointment.getDoctor().getPersonDetails().getFullName() + ", </br>" +
                "Appointment Date: " + appointment.getDate() + " " + appointment.getAppointmentTimeHours() + ":00 hrs" + "</br>" +
                "</html>";
        jLabelAppointmentDetailsPlaceHolder.setText(placeHolderValue);
    }
    
    void populateBillingCharges() {
        String labTestCostValue = null;
        if (appointment.getLabTestReport() == null) {
            labTestCostValue = 
                    "<html>" +
                    "No lab tests performed. Lab Charges: 0.00 USD" +
                    "</html>";
                jLabelLabTestCostPlaceHolder.setText("0.00 USD");
                return;
        } else {
            labTestCostValue = 
                "<html>" +
                appointment.getLabTestReport().getLab().getName() + " test charges: " + appointment.getLabTestReport().getLabTestCost() + " USD" +
                "</html>";
        }
        jLabelLabTestCostPlaceHolder.setText(labTestCostValue);
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
        jLabel1 = new javax.swing.JLabel();
        jLabelLabTestCostPlaceHolder = new javax.swing.JLabel();
        jLabelLabAssistantPlaceHolder3 = new javax.swing.JLabel();
        jLabelLabAssistantPlaceHolder4 = new javax.swing.JLabel();
        jLabelTotalAppointmentCostPlaceHolder = new javax.swing.JLabel();
        jButtonSubmitInsuranceClaim = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabelAppointmentDetailsPlaceHolder = new javax.swing.JLabel();
        jLabelLabAssistantPlaceHolder6 = new javax.swing.JLabel();
        jTextFieldInsuranceCompanyCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPrimaryCareCost = new javax.swing.JTextField();
        jTextFieldPrimaryCareOtherCharges = new javax.swing.JTextField();
        jButtonCalculateTotalCost = new javax.swing.JButton();
        jLabelLabAssistantPlaceHolder5 = new javax.swing.JLabel();
        jLabelLabAssistantPlaceHolder7 = new javax.swing.JLabel();
        jLabelClaimAlreadySubmittedMessage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText(" Patient Billing Dashboard");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 33, -1, -1));

        jLabelLabTestCostPlaceHolder.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelLabTestCostPlaceHolder.setForeground(new java.awt.Color(51, 153, 255));
        jLabelLabTestCostPlaceHolder.setText("Lab Test Cost PH");
        jPanel1.add(jLabelLabTestCostPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 182, 620, 25));

        jLabelLabAssistantPlaceHolder3.setText("USD");
        jPanel1.add(jLabelLabAssistantPlaceHolder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 38, 25));

        jLabelLabAssistantPlaceHolder4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelLabAssistantPlaceHolder4.setForeground(new java.awt.Color(51, 153, 255));
        jLabelLabAssistantPlaceHolder4.setText("Other Primary Care Provider Charges(tax etc.)");
        jPanel1.add(jLabelLabAssistantPlaceHolder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 250, -1, 25));

        jLabelTotalAppointmentCostPlaceHolder.setForeground(new java.awt.Color(153, 0, 153));
        jPanel1.add(jLabelTotalAppointmentCostPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 320, 25));

        jButtonSubmitInsuranceClaim.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSubmitInsuranceClaim.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonSubmitInsuranceClaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-submit-resume-30.png"))); // NOI18N
        jButtonSubmitInsuranceClaim.setText("Submit Claim to Insurance Provider");
        jButtonSubmitInsuranceClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitInsuranceClaimActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSubmitInsuranceClaim, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, -1, -1));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 23, 94, -1));

        jLabelAppointmentDetailsPlaceHolder.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelAppointmentDetailsPlaceHolder.setForeground(new java.awt.Color(153, 0, 153));
        jLabelAppointmentDetailsPlaceHolder.setText("Appointment Details Place Holder");
        jPanel1.add(jLabelAppointmentDetailsPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 114, 900, -1));

        jLabelLabAssistantPlaceHolder6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelLabAssistantPlaceHolder6.setText("Billing Details");
        jPanel1.add(jLabelLabAssistantPlaceHolder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 151, 228, 25));

        jTextFieldInsuranceCompanyCode.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldInsuranceCompanyCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldInsuranceCompanyCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInsuranceCompanyCodeActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldInsuranceCompanyCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 398, 153, 30));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 255));
        jLabel3.setText("Insurance Group number");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 200, 28));

        jTextFieldPrimaryCareCost.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldPrimaryCareCost.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldPrimaryCareCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrimaryCareCostActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPrimaryCareCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 153, 20));

        jTextFieldPrimaryCareOtherCharges.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldPrimaryCareOtherCharges.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldPrimaryCareOtherCharges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrimaryCareOtherChargesActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPrimaryCareOtherCharges, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 153, 20));

        jButtonCalculateTotalCost.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCalculateTotalCost.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonCalculateTotalCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-calculator-30.png"))); // NOI18N
        jButtonCalculateTotalCost.setText("Calculate total Cost");
        jButtonCalculateTotalCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateTotalCostActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCalculateTotalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 288, -1, -1));

        jLabelLabAssistantPlaceHolder5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelLabAssistantPlaceHolder5.setForeground(new java.awt.Color(51, 153, 255));
        jLabelLabAssistantPlaceHolder5.setText("Primary Care Charges");
        jPanel1.add(jLabelLabAssistantPlaceHolder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 219, 172, 25));

        jLabelLabAssistantPlaceHolder7.setText("USD");
        jPanel1.add(jLabelLabAssistantPlaceHolder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 38, 25));

        jLabelClaimAlreadySubmittedMessage.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelClaimAlreadySubmittedMessage.setForeground(new java.awt.Color(204, 0, 102));
        jPanel1.add(jLabelClaimAlreadySubmittedMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 640, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 4, 1090, 840));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        nextScreen(workAreaPanel, backPage, "Patient appointment details page");
    }//GEN-LAST:event_btnBackActionPerformed

    private void jTextFieldInsuranceCompanyCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInsuranceCompanyCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldInsuranceCompanyCodeActionPerformed

    private void jButtonSubmitInsuranceClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitInsuranceClaimActionPerformed
        // TODO add your handling code here:
        
        String id = jTextFieldInsuranceCompanyCode.getText();
        if (id == null || id.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Please enter a valid insurance provider ID", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        long insuranceCompanyId = Long.parseLong(id);
        // Get Insurance Company from ID
        Enterprise insuranceCompany = ecosystem.enterpriseDirectory.getEnterprise(insuranceCompanyId);
        if (insuranceCompany == null) {
            JOptionPane.showMessageDialog(null,"No insurance company found for id " + insuranceCompanyId, "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Organization healthInsuranceDepartment = null;
        for (Organization organization : insuranceCompany.getOrganizations()) {
            if (organization.getOrganizationType().equals(OrganizationType.HEALTH_INSURANCE_DEPARTMENT)) {
                healthInsuranceDepartment = organization;
                break;
            }
        }
        
        if (healthInsuranceDepartment == null) {
            JOptionPane.showMessageDialog(null,"No health insurance department found for company with id " + insuranceCompanyId, "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String placeHolderValue = 
                "<html>" +
                "Patient Name: " + appointment.getPatient().getPersonDetails().getFullName() + "</br>" +
                "Health Care Provider Name: " + appointment.getDoctor().getPersonDetails().getFullName() + "</br>" +
                "Appointment Date: " + appointment.getDate() + " " + appointment.getAppointmentTimeHours() + ":00 hrs" + "</br>" +
                "</html>";

        int dialogResult = JOptionPane.showConfirmDialog (this, placeHolderValue, "Warning", 1);
        if(dialogResult == JOptionPane.YES_OPTION){
          jButtonSubmitInsuranceClaim.setEnabled(false);
          jTextFieldInsuranceCompanyCode.setEnabled(false);
          jTextFieldPrimaryCareCost.setEnabled(false);
          jTextFieldPrimaryCareOtherCharges.setEnabled(false);
          appointment.setTotalAppointmentCharges(totalAppointmentCharges);
          jLabelTotalAppointmentCostPlaceHolder.setText("Total Appointment Cost = " + appointment.getTotalAppointmentCharges() + " USD");
            jLabelClaimAlreadySubmittedMessage.setText("Claim of " + appointment.getTotalAppointmentCharges() + 
                    " USD has been submitted to the insurance provider. Cannot be changed now.");
            
            boolean noLabReport = appointment.getLabTestReport() == null;
            PrimaryCareInsuranceClaim primaryCareInsuranceClaim = new PrimaryCareInsuranceClaim(
                    appointment.getPrimaryCareProviderCost(), 
                    noLabReport ? 0.0 : appointment.getLabTestReport().getLabTestCost(),
                    noLabReport ? null : appointment.getLabTestReport().getLaboratoryTestResult().getTestNames(),
                    noLabReport ? "Not Available" : appointment.getLabTestReport().getLab().getName(),
                    appointment.getDoctor(),
                    appointment.getPatient(),
                    LocalDate.now(),
                    healthInsuranceDepartment);
            
            
            HealthInsuranceDepartmentOrganization healthInsuranceDepartmentOrganization = (HealthInsuranceDepartmentOrganization)healthInsuranceDepartment;
            healthInsuranceDepartmentOrganization.addMedicalInsuranceClaim(primaryCareInsuranceClaim);
        }
        
    }//GEN-LAST:event_jButtonSubmitInsuranceClaimActionPerformed

    private void jTextFieldPrimaryCareCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrimaryCareCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrimaryCareCostActionPerformed

    private void jTextFieldPrimaryCareOtherChargesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrimaryCareOtherChargesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrimaryCareOtherChargesActionPerformed

    private void jButtonCalculateTotalCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateTotalCostActionPerformed
        // TODO add your handling code here:
        double primaryCareCost = Double.parseDouble(jTextFieldPrimaryCareCost.getText());
        primaryCareCost += Double.parseDouble(jTextFieldPrimaryCareOtherCharges.getText()); 
        
        double labTestCost = appointment.getLabTestReport() == null ? 0.0 : appointment.getLabTestReport().getLabTestCost();
        appointment.setPrimaryCareProviderCost(primaryCareCost);
        totalAppointmentCharges = primaryCareCost + labTestCost;
        jLabelTotalAppointmentCostPlaceHolder.setText("Total Appointment Cost = " + totalAppointmentCharges + " USD");  
    }//GEN-LAST:event_jButtonCalculateTotalCostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButtonCalculateTotalCost;
    private javax.swing.JButton jButtonSubmitInsuranceClaim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAppointmentDetailsPlaceHolder;
    private javax.swing.JLabel jLabelClaimAlreadySubmittedMessage;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder3;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder4;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder5;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder6;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder7;
    private javax.swing.JLabel jLabelLabTestCostPlaceHolder;
    private javax.swing.JLabel jLabelTotalAppointmentCostPlaceHolder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldInsuranceCompanyCode;
    private javax.swing.JTextField jTextFieldPrimaryCareCost;
    private javax.swing.JTextField jTextFieldPrimaryCareOtherCharges;
    // End of variables declaration//GEN-END:variables
}
