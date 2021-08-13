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

       public enum FitnessAppointmentStatus {
        PENDING,
        COMPLETED
    }

    @Override
    public String toString() {
        return "FitnessTrainerAppointment{" + "date=" + date + ", patient=" + patient + ", fitnessTrainer=" + fitnessTrainer + '}';
    }
    
    
    public FitnessTrainerAppointment(LocalDate date, Patient patient,  FitnessTrainer fitnessTrainer) {
        this.date = date;
        this.patient = patient;
        this.fitnessTrainer = fitnessTrainer;
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

  
      
}
