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
import Personnel.PersonDetails;
import SysAdminUI.Login;
import Utils.ConsoleLogger;
import Utils.NextScreen;
import Utils.ViewPersonRatingsJPanel;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ankur Bywar
 */
public class DoctorWorkAreaPanel extends javax.swing.JPanel implements NextScreen{
    JPanel WorkAreaPanel;
    Doctor doctor;
    JFrame mainJFrame;
    EcoSystem ecoSystem;
    Enterprise hospital;
    ConsoleLogger log = ConsoleLogger.getLogger();
    /**
     * Creates new form DoctorWorkAreaPanel
     */
    public DoctorWorkAreaPanel(JPanel WorkAreaPanel, EcoSystem ecoSystem, Enterprise hospital, Doctor doctor) {
        initComponents();
        this.WorkAreaPanel = WorkAreaPanel;
        this.doctor = doctor;
        this.ecoSystem =ecoSystem;
        this.hospital = hospital;
        populateUpcomingAppointments();
        populateDoctorInfoPlaceholders();
        populateCompletedAppointments(null);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompletedPatientAppointments = new javax.swing.JTable();
        lblAddress = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        lblPatientDetails = new javax.swing.JLabel();
        lblNamePlaceHolder = new javax.swing.JLabel();
        lblDob1 = new javax.swing.JLabel();
        lblDobPlaceHolder = new javax.swing.JLabel();
        lblPhoneNumberPlaceHolder = new javax.swing.JLabel();
        lblAddressPlaceHolder = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblSearchByDate = new javax.swing.JLabel();
        txtPatientUserNameSearch = new javax.swing.JTextField();
        jUserNameSearchBtn = new javax.swing.JButton();
        btnOldAppointmentDetails = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNewAppointmentDetails2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUpcomingPatientAppointments = new javax.swing.JTable();
        btnViewRatings = new javax.swing.JButton();

        jPatientDetailPanel.setBackground(new java.awt.Color(204, 255, 255));
        jPatientDetailPanel.setPreferredSize(new java.awt.Dimension(1000, 1000));

        tblCompletedPatientAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Appointment id", "Patient Name", "Doctor Name", "Appointment Date", "Appointment Status"
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
        jScrollPane1.setViewportView(tblCompletedPatientAppointments);

        lblAddress.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblAddress.setText("Address:");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Upcoming Appointments");

        lblPhoneNumber.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPhoneNumber.setText("Phone Number:");

        lblName.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblName.setText("Name:");

        imgLogo.setText("<<No Image>>");

        lblPatientDetails.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblPatientDetails.setText("                  Doctor Profile");

        lblNamePlaceHolder.setText("NamePlaceHolder");

        lblDob1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblDob1.setText("Dob:");

        lblDobPlaceHolder.setText("DobPlaceHolder");

        lblPhoneNumberPlaceHolder.setText("Phone Number Place Holder");

        lblAddressPlaceHolder.setText("AddressPlaceHolder");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("Welcome to Fred Meyer ");

        lblSearchByDate.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblSearchByDate.setText("Filter by patient id");

        txtPatientUserNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientUserNameSearchActionPerformed(evt);
            }
        });

        jUserNameSearchBtn.setText("Search");
        jUserNameSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserNameSearchBtnActionPerformed(evt);
            }
        });

        btnOldAppointmentDetails.setText("More details");
        btnOldAppointmentDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOldAppointmentDetailsActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNewAppointmentDetails2.setText("Appointment Details");
        btnNewAppointmentDetails2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewAppointmentDetails2ActionPerformed(evt);
            }
        });

        tblUpcomingPatientAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Appointment id", "Patient Name", "Doctor Name", "Appointment Date"
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
        jScrollPane3.setViewportView(tblUpcomingPatientAppointments);

        btnViewRatings.setText("View my Ratings");
        btnViewRatings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRatingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPatientDetailPanelLayout = new javax.swing.GroupLayout(jPatientDetailPanel);
        jPatientDetailPanel.setLayout(jPatientDetailPanelLayout);
        jPatientDetailPanelLayout.setHorizontalGroup(
            jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                .addComponent(lblDob1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDobPlaceHolder))
                            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                .addComponent(lblPhoneNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPhoneNumberPlaceHolder))
                            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                .addComponent(lblAddress)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAddressPlaceHolder))
                            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNamePlaceHolder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                                .addComponent(btnViewRatings, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(btnOldAppointmentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnNewAppointmentDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                    .addComponent(lblSearchByDate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPatientUserNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jUserNameSearchBtn)))))
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPatientDetailPanelLayout.setVerticalGroup(
            jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblName)
                                    .addComponent(lblNamePlaceHolder)))
                            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnViewRatings, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDob1)
                            .addComponent(lblDobPlaceHolder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoneNumber)
                            .addComponent(lblPhoneNumberPlaceHolder))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(lblAddressPlaceHolder)))
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewAppointmentDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jUserNameSearchBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPatientUserNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSearchByDate)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOldAppointmentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPatientDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPatientDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 887, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPatientUserNameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientUserNameSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientUserNameSearchActionPerformed

    private void jUserNameSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserNameSearchBtnActionPerformed
        // TODO add your handling code here:

        String patientUserName = txtPatientUserNameSearch.getText();
        if (patientUserName == null || patientUserName.isBlank()) {
            JOptionPane.showMessageDialog(null,"Please enter a valid username", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        populateCompletedAppointments(patientUserName);
    }//GEN-LAST:event_jUserNameSearchBtnActionPerformed

    private void btnOldAppointmentDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOldAppointmentDetailsActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblCompletedPatientAppointments.getSelectedRow();
        if (selectedRow < 0) {
            log.error("Selected row from tblDoctorList is not >= 0");
            return;
        }

        int appointmentId = (int) tblCompletedPatientAppointments.getModel().getValueAt(selectedRow, 0);
        Appointment selectedAppointment = null;
        for (Appointment apt : doctor.getPatientAppointments()) {
            if (apt.getId() == appointmentId) {
                selectedAppointment = apt;
                break;
            }
        }

        if (selectedAppointment == null) {
            log.error("No patient appointment found for id " + appointmentId);
            return;
        } 

        nextScreen(WorkAreaPanel, new PatientAppointmentDetailsPanel(WorkAreaPanel, ecoSystem, hospital, selectedAppointment, this), "PatientAppointmentDetailsPanel");
    }//GEN-LAST:event_btnOldAppointmentDetailsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        nextScreen(WorkAreaPanel, new Login(WorkAreaPanel, ecoSystem), "Login Page");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNewAppointmentDetails2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewAppointmentDetails2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblUpcomingPatientAppointments.getSelectedRow();
        if (selectedRow < 0) {
            log.error("Selected row from tblDoctorList is not >= 0");
            return;
        }

        int appointmentId = (int) tblUpcomingPatientAppointments.getModel().getValueAt(selectedRow, 0);
        Appointment selectedAppointment = null;
        for (Appointment apt : doctor.getPatientAppointments()) {
            if (apt.getId() == appointmentId) {
                selectedAppointment = apt;
                break;
            }
        }

        if (selectedAppointment == null) {
            log.error("No patient appointment found for id " + appointmentId);
            return;
        }

        nextScreen(WorkAreaPanel, new PatientAppointmentDetailsPanel(WorkAreaPanel, ecoSystem, hospital, selectedAppointment, this), "PatientAppointmentDetailsPanel");
    }//GEN-LAST:event_btnNewAppointmentDetails2ActionPerformed

    private void btnViewRatingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRatingsActionPerformed
        // TODO add your handling code here:
        nextScreen(WorkAreaPanel, new ViewPersonRatingsJPanel(WorkAreaPanel, doctor, this), "ViewPersonRatingsJPanel");
    }//GEN-LAST:event_btnViewRatingsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNewAppointmentDetails2;
    private javax.swing.JButton btnOldAppointmentDetails;
    private javax.swing.JButton btnViewRatings;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPatientDetailPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jUserNameSearchBtn;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressPlaceHolder;
    private javax.swing.JLabel lblDob1;
    private javax.swing.JLabel lblDobPlaceHolder;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePlaceHolder;
    private javax.swing.JLabel lblPatientDetails;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberPlaceHolder;
    private javax.swing.JLabel lblSearchByDate;
    private javax.swing.JTable tblCompletedPatientAppointments;
    private javax.swing.JTable tblUpcomingPatientAppointments;
    private javax.swing.JTextField txtPatientUserNameSearch;
    // End of variables declaration//GEN-END:variables

    private void populateUpcomingAppointments() {
            
        DefaultTableModel  model = (DefaultTableModel) tblUpcomingPatientAppointments.getModel();
        model.setRowCount(0);
        
        List<Appointment> upComingAppointments = doctor.getPatientAppointments();
        // Sort upComingAppointments based on date
        Collections.sort(upComingAppointments);
        
       // model.setRowCount(0);
        if ((upComingAppointments == null) || upComingAppointments.isEmpty()) {
          log.debug("No appointments found for doctor : " + doctor.getPersonDetails().getUserAccount().getUsername());
          return; 
       }
        for (Appointment appointment : upComingAppointments) {
            
            if (!appointment.getStatus().equals(Appointment.AppointmentStatus.PENDING)) {
                continue;
            }
            
            Object row[] = new Object[4];
            row[0] = appointment.getId();
            row[1] = appointment.getPatient().getPersonDetails().getFullName();
            row[2] = appointment.getDoctor().getPersonDetails().getFullName();
            row[3] = appointment.getDate() + " " + appointment.getAppointmentTimeHours() + ":00 hrs";
            model.addRow(row);
        }
        
    }

    private void populateDoctorInfoPlaceholders() {
        PersonDetails pd = doctor.getPersonDetails();
        lblAddressPlaceHolder.setText(pd.getAddress().toString()); 
        //lblAgePlaceHolder.setText(pd.getAge() + " years");  
         lblDobPlaceHolder.setText(pd.getDob().toString());
       
        lblNamePlaceHolder.setText(pd.getFullName()); 
        lblPhoneNumberPlaceHolder.setText(pd.getPhoneNumber());
        imgLogo.setIcon(pd.getLogoImage());
       
    }

    private void populateCompletedAppointments(String patientUserNameFilter) {
       DefaultTableModel  model = (DefaultTableModel) tblCompletedPatientAppointments.getModel();
        model.setRowCount(0);
        
        List<Appointment> upComingAppointments = doctor.getPatientAppointments();
        // Sort upComingAppointments based on date
        Collections.sort(upComingAppointments);
        
       // model.setRowCount(0);
        if ((upComingAppointments == null) || upComingAppointments.isEmpty()) {
          log.debug("No appointments found for doctor : " + doctor.getPersonDetails().getUserAccount().getUsername());
          return; 
       }
        for (Appointment appointment : upComingAppointments) {
            if (!appointment.getStatus().equals(Appointment.AppointmentStatus.COMPLETED)) {
                continue;
            }
            
            if (patientUserNameFilter != null && !appointment.getPatient().getUserAccount().getUsername().equals(patientUserNameFilter)) {
                continue;
            }
            
            Object row[] = new Object[5];
            row[0] = appointment.getId();
            row[1] = appointment.getPatient().getPersonDetails().getFullName();
            row[2] = appointment.getDoctor().getPersonDetails().getFullName();
            row[3] = appointment.getDate() + " " + appointment.getAppointmentTimeHours() + ":00 hrs";
            row[4] = appointment.getStatus().toString();
            model.addRow(row);
        }
    }
    void reload() {
        populateUpcomingAppointments();
        populateCompletedAppointments(null);
    }
    
   
}