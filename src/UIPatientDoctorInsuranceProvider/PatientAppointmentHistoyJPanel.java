/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import DataStore.Appointment;
import EcoSystem.EcoSystem;
import Patient.Patient;
import Utils.ConsoleLogger;
import Utils.NextScreen;
import Utils.Rating;
import Utils.StarRatingsUtil;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ankur Bywar
 */
public class PatientAppointmentHistoyJPanel extends javax.swing.JPanel implements NextScreen {
    JPanel workAreaPanel;
    Patient patient;
    JFrame mainJFrame;
    EcoSystem ecoSystem;
    JPanel backButtonPage;
    
    Appointment selectedAppointment;
    
    ConsoleLogger log = ConsoleLogger.getLogger();
    /**
    /**
     * Creates new form ViewOlderAppointmentsJPanel
     */
    public PatientAppointmentHistoyJPanel(JPanel workAreaPanel, EcoSystem ecoSystem, Patient patient, JPanel backButtonPage) {
        initComponents();
        this.ecoSystem = ecoSystem;
        this.patient = patient;
        this.workAreaPanel = workAreaPanel;
        this.backButtonPage = backButtonPage;
        this.selectedAppointment = null;
        btnViewLabReports.setEnabled(false);
        btnAddReview.setEnabled(false);
        populatePatientAppointmentHistoryTable();
    }
    
