/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SysAdminUI;

import DataStore.GlobalUserDirectory;
import Doctor.Doctor;
import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import Enterprise.EnterpriseType;
import Enterprise.PharmacyEnterprise;
import Organization.Organization;
import Patient.Patient;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.SystemAdmin;
import Personnel.UserAccount;
import Utils.ConsoleLogger;
import Utils.EmailClient;
import Utils.FieldsValidator;
import Utils.NextScreen;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
//import com.github.sarxos.webcam.Webcam;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Ankur Bywar
 */
public class NewRegistrationJPanel extends javax.swing.JPanel implements NextScreen {
    EcoSystem ecoSystem;
    JPanel WorkArea;
    GlobalUserDirectory globalUserDirectory;
    private final JFileChooser fileChooser = new JFileChooser();
    ImageIcon logoImage;
    ConsoleLogger log = ConsoleLogger.getLogger();
    /**
     * Creates new form NewRegistrationJPanel
     */
    public NewRegistrationJPanel(JPanel WorkArea, EcoSystem ecoSystem) {
        initComponents();
        this.setSize(1100,850);
        this.ecoSystem = ecoSystem;
        this.globalUserDirectory = globalUserDirectory;
        this.WorkArea = WorkArea;
        //boolean Visible;
        
        FileFilter jpegFilter = new FileNameExtensionFilter("JPEG file" , "jpg" , "jpeg");
        FileFilter pngFilter = new FileNameExtensionFilter("PNG file" , "png" , "png");
        
        txtDobDateChooser.setMaxSelectableDate(Date.from(Instant.now().minusMillis(86400000)));
        fileChooser.addChoosableFileFilter(jpegFilter);
        fileChooser.addChoosableFileFilter(pngFilter);
        fileChooser.setFileFilter(pngFilter);
        populatePreferredPharmacy();
    }
    
    void populatePreferredPharmacy() {
        jComboBoxPreferredPharmacy.removeAllItems();
        List<Enterprise> pharmacies = ecoSystem.enterpriseDirectory.getEnterpriseByType(EnterpriseType.PHARMACY);
        if (pharmacies == null || pharmacies.isEmpty()) {
            log.error("NO PHARMACIES EXISTS FOR PATIENTS TO SELECT PREFERRED PHARMACY");
            return;
        }
        
        jComboBoxPreferredPharmacy.addItem("Select");
        for (Enterprise pharmacy : pharmacies) {
            jComboBoxPreferredPharmacy.addItem(pharmacy.getEnterpriseName() + ":" + pharmacy.getEnterpriseId());
        } 
        
        jComboBoxPreferredPharmacy.addItemListener(new ItemListener() {
            NewRegistrationJPanel parent;
            @Override
            public void itemStateChanged(ItemEvent e) {
                parent.populatePharmacyAddressPlaceHolder();
            }
            
            private ItemListener init(NewRegistrationJPanel parent) {
                this.parent = parent;
                return this;
            }  
        }.init(this));
    }
    
