/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import DataStore.Appointment;
import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Insurance.InsuranceDetails;
import Insurance.InsuranceProviderRepresentative;
import Insurance.PrimaryCareInsuranceClaim;
import Insurance.PrimaryCareInsuranceClaim.ClaimStatus;
import Laboratory.LaboratoryAssistant;
import Laboratory.LaboratoryTestReport;
import Organization.HealthInsuranceDepartmentOrganization;
import Organization.Organization;
import Patient.Patient;
import Personnel.Person;
import Personnel.PersonDetails;
import SysAdminUI.Login;
import Utils.ConsoleLogger;
import Utils.EmailClient;
import Utils.NextScreen;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ankur Bywar
 *//**
 *
 * @author Ankur Bywar
 *//**
 *
 * @author Ankur Bywar
 */
public class InsuranceProviderRepresentativeHomePageJPanel extends javax.swing.JPanel implements NextScreen {

    private JPanel workAreaPanel;
    private EcoSystem ecoSystem;
    private LaboratoryAssistant laboratoryAssistant;
    Person insuranceProviderRepresentative;
    
    HealthInsuranceDepartmentOrganization healthInsuranceOrganization ;
    ConsoleLogger log = ConsoleLogger.getLogger();
    
    /**
     * Creates new form LaboratoryAssistantHomePagePanel
     */
    public InsuranceProviderRepresentativeHomePageJPanel(JPanel workAreaPanel, EcoSystem ecoSystem, Organization healthInsuranceOrganization, Person insuranceProviderRepresentative) {
        initComponents();
        this.setSize(1100,850);
        this.workAreaPanel = workAreaPanel;
        this.ecoSystem = ecoSystem;
        this.laboratoryAssistant = (LaboratoryAssistant) laboratoryAssistant;
        this.insuranceProviderRepresentative = insuranceProviderRepresentative;
        this.healthInsuranceOrganization = (HealthInsuranceDepartmentOrganization) healthInsuranceOrganization;
        
         healthInsuranceOrganization = getHealthInsuranceOrganization(insuranceProviderRepresentative);
        
        populatePendingHealthInsuranceClaimsTable();
        populateProcessedHealthInsuranceClaimsTable();
        populateInsuranceProviderRepresentativeInfoPlaceholders();
        populateInsuranceRequests(tblUnProcessedInsuranceRequests, this.healthInsuranceOrganization.getPendingnewInsuranceRequests());
        populateInsuranceRequests(tblProcessedInsuranceRequests, this.healthInsuranceOrganization.getProcessedInsuranceRequests());  
    }
    
    public void reload() {
        populatePendingHealthInsuranceClaimsTable();
        populateProcessedHealthInsuranceClaimsTable();
    }
    
    HealthInsuranceDepartmentOrganization getHealthInsuranceOrganization(Person insuranceProviderRepresentative) {
        InsuranceProviderRepresentative insuranceRep = (InsuranceProviderRepresentative)insuranceProviderRepresentative;
        return (HealthInsuranceDepartmentOrganization)insuranceRep.getOrganization();
    }
    
    void populateInsuranceRequests(JTable tblPendingInsuranceRequests, List<InsuranceDetails> insuranceRequests) {
        DefaultTableModel  model = (DefaultTableModel) tblPendingInsuranceRequests.getModel();
        model.setRowCount(0);

        if (insuranceRequests == null || insuranceRequests.isEmpty()) {
            log.debug("No requests found");
            return;
        }
        
        for (InsuranceDetails insuranceRequest : insuranceRequests) {
            Object row[] = new Object[5];
            row[0] = insuranceRequest.getId();
            row[1] = insuranceRequest.getRequestDate().toString();
            row[2] = insuranceRequest.getPatient().getPersonDetails().getFullName();
            row[3] = insuranceRequest.getPlanDetails().getPlanName();
            row[4] = insuranceRequest.getInsuranceRequestApprovalStatus().toString();
            model.addRow(row);
        }
    }
    
