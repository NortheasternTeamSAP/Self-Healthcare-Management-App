/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SysAdminUI;

import Counselor.Counselor;
import DB4OUtil.DB4OUtil;
import DataStore.GenericDirectory;
import DataStore.GlobalUserDirectory;
import Dietitian.Dietitian;
import EcoSystem.EcoSystem;
import FitnessTrainer.FitnessTrainer;
import UIPatientDoctorInsuranceProvider.PatientHomePagePanel;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ankur Bywar
 */
public class MainJFrame extends javax.swing.JFrame {

   public EcoSystem system;
   DB4OUtil dB4OUtil;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
        this.setSize(1100,850);
        this.setResizable(false);
        this.setTitle("Health Springs Self Health Management Application");
        dB4OUtil = DB4OUtil.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WorkArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        WorkArea.setLayout(new java.awt.CardLayout());
        getContentPane().add(WorkArea, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */


        /* Create and display the form */
        MainJFrame mjf = new MainJFrame();
        mjf.system = mjf.dB4OUtil.retrieveSystem();
        
        mjf.addWindowListener(new WindowAdapter() {
            MainJFrame main;
            public void windowClosing(WindowEvent e) {
                System.out.println("Storing Ecosystem in database");
                main.dB4OUtil.storeSystem(main.system);
            }
            
            private WindowAdapter init(MainJFrame main) {
                this.main = main;
                return this;
            }
            
        }.init(mjf));
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mjf.setVisible(true);
                mjf.login(mjf.WorkArea, mjf.system);
            }
        });
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel WorkArea;
    // End of variables declaration//GEN-END:variables

    private void login(JPanel workArea, EcoSystem ecoSystem) {
        Login ls= new Login(workArea, ecoSystem);
        workArea.add("Login",ls);
        CardLayout layout= (CardLayout)workArea.getLayout();
        layout.next(workArea);  
    }

  
}