    void populatePharmacyAddressPlaceHolder() {
        String selectedPharmacy = (String) jComboBoxPreferredPharmacy.getSelectedItem();
        if (selectedPharmacy == null) {
            return;
        }
        
        if ("Select".equals(selectedPharmacy)) {
            lblPharmacyAddressPlaceHolder.setText("");
            return;
        }
        
        Enterprise pharmacy = ecoSystem.enterpriseDirectory.getEnterprise(Integer.parseInt(selectedPharmacy.split(":")[1]));
        if (pharmacy == null) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "No pharmacy exists for the selected entry: " + selectedPharmacy);
            return;
        }
        
        lblPharmacyAddressPlaceHolder.setText("Pharmacy Address: " + pharmacy.getEnterpriseAddress().toString());
        lblPharmacyAddressPlaceHolder.setForeground(Color.GREEN);
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
        txtName = new javax.swing.JTextField();
        jPasswordTextField = new javax.swing.JPasswordField();
        lblDob = new javax.swing.JLabel();
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
        lblAddrStreet = new javax.swing.JLabel();
        lblAddrState1 = new javax.swing.JLabel();
        jComboBoxGender = new javax.swing.JComboBox<>();
        txtAddressStreet = new javax.swing.JTextField();
        lblAddrCity1 = new javax.swing.JLabel();
        txtAddressApartment = new javax.swing.JTextField();
        lblAddrCity = new javax.swing.JLabel();
        txtAddressCity = new javax.swing.JTextField();
        lblAddrZip = new javax.swing.JLabel();
        txtAddressZip = new javax.swing.JTextField();
        lblAddrState = new javax.swing.JLabel();
        jComboBoxAddrState = new javax.swing.JComboBox<>();
        lblAddrCountry = new javax.swing.JLabel();
        txtAddressCountry = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmailId = new javax.swing.JTextField();
        txtPhoneNumberAreaCode = new javax.swing.JTextField();
        jUsernameLabel1 = new javax.swing.JLabel();
        jComboBoxPreferredPharmacy = new javax.swing.JComboBox<>();
        lblPharmacyAddressPlaceHolder = new javax.swing.JLabel();
        lblAddrZip1 = new javax.swing.JLabel();
        lblAddrZip2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRegistrationpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jRegistrationpanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 53, 181, -1));

        jPasswordTextField.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jPasswordTextField.setToolTipText("");
        jPasswordTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordTextFieldActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(jPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 630, 198, -1));

        lblDob.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDob.setText("Date Of Birth");
        jRegistrationpanel.add(lblDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Phone Number");
        jRegistrationpanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 164, -1, -1));

        txtUsername.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtUsername.setToolTipText("Enter Username");
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 590, 198, 20));

        jPasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPasswordLabel.setText("Password");
        jRegistrationpanel.add(jPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, 95, 29));

        imgLogo.setBackground(new java.awt.Color(255, 255, 204));
        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/user1new.png"))); // NOI18N
        imgLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jRegistrationpanel.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 53, 120, 120));

        lblTitleRegister.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitleRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleRegister.setText("New User Registeration");
        jRegistrationpanel.add(lblTitleRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 6, 293, 41));

        txtPhoneNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jRegistrationpanel.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 166, 141, 26));

        btnAttach.setBackground(new java.awt.Color(255, 255, 255));
        btnAttach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-attach-30.png"))); // NOI18N
        btnAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttachActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(btnAttach, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 192, 46, -1));
        jRegistrationpanel.add(txtDobDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 120, 181, -1));

        jUsernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jUsernameLabel.setText("Preferred Pharmacy");
        jRegistrationpanel.add(jUsernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 157, 29));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Name");
        jRegistrationpanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 53, -1, -1));

        btnRegister.setBackground(new java.awt.Color(255, 255, 255));
        btnRegister.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/mngOrder.png"))); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 670, 130, -1));

        btnLoginRedirect.setBackground(new java.awt.Color(255, 255, 255));
        btnLoginRedirect.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnLoginRedirect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/icons8-login-30 (1).png"))); // NOI18N
        btnLoginRedirect.setText("Login");
        btnLoginRedirect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginRedirectActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(btnLoginRedirect, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 720, 130, 40));

        btnRemove1.setBackground(new java.awt.Color(255, 255, 255));
        btnRemove1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/disagree.png"))); // NOI18N
        btnRemove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemove1ActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(btnRemove1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 192, 45, -1));

        lblAddrStreet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddrStreet.setText("Community/ Street");
        jRegistrationpanel.add(lblAddrStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 263, -1, -1));

        lblAddrState1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddrState1.setText("Gender");
        jRegistrationpanel.add(lblAddrState1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 203, -1, -1));

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "MALE", "FEMALE", "OTHER" }));
        jComboBoxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGenderActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(jComboBoxGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 203, 181, -1));

        txtAddressStreet.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtAddressStreet.setText("1232 Harrison St");
        txtAddressStreet.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jRegistrationpanel.add(txtAddressStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 263, 190, -1));

        lblAddrCity1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddrCity1.setText("Unit");
        jRegistrationpanel.add(lblAddrCity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 297, 150, 30));

        txtAddressApartment.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtAddressApartment.setText("#225");
        txtAddressApartment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jRegistrationpanel.add(txtAddressApartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 190, -1));

        lblAddrCity.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblAddrCity.setText("City");
        jRegistrationpanel.add(lblAddrCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 150, 30));

        txtAddressCity.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtAddressCity.setText("Seattle");
        txtAddressCity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jRegistrationpanel.add(txtAddressCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 190, -1));

        lblAddrZip.setText("ZIP");
        jRegistrationpanel.add(lblAddrZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 140, 30));

        txtAddressZip.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtAddressZip.setText("97981");
        txtAddressZip.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jRegistrationpanel.add(txtAddressZip, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 190, -1));

        lblAddrState.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblAddrState.setText("State");
        jRegistrationpanel.add(lblAddrState, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 140, 30));

        jComboBoxAddrState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "MA", "WA", "TX", "CA", " " }));
        jComboBoxAddrState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAddrStateActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(jComboBoxAddrState, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 190, -1));

        lblAddrCountry.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblAddrCountry.setText("Country");
        jRegistrationpanel.add(lblAddrCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 150, 30));

        txtAddressCountry.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtAddressCountry.setText("USA");
        txtAddressCountry.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jRegistrationpanel.add(txtAddressCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 190, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Email ID");
        jRegistrationpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 80, -1, -1));

        txtEmailId.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtEmailId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtEmailId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailIdActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 85, 181, -1));

        txtPhoneNumberAreaCode.setEditable(false);
        txtPhoneNumberAreaCode.setText("+1");
        txtPhoneNumberAreaCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jRegistrationpanel.add(txtPhoneNumberAreaCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 166, 34, 26));

        jUsernameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jUsernameLabel1.setText("Username");
        jRegistrationpanel.add(jUsernameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 95, 29));

        jComboBoxPreferredPharmacy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPreferredPharmacyActionPerformed(evt);
            }
        });
        jRegistrationpanel.add(jComboBoxPreferredPharmacy, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 190, -1));
        jRegistrationpanel.add(lblPharmacyAddressPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 752, 372, -1));

        lblAddrZip1.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblAddrZip1.setText("*10 digits");
        jRegistrationpanel.add(lblAddrZip1, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 174, -1, -1));

        lblAddrZip2.setFont(new java.awt.Font("Lucida Grande", 2, 9)); // NOI18N
        lblAddrZip2.setText("*5 digits");
        jRegistrationpanel.add(lblAddrZip2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));
        jRegistrationpanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 246, 1100, 11));
        jRegistrationpanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 492, 1100, 10));
        jRegistrationpanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 1100, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/polygonal-bg1100X850.jpg"))); // NOI18N
        jRegistrationpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1100, 850));

        add(jRegistrationpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 850));
    }// </editor-fold>//GEN-END:initComponents

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
        
        FieldsValidator fieldsValidator = new FieldsValidator();
        boolean error = fieldsValidator.validate(txtName, txtEmailId, txtUsername, jPasswordTextField, txtPhoneNumber, txtDobDateChooser,
                txtAddressStreet, txtAddressApartment, txtAddressCity, txtAddressZip, jComboBoxAddrState, txtAddressCountry, jComboBoxGender);
        error |= fieldsValidator.validate(jComboBoxPreferredPharmacy);
        if (error) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "There are error in some field(s). Please correct them.");
            return;
        }
        
        GlobalUserDirectory gd = ecoSystem.globalUserDirectory;
 
        String name = txtName.getText();
        String emailId = txtEmailId.getText();
        String userName = txtUsername.getText();
        String password = new String(jPasswordTextField.getPassword());
        String phoneNumber = txtPhoneNumber.getText();
        Date dob = txtDobDateChooser.getDate();
        LocalDate dateOfBirth = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        String addrCommunity = txtAddressStreet.getText();
        String addrCity = txtAddressCity.getText();
        String addrUnit = txtAddressApartment.getText();
        String addrZip = txtAddressZip.getText();
        String addrState = String.valueOf(jComboBoxAddrState.getSelectedItem());
        String addrCountry = txtAddressCountry.getText();
        Address address = new Address(addrCommunity, addrUnit, addrCity, addrZip, addrState, addrCountry);

        String selectedGender = String.valueOf(jComboBoxGender.getSelectedItem());
        PersonDetails.Gender gender = PersonDetails.Gender.valueOf(selectedGender);


        if (gd.get(userName) != null) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "Username already exists. Pick a different username.");
            return;
        }

        Icon logo = imgLogo.getIcon();
        UserAccount userAccount = new UserAccount(userName, password);
        
        String selectedPreferredPharmacy = (String)jComboBoxPreferredPharmacy.getSelectedItem();
        Enterprise preferredPharmacy = ecoSystem.enterpriseDirectory.getEnterprise(Integer.parseInt(selectedPreferredPharmacy.split(":")[1]));
        if (preferredPharmacy == null) {
            JOptionPane.showMessageDialog(jRegistrationpanel, "No pharmacy found for selected item: " + selectedPreferredPharmacy);
            return;
        }
        
        Person patient = new Patient(name, dateOfBirth, gender, address, phoneNumber, logo, userAccount, -1, (PharmacyEnterprise)preferredPharmacy, emailId);
                ecoSystem.globalUserDirectory.createNewUser(patient);
        
         gd.createNewUser(patient);
        
       // gd.createNewUser(person);
       JOptionPane.showMessageDialog(this,"Congradulations! You have successfully registered in the app. Use your credentials to login.");
       boolean success = new EmailClient().sendEmail(
               emailId, 
               ecoSystem.getSysAdminEmail(), 
               ecoSystem.getSysAdmingEmailPassword(), 
               getNewUserRegistrationEmailSubject(), 
               getNewUserRegistrationEmailBody(patient));
        log.debug("Registeration email sent to user: " + userName + ". Email status success: " + success);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private String getNewUserRegistrationEmailSubject() {
        return "Welcome to Health Springs App!";
    }
    
    private String getNewUserRegistrationEmailBody(Person patient) {
        return "Hi " + patient.getPersonDetails().getFullName() + "!\n" +
                "We're glad that you choose Health Springs App to manage your daily health.\n" + 
                "We sincerely hope that the app will help you in achieving your health goals!\n" + 
                "Remember, the greatest wealth is health!\n\n\n" +
                "Cheers -\n" + 
                "Health Springs App Team";
    }
    
    private void btnLoginRedirectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginRedirectActionPerformed
        // TODO add your handling code here:
        //nextScreen(new Login(dataStore, mainWorkArea, mainJFrame), "Login");
        nextScreen(new Login(WorkArea, ecoSystem), "Login");
    }//GEN-LAST:event_btnLoginRedirectActionPerformed

    private void btnRemove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemove1ActionPerformed
        // TODO add your handling code here:
        logoImage = null;
        imgLogo.setIcon(logoImage);
    }//GEN-LAST:event_btnRemove1ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void jComboBoxAddrStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAddrStateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAddrStateActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//        WorkArea.remove(this);
