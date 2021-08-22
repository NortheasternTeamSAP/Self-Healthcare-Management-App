/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Personnel.Person;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mrs.katey
 */
public class StarRatingsUtil {
    
    public void openRatingsJPanel(String panelName, Person person, Rating rating, LocalDate ratingsDate) {
        JFrame frame = new JFrame(panelName);
        JPanel ratingsPanel = new RatingsJPanel(person, rating, ratingsDate);
        frame.add(ratingsPanel);
        ratingsPanel.setVisible(true);
        frame.setVisible(true);
        frame.setSize(600, 600);
    }
    
    public void viewPersonRatings(String panelName, Person person) {
        JFrame frame = new JFrame(panelName);
        JPanel viewRatings = new ViewPersonRatingsJPanel(null, person, null);
        frame.add(viewRatings);
        viewRatings.setVisible(true);
        frame.setVisible(true);
        frame.setSize(600, 600);
    }
}
