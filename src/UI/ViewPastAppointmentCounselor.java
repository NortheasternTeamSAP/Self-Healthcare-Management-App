/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Counselor.CounselorAppointment;
import EcoSystem.EcoSystem;
import FitnessTrainer.FitnessTrainerAppointment;
import java.awt.CardLayout;
import java.awt.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preet
 */
public class ViewPastAppointmentCounselor extends javax.swing.JPanel {
  JPanel WorkArea;
  EcoSystem system;
  ArrayList<CounselorAppointment> counselorAppointments;
  int flag=0;
    /**
     * Creates new form ViewPastAppointmentCounselor
     */
    public ViewPastAppointmentCounselor(JPanel WorkArea,EcoSystem system,ArrayList<CounselorAppointment> d,int flag) {
        initComponents();
        this.WorkArea=WorkArea;
        this.system=system;
        this.counselorAppointments=d;
        this.flag=flag;
        if(flag==1){  
        populatepastCounselorAppointment();
          }
        else {
       populatepastpaitentcounselorappointment();
      
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

        backp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpastAppointments = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        backp.setText("Back");
        backp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backpActionPerformed(evt);
            }
        });

        tblpastAppointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient Name", "Past Appointment Date"
            }
        ));
        jScrollPane1.setViewportView(tblpastAppointments);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("My Past Appointments");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(backp)))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(backp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backpActionPerformed

        if(flag==0){ WorkArea.remove(this);
            Component[] componentArray = WorkArea.getComponents();
            Component component = componentArray[componentArray.length - 1];
            CounselorDashboard panel = (CounselorDashboard) component;
            panel.populateupcomingAppointments();
            CardLayout layout = (CardLayout)WorkArea.getLayout();
            layout.previous(WorkArea);}

        else{
            WorkArea.remove(this);
            Component[] componentArray = WorkArea.getComponents();
            Component component = componentArray[componentArray.length - 1];
            PatientCounselorDashboard panel = (PatientCounselorDashboard) component;
            panel.populateUpcomingCounselorAppointments();
            CardLayout layout = (CardLayout)WorkArea.getLayout();
            layout.previous(WorkArea);}
    }//GEN-LAST:event_backpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblpastAppointments;
    // End of variables declaration//GEN-END:variables

    private void populatepastCounselorAppointment() {
 DefaultTableModel model = (DefaultTableModel) tblpastAppointments.getModel();
 ArrayList<CounselorAppointment> temp=new ArrayList();
 temp=counselorAppointments; 
 tblpastAppointments.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Counselor Name");
 model.setRowCount(0);       
        for(int i=0;i<temp.size();i++)
    {
        if(temp.get(i).getDate().isBefore(LocalDate.now()) || temp.get(i).getDone()==true){
       Object row[] = new Object[2];
                row[0] = temp.get(i).getCounselor().getPersonDetails().getFullName();
                row[1] = temp.get(i).getDate();
                model.addRow(row);
    }
    }       
    }

private void populatepastpaitentcounselorappointment() {
 DefaultTableModel model = (DefaultTableModel) tblpastAppointments.getModel();
 ArrayList<CounselorAppointment> temp=new ArrayList();
 temp=counselorAppointments; 
 model.setRowCount(0);       
        for(int i=0;i<temp.size();i++)
    {
        if(temp.get(i).getDate().isBefore(LocalDate.now()) || temp.get(i).getDone()==true){
         Object row[] = new Object[2];
                row[0] = temp.get(i).getPatient().getPatientDetails().getFullName();
                row[1] = temp.get(i).getDate();
                model.addRow(row);
    }
    }   
    }
}
