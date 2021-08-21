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

        bntmanageenterprise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/enterprise-mobility.jpg"))); // NOI18N
        bntmanageenterprise.setToolTipText("Manage your enterprise");
        bntmanageenterprise.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 204, 204), null));
        bntmanageenterprise.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntmanageenterprise.setOpaque(true);
        bntmanageenterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntmanageenterpriseActionPerformed(evt);
            }
        });

        bntmanageorg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/oo.jpg"))); // NOI18N
        bntmanageorg.setToolTipText("Manage Organizations");
        bntmanageorg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 204, 204), null));
        bntmanageorg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntmanageorg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntmanageorgActionPerformed(evt);
            }
        });

        jBtnLogout.setText("Logout");
        jBtnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLogoutActionPerformed(evt);
            }
        });

        manageemp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/ee3.jpg"))); // NOI18N
        manageemp.setToolTipText("Manage Employees");
        manageemp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 204, 204), new java.awt.Color(0, 102, 102), new java.awt.Color(0, 204, 204), null));
        manageemp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageempActionPerformed(evt);
            }
        });

        jButtonUpdateDeleteRoles.setText("Update/Delete Roles");
        jButtonUpdateDeleteRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateDeleteRolesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(bntmanageenterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(bntmanageorg, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(manageemp, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jBtnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonUpdateDeleteRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(663, 663, 663))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jBtnLogout)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bntmanageenterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntmanageorg, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(manageemp, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110)
                .addComponent(jButtonUpdateDeleteRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
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
    private javax.swing.JButton manageemp;
    // End of variables declaration//GEN-END:variables
}
