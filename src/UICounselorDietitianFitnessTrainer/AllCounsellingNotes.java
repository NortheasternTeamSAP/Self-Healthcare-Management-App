/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UICounselorDietitianFitnessTrainer;

import Counselor.CounsellingNote;
import Dietitian.DietPlan;
import EcoSystem.EcoSystem;
import FitnessTrainer.FitnessPlan;
import Patient.Patient;
import Utils.FieldsDecorator;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preet
 */
public class AllCounsellingNotes extends javax.swing.JPanel {
JPanel WorkArea;
EcoSystem system;
Patient p;
    /**
     * Creates new form AllCounsellingNotes
     */
    public AllCounsellingNotes(JPanel WorkArea,EcoSystem system,Patient p) {
        initComponents();
        this.setSize(1100, 850);
         this.WorkArea=WorkArea;
        this.system=system;
        this.p=p;
        FieldsDecorator.decorateTable(counselnote);
        
        
        DefaultTableModel model = (DefaultTableModel) counselnote.getModel();
        ArrayList<CounsellingNote> temp=p.getCounsellingNotes();
        model.setRowCount(0);
        
        for(int i=0;i<temp.size();i++)
    {
                Object row[] = new Object[1];
                row[0] = temp.get(i);
                model.addRow(row);
    
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

        jScrollPane1 = new javax.swing.JScrollPane();
        counselnote = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        counselnote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "All Counseling Notes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(counselnote);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 173, 903, 437));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/view_notes.png"))); // NOI18N
        jButton1.setText("View Counseling Notes");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 616, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 25, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Counseling Notes:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 104, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 860));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = counselnote.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a Counselling Note from the Table", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        CounsellingNote fp = (CounsellingNote)counselnote.getValueAt(row, 0);
        PatientConfidentiality ls= new PatientConfidentiality(WorkArea,system,p,fp);
        WorkArea.add("PatientConfidentiality",ls);
        CardLayout layout= (CardLayout)WorkArea.getLayout();
        layout.next(WorkArea);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WorkArea.remove(this);
        Component[] componentArray = WorkArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
         CardLayout layout = (CardLayout)WorkArea.getLayout();
        layout.previous(WorkArea);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable counselnote;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
