/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.PatientWorkAreaPanel;

import Ui.MainJFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ankur Bywar
 */
public class PatientWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientWorkAreaJPanel
     */
    public PatientWorkAreaJPanel() {
        initComponents();
    }

    public PatientWorkAreaJPanel(JPanel WorkAreaPanel, MainJFrame aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPatientPanel = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jControlPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnRecordPersonalVitals = new javax.swing.JButton();
        btnBookFamilyDoctorAppointment = new javax.swing.JButton();
        btnMyMedicinePrescription = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnViewVitalSoignHistory = new javax.swing.JButton();
        btnViewOlderAppointments = new javax.swing.JButton();
        jWorkAreaPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPatientDetailPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUpcomingAppointments = new javax.swing.JTable();
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
        lblAge = new javax.swing.JLabel();
        lblAgePlaceHolder = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        lblWeightPlaceHolder = new javax.swing.JLabel();
        lblWeight1 = new javax.swing.JLabel();
        lblWeightPlaceHolder1 = new javax.swing.JLabel();

        jButton1.setText("View Medical Lab Test");

        btnRecordPersonalVitals.setText("Record personal vitals");
        btnRecordPersonalVitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordPersonalVitalsActionPerformed(evt);
            }
        });

        btnBookFamilyDoctorAppointment.setText("Book Family Doctor Appointment");

        btnMyMedicinePrescription.setText("See My Medicine Prescription");

        btnLogout.setText("LogOut");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnViewVitalSoignHistory.setText("View Vital Sign History");
        btnViewVitalSoignHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVitalSoignHistoryActionPerformed(evt);
            }
        });

        btnViewOlderAppointments.setText("View Older Appointments");
        btnViewOlderAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOlderAppointmentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jControlPanelLayout = new javax.swing.GroupLayout(jControlPanel);
        jControlPanel.setLayout(jControlPanelLayout);
        jControlPanelLayout.setHorizontalGroup(
            jControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jControlPanelLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(btnBookFamilyDoctorAppointment))
            .addGroup(jControlPanelLayout.createSequentialGroup()
                .addGroup(jControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jControlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRecordPersonalVitals, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jControlPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnViewOlderAppointments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnMyMedicinePrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jControlPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnViewVitalSoignHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jControlPanelLayout.setVerticalGroup(
            jControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jControlPanelLayout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(btnRecordPersonalVitals)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewVitalSoignHistory)
                .addGap(19, 19, 19)
                .addComponent(btnBookFamilyDoctorAppointment)
                .addGap(18, 18, 18)
                .addComponent(btnMyMedicinePrescription)
                .addGap(12, 12, 12)
                .addComponent(btnViewOlderAppointments)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addContainerGap(551, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jControlPanel);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jPatientDetailPanel.setBackground(new java.awt.Color(204, 255, 255));
        jPatientDetailPanel.setPreferredSize(new java.awt.Dimension(1000, 1000));

        tblUpcomingAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cheif Complaint", "Doctor", "Dietician", "Gym Instructor", "Date"
            }
        ));
        jScrollPane1.setViewportView(tblUpcomingAppointments);

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
        lblPatientDetails.setText("                  Patient Profile");

        lblNamePlaceHolder.setText("NamePlaceHolder");

        lblDob1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblDob1.setText("Dob:");

        lblDobPlaceHolder.setText("DobPlaceHolder");

        lblPhoneNumberPlaceHolder.setText("Phone Number Place Holder");

        lblAddressPlaceHolder.setText("AddressPlaceHolder");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 102, 255));
        jLabel4.setText("Welcome to Fred Meyer ");

        lblAge.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblAge.setText("Age:");

        lblAgePlaceHolder.setText("AgeHolder");

        lblWeight.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblWeight.setText("Weight:");

        lblWeightPlaceHolder.setText("WeightPlaceHolder");

        lblWeight1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblWeight1.setText("EmailId:");

        lblWeightPlaceHolder1.setText("EmailIdPlaceHolder");

        javax.swing.GroupLayout jPatientDetailPanelLayout = new javax.swing.GroupLayout(jPatientDetailPanel);
        jPatientDetailPanel.setLayout(jPatientDetailPanelLayout);
        jPatientDetailPanelLayout.setHorizontalGroup(
            jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(lblName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNamePlaceHolder))
                                    .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                            .addComponent(lblAddress)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblAddressPlaceHolder))
                                        .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                            .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblAge)
                                                .addComponent(lblWeight))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblWeightPlaceHolder)
                                                .addComponent(lblAgePlaceHolder)))
                                        .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                            .addComponent(lblWeight1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lblWeightPlaceHolder1)))))
                            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPatientDetailPanelLayout.setVerticalGroup(
            jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPatientDetailPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(lblPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(lblNamePlaceHolder))
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
                        .addGap(78, 78, 78)
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(lblAgePlaceHolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight)
                    .addComponent(lblWeightPlaceHolder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPatientDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight1)
                    .addComponent(lblWeightPlaceHolder1))
                .addGap(226, 226, 226)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPatientDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPatientDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jWorkAreaPanelLayout = new javax.swing.GroupLayout(jWorkAreaPanel);
        jWorkAreaPanel.setLayout(jWorkAreaPanelLayout);
        jWorkAreaPanelLayout.setHorizontalGroup(
            jWorkAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jWorkAreaPanelLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jWorkAreaPanelLayout.setVerticalGroup(
            jWorkAreaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jWorkAreaPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jWorkAreaPanel);

        javax.swing.GroupLayout jPatientPanelLayout = new javax.swing.GroupLayout(jPatientPanel);
        jPatientPanel.setLayout(jPatientPanelLayout);
        jPatientPanelLayout.setHorizontalGroup(
            jPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPatientPanelLayout.createSequentialGroup()
                .addGap(0, 341, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPatientPanelLayout.setVerticalGroup(
            jPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPatientPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPatientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPatientPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecordPersonalVitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordPersonalVitalsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecordPersonalVitalsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnViewVitalSoignHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVitalSoignHistoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewVitalSoignHistoryActionPerformed

    private void btnViewOlderAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOlderAppointmentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewOlderAppointmentsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookFamilyDoctorAppointment;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyMedicinePrescription;
    private javax.swing.JButton btnRecordPersonalVitals;
    private javax.swing.JButton btnViewOlderAppointments;
    private javax.swing.JButton btnViewVitalSoignHistory;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jControlPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPatientDetailPanel;
    private javax.swing.JPanel jPatientPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel jWorkAreaPanel;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressPlaceHolder;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAgePlaceHolder;
    private javax.swing.JLabel lblDob1;
    private javax.swing.JLabel lblDobPlaceHolder;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePlaceHolder;
    private javax.swing.JLabel lblPatientDetails;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberPlaceHolder;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel lblWeight1;
    private javax.swing.JLabel lblWeightPlaceHolder;
    private javax.swing.JLabel lblWeightPlaceHolder1;
    private javax.swing.JTable tblUpcomingAppointments;
    // End of variables declaration//GEN-END:variables
}
