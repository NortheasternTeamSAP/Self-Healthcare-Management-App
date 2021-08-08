/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkQueue;

import java.time.LocalDate;


/**
 *
 * @author Sravya
 */
public abstract class WorkRequest {
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private LocalDate requestDate;
    private LocalDate resolveDate;

    public WorkRequest() {
        requestDate = new LocalDate(int year, short month, short dayOfMonth);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDate getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(LocalDate resolveDate) {
        this.resolveDate = resolveDate;
    }
    
    @Override
    public String toString(){
        return this.message;
    }  
}
