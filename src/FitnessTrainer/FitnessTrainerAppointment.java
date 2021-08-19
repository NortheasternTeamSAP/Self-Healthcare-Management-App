/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessTrainer;

import Dietitian.Dietitian;
import Patient.Patient;
import java.time.LocalDate;

/**
 *
 * @author preet
 */
public class FitnessTrainerAppointment {
  private LocalDate date;
 Patient patient;
 FitnessTrainer fitnessTrainer;
 int time;
 String injuries;
 String cheifcomplaints;
 String patientMedication;
 Boolean done;

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
 
 

       public enum FitnessAppointmentStatus {
        PENDING,
        COMPLETED
    }

    @Override
    public String toString() {
        return "" + date ;
    }
    
    
    public FitnessTrainerAppointment(LocalDate date, Patient patient,  FitnessTrainer fitnessTrainer,String injuries,String medication,String cheifcomplait) {
        this.date = date;
        this.patient = patient;
        this.fitnessTrainer = fitnessTrainer;
        this.cheifcomplaints=cheifcomplait;
        this.injuries=injuries;
        this.patientMedication=medication;
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

    public FitnessTrainer getFitnessTrainer() {
        return fitnessTrainer;
    }

    public void setFitnessTrainer(FitnessTrainer fitnessTrainer) {
        this.fitnessTrainer = fitnessTrainer;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getInjuries() {
        return injuries;
    }

    public void setInjuries(String injuries) {
        this.injuries = injuries;
    }

    public String getCheifcomplaints() {
        return cheifcomplaints;
    }

    public void setCheifcomplaints(String cheifcomplaints) {
        this.cheifcomplaints = cheifcomplaints;
    }

    public String getPatientMedication() {
        return patientMedication;
    }

    public void setPatientMedication(String patientMedication) {
        this.patientMedication = patientMedication;
    }

  
      
}
