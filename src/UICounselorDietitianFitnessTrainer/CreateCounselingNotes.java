/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UICounselorDietitianFitnessTrainer;

import Counselor.Counselor;
import Counselor.CounselorAppointment;
import EcoSystem.EcoSystem;
import FitnessTrainer.FitnessTrainerAppointment;
import Patient.Patient;
import Utils.FieldsDecorator;
import VitalSign.VitalSigns;
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
public class CreateCounselingNotes extends javax.swing.JPanel {
Counselor c;
JPanel WorkArea;
EcoSystem system;
Patient p ;
CounselorAppointment app;
    /**
     * Creates new form CreatCounselingNotes
     */
    public CreateCounselingNotes(JPanel WorkArea,EcoSystem system,Counselor c,Patient p,CounselorAppointment app) {
        initComponents();
        this.setSize(1100, 850);
        this.WorkArea=WorkArea;
        this.system=system;
        this.p=p;
        this.c=c;
        this.app=app;
      FieldsDecorator.decorateTable(tblVitalSign);
        
      for(CounselorAppointment c1 :c.getCounselorSchedule().getCounselorAppointments()){
      jLabel7.setText(c1.getCheifcomplaints());
      jLabel5.setText(c1.getPatientMedication());
      jLabel3.setText(c1.getPastmentalhealth());
      }
        showmostrecentVitalSign();
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
        tblVitalSign = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmeal1 = new javax.swing.JEditorPane();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVitalSign.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Recorded Date", "Blood Pressure Range", "Heart Rate", "Resipiratory Rate", "Weight"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVitalSign);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 128, 863, 120));

        txtmeal1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(txtmeal1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 510, 141));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 40, 32, 29));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/notes.png"))); // NOI18N
        jLabel2.setText("Counseling Notes");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 477, -1, 31));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/add.png"))); // NOI18N
        jButton1.setText("Add ");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 640, -1, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-complaint-30.png"))); // NOI18N
        jLabel1.setText("Chief Complaint");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 307, -1, 27));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel3.setOpaque(true);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 307, 505, 27));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/medication.png"))); // NOI18N
        jLabel4.setText("Medication");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 362, 161, 27));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 362, 505, 27));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-meditation-30.png"))); // NOI18N
        jLabel6.setText("Mental Health History");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 418, -1, 27));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 418, 505, 27));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Add Counceling Notes:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WorkArea.remove(this);
        Component[] componentArray = WorkArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DietitianDashboard d=(DietitianDashboard)component;
        d.populateupcomingAppointments();
        CardLayout layout = (CardLayout)WorkArea.getLayout();
        layout.previous(WorkArea);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        c.addCounsellingNote(p,txtmeal1.getText());
        app.setDone(Boolean.TRUE);
        JOptionPane.showMessageDialog(this, "Counselling Note has been Created for  "+p.getPatientDetails().getFullName());
        WorkArea.remove(this);
        Component[] componentArray = WorkArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CounselorDashboard d=(CounselorDashboard)component;
        d.populateupcomingAppointments();
        CardLayout layout = (CardLayout)WorkArea.getLayout();
        layout.previous(WorkArea);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblVitalSign;
    private javax.swing.JEditorPane txtmeal1;
    // End of variables declaration//GEN-END:variables

 private void showmostrecentVitalSign() {
 DefaultTableModel model = (DefaultTableModel) tblVitalSign.getModel();
 
 
 
     try {
          VitalSigns temp=p.getMostRecentVitalSigns(); 
 model.setRowCount(0);       
 Object row[] = new Object[5];
                row[0] = temp.getDateForVitalSigns();
                row[1] = temp.getBloodPressure();
                row[2] = temp.getHeartRate();
                row[3] = temp.getRespiratoryRate();
                row[4] = temp.getWeight();
                model.addRow(row);
     } catch (Exception e) {
         JOptionPane.showMessageDialog(this, "Patient has not entered his vital signs ");
         return;
     }
 }
}