//        Component[] componentArray = WorkArea.getComponents();
//        Component component = componentArray[componentArray.length - 1];
//        CardLayout layout = (CardLayout)WorkArea.getLayout();
//        layout.previous(WorkArea);
         nextScreen(WorkArea, new Login(WorkArea, ecoSystem), "Login   ");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBoxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGenderActionPerformed

    private void txtEmailIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailIdActionPerformed

    private void jComboBoxPreferredPharmacyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPreferredPharmacyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPreferredPharmacyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttach;
    private javax.swing.JButton btnLoginRedirect;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRemove1;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JComboBox<String> jComboBoxAddrState;
    private javax.swing.JComboBox<String> jComboBoxGender;
    private javax.swing.JComboBox<String> jComboBoxPreferredPharmacy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jPasswordLabel;
    private javax.swing.JPasswordField jPasswordTextField;
    private javax.swing.JPanel jRegistrationpanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jUsernameLabel;
    private javax.swing.JLabel jUsernameLabel1;
    private javax.swing.JLabel lblAddrCity;
    private javax.swing.JLabel lblAddrCity1;
    private javax.swing.JLabel lblAddrCountry;
    private javax.swing.JLabel lblAddrState;
    private javax.swing.JLabel lblAddrState1;
    private javax.swing.JLabel lblAddrStreet;
    private javax.swing.JLabel lblAddrZip;
    private javax.swing.JLabel lblAddrZip1;
    private javax.swing.JLabel lblAddrZip2;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblPharmacyAddressPlaceHolder;
    private javax.swing.JLabel lblTitleRegister;
    private javax.swing.JTextField txtAddressApartment;
    private javax.swing.JTextField txtAddressCity;
    private javax.swing.JTextField txtAddressCountry;
    private javax.swing.JTextField txtAddressStreet;
    private javax.swing.JTextField txtAddressZip;
    private com.toedter.calendar.JDateChooser txtDobDateChooser;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtPhoneNumberAreaCode;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

        private void nextScreen(JPanel nextScreen, String screenName) {
        WorkArea.removeAll();
        WorkArea.add(screenName , nextScreen);
        WorkArea.setAlignmentX(SwingConstants.CENTER);
        WorkArea.setAlignmentY(SwingConstants.CENTER);
        CardLayout layout = (CardLayout)WorkArea.getLayout();
        Dimension d = nextScreen.getLayout().preferredLayoutSize(nextScreen);
        WorkArea.setSize(d);
        layout.next(WorkArea); 
    }
}
