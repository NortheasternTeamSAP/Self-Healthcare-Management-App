/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Counselor.Counselor;
import Dietitian.Dietitian;
import EcoSystem.EcoSystem;
import Personnel.Person;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preet
 */
public class CounselorDirectory extends javax.swing.JPanel {
   JPanel WorkArea;
   EcoSystem system;
    /**
     * Creates new form CounselorDirectory
     */
    public CounselorDirectory(JPanel WorkArea,EcoSystem system) {
        initComponents();
        this.WorkArea=WorkArea;
        this.system=system;
        ShowCounselors();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcounselor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/edit.png"))); // NOI18N
        jButton3.setText("Edit ");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 100, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/delete.png"))); // NOI18N
        jButton2.setText("Delete ");
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, 30));

        tblcounselor.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblcounselor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Counselors"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblcounselor);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 870, 280));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("List of Counselors:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1100, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        WorkArea.remove(this);
        Component[] componentArray = WorkArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout)WorkArea.getLayout();
        layout.previous(WorkArea);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = tblcounselor.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a Counselor from the Table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Counselor p = (Counselor)tblcounselor.getValueAt(row, 0);
        ModifyCounselor ls= new ModifyCounselor(WorkArea,system,p);
        WorkArea.add("CreateCounselor",ls);
        CardLayout layout= (CardLayout)WorkArea.getLayout();
        layout.next(WorkArea);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = tblcounselor.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a Counselor from the Table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Counselor p = (Counselor)tblcounselor.getValueAt(row, 0);
        system.globalUserDirectory.remove(p);
        JOptionPane.showMessageDialog(this, "This Counselor  has been deleted ");
        ShowCounselors();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcounselor;
    // End of variables declaration//GEN-END:variables


    public void ShowCounselors() {
    DefaultTableModel model = (DefaultTableModel) tblcounselor.getModel();
     List<Person> temp;    
        try {
            temp = system.globalUserDirectory.getAllCounselors();
            System.out.println("counselor list "+temp);
        } catch (Exception e) {
            return;
        }
 
        model.setRowCount(0);
        
        for(int i=0;i<temp.size();i++)
    {
        Object row[] = new Object[1];
        row[0] = temp.get(i);
        model.addRow(row);
     
    }       
   }
}
