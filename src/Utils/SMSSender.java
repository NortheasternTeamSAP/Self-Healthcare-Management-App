/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Ankur Bywar
 */

/*
    Exanple to send SMS:
    SMSSender smsSender = new SMSSender();
    smsSender.sendSMSAsynchronous(recipientNumber, smsBody);

    For SMS to successfully reach recipientNumber, recipientNumber should be first verified with Twilio.
*/

public class SMSSender {
    
    String accountSid = "ACe3009a55744ca108d9174a0906764b5f";
    String authToken = "35b7fad5b9d0d68fb975ec742b7b20e9";
    String fromNumber = "+18505025008"; // This is Twilio generated number and should not be changed
    
    public SMSSender() {
        Twilio.init(accountSid, authToken);
    }
    
    public void sendSMSAsynchronous(String toNumber, String smsBody) {
        SMSObject smsObject = new SMSObject(toNumber, this.fromNumber, smsBody);
        Thread thread = new Thread(new SMSSenderHelper(smsObject, ConsoleLogger.getLogger()));
        thread.start();   
    }    
}
