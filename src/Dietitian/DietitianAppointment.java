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
    int time;
    String restriction;
    String cheifcomplaints;
    String patientMedication;
    Boolean done=false;

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
    
    
       public enum DietitianAppointmentStatus {
        PENDING,
        COMPLETED
    }

    @Override
    public String toString() {
        return " " + date ;
    }        
    
    public DietitianAppointment(LocalDate date, Patient patient, Dietitian dietitian,String restriction,String medication,String cheifcomplaint) {
        this.date = date;
        this.patient = patient;
        this.dietitian = dietitian;
        this.restriction=restriction;
        this.patientMedication=medication;
        this.cheifcomplaints=cheifcomplaint;
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

    public int getTime() {
        return time;
    }

    public String getRestriction() {
        return restriction;
    }

    public String getCheifcomplaints() {
        return cheifcomplaints;
    }

    public String getPatientMedication() {
        return patientMedication;
    }
    
}
