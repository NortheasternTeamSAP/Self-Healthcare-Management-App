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
    String pastmentalhealth;
    String cheifcomplaints;
    String patientMedication;

    
       public enum CounselorAppointmentStatus {
        PENDING,
        COMPLETED
    }

    public int getTime() {
        return time;
    }

    public String getPastmentalhealth() {
        return pastmentalhealth;
    }

    public String getCheifcomplaints() {
        return cheifcomplaints;
    }

    public String getPatientMedication() {
        return patientMedication;
    }

    
    @Override
    public String toString() {
        return "CounselorAppointment{" + "date=" + date + ", patient=" + patient + ", counselor=" + counselor + '}';
    }

    public CounselorAppointment(LocalDate date, Patient patient, Counselor counselor,String r,String m,String c) {
        this.date = date;
        this.patient = patient;
        this.counselor = counselor;
        this.cheifcomplaints=c;
        this.pastmentalhealth=r;
        this.patientMedication=m;
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
