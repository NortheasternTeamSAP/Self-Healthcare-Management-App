/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Laboratory.LaboratoryTestReport;
import Personnel.Person;
import java.time.LocalDate;

/**
 *
 * @author Ankur Bywar
 */
public class Appointment implements Comparable<Appointment> {
    
    public enum AppointmentStatus {
        PENDING,
        COMPLETED
    }
    
    private AppointmentStatus status;
    private Person patient;
    private String cheifComplain;
    private Person doctor;
    private LocalDate date;
    private int id;
    private int appointmentTimeHours;
    private String doctorFeedback;
    private LaboratoryTestReport labTestReport;
    private double primaryCareProviderCost;

    private double totalAppointmentCharges;
    
    static int idCounter = 1;

    public Appointment(Person patient, String cheifComplain, Person doctor, LocalDate date, int appointmentTimeHours) {
        this.patient = patient;
        this.cheifComplain = cheifComplain;
        this.doctor = doctor;
        this.date = date;
        this.appointmentTimeHours = appointmentTimeHours;
        this.doctorFeedback = "NotAvailable";
        this.labTestReport = null;
        this.id = idCounter++;
        this.status = AppointmentStatus.PENDING;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
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

    public void setLabTestReport(LaboratoryTestReport labTestReport) {
        this.labTestReport = labTestReport;
    }

    public LaboratoryTestReport getLabTestReport() {
        return labTestReport;
    }
    
    public double getTotalAppointmentCharges() {
        return totalAppointmentCharges;
    }

    public void setTotalAppointmentCharges(double totalAppointmentCharges) {
        this.totalAppointmentCharges = totalAppointmentCharges;
    }

    public double getPrimaryCareProviderCost() {
        return primaryCareProviderCost;
    }

    public void setPrimaryCareProviderCost(double primaryCareProviderCost) {
        this.primaryCareProviderCost = primaryCareProviderCost;
    }
    
    
}
