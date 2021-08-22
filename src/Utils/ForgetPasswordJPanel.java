/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import EcoSystem.EcoSystem;
import Personnel.Person;
import java.awt.Color;
import java.time.Instant;
import java.util.Date;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author mrs.katey
 */
public class ForgetPasswordJPanel extends javax.swing.JPanel {

    FieldsValidator fieldsValidator = new FieldsValidator();
    EcoSystem ecoSystem;
    ButtonGroup buttonGroup = new ButtonGroup();
    Random rnd = new Random();
    
    String sentOtp = null;
    
    Person selectedPerson;
    /**
     * Creates new form ForgetPasswordJPanel
     */
    public ForgetPasswordJPanel(EcoSystem ecoSystem) {
        initComponents();
        this.setSize(1100,850);
        this.ecoSystem = ecoSystem;
        
        buttonGroup.add(jRadioButtonSelectEmail);
        buttonGroup.add(jRadioButtonSelectMobileNumber);
        
        jTextFieldMobileNumberCountryCode.setEnabled(false);
        jRadioButtonSelectEmail.setEnabled(false);
        jRadioButtonSelectMobileNumber.setEnabled(false);
        
        jTextFieldEmailId.setEnabled(false);
        jTextFieldMobileNum.setEnabled(false);
        jButtonSendOTP.setEnabled(false);
        jTextFieldEnterOTP.setEnabled(false);
        jButtonCheckOTP.setEnabled(false);

        jTextFieldNewPassword.setEnabled(false);
        jTextConfirmPassword.setEnabled(false);
        jButtonResetPassword.setEnabled(false);
        
        jLabelUsernameCheck.setText("");
        jLabelOTPCheck.setText("");
        jLabelEmailIdCheck.setText("");
        jLabelPhoneNumberCheck.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jRadioButtonSelectEmail = new javax.swing.JRadioButton();
        jRadioButtonSelectMobileNumber = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelUsernameCheck = new javax.swing.JLabel();
        jTextFieldEnterOTP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonSendOTP = new javax.swing.JButton();
        jButtonCheckOTP = new javax.swing.JButton();
        jButtonCheckUserName1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelOTPCheck = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonResetPassword = new javax.swing.JButton();
        jTextFieldMobileNumberCountryCode = new javax.swing.JTextField();
        jTextFieldEmailId = new javax.swing.JTextField();
        jTextFieldMobileNum = new javax.swing.JTextField();
        jLabelPhoneNumberCheck = new javax.swing.JLabel();
        jLabelEmailIdCheck = new javax.swing.JLabel();
        jTextFieldNewPassword = new javax.swing.JPasswordField();
        jTextConfirmPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Password Reset Tool");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 32, 245, 40));

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Select Email OR Mobile number to receive a one time OPT to reset password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 136, -1, 25));

        jTextFieldUserName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldUserName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextFieldUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 154, 20));

        jRadioButtonSelectEmail.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jRadioButtonSelectEmail.setText("Email ");
        jRadioButtonSelectEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSelectEmailActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonSelectEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 178, -1, -1));

        jRadioButtonSelectMobileNumber.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jRadioButtonSelectMobileNumber.setText("Mobile number");
        jRadioButtonSelectMobileNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonSelectMobileNumberActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButtonSelectMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 218, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel3.setText("Enter the OTP received");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 295, 180, 24));

        jLabelUsernameCheck.setText("Verified!");
        jPanel1.add(jLabelUsernameCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 204, 24));

        jTextFieldEnterOTP.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldEnterOTP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextFieldEnterOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 293, 160, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel4.setText("Enter your username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 92, -1, 24));

        jButtonSendOTP.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSendOTP.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonSendOTP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/send_mail.png"))); // NOI18N
        jButtonSendOTP.setText("Send OTP");
        jButtonSendOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendOTPActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSendOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 140, 40));

        jButtonCheckOTP.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCheckOTP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-double-tick-30.png"))); // NOI18N
        jButtonCheckOTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckOTPActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCheckOTP, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 63, 30));

        jButtonCheckUserName1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonCheckUserName1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-double-tick-30.png"))); // NOI18N
        jButtonCheckUserName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckUserName1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCheckUserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 63, 30));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("Enter new Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 335, 170, 24));

        jLabelOTPCheck.setText("Verified!");
        jPanel1.add(jLabelOTPCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 465, 24));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setText("Confirm password");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 373, 170, 24));

        jButtonResetPassword.setBackground(new java.awt.Color(255, 255, 255));
        jButtonResetPassword.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonResetPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-password-reset-30.png"))); // NOI18N
        jButtonResetPassword.setText("Reset Password");
        jButtonResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonResetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 180, -1));

        jTextFieldMobileNumberCountryCode.setText("+1");
        jTextFieldMobileNumberCountryCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextFieldMobileNumberCountryCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 30, 20));

        jTextFieldEmailId.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldEmailId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextFieldEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 173, 160, -1));

        jTextFieldMobileNum.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldMobileNum.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextFieldMobileNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 223, 160, 20));

        jLabelPhoneNumberCheck.setText("Verified!");
        jPanel1.add(jLabelPhoneNumberCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 215, 234, 24));

        jLabelEmailIdCheck.setText("Verified!");
        jPanel1.add(jLabelEmailIdCheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 175, 233, 24));

        jTextFieldNewPassword.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextFieldNewPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextFieldNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 333, 160, -1));

        jTextConfirmPassword.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextConfirmPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jTextConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 373, 160, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, -4, 1100, 850));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonSelectEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSelectEmailActionPerformed
        // TODO add your handling code here:
        jTextFieldEmailId.setEnabled(true);
        jRadioButtonSelectEmail.setEnabled(true);
        jRadioButtonSelectMobileNumber.setEnabled(true);
        
         jButtonSendOTP.setEnabled(true);
        jLabelEmailIdCheck.setText("");
        jLabelPhoneNumberCheck.setText("");
        
        jTextFieldMobileNumberCountryCode.setEnabled(false);
        
        jTextFieldMobileNum.setEnabled(false);

        jButtonCheckOTP.setEnabled(false);
        jTextFieldEnterOTP.setEnabled(false);
        jButtonCheckOTP.setEnabled(false);

        jTextFieldNewPassword.setEnabled(false);
        jTextConfirmPassword.setEnabled(false);
        jButtonResetPassword.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonSelectEmailActionPerformed

    private void jRadioButtonSelectMobileNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonSelectMobileNumberActionPerformed
        // TODO add your handling code here:
        jTextFieldMobileNum.setEnabled(true);
        jRadioButtonSelectEmail.setEnabled(true);
        
         jButtonSendOTP.setEnabled(true);
        jLabelEmailIdCheck.setText("");
        jLabelPhoneNumberCheck.setText("");
        
        jTextFieldMobileNumberCountryCode.setEnabled(false);
        jRadioButtonSelectEmail.setEnabled(true);
        jRadioButtonSelectMobileNumber.setEnabled(true);
        
        jTextFieldEmailId.setEnabled(false);
        jButtonCheckOTP.setEnabled(false);
        jTextFieldEnterOTP.setEnabled(false);
        jButtonCheckOTP.setEnabled(false);

        jTextFieldNewPassword.setEnabled(false);
        jTextConfirmPassword.setEnabled(false);
        jButtonResetPassword.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonSelectMobileNumberActionPerformed

    private void jButtonCheckUserName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckUserName1ActionPerformed
        // TODO add your handling code here:
        jLabelUsernameCheck.setText("");
        jTextFieldMobileNum.setEnabled(false);
        jButtonSendOTP.setEnabled(false);
        jLabelEmailIdCheck.setText("");
        jLabelPhoneNumberCheck.setText("");
        
        jTextFieldMobileNumberCountryCode.setEnabled(false);
        jRadioButtonSelectEmail.setEnabled(false);
        jRadioButtonSelectMobileNumber.setEnabled(false);
        
        jTextFieldEmailId.setEnabled(false);
        jButtonCheckOTP.setEnabled(false);
        jTextFieldEnterOTP.setEnabled(false);
        jButtonCheckOTP.setEnabled(false);

        jTextFieldNewPassword.setEnabled(false);
        jTextConfirmPassword.setEnabled(false);
        jButtonResetPassword.setEnabled(false);
        
        String userName = jTextFieldUserName.getText();
        boolean error = fieldsValidator.validate(jTextFieldUserName);
        
        if (error) {
            setNotVerifiedLabel(jLabelUsernameCheck);
            return;
        }
        
        Person person = ecoSystem.globalUserDirectory.get(userName);
        if (person == null) {
            setNotVerifiedLabel(jLabelUsernameCheck);
            return;
        }
        
        selectedPerson = person;
        
        setVerifiedLabel(jLabelUsernameCheck);
        
        jRadioButtonSelectEmail.setEnabled(true);
        jRadioButtonSelectMobileNumber.setEnabled(true);
        jButtonSendOTP.setEnabled(true);
    }//GEN-LAST:event_jButtonCheckUserName1ActionPerformed

    private void jButtonSendOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendOTPActionPerformed
        // TODO add your handling code here:
        
        if (jRadioButtonSelectEmail.isSelected()) {
            boolean error = fieldsValidator.validateEmail(jTextFieldEmailId);
            boolean verifiedEmail = jTextFieldEmailId.getText().equals(selectedPerson.getPersonDetails().getEmailId());
            if (error || !verifiedEmail) {
                setNotVerifiedLabel(jLabelEmailIdCheck);
                return;
            }
            setVerifiedLabel(jLabelEmailIdCheck);
            jTextFieldEnterOTP.setEnabled(true);
            jButtonCheckOTP.setEnabled(true);
            sendOTPViaEmail();
            return;
        }
        
        if (jRadioButtonSelectMobileNumber.isSelected()) {
            boolean error = fieldsValidator.validate(jTextFieldMobileNum, 10);
            String phoneNumber = jTextFieldMobileNum.getText();
            boolean verifiedPhone = phoneNumber.equals(selectedPerson.getPersonDetails().getPhoneNumber());
            if (error || !verifiedPhone) {
                setNotVerifiedLabel(jLabelPhoneNumberCheck);
                return;
            }
            setVerifiedLabel(jLabelPhoneNumberCheck);
            jTextFieldEnterOTP.setEnabled(true);
            jButtonCheckOTP.setEnabled(true);
            sendOTPViaTextMessage();
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Select either email or mobile option to send OTP");
    }//GEN-LAST:event_jButtonSendOTPActionPerformed

    private void jButtonCheckOTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckOTPActionPerformed
        // TODO add your handling code here:
        
        String enteredOTP = jTextFieldEnterOTP.getText();
        if (!sentOtp.equals(enteredOTP)) {
            setNotVerifiedLabel(jLabelOTPCheck);
            return;
        } else {
            setVerifiedLabel(jLabelOTPCheck);
            jTextFieldNewPassword.setEnabled(true);
            jTextConfirmPassword.setEnabled(true);
            jButtonResetPassword.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonCheckOTPActionPerformed

    private void jButtonResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetPasswordActionPerformed
        // TODO add your handling code here:
        
        String enteredPassword = new String(jTextFieldNewPassword.getPassword());
        String confirmPassword = new String(jTextConfirmPassword.getPassword());
        System.out.println("enteredPassword = " + enteredPassword + "   confirmPassword = " + confirmPassword);
        if (StringUtils.isBlank(enteredPassword) || 
                StringUtils.isBlank(confirmPassword) ||
                !enteredPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Password mismatch. Try again");
            return;
        }
        
        
        selectedPerson.getPersonDetails().setPassword(enteredPassword);
        ecoSystem.globalUserDirectory.updateUser(selectedPerson);
        disableAllButtons();
        JOptionPane.showMessageDialog(null, "Password successfully updated");
        disableAllButtons();
        sendPasswordUpdateEmail();
    }//GEN-LAST:event_jButtonResetPasswordActionPerformed

    void disableAllButtons() {
        jTextFieldMobileNumberCountryCode.setEnabled(false);
        jRadioButtonSelectEmail.setEnabled(false);
        jRadioButtonSelectMobileNumber.setEnabled(false);
        
        jTextFieldUserName.setEnabled(false);
        jButtonCheckUserName1.setEnabled(false);
        jTextFieldEmailId.setEnabled(false);
        jTextFieldMobileNum.setEnabled(false);
        jButtonSendOTP.setEnabled(false);
        jButtonCheckOTP.setEnabled(false);
        jTextFieldEnterOTP.setEnabled(false);
        jButtonCheckOTP.setEnabled(false);

        jTextFieldNewPassword.setEnabled(false);
        jTextConfirmPassword.setEnabled(false);
        jButtonResetPassword.setEnabled(false);
    }
    
    void sendPasswordUpdateEmail() {
       boolean success = new EmailClient().sendEmail(
               selectedPerson.getPersonDetails().getEmailId(), 
               ecoSystem.getSysAdminEmail(), 
               ecoSystem.getSysAdmingEmailPassword(), 
               "Password successfully reset for Health Springs App", 
               getPassWordSuccessfullResetMessage());
    }
    
    String getPassWordSuccessfullResetMessage() {
        Date date = Date.from(Instant.now());
        return "Hi " + selectedPerson.getPersonDetails().getFullName() + "!\n" +
                "This is to inform you that your password has been successfully updated on " + date.toString() + " PST.\n" +
                "\n\n\n" +
                "Thank you,\n" + 
                "Health Springs App Team";
    }
    
    void setVerifiedLabel(JLabel label) {
        label.setText("Verified!");
        label.setForeground(Color.green);
    }
    
    void setNotVerifiedLabel(JLabel label) {
        label.setText("Unable to verify. Try again.");
        label.setForeground(Color.red);
    }
    
    void sendOTPViaEmail() {
      sentOtp = getRandomOPT();
       boolean success = new EmailClient().sendEmail(
               selectedPerson.getPersonDetails().getEmailId(), 
               ecoSystem.getSysAdminEmail(), 
               ecoSystem.getSysAdmingEmailPassword(), 
               "Password Reset for Health Springs App", 
               getPassWordResetMessage(sentOtp));
    }
    
    String getPassWordResetMessage(String otp) {
        return "Hi " + selectedPerson.getPersonDetails().getFullName() + "!\n" +
                "Your 6 digit OPT to reset password is : " + otp + "\n" +
                "Please visit your app and enter the code to reset the password." + 
                "\n\n\n" +
                "Thank you,\n" + 
                "Health Springs App Team";
    }
    
    void sendOTPViaTextMessage() {
        sentOtp = getRandomOPT();
        new SMSSender().sendSMSAsynchronous(selectedPerson.getPersonDetails().getPhoneNumber(), getPassWordResetMessage(sentOtp));
    }
    
    String getRandomOPT() {
        int number = rnd.nextInt(999999);
        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCheckOTP;
    private javax.swing.JButton jButtonCheckUserName1;
    private javax.swing.JButton jButtonResetPassword;
    private javax.swing.JButton jButtonSendOTP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelEmailIdCheck;
    private javax.swing.JLabel jLabelOTPCheck;
    private javax.swing.JLabel jLabelPhoneNumberCheck;
    private javax.swing.JLabel jLabelUsernameCheck;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonSelectEmail;
    private javax.swing.JRadioButton jRadioButtonSelectMobileNumber;
    private javax.swing.JPasswordField jTextConfirmPassword;
    private javax.swing.JTextField jTextFieldEmailId;
    private javax.swing.JTextField jTextFieldEnterOTP;
    private javax.swing.JTextField jTextFieldMobileNum;
    private javax.swing.JTextField jTextFieldMobileNumberCountryCode;
    private javax.swing.JPasswordField jTextFieldNewPassword;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}