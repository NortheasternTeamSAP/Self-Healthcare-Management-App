/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author mrs.katey
 */
public class FieldsDecorator {
    
    static Color disableColor = new Color(217, 217, 217);
    static Color enableColor = Color.WHITE;
    
    public static void decorate(JTextComponent field, boolean enable) {
        if (enable) {
            enableFunc(field);
        } else {
            disableFunc(field);
        }
    }
    
    public static void enableFunc(JTextComponent field) {
        field.setEditable(true);
        field.setEnabled(true);
        field.setBackground(enableColor);
    }
    
    public static void disableFunc(JTextComponent field) {
        field.setEditable(false);
        field.setEnabled(false);
        field.setBackground(disableColor);
    }
    
    public static void decorateTable(JTable table) {
        //table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(204, 239, 255));
    }
    
    public static void decorateTable(JTable table, Color color) {
        //table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(color);
    }
}
