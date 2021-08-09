/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.PAdminRole;

import DeliveryMan.DeliveryMan;
import DeliveryMan.DeliveryManDirectory;
import EcoSystem.EcoSystem;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sravya
 */
public class ManageDeliveryManJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private EcoSystem ecoSystem;
    private DeliveryManDirectory deliveryManDirectory;
    
    public ManageDeliveryManJPanel(
           JPanel workArea,
           EcoSystem ecoSystem, 
           DeliveryManDirectory deliveryManDirectory ) {
        
        initComponents();
        this.workArea = workArea;
        this.ecoSystem = ecoSystem;
        this.deliveryManDirectory = ecoSystem.getDeliveryManDirectory(); //check
        populateTable();
    }
    
    //write method to populate manage deliveryman table
    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblDeliveryMan7.getModel();
        dtm.setRowCount(0);
        for(DeliveryMan deliveryMan : deliveryManDirectory.getDeliveryManList()){
            Object [] row = new Object[6];
            row[0] = deliveryMan;
            //row[1] = deliveryMan.getEmailID();
            row[2] = deliveryMan.getHomeAddress();
            row[3] = deliveryMan.getPhNo();
            //row[4] = deliveryMan.getAge();
            dtm.addRow(row);
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

        btnModify7 = new javax.swing.JButton();
        btnCreate7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeliveryMan7 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnDelete7 = new javax.swing.JButton();

        btnModify7.setText("Update");
        btnModify7.setContentAreaFilled(false);
        btnModify7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModify7ActionPerformed(evt);
            }
        });

        btnCreate7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnCreate7.setText("Create ");
        btnCreate7.setToolTipText("");
        btnCreate7.setContentAreaFilled(false);
        btnCreate7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate7ActionPerformed(evt);
            }
        });

        tblDeliveryMan7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblDeliveryMan7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name ", "Address", "Phone Number", "DOB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDeliveryMan7);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Manage Delivery Man");

        btnBack.setText("Back");
        btnBack.setToolTipText("Back");
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Delivery Man Details");

        btnDelete7.setText("Delete ");
        btnDelete7.setContentAreaFilled(false);
        btnDelete7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModify7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModify7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(314, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnModify7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModify7ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDeliveryMan7.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Select a row from table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DeliveryMan deliveryMan = (DeliveryMan)tblDeliveryMan7.getValueAt(selectedRow,0);
        ModifyDeliveryManJPanel modifyDeliveryMan = new ModifyDeliveryManJPanel(workArea, ecoSystem, deliveryManDirectory, deliveryMan);
        workArea.add("ModifyDeliveryManJPanel",modifyDeliveryMan);
        CardLayout layout =(CardLayout)workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnModify7ActionPerformed

    private void btnCreate7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate7ActionPerformed
        // TODO add your handling code here:
        AddDeliveryManJPanel createDelivery = new AddDeliveryManJPanel(workArea, ecoSystem, deliveryManDirectory);
        workArea.add("CreateDeliveryManJPanel",createDelivery);
        CardLayout layout =(CardLayout)workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_btnCreate7ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        CardLayout layout2 = (CardLayout) workArea.getLayout();
        layout2.previous(workArea);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDelete7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete7ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblDeliveryMan7.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null,"Select a row from table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DeliveryMan deliveryMan = (DeliveryMan) tblDeliveryMan7.getValueAt(selectedRow, 0);
        deliveryManDirectory.deleteDeliveryMan(deliveryMan);
        populateTable();
    }//GEN-LAST:event_btnDelete7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate7;
    private javax.swing.JButton btnDelete7;
    private javax.swing.JButton btnModify7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDeliveryMan7;
    // End of variables declaration//GEN-END:variables
}