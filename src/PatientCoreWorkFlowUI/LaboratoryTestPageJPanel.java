/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientCoreWorkFlowUI;

import EcoSystem.EcoSystem;
import Laboratory.LaboratoryAssistant;
import Laboratory.LaboratoryTest;
import Laboratory.LaboratoryTest.TestType;
import Laboratory.LaboratoryTestReport;
import Patient.Patient;
import Utils.GraphPlotterUtils;
import Utils.NextScreen;
import java.awt.Color;
import static javax.swing.GroupLayout.Alignment.values;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
public class LaboratoryTestPageJPanel extends javax.swing.JPanel implements NextScreen {
    JPanel workAreaPanel;
    LaboratoryTestReport labTestReport;
    JPanel backPage;
    
    LaboratoryTest labTestResult;
    /**
     * Creates new form ViewMedicalLabTestResultJPanel
     */
    public LaboratoryTestPageJPanel(JPanel workAreaPanel, LaboratoryTestReport labTestReport, JPanel backPage) {
        initComponents();
        this.workAreaPanel = workAreaPanel;
        this.labTestReport = labTestReport;
        this.backPage = backPage;
        labTestResult = null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        defaultCategoryDataset1 = new org.jfree.data.category.DefaultCategoryDataset();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jTextFieldVitaminB12 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldHemoglobin = new javax.swing.JTextField();
        jTextFieldThyroid = new javax.swing.JTextField();
        jTextFieldVitaminD = new javax.swing.JTextField();
        jTextFieldBloodSugar = new javax.swing.JTextField();
        btnLabTestsSave = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnCompleteLabTest = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextLabTestCost = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnShowTrend = new javax.swing.JButton();

        jLabel1.setText("Laboratory Test Page");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Hemoglobin");

        jLabel3.setText("Thyroid");

        jLabel4.setText("Vitamin D");

        jLabel5.setText("Blood Sugar");

        jLabel6.setText("Vitamin B12");

        btnLabTestsSave.setText("Save");
        btnLabTestsSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLabTestsSaveActionPerformed(evt);
            }
        });

        jLabel7.setText("Add patient details (name, age, etc.) and Doctor details.");

        btnCompleteLabTest.setText("Finalize lab test");
        btnCompleteLabTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteLabTestActionPerformed(evt);
            }
        });

        jLabel8.setText("Lab Test Cost");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        btnShowTrend.setText("Show Trend");
        btnShowTrend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTrendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTextLabTestCost, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(btnShowTrend)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldHemoglobin, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldVitaminD, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(34, 34, 34)
                                        .addComponent(jTextFieldThyroid, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldVitaminB12, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBloodSugar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLabTestsSave, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCompleteLabTest, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 191, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldHemoglobin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldThyroid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVitaminD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVitaminB12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBloodSugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextLabTestCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLabTestsSave)
                    .addComponent(btnCompleteLabTest))
                .addGap(47, 47, 47)
                .addComponent(btnShowTrend)
                .addGap(51, 51, 51)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        nextScreen(workAreaPanel, backPage, "LabAssistantHomePage");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLabTestsSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLabTestsSaveActionPerformed
        // TODO add your handling code here:
        
        double bloodSugar = Double.parseDouble(jTextFieldBloodSugar.getText());
        double hemoglobin = Double.parseDouble(jTextFieldHemoglobin.getText());
        double thyroid = Double.parseDouble(jTextFieldThyroid.getText());
        double vitaminD = Double.parseDouble(jTextFieldVitaminD.getText());
        double vitaminB12 = Double.parseDouble(jTextFieldVitaminB12.getText());
        double labTestCost = Double.parseDouble(jTextLabTestCost.getText());
        
        labTestResult = new LaboratoryTest();
        labTestResult.add(TestType.BLOOD_SUGAR, bloodSugar);
        labTestResult.add(TestType.HEMOGLOBIN, hemoglobin);
        labTestResult.add(TestType.THYROID, thyroid);
        labTestResult.add(TestType.VITAMIN_D, vitaminD);
        labTestResult.add(TestType.VITAMIN_B12, vitaminB12);
        labTestReport.setLabTestCost(labTestCost);
    }//GEN-LAST:event_btnLabTestsSaveActionPerformed

    private void btnCompleteLabTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteLabTestActionPerformed
        // TODO add your handling code here:
        if (labTestResult == null) {
           JOptionPane.showMessageDialog(null,"Please enter lab test results or press back to return.", "Warning", JOptionPane.WARNING_MESSAGE );
           return;
        }

        labTestReport.setLaboratoryTestResult(labTestResult);
        LaboratoryAssistant labAssistant = labTestReport.getLabAssistant();
        labAssistant.finishLabTest(labTestReport);
        ((LaboratoryAssistantHomePagePanel)backPage).reload();
        
        btnLabTestsSave.setEnabled(false);
        btnCompleteLabTest.setEnabled(false);
        JOptionPane.showMessageDialog(null,"Lab Tests Results Saved.", "Information", JOptionPane.INFORMATION_MESSAGE );
    }//GEN-LAST:event_btnCompleteLabTestActionPerformed

    private void btnShowTrendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTrendActionPerformed
        // TODO add your handling code here:
       String Hemoglobin = jTextFieldHemoglobin.getText();
       String Thyroid = jTextFieldThyroid.getText();
       String VitaminD = jTextFieldVitaminD.getText();
       String VitaminB12 = jTextFieldVitaminB12.getText();
       String BloodSugar = jTextFieldBloodSugar.getText();
       DefaultCategoryDataset dcd = new DefaultCategoryDataset();
       GraphPlotterUtils graphPlotterUtils = new GraphPlotterUtils();
       dcd.setValue(new Integer(Hemoglobin), "values", "hemoglobin");
       dcd.setValue(new Integer(Thyroid), "values", "thyroid");
       dcd.setValue(new Integer(VitaminD), "values", "VitaminD");
       dcd.setValue(new Integer(VitaminB12), "values", "VitaminB12");
       dcd.setValue(new Integer(BloodSugar), "values", "BloodSugar");
       graphPlotterUtils.createBarChart3D("lab tests", "Ranges", "All lab tests trends", "lab test", dcd, jPanel2);
       //graphPlotterUtils.addToDataSet(values, VitaminD, dcd);
       
       
       
       
   
     
         
