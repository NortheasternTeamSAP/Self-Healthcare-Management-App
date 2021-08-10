/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Personnel.Person;
import java.time.LocalDate;

/**
 *
 * @author Ankur Bywar
 */
public class Appointment implements Comparable<Appointment> {
    private Person patient;
    private String cheifComplain;
    private Person doctor;
    private LocalDate date;
    private int id;
    private int appointmentTimeHours;
    private String doctorFeedback;
    
    static int idCounter = 1;

    public Appointment(Person patient, String cheifComplain, Person doctor, LocalDate date, int appointmentTimeHours) {
        this.patient = patient;
        this.cheifComplain = cheifComplain;
        this.doctor = doctor;
        this.date = date;
        this.appointmentTimeHours = appointmentTimeHours;
        this.doctorFeedback = "NotAvailable";
        this.id = idCounter++;
    }

    public int getId() {
        return id;
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

    public LocalDate getDate() {
        return date;
    }
    
    public int getAppointmentTimeHours() {
        return appointmentTimeHours;
    }

    @Override
    public int compareTo(Appointment apt) {
        return this.getDate().isAfter(apt.getDate()) ? 1 : 0;
    }

    public String getDoctorFeedback() {
        return this.doctorFeedback;
    }
    
    public void setDoctorFeedback(String doctorFeedback) {
        this.doctorFeedback = doctorFeedback;
    }
    
    
}
