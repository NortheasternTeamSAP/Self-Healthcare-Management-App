/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import Counselor.CounselorAppointment;
import DataStore.Appointment;
import Dietitian.DietitianAppointment;
import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import FitnessTrainer.FitnessTrainerAppointment;
import Laboratory.LaboratoryAssistant;
import Patient.Patient;
import Personnel.PersonDetails;
import Prescription.Prescription;
import SysAdminUI.Login;
import Utils.ConsoleLogger;
import Utils.FieldsDecorator;
import Utils.NextScreen;
import Utils.Rating;
import Utils.StarRatingsUtil;
import Utils.ViewPersonRatingsJPanel;
import VitalSign.VitalSigns;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import static java.time.Clock.system;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ankur Bywar
 */
public class PatientHomePagePanel extends javax.swing.JPanel implements NextScreen {
    JPanel WorkAreaPanel;
    Patient patient;
    EcoSystem ecoSystem;
    
    ConsoleLogger log = ConsoleLogger.getLogger();
    /**
     * Creates new form PatientWorkAreaJPanel
     */
    public PatientHomePagePanel(JPanel WorkAreaPanel, EcoSystem ecoSystem, Patient patient) {
        initComponents();
        this.setSize(1100,850);
        this.WorkAreaPanel = WorkAreaPanel;
        this.patient = patient;
        this.ecoSystem = ecoSystem;
        
        List<UIAppointmentEntry> allUpcomingAppointments = new ArrayList<>();
        populateUpcomingDoctorAppointments(allUpcomingAppointments);
        populateUpcomingDietitianAppointments(allUpcomingAppointments);
        populateUpcomingFitnessAppointments(allUpcomingAppointments);
        populateUpcomingCounsellerAppointments(allUpcomingAppointments);
        
        populatePatientInfoPlaceholders();
        populateUpcomingAppointmentsTable(allUpcomingAppointments);
        setUpDeliveryManReviewButton();
        updateDailyRemienders();
        
        FieldsDecorator.decorateTable(tblAllUpcomingAppointments);

    }
    
    public void updateDailyRemienders() {
        VitalSigns vitals = patient.getMostRecentVitalSigns();
        String mostRecentVitalsDate = vitals == null ? "You did not record you vitals yet." : "Last vitals recorded on " + vitals.getDateForVitalSigns();
        jLabelRemienderToCheckVitals.setText("Do not forget to check your vitals regularly. " + mostRecentVitalsDate);
    }
    
