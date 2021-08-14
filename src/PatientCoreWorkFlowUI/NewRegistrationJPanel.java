/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientCoreWorkFlowUI;

import DataStore.GlobalUserDirectory;
import EcoSystem.EcoSystem;
import Personnel.Person;
import Utils.ConsoleLogger;
//import com.github.sarxos.webcam.Webcam;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ankur Bywar
 */
public class NewRegistrationJPanel extends javax.swing.JPanel {
    EcoSystem ecoSystem;
    GlobalUserDirectory globalUserDirectory;
    private final JFileChooser fileChooser = new JFileChooser();
    ImageIcon logoImage;
    ConsoleLogger log = ConsoleLogger.getLogger();
    
     
    /**
     * Creates new form NewRegistrationJPanel
     */
    public NewRegistrationJPanel(EcoSystem ecoSystem ,GlobalUserDirectory globalUserDirectory) {
        initComponents();
        this.ecoSystem = ecoSystem;
        this.globalUserDirectory = globalUserDirectory;
        //boolean Visible;
        
        FileFilter jpegFilter = new FileNameExtensionFilter("JPEG file" , "jpg" , "jpeg");
        FileFilter pngFilter = new FileNameExtensionFilter("PNG file" , "png" , "png");
        
       
        fileChooser.addChoosableFileFilter(jpegFilter);
        fileChooser.addChoosableFileFilter(pngFilter);
        fileChooser.setFileFilter(pngFilter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRegistrationpanel = new javax.swing.JPanel();
        btnTakeShot = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        jPasswordTextField = new javax.swing.JPasswordField();
        lblDob = new javax.swing.JLabel();
        jSelectRoleLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jPasswordLabel = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        lblTitleRegister = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        btnAttach = new javax.swing.JButton();
        txtDobDateChooser = new com.toedter.calendar.JDateChooser();
        jUsernameLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnLoginRedirect = new javax.swing.JButton();
        btnRemove1 = new javax.swing.JButton();

        btnTakeShot.setBackground(new java.awt.Color(204, 204, 255));
        btnTakeShot.setText("Take shot");
        btnTakeShot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTakeShotActionPerformed(evt);
            }
        });

        jPasswordTextField.setToolTipText("");
        jPasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordTextFieldActionPerformed(evt);
            }
        });

        lblDob.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblDob.setText("Dob:");

        jSelectRoleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jSelectRoleLabel.setText("Profile Picture");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Phone Number:");

        txtUsername.setToolTipText("Enter Username");
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jPasswordLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jPasswordLabel.setText("Password");

        imgLogo.setBackground(new java.awt.Color(255, 255, 204));
        imgLogo.setText("Upload your photo here");

        lblTitleRegister.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblTitleRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleRegister.setText("New User Registeration");

        btnAttach.setBackground(new java.awt.Color(255, 255, 102));
        btnAttach.setText("Attach");
        btnAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachActionPerformed(evt);
            }
        });

        jUsernameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jUsernameLabel.setText("Username");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Name:");

        btnRegister.setBackground(new java.awt.Color(0, 153, 153));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnLoginRedirect.setText("Login");
        btnLoginRedirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginRedirectActionPerformed(evt);
            }
        });

        btnRemove1.setBackground(new java.awt.Color(204, 204, 255));
        btnRemove1.setText("Remove");
        btnRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jRegistrationpanelLayout = new javax.swing.GroupLayout(jRegistrationpanel);
        jRegistrationpanel.setLayout(jRegistrationpanelLayout);
        jRegistrationpanelLayout.setHorizontalGroup(
            jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                                .addComponent(jPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                                .addComponent(jUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(330, 330, 330))
                    .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                        .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(lblTitleRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jRegistrationpanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)))
                        .addGap(271, 271, 271))
                    .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                        .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSelectRoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(lblDob)
                            .addComponent(jLabel3))
                        .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhoneNumber)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDobDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jRegistrationpanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(btnRemove1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addComponent(btnAttach, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnTakeShot)))
                                .addGap(147, 147, 147))))))
            .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoginRedirect, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jRegistrationpanelLayout.setVerticalGroup(
            jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                        .addComponent(lblTitleRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                                .addComponent(jSelectRoleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(btnAttach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemove1)))
                        .addGap(18, 18, 18)
                        .addComponent(btnTakeShot)
                        .addGap(32, 32, 32)))
                .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblDob)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jRegistrationpanelLayout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDobDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(156, 156, 156)
                .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jRegistrationpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoginRedirect, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jRegistrationpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRegistrationpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTakeShotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTakeShotActionPerformed
        // TODO add your handling code here:
