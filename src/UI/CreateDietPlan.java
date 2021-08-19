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
import VitalSign.VitalSigns;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preet
 */
public class CreateDietPlan extends javax.swing.JPanel {
JPanel WorkArea;
EcoSystem system;
Dietitian d;
Patient p;
DietitianAppointment app;
    /**
    /**
     * Creates new form CreateMealPlan
     */
    public CreateDietPlan(JPanel WorkArea,EcoSystem system,Dietitian d,Patient p,DietitianAppointment app) {
      initComponents();
      this.setSize(1100,850);
      this.WorkArea=WorkArea;
      this.system=system;
      this.d=d;
      this.app=app;
      this.p=p;
      lblPatientname.setText(p.getPatientDetails().getFullName());
     

      for(DietitianAppointment f1 :d.getDietitianSchedule().getDietitianAppointments()){
      jLabel7.setText(f1.getRestriction());
      jLabel15.setText(f1.getPatientMedication());
      jLabel17.setText(f1.getCheifcomplaints());
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
        jScrollPane3 = new javax.swing.JScrollPane();
        txtmeal4 = new javax.swing.JEditorPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtmeal2 = new javax.swing.JEditorPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtmeal7 = new javax.swing.JEditorPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtmeal3 = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblPatientname = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtmeal6 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtmeal5 = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVitalSign.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recorded Date", "Blood Pressure Range", "Heart Rate", "Respiratory Rate", "Weight"
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 850, 70));

        jScrollPane2.setViewportView(txtmeal1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 445, 60));

        jScrollPane3.setViewportView(txtmeal4);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 445, 60));

        jScrollPane4.setViewportView(txtmeal2);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 445, 52));

        jScrollPane5.setViewportView(txtmeal7);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 730, 450, 60));

        jScrollPane6.setViewportView(txtmeal3);

        add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 445, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/day1.png"))); // NOI18N
        jLabel2.setText("Day 1:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 80, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/day4.png"))); // NOI18N
        jLabel8.setText("Day 4:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 80, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/day2.png"))); // NOI18N
        jLabel9.setText("Day 2:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 80, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/day3.png"))); // NOI18N
        jLabel10.setText("Day 3:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 80, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/day7.png"))); // NOI18N
        jLabel11.setText("Day 7:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 740, 80, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/day5.png"))); // NOI18N
        jLabel12.setText("Day 5:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 80, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/day6.png"))); // NOI18N
        jLabel13.setText("Day 6:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 670, 80, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/create_meal.png"))); // NOI18N
        jButton1.setText("Create Meal  Plan");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 800, 180, 40));

        lblPatientname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        add(lblPatientname, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 25, 242, 30));

        add(lblPatientname, new org.netbeans.lib.awtextra.AbsoluteConstraints(787, 25, 242, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 30, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "% Diet Breakdown", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel1.setOpaque(false);

        jLabel3.setText("Carbohydrate :");

        jLabel4.setText("Protein:");

        jLabel5.setText("Fat:");

        jLabel6.setText("Fiber:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 630, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-complaint-30.png"))); // NOI18N
        jLabel1.setText("Chief Complaint");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 140, 27));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 430, 27));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/medication.png"))); // NOI18N
        jLabel14.setText("Medication");

        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 110, 27));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel15.setOpaque(true);
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 450, 27));

        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 430, 27));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-meditation-30.png"))); // NOI18N
        jLabel16.setText("Mental Health History");

        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 180, 30));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel17.setOpaque(true);
        
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 430, 27));


        txtmeal6.setColumns(20);
        txtmeal6.setRows(5);
        jScrollPane7.setViewportView(txtmeal6);

        add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 450, 56));

        txtmeal5.setColumns(20);
        txtmeal5.setRows(5);
        jScrollPane9.setViewportView(txtmeal5);

        add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 590, 450, 56));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel18.setText("Diet Plan for");

        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 30));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 850));
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

        int fatnum= Integer.parseInt(jTextField1.getText());
        int carbnum= Integer.parseInt(jTextField2.getText());
        int proteinnum= Integer.parseInt(jTextField3.getText());
        int fibernum= Integer.parseInt(jTextField4.getText());
        int totalnum= fatnum+carbnum+proteinnum+fibernum;

        if(totalnum!=100){
            JOptionPane.showMessageDialog(this, "% of balanced diet not adding to 100%", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ArrayList<String> mealplan =new ArrayList<>();
        mealplan.add(txtmeal1.getText());
        mealplan.add(txtmeal2.getText());
        mealplan.add(txtmeal3.getText());
        mealplan.add(txtmeal4.getText());
        mealplan.add(txtmeal5.getText());
        mealplan.add(txtmeal5.getText());
        mealplan.add(txtmeal7.getText());

        d.addDietPlan(p, mealplan,carbnum,fatnum,proteinnum,fibernum);
        app.setDone(Boolean.TRUE);

        JOptionPane.showMessageDialog(this, "Weekly Diet Plan has been Created for  " + p.getPatientDetails().getFullName(),"Info" ,JOptionPane.INFORMATION_MESSAGE);

        WorkArea.remove(this);
        Component[] componentArray = WorkArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DietitianDashboard d=(DietitianDashboard)component;
        d.populateupcomingAppointments();
        CardLayout layout = (CardLayout)WorkArea.getLayout();
        layout.previous(WorkArea);
    }//GEN-LAST:event_jButton1ActionPerformed
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
        JOptionPane.showMessageDialog(this, "Patient has not recorded his vitalSigns yet");
    }
 JOptionPane.showMessageDialog(this, "Patient has not recorded vitalSigns yet!" , "Info", JOptionPane.INFORMATION_MESSAGE);
 return;
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lblPatientname;
    private javax.swing.JTable tblVitalSign;
    private javax.swing.JEditorPane txtmeal1;
    private javax.swing.JEditorPane txtmeal2;
    private javax.swing.JEditorPane txtmeal3;
    private javax.swing.JEditorPane txtmeal4;
    private javax.swing.JTextArea txtmeal5;
    private javax.swing.JTextArea txtmeal6;
    private javax.swing.JEditorPane txtmeal7;
    // End of variables declaration//GEN-END:variables
}
