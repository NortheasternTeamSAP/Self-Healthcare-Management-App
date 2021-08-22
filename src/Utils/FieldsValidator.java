/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Enterprise.EnterpriseType;
import java.awt.Color;
import java.time.Instant;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author mrs.katey
 */
public class FieldsValidator {
    
    Color errorColor = Color.red;
    Color okColor = Color.white;
    
    public boolean validate(JTextField field) {
        boolean error = false;
        if (StringUtils.isEmpty(field.getText())) {
            field.setBackground(errorColor);
            error = true;
        } else {
            field.setBackground(okColor);
        }
        return error;
    }
    
    public boolean validate(JTextField field, int length) {
        boolean error = false;
        if (StringUtils.isEmpty(field.getText()) || !StringUtils.isNumeric(field.getText()) || field.getText().length() != length) {
            field.setBackground(errorColor);
            error = true;
        } else {
            field.setBackground(okColor);
        }
        return error;
    }
    
    public boolean validateLong(JTextField field, double low, double high) {
        boolean error = false;
        String val = field.getText();
        try {
            if (StringUtils.isEmpty(val) || 
                    !StringUtils.isNumeric(val) || 
                    Long.parseLong(val) < low ||
                    Long.parseLong(val) > high) {
                field.setBackground(errorColor);
                error = true;
            } else {
                field.setBackground(okColor);
            }
        } catch (Exception e) {
            field.setBackground(errorColor);
            error = true;
        }

        return error;
    }
    
    public boolean validate(com.toedter.calendar.JDateChooser date) {
        boolean error = false;
        Date dt = date.getDate();
        Date currentDate = Date.from(Instant.now());
        if (dt == null) {
            date.setBackground(errorColor);
            error = true;
        } else {
            date.setBackground(okColor);
            error = false;
        }
        return error;
    }
    
    public boolean validate(JComboBox<String> comboBox) {
        boolean error = false;
        
        String selectedField = String.valueOf(comboBox.getSelectedItem());
        if ("Select".equals(selectedField)) {
            comboBox.setBackground(errorColor);
            error = true;
        } else {
            comboBox.setBackground(okColor);
            error = false;
        }
        return error;
    }
    
    public boolean validateEmail(JTextField emailId) {
        EmailValidator validator = EmailValidator.getInstance();
        boolean error = false;
        if (StringUtils.isEmpty(emailId.getText()) || !validator.isValid(emailId.getText())) {
            emailId.setBackground(errorColor);
            error = true;
        } else {
            emailId.setBackground(okColor);
        }
        return error;
    }
    
    public boolean validate(
            JTextField name, 
            JTextField emailId,
            JTextField userName, 
            JPasswordField password,
            JTextField phoneNumber,
            com.toedter.calendar.JDateChooser dob,
            JTextField addressStreet,
            JTextField addressUnit,
            JTextField addressCity,
            JTextField addressZip,
            JComboBox<String> state,
            JTextField addressCountry,
            JComboBox<String> gender
            ) {

        boolean error = false;
        
        error |= validate(name);
        error |= validateEmail(emailId);
        error |= validate(userName);
        error |= validate(password);
        error |= validate(phoneNumber, 10);
        error |= validate(dob);
        error |= validate(addressStreet);
        error |= validate(addressUnit);
        error |= validate(addressCity);
        error |= validate(addressCountry);
        error |= validate(addressZip, 5);
        error |= validate(state);
        error |= validate(gender);
        
        return error;
    }
    
}
