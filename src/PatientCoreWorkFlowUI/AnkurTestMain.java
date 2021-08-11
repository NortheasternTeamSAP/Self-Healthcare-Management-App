/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientCoreWorkFlowUI;

import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Patient.Patient;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.UserAccount;
import Utils.NextScreen;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Ankur Bywar
 */
public class AnkurTestMain extends javax.swing.JFrame implements NextScreen {

    EcoSystem ecosystem;
    
    /**
     * Creates new form AnkurTestMain
     */
    public AnkurTestMain() {
        initComponents();
        
        this.ecosystem = new EcoSystem();
        
        // Create temporary patient and doctor
        Person p1 = new Patient("Anurag Katey", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("(06 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("anurag", "anurag"));
        this.ecosystem.globalUserDirectory.createNewUser(p1);
        
        Person p2 = new Patient("Ankur Bywar", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("(06 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("ankur", "ankur"));
        this.ecosystem.globalUserDirectory.createNewUser(p2);
        
        Person p3 = new Patient("Preeti Gopal", LocalDate.now().minusYears(29), PersonDetails.Gender.FEMALE,
                new Address("(06 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("preeti", "preeti"));
        this.ecosystem.globalUserDirectory.createNewUser(p3);
       
        Person d1 = new Doctor("Dr. Anaya Katey", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("(06 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("anaya", "anaya"));
        this.ecosystem.globalUserDirectory.createNewUser(d1);
        
        Person d2 = new Doctor("Dr. Sanjay Katey", LocalDate.now(), PersonDetails.Gender.MALE,
                new Address("(06 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("sanjay", "sanjay"));
        this.ecosystem.globalUserDirectory.createNewUser(d2);
        
        Person d3 = new Doctor("Dr. Sushama Katey", LocalDate.now(), PersonDetails.Gender.FEMALE,
                new Address("(06 Dexter Ane N", "L422", "Seattle", "98109", "WA", "USA"), "2132921728", null ,new UserAccount("sush", "sush"));
        this.ecosystem.globalUserDirectory.createNewUser(d3);
        
        nextScreen(this, mainWorkArea, new PatientHomePagePanel(mainWorkArea, ecosystem, (Patient) p1), "PatientHomePagePanel");
        //nextScreen(this, mainWorkArea, new GeneratePatientBillJPanel(), "xxx");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWorkArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainWorkArea.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(220, Short.MAX_VALUE)
                    .addComponent(mainWorkArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(180, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(177, Short.MAX_VALUE)
                    .addComponent(mainWorkArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(123, Short.MAX_VALUE)))
        );

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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AnkurTestMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnkurTestMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnkurTestMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnkurTestMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnkurTestMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainWorkArea;
    // End of variables declaration//GEN-END:variables
}
