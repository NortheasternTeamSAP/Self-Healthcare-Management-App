/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dietitian;

import Patient.Patient;
import java.time.LocalDate;

/**
 *
 * @author preet
 */
public class DietitianAppointment {
    private LocalDate date;
    Patient patient;
    Dietitian dietitian;

    @Override
    public String toString() {
        return "DietitianAppointment{" + "date=" + date + ", patient=" + patient + ", dietitian=" + dietitian + '}';
    }        
    
    public DietitianAppointment(LocalDate date, Patient patient, Dietitian dietitian) {
        this.date = date;
        this.patient = patient;
        this.dietitian = dietitian;
    }
    

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dietitian getDietitian() {
        return dietitian;
    }

    public void setDietitian(Dietitian dietitian) {
        this.dietitian = dietitian;
    }
    
}
