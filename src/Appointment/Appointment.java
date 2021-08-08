/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import Personnel.Person;
import VitalSign.VitalSigns;
import java.util.Date;

/**
 *
 * @author Ankur Bywar
 */
public class Appointment {
    private Person patient;
    private String cheifComplain;
    private Person doctor;
    private Date date;
    VitalSigns vs;

    public Appointment(Person patient, String cheifComplain, Person doctor, Date date) {
        this.patient = patient;
        this.cheifComplain = cheifComplain;
        this.doctor = doctor;
        this.date = date;
        this.vs = null;
    }

    public VitalSigns getVitalSign() {
        return vs;
    }

    public void setVitalsSign(VitalSigns vs) {
        this.vs = vs;
    }

    public Person getPatient() {
        return patient;
    }

    public String getCheifComplain() {
        return cheifComplain;
    }

    public Person getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
    }
    
    
}
