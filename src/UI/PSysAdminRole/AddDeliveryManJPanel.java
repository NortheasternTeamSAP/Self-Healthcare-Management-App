/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PSysAdminRole;

import DeliveryMan.DeliveryMan;
import EcoSystem.EcoSystem;
import Personnel.Address;
import Personnel.PersonDetails;
import Personnel.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sravya
 */
public class AddDeliveryManJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private EcoSystem ecoSystem;
    
    public AddDeliveryManJPanel(
            JPanel workArea, 
            EcoSystem ecoSystem) {
        
        this.workArea = workArea;
        this.ecoSystem = ecoSystem;
        initComponents();
        populatecmbDelManGender();
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel9 = new javax.swing.JLabel();
        btnAddDelMan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblZIP = new javax.swing.JLabel();
        txtAddDelManZIP = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        txtAddDelManState = new javax.swing.JTextField();
        lblBuildingNo = new javax.swing.JLabel();
        lblCountry = new javax.swing.JLabel();
        txtAddDeliveryManBuildingNo = new javax.swing.JTextField();
        txtAddDelManCountry = new javax.swing.JTextField();
        lblStreet = new javax.swing.JLabel();
        txtAddDelManSt = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        txtAddDelManCity = new javax.swing.JTextField();
        txtAddDeliveryMan = new javax.swing.JTextField();
        txtAddDelManPhNo = new javax.swing.JTextField();
        txtAddDelManUsername = new javax.swing.JTextField();
        txtAddDelManPW = new javax.swing.JPasswordField();
        jDateChooserDelManDob = new com.toedter.calendar.JDateChooser();
        cmbDelManGender = new javax.swing.JComboBox<>();

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Password:");

        btnAddDelMan.setText("Add");
        btnAddDelMan.setToolTipText("Create");
        btnAddDelMan.setContentAreaFilled(false);
        btnAddDelMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDelManActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("DOB");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Username:");

        btnBack.setText("Back");
        btnBack.setToolTipText("Back");
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Phone Number:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Create New Delivery Man ");

        jLabel3.setText("Gender");

        lblZIP.setText("ZIP");

        lblState.setText("State");

        lblBuildingNo.setText("Building No");

        lblCountry.setText("Country");

        txtAddDelManCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddDelManCountryActionPerformed(evt);
            }
        });

        lblStreet.setText("Street");

        lblCity.setText("City");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(43, 43, 43)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddDelManPhNo)
                            .addComponent(txtAddDelManUsername)
                            .addComponent(txtAddDelManPW, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(167, 167, 167))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddDeliveryMan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserDelManDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbDelManGender, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblBuildingNo)
                                .addGap(18, 18, 18)
                                .addComponent(txtAddDeliveryManBuildingNo, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lblCountry)
                                .addGap(18, 18, 18)
                                .addComponent(txtAddDelManCountry))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblStreet)
                                            .addComponent(lblCity)))
                                    .addComponent(lblZIP, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblState, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAddDelManState)
                                    .addComponent(txtAddDelManSt)
                                    .addComponent(txtAddDelManCity)
                                    .addComponent(txtAddDelManZIP)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnAddDelMan, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(185, 185, 185)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addContainerGap(156, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAddDeliveryMan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbDelManGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBuildingNo)
                            .addComponent(txtAddDeliveryManBuildingNo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStreet)
                            .addComponent(txtAddDelManSt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCity)
                            .addComponent(txtAddDelManCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblZIP)
                            .addComponent(txtAddDelManZIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblState)
                            .addComponent(txtAddDelManState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCountry)
                            .addComponent(txtAddDelManCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtAddDelManPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtAddDelManUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddDelManPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(37, 37, 37)
                        .addComponent(btnAddDelMan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooserDelManDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jLabel1)
                    .addGap(28, 28, 28)
                    .addComponent(lblName)
                    .addContainerGap(638, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDelManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDelManActionPerformed
        // TODO add your handling code here:
        
        Date dob = jDateChooserDelManDob.getDate();
        
        LocalDate localDate = Instant.ofEpochMilli(dob.getTime())
       .atZone(ZoneId.systemDefault())
       .toLocalDate();
        if( txtAddDeliveryMan.getText().isEmpty() ||
            dob.toString().isEmpty()||  //later add for rbtns
            txtAddDeliveryManBuildingNo.getText().isEmpty() || 
            txtAddDelManSt.getText().isEmpty() || 
            txtAddDelManCity.getText().isEmpty() || 
            txtAddDelManZIP.getText().isEmpty() || 
            txtAddDelManState.getText().isEmpty() || 
            txtAddDelManCountry.getText().isEmpty() || 
            txtAddDelManPhNo.getText().isEmpty() || 
            txtAddDelManUsername.getText().isEmpty() || 
            txtAddDelManPW.getPassword().toString().isEmpty()) {
           
            JOptionPane.showMessageDialog(null, "Fields cannot be left empty");
            return;
        }

        boolean flag; 
        //add other validations too
        
        flag = txtAddDeliveryMan.getText().matches("^[a-zA-Z]+$");

        if(flag == false) {
            JOptionPane.showMessageDialog(null, "Full name cannot have integer values!");
            return;
        }
        
        String phoneNumber = txtAddDelManPhNo.getText();

        if(phoneNumber.length() != 10) {
            JOptionPane.showMessageDialog(null, "Phone Number must consist of 10 digits");
            return;
        }
        flag = phoneNumber.matches("^[0-9]+$");
        if(!flag) {
            JOptionPane.showMessageDialog(null, "Phone Number must have digits only");
            return;
        }
        
        Address address = new Address(
            txtAddDelManSt.getText(),
            txtAddDeliveryManBuildingNo.getText(),
            txtAddDelManCity.getText(),
            txtAddDelManZIP.getText(),
            txtAddDelManState.getText(),
            txtAddDelManCountry.getText()
        );
        
        
        PersonDetails.Gender gender = PersonDetails.Gender.MALE;
        if ("Male".equals(cmbDelManGender.getSelectedItem().toString())){
            gender = PersonDetails.Gender.MALE;
        } else if ("Female".equals(cmbDelManGender.getSelectedItem().toString())){
            gender = PersonDetails.Gender.FEMALE;
        } else {
            gender = PersonDetails.Gender.OTHER;
        }
        
        DeliveryMan delMan = new DeliveryMan(
            txtAddDeliveryMan.getText(),
            localDate,
            gender,
            address,
            txtAddDelManPhNo.getText(),
            null,
            new UserAccount(txtAddDelManUsername.getText(), txtAddDelManPW.getPassword().toString())
        );
        
        ecoSystem.globalUserDirectory.createNewUser(delMan);

        JOptionPane.showMessageDialog(null, "Your profile has been successfully created!");
    }//GEN-LAST:event_btnAddDelManActionPerformed

    private void populatecmbDelManGender(){
 
        cmbDelManGender.addItem("Male");
        cmbDelManGender.addItem("Female");
        cmbDelManGender.addItem("Other");
    }
   
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        Component[] componentArray = workArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageDeliveryManJPanel mcjp = (ManageDeliveryManJPanel) component;
        //check refresh table method
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtAddDelManCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddDelManCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddDelManCountryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDelMan;
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbDelManGender;
    private com.toedter.calendar.JDateChooser jDateChooserDelManDob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBuildingNo;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JLabel lblZIP;
    private javax.swing.JTextField txtAddDelManCity;
    private javax.swing.JTextField txtAddDelManCountry;
    private javax.swing.JPasswordField txtAddDelManPW;
    private javax.swing.JTextField txtAddDelManPhNo;
    private javax.swing.JTextField txtAddDelManSt;
    private javax.swing.JTextField txtAddDelManState;
    private javax.swing.JTextField txtAddDelManUsername;
    private javax.swing.JTextField txtAddDelManZIP;
    private javax.swing.JTextField txtAddDeliveryMan;
    private javax.swing.JTextField txtAddDeliveryManBuildingNo;
    // End of variables declaration//GEN-END:variables
}
