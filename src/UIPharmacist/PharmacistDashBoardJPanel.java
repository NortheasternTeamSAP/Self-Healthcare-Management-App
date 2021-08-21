/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPharmacist;

import EcoSystem.EcoSystem;
import Medicine.MedicineDirectory;
import Order.OrderDirectory;
import Personnel.UserAccount;
import Enterprise.PharmacyEnterprise;
import Pharmacy.PharmacyDirectory;
import SysAdminUI.Login;
import Utils.NextScreen;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Sravya
 */
public class PharmacistDashBoardJPanel extends javax.swing.JPanel implements NextScreen {

    private JPanel workArea;
    private EcoSystem ecoSystem;
    private PharmacyEnterprise pharmacy;
    
    public PharmacistDashBoardJPanel(
            JPanel workArea,
            EcoSystem ecoSystem, 
            PharmacyEnterprise pharmacy) {
        

        this.workArea = workArea;
        this.ecoSystem = ecoSystem;
        this.pharmacy = pharmacy;
        initComponents();
        this.setSize(1100, 850);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnManageOrders = new javax.swing.JButton();
        btnManageMedicineCatalog = new javax.swing.JButton();
        lblPharmacistDashboard = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnManageOrders.setBackground(new java.awt.Color(255, 255, 255));
        btnManageOrders.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/mngOrder.png"))); // NOI18N
        btnManageOrders.setText("Manage Orders");
        btnManageOrders.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnManageOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrdersActionPerformed(evt);
            }
        });
        add(btnManageOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 243, 280, -1));

        btnManageMedicineCatalog.setBackground(new java.awt.Color(255, 255, 255));
        btnManageMedicineCatalog.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageMedicineCatalog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/medication.png"))); // NOI18N
        btnManageMedicineCatalog.setText("Manage Medicine Stock");
        btnManageMedicineCatalog.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnManageMedicineCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageMedicineCatalogActionPerformed(evt);
            }
        });
        add(btnManageMedicineCatalog, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 183, 280, -1));

        lblPharmacistDashboard.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPharmacistDashboard.setText("Pharmacist Dashboard");
        add(lblPharmacistDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 89, -1, -1));

        jButtonLogout.setBackground(new java.awt.Color(255, 255, 255));
        jButtonLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/logout.png"))); // NOI18N
        jButtonLogout.setText("Logout");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });
        add(jButtonLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 14, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1100, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrdersActionPerformed
        ManageOrdersJPanel manageOrderJPanel = new ManageOrdersJPanel(workArea, ecoSystem, pharmacy);
        workArea.add("ManageOrderJPanel", manageOrderJPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnManageOrdersActionPerformed

    private void btnManageMedicineCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageMedicineCatalogActionPerformed
        ManageMedicineStockJPanel manageMedicineCatalogJPanel = new ManageMedicineStockJPanel(workArea, pharmacy, ecoSystem);
        workArea.add("ManageMedicineCatalogJPanel", manageMedicineCatalogJPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnManageMedicineCatalogActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:
         nextScreen(workArea, new Login(workArea, ecoSystem), "Login Page");
    }//GEN-LAST:event_jButtonLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageMedicineCatalog;
    private javax.swing.JButton btnManageOrders;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPharmacistDashboard;
    // End of variables declaration//GEN-END:variables
}