//        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
//       
//        dcd.setValue(new Integer(weight), "values" , "weight" );
//        dcd.setValue(new Integer(lowBp) , "values" , "lowBp");
//        dcd.setValue(new Integer(HighBp) , "values" , "highBp");
//        dcd.setValue(new Integer(respiratoryRate) , "values" , "respiratoryRate");
//        dcd.setValue(new Integer(heartRate) , "values" , "heatrate");
//        dcd.setValue(new Integer(respiratoryRate) , "values" , "respiratoryRate");
//       
//        JFreeChart jchart = ChartFactory.createBarChart3D("Record Vitals", "Vital sign", "Ranges", dcd, PlotOrientation.VERTICAL, true, true, false);
//        CategoryPlot plot = jchart.getCategoryPlot();
//        plot.setRangeGridlinePaint(Color.black);
//        ChartFrame cf = new ChartFrame("Vital sign", jchart, true);
//        cf.setVisible(true);
//        cf.setSize(500, 400);
//        ChartPanel cp = new ChartPanel(jchart);
//        jPanel2.removeAll();
//        jPanel2.add(cp);
//        jPanel2.updateUI();
        
    }//GEN-LAST:event_btnShowTrendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCompleteLabTest;
    private javax.swing.JButton btnLabTestsSave;
    private javax.swing.JButton btnShowTrend;
    private org.jfree.data.category.DefaultCategoryDataset defaultCategoryDataset1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldBloodSugar;
    private javax.swing.JTextField jTextFieldHemoglobin;
    private javax.swing.JTextField jTextFieldThyroid;
    private javax.swing.JTextField jTextFieldVitaminB12;
    private javax.swing.JTextField jTextFieldVitaminD;
    private javax.swing.JTextField jTextLabTestCost;
    // End of variables declaration//GEN-END:variables
}
