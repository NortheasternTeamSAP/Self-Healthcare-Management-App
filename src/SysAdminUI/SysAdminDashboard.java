/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SysAdminUI;

import EcoSystem.EcoSystem;
import UICounselorDietitianFitnessTrainer.ViewPastAppointments;
import Utils.NextScreen;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author preet
 */
public class SysAdminDashboard extends javax.swing.JPanel implements NextScreen {
   JPanel WorkArea;
   EcoSystem system;
    /**
     * Creates new form SysAdminDashboard
     */
    public SysAdminDashboard(JPanel WorkArea, EcoSystem system) {
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

        bntmanageenterprise = new javax.swing.JButton();
        bntmanageorg = new javax.swing.JButton();
        jBtnLogout = new javax.swing.JButton();
        manageemp = new javax.swing.JButton();
        jButtonUpdateDeleteRoles = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bntmanageenterprise.setBackground(new java.awt.Color(255, 255, 255));
        bntmanageenterprise.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bntmanageenterprise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/mngEnt.png"))); // NOI18N
        bntmanageenterprise.setText("Manage Enterprise");
        bntmanageenterprise.setToolTipText("Manage your enterprise");
        bntmanageenterprise.setBorder(null);
        bntmanageenterprise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntmanageenterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntmanageenterpriseActionPerformed(evt);
            }
        });
        add(bntmanageenterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 250, 60));

        bntmanageorg.setBackground(new java.awt.Color(255, 255, 255));
        bntmanageorg.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bntmanageorg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/mngOrg.png"))); // NOI18N
        bntmanageorg.setText("Manage Organization");
        bntmanageorg.setToolTipText("Manage Organizations");
        bntmanageorg.setBorder(null);
        bntmanageorg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntmanageorg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntmanageorgActionPerformed(evt);
            }
        });
        add(bntmanageorg, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 250, 60));

        jBtnLogout.setBackground(new java.awt.Color(255, 255, 255));
        jBtnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBtnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/logout.png"))); // NOI18N
        jBtnLogout.setText("Logout");
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });
        add(jBtnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 31, -1, -1));

        manageemp.setBackground(new java.awt.Color(255, 255, 255));
        manageemp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        manageemp.setText("Create Roles");
        manageemp.setToolTipText("Manage Employees");
        manageemp.setBorder(null);
        manageemp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageempActionPerformed(evt);
            }
        });
        add(manageemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 250, 50));

        jButtonUpdateDeleteRoles.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUpdateDeleteRoles.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonUpdateDeleteRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/mngRoles.png"))); // NOI18N
        jButtonUpdateDeleteRoles.setText("Update/ Delete Roles");
        jButtonUpdateDeleteRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateDeleteRolesActionPerformed(evt);
            }
        });
        add(jButtonUpdateDeleteRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 250, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("System Admin Dashboard");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/sys-admin-gif.gif"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 480, 210));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void bntmanageenterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntmanageenterpriseActionPerformed
      
        nextScreen(WorkArea, new ManageEnterprises(WorkArea,system, this), "ManageEnterprises"); 
    }//GEN-LAST:event_bntmanageenterpriseActionPerformed

    private void bntmanageorgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntmanageorgActionPerformed
     
        nextScreen(WorkArea, new ManageOrganizations(WorkArea,system, this), "ManageOrganizations");
    }//GEN-LAST:event_bntmanageorgActionPerformed

    private void jBtnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLogoutActionPerformed
        nextScreen(WorkArea, new Login(WorkArea, system), "Login Page");
    }//GEN-LAST:event_jBtnLogoutActionPerformed

    private void manageempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageempActionPerformed

        nextScreen(WorkArea, new CreateRolesJPanel(WorkArea, system, this), "CreateRolesJPanel");
    }//GEN-LAST:event_manageempActionPerformed

    private void jButtonUpdateDeleteRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateDeleteRolesActionPerformed
        // TODO add your handling code here:
        nextScreen(WorkArea, new UpdateAndDeleteRolesJPanel(WorkArea, system, this), "UpdateAndDeleteRolesJPanel");
    }//GEN-LAST:event_jButtonUpdateDeleteRolesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntmanageenterprise;
    private javax.swing.JButton bntmanageorg;
    private javax.swing.JButton jBtnLogout;
    private javax.swing.JButton jButtonUpdateDeleteRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton manageemp;
    // End of variables declaration//GEN-END:variables
}
