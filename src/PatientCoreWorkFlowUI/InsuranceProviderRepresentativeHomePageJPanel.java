/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientCoreWorkFlowUI;

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
            if (!claim.getClaimSatus().equals(ClaimStatus.PROCESSED)) {
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

        lblPhoneNumberPlaceHolder.setText("Phone Number Place Holder");

        lblNamePlaceHolder.setText("NamePlaceHolder");

        lblDob1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblDob1.setText("Dob:");

        lblWeight1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblWeight1.setText("EmailId:");

        lblGender.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblGender.setText("Gender");

        lblAddressPlaceHolder.setText("AddressPlaceHolder");

        imgLogo.setText("<<No Image>>");

        lblPatientDetails.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblPatientDetails.setText("Insurance Provider Home Page");

        lblPhoneNumber.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");

        lblAddress.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblAddress.setText("Address:");

        lblEmailPlaceHolder.setText("EmailIdPlaceHolder");

        lblGenderPlaceHolder.setText("GenderHolder");

        lblDobPlaceHolder.setText("DobPlaceHolder");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Pending Health Insurance Claims");

        lblName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblName.setText("Name:");

        btnProcessClaim.setText("Process Claim");
        btnProcessClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessClaimActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Processed Health Insurance Claims");

        btnBback.setText("Logout");
        btnBback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBbackActionPerformed(evt);
            }
        });

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

        btnReviewClaim.setText("Review Claim");
        btnReviewClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewClaimActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setText("Pending insurance Requests");

        btnAcceptInsuranceRequest.setText("Accept");
        btnAcceptInsuranceRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptInsuranceRequestActionPerformed(evt);
            }
        });

        btnDeclineInsuranceRequest.setText("Decline");
        btnDeclineInsuranceRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineInsuranceRequestActionPerformed(evt);
            }
        });

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

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setText("Processed insurance Requests");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnBback, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(btnProcessClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnReviewClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblDob1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblDobPlaceHolder))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblPhoneNumber)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblPhoneNumberPlaceHolder))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(lblName)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblNamePlaceHolder))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblAddress)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblAddressPlaceHolder))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblWeight1)
                                                    .addComponent(lblGender))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(lblGenderPlaceHolder))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(4, 4, 4)
                                                        .addComponent(lblEmailPlaceHolder)))
                                                .addGap(5, 5, 5)))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(99, 99, 99)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnAcceptInsuranceRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnDeclineInsuranceRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(432, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(422, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBback))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(lblNamePlaceHolder))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDob1)
                            .addComponent(lblDobPlaceHolder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoneNumber)
                            .addComponent(lblPhoneNumberPlaceHolder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(lblAddressPlaceHolder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGender)
                            .addComponent(lblGenderPlaceHolder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWeight1)
                            .addComponent(lblEmailPlaceHolder))))
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addComponent(btnProcessClaim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReviewClaim)
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcceptInsuranceRequest)
                    .addComponent(btnDeclineInsuranceRequest))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(299, 299, 299)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(684, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1038, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1087, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcessClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessClaimActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblPendingHealthInsuranceClaims.getSelectedRow();
        if (selectedRow < 0) {
            log.error("Selected row from tblPendingHealthInsuranceClaims table is not >= 0");
            return;
        }
        
        int claimId = (int) tblPendingHealthInsuranceClaims.getModel().getValueAt(selectedRow, 0);
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
        
        int claimId = (int) tblProcessedHealthInsuranceClaims.getModel().getValueAt(selectedRow, 0);
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
        
        int requestId = (int) tblUnProcessedInsuranceRequests.getModel().getValueAt(selectedRow, 0);
        InsuranceDetails insuranceDetails = healthInsuranceOrganization.getUnprocessedInsuranceRequest(requestId);
        if (insuranceDetails == null) {
            JOptionPane.showMessageDialog(null, "No pending insurance found with id: " + requestId, "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        insuranceDetails.setExpiryDate(LocalDate.now().plusYears(1));
        Random r = new Random();
        insuranceDetails.setInsuranceNumber((long) r.nextInt(Short.MAX_VALUE + 1));
        insuranceDetails.setGroupNumber((long) r.nextInt(Short.MAX_VALUE + 1));
        insuranceDetails.setInsuranceRequestApprovalStatus(InsuranceDetails.InsuranceRequestApprovalStatus.APPROVED);
        
        healthInsuranceOrganization.processInsuranceRequest(insuranceDetails);
        populateInsuranceRequests(tblUnProcessedInsuranceRequests, this.healthInsuranceOrganization.getPendingnewInsuranceRequests());
        populateInsuranceRequests(tblProcessedInsuranceRequests, this.healthInsuranceOrganization.getProcessedInsuranceRequests());
        Patient patient = (Patient) insuranceDetails.getPatient();
        patient.setInsuranceDetails(insuranceDetails);
    }//GEN-LAST:event_btnAcceptInsuranceRequestActionPerformed

    private void btnDeclineInsuranceRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineInsuranceRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblUnProcessedInsuranceRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a pending insurance request from the table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int requestId = (int) tblUnProcessedInsuranceRequests.getModel().getValueAt(selectedRow, 0);
        InsuranceDetails insuranceDetails = healthInsuranceOrganization.getUnprocessedInsuranceRequest(requestId);
        if (insuranceDetails == null) {
            JOptionPane.showMessageDialog(null, "No pending insurance found with id: " + requestId, "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        insuranceDetails.setInsuranceRequestApprovalStatus(InsuranceDetails.InsuranceRequestApprovalStatus.DECLINED);
        
        populateInsuranceRequests(tblUnProcessedInsuranceRequests, this.healthInsuranceOrganization.getPendingnewInsuranceRequests());
        populateInsuranceRequests(tblProcessedInsuranceRequests, this.healthInsuranceOrganization.getProcessedInsuranceRequests());  
    }//GEN-LAST:event_btnDeclineInsuranceRequestActionPerformed


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
