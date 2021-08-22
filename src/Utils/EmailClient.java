/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author mrs.katey
 */
public class EmailClient {
    
    ConsoleLogger log = ConsoleLogger.getLogger();
    
    public boolean sendEmail(String receiverEmail, String senderEmail, String senderPassword, String emailSubject, String emailBody) {
        boolean success = true;
        Properties p = new Properties();
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.host","smtp.gmail.com");
        p.put("mail.smtp.port","587");
        
        Session session = Session.getDefaultInstance(p,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
            message.setSubject(emailSubject);
            message.setText(emailBody);
            Transport.send(message);  
        } catch(Exception ex) {
            success = false;
            log.error("Error while sending email: " + ex.getMessage());
        }
        
        return success;
    }
    
}
