/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Ankur Bywar
 */
public class SMSObject {
    
    private String toNumber;
    private String fromNumber;
    private String body;

    public SMSObject(String toNumber, String fromNumber, String body) {
        this.toNumber = toNumber;
        this.fromNumber = fromNumber;
        this.body = body;
    }

    public String getToNumber() {
        return toNumber;
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public String getBody() {
        return body;
    }
}
