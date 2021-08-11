/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.PAdminRole;


import DeliveryMan.DeliveryMan;
import DeliveryMan.DeliveryManDirectory;
import EcoSystem.EcoSystem;
import Personnel.Address;
import Personnel.PersonDetails;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Sravya
 */
public class ModifyDeliveryManJPanel extends javax.swing.JPanel {

    private JPanel workArea; 
    private EcoSystem ecoSystem; 
    private DeliveryManDirectory deliveryManDirectory;
    private DeliveryMan deliveryMan;
    private PersonDetails personDetails;
    private Address address;
    
    /**
     * Creates new form ModifyDeliveryMan
     */
    public ModifyDeliveryManJPanel(
            JPanel workArea, 
            EcoSystem ecoSystem, 
            DeliveryManDirectory deliveryManDirectory, 
            DeliveryMan deliveryMan) {
        
        initComponents();
        this.workArea = workArea;
        this.deliveryManDirectory = ecoSystem.getDeliveryManDirectory(); //check
        this.ecoSystem = ecoSystem;
        this.deliveryMan = deliveryMan;
        this.personDetails = personDetails;
        this.address = address;
        txtName2.setText(personDetails.getFullName());
        txtDOB2.setText(personDetails.getDob()); //parsing needed
        txtPhNo2.setText(personDetails.getPhoneNumber());
        txtBuildingNo2.setText(address.getApartment());
        txtStreet2.setText(address.getStreet());
        txtCity2.setText(address.getCity());
        txtZIP2.setText(address.getZipcode());
        txtState2.setText(address.getState());
        txtCountry2.setText(address.getCountry());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName2 = new javax.swing.JTextField();
        lblDOB = new javax.swing.JLabel();
        txtDOB2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFemale = new javax.swing.JRadioButton();
        rbtnOther = new javax.swing.JRadioButton();
        lblBuildingNo = new javax.swing.JLabel();
        txtBuildingNo2 = new javax.swing.JTextField();
        lblDOB1 = new javax.swing.JLabel();
        txtStreet2 = new javax.swing.JTextField();
        lblName2 = new javax.swing.JLabel();
        txtCity2 = new javax.swing.JTextField();
        lblZIP = new javax.swing.JLabel();
        txtZIP2 = new javax.swing.JTextField();
        lblName3 = new javax.swing.JLabel();
        txtCountry2 = new javax.swing.JTextField();
        lblZIP1 = new javax.swing.JLabel();
        txtPhNo2 = new javax.swing.JTextField();
        lblZIP2 = new javax.swing.JLabel();
        txtState2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.setToolTipText("Back");
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 45, 69, 33));

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-save-64.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setContentAreaFilled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 690, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Modify Delivery Man Details");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 46, -1, -1));

        lblName.setText("Name:");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));
        add(txtName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 200, -1));

        lblDOB.setText("DOB:");
        add(lblDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));
        add(txtDOB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 200, -1));

        jLabel2.setText("Gender:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        rbtnMale.setText("Male");
        add(rbtnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        rbtnFemale.setText("Female");
        add(rbtnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        rbtnOther.setText("Other");
        add(rbtnOther, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        lblBuildingNo.setText("Building No:");
        add(lblBuildingNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));
        add(txtBuildingNo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 200, -1));

        lblDOB1.setText("Street");
        add(lblDOB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));
        add(txtStreet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 200, -1));

        lblName2.setText("City");
        add(lblName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));
        add(txtCity2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 200, -1));

        lblZIP.setText("ZIP");
        add(lblZIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, -1, -1));
        add(txtZIP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 200, -1));

        lblName3.setText("Country");
        add(lblName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, -1, -1));
        add(txtCountry2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 200, -1));

        lblZIP1.setText("Phone Number:");
        add(lblZIP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, -1, -1));
        add(txtPhNo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, 200, -1));

        lblZIP2.setText("State");
        add(lblZIP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));
        add(txtState2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 200, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        Component[] componentArray = workArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageDeliveryManJPanel mdmjp = (ManageDeliveryManJPanel) component;
        mdmjp.refreshTable(); //check refresh method
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if( txtName2.getText().isEmpty() ||
            txtDOB2.getText().isEmpty() ||  //later add for rbtns
            txtBuildingNo2.getText().isEmpty() || 
            txtStreet2.getText().isEmpty() || 
            txtCity2.getText().isEmpty() || 
            txtZIP2.getText().isEmpty() || 
            txtState2.getText().isEmpty() || 
            txtCountry2.getText().isEmpty() || 
            txtPhNo2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be left empty");
            return;
        }

        boolean flag ;

        String phoneNumber = txtPhNo2.getText();

        if(phoneNumber.length() != 10) {
            JOptionPane.showMessageDialog(null, "PhoneNumber must be of 10 digits");
            return;
        }
        
        flag = phoneNumber.matches("^[0-9]+$");
        if(!flag) {
            JOptionPane.showMessageDialog(null, "Phone Number must contain only digits ");
            return;
        }
        
        for(DeliveryMan deliveryMan : deliveryManDirectory.getDeliveryManMap()) {
            if(deliveryMan.getPhNo2().equals(phoneNumber) && this.deliveryMan != deliveryMan) {
                JOptionPane.showMessageDialog(null, "Phone Number already exists");
            }
        }

        int age = 0;

        try {

            age = Integer.parseInt(txtDOB2.getText()); //check DOB to age properly

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "DOB must have integers only");
            return;
        }

        String apartment = txtBuildingNo2.getText();
        String street = txtStreet2.getText();
        String city = txtCity2.getText();
        String zipcode = txtZIP2.getText();
        String state = txtState2.getText();
        String country = txtCountry2.getText();
        
        //personDetails.setAge(age);  //add setters
        personDetails.setPhoneNumber(phoneNumber); //add setters in Person details and Address classes
        personDetails.setAddress(address);

        JOptionPane.showMessageDialog(null, "Delivery Man Profile Updated");
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBuildingNo;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblDOB1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblZIP;
    private javax.swing.JLabel lblZIP1;
    private javax.swing.JLabel lblZIP2;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JRadioButton rbtnOther;
    private javax.swing.JTextField txtBuildingNo2;
    private javax.swing.JTextField txtCity2;
    private javax.swing.JTextField txtCountry2;
    private javax.swing.JTextField txtDOB2;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtPhNo2;
    private javax.swing.JTextField txtState2;
    private javax.swing.JTextField txtStreet2;
    private javax.swing.JTextField txtZIP2;
    // End of variables declaration//GEN-END:variables
}
