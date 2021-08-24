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
        this.setSize(1100,850);
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
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLowBp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLowBpActionPerformed(evt);
            }
        });
        jPanel1.add(txtLowBp, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 146, 51, -1));
        jPanel1.add(txtWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 118, 142, -1));

        lblWeight.setText("Weight:");
        jPanel1.add(lblWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 124, -1, -1));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 26, -1, -1));
        jPanel1.add(txtHeartRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 220, 142, -1));
        jPanel1.add(txtRespirtoryRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 180, 142, -1));

        txtHighBp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHighBpActionPerformed(evt);
            }
        });
        jPanel1.add(txtHighBp, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 146, 51, -1));

        lblRespRate.setText("Respiratory Rate:");
        jPanel1.add(lblRespRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 186, -1, -1));

        lblHeartRate.setText("Heart Rate:");
        jPanel1.add(lblHeartRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 226, -1, -1));

        lblWeight1.setText("kgs");
        jPanel1.add(lblWeight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 124, -1, -1));

        lblWeight2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblWeight2.setText("--");
        jPanel1.add(lblWeight2, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 149, 16, -1));

        lblBloodPressure.setText("Blood Pressure:");
        jPanel1.add(lblBloodPressure, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 152, -1, -1));

        lblPatientNamePlaceholder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPatientNamePlaceholder.setText("Patient: <patient_placeholder>");
        jPanel1.add(lblPatientNamePlaceholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 86, 442, -1));

        lblTittle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTittle.setText("Patient's Self Vital Signs Collection");
        jPanel1.add(lblTittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 26, 510, 42));

        lblDate.setText("Date of vital sign:");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));
        jPanel1.add(jDateOfVitalSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 260, 142, -1));

        jPanel3.setOpaque(false);

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, -1, -1));

        lblWeight3.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblWeight3.setText("*between 1 to 200 ");
        jPanel1.add(lblWeight3, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 128, -1, -1));

        lblWeight4.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblWeight4.setText("*non-zero and <250 ");
        jPanel1.add(lblWeight4, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 156, -1, -1));

        lblWeight5.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblWeight5.setText("*non-zero and <250 ");
        jPanel1.add(lblWeight5, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 190, -1, -1));

        lblWeight6.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblWeight6.setText("*non-zero and <250 ");
        jPanel1.add(lblWeight6, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 230, -1, -1));

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 240, 40));

        btnBarGraph.setBackground(new java.awt.Color(255, 255, 255));
        btnBarGraph.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnBarGraph.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-graph-report-30.png"))); // NOI18N
        btnBarGraph.setText("Bar Graph");
        btnBarGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarGraphActionPerformed(evt);
            }
        });
        jPanel1.add(btnBarGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 363, 240, 40));

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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 428, 217, 105));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 428, 217, 105));

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

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 563, 217, 105));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 563, 217, 105));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1100, 850));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1101, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
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
