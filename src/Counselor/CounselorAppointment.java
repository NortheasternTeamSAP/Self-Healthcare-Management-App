/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counselor;

import Patient.Patient;
import java.time.LocalDate;

/**
 *
 * @author preet
 */
public class CounselorAppointment {
    private LocalDate date;
    Patient patient;
    Counselor counselor;
    int time;

    
       public enum CounselorAppointmentStatus {
        PENDING,
        COMPLETED
    }

    
    @Override
    public String toString() {
        return "CounselorAppointment{" + "date=" + date + ", patient=" + patient + ", counselor=" + counselor + '}';
    }

    public CounselorAppointment(LocalDate date, Patient patient, Counselor counselor) {
        this.date = date;
        this.patient = patient;
        this.counselor = counselor;
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

    public Counselor getCounselor() {
        return counselor;
    }

    public void setCounselor(Counselor counselor) {
        this.counselor = counselor;
    }
    


}
