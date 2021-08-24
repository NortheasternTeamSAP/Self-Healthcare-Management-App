/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Personnel.Person;
import java.awt.Image;
import java.time.LocalDate;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author mrs.katey
 */
public class RatingsJPanel extends javax.swing.JPanel {

    Person person;
    LocalDate ratingsDate;
    ConsoleLogger log = ConsoleLogger.getLogger();
    Rating rating;
    
    RatingsJPanel(Person person, Rating rating, LocalDate ratingsDate) {
        initComponents();
        this.setSize(1100,850);
        initizlizeRatingIcons();
        initializeRadioButtonGroup();
        this.person = person;
        this.ratingsDate = ratingsDate;
        this.rating = rating;
    }
    
    void setStarIcons(JLabel label, String iconPath) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(iconPath));
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);  // transform it back]
        label.setIcon(imageIcon);
    }
    
    void initizlizeRatingIcons() {
        setStarIcons(jLabel1Star, "/images_icons/icon-1-star.png");
        setStarIcons(jLabel2Star, "/images_icons/icon-2-star.png");
        setStarIcons(jLabel3Star, "/images_icons/icon-3-star.png");
        setStarIcons(jLabel4Star, "/images_icons/icon-4-star.png");
        setStarIcons(jLabel5Star, "/images_icons/icon-5-star.png");
    }
    
    private void disableControls() {
        jRadioButton1Star.setEnabled(false);
        jRadioButton2Star.setEnabled(false);
        jRadioButton3Star.setEnabled(false);
        jRadioButton4Star.setEnabled(false);
        jRadioButton5Star.setEnabled(false);
        jTextAreaFeedbackText.setEnabled(false);
        jButtonSubmitReview.setEnabled(false);
    }
    
    private void initializeRadioButtonGroup() {
        this.radioButtonGroup.add(jRadioButton1Star);
        this.radioButtonGroup.add(jRadioButton2Star);
        this.radioButtonGroup.add(jRadioButton3Star);
        this.radioButtonGroup.add(jRadioButton4Star);
        this.radioButtonGroup.add(jRadioButton5Star);
    }
    
    private int getSelectedRating() {
        if (jRadioButton1Star.isSelected()) {
            return 1;
        }
        if (jRadioButton2Star.isSelected()) {
            return 2;
        }
        if (jRadioButton3Star.isSelected()) {
            return 3;
        }
        if (jRadioButton4Star.isSelected()) {
            return 4;
        }
        if (jRadioButton5Star.isSelected()) {
            return 5;
        }
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jRadioButton5Star = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton4Star = new javax.swing.JRadioButton();
        jRadioButton3Star = new javax.swing.JRadioButton();
        jRadioButton2Star = new javax.swing.JRadioButton();
        jRadioButton1Star = new javax.swing.JRadioButton();
        jLabel3Star = new javax.swing.JLabel();
        jLabel4Star = new javax.swing.JLabel();
        jLabel1Star = new javax.swing.JLabel();
        jLabel2Star = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaFeedbackText = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButtonSubmitReview = new javax.swing.JButton();
        jLabel5Star = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton5Star.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton5Star.setForeground(new java.awt.Color(0, 204, 102));
        jRadioButton5Star.setText("Very Satisfied");
        jRadioButton5Star.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5StarActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton5Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 290, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Submit Review");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 250, 40));

        jRadioButton4Star.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton4Star.setForeground(new java.awt.Color(102, 204, 0));
        jRadioButton4Star.setText("Somewhat Satisfied");
        jPanel1.add(jRadioButton4Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 300, -1));

        jRadioButton3Star.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton3Star.setForeground(new java.awt.Color(204, 204, 0));
        jRadioButton3Star.setText("Neither satisfied nor dissatisfied");
        jPanel1.add(jRadioButton3Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, 40));

        jRadioButton2Star.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton2Star.setForeground(new java.awt.Color(255, 153, 0));
        jRadioButton2Star.setText("Somewhat dissatisfied");
        jPanel1.add(jRadioButton2Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 300, -1));

        jRadioButton1Star.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton1Star.setForeground(new java.awt.Color(255, 0, 51));
        jRadioButton1Star.setText("Very dissatisfied");
        jPanel1.add(jRadioButton1Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 300, -1));
        jPanel1.add(jLabel3Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 177, -1, 33));
        jPanel1.add(jLabel4Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 139, -1, 26));
        jPanel1.add(jLabel1Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 255, -1, 33));
        jPanel1.add(jLabel2Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 216, -1, 33));

        jTextAreaFeedbackText.setColumns(20);
        jTextAreaFeedbackText.setRows(5);
        jTextAreaFeedbackText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextAreaFeedbackText);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 320, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Optional Feedback");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        jButtonSubmitReview.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSubmitReview.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonSubmitReview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/submit.png"))); // NOI18N
        jButtonSubmitReview.setText("Submit Review");
        jButtonSubmitReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitReviewActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSubmitReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 170, -1));
        jPanel1.add(jLabel5Star, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 113, -1, 26));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images_icons/ratings-funny.gif"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 250, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton5StarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5StarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5StarActionPerformed

    private void jButtonSubmitReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitReviewActionPerformed
        // TODO add your handling code here:
        int selectedRating = getSelectedRating();
        if (selectedRating == -1) {
            JOptionPane.showMessageDialog(jPanel1, "Please select a rating");
            log.error("Please select a rating");
            return;
        }
        
        String feedBack = jTextAreaFeedbackText.getText();
        rating.setRating(selectedRating);
        rating.setFeedBack(feedBack);
        rating.setRatingDate(ratingsDate);
        rating.setStatus(Rating.RatingStatus.RATING_PROVIDED);
        person.addRating(rating);
        log.error("Ratings provided");
        jButtonSubmitReview.setText("Thank you! Your review has been sumbitted!");
        disableControls();
    }//GEN-LAST:event_jButtonSubmitReviewActionPerformed

    ButtonGroup radioButtonGroup = new ButtonGroup();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSubmitReview;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1Star;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2Star;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3Star;
    private javax.swing.JLabel jLabel4Star;
    private javax.swing.JLabel jLabel5Star;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1Star;
    private javax.swing.JRadioButton jRadioButton2Star;
    private javax.swing.JRadioButton jRadioButton3Star;
    private javax.swing.JRadioButton jRadioButton4Star;
    private javax.swing.JRadioButton jRadioButton5Star;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaFeedbackText;
    // End of variables declaration//GEN-END:variables
}
