/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIPatientDoctorInsuranceProvider;

import java.time.LocalDate;

/**
 *
 * @author mrs.katey
 */
public class UIAppointmentEntry {
    
    String patientName;
    String appointmentWith;
    String roleType;
    LocalDate date;
    int hours;

    public UIAppointmentEntry(String patientName, String appointmentWith, String roleType, LocalDate date, int hours) {
        this.patientName = patientName;
        this.appointmentWith = appointmentWith;
        this.roleType = roleType;
        this.date = date;
        this.hours = hours;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getAppointmentWith() {
        return appointmentWith;
    }

    public String getRoleType() {
        return roleType;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }
    
    
    
}