//        Webcam webcam = Webcam.getDefault();
//        webcam.open();
//        ImageIO.write(webcam.getImage(), "JPG", new File("/tmp/hello-world.png"));
//        Webcam webcam = Webcam.getDefault();
//        webcam.open();
//        ImageIO.write(webcam.getImage(), "PNG", new File("/tmp/hello-world.png"));
//            Webcam webcam = Webcam.getDefault(); 
//                webcam.open();
//
//		// get image
//		BufferedImage image = webcam.getImage();
//
//        try {
//            // save image to PNG file
//            ImageIO.write(image, "PNG", new File("test.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(NewRegistrationJPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_btnTakeShotActionPerformed

    private void jPasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordTextFieldActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttachActionPerformed
        // TODO add your handling code here:

         int returnVal = fileChooser.showOpenDialog(this);
         if (returnVal == JFileChooser.APPROVE_OPTION) {
             File file = fileChooser.getSelectedFile();
             BufferedImage img = null;
             try {
                 img = ImageIO.read(file);
             } catch (IOException ex) {
                 java.util.logging.Logger.getLogger(NewRegistrationJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
               //Logger.getLogger(NewRegistrationJPanel.class.getName()).log(Level.SEVERE, null, ex);  
             }
             Image scaled = img.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
             ImageIcon icon = new ImageIcon(scaled);
             imgLogo.setIcon(icon);
             
         }
    }//GEN-LAST:event_btnAttachActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        //Person person = null ;
        // TODO add your handling code here:

        
        GlobalUserDirectory gd = ecoSystem.getGlobalUserDirectory();
        String name = txtName.getText();
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "name cannot be empty");
            return;
        }

        String userName = txtUsername.getText();
        if (userName == null || userName.isEmpty()) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "username cannot be empty");
            return;
        }

        String password = new String(jPasswordTextField.getPassword());
        if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "password cannot be empty");
            return;
        }

        String phoneNumber = txtPhoneNumber.getText();
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "phone number cannot be empty");
            return;
        }
        Date dob = txtDobDateChooser.getDate();
        Date currentDate = Date.from(Instant.now());
        if (dob.after(currentDate)) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "Date of Birth must be older than current date");
            return;
        }

        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "Invalid phone number. Expected numbers only.");
            return;
        }

        if (phoneNumber.length() != 10) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "Invalid phone number. Expected 10 digit number.");
            return;
        }

//        String addrCommunity = txtAddressStreet.getText();
//        String addrCity = txtAddressCity.getText();
//        String addrZip = txtAddressZip.getText();
//        String addrState = String.valueOf(jComboBoxAddrState.getSelectedItem());
//        if (addrState.equals("Select")) {
//            JOptionPane.showMessageDialog(jRegisterPannel, "Select a valid state.");
//            return;
//        }
        //String addrCountry = txtAddressCountry.getText();

        if (gd.get(userName) != null) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "Username already exists. Pick a different username.");
            return;
        }

        System.out.println("Date: " + dob.toString());
       // House house = new House(addrCommunity, addrZip,  addrCity,  addrState,  addrCountry);

    

        Icon logo = imgLogo.getIcon();

        Person p = null;


        Person person = null;

        
        gd.add(person);
        JOptionPane.showMessageDialog(this,"registered info saved");
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginRedirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginRedirectActionPerformed
        // TODO add your handling code here:
        //nextScreen(new Login(dataStore, mainWorkArea, mainJFrame), "Login");
    }//GEN-LAST:event_btnLoginRedirectActionPerformed

    private void btnRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove1ActionPerformed
        // TODO add your handling code here:
        logoImage = null;
        imgLogo.setIcon(logoImage);
    }//GEN-LAST:event_btnRemove1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttach;
    private javax.swing.JButton btnLoginRedirect;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRemove1;
    private javax.swing.JButton btnTakeShot;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jPasswordLabel;
    private javax.swing.JPasswordField jPasswordTextField;
    private javax.swing.JPanel jRegistrationpanel;
    private javax.swing.JLabel jSelectRoleLabel;
    private javax.swing.JLabel jUsernameLabel;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblTitleRegister;
    private com.toedter.calendar.JDateChooser txtDobDateChooser;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
