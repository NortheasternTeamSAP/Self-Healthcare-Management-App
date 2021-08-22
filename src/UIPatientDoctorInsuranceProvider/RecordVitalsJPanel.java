/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import EcoSystem.EcoSystem;
import Patient.Patient;
import SysAdminUI.MainJFrame;
import Utils.FieldsValidator;
import Utils.NextScreen;
import VitalSign.Range;
import VitalSign.VitalSigns;
import java.awt.CardLayout;
import java.awt.Color;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeriesCollection;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Ankur Bywar
 */
public class RecordVitalsJPanel extends javax.swing.JPanel implements NextScreen {
    JPanel WorkAreaPanel;
    Patient patient;
    MainJFrame mainJFrame;
    EcoSystem ecoSystem;
    
    
    /**
     * Creates new form RecordVitalsJPanel
     */
    public RecordVitalsJPanel(JPanel WorkAreaPanel, EcoSystem ecoSystem, Patient patient) {
        initComponents();
        this.WorkAreaPanel = WorkAreaPanel;
        this.patient = patient;
        this.ecoSystem = ecoSystem;
        jDateOfVitalSign.setMaxSelectableDate(Date.from(Instant.now()));
        lblPatientNamePlaceholder.setText("Patient Name: " + patient.getPersonDetails().getFullName());
        displayPersonDetail();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooserBeanInfo1 = new com.toedter.calendar.JDateChooserBeanInfo();
        dateChooserPanel1 = new com.toedter.calendar.demo.DateChooserPanel();
        lineBorder1 = new org.jfree.chart.block.LineBorder();
        jPanel1 = new javax.swing.JPanel();
        txtLowBp = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        lblWeight = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtHeartRate = new javax.swing.JTextField();
        txtRespirtoryRate = new javax.swing.JTextField();
        txtHighBp = new javax.swing.JTextField();
        lblRespRate = new javax.swing.JLabel();
        lblHeartRate = new javax.swing.JLabel();
        lblWeight1 = new javax.swing.JLabel();
        lblWeight2 = new javax.swing.JLabel();
        lblBloodPressure = new javax.swing.JLabel();
        lblPatientNamePlaceholder = new javax.swing.JLabel();
        lblTittle = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jDateOfVitalSign = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        lblWeight3 = new javax.swing.JLabel();
        lblWeight4 = new javax.swing.JLabel();
        lblWeight5 = new javax.swing.JLabel();
        lblWeight6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnBarGraph = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        txtLowBp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLowBpActionPerformed(evt);
            }
        });

        lblWeight.setText("Weight:");

        btnBack.setBackground(new java.awt.Color(255, 204, 204));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtHighBp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHighBpActionPerformed(evt);
            }
        });

        lblRespRate.setText("Respiratory Rate:");

        lblHeartRate.setText("Heart Rate:");

        lblWeight1.setText("kgs");

        lblWeight2.setText("-");

        lblBloodPressure.setText("Blood Pressure:");

        lblPatientNamePlaceholder.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPatientNamePlaceholder.setText("Patient: <patient_placeholder>");

        lblTittle.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lblTittle.setText("Patient's Vital Signs Collection");

        lblDate.setText("Date of vital sign :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        lblWeight3.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblWeight3.setText("*between 1 to 200 ");

        lblWeight4.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblWeight4.setText("*non-zero and <250 ");

        lblWeight5.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblWeight5.setText("*non-zero and <250 ");

        lblWeight6.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblWeight6.setText("*non-zero and <250 ");

        btnSave.setBackground(new java.awt.Color(204, 255, 204));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBarGraph.setBackground(new java.awt.Color(204, 255, 204));
        btnBarGraph.setText("Bar Graph");
        btnBarGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarGraphActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"infant", "120-60", ">4"},
                {"toddler", "80-140", "5-6"},
                {"preschool", "80-130", "7-10"},
                {"school", "70-110", "11-16"},
                {"adolescent", "55-105", "<16"}
            },
            new String [] {
                "Meaning", "BP", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"infant", "120-60", ">4"},
                {"toddler", "80-140", "5-6"},
                {"preschool", "80-130", "7-10"},
                {"school", "70-110", "11-16"},
                {"adolescent", "55-105", "<16"}
            },
            new String [] {
                "Meaning", "BP", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"infant", "120-60", ">4"},
                {"toddler", "80-140", "5-6"},
                {"preschool", "80-130", "7-10"},
                {"school", "70-110", "11-16"},
                {"adolescent", "55-105", "<16"}
            },
            new String [] {
                "Meaning", "BP", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"infant", "120-60", ">4"},
                {"toddler", "80-140", "5-6"},
                {"preschool", "80-130", "7-10"},
                {"school", "70-110", "11-16"},
                {"adolescent", "55-105", "<16"}
            },
            new String [] {
                "Meaning", "BP", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBack))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPatientNamePlaceholder, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDate)
                                .addGap(78, 78, 78)
                                .addComponent(jDateOfVitalSign, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnBarGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblWeight)
                                    .addComponent(lblRespRate)
                                    .addComponent(lblHeartRate)
                                    .addComponent(lblBloodPressure))
                                .addGap(126, 126, 126)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtLowBp, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblWeight2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHighBp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblWeight4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblWeight1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblWeight3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtRespirtoryRate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblWeight5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtHeartRate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblWeight6)))))))
                .addContainerGap(414, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(307, 307, 307)
                    .addComponent(lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(194, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(63, 63, 63)
                .addComponent(lblPatientNamePlaceholder)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeight1)
                    .addComponent(lblWeight3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBloodPressure)
                    .addComponent(txtLowBp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHighBp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeight2)
                    .addComponent(lblWeight4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRespRate)
                    .addComponent(txtRespirtoryRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeight5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeartRate)
                    .addComponent(txtHeartRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWeight6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate)
                    .addComponent(jDateOfVitalSign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBarGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(427, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(lblTittle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(566, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1109, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1122, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtLowBpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLowBpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLowBpActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        nextScreen(WorkAreaPanel, new PatientVitalsHistoryPanel(WorkAreaPanel, ecoSystem, patient), "PatientVitalsHistoryPanel");
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtHighBpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHighBpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHighBpActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        FieldsValidator fieldsValidator = new FieldsValidator();
        boolean error = 
                fieldsValidator.validate(jDateOfVitalSign) | 
                fieldsValidator.validateLong(txtWeight, 1, 200) |
                fieldsValidator.validateLong(txtLowBp, 1, 250) |
                fieldsValidator.validateLong(txtHighBp, 1, 250) |
                fieldsValidator.validateLong(txtHeartRate, 1, 250) |
                fieldsValidator.validateLong(txtRespirtoryRate, 1, 250);
        
        if (error) {
            JOptionPane.showMessageDialog(jPanel1, "There are error in some field(s). Please correct them.");
            return;
        }
        
        Date vsDate = jDateOfVitalSign.getDate();
        String weight = txtWeight.getText();
        String lowBp = txtLowBp.getText();
        String highBp = txtHighBp.getText();
        String hr = txtHeartRate.getText();
        String rr = txtRespirtoryRate.getText();

        
        VitalSigns vs = new VitalSigns();
        vs.setWeight(Integer.valueOf(weight));
        vs.setBloodPressure(new Range(Double.valueOf(lowBp), Double.valueOf(highBp)));
        vs.setHeartRate(Integer.valueOf(hr));
        vs.setRespiratoryRate(Integer.valueOf(rr));
        vs.setDateForVitalSigns(LocalDate.ofInstant(vsDate.toInstant(), ZoneId.systemDefault()));
        
        patient.addNewVitalSign(vs);
        btnSave.setEnabled(false);
        JOptionPane.showMessageDialog(jPanel1, "Vital signs recorded"); 
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBarGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarGraphActionPerformed
        // TODO add your handling code here:
        
       String chartTitle = "Record Vital Signs";
       String CategoryAxisLabel = "Vital Signs";
       String ValueAxisLabel  = "Ranges";
       String lowBp = txtLowBp.getText();
       String HighBp = txtHighBp.getText();
       String heartRate = txtHeartRate.getText();
       String respiratoryRate = txtRespirtoryRate.getText();
       String weight = txtWeight.getText();
   
       //XYSeriesCollection dataset = new XYSeriesCollection();
         
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
       
        dcd.setValue(new Integer(weight), "values" , "weight" );
        dcd.setValue(new Integer(lowBp) , "values" , "lowBp");
        dcd.setValue(new Integer(HighBp) , "values" , "highBp");
        dcd.setValue(new Integer(respiratoryRate) , "values" , "respiratoryRate");
        dcd.setValue(new Integer(heartRate) , "values" , "heatrate");
        dcd.setValue(new Integer(respiratoryRate) , "values" , "respiratoryRate");
       
        JFreeChart jchart = ChartFactory.createBarChart3D("Record Vitals", "Vital sign", "Ranges", dcd, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartFrame cf = new ChartFrame("Vital sign", jchart, true);
        cf.setVisible(true);
        cf.setSize(500, 400);
        ChartPanel cp = new ChartPanel(jchart);
        jPanel3.removeAll();
        jPanel3.add(cp);
        jPanel3.updateUI();
        
        

        
    }//GEN-LAST:event_btnBarGraphActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBarGraph;
    private javax.swing.JButton btnSave;
    private com.toedter.calendar.demo.DateChooserPanel dateChooserPanel1;
    private com.toedter.calendar.JDateChooserBeanInfo jDateChooserBeanInfo1;
    private com.toedter.calendar.JDateChooser jDateOfVitalSign;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JLabel lblBloodPressure;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblHeartRate;
    private javax.swing.JLabel lblPatientNamePlaceholder;
    private javax.swing.JLabel lblRespRate;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel lblWeight1;
    private javax.swing.JLabel lblWeight2;
    private javax.swing.JLabel lblWeight3;
    private javax.swing.JLabel lblWeight4;
    private javax.swing.JLabel lblWeight5;
    private javax.swing.JLabel lblWeight6;
    private org.jfree.chart.block.LineBorder lineBorder1;
    private javax.swing.JTextField txtHeartRate;
    private javax.swing.JTextField txtHighBp;
    private javax.swing.JTextField txtLowBp;
    private javax.swing.JTextField txtRespirtoryRate;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables

    
    private void displayPersonDetail() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
