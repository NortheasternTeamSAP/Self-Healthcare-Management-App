/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SysAdminUI;

import Counselor.Counselor;
import Dietitian.Dietitian;
import EcoSystem.EcoSystem;
import FitnessTrainer.FitnessTrainer;
import Personnel.Person;
import UI.CounselorDashboard;
import UI.DietitianDashboard;
import UI.FitnessTrainerDashBoard;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author preet
 */
public class Login extends javax.swing.JPanel {
  JPanel WorkArea;
   EcoSystem system;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel3)
                .addGap(75, 75, 75)
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
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = jTextField1.getText();
        String password = jPasswordField1.getText();
        
        Person p = system.globalUserDirectory.get(username, password);
        if (p == null)
        {
            JOptionPane.showMessageDialog(this, "Invalid user credentials!");
            return;
        }
        
        System.out.println("User " + username + " with role " + p.getRole() + " is logged in");
        
        switch (p.getRole()) {
            case SYSTEM_ADMIN:
                SysAdminDashboard ls= new SysAdminDashboard(WorkArea,system);
                WorkArea.add("SysAdminDashboard",ls);
                CardLayout layout= (CardLayout)WorkArea.getLayout();
                layout.next(WorkArea);  
                break;
            case PATIENT:
                // redirect to patient dashboard
                break;
            case DOCTOR:
                // redirect to doctor dashboard
                break;
            case INSURANCE_PROVIDER_REP:
                // redirect to insurance provider dashboard
                break;
            case DELIVERY_MAN:
                // redirect to delivery man dashboard
                break;
            case PHARMACIST:
                // redirect to pharmacist dashboard
                break;
            case DIETITIAN:
                 DietitianDashboard dd= new DietitianDashboard(WorkArea,system,(Dietitian)p);
                WorkArea.add("DietitianDashboard",dd);
                CardLayout layoutd= (CardLayout)WorkArea.getLayout();
                layoutd.next(WorkArea); 
                break;
            case TRAINER:
                FitnessTrainerDashBoard fd= new FitnessTrainerDashBoard(WorkArea,system,(FitnessTrainer)p);
                WorkArea.add("FitnessTrainerDashBoard",fd);
                CardLayout layoutft= (CardLayout)WorkArea.getLayout();
                layoutft.next(WorkArea); 
                break;
            case COUNSELOR:
                CounselorDashboard cd= new CounselorDashboard(WorkArea,system,(Counselor)p);
                WorkArea.add("CounselorDashboard",cd);
                CardLayout layoutcd= (CardLayout)WorkArea.getLayout();
                layoutcd.next(WorkArea); 
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
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
