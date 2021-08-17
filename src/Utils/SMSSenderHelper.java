/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ankur Bywar
 */
class SMSSenderHelper implements Runnable {

    SMSObject smsObject;
    ConsoleLogger log;
    
    public SMSSenderHelper(SMSObject smsObject, ConsoleLogger log) {
        this.smsObject = smsObject;
        this.log = log;
    }
    
    @Override
    public void run() {
        Message message = Message.creator(
            new PhoneNumber(smsObject.getToNumber()),
            new PhoneNumber(smsObject.getFromNumber()),
            smsObject.getBody()
        ).create();
        
        boolean pending = true;
        while (pending) {
            switch (message.getStatus()) {
                // SENT, FAILED, DELIVERED, UNDELIVERED
                case SENT:
                case DELIVERED:
                case UNDELIVERED:
                    log.debug("SMS to" + smsObject.getToNumber() + " from: " + smsObject.getFromNumber() + " status: " + message.getStatus().toString());
                    pending = false;
                    break;
                 
                case FAILED:
                    log.debug("SMS to" + smsObject.getToNumber() + " from: " + smsObject.getFromNumber() + " status: " + message.getStatus().toString());
                    pending = false;
                    break;
                    
                default:
                {
                    try {
                        Thread.sleep(1000); // wait for 1 second before checking again
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
        
        log.debug("Exiting SMSSender");
    }
    
}
