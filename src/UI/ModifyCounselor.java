/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Counselor.Counselor;

import EcoSystem.EcoSystem;
import Personnel.Address;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author preet
 */
public class ModifyCounselor extends javax.swing.JPanel {
 JPanel WorkArea;
 EcoSystem system;
 Counselor d;
    /**
     * Creates new form CreateCounselor
     */

        public ModifyCounselor(JPanel WorkArea,EcoSystem system,Counselor d) {
        initComponents();
        this.WorkArea=WorkArea;
        this.system=system;
        this.d=d;
        combogender1.setModel(new DefaultComboBoxModel(PersonDetails.Gender.values()));
        jLabel1.setText("Modify Counselor");
        jButton1.setText("Modify");
        txtname1.setText(d.getPersonDetails().getFullName());
        combogender1.setSelectedItem(d.getPersonDetails().getGender());
        Address addr =d.getPersonDetails().getAddress();
        txtadd1.setText(addr.getStreet());
        txtadd2.setText(addr.getApartment());
        txtadd3.setText(addr.getCity());
        txtadd4.setText(addr.getZipcode());
        txtadd6.setText(addr.getState());
        txtadd5.setText(addr.getCountry());
        txtphoneno.setText(d.getPersonDetails().getPhoneNumber());
        UserAccount us=d.getPersonDetails().getUserAccount();
        txtuname.setText(us.getUsername());
         txtpswd.setText(us.getPassword());
        LocalDate localDate=d.getPersonDetails().getDob();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        jDateChooser1.setDate(date);
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtpswd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        txtadd6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtadd1 = new javax.swing.JTextField();
        combogender1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtphoneno = new javax.swing.JTextField();
        txtname1 = new javax.swing.JTextField();
        txtadd4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtadd3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtadd2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtadd5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Update Mental Health Counselor");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 24, 390, 35));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/back.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 24, -1, -1));

        txtpswd.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtpswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 591, 202, 20));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("State :");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 355, 81, 22));

        txtuname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtuname, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 537, 208, -1));

        txtadd6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtadd6, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 352, 208, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Street:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 177, 81, 22));

        txtadd1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtadd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 174, 208, -1));

        combogender1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE", "OTHER" }));
        combogender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combogender1ActionPerformed(evt);
            }
        });
        add(combogender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 130, 208, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 650, -1, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Date of Birth :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 486, 112, 22));
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 486, 208, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Phone Number :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 440, 112, 22));
        add(txtphoneno, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 440, 208, -1));

        txtname1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtname1ActionPerformed(evt);
            }
        });
        add(txtname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 84, 208, -1));

        txtadd4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtadd4, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 394, 208, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("City:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 263, 81, 22));

        txtadd3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtadd3, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 260, 208, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Apartment:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 217, 81, 22));

        txtadd2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtadd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 214, 208, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Password:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 583, 112, 22));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Name :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 87, 81, 22));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("UserName:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 540, 112, 22));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Gender:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 132, 81, 22));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Zipcode :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 309, 81, 22));

        txtadd5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        add(txtadd5, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 306, 208, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Country:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 397, 81, 22));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 850));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        WorkArea.remove(this);
        Component[] componentArray = WorkArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CounselorDirectory dd=(CounselorDirectory)component;
        CardLayout layout = (CardLayout)WorkArea.getLayout();
        layout.previous(WorkArea);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void combogender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combogender1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combogender1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

           
                d.getPersonDetails().setFullName(txtname1.getText());
                LocalDate date =(LocalDate) jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                d.getPersonDetails().setDob(date);
                Gender gender =(Gender)combogender1.getSelectedItem();
                d.getPersonDetails().setGender(gender);
                d.getPersonDetails().setPhoneNumber(txtphoneno.getText());
                d.getPersonDetails().getUserAccount().setUsername(txtuname.getText());
                d.getPersonDetails().getUserAccount().setPassword(txtpswd.getText());
                Address addr= new Address(txtadd1.getText(),txtadd2.getText(),txtadd3.getText(),txtadd4.getText(),txtadd6.getText(),txtadd5.getText());
                d.getPersonDetails().setAddress(addr);
                JOptionPane.showMessageDialog(this, "Details have been Modified  : "+txtname1.getText());
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please add all details correctly ..");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtname1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combogender1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtadd1;
    private javax.swing.JTextField txtadd2;
    private javax.swing.JTextField txtadd3;
    private javax.swing.JTextField txtadd4;
    private javax.swing.JTextField txtadd5;
    private javax.swing.JTextField txtadd6;
    private javax.swing.JTextField txtname1;
    private javax.swing.JTextField txtphoneno;
    private javax.swing.JTextField txtpswd;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
