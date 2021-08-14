/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Counselor.Counselor;
import Counselor.CounselorAppointment;
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
public class CounselorDashboard extends javax.swing.JPanel {
JPanel WorkArea;
EcoSystem system;
Counselor c;
    /**
     * Creates new form CounselorDashboard
     */
    public CounselorDashboard(JPanel WorkArea,EcoSystem system,Counselor c) {
        initComponents();
          initComponents();
      this.WorkArea=WorkArea;
      this.system=system;
      this.c=c;
      populateupcomingAppointments();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpastapp = new javax.swing.JTable();

        jButton1.setText("View Past Appointment");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Add Counselling Notes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        tblpastapp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient", "Upcoming Appointment Date"
            }
        ));
        jScrollPane1.setViewportView(tblpastapp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewPastAppointmentCounselor ls= new ViewPastAppointmentCounselor(WorkArea,system,c.getCounselorSchedule().getCounselorAppointments(),0);
        WorkArea.add("ViewPastAppointmentCounselor",ls);
        CardLayout layout= (CardLayout)WorkArea.getLayout();
        layout.next(WorkArea);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      int row = tblpastapp.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a Patient from the Table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Patient p = (Patient)tblpastapp.getValueAt(row, 0);
        CreateCounselingNotes cp=new CreateCounselingNotes(WorkArea,system,c,p);
        WorkArea.add("CreateCounselingNotes",cp);
        CardLayout layout= (CardLayout)WorkArea.getLayout();
        layout.next(WorkArea);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        WorkArea.remove(this);
        Component[] componentArray = WorkArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout)WorkArea.getLayout();
        layout.previous(WorkArea);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblpastapp;
    // End of variables declaration//GEN-END:variables

    public void populateupcomingAppointments() {
   DefaultTableModel model = (DefaultTableModel) tblpastapp.getModel();
   ArrayList<CounselorAppointment> temp=new ArrayList();
        try {
             temp=c.getCounselorSchedule().getCounselorAppointments();
        
        } catch (Exception e) {
            return;
        }
   model.setRowCount(0);
        for(int i=0;i<temp.size();i++)
    {
        if(temp.get(i).getDate().isAfter(LocalDate.now())){
                Object row[] = new Object[2];
                row[0] = temp.get(i).getPatient();
                row[1] = temp.get(i).getDate();
                model.addRow(row);
    
        }   
      }   
    }
}
