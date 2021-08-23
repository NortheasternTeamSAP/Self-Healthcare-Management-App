/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStore;

import Laboratory.LaboratoryTestReport;
import Personnel.Person;
import Utils.IdProvider;
import Utils.Rating;
import java.time.Instant;
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
    private long id;
    private int appointmentTimeHours;
    private String doctorFeedback;
    private LaboratoryTestReport labTestReport;
    private double primaryCareProviderCost;

    private double totalAppointmentCharges;
    
    private String patientVitalSignsHistoryS3ObjectPath;
    private String patientInsuranceFileS3ObjectPath;
    private String patientPrescriptionsFileS3ObjectPath;
    private Rating rating;
   

    public Appointment(Person patient, String cheifComplain, Person doctor, LocalDate date, int appointmentTimeHours) {
        this.patient = patient;
        this.cheifComplain = cheifComplain;
        this.doctor = doctor;
        this.date = date;
        this.appointmentTimeHours = appointmentTimeHours;
        this.doctorFeedback = "NotAvailable";
        this.labTestReport = null;
        this.id = IdProvider.getUUID();
        this.status = AppointmentStatus.PENDING;
        this.patientVitalSignsHistoryS3ObjectPath = null; // Null because this will be set after the appointment is booked
        this.patientInsuranceFileS3ObjectPath = null;
        this.rating = null;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public long getId() {
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

    public String getPatientVitalSignsHistoryS3ObjectPath() {
        return patientVitalSignsHistoryS3ObjectPath;
    }

    public void setPatientVitalSignsHistoryS3ObjectPath(String patientVitalSignsHistoryS3ObjectPath) {
        this.patientVitalSignsHistoryS3ObjectPath = patientVitalSignsHistoryS3ObjectPath;
    }
    
    public void setPatientInsuranceFileS3ObjectPath(String patientInsuranceFileS3ObjectPath) {
        this.patientInsuranceFileS3ObjectPath = patientInsuranceFileS3ObjectPath;
    }

    public String getPatientInsuranceFileS3ObjectPath() {
        return patientInsuranceFileS3ObjectPath;
    }
    
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getPatientPrescriptionsFileS3ObjectPath() {
        return patientPrescriptionsFileS3ObjectPath;
    }

    public void setPatientPrescriptionsFileS3ObjectPath(String patientPrescriptionsFileS3ObjectPath) {
        this.patientPrescriptionsFileS3ObjectPath = patientPrescriptionsFileS3ObjectPath;
    }
    
    
}
