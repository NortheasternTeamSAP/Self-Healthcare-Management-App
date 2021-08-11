/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Dietitian.Dietitian;
import Dietitian.DietitianAppointment;
import EcoSystem.EcoSystem;
import Patient.Patient;
import java.awt.CardLayout;
import java.awt.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preet
 */
public class DietitianDirectory extends javax.swing.JPanel {
   JPanel WorkArea;
   EcoSystem system;
    /**
     * Creates new form DietitianDirectory
     */
    public DietitianDirectory(JPanel WorkArea,EcoSystem system) {
        initComponents();
        this.WorkArea=WorkArea;
        this.system=system;
        ShowDietitians();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbldietitians = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        tbldietitians.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Dietitian"
            }
        ));
        jScrollPane1.setViewportView(tbldietitians);

        jButton1.setText("Add Dietitian");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete Dietitian ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit Dietitian");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(46, 46, 46)
                .addComponent(jButton2)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(259, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CreateDietician ls= new CreateDietician(WorkArea,system);
        WorkArea.add("CreateDietician",ls);
        CardLayout layout= (CardLayout)WorkArea.getLayout();
        layout.next(WorkArea);   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = tbldietitians.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a Dietitian from the Table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Dietitian p = (Dietitian)tbldietitians.getValueAt(row, 0);
        CreateDietician ls= new CreateDietician(WorkArea,system,p);
        WorkArea.add("CreateDietician",ls);
        CardLayout layout= (CardLayout)WorkArea.getLayout();
        layout.next(WorkArea); 
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = tbldietitians.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a Dietitian from the Table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Dietitian p = (Dietitian)tbldietitians.getValueAt(row, 0);
        system.getDietitianDirectory().deleteDeititian(p);
         JOptionPane.showMessageDialog(this, "This dietician  has been deleted ");
         ShowDietitians();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        WorkArea.remove(this);
        Component[] componentArray = WorkArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout)WorkArea.getLayout();
        layout.previous(WorkArea);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldietitians;
    // End of variables declaration//GEN-END:variables

 public void ShowDietitians() {
 DefaultTableModel model = (DefaultTableModel) tbldietitians.getModel();
 ArrayList<Dietitian> temp=new ArrayList();
        try {
            temp=system.getDietitianDirectory().getDietitians();
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