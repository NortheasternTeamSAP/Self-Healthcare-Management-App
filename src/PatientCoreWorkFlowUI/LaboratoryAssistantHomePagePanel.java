/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientCoreWorkFlowUI;

import DataStore.Appointment;
import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import Laboratory.LaboratoryAssistant;
import Laboratory.LaboratoryTestReport;
import Patient.Patient;
import Personnel.Person;
import Personnel.PersonDetails;
import Utils.ConsoleLogger;
import Utils.NextScreen;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ankur Bywar
 */
public class LaboratoryAssistantHomePagePanel extends javax.swing.JPanel implements NextScreen {

    private JPanel workAreaPanel;
    private EcoSystem ecoSystem;
    private LaboratoryAssistant laboratoryAssistant;
    private JPanel temporaryBack;
    Enterprise hospital;
    
    ConsoleLogger log = ConsoleLogger.getLogger();
    
    /**
     * Creates new form LaboratoryAssistantHomePagePanel
     */
    public LaboratoryAssistantHomePagePanel(JPanel workAreaPanel, EcoSystem ecoSystem,Person laboratoryAssistant) {
        initComponents();
        this.workAreaPanel = workAreaPanel;
        this.ecoSystem = ecoSystem;
        this.laboratoryAssistant = (LaboratoryAssistant) laboratoryAssistant;
        this.temporaryBack = temporaryBack;
        this.hospital = hospital;
        
        populatePendingLabTestsTable();
        populateCompletedLabTestsTable();
        populateLabAssistantInfoPlaceholders();
        
    }


    
    public void reload() {
        populatePendingLabTestsTable();
        populateCompletedLabTestsTable();
    }
    
    void populatePendingLabTestsTable() {
        DefaultTableModel  model = (DefaultTableModel) tblPendingLabTests.getModel();
        model.setRowCount(0);
        List<LaboratoryTestReport> pendingLabtests = laboratoryAssistant.getPendingLabTests();
        if (pendingLabtests == null || pendingLabtests.isEmpty()) {
            log.debug("No pending lab tests");
            return;
        }

        for (LaboratoryTestReport labTest : pendingLabtests) {
            Object row[] = new Object[3];
            row[0] = labTest.getId();
            row[1] = labTest.getPatient().getPersonDetails().getFullName();
            row[2] = labTest.getDoctor().getPersonDetails().getFullName();
            model.addRow(row);
        }
    }
    
    void populateCompletedLabTestsTable() {
        DefaultTableModel  model = (DefaultTableModel) tblCompletedLabTests.getModel();
        model.setRowCount(0);
        List<LaboratoryTestReport> completedLabTests = laboratoryAssistant.getCompletedLabTests();
        if (completedLabTests == null || completedLabTests.isEmpty()) {
            log.debug("No completed lab tests");
            return;
        }

        for (LaboratoryTestReport labTest : completedLabTests) {
            Object row[] = new Object[4];
            row[0] = labTest.getId();
            row[1] = labTest.getPatient().getPersonDetails().getFullName();
            row[2] = labTest.getDoctor().getPersonDetails().getFullName();
            row[3] = labTest.getLabTestDate();
            model.addRow(row);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCompletedLabTests = new javax.swing.JTable();
        lblEmailPlaceHolder = new javax.swing.JLabel();
        lblGenderPlaceHolder = new javax.swing.JLabel();
        lblDobPlaceHolder = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnPerformLabTest = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPendingLabTests = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnBback = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

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
        lblPatientDetails.setText("Laboratory Assistant Home Page");

        lblPhoneNumber.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");

        lblAddress.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblAddress.setText("Address:");

        tblCompletedLabTests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Lab Tests Id", "Patient Name", "Referred by Doctor", "Test Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCompletedLabTests);
        if (tblCompletedLabTests.getColumnModel().getColumnCount() > 0) {
            tblCompletedLabTests.getColumnModel().getColumn(0).setResizable(false);
            tblCompletedLabTests.getColumnModel().getColumn(1).setResizable(false);
            tblCompletedLabTests.getColumnModel().getColumn(2).setResizable(false);
            tblCompletedLabTests.getColumnModel().getColumn(3).setResizable(false);
        }

        lblEmailPlaceHolder.setText("EmailIdPlaceHolder");

        lblGenderPlaceHolder.setText("GenderPlaceHolder");

        lblDobPlaceHolder.setText("DobPlaceHolder");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Pending Lab Tests");

        lblName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblName.setText("Name:");

        btnPerformLabTest.setText("Perform Lab Test");
        btnPerformLabTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerformLabTestActionPerformed(evt);
            }
        });

        tblPendingLabTests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Lab Tests Id", "Patient Name", "Referred by Doctor"
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
        jScrollPane3.setViewportView(tblPendingLabTests);
        if (tblPendingLabTests.getColumnModel().getColumnCount() > 0) {
            tblPendingLabTests.getColumnModel().getColumn(0).setResizable(false);
            tblPendingLabTests.getColumnModel().getColumn(1).setResizable(false);
            tblPendingLabTests.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Completed Lab Tests");

        btnBback.setText("Back");
        btnBback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBbackActionPerformed(evt);
            }
        });

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
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPerformLabTest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(99, 99, 99)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPerformLabTest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerformLabTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerformLabTestActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblPendingLabTests.getSelectedRow();
        if (selectedRow < 0) {
            log.error("Selected row from tblPendingLabTests table is not >= 0");
            return;
        }
        
        int labTestId = (int) tblPendingLabTests.getModel().getValueAt(selectedRow, 0);
        LaboratoryTestReport labTestReport = null;
        for (LaboratoryTestReport ltr : laboratoryAssistant.getPendingLabTests()) {
            if (ltr.getId() == labTestId) {
                labTestReport = ltr;
                break;
            }
        }
        
        if (labTestReport == null) {
            log.error("No lab test report object found with id " + labTestId);
            return;
        }
        
        nextScreen(workAreaPanel, new LaboratoryTestPageJPanel(workAreaPanel, labTestReport, this), "LaboratoryTestPageJPanel");
    }//GEN-LAST:event_btnPerformLabTestActionPerformed

    private void btnBbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBbackActionPerformed
        // TODO add your handling code here:
        nextScreen(workAreaPanel, temporaryBack, "Patient home page");
    }//GEN-LAST:event_btnBbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBback;
    private javax.swing.JButton btnPerformLabTest;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JTable tblCompletedLabTests;
    private javax.swing.JTable tblPendingLabTests;
    // End of variables declaration//GEN-END:variables

    private void populateLabAssistantInfoPlaceholders() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          PersonDetails pd = laboratoryAssistant.getPersonDetails();
          lblNamePlaceHolder.setText(pd.getFullName());
          lblPhoneNumberPlaceHolder.setText(pd.getPhoneNumber());
          //lblEmailPlaceHolder.setText(pd.);
          lblDobPlaceHolder.setText(pd.getDob().toString());
          lblAddressPlaceHolder.setText(pd.getAddress().toString());
          lblGenderPlaceHolder.setText(pd.getGender().FEMALE.toString());
          imgLogo.setIcon(pd.getLogoImage());
          

    }
}