    void populatePendingHealthInsuranceClaimsTable() {
        DefaultTableModel  model = (DefaultTableModel) tblPendingHealthInsuranceClaims.getModel();
        model.setRowCount(0);

        List<PrimaryCareInsuranceClaim> pendingClaims = healthInsuranceOrganization.getPendingMedicalInsuranceClaims();
        if (pendingClaims == null || pendingClaims.isEmpty()) {
            log.debug("No pending PrimaryCareInsuranceClaims");
            return;
        }

        for (PrimaryCareInsuranceClaim claim : pendingClaims) {
            if (claim.getClaimSatus().equals(ClaimStatus.PENDING)) {
                Object row[] = new Object[3];
                row[0] = claim.getClaimId();
                row[1] = claim.getPatient().getPersonDetails().getFullName();
                row[2] = claim.getClaimSatus();
                model.addRow(row);
            }
        }
    }
    
    void populateProcessedHealthInsuranceClaimsTable() {
        DefaultTableModel  model = (DefaultTableModel) tblProcessedHealthInsuranceClaims.getModel();
        model.setRowCount(0);

        List<PrimaryCareInsuranceClaim> processedClaims = healthInsuranceOrganization.getProcessedMedicalInsuranceClaims();
        if (processedClaims == null || processedClaims.isEmpty()) {
            log.debug("No processed PrimaryCareInsuranceClaims");
            return;
        }

        for (PrimaryCareInsuranceClaim claim : processedClaims) {
            if (!claim.getClaimSatus().equals(ClaimStatus.PENDING)) {
                Object row[] = new Object[3];
                row[0] = claim.getClaimId();
                row[1] = claim.getPatient().getPersonDetails().getFullName();
                row[2] = claim.getClaimSatus();
                model.addRow(row);
            }
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

        jPanel1 = new javax.swing.JPanel();
        lblPhoneNumberPlaceHolder = new javax.swing.JLabel();
        lblNamePlaceHolder = new javax.swing.JLabel();
        lblDob1 = new javax.swing.JLabel();
        lblWeight1 = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblAddressPlaceHolder = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        lblPatientDetails = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblEmailPlaceHolder = new javax.swing.JLabel();
        lblGenderPlaceHolder = new javax.swing.JLabel();
        lblDobPlaceHolder = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnProcessClaim = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProcessedHealthInsuranceClaims = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnBback = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPendingHealthInsuranceClaims = new javax.swing.JTable();
        btnReviewClaim = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblUnProcessedInsuranceRequests = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnAcceptInsuranceRequest = new javax.swing.JButton();
        btnDeclineInsuranceRequest = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblProcessedInsuranceRequests = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPhoneNumberPlaceHolder.setText("Phone Number Place Holder");
        jPanel1.add(lblPhoneNumberPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 146, -1, -1));

        lblNamePlaceHolder.setText("NamePlaceHolder");
        jPanel1.add(lblNamePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 88, -1, -1));

