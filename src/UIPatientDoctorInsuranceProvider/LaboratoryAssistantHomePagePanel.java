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
import Organization.Organization;
import Patient.Patient;
import Personnel.Person;
import Personnel.PersonDetails;
import SysAdminUI.Login;
import Utils.ConsoleLogger;
import Utils.FieldsDecorator;
import Utils.NextScreen;
import java.awt.Color;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
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
        this.setSize(1100,850);
        this.workAreaPanel = workAreaPanel;
        this.ecoSystem = ecoSystem;
        this.laboratoryAssistant = (LaboratoryAssistant) laboratoryAssistant;
        this.temporaryBack = temporaryBack;
        this.hospital = hospital;
        FieldsDecorator.decorateTable(tblPendingLabTests);
        FieldsDecorator.decorateTable(tblCompletedLabTests, new Color(255, 204, 230));
        
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
            Object row[] = new Object[4];
            row[0] = labTest.getLabTestDate().toString();
            row[1] = labTest.getPatient().getPersonDetails().getFullName();
            row[2] = labTest.getDoctor().getPersonDetails().getFullName();
            row[3] = labTest.getId();
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
            row[0] = labTest.getLabTestDate().toString();
            row[1] = labTest.getPatient().getPersonDetails().getFullName();
            row[2] = labTest.getDoctor().getPersonDetails().getFullName();
            row[3] = labTest.getId();
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
        lblGender = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        lblPatientDetails = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCompletedLabTests = new javax.swing.JTable();
        lblGenderPlaceHolder = new javax.swing.JLabel();
        lblLabNamePlaceHolder = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnPerformLabTest = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPendingLabTests = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnBback = new javax.swing.JButton();
        jLabelLabResultsPlaceHolder1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPhoneNumberPlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblPhoneNumberPlaceHolder.setText("Phone Number Place Holder");
        jPanel1.add(lblPhoneNumberPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        lblNamePlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblNamePlaceHolder.setText("NamePlaceHolder");
        jPanel1.add(lblNamePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 83, -1, -1));

        lblDob1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDob1.setForeground(new java.awt.Color(51, 153, 255));
        lblDob1.setText("Lab:");
        jPanel1.add(lblDob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGender.setForeground(new java.awt.Color(51, 153, 255));
        lblGender.setText("Gender:");
        jPanel1.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/user1new.png"))); // NOI18N
        imgLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 62, 120, 120));

        lblPatientDetails.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPatientDetails.setText("Laboratory Assistant Home");
        jPanel1.add(lblPatientDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 10, 900, 40));

        lblPhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhoneNumber.setForeground(new java.awt.Color(51, 153, 255));
        lblPhoneNumber.setText("Phone:");
        jPanel1.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        tblCompletedLabTests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Test Date", "Patient Name", "Referred by Doctor", "Lab Test Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 700, 104));

        lblGenderPlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblGenderPlaceHolder.setText("GenderPlaceHolder");
        jPanel1.add(lblGenderPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        lblLabNamePlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblLabNamePlaceHolder.setText("DobPlaceHolder");
        jPanel1.add(lblLabNamePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 680, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Pending Lab Tests");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 244, 330, 26));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(51, 153, 255));
        lblName.setText("Name:");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 82, -1, -1));

        btnPerformLabTest.setBackground(new java.awt.Color(255, 255, 255));
        btnPerformLabTest.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnPerformLabTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-test-tube-30.png"))); // NOI18N
        btnPerformLabTest.setText("Perform Lab Test");
        btnPerformLabTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerformLabTestActionPerformed(evt);
            }
        });
        jPanel1.add(btnPerformLabTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 392, 195, -1));

        tblPendingLabTests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Test date", "Patient Name", "Referred by Doctor", "Lab Test Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
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
            tblPendingLabTests.getColumnModel().getColumn(1).setResizable(false);
            tblPendingLabTests.getColumnModel().getColumn(2).setResizable(false);
            tblPendingLabTests.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 276, 700, 104));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Completed Lab Tests");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 330, 26));

        btnBback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        btnBback.setContentAreaFilled(false);
        btnBback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBback, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 8, 45, -1));

        jLabelLabResultsPlaceHolder1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelLabResultsPlaceHolder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/lab-gif-1.gif"))); // NOI18N
        jPanel1.add(jLabelLabResultsPlaceHolder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, 150, 150));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 860));

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerformLabTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerformLabTestActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblPendingLabTests.getSelectedRow();
        if (selectedRow < 0) {
            log.error("Selected row from tblPendingLabTests table is not >= 0");
            return;
        }
        
        long labTestId = (long) tblPendingLabTests.getModel().getValueAt(selectedRow, 3);
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
         nextScreen(workAreaPanel, new Login(workAreaPanel, ecoSystem), "Login");
    }//GEN-LAST:event_btnBbackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBback;
    private javax.swing.JButton btnPerformLabTest;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelLabResultsPlaceHolder1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDob1;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGenderPlaceHolder;
    private javax.swing.JLabel lblLabNamePlaceHolder;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePlaceHolder;
    private javax.swing.JLabel lblPatientDetails;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberPlaceHolder;
    private javax.swing.JTable tblCompletedLabTests;
    private javax.swing.JTable tblPendingLabTests;
    // End of variables declaration//GEN-END:variables

    private void populateLabAssistantInfoPlaceholders() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          PersonDetails pd = laboratoryAssistant.getPersonDetails();
          lblNamePlaceHolder.setText(pd.getFullName());
          lblPatientDetails.setText("Laboratory Assistant - Welcome " + pd.getFullName() + "!");
          lblPhoneNumberPlaceHolder.setText(pd.getPhoneNumber());
          Organization lab = ecoSystem.organizationDirectory.getOrganization(laboratoryAssistant.getOrganizationId());
          lblLabNamePlaceHolder.setText(lab.getName() + " at " + lab.getEnterprise().getEnterpriseName());
          lblGenderPlaceHolder.setText(pd.getGender().toString());
          imgLogo.setIcon(pd.getLogoImage());
          
        if (pd.getLogoImage() != null) {
            imgLogo.setIcon(pd.getLogoImage());
            return;
        }
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images_icons/lab-ass.png"));
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);  // transform it back]
        imgLogo.setIcon(imageIcon);
    }
}
