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
        this.setSize(1100, 850);
        
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/calendar.png"))); // NOI18N
        jButton1.setText("View Past Appointment");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, 30));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/add.png"))); // NOI18N
        jButton3.setText("Add Counselling Notes");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 424, 190, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 20, -1, -1));

        tblpastapp.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblpastapp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Upcoming Appointment Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblpastapp);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 144, 923, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Counselor Dashboard:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 82, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1100, 850));
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
        CounselorAppointment app= (CounselorAppointment) tblpastapp.getValueAt(row, 1);
        CreateCounselingNotes cp=new CreateCounselingNotes(WorkArea,system,c,p,app);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
        if(temp.get(i).getDate().isAfter(LocalDate.now())&& temp.get(i).getDone()==false){
                Object row[] = new Object[2];
                row[0] = temp.get(i).getPatient();
                row[1] = temp.get(i);
                model.addRow(row);
    
        }   
      }   
    }
}
