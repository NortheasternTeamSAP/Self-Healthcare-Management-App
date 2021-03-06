/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Insurance.PrimaryCareInsuranceClaim;
import Laboratory.LaboratoryAssistant;
import Laboratory.LaboratoryTest;
import Laboratory.LaboratoryTest.TestType;
import Laboratory.LaboratoryTestReport;
import Organization.HealthInsuranceDepartmentOrganization;
import Patient.Patient;
import Personnel.Person;
import Utils.ConsoleLogger;
import Utils.EmailClient;
import Utils.NextScreen;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Ankur Bywar
 */
public class PatientClaimDetailsJPanel extends javax.swing.JPanel implements NextScreen {
    JPanel workAreaPanel;
    PrimaryCareInsuranceClaim claim;
    InsuranceProviderRepresentativeHomePageJPanel backPage;
    EcoSystem ecosystem;
    String insuranceCompany;
    
    ConsoleLogger log = ConsoleLogger.getLogger();
    
    /**
     * Creates new form ViewMedicalLabTestResultJPanel
     */
    public PatientClaimDetailsJPanel(JPanel workAreaPanel, EcoSystem ecosystem, PrimaryCareInsuranceClaim claim, String insuranceCompany, JPanel backPage) {
        initComponents();
        this.setSize(1100,850);
        this.workAreaPanel = workAreaPanel;
        this.claim = claim;
        this.ecosystem = ecosystem;
        this.insuranceCompany = insuranceCompany;
        this.backPage = (InsuranceProviderRepresentativeHomePageJPanel)backPage;
        
        populatePlaceHolders();
        
        if (!claim.getClaimSatus().equals(PrimaryCareInsuranceClaim.ClaimStatus.PENDING)) {
            setClaimProcessingMessage();
            disableClaimFields();
            return;
        }
        
        Patient patient = (Patient) claim.getPatient();
        int coverage = patient.getInsuranceDetails() == null ? 0 : patient.getInsuranceDetails().getCoverageDetails().getDeductible();
        jTextFieldInsuranceCompanyDeductable.setText(coverage + "");
    }
    
    void disableClaimFields() {
        jTextFieldInsuranceCompanyDeductable.setEnabled(false);
        btnApproveClaim.setEnabled(false);
        btnDeclineClaim.setEnabled(false);
        jCheckBoxSendClaimEmailToPatient.setEnabled(false);
    }
    
    void populatePlaceHolders() {
        Person doctor = claim.getDoctor();
        Person patient = claim.getPatient();
        jLabelPatientPlaceHolder.setText("Beneficiary Name: " + patient.getPersonDetails().getFullName() + ", Claim submitted by: " + doctor.getPersonDetails().getFullName());
        jLabelTotalClaimAmountPlaceHolder.setText(claim.getTotalClaimAmount() + "");
        if (claim.getClaimSatus().equals(PrimaryCareInsuranceClaim.ClaimStatus.PENDING)) {
            if (claim.getInsuranceDeductable() >= claim.getTotalClaimAmount()) {
                jLabelPatientsResponsibilityPlaceHolder.setText("0.00 USD");
            } else {
                jLabelPatientsResponsibilityPlaceHolder.setText((claim.getTotalClaimAmount() - claim.getInsuranceDeductable()) + " USD");
            }
            jTextFieldInsuranceCompanyDeductable.setText(claim.getInsuranceDeductable() + "");
        } else {
            jTextFieldInsuranceCompanyDeductable.setEnabled(false);
            jLabelClaimProcessingMessagePlaceHolder.setText("Claim has already been processed.");
        }
    }
    
