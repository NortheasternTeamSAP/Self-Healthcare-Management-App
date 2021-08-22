/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Enterprise.Enterprise;
import Personnel.Person;
import SysAdminUI.CreateRolesJPanel;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mrs.katey
 */
public class ViewPersonRatingsJPanel extends javax.swing.JPanel implements NextScreen {
    
    JPanel workArea;
    Person person;
    JPanel backPage;
    List<Rating> ratings = null;
    
    /**
     * Creates new form ViewPersonRatingsJPanel
     */
    public ViewPersonRatingsJPanel(JPanel workArea, Person person, JPanel backPage) {
        initComponents();
        this.workArea = workArea;
        this.person = person;
        this.backPage = backPage;
        jTableReviews.setRowHeight(30);
        ratings = person.getAllRatings();
        jLabelNamePlaceHolder.setText("Name: " + person.getPersonDetails().getFullName());
        jTextAreaReview.setEnabled(false);
        jLabelAverageRatings.setText("Average Rating: " + getAverageRating(ratings));
        populateReviewsTable(this.ratings);
        setUpSortByActionListener();
    }
    
    void setUpSortByActionListener() {
        jComboBoxSortBy.addItemListener(new ItemListener() {
            
            ViewPersonRatingsJPanel parentJPanel = null;
            
            @Override
            public void itemStateChanged(ItemEvent e) {
                parentJPanel.takeActionOnSelectedSortByOption();
            }
            
             private ItemListener init(ViewPersonRatingsJPanel parentJPanel){
                this.parentJPanel = parentJPanel;
                return this;
            }
        }.init(this));
    }
    
    void takeActionOnSelectedSortByOption() {
        String selectedOption = (String) jComboBoxSortBy.getSelectedItem();
        if (selectedOption == null) {
            return;
        }
        
        if ("Select".equals(selectedOption)) {
            // Do nothing
            return;
        }

        if ("Review Date".equals(selectedOption)) {
            List<Rating> sortedRatings = sortRatingsByDate(ratings);
            populateReviewsTable(sortedRatings);
            return;
        }
        
        if ("Ratings".equals(selectedOption)) {
            List<Rating> sortedRatings = sortRatingsByReview(ratings);
            populateReviewsTable(sortedRatings);
            return;
        }
    }
    
    List<Rating> sortRatingsByDate(List<Rating> ratings) {
        
        List<Rating> sortedRatings = new ArrayList<>(ratings);
        Collections.sort(sortedRatings, new Comparator<Rating>() {
            @Override
            public int compare(Rating r1, Rating r2) {
                return r2.getRatingDate().compareTo(r1.getRatingDate());
            }
        });
        
        return sortedRatings;
    }
    
    List<Rating> sortRatingsByReview(List<Rating> ratings) {
        List<Rating> sortedRatings = new ArrayList<>(ratings);
        Collections.sort(sortedRatings, new Comparator<Rating>() {
            @Override
            public int compare(Rating r1, Rating r2) {
                return r1.getRating() - r2.getRating();
            }
        });
        
        return sortedRatings;
    }
    
    String getAverageRating(List<Rating> ratings) {
        if (ratings == null || ratings.isEmpty()) {
            return "0.0";
        }
        
        int sum = 0;
        for (Rating rating : ratings) {
            sum = sum + rating.getRating();
        }
        return new DecimalFormat("#####.#").format((sum * 1.0f)/ratings.size());
    }
    
    void populateReviewsTable(List<Rating> ratings) {
        DefaultTableModel model = new DefaultTableModel()
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                if (column == 0) {
                    return Integer.class;
                }
                
                if (column == 1) {
                    return String.class;
                }
                
                if (column == 2) {
                    return Icon.class;
                }
                
                return String.class;
            }
        };
        model.addColumn("Rating Id");
        model.addColumn("Review date");
        model.addColumn("Rating");

        jTableReviews.setModel(model);
        model.setRowCount(0);
        
        
        for (Rating rating : ratings) {
            Object [] row = new Object[3];
            row[0] = rating.getRatingId();//
            row[1] = rating.getRatingDate().toString();
            row[2] = getRatingIcon(rating.getRating());
            model.addRow(row);
        }
    }
    
    ImageIcon getRatingIcon(int rating) {
        switch (rating) {
            case 1:
                return getResizedIcon("/images_icons/icon-1-star.png");
            case 2:
                return getResizedIcon("/images_icons/icon-2-star.png");
            case 3:
                return getResizedIcon("/images_icons/icon-3-star.png");
            case 4:
                return getResizedIcon("/images_icons/icon-4-star.png");
            case 5:
                return getResizedIcon("/images_icons/icon-5-star.png");
            default:
                throw new RuntimeException("Invalid Rating");
        }
    }
    
    ImageIcon getResizedIcon(String iconPath) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(iconPath));
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReviews = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabelNamePlaceHolder = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jButtonMoreDetails = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaReview = new javax.swing.JTextArea();
        jLabelAverageRatings = new javax.swing.JLabel();
        jComboBoxSortBy = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        jTableReviews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableReviews);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 15)); // NOI18N
        jLabel1.setText("Reviews Summary");

        jLabelNamePlaceHolder.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelNamePlaceHolder.setText("Name: <PlaceHolder>");

        jButtonBack.setText("Back");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonMoreDetails.setText("More Details");
        jButtonMoreDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMoreDetailsActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Review");

        jTextAreaReview.setColumns(20);
        jTextAreaReview.setRows(5);
        jScrollPane2.setViewportView(jTextAreaReview);

        jLabelAverageRatings.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabelAverageRatings.setText("Average Rating: <PlaceHolder>");

        jComboBoxSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Review Date", "Ratings" }));

        jLabel3.setText("Sort By");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonMoreDetails)
                .addGap(403, 403, 403))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButtonBack)
                        .addGap(236, 236, 236)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNamePlaceHolder)
                                .addGap(315, 315, 315))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelAverageRatings)
                                .addGap(124, 124, 124)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButtonBack)))
                .addGap(46, 46, 46)
                .addComponent(jLabelNamePlaceHolder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAverageRatings, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonMoreDetails)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMoreDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMoreDetailsActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTableReviews.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row");
            return;
        }
        
        int ratingId = (int) jTableReviews.getModel().getValueAt(selectedRow, 0);
        for (Rating rating : ratings) {
            if (rating.getRatingId() == ratingId) {
                jTextAreaReview.setText(rating.getFeedBack() == null || rating.getFeedBack().isEmpty() ? "Not Available" : rating.getFeedBack());
                break;
            }
        }
    }//GEN-LAST:event_jButtonMoreDetailsActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        if (backPage == null || workArea == null) {
            return;
        }
        nextScreen(workArea, backPage, "Back Page");
    }//GEN-LAST:event_jButtonBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonMoreDetails;
    private javax.swing.JComboBox<String> jComboBoxSortBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAverageRatings;
    private javax.swing.JLabel jLabelNamePlaceHolder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableReviews;
    private javax.swing.JTextArea jTextAreaReview;
    // End of variables declaration//GEN-END:variables
}