        lblDob1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDob1.setText("Date Of Birth:");
        jPanel1.add(lblDob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 121, -1, -1));

        lblWeight1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblWeight1.setText("Email ID:");
        jPanel1.add(lblWeight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 229, -1, -1));

        lblGender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGender.setText("Gender");
        jPanel1.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 199, 56, -1));

        lblAddressPlaceHolder.setText("AddressPlaceHolder");
        jPanel1.add(lblAddressPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/user1new.png"))); // NOI18N
        imgLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 120, 120));

        lblPatientDetails.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPatientDetails.setText("Insurance Provider Home Page");
        jPanel1.add(lblPatientDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 370, 40));

        lblPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");
        jPanel1.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 145, -1, -1));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddress.setText("Address:");
        jPanel1.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 169, 68, -1));

        lblEmailPlaceHolder.setText("EmailIdPlaceHolder");
        jPanel1.add(lblEmailPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        lblGenderPlaceHolder.setText("GenderHolder");
        jPanel1.add(lblGenderPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        lblDobPlaceHolder.setText("DobPlaceHolder");
        jPanel1.add(lblDobPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 122, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Pending Health Insurance Claims");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 275, 330, 26));

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Name:");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 87, -1, -1));

        btnProcessClaim.setBackground(new java.awt.Color(255, 255, 255));
        btnProcessClaim.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnProcessClaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-process-30 (1).png"))); // NOI18N
        btnProcessClaim.setText("Process Claim");
        btnProcessClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessClaimActionPerformed(evt);
            }
        });
        jPanel1.add(btnProcessClaim, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        tblProcessedHealthInsuranceClaims.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Claim Id", "Patient Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblProcessedHealthInsuranceClaims);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 525, 104));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Processed Health Insurance Claims");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 330, 26));

        btnBback.setBackground(new java.awt.Color(255, 255, 255));
        btnBback.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnBback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/logout.png"))); // NOI18N
        btnBback.setText("Logout");
        btnBback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBback, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 6, 117, -1));

        tblPendingHealthInsuranceClaims.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Claim Id", "Patient Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblPendingHealthInsuranceClaims);
        if (tblPendingHealthInsuranceClaims.getColumnModel().getColumnCount() > 0) {
            tblPendingHealthInsuranceClaims.getColumnModel().getColumn(0).setResizable(false);
            tblPendingHealthInsuranceClaims.getColumnModel().getColumn(1).setResizable(false);
            tblPendingHealthInsuranceClaims.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 299, 525, 104));

        btnReviewClaim.setBackground(new java.awt.Color(255, 255, 255));
        btnReviewClaim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReviewClaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/review.png"))); // NOI18N
        btnReviewClaim.setText("Review Claim");
        btnReviewClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewClaimActionPerformed(evt);
            }
        });
        jPanel1.add(btnReviewClaim, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 160, -1));

        tblUnProcessedInsuranceRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Request Date", "Beneficiary name", "Plan Details", "Request Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblUnProcessedInsuranceRequests);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 690, 525, 104));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setText("Pending insurance Requests");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 660, 330, 26));

        btnAcceptInsuranceRequest.setBackground(new java.awt.Color(255, 255, 255));
        btnAcceptInsuranceRequest.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAcceptInsuranceRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/accept.png"))); // NOI18N
        btnAcceptInsuranceRequest.setText("Accept");
        btnAcceptInsuranceRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptInsuranceRequestActionPerformed(evt);
            }
        });
        jPanel1.add(btnAcceptInsuranceRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 800, 110, -1));

        btnDeclineInsuranceRequest.setBackground(new java.awt.Color(255, 255, 255));
        btnDeclineInsuranceRequest.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnDeclineInsuranceRequest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/disagree.png"))); // NOI18N
        btnDeclineInsuranceRequest.setText("Decline");
        btnDeclineInsuranceRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineInsuranceRequestActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeclineInsuranceRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 802, 120, 40));

        tblProcessedInsuranceRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Request Date", "Beneficiary name", "Plan Details", "Request Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblProcessedInsuranceRequests);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 880, 525, 104));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setText("Processed insurance Requests");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 850, 330, 26));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X960.jpg"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1100, 980));
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessClaimActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblProcessedHealthInsuranceClaims.getSelectedRow();
        if (selectedRow < 0) {
            log.error("Selected row from tblPendingHealthInsuranceClaims table is not >= 0");
            return;
        }
        
        long claimId = (long) tblPendingHealthInsuranceClaims.getModel().getValueAt(selectedRow, 0);
        PrimaryCareInsuranceClaim claimToBeProcessed = null;
        for (PrimaryCareInsuranceClaim claim : healthInsuranceOrganization.getPendingMedicalInsuranceClaims()) {
            if (claim.getClaimId() == claimId) {
                claimToBeProcessed = claim;
                break;
            }
        }
        
        if (claimToBeProcessed == null) {
            log.error("No claim found with id " + claimId);
            return;
        }
        
        nextScreen(workAreaPanel, new PatientClaimDetailsJPanel(workAreaPanel, claimToBeProcessed, this), "PatientClaimDetailsJPanel");
    }//GEN-LAST:event_btnProcessClaimActionPerformed

    private void btnBbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBbackActionPerformed
        // TODO add your handling code here:
        nextScreen(workAreaPanel, new Login(workAreaPanel, ecoSystem), "Patient home page");
    }//GEN-LAST:event_btnBbackActionPerformed

    private void btnReviewClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewClaimActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblProcessedHealthInsuranceClaims.getSelectedRow();
        if (selectedRow < 0) {
            log.error("Selected row from tblProcessedHealthInsuranceClaims table is not >= 0");
            return;
        }
        
        long claimId = (long) tblProcessedHealthInsuranceClaims.getModel().getValueAt(selectedRow, 0);
        PrimaryCareInsuranceClaim claimToBeProcessed = null;
        for (PrimaryCareInsuranceClaim claim : healthInsuranceOrganization.getPendingMedicalInsuranceClaims()) {
            if (claim.getClaimId() == claimId) {
                claimToBeProcessed = claim;
                break;
            }
        }
        
        if (claimToBeProcessed == null) {
            log.error("No claim found with id " + claimId);
            return;
        }
        
        nextScreen(workAreaPanel, new PatientClaimDetailsJPanel(workAreaPanel, claimToBeProcessed, this), "PatientClaimDetailsJPanel");
    }//GEN-LAST:event_btnReviewClaimActionPerformed

    private void btnAcceptInsuranceRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptInsuranceRequestActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblUnProcessedInsuranceRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a pending insurance requests table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        long requestId = (long) tblUnProcessedInsuranceRequests.getModel().getValueAt(selectedRow, 0);
        InsuranceDetails insuranceDetails = healthInsuranceOrganization.getUnprocessedInsuranceRequest(requestId);
        if (insuranceDetails == null) {
            JOptionPane.showMessageDialog(null, "No pending insurance found with id: " + requestId, "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        insuranceDetails.setExpiryDate(LocalDate.now().plusYears(1));
        Random r = new Random();
        insuranceDetails.setInsuranceNumber((long) r.nextInt(Short.MAX_VALUE + 1));
        insuranceDetails.setGroupNumber((long)healthInsuranceOrganization.getEnterprise().getEnterpriseId());
        insuranceDetails.setInsuranceRequestApprovalStatus(InsuranceDetails.InsuranceRequestApprovalStatus.APPROVED);
        
        healthInsuranceOrganization.processInsuranceRequest(insuranceDetails);
        populateInsuranceRequests(tblUnProcessedInsuranceRequests, this.healthInsuranceOrganization.getPendingnewInsuranceRequests());
        populateInsuranceRequests(tblProcessedInsuranceRequests, this.healthInsuranceOrganization.getProcessedInsuranceRequests());
        Patient patient = (Patient) insuranceDetails.getPatient();
        patient.setInsuranceDetails(insuranceDetails);
        
        JOptionPane.showMessageDialog(null, "An email has been sent to the customer indicating an update to their insurance policy. ");
        sendInsuranceAcceptanceUpdatePolicyEmail(patient);
    }//GEN-LAST:event_btnAcceptInsuranceRequestActionPerformed

    private void sendInsuranceAcceptanceUpdatePolicyEmail(Patient patient) {
       boolean success = new EmailClient().sendEmail(
               patient.getPersonDetails().getEmailId(), 
               ecoSystem.getSysAdminEmail(), 
               ecoSystem.getSysAdmingEmailPassword(), 
               getInsurancePolicyUpdateEmailSubject(), 
               getInsurancePolicyAcceptanceUpdateEmailBody(patient));
        log.debug("Insurance policy update email sent to user: " + patient.getUserAccount().getUsername() + ". Email status success: " + success);
    }
    
    private String getInsurancePolicyUpdateEmailSubject() {
        return "Your insurance policy update associated with Health Springs App";
    }
    
    private String getInsurancePolicyAcceptanceUpdateEmailBody(Person patient) {
        String enterpriseName = healthInsuranceOrganization.getEnterprise().getEnterpriseName();
        return "Hi " + patient.getPersonDetails().getFullName() + "!\n" +
                "There has been an update to your health insurance policy associated with Health Springs App.\n" + 
                "Your health insurance provider, " + enterpriseName + ", " +
                "has accepted your request to update your policy.\n" +
                "Please check your app to see the updated policy and coverage details.\n" +
                "For further questions, email us at healthspringapp@gmail.com OR reach out to" + enterpriseName +"'s customer service number."+
                "\n\n\n" +
                "Regards -\n" +
                "Health Springs App Team";
                
    }
    
    private void btnDeclineInsuranceRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineInsuranceRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblUnProcessedInsuranceRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a pending insurance request from the table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        long requestId = (long) tblUnProcessedInsuranceRequests.getModel().getValueAt(selectedRow, 0);
        InsuranceDetails insuranceDetails = healthInsuranceOrganization.getUnprocessedInsuranceRequest(requestId);
        if (insuranceDetails == null) {
            JOptionPane.showMessageDialog(null, "No pending insurance found with id: " + requestId, "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        insuranceDetails.setInsuranceRequestApprovalStatus(InsuranceDetails.InsuranceRequestApprovalStatus.DECLINED);
        
        populateInsuranceRequests(tblUnProcessedInsuranceRequests, this.healthInsuranceOrganization.getPendingnewInsuranceRequests());
        populateInsuranceRequests(tblProcessedInsuranceRequests, this.healthInsuranceOrganization.getProcessedInsuranceRequests());  
        
        JOptionPane.showMessageDialog(null, "An email has been sent to the customer indicating an update to their insurance policy.");
        sendInsuranceDecliceUpdatePolicyEmail(insuranceDetails.getPatient());
        
    }//GEN-LAST:event_btnDeclineInsuranceRequestActionPerformed

    private void sendInsuranceDecliceUpdatePolicyEmail(Person patient) {
       boolean success = new EmailClient().sendEmail(
               patient.getPersonDetails().getEmailId(), 
               ecoSystem.getSysAdminEmail(), 
               ecoSystem.getSysAdmingEmailPassword(), 
               getInsurancePolicyUpdateEmailSubject(), 
               getInsurancePolicyDeclineUpdateEmailBody(patient));
        log.debug("Insurance policy update email sent to user: " + patient.getUserAccount().getUsername() + ". Email status success: " + success);
    }
    
    private String getInsurancePolicyDeclineUpdateEmailBody(Person patient) {
        String enterpriseName = healthInsuranceOrganization.getEnterprise().getEnterpriseName();
        return "Hi " + patient.getPersonDetails().getFullName() + "!\n" +
                "There has been an update to your health insurance policy associated with Health Springs App.\n" + 
                "Your health insurance provider, " + enterpriseName + ", " +
                "has declined your request to update your policy.\n" +
                "For further questions, email us at healthspringapp@gmail.com OR reach out to" + enterpriseName +"'s customer service number."+
                "\n\n\n" +
                "Regards -\n" +
                "Health Springs App Team";
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptInsuranceRequest;
    private javax.swing.JButton btnBback;
    private javax.swing.JButton btnDeclineInsuranceRequest;
    private javax.swing.JButton btnProcessClaim;
    private javax.swing.JButton btnReviewClaim;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressPlaceHolder;
    private javax.swing.JLabel lblDob1;
    private javax.swing.JLabel lblDobPlaceHolder;
    private javax.swing.JLabel lblEmailPlaceHolder;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGenderPlaceHolder;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePlaceHolder;
    private javax.swing.JLabel lblPatientDetails;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberPlaceHolder;
    private javax.swing.JLabel lblWeight1;
    private javax.swing.JTable tblPendingHealthInsuranceClaims;
    private javax.swing.JTable tblProcessedHealthInsuranceClaims;
    private javax.swing.JTable tblProcessedInsuranceRequests;
    private javax.swing.JTable tblUnProcessedInsuranceRequests;
    // End of variables declaration//GEN-END:variables

    private void populateInsuranceProviderRepresentativeInfoPlaceholders() {
        PersonDetails pd = insuranceProviderRepresentative.getPersonDetails();
        lblAddressPlaceHolder.setText(pd.getAddress().toString()); 
        lblGenderPlaceHolder.setText(pd.getDob().toString()); 
        lblNamePlaceHolder.setText(pd.getFullName()); 
        lblPhoneNumberPlaceHolder.setText(pd.getPhoneNumber());
        lblGenderPlaceHolder.setText(pd.getGender().toString());
        imgLogo.setIcon(pd.getLogoImage());
    }
}
