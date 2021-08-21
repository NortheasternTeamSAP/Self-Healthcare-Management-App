/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import DataStore.Appointment;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.PersonDetails.Gender;
import Personnel.PersonRatings;
import Personnel.Role;
import Personnel.UserAccount;
import Utils.Rating;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.Icon;

/**
 *
 * @author Ankur Bywar
 */
public class Doctor implements Person {
    private PersonDetails doctorDetails;
    private String speciality;
    private ArrayList<Appointment> patientAppointments;
    private Set<String /* Appointment Date + time */> doctorAvailability;
    private PersonRatings personRatings;
    
    public Doctor(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            Icon logoImage,
            UserAccount account) {
        
        doctorDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DOCTOR, logoImage);
        speciality = "Unknown";
        this.patientAppointments = new ArrayList<>();
        this.doctorAvailability = new HashSet<>();
        this.personRatings = new PersonRatings();
    }
   
    public Doctor(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            Icon logoImage,
            UserAccount account,
            int organizationId) {
        
        doctorDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DOCTOR, logoImage, organizationId);
        speciality = "Unknown";
        this.patientAppointments = new ArrayList<>();
        this.doctorAvailability = new HashSet<>();
        this.personRatings = new PersonRatings();
    }
    
    public Doctor(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            Icon logoImage,
            UserAccount account,
            int organizationId,
            String emailId) {
        
        doctorDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.DOCTOR, logoImage, organizationId, emailId);
        speciality = "Unknown";
        this.patientAppointments = new ArrayList<>();
        this.doctorAvailability = new HashSet<>();
        this.personRatings = new PersonRatings();
    }
    
    public String getSpeciality() {
        return speciality;
    }

    @Override
    public UserAccount getUserAccount() {
        return doctorDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return doctorDetails.getRole();
    }

    @Override
    public PersonDetails getPersonDetails() {
        return doctorDetails;
    }
    
    public void addPatientAppointment(Appointment appointment) {
        patientAppointments.add(appointment);
        // update doctor's availability
        doctorAvailability.add(appointment.getDate().toString() + appointment.getAppointmentTimeHours());
    }
    
    public boolean isDoctorAvailable(LocalDate date, int timeHours) {
        return !doctorAvailability.contains(date.toString() + timeHours);
    }
    
    public List<Appointment> getPatientAppointments() {
        return this.patientAppointments;
    }

    @Override
    public int getOrganizationId() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getPersonDetails().getOrganizationId();
    }
    
    @Override
    public void updateDetails(PersonDetails newDoctorDetails) {
        this.doctorDetails = newDoctorDetails;
    }
    
    @Override
    public void addRating(Rating rating) {
        personRatings.addRating(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return personRatings.getAllRatings();
    }
}