    void populatePatientAppointmentHistoryTable() {
        
                
        DefaultTableModel  model = (DefaultTableModel) tblPatientAppointmentHistory.getModel();
        model.setRowCount(0);
        
        List<Appointment> pastAppointments = patient.getDoctorAppointmentsHistory();
        // Sort upComingAppointments based on date
        Collections.sort(pastAppointments);
        
       // model.setRowCount(0);
        if ((pastAppointments == null) || pastAppointments.isEmpty()) {
          log.debug("No past appointments found for patient : " + patient.getPersonDetails().getUserAccount().getUsername());
          return; 
       }
        for (Appointment appointment : pastAppointments) {
            Object row[] = new Object[5];
            row[0] = appointment.getId();
            row[1] = appointment.getPatient().getPersonDetails().getFullName();
            row[2] = appointment.getDoctor().getPersonDetails().getFullName();
            row[3] = appointment.getDate();
            row[4] = appointment.getLabTestReport() == null ? "N/A" : appointment.getLabTestReport().getId();
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

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatientAppointmentHistory = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblName4 = new javax.swing.JLabel();
        lbllastAptDatePlaceHolder = new javax.swing.JLabel();
        lblName5 = new javax.swing.JLabel();
        lblLastAptChiefComplain = new javax.swing.JLabel();
        lblName6 = new javax.swing.JLabel();
        lblLastAptDocsFeedback = new javax.swing.JLabel();
        btnMoreAppointmentDetails1 = new javax.swing.JButton();
        btnViewLabReports = new javax.swing.JButton();
        btnAddReview = new javax.swing.JButton();

        jLabel1.setText("Patient Appointment and Lab tests History");

        tblPatientAppointmentHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Appointment id", "Patient Name", "Doctor Name", "Appointment Date", "Lab test Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPatientAppointmentHistory);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblName4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblName4.setText("Appointment Date");

        lbllastAptDatePlaceHolder.setText("Not Available");

        lblName5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblName5.setText("Chief complain");

        lblLastAptChiefComplain.setText("Not Available");

        lblName6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblName6.setText("Doctor's Feedback:");

        lblLastAptDocsFeedback.setText("Not Available");

        btnMoreAppointmentDetails1.setText("More Details");
        btnMoreAppointmentDetails1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreAppointmentDetails1ActionPerformed(evt);
            }
        });

        btnViewLabReports.setText("View this appointment's lab reports");
        btnViewLabReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLabReportsActionPerformed(evt);
            }
        });

        btnAddReview.setText("Provide review for this appointment");
        btnAddReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReviewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblName4)
                                .addGap(18, 18, 18)
                                .addComponent(lbllastAptDatePlaceHolder))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblName5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblLastAptChiefComplain))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblName6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblLastAptDocsFeedback))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnViewLabReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddReview, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(259, 259, 259)
                    .addComponent(btnMoreAppointmentDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(279, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName4)
                    .addComponent(lbllastAptDatePlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName5)
                    .addComponent(lblLastAptChiefComplain, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName6)
                    .addComponent(lblLastAptDocsFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnViewLabReports)
                .addGap(27, 27, 27)
                .addComponent(btnAddReview)
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(241, 241, 241)
                    .addComponent(btnMoreAppointmentDetails1)
                    .addContainerGap(396, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
                
        nextScreen(workAreaPanel, backButtonPage, "backButtonPage");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMoreAppointmentDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreAppointmentDetails1ActionPerformed
        // TODO add your handling code here
        
        int selectedRow = tblPatientAppointmentHistory.getSelectedRow();
        if (selectedRow < 0) {
            log.error("Selected row from past appointments table is not >= 0");
            return;
        }
        
        int appointmentId = (int) tblPatientAppointmentHistory.getModel().getValueAt(selectedRow, 0);
        Appointment selectedAppointment = null;
        for (Appointment apt : patient.getDoctorAppointmentsHistory()) {
            if (apt.getId() == appointmentId) {
                selectedAppointment = apt;
                break;
            }
        }
        
        if (selectedAppointment == null) {
            log.error("No appointment found for " + this.patient.getPersonDetails().getFullName() + " with id " + appointmentId);
            return;
        }
        
        this.selectedAppointment = selectedAppointment;
        btnViewLabReports.setEnabled(true);
        lbllastAptDatePlaceHolder.setText(selectedAppointment.getDate() + " at " + selectedAppointment.getAppointmentTimeHours() + ":00");
        lblLastAptChiefComplain.setText(selectedAppointment.getCheifComplain());
        lblLastAptDocsFeedback.setText(selectedAppointment.getDoctorFeedback() == null || selectedAppointment.getDoctorFeedback().isEmpty() 
                ? "Not Available" 
                : selectedAppointment.getDoctorFeedback());
        
        if (selectedAppointment.getRating() == null) {
            btnAddReview.setEnabled(true);
        } else {
            if (selectedAppointment.getRating().getStatus() == Rating.RatingStatus.RATING_NOT_PROVIDED) {
                btnAddReview.setEnabled(true);
            } else {
                btnAddReview.setEnabled(true);
                btnAddReview.setText(selectedAppointment.getRating().getRating() + " star rating already provided");
                btnAddReview.setEnabled(false);
            }
        }
        // Add lab test reports details
        // Add VS at that time (may be??)
    }//GEN-LAST:event_btnMoreAppointmentDetails1ActionPerformed

    private void btnViewLabReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLabReportsActionPerformed
        // TODO add your handling code here:
        nextScreen(workAreaPanel, new PatientLabTestViewJPanel(workAreaPanel, selectedAppointment.getLabTestReport(), this), "PatientLabTestViewJPanel");
    }//GEN-LAST:event_btnViewLabReportsActionPerformed

    private void btnAddReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReviewActionPerformed
        // TODO add your handling code here:
        StarRatingsUtil starRatingsUtil = new StarRatingsUtil();
        Rating rating = new Rating();
        selectedAppointment.setRating(rating);
        starRatingsUtil.openRatingsJPanel("Provide Review for Primary Care Provider", selectedAppointment.getDoctor(), rating, LocalDate.now());        
    }//GEN-LAST:event_btnAddReviewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddReview;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMoreAppointmentDetails1;
    private javax.swing.JButton btnViewLabReports;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLastAptChiefComplain;
    private javax.swing.JLabel lblLastAptDocsFeedback;
    private javax.swing.JLabel lblName4;
    private javax.swing.JLabel lblName5;
    private javax.swing.JLabel lblName6;
    private javax.swing.JLabel lbllastAptDatePlaceHolder;
    private javax.swing.JTable tblPatientAppointmentHistory;
    // End of variables declaration//GEN-END:variables
}