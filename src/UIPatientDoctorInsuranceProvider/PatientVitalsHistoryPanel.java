
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import EcoSystem.EcoSystem;
import Patient.Patient;
import Utils.GraphPlotterUtils;
import VitalSign.VitalSigns;
import java.awt.CardLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Ankur Bywar
 */
public class PatientVitalsHistoryPanel extends javax.swing.JPanel {
    JPanel WorkAreaPanel;
    Patient patient;
    JFrame mainJFrame;
    EcoSystem ecoSystem;
    /**
     * Creates new form DataOfPatientVitalSignJPanel
     */
    public PatientVitalsHistoryPanel(JPanel WorkAreaPanel, EcoSystem ecoSystem, Patient patient) {
        initComponents();
        this.WorkAreaPanel = WorkAreaPanel;
        this.patient = patient;
        this.ecoSystem = ecoSystem;
        populateVitalSignTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        levelRenderer1 = new org.jfree.chart.renderer.category.LevelRenderer();
        jDataOfPatientVitalSignPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientsEncounterHistory = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnLineChart = new javax.swing.JButton();

        jLabel1.setText("Data Of Patient Vital Sign");

        tblPatientsEncounterHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "vital sign collection Date", "Weight", "Blood Pressure", "Respiratory Rate", "Heart Rate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPatientsEncounterHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientsEncounterHistoryMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tblPatientsEncounterHistoryMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(tblPatientsEncounterHistory);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDataOfPatientVitalSignPanelLayout = new javax.swing.GroupLayout(jDataOfPatientVitalSignPanel);
        jDataOfPatientVitalSignPanel.setLayout(jDataOfPatientVitalSignPanelLayout);
        jDataOfPatientVitalSignPanelLayout.setHorizontalGroup(
            jDataOfPatientVitalSignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDataOfPatientVitalSignPanelLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jDataOfPatientVitalSignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDataOfPatientVitalSignPanelLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jDataOfPatientVitalSignPanelLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDataOfPatientVitalSignPanelLayout.setVerticalGroup(
            jDataOfPatientVitalSignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDataOfPatientVitalSignPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jDataOfPatientVitalSignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(120, 120, 120)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnLineChart.setText("Show Trend");
        btnLineChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineChartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDataOfPatientVitalSignPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(btnLineChart)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDataOfPatientVitalSignPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnLineChart)
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblPatientsEncounterHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientsEncounterHistoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPatientsEncounterHistoryMouseClicked

    private void tblPatientsEncounterHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientsEncounterHistoryMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPatientsEncounterHistoryMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    CardLayout layout = (CardLayout) WorkAreaPanel.getLayout();
    WorkAreaPanel.add("patientWorkAreaJPanel" , new PatientHomePagePanel(WorkAreaPanel, ecoSystem, patient));
   // WorkAreaPanel.add("patientWorkAreaJPanel", new PatientHomePagePanel(WorkAreaPanel, patient);
    layout.next(WorkAreaPanel);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLineChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineChartActionPerformed
        // TODO add your handling code here:

 

        List<VitalSigns> vitalSignsHistory = patient.getVitalSignsHistory();
        GraphPlotterUtils graphPlotterUtils = new GraphPlotterUtils();
        DefaultCategoryDataset dataset = 
                new PatientVitalSignHistoryHelper().createPatientVitalsSignsDefaultCategoryDataSet(graphPlotterUtils, vitalSignsHistory);
        graphPlotterUtils.createLineChart("Dateforvitals", "Ranges", "All vital Signs trend", "Vital sign", dataset, jPanel1);
    }//GEN-LAST:event_btnLineChartActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLineChart;
    private javax.swing.JPanel jDataOfPatientVitalSignPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jfree.chart.renderer.category.LevelRenderer levelRenderer1;
    private javax.swing.JTable tblPatientsEncounterHistory;
    // End of variables declaration//GEN-END:variables

    private void populateVitalSignTable() {
        
       
        
        DefaultTableModel  model = (DefaultTableModel) tblPatientsEncounterHistory.getModel();
        model.setRowCount(0);
        
        List<VitalSigns> vitalSigns = patient.getVitalSignsHistory();//patient.getEncounterHistory();
       // model.setRowCount(0);
        if ((vitalSigns == null) || vitalSigns.isEmpty()) {
      //  JOptionPane.showMessageDialog(jDataOfPatientVitalSignPanel, "No previous encounters found for patient " + patient.getPatientDetails().getFullName());
          return; 
       }
        for (VitalSigns vs : vitalSigns) {
            Object row[] = new Object[6];
            row[0] = patient.getPatientDetails().getFullName();
            row[1] = vs.getDateForVitalSigns();
            row[2] = vs.getWeight();
            row[3] = vs.getBloodPressure().getLow() + "-" + vs.getBloodPressure().getHigh();
            row[4] = vs.getRespiratoryRate();
            row[5] = vs.getHeartRate();
            model.addRow(row);
        }
    }
}