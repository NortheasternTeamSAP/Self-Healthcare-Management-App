/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientCoreWorkFlowUI;

import DataStore.Appointment;
import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Patient.Patient;
import Utils.NextScreen;
import java.awt.Color;
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
    boolean billSentToInsuranceProvider;
    
    double totalAppointmentCharges = 0.0;

    public GeneratePatientBillJPanel(JPanel workAreaPanel, EcoSystem ecosystem, Appointment appointment, JPanel backPage) {
        initComponents();
        this.workAreaPanel= workAreaPanel;
        this.ecosystem = ecosystem;
        this.appointment = appointment;
        this.backPage = backPage;
        
        populateAppointmentDetailsPlaceHolder();
        populateBillingCharges();
        
        if (appointment.getTotalAppointmentCharges() != 0.0) {
            jLabelClaimAlreadySubmittedMessage.setText("Claim of " + appointment.getTotalAppointmentCharges() + 
                    " USD has been submitted to the insurance provider. Cannot be changed now.");
            jLabelClaimAlreadySubmittedMessage.setBackground(Color.red);
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
                "Patient Name: " + appointment.getPatient().getPersonDetails().getFullName() + "</br>" +
                "Health Care Provider Name: " + appointment.getDoctor().getPersonDetails().getFullName() + "</br>" +
                "Appointment Date: " + appointment.getDate() + " " + appointment.getAppointmentTimeHours() + ":00 hrs" + "</br>" +
                "</html>";
        jLabelAppointmentDetailsPlaceHolder.setText(placeHolderValue);
    }
    
    void populateBillingCharges() {
        String labTestCostValue = 
                "<html>" +
                appointment.getLabTestReport().getLab().getName() + " test charges: " + appointment.getLabTestReport().getLabTestCost() +
                "</html>";
                
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
        jLabel2 = new javax.swing.JLabel();
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
        jLabelLabAssistantPlaceHolder8 = new javax.swing.JLabel();
        jLabelClaimAlreadySubmittedMessage = new javax.swing.JLabel();

        jLabel1.setText(" Patient Billing Dashboard");

        jLabel2.setText("Appointment Details");

        jLabelLabTestCostPlaceHolder.setText("Lab Test Cost PH");

        jLabelLabAssistantPlaceHolder3.setText("USD");

        jLabelLabAssistantPlaceHolder4.setText("Other Primary Care Provider Charges (tax etc.)");

        jButtonSubmitInsuranceClaim.setText("Submit Claim to Insurance Provider");
        jButtonSubmitInsuranceClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitInsuranceClaimActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabelAppointmentDetailsPlaceHolder.setText("Appointment Details Place Holder");

        jLabelLabAssistantPlaceHolder6.setText("Billing Details");

        jTextFieldInsuranceCompanyCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInsuranceCompanyCodeActionPerformed(evt);
            }
        });

        jLabel3.setText("Insurance Company Code");

        jTextFieldPrimaryCareCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrimaryCareCostActionPerformed(evt);
            }
        });

        jTextFieldPrimaryCareOtherCharges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrimaryCareOtherChargesActionPerformed(evt);
            }
        });

        jButtonCalculateTotalCost.setText("Calculate total Cost");
        jButtonCalculateTotalCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateTotalCostActionPerformed(evt);
            }
        });

        jLabelLabAssistantPlaceHolder5.setText("Primary Care Charges");

        jLabelLabAssistantPlaceHolder7.setText("USD");

        jLabelLabAssistantPlaceHolder8.setText("USD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabelAppointmentDetailsPlaceHolder)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldPrimaryCareCost, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelLabAssistantPlaceHolder4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldPrimaryCareOtherCharges, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLabAssistantPlaceHolder3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLabAssistantPlaceHolder7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabelTotalAppointmentCostPlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldInsuranceCompanyCode, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelLabAssistantPlaceHolder8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButtonCalculateTotalCost))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelLabAssistantPlaceHolder6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLabTestCostPlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jButtonSubmitInsuranceClaim))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabelClaimAlreadySubmittedMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(165, 165, 165)
                    .addComponent(jLabelLabAssistantPlaceHolder5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(417, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnBack)))
                .addGap(60, 60, 60)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabelAppointmentDetailsPlaceHolder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(jLabelLabAssistantPlaceHolder6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabelLabTestCostPlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLabAssistantPlaceHolder4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPrimaryCareOtherCharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLabAssistantPlaceHolder3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPrimaryCareCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelLabAssistantPlaceHolder7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButtonCalculateTotalCost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTotalAppointmentCostPlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldInsuranceCompanyCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLabAssistantPlaceHolder8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jButtonSubmitInsuranceClaim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelClaimAlreadySubmittedMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(456, Short.MAX_VALUE)
                    .addComponent(jLabelLabAssistantPlaceHolder5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(389, 389, 389)))
        );

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
            jLabelClaimAlreadySubmittedMessage.setBackground(Color.red);
        } else {
            
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
        double primaryCareOtherCharges = Double.parseDouble(jTextFieldPrimaryCareOtherCharges.getText()); 
        
        totalAppointmentCharges = primaryCareCost + primaryCareOtherCharges + appointment.getLabTestReport().getLabTestCost();
        jLabelTotalAppointmentCostPlaceHolder.setText("Total Appointment Cost = " + totalAppointmentCharges + " USD");  
    }//GEN-LAST:event_jButtonCalculateTotalCostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButtonCalculateTotalCost;
    private javax.swing.JButton jButtonSubmitInsuranceClaim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAppointmentDetailsPlaceHolder;
    private javax.swing.JLabel jLabelClaimAlreadySubmittedMessage;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder3;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder4;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder5;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder6;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder7;
    private javax.swing.JLabel jLabelLabAssistantPlaceHolder8;
    private javax.swing.JLabel jLabelLabTestCostPlaceHolder;
    private javax.swing.JLabel jLabelTotalAppointmentCostPlaceHolder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldInsuranceCompanyCode;
    private javax.swing.JTextField jTextFieldPrimaryCareCost;
    private javax.swing.JTextField jTextFieldPrimaryCareOtherCharges;
    // End of variables declaration//GEN-END:variables
}
