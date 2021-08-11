/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.PharmacistRole;

/**
 *
 * @author Sravya
 */
public class PharmacistWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PharmacistWorkAreaJPanel
     */
    public PharmacistWorkAreaJPanel() {
        initComponents();
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
        btnManageMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        btnManageOrders.setBackground(new java.awt.Color(255, 255, 255));
        btnManageOrders.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageOrders.setIcon(new javax.swing.ImageIcon("C:\\Users\\sravy\\OneDrive\\Pictures\\A4 pics\\mng orders.png")); // NOI18N
        btnManageOrders.setText("Manage Orders");
        btnManageOrders.setContentAreaFilled(false);
        btnManageOrders.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnManageOrders.setOpaque(true);
        btnManageOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrdersActionPerformed(evt);
            }
        });

        btnManageMenu.setBackground(new java.awt.Color(255, 255, 255));
        btnManageMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnManageMenu.setIcon(new javax.swing.ImageIcon("C:\\Users\\sravy\\OneDrive\\Pictures\\A4 pics\\mng res menu.png")); // NOI18N
        btnManageMenu.setText("Manage Medicines");
        btnManageMenu.setContentAreaFilled(false);
        btnManageMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnManageMenu.setOpaque(true);
        btnManageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageMenuActionPerformed(evt);
            }
        });

        jButton1.setText("Manage Medicine Stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnManageMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnManageOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(482, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnManageOrders)
                .addGap(18, 18, 18)
                .addComponent(btnManageMenu)
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(394, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrdersActionPerformed

        ManageOrders manageOrderJPanel = new ManageOrders(userProcessContainer,account, ecoSystem, restaurantDirectory, menuDirectory, orderDirectory);
        userProcessContainer.add("ManageOrderJPanel", manageOrderJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageOrdersActionPerformed

    private void btnManageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageMenuActionPerformed

        ManageMenu manageMenuJPanel = new ManageMenu(userProcessContainer, account, ecoSystem, restaurantDirectory, menuDirectory);
        userProcessContainer.add("manageMenuJPanel", manageMenuJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageMenu;
    private javax.swing.JButton btnManageOrders;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
