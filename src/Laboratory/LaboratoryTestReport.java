/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratory;

import DataStore.Appointment;
import Organization.Organization;
import Personnel.Person;
import Utils.IdProvider;
import java.time.Instant;
import java.time.LocalDate;

/**
 *
 * @author Ankur Bywar
 */
public class LaboratoryTestReport {
    
    public enum LabTestStatus {
        PENDING,
        COMPLETED
    }
    
    private Organization lab;
    private LaboratoryAssistant labAssistant;
    private Person patient;
    private Person doctor;
    private Appointment appointment;
    private LocalDate labTestDate;
    private LaboratoryTest testResults;
    private long id;
    private double labTestCost;
    private LabTestStatus labTestStatus;

    public LaboratoryTestReport(
            Organization lab, 
            LaboratoryAssistant labAssistant, 
            Person patient, 
            Person doctor, 
            Appointment appointment,
            LocalDate labTestDate) {
        this.lab = lab;
        this.labAssistant = labAssistant;
        this.patient = patient;
        this.doctor = doctor;
        this.appointment = appointment;
        this.labTestDate = labTestDate;
        this.testResults = null;
        this.id = IdProvider.getUUID();
        this.labTestStatus = LabTestStatus.PENDING;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public long getId() {
        return id;
    }
    
    public Organization getLab() {
        return lab;
    }

    public LaboratoryAssistant getLabAssistant() {
        return labAssistant;
    }

    public Person getPatient() {
        return patient;
    }

    public Person getDoctor() {
        return doctor;
    }

    public LocalDate getLabTestDate() {
        return labTestDate;
    }
    
    public void setLaboratoryTestResult(LaboratoryTest testResults) {
        this.testResults = testResults;
    }
    
    public LaboratoryTest getLaboratoryTestResult() {
        return this.testResults;
    }
    
    public double getLabTestCost() {
        return labTestCost;
    }

    public void setLabTestCost(double labTestCost) {
        this.labTestCost = labTestCost;
    }

    public LabTestStatus getLabTestStatus() {
        return labTestStatus;
    }

    public void setLabTestStatus(LabTestStatus labTestStatus) {
        this.labTestStatus = labTestStatus;
    }
    
}
