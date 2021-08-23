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
    boolean disableAddReview;
    /**
    /**
     * Creates new form ViewOlderAppointmentsJPanel
     */
    public PatientAppointmentHistoyJPanel(JPanel workAreaPanel, EcoSystem ecoSystem, Patient patient, JPanel backButtonPage) {
        initComponents();
        this.setSize(1100,850);
        this.ecoSystem = ecoSystem;
        this.patient = patient;
        this.workAreaPanel = workAreaPanel;
        this.backButtonPage = backButtonPage;
        this.selectedAppointment = null;
        btnViewLabReports.setEnabled(false);
        btnAddReview.setEnabled(false);
        populatePatientAppointmentHistoryTable();
        this.disableAddReview = true;
        if (disableAddReview) {
            btnAddReview.setVisible(false);
        }
    }
    
    public PatientAppointmentHistoyJPanel(JPanel workAreaPanel, EcoSystem ecoSystem, Patient patient, JPanel backButtonPage, boolean disableAddReview) {
        initComponents();
        this.setSize(1100,850);
        this.ecoSystem = ecoSystem;
        this.patient = patient;
        this.workAreaPanel = workAreaPanel;
        this.backButtonPage = backButtonPage;
        this.selectedAppointment = null;
        btnViewLabReports.setEnabled(false);
        btnAddReview.setEnabled(false);
        populatePatientAppointmentHistoryTable();
        this.disableAddReview = disableAddReview;
        if (disableAddReview) {
            btnAddReview.setVisible(false);
        }
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
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("Patient Primary Care Appointment and Lab tests History");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 29, 740, 46));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 87, 792, 145));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, -1, -1));

        lblName4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName4.setText("Appointment Date");
        jPanel1.add(lblName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 306, -1, -1));

        lbllastAptDatePlaceHolder.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbllastAptDatePlaceHolder.setText("Not Available");
        jPanel1.add(lbllastAptDatePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 304, -1, 25));

        lblName5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName5.setText("Chief complain");
        jPanel1.add(lblName5, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 343, -1, -1));

        lblLastAptChiefComplain.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblLastAptChiefComplain.setText("Not Available");
        jPanel1.add(lblLastAptChiefComplain, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 341, -1, 25));

        lblName6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName6.setText("Doctor's Feedback");
        jPanel1.add(lblName6, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 380, -1, -1));

        lblLastAptDocsFeedback.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblLastAptDocsFeedback.setText("Not Available");
        jPanel1.add(lblLastAptDocsFeedback, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 378, -1, 25));

        btnMoreAppointmentDetails1.setBackground(new java.awt.Color(255, 255, 255));
        btnMoreAppointmentDetails1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnMoreAppointmentDetails1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-more-30.png"))); // NOI18N
        btnMoreAppointmentDetails1.setText("More Details");
        btnMoreAppointmentDetails1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoreAppointmentDetails1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnMoreAppointmentDetails1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 244, -1, -1));

        btnViewLabReports.setBackground(new java.awt.Color(255, 255, 255));
        btnViewLabReports.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnViewLabReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/view_past_appointment.png"))); // NOI18N
        btnViewLabReports.setText("View Lab Report");
        btnViewLabReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLabReportsActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewLabReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 431, -1, -1));

        btnAddReview.setBackground(new java.awt.Color(255, 255, 255));
        btnAddReview.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAddReview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/review.png"))); // NOI18N
        btnAddReview.setText("Provide Review ");
        btnAddReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReviewActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 431, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 850));

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
                
        nextScreen(workAreaPanel, backButtonPage, "backButtonPage");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMoreAppointmentDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoreAppointmentDetails1ActionPerformed
        // TODO add your handling code here
        
        int selectedRow = tblPatientAppointmentHistory.getSelectedRow();
        if (selectedRow < 0) {
            log.error("Selected row from past appointments table is not >= 0");
            return;
        }
        
        long appointmentId = (long) tblPatientAppointmentHistory.getModel().getValueAt(selectedRow, 0);
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
        
        if (disableAddReview) {
            btnAddReview.setVisible(false);
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
    private javax.swing.JLabel jLabel2;
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