    void setClaimProcessingMessage() {
        String status = claim.getClaimSatus().toString();
        String message = "Claim has been processed (" + status + ") and the patient has been notified about it.";
        jLabelClaimProcessingMessagePlaceHolder.setText(message);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldInsuranceCompanyDeductable = new javax.swing.JTextField();
        btnApproveClaim = new javax.swing.JButton();
        jLabelPatientPlaceHolder = new javax.swing.JLabel();
        btnDeclineClaim = new javax.swing.JButton();
        jLabelTotalClaimAmountPlaceHolder = new javax.swing.JLabel();
        jCheckBoxSendClaimEmailToPatient = new javax.swing.JCheckBox();
        jLabelPatientsResponsibilityPlaceHolder = new javax.swing.JLabel();
        jLabelClaimProcessingMessagePlaceHolder = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("Patient Claims Detail page");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 410, 31));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Total Amount Claimed: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("*Insurance Deductable:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, 25));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("Patient Responsibility:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, 25));

        jTextFieldInsuranceCompanyDeductable.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldInsuranceCompanyDeductable.setText("-");
        jTextFieldInsuranceCompanyDeductable.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldInsuranceCompanyDeductable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldInsuranceCompanyDeductableActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldInsuranceCompanyDeductable, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 200, 20));

        btnApproveClaim.setBackground(new java.awt.Color(255, 255, 255));
        btnApproveClaim.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnApproveClaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/accept.png"))); // NOI18N
        btnApproveClaim.setText("Approve Claim");
        btnApproveClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveClaimActionPerformed(evt);
            }
        });
        jPanel1.add(btnApproveClaim, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 170, 40));

        jLabelPatientPlaceHolder.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelPatientPlaceHolder.setForeground(new java.awt.Color(153, 0, 153));
        jLabelPatientPlaceHolder.setText("Add Patient, doctor and other claim details here");
        jPanel1.add(jLabelPatientPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 830, -1));

        btnDeclineClaim.setBackground(new java.awt.Color(255, 255, 255));
        btnDeclineClaim.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnDeclineClaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/disagree.png"))); // NOI18N
        btnDeclineClaim.setText("Decline Claim");
        btnDeclineClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineClaimActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeclineClaim, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 160, 40));

        jLabelTotalClaimAmountPlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabelTotalClaimAmountPlaceHolder.setText("-");
        jPanel1.add(jLabelTotalClaimAmountPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 280, -1));

        jCheckBoxSendClaimEmailToPatient.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jCheckBoxSendClaimEmailToPatient.setSelected(true);
        jCheckBoxSendClaimEmailToPatient.setText("Send claim email details to Patient");
        jCheckBoxSendClaimEmailToPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSendClaimEmailToPatientActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxSendClaimEmailToPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, -1, -1));

        jLabelPatientsResponsibilityPlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabelPatientsResponsibilityPlaceHolder.setText("-");
        jPanel1.add(jLabelPatientsResponsibilityPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 220, 20));

        jLabelClaimProcessingMessagePlaceHolder.setForeground(new java.awt.Color(153, 0, 153));
        jPanel1.add(jLabelClaimProcessingMessagePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 460, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1100, 850));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        backPage.reload();
        nextScreen(workAreaPanel, backPage, "InsuranceProviderRepresentativeHomePageJPanel");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnApproveClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveClaimActionPerformed
        // TODO add your handling code here:
        
        String value = jLabelPatientsResponsibilityPlaceHolder.getText();
        if (value == null || "-".equals(value)) {
            JOptionPane.showMessageDialog(null,"Cannot process claim. Enter the required fields", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        double patientResponsibility = Double.parseDouble(value);
        claim.setClaimSatus(PrimaryCareInsuranceClaim.ClaimStatus.PROCESSED);
        log.debug("Claim Approved. Patients responsibility = " + patientResponsibility);
        setClaimProcessingMessage();
        disableClaimFields();
        HealthInsuranceDepartmentOrganization org = (HealthInsuranceDepartmentOrganization) claim.getInsuranceCompanyOrganization();
        org.processMedicalInsuranceClaim(claim);
        
        String message = "Hi " + claim.getPatient().getPersonDetails().getFullName() + "!\n" +
                "Your insurance claim of " + claim.getTotalClaimAmount() + " USD has been processed by " + insuranceCompany + ".\n" +
                "Your responsibility is " + patientResponsibility + " USD.\n" +
                "To pay your bill, visit " + insuranceCompany + " company website.\n" +
                "\n\n\n" +
                "Cheers -\n" +
                "Health Springs App Team";
        sendEmail(message, claim.getPatient());        
    }//GEN-LAST:event_btnApproveClaimActionPerformed

    void sendEmail(String message, Person patient) {
        boolean success = new EmailClient().sendEmail(
               patient.getPersonDetails().getEmailId(), 
               ecosystem.getSysAdminEmail(), 
               ecosystem.getSysAdmingEmailPassword(), 
               "Insurance claim update for you recent appointment with primary care provider", 
               message);
    }
    
    private void btnDeclineClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineClaimActionPerformed
        // TODO add your handling code here:
        jLabelTotalClaimAmountPlaceHolder.setText(claim.getTotalClaimAmount() + "");
        jLabelPatientsResponsibilityPlaceHolder.setText(claim.getTotalClaimAmount() + "");
        claim.setClaimSatus(PrimaryCareInsuranceClaim.ClaimStatus.DECLINED);
        log.debug("Claim Declined. Patients responsibility = ");
        disableClaimFields();
        
        String message = "Hi " + claim.getPatient().getPersonDetails().getFullName() + "!\n" +
                "Your insurance claim of " + claim.getTotalClaimAmount() + " USD has been declined by " + insuranceCompany + ".\n" +
                "Your responsibility is " + claim.getTotalClaimAmount() + " USD.\n" +
                "To pay your bill, visit " + insuranceCompany + " company website.\n" +
                "\n\n\n" +
                "Cheers -\n" +
                "Health Springs App Team";
        sendEmail(message, claim.getPatient());     
    }//GEN-LAST:event_btnDeclineClaimActionPerformed

    private void jCheckBoxSendClaimEmailToPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSendClaimEmailToPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxSendClaimEmailToPatientActionPerformed

    private void jTextFieldInsuranceCompanyDeductableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInsuranceCompanyDeductableActionPerformed
        // TODO add your handling code here:
        jTextFieldInsuranceCompanyDeductable.setBackground(Color.white);
        String value = jTextFieldInsuranceCompanyDeductable.getText();
        if (StringUtils.isEmpty(value) || "-".equals(value)) {
            return;
        }
        
        try {
            double insuranceDeductable = Double.parseDouble(value);
            if (insuranceDeductable > claim.getTotalClaimAmount()) {
                jLabelPatientsResponsibilityPlaceHolder.setText("0.00$");
                return;
            }
            double patientResponsibility = claim.getTotalClaimAmount() - insuranceDeductable;
            jLabelPatientsResponsibilityPlaceHolder.setText(patientResponsibility + "");
        } catch (Exception e) {
            jTextFieldInsuranceCompanyDeductable.setBackground(Color.red);
        }
    }//GEN-LAST:event_jTextFieldInsuranceCompanyDeductableActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApproveClaim;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeclineClaim;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxSendClaimEmailToPatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelClaimProcessingMessagePlaceHolder;
    private javax.swing.JLabel jLabelPatientPlaceHolder;
    private javax.swing.JLabel jLabelPatientsResponsibilityPlaceHolder;
    private javax.swing.JLabel jLabelTotalClaimAmountPlaceHolder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldInsuranceCompanyDeductable;
    // End of variables declaration//GEN-END:variables
}
