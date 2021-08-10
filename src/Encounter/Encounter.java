/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encounter;

import Patient.Patient;
import Personnel.Person;
import VitalSign.VitalSigns;
import java.util.Date;

/**
 *
 * @author Ankur Bywar
 */
public class Encounter {
    Person patient;
    Person doctor;
    Date date;
    String chiefComplain;
    VitalSigns vitalSigns;

    public Encounter(Patient patient, VitalSigns vitalSigns) {
        this.patient = patient;
        this.vitalSigns = vitalSigns;
    }

    public Person getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public Person getDoctor() {
        return doctor;
    }

    public Date getDate() {
        return date;
    }

    public String getChiefComplain() {
        return chiefComplain;
    }
    
}