    void populateUpcomingAppointmentsTable(List<UIAppointmentEntry> allUpcomingAppointments) {
        DefaultTableModel  model = (DefaultTableModel) tblAllUpcomingAppointments.getModel();
        model.setRowCount(0);
        
        if (allUpcomingAppointments == null || allUpcomingAppointments.isEmpty()) {
            log.debug("No upcoming appointments found for patient : " + patient.getPersonDetails().getUserAccount().getUsername());
            return; 
        }

        Collections.sort(allUpcomingAppointments, new Comparator<UIAppointmentEntry>() {
            @Override
            public int compare(UIAppointmentEntry o1, UIAppointmentEntry o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
            
        });
        
        for (UIAppointmentEntry appointment : allUpcomingAppointments) {
            Object row[] = new Object[4];
            row[0] = appointment.getPatientName();
            row[1] = appointment.getAppointmentWith();
            row[2] = appointment.getRoleType(); 
            row[3] = appointment.getDate() + " " + appointment.getHours()+ ":00 hrs";
            model.addRow(row);
        }
        
    }
    
    void populateUpcomingDoctorAppointments(List<UIAppointmentEntry> allUpcomingAppointments) {
         List<Appointment> upComingAppointments = patient.getUpcomingDoctorAppointments();
         for (Appointment appointment : upComingAppointments) {
             allUpcomingAppointments.add(new UIAppointmentEntry(
                     appointment.getPatient().getPersonDetails().getFullName(),
                     appointment.getDoctor().getPersonDetails().getFullName(),
                     "Primary Care (Doctor)",
                     appointment.getDate(),
                     appointment.getAppointmentTimeHours()));
         }
    }
    
    void populateUpcomingDietitianAppointments(List<UIAppointmentEntry> allUpcomingAppointments) {
         List<DietitianAppointment> upComingAppointments = patient.getDietitianAppointments();
         for (DietitianAppointment appointment : upComingAppointments) {
             if (appointment.getDone() == true) {
                 continue;
             }
             allUpcomingAppointments.add(new UIAppointmentEntry(
                     appointment.getPatient().getPersonDetails().getFullName(),
                     appointment.getDietitian().getPersonDetails().getFullName(),
                     "Dietitian",
                     appointment.getDate(),
                     appointment.getTime()));
         }
    }
    
    void populateUpcomingFitnessAppointments(List<UIAppointmentEntry> allUpcomingAppointments) {
         List<FitnessTrainerAppointment> upComingAppointments = patient.getFitnessTrainerAppointments();
         for (FitnessTrainerAppointment appointment : upComingAppointments) {
             if (appointment.getDone() == true) {
                 continue;
             }
             allUpcomingAppointments.add(new UIAppointmentEntry(
                     appointment.getPatient().getPersonDetails().getFullName(),
                     appointment.getFitnessTrainer().getPersonDetails().getFullName(),
                     "Fitness Trainer",
                     appointment.getDate(),
                     appointment.getTime()));
         }
    }
    
    void populateUpcomingCounsellerAppointments(List<UIAppointmentEntry> allUpcomingAppointments) {
         List<CounselorAppointment> upComingAppointments = patient.getCounselorAppointments();
         for (CounselorAppointment appointment : upComingAppointments) {
             if (appointment.getDone() == true) {
                 continue;
             }
             allUpcomingAppointments.add(new UIAppointmentEntry(
                     appointment.getPatient().getPersonDetails().getFullName(),
                     appointment.getCounselor().getPersonDetails().getFullName(),
                     "Mental Health Counselor",
                     appointment.getDate(),
                     appointment.getTime()));
         }
    }
    
    void populatePatientInfoPlaceholders() {
        PersonDetails pd = patient.getPersonDetails();
        lblAddressPlaceHolder.setText(pd.getAddress().toString());   
         lblAgePlaceHolder.setText(pd.getDob().toString());
        lblEmailPlaceHolder.setText(patient.getPatientDetails().getEmailId());  
        lblNamePlaceHolder.setText(pd.getFullName()); 
        lblPhoneNumberPlaceHolder.setText(pd.getPhoneNumber());
        
        if (pd.getLogoImage() != null) {
            imgLogo.setIcon(pd.getLogoImage());
            return;
        }
        
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images_icons/patient-icon.png"));
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);  // transform it back]
        imgLogo.setIcon(imageIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPatientPanel = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jControlPanel = new javax.swing.JPanel();
        btnRecordPersonalVitals = new javax.swing.JButton();
        btnBookFamilyDoctorAppointment = new javax.swing.JButton();
        btnMyMedicinePrescription = new javax.swing.JButton();
        btnViewVitalSoignHistory = new javax.swing.JButton();
        btnViewOlderAppointments = new javax.swing.JButton();
        btnLogout1 = new javax.swing.JButton();
        btnDietitianSession = new javax.swing.JButton();
        btnCouncellorSession = new javax.swing.JButton();
        btnFitnessInstructor = new javax.swing.JButton();
        jButtonUpdatePatientInsurance = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jWorkAreaPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPatientDetailPanel = new javax.swing.JPanel();
        lblAddress = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        lblPatientDetails = new javax.swing.JLabel();
        lblNamePlaceHolder = new javax.swing.JLabel();
        lblPhoneNumberPlaceHolder = new javax.swing.JLabel();
        lblAddressPlaceHolder = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblAgePlaceHolder = new javax.swing.JLabel();
        lblWeight1 = new javax.swing.JLabel();
        lblEmailPlaceHolder = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAllUpcomingAppointments = new javax.swing.JTable();
        jLabelRemienderToTakeMeds = new javax.swing.JLabel();
        jLabelRemienderToCheckVitals = new javax.swing.JLabel();
        jLabelRemienderToFollowDiet = new javax.swing.JLabel();
        jLabelRemienderToExercise = new javax.swing.JLabel();
        jButtonDeliveryBoyReview = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jControlPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnRecordPersonalVitals.setBackground(new java.awt.Color(255, 255, 255));
        btnRecordPersonalVitals.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnRecordPersonalVitals.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/health.png"))); // NOI18N
        btnRecordPersonalVitals.setText("Record Personal Vitals");
        btnRecordPersonalVitals.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRecordPersonalVitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordPersonalVitalsActionPerformed(evt);
            }
        });

        btnBookFamilyDoctorAppointment.setBackground(new java.awt.Color(255, 255, 255));
        btnBookFamilyDoctorAppointment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBookFamilyDoctorAppointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-hospital-sign-30.png"))); // NOI18N
        btnBookFamilyDoctorAppointment.setText("Primary Care Visit");
        btnBookFamilyDoctorAppointment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBookFamilyDoctorAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookFamilyDoctorAppointmentActionPerformed(evt);
            }
        });

        btnMyMedicinePrescription.setBackground(new java.awt.Color(255, 255, 255));
        btnMyMedicinePrescription.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnMyMedicinePrescription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/medication.png"))); // NOI18N
        btnMyMedicinePrescription.setText("View Medical Prescription");
        btnMyMedicinePrescription.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMyMedicinePrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyMedicinePrescriptionActionPerformed(evt);
            }
        });

        btnViewVitalSoignHistory.setBackground(new java.awt.Color(255, 255, 255));
        btnViewVitalSoignHistory.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnViewVitalSoignHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-order-history-30.png"))); // NOI18N
        btnViewVitalSoignHistory.setText("View Vital Sign History");
        btnViewVitalSoignHistory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnViewVitalSoignHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVitalSoignHistoryActionPerformed(evt);
            }
        });

        btnViewOlderAppointments.setBackground(new java.awt.Color(255, 255, 255));
        btnViewOlderAppointments.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnViewOlderAppointments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/calendar.png"))); // NOI18N
        btnViewOlderAppointments.setText("Previous Primary Care Visits");
        btnViewOlderAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOlderAppointmentsActionPerformed(evt);
            }
        });

        btnLogout1.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnLogout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/logout.png"))); // NOI18N
        btnLogout1.setText("LogOut");
        btnLogout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout1ActionPerformed(evt);
            }
        });

        btnDietitianSession.setBackground(new java.awt.Color(255, 255, 255));
        btnDietitianSession.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnDietitianSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-bitten-apple-30.png"))); // NOI18N
        btnDietitianSession.setText("Dietitian Session");
        btnDietitianSession.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDietitianSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDietitianSessionActionPerformed(evt);
            }
        });

        btnCouncellorSession.setBackground(new java.awt.Color(255, 255, 255));
        btnCouncellorSession.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnCouncellorSession.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-consultation-30.png"))); // NOI18N
        btnCouncellorSession.setText("Counseller Visit");
        btnCouncellorSession.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCouncellorSession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCouncellorSessionActionPerformed(evt);
            }
        });

        btnFitnessInstructor.setBackground(new java.awt.Color(255, 255, 255));
        btnFitnessInstructor.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnFitnessInstructor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-weightlifting-30.png"))); // NOI18N
        btnFitnessInstructor.setText("Fitness Instructor Session");
        btnFitnessInstructor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFitnessInstructorActionPerformed(evt);
            }
        });

        jButtonUpdatePatientInsurance.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUpdatePatientInsurance.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jButtonUpdatePatientInsurance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-money-bag-30.png"))); // NOI18N
        jButtonUpdatePatientInsurance.setText("Update Insurance Details");
        jButtonUpdatePatientInsurance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonUpdatePatientInsurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdatePatientInsuranceActionPerformed(evt);
            }
        });

        jSeparator1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 255));
        jLabel2.setText("Book appointments");

        jSeparator2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 204, 255));
        jLabel3.setText("More Details");

        jSeparator3.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 204, 255));
        jLabel5.setText("Categories");

        javax.swing.GroupLayout jControlPanelLayout = new javax.swing.GroupLayout(jControlPanel);
        jControlPanel.setLayout(jControlPanelLayout);
        jControlPanelLayout.setHorizontalGroup(
            jControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jControlPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jControlPanelLayout.createSequentialGroup()
                        .addComponent(jButtonUpdatePatientInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jControlPanelLayout.createSequentialGroup()
                        .addGroup(jControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRecordPersonalVitals, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogout1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewOlderAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMyMedicinePrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewVitalSoignHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCouncellorSession, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFitnessInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDietitianSession, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBookFamilyDoctorAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jControlPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jControlPanelLayout.createSequentialGroup()
                .addGroup(jControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jControlPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jControlPanelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2))
                    .addGroup(jControlPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jControlPanelLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3))
                    .addGroup(jControlPanelLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel5)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jControlPanelLayout.setVerticalGroup(
            jControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecordPersonalVitals, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonUpdatePatientInsurance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnBookFamilyDoctorAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDietitianSession)
                .addGap(18, 18, 18)
                .addComponent(btnFitnessInstructor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCouncellorSession)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addComponent(btnViewVitalSoignHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMyMedicinePrescription)
                .addGap(18, 18, 18)
                .addComponent(btnViewOlderAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout1)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jControlPanel);

        jWorkAreaPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPatientDetailPanel.setOpaque(false);
        jPatientDetailPanel.setPreferredSize(new java.awt.Dimension(1000, 1000));
        jPatientDetailPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(51, 153, 255));
        lblAddress.setText("Address:");
        jPatientDetailPanel.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 155, -1, -1));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Your upcoming appointments with different health providers");
        jPatientDetailPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 500, 26));

        lblPhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhoneNumber.setForeground(new java.awt.Color(51, 153, 255));
        lblPhoneNumber.setText("Phone Number:");
        jPatientDetailPanel.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 129, -1, -1));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(51, 153, 255));
        lblName.setText("Name:");
        jPatientDetailPanel.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 103, -1, -1));

        imgLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPatientDetailPanel.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 113, 120, 120));

        lblPatientDetails.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblPatientDetails.setText("Patient Profile");
        jPatientDetailPanel.add(lblPatientDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 61, -1, 40));

        lblNamePlaceHolder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNamePlaceHolder.setText("NamePlaceHolder");
        jPatientDetailPanel.add(lblNamePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 103, -1, -1));

        lblPhoneNumberPlaceHolder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhoneNumberPlaceHolder.setText("Phone Number Place Holder");
        jPatientDetailPanel.add(lblPhoneNumberPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 129, -1, -1));

        lblAddressPlaceHolder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddressPlaceHolder.setText("AddressPlaceHolder");
        jPatientDetailPanel.add(lblAddressPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 155, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel4.setText("Patient Dashboard");
        jPatientDetailPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 0, -1, 48));

        lblAge.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAge.setForeground(new java.awt.Color(51, 153, 255));
        lblAge.setText("Date Of Birth");
        jPatientDetailPanel.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 181, -1, -1));

        lblAgePlaceHolder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAgePlaceHolder.setText("Dob Place holder");
        jPatientDetailPanel.add(lblAgePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 181, -1, -1));

        lblWeight1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblWeight1.setForeground(new java.awt.Color(51, 153, 255));
        lblWeight1.setText("EmailId:");
        jPatientDetailPanel.add(lblWeight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 213, -1, -1));

        lblEmailPlaceHolder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmailPlaceHolder.setText("EmailIdPlaceHolder");
        jPatientDetailPanel.add(lblEmailPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(316, 213, -1, -1));

        tblAllUpcomingAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Patient Name", "Appointment with", "Role Type", "Appointment Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane2.setViewportView(tblAllUpcomingAppointments);

        jPatientDetailPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 730, 104));

        jLabelRemienderToTakeMeds.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRemienderToTakeMeds.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelRemienderToTakeMeds.setForeground(new java.awt.Color(153, 0, 153));
        jLabelRemienderToTakeMeds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-pill-30.png"))); // NOI18N
        jLabelRemienderToTakeMeds.setText("Do not forget to take your daily medicines");
        jPatientDetailPanel.add(jLabelRemienderToTakeMeds, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 660, -1));

        jLabelRemienderToCheckVitals.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelRemienderToCheckVitals.setForeground(new java.awt.Color(153, 0, 153));
        jLabelRemienderToCheckVitals.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-stethoscope-30.png"))); // NOI18N
        jLabelRemienderToCheckVitals.setText("Do not forget to check your vitals regularly. last vitals recorded on <bbb>");
        jPatientDetailPanel.add(jLabelRemienderToCheckVitals, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 720, -1));

        jLabelRemienderToFollowDiet.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelRemienderToFollowDiet.setForeground(new java.awt.Color(153, 0, 153));
        jLabelRemienderToFollowDiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/create_meal.png"))); // NOI18N
        jLabelRemienderToFollowDiet.setText("Do not forget to check you diet plan and stick to it!");
        jPatientDetailPanel.add(jLabelRemienderToFollowDiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 329, 660, -1));

        jLabelRemienderToExercise.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelRemienderToExercise.setForeground(new java.awt.Color(153, 0, 153));
        jLabelRemienderToExercise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/view workout.png"))); // NOI18N
        jLabelRemienderToExercise.setText("All progress takes place outside your comfort zone. So exercise daily!");
        jPatientDetailPanel.add(jLabelRemienderToExercise, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 366, -1, -1));

        jButtonDeliveryBoyReview.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDeliveryBoyReview.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonDeliveryBoyReview.setText("Tell us was your last medicine prescription delivery at <>?");
        jButtonDeliveryBoyReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeliveryBoyReviewActionPerformed(evt);
            }
        });
        jPatientDetailPanel.add(jButtonDeliveryBoyReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 740, 40));

        jPanel2.add(jPatientDetailPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 6, 810, 1108));

        jWorkAreaPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 820, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jWorkAreaPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 830, 860));

        jSplitPane1.setRightComponent(jWorkAreaPanel);

        javax.swing.GroupLayout jPatientPanelLayout = new javax.swing.GroupLayout(jPatientPanel);
        jPatientPanel.setLayout(jPatientPanelLayout);
        jPatientPanelLayout.setHorizontalGroup(
            jPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPatientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1))
        );
        jPatientPanelLayout.setVerticalGroup(
            jPatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPatientPanelLayout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPatientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPatientPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecordPersonalVitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordPersonalVitalsActionPerformed
        // TODO add your handling code here:
        RecordVitalsJPanel recordVitalsJPanel=new RecordVitalsJPanel(WorkAreaPanel, ecoSystem, patient);
        nextScreen(WorkAreaPanel, recordVitalsJPanel, "recordVitalsJPanel");
    }//GEN-LAST:event_btnRecordPersonalVitalsActionPerformed

    private void btnViewVitalSoignHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVitalSoignHistoryActionPerformed
        // TODO add your handling code here:
        PatientVitalsHistoryPanel dataOfPatientVitalSignJPanel=new PatientVitalsHistoryPanel(WorkAreaPanel, ecoSystem, patient);
        nextScreen(WorkAreaPanel, dataOfPatientVitalSignJPanel, "dataOfPatientVitalSignJPanel");
        
    }//GEN-LAST:event_btnViewVitalSoignHistoryActionPerformed

    private void btnViewOlderAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOlderAppointmentsActionPerformed
        // TODO add your handling code here:
        nextScreen(WorkAreaPanel, new PatientAppointmentHistoyJPanel(WorkAreaPanel, ecoSystem, patient, this, false), "PatientAppointmentHistoyJPanel");
    }//GEN-LAST:event_btnViewOlderAppointmentsActionPerformed

    private void btnBookFamilyDoctorAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookFamilyDoctorAppointmentActionPerformed
        // TODO add your handling code here:
        BookDoctorAppointmentJPanel bookFamilyDoctorAppointmentJPanel=new BookDoctorAppointmentJPanel(WorkAreaPanel, ecoSystem, patient);
        nextScreen(WorkAreaPanel, bookFamilyDoctorAppointmentJPanel, "bookFamilyDoctorAppointmentJPanel");
       
    }//GEN-LAST:event_btnBookFamilyDoctorAppointmentActionPerformed

    private void btnMyMedicinePrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyMedicinePrescriptionActionPerformed
        // TODO add your handling code here:
        nextScreen(WorkAreaPanel, new PatientViewPrescriptionJPanel(WorkAreaPanel, ecoSystem, patient, this), "PatientViewPrescriptionJPanel");
    }//GEN-LAST:event_btnMyMedicinePrescriptionActionPerformed

    private void btnLogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout1ActionPerformed
        // TODO add your handling code here:
        nextScreen(WorkAreaPanel, new Login(WorkAreaPanel, ecoSystem), "Login Page");
    }//GEN-LAST:event_btnLogout1ActionPerformed

    private void btnDietitianSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDietitianSessionActionPerformed

        nextScreen(WorkAreaPanel, new UICounselorDietitianFitnessTrainer.PatientDieticianDashboard(WorkAreaPanel,ecoSystem,patient), "PatientDieticianDashboard");
    }//GEN-LAST:event_btnDietitianSessionActionPerformed

    private void btnCouncellorSessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCouncellorSessionActionPerformed

        nextScreen(WorkAreaPanel, new UICounselorDietitianFitnessTrainer.PatientCounselorDashboard(WorkAreaPanel,ecoSystem,patient), "PatientCounselorDashboard");
    }//GEN-LAST:event_btnCouncellorSessionActionPerformed

    private void btnFitnessInstructorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFitnessInstructorActionPerformed

        nextScreen(WorkAreaPanel, new UICounselorDietitianFitnessTrainer.PatientFitnessDashboard(WorkAreaPanel,ecoSystem,patient), "PatientFitnessDashboard");
    }//GEN-LAST:event_btnFitnessInstructorActionPerformed

    private void jButtonUpdatePatientInsuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdatePatientInsuranceActionPerformed
        // TODO add your handling code here:
        
        nextScreen(WorkAreaPanel, new PatientInsuranceDetailsJPanel(WorkAreaPanel, ecoSystem, patient, this), "PatientInsuranceDetailsJPanel");
    }//GEN-LAST:event_jButtonUpdatePatientInsuranceActionPerformed

    private void jButtonDeliveryBoyReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeliveryBoyReviewActionPerformed
        // TODO add your handling code here:

        Prescription prescription = patient.getLatestMedicinePrescription();
        DeliveryMan.DeliveryMan deliveryMan = prescription.getDeliveryMan();
        StarRatingsUtil starRatingsUtil = new StarRatingsUtil();
        Rating rating = new Rating();
        starRatingsUtil.openRatingsJPanel("Provide Review for Prescription Delivery", deliveryMan, rating, LocalDate.now());
        prescription.setDeliveryReviewProvided(true);
        jButtonDeliveryBoyReview.setEnabled(false);
        jButtonDeliveryBoyReview.setVisible(true);
        jButtonDeliveryBoyReview.setText("Last medicine prescription delivery at " + prescription.getDeliveryDate().toString());
    }//GEN-LAST:event_jButtonDeliveryBoyReviewActionPerformed

    private void setUpDeliveryManReviewButton() {
        Prescription prescription = patient.getLatestMedicinePrescription();
        if (prescription == null) {
            jButtonDeliveryBoyReview.setEnabled(false);
            jButtonDeliveryBoyReview.setVisible(false);
            return;
        }
        
        if (!prescription.isDeliveryReviewProvided()) {
            jButtonDeliveryBoyReview.setEnabled(true);
            jButtonDeliveryBoyReview.setVisible(true);
            jButtonDeliveryBoyReview.setText("Tell us how was your last medicine prescription delivery at " + prescription.getDeliveryDate().toString());
            jButtonDeliveryBoyReview.setForeground(new Color(51, 204, 255));
        } else {
            jButtonDeliveryBoyReview.setEnabled(false);
            jButtonDeliveryBoyReview.setVisible(true);
            jButtonDeliveryBoyReview.setText("Last medicine prescription delivery at " + prescription.getDeliveryDate().toString());
            jButtonDeliveryBoyReview.setForeground(Color.white);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookFamilyDoctorAppointment;
    private javax.swing.JButton btnCouncellorSession;
    private javax.swing.JButton btnDietitianSession;
    private javax.swing.JButton btnFitnessInstructor;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnMyMedicinePrescription;
    private javax.swing.JButton btnRecordPersonalVitals;
    private javax.swing.JButton btnViewOlderAppointments;
    private javax.swing.JButton btnViewVitalSoignHistory;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDeliveryBoyReview;
    private javax.swing.JButton jButtonUpdatePatientInsurance;
    private javax.swing.JPanel jControlPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelRemienderToCheckVitals;
    private javax.swing.JLabel jLabelRemienderToExercise;
    private javax.swing.JLabel jLabelRemienderToFollowDiet;
    private javax.swing.JLabel jLabelRemienderToTakeMeds;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPatientDetailPanel;
    private javax.swing.JPanel jPatientPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel jWorkAreaPanel;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddressPlaceHolder;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAgePlaceHolder;
    private javax.swing.JLabel lblEmailPlaceHolder;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNamePlaceHolder;
    private javax.swing.JLabel lblPatientDetails;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblPhoneNumberPlaceHolder;
    private javax.swing.JLabel lblWeight1;
    private javax.swing.JTable tblAllUpcomingAppointments;
    // End of variables declaration//GEN-END:variables
  
}
