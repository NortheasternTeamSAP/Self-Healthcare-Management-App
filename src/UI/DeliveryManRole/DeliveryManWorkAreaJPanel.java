/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.DeliveryManRole;

import DataStore.CredentialsManager;
import DeliveryMan.DeliveryManDirectory;
import EcoSystem.EcoSystem;
import Order.Order;
import Order.OrderDirectory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sravya
 */
public class DeliveryManWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private EcoSystem ecoSystem;
    private CredentialsManager credentialsManager;
    private DeliveryManDirectory deliveryManDirectory;
    private OrderDirectory orderDirectory;
    
    public DeliveryManWorkAreaJPanel(
            JPanel workArea, 
            CredentialsManager credentialsManager,  
            EcoSystem ecoSystem,
            DeliveryManDirectory deliveryManDirectory,
            OrderDirectory orderDirectory) {
        initComponents();
        this.setSize(980, 780);
        this.workArea = workArea;
        this.credentialsManager = credentialsManager;
        this.ecoSystem = ecoSystem;
        this.orderDirectory = ecoSystem.getOrderDirectory();
        this.deliveryManDirectory = ecoSystem.getDeliveryManDirectory();
        
        populateTable();
    }
    
    //write methods to populate Order table and deliveryManOrderTable
    public void populateOrderTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        for(Order order: ecoSystem.getOrderDirectory().)
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDeliveryMan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Hello Delivery Man!");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        workRequestJTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Comment", "Patient Name", "Patient Address", "Pharmacy Name", "Pharmacy Address", "Order Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setSelectionBackground(new java.awt.Color(255, 204, 204));
        workRequestJTable.setSelectionForeground(new java.awt.Color(51, 51, 255));
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 880, 96));

        assignJButton.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        assignJButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\sravy\\OneDrive\\Pictures\\A4 pics\\icons8-connected-people-30.png")); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.setContentAreaFilled(false);
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, 40));

        processJButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\sravy\\OneDrive\\Pictures\\A4 pics\\icons8-process-30.png")); // NOI18N
        processJButton.setText("Process Order");
        processJButton.setContentAreaFilled(false);
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 150, -1));

        refreshJButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\sravy\\OneDrive\\Pictures\\A4 pics\\icons8-refresh-30.png")); // NOI18N
        refreshJButton.setContentAreaFilled(false);
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 40, 30));

        tblDeliveryMan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblDeliveryMan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Patient Name", "Patient Address", "Pharmacy Name", "Pharmacy Address", "Order Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDeliveryMan.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tblDeliveryMan.setSelectionForeground(new java.awt.Color(102, 102, 255));
        jScrollPane2.setViewportView(tblDeliveryMan);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 880, 180));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Order Requests");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("My Deliveries");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row");
            return;
        }

        Order order = (Order) workRequestJTable.getValueAt(selectedRow,0);
        order.setDeliveryMan(credentialsManager.getEmployee().getName()); //check
        order.setOrderStatus("Order Picked up");
        populateTable();
        populateDeliveryManTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = tblDeliveryMan.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row");
            return;
        }

        Order order = (Order) tblDeliveryMan.getValueAt(selectedRow, 0);
        if(order.getOrderStatus().equals("Delivered")) {
            JOptionPane.showMessageDialog(null, "Already Delivered.");
            return;
        }
        order.setOrderStatus("Delivered");

        JOptionPane.showMessageDialog(null, "Delivered");
        populateDeliveryManTable();
    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable tblDeliveryMan;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
