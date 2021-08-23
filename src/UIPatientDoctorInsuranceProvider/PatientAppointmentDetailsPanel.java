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
import Laboratory.LaboratoryAssistant;
import Laboratory.LaboratoryTestReport;
import Organization.LaboratoryOrganization;
import Organization.Organization;
import Organization.OrganizationType;
import Patient.Patient;
import Personnel.Person;
import Utils.ConsoleLogger;
import Utils.NextScreen;
import Utils.AwsS3Helper;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ankur Bywar
 */
public class PatientAppointmentDetailsPanel extends javax.swing.JPanel implements NextScreen {
    JPanel workAreaPanel;
    EcoSystem ecosystem;
    Doctor doctor;
    Patient patient;
    Appointment appointment;
    Enterprise hospital;
    DoctorWorkAreaPanel backpage;
    
    ConsoleLogger log = ConsoleLogger.getLogger();
    AwsS3Helper s3helper;
    /**
     * Creates new form PatientAppointmentDetailsPanel
     */
    public PatientAppointmentDetailsPanel(JPanel workAreaPanel, EcoSystem ecosystem, Enterprise hospital, Appointment appointment, JPanel backpage) {
        initComponents();
        this.setSize(1100,850);
        this.workAreaPanel = workAreaPanel;
        this.ecosystem = ecosystem;
        this.appointment = appointment;
        this.doctor = (Doctor) appointment.getDoctor();
        this.patient = (Patient) appointment.getPatient();
        this.hospital = hospital;
        this.backpage = (DoctorWorkAreaPanel) backpage;
        this.s3helper = new AwsS3Helper();
        
        populatePatientDetails();
        populateLabAssistantCombo();
        
        if (appointment.getStatus().equals(Appointment.AppointmentStatus.COMPLETED)) {
            btnSubmitNewLabTestRequest1.setEnabled(false);
            btnNewAppointmentDetails.setEnabled(false);
            btnPrescribeNewMedicines.setEnabled(false);
            btnGeneratePatientBill.setEnabled(false);
        }
        
        if (appointment.getLabTestReport() != null) {
            btnSubmitNewLabTestRequest1.setEnabled(false); // do not allow oprdering new lab test if one is already pending
        }

        
        // Download files from S3
        //  - Daily medicine report (not needed here. Will be needed in patient home page)
        //  - Daily vitals report
        //  - Insurance details
        //  - Current Prescription Details (prescription date, meds, power, dosages etc.)
        // Last appointment details
        // Previous lab reports and lab reports history
        // Perform new lab test (Go to new lab page - pass by reference a lab report object)
        // Prescribe new meds (Go to new meds prescription page - pass by reference a lab report object)
        
        // File opening: https://www.youtube.com/watch?v=DfTpJPEAoH0
    }
    
    void populateLabAssistantCombo() {
        jComboBoxLabAssistantList.removeAllItems();
        jComboBoxLabAssistantList.addItem("Select");
        
        List<Organization> organizations = hospital.getOrganizations();
        for (Organization org : organizations) {
            if (org.getOrganizationType().equals(OrganizationType.LABORATORY)) {
                jComboBoxLabAssistantList.addItem(org.getOrganizationId()+ ":" + org.getName());
            }
        }
    }
    
    void populatePatientDetails() {
        lblAptDatePlaceHolder.setText(appointment.getDate() + " at " + appointment.getAppointmentTimeHours() + ":00");
        lblAddressPlaceHolder.setText(appointment.getPatient().getPersonDetails().getAddress().toString());
        lblAgePlaceHolder.setText(appointment.getPatient().getPersonDetails().getAge() + " years");
        //lblEmailPlaceHolder.setText();
        lblNamePlaceHolder.setText(appointment.getPatient().getPersonDetails().getFullName());
        lblPhoneNumberPlaceHolder.setText(appointment.getPatient().getPersonDetails().getPhoneNumber());       
        lblWeightPlaceHolder.setText(this.patient.getMostRecentVitalSigns() == null ? "Not Available" : this.patient.getMostRecentVitalSigns().getWeight() + " kgs");
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
        jPatientDetailPanel = new javax.swing.JPanel();
        lblAddress = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        lblNamePlaceHolder = new javax.swing.JLabel();
        lblDob1 = new javax.swing.JLabel();
        lblDobPlaceHolder = new javax.swing.JLabel();
        lblPhoneNumberPlaceHolder = new javax.swing.JLabel();
        lblAddressPlaceHolder = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblAgePlaceHolder = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        lblWeightPlaceHolder = new javax.swing.JLabel();
        lblWeight1 = new javax.swing.JLabel();
        lblEmailPlaceHolder = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnViewLabTestResults = new javax.swing.JButton();
        jComboBoxLabAssistantList = new javax.swing.JComboBox<>();
        lblName3 = new javax.swing.JLabel();
        btnPrescribeNewMedicines = new javax.swing.JButton();
        lblWeight2 = new javax.swing.JLabel();
        lblAptDatePlaceHolder = new javax.swing.JLabel();
        jBtnViewPreviousAppointments1 = new javax.swing.JButton();
        btnGeneratePatientBill = new javax.swing.JButton();
        btnSubmitNewLabTestRequest1 = new javax.swing.JButton();
        btnNewAppointmentDetails = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPatientDetailPanel.setOpaque(false);
        jPatientDetailPanel.setPreferredSize(new java.awt.Dimension(1000, 1000));
        jPatientDetailPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddress.setText("Address:");
        jPatientDetailPanel.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 150, -1));

        lblPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");
        jPatientDetailPanel.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 150, -1));

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Name:");
        jPatientDetailPanel.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 150, -1));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/user1new.png"))); // NOI18N
        imgLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPatientDetailPanel.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 120, 120));

        lblNamePlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblNamePlaceHolder.setText("NamePlaceHolder");
        jPatientDetailPanel.add(lblNamePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 160, 20));

        lblDob1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDob1.setText("Date Of Birth:");
        jPatientDetailPanel.add(lblDob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 150, -1));

        lblDobPlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblDobPlaceHolder.setText("DobPlaceHolder");
        jPatientDetailPanel.add(lblDobPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 160, 20));

        lblPhoneNumberPlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblPhoneNumberPlaceHolder.setText("Phone Number Place Holder");
        jPatientDetailPanel.add(lblPhoneNumberPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        lblAddressPlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblAddressPlaceHolder.setText("AddressPlaceHolder");
        jPatientDetailPanel.add(lblAddressPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 180, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Appointment Details");
        jPatientDetailPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 23, 248, 48));

        lblAge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAge.setText("Age:");
        jPatientDetailPanel.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 150, -1));

        lblAgePlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblAgePlaceHolder.setText("AgeHolder");
        jPatientDetailPanel.add(lblAgePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 180, -1));

        lblWeight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblWeight.setText("Weight:");
        jPatientDetailPanel.add(lblWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 150, -1));

        lblWeightPlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblWeightPlaceHolder.setText("WeightPlaceHolder");
        jPatientDetailPanel.add(lblWeightPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 170, -1));

        lblWeight1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblWeight1.setText("Email ID:");
        jPatientDetailPanel.add(lblWeight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 150, -1));

        lblEmailPlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblEmailPlaceHolder.setText("EmailIdPlaceHolder");
        jPatientDetailPanel.add(lblEmailPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 180, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/prescription.png"))); // NOI18N
        jButton1.setText("Prescription History");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 350, 48));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-money-bag-30.png"))); // NOI18N
        jButton2.setText("Insurance Details");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 350, 48));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-graph-report-30.png"))); // NOI18N
        jButton3.setText("Historical Vitals Report");
        jButton3.setBorderPainted(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 350, 40));

        btnViewLabTestResults.setBackground(new java.awt.Color(255, 255, 255));
        btnViewLabTestResults.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewLabTestResults.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-view-details-30.png"))); // NOI18N
        btnViewLabTestResults.setText("View Results");
        btnViewLabTestResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLabTestResultsActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(btnViewLabTestResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 150, -1));

        jComboBoxLabAssistantList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPatientDetailPanel.add(jComboBoxLabAssistantList, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 190, -1));

        lblName3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName3.setText("Perform new Lab Test");
        jPatientDetailPanel.add(lblName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        btnPrescribeNewMedicines.setBackground(new java.awt.Color(255, 255, 255));
        btnPrescribeNewMedicines.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrescribeNewMedicines.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/medication.png"))); // NOI18N
        btnPrescribeNewMedicines.setText("Prescribe new medicines");
        btnPrescribeNewMedicines.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPrescribeNewMedicines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrescribeNewMedicinesActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(btnPrescribeNewMedicines, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 350, 48));

        lblWeight2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblWeight2.setText("Appointment Date:");
        jPatientDetailPanel.add(lblWeight2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 150, -1));

        lblAptDatePlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblAptDatePlaceHolder.setText("appointment date place holder");
        jPatientDetailPanel.add(lblAptDatePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 200, -1));

        jBtnViewPreviousAppointments1.setBackground(new java.awt.Color(255, 255, 255));
        jBtnViewPreviousAppointments1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jBtnViewPreviousAppointments1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/view_past_appointment.png"))); // NOI18N
        jBtnViewPreviousAppointments1.setText("View previous appointments and lab tests");
        jBtnViewPreviousAppointments1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnViewPreviousAppointments1ActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(jBtnViewPreviousAppointments1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 350, -1));

        btnGeneratePatientBill.setBackground(new java.awt.Color(255, 255, 255));
        btnGeneratePatientBill.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGeneratePatientBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-receipt-dollar-30.png"))); // NOI18N
        btnGeneratePatientBill.setText("Bill the patient via insurance");
        btnGeneratePatientBill.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGeneratePatientBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratePatientBillActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(btnGeneratePatientBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 350, 50));

        btnSubmitNewLabTestRequest1.setBackground(new java.awt.Color(255, 255, 255));
        btnSubmitNewLabTestRequest1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSubmitNewLabTestRequest1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-test-passed-30.png"))); // NOI18N
        btnSubmitNewLabTestRequest1.setText("Request Test");
        btnSubmitNewLabTestRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitNewLabTestRequest1ActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(btnSubmitNewLabTestRequest1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 150, -1));

        btnNewAppointmentDetails.setBackground(new java.awt.Color(255, 255, 255));
        btnNewAppointmentDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNewAppointmentDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-double-tick-30.png"))); // NOI18N
        btnNewAppointmentDetails.setText("Complete Appointment");
        btnNewAppointmentDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNewAppointmentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAppointmentDetailsActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(btnNewAppointmentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 350, 50));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 23, -1, 37));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jPatientDetailPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 850));

        jPanel1.add(jPatientDetailPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1094, 840));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed


        JOptionPane.showMessageDialog(null, "This will download file from Amazon S3 bucket");
        
        String vitalsHistoryImagePath = appointment.getPatientVitalSignsHistoryS3ObjectPath();
        if (vitalsHistoryImagePath == null) {
            JOptionPane.showMessageDialog(null, "No vitals history provided by the patient");
            return;
        }
        
        String patientUsername = appointment.getPatient().getUserAccount().getUsername();
        String vitalsHistoryImageName = "vitals-image-" + patientUsername + "-" + appointment.getId() + "-" + appointment.getDate();
        String localVitalsHistoryImagePath = "/tmp/doctor/" + vitalsHistoryImageName;
        boolean success = s3helper.getObject(vitalsHistoryImagePath, localVitalsHistoryImagePath);
        if (!success) {
            JOptionPane.showMessageDialog(null, "Some unexpected error downloading file from S3");
            return;
        }
        
        log.debug("Successfully downloaded patient's vital sign report from S3");

        try {
            Desktop.getDesktop().open(new File(localVitalsHistoryImagePath));
        } catch (IOException ex) {
            log.debug("Error in opening patient's vital sign report file. Exception: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBtnViewPreviousAppointments1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnViewPreviousAppointments1ActionPerformed
        // TODO add your handling code here:
        nextScreen(workAreaPanel, new PatientAppointmentHistoyJPanel(workAreaPanel, ecosystem, patient, this), "PatientAppointmentHistoyJPanel");
    }//GEN-LAST:event_jBtnViewPreviousAppointments1ActionPerformed

    private void btnViewLabTestResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLabTestResultsActionPerformed
        // TODO add your handling code here:
        
        nextScreen(workAreaPanel, new PatientLabTestViewJPanel(workAreaPanel, appointment.getLabTestReport(), this), "PatientLabTestViewJPanel");
    }//GEN-LAST:event_btnViewLabTestResultsActionPerformed

    private void btnSubmitNewLabTestRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitNewLabTestRequest1ActionPerformed
        // TODO add your handling code here:]
        if(jComboBoxLabAssistantList.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please select a Laboratory");
            return;
        }
        
        String selectedLab = (String)jComboBoxLabAssistantList.getSelectedItem();
        int labId = Integer.parseInt(selectedLab.split(":")[0]);
        Organization laboratory = null;
        
        for (Organization org : (List<Organization>) hospital.getOrganizations()) {
            if (org.getOrganizationType().equals(OrganizationType.LABORATORY) && labId == org.getOrganizationId()) {
                laboratory = org; 
            }
        }
        
        if (laboratory == null) {
            JOptionPane.showMessageDialog(null, "No laboratory found with id: " + labId);
            return;
        }
        
        List<Person> labAssistants = laboratory.getAllEmployees();
        for (Person labAssistant : labAssistants) {
            // pick first lab assistant since each laboratory will have one lab assistant
            LaboratoryAssistant labAss = (LaboratoryAssistant) labAssistant;
            LaboratoryTestReport laboratoryTestReport = new LaboratoryTestReport(laboratory, labAss, patient, doctor, appointment, LocalDate.now());
            labAss.assignLabTest(laboratoryTestReport);
            appointment.setLabTestReport(laboratoryTestReport);
            break;
        }
        
        JOptionPane.showMessageDialog(null, "Lab test requested");
        btnSubmitNewLabTestRequest1.setEnabled(false);
    }//GEN-LAST:event_btnSubmitNewLabTestRequest1ActionPerformed

    private void btnNewAppointmentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAppointmentDetailsActionPerformed
        // TODO add your handling code here:
        
        appointment.setStatus(Appointment.AppointmentStatus.COMPLETED);
        patient.completeDoctorAppointment(appointment);
        
        btnSubmitNewLabTestRequest1.setEnabled(false);
        btnPrescribeNewMedicines.setEnabled(false);
        btnNewAppointmentDetails.setEnabled(false);
        
    }//GEN-LAST:event_btnNewAppointmentDetailsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        backpage.reload();
        nextScreen(workAreaPanel, backpage, "Patient home page");
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(null, "This will download insurance details file from Amazon S3 bucket");
        
        String s3insuranceFileKey = appointment.getPatientInsuranceFileS3ObjectPath();
        if (s3insuranceFileKey == null) {
            JOptionPane.showMessageDialog(null, "No insurance provided by the patient while booking appointment");
            return;
        }
        
        String patientUsername = appointment.getPatient().getUserAccount().getUsername();
        String insuranceFileName = "insurance-detail-file-" + patientUsername;
        String insuranceFilePath = "/tmp/doctor/" + insuranceFileName;
        boolean success = s3helper.getObject(s3insuranceFileKey, insuranceFilePath);
        if (!success) {
            JOptionPane.showMessageDialog(null, "Some unexpected error downloading file from S3");
            return;
        }
        
        log.debug("Successfully downloaded patient's insurance file from S3");

        try {
            Desktop.getDesktop().open(new File(insuranceFilePath));
        } catch (IOException ex) {
            log.debug("Error in opening patient's insurance file. Exception: " + ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnGeneratePatientBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneratePatientBillActionPerformed
        // TODO add your handling code here:
        
        nextScreen(workAreaPanel, new GeneratePatientBillJPanel(workAreaPanel, ecosystem, appointment, this), TOOL_TIP_TEXT_KEY);
        
    }//GEN-LAST:event_btnGeneratePatientBillActionPerformed

    private void btnPrescribeNewMedicinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrescribeNewMedicinesActionPerformed
        // TODO add your handling code here:
        nextScreen(workAreaPanel, new PrescribeMedicinesJPanel(workAreaPanel, ecosystem, appointment, this), TOOL_TIP_TEXT_KEY);
    }//GEN-LAST:event_btnPrescribeNewMedicinesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(null, "This will download file from Amazon S3 bucket");
        
        String prescriptionHistoryS3Path = appointment.getPatientPrescriptionsFileS3ObjectPath();
        if (prescriptionHistoryS3Path == null) {
            JOptionPane.showMessageDialog(null, "No prescription history found");
            return;
        }
        
        String patientUsername = appointment.getPatient().getUserAccount().getUsername();
        String prescriptionHistoryFileName = "prescriptions-history-" + patientUsername + "-" + appointment.getId() + "-" + appointment.getDate();
        String prescriptionHistoryFileNamePath = "/tmp/doctor/" + prescriptionHistoryFileName; 
        
        boolean success = s3helper.getObject(prescriptionHistoryS3Path, prescriptionHistoryFileNamePath);
        if (!success) {
            JOptionPane.showMessageDialog(null, "Some unexpected error downloading file from S3");
            return;
        }
        
        log.debug("Successfully downloaded patient's prescription history from S3");

        try {
            Desktop.getDesktop().open(new File(prescriptionHistoryFileNamePath));
        } catch (IOException ex) {
            log.debug("Error in opening patient's prescription history file. Exception: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGeneratePatientBill;
    private javax.swing.JButton btnNewAppointmentDetails;
    private javax.swing.JButton btnPrescribeNewMedicines;
    private javax.swing.JButton btnSubmitNewLabTestRequest1;
    private javax.swing.JButton btnViewLabTestResults;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JButton jBtnViewPreviousAppointments1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxLabAssistantList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPatientDetailPanel;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressPlaceHolder;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAgePlaceHolder;
    private javax.swing.JLabel lblAptDatePlaceHolder;
    private javax.swing.JLabel lblDob1;
    private javax.swing.JLabel lblDobPlaceHolder;
    private javax.swing.JLabel lblEmailPlaceHolder;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblNamePlaceHolder;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberPlaceHolder;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel lblWeight1;
    private javax.swing.JLabel lblWeight2;
    private javax.swing.JLabel lblWeightPlaceHolder;
    // End of variables declaration//GEN-END:variables
}
