/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SysAdminUI;

import Counselor.Counselor;
import DeliveryMan.DeliveryMan;
import Dietitian.Dietitian;
import EcoSystem.EcoSystem;
import FitnessTrainer.FitnessTrainer;
import Personnel.Person;
import UICounselorDietitianFitnessTrainer.CounselorDashboard;
import UICounselorDietitianFitnessTrainer.DietitianDashboard;
import UICounselorDietitianFitnessTrainer.FitnessTrainerDashBoard;
import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import Enterprise.PharmacyEnterprise;
import Insurance.InsuranceProviderRepresentative;
import Laboratory.LaboratoryAssistant;
import Organization.Organization;
import Patient.Patient;
import UIPatientDoctorInsuranceProvider.DoctorWorkAreaPanel;
import UIPatientDoctorInsuranceProvider.InsuranceProviderRepresentativeHomePageJPanel;
import UIPatientDoctorInsuranceProvider.LaboratoryAssistantHomePagePanel;
import UIPatientDoctorInsuranceProvider.PatientHomePagePanel;
import Personnel.Person;
import Personnel.Role;
import Personnel.SystemAdmin;
import Pharmacy.Pharmacist;
import UIDeliveryMan.DeliveryManWorkAreaJPanel;
import UIPharmacist.PharmacistDashBoardJPanel;
import Utils.NextScreen;
import Utils.AwsS3Helper;
import Utils.EmailClient;
import Utils.ForgetPasswordJPanel;
import Utils.RatingsJPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author preet
 */
public class Login extends javax.swing.JPanel implements NextScreen {
  JPanel WorkArea;
   EcoSystem system;
    private JPanel temporaryBack;
    /**
     * Creates new form StaffLogin
     */
    public Login(JPanel WorkArea,EcoSystem system) {
        initComponents();
        this.setSize(1100,850);
        this.WorkArea=WorkArea;
        this.system=system;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jBtnForgetPassword = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 218, 35));

        jButtonLogin.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-login-30 (1).png"))); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 410, 240, 45));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 306, -1, -1));

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 218, 36));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText(" Login ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Username ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-new-30.png"))); // NOI18N
        jButton2.setText("New User? Register here");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 550, 234, 40));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        jBtnForgetPassword.setBackground(new java.awt.Color(255, 255, 255));
        jBtnForgetPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnForgetPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-forgot-password-30.png"))); // NOI18N
        jBtnForgetPassword.setText("Forgot Password?");
        jBtnForgetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnForgetPasswordActionPerformed(evt);
            }
        });
        add(jBtnForgetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 480, 230, 45));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/health springs Logo.gif"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 490, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        
        String username = jTextField1.getText();
        String password = new String(jPasswordField1.getPassword());

        Person p = system.globalUserDirectory.get(username, password);
        if (p == null) {
            JOptionPane.showMessageDialog(this, "Invalid user credentials!");
            jTextField1.setText("");
            jPasswordField1.setText("");
            return;
        }
        
        System.out.println("User " + username + " with role " + p.getRole() + " is logged in");
        
        switch (p.getRole()) {
            case SYSTEM_ADMIN:
                nextScreen(WorkArea, new SysAdminDashboard(WorkArea, system), "SysAdminDashboard");
                break;
            case PATIENT:
                nextScreen(WorkArea, new PatientHomePagePanel(WorkArea, system, (Patient) p), "PatientHomePagePanel");
                break;
            case DOCTOR:
              
                // redirect to doctor dashboard
                long organizationId = p.getOrganizationId();
                Organization organization = system.organizationDirectory.getOrganization(organizationId);
                Enterprise enterprise = organization.getEnterprise();
                nextScreen(WorkArea, new DoctorWorkAreaPanel(WorkArea, system, enterprise, (Doctor) p), "DoctorWorkAreaPanel");
                break;
             
            case LABASSISTANT:
               nextScreen(WorkArea, new LaboratoryAssistantHomePagePanel(WorkArea, system,(LaboratoryAssistant)p), "LaboratoryAssistantHomePagePanel");
                break;

            case INSURANCE_PROVIDER_REP:
                InsuranceProviderRepresentativeHomePageJPanel insuranceprovider= new InsuranceProviderRepresentativeHomePageJPanel(WorkArea,system, 
                        system.organizationDirectory.getOrganization(p.getOrganizationId()), (InsuranceProviderRepresentative)p);
                 nextScreen(WorkArea, insuranceprovider, "InsuranceProviderRepresentativeHomePageJPanel");

                break;
            case DELIVERY_MAN:
                // redirect to delivery man dashboard
                 nextScreen(WorkArea, new DeliveryManWorkAreaJPanel(WorkArea, system, (DeliveryMan)p), "DeliveryManWorkAreaJPanel");
                break;
            case PHARMACIST:
                organizationId = p.getOrganizationId();
                organization = system.organizationDirectory.getOrganization(organizationId);
                nextScreen(WorkArea, new PharmacistDashBoardJPanel(WorkArea, system,(PharmacyEnterprise)organization.getEnterprise()), "PharmacistDashBoardJPanel");
                break;
            case DIETITIAN:
                nextScreen(WorkArea, new DietitianDashboard(WorkArea,system,(Dietitian)p), "DietitianDashboard");
                break;
            case TRAINER:
                nextScreen(WorkArea, new FitnessTrainerDashBoard(WorkArea,system,(FitnessTrainer)p), "FitnessTrainerDashBoard");
                break;
            case COUNSELOR:
                nextScreen(WorkArea, new CounselorDashboard(WorkArea,system,(Counselor)p), "CounselorDashboard");
                break;
            case INVALID:
            default:
                // this should never happen if all roles are initialized with a role correctly
                JOptionPane.showMessageDialog(this, "Unknown user role");
                break;
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
              nextScreen(new NewRegistrationJPanel(WorkArea, system), "NewRegistrationJPanel");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBtnForgetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnForgetPasswordActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("Health Springs App - Password Reset");
        ForgetPasswordJPanel ratingsPanel = new ForgetPasswordJPanel(system);
        frame.add(ratingsPanel);
        ratingsPanel.setVisible(true);
        frame.setVisible(true);
        frame.setSize(700, 700);
    }//GEN-LAST:event_jBtnForgetPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnForgetPassword;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

   private void nextScreen(JPanel nextScreen, String screenName) {
        WorkArea.removeAll();
        WorkArea.add(screenName , nextScreen);
        WorkArea.setAlignmentX(SwingConstants.CENTER);
        WorkArea.setAlignmentY(SwingConstants.CENTER);
        CardLayout layout = (CardLayout)WorkArea.getLayout();
        Dimension d = nextScreen.getLayout().preferredLayoutSize(nextScreen);
        WorkArea.setSize(d);
        layout.next(WorkArea); 
   }
}
