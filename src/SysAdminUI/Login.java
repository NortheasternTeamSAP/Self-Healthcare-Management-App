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
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Password:");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText(" Login ");

        jLabel1.setText("Username :");

        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Not registerd ? New Patient REgistration ");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon("/Users/mrs.katey/Desktop/giphy.gif")); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -160, 490, 763));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(70, 70, 70))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(154, 154, 154))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel3)
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
                int organizationId = p.getOrganizationId();
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
              nextScreen(new NewRegistrationJPanel(WorkArea, system), "NewRegistrationJPanel");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
