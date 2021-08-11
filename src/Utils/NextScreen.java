/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Ankur Bywar
 */
public interface NextScreen {
   
    default void nextScreen(JFrame mainJFrame, JPanel mainWorkArea, JPanel nextScreen, String screenName) {
        mainWorkArea.removeAll();
        mainWorkArea.add(screenName , nextScreen);
        mainWorkArea.setAlignmentX(SwingConstants.CENTER);
        mainWorkArea.setAlignmentY(SwingConstants.CENTER);
        CardLayout layout = (CardLayout)mainWorkArea.getLayout();
        Dimension d = nextScreen.getLayout().preferredLayoutSize(nextScreen);
        mainJFrame.setSize(d);
        layout.next(mainWorkArea); 
    }
        
    default void nextScreen(JPanel mainWorkArea, JPanel nextScreen, String screenName) {
        mainWorkArea.add(screenName , nextScreen);
        CardLayout layout = (CardLayout)mainWorkArea.getLayout();
        layout.next(mainWorkArea);
    }
    
    
}
