/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessTrainer;
import FitnessTrainer.FitnessPlan.Excercise;
import Patient.Patient;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
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
 * @author preet
 */
public class FitnessTrainer implements Person{
    
    private PersonDetails fitnessTrainerDetails;
    private FitnessTrainerSchedule fitnessTrainerSchedule;
    private Set<String /* Appointment Date + time */> availability;
    private PersonRatings personRatings;
    

    public FitnessTrainer(
            String fullName, 
            LocalDate dob, 
            PersonDetails.Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account,
            Icon icon,
            long organizationId) {
        fitnessTrainerDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.TRAINER,icon, organizationId);
        fitnessTrainerSchedule = new FitnessTrainerSchedule();
        this.availability = new HashSet<>();
        this.personRatings = new PersonRatings();
    }
    
    public FitnessTrainer(
            String fullName, 
            LocalDate dob, 
            PersonDetails.Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account,
            Icon icon,
            long organizationId,
            String emailId) {
        fitnessTrainerDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.TRAINER,icon, organizationId, emailId);
        fitnessTrainerSchedule = new FitnessTrainerSchedule();
        this.availability = new HashSet<>();
        this.personRatings = new PersonRatings();
    }

    @Override
    public UserAccount getUserAccount() {
        return fitnessTrainerDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return fitnessTrainerDetails.getRole();
    }
    
    public boolean isFitnessTrainerAvailable(LocalDate date, int timeHours) {
        return !availability.contains(date.toString() + timeHours);
    }        
    
    public FitnessTrainerAppointment scheduleAppointment (LocalDate d,Patient p, int timeHours,String restriction,String medication,String cheifcomplaint ){
        availability.add(d.toString() + timeHours);
        return fitnessTrainerSchedule.ScheduleAppointment(d, p, this,restriction,medication,cheifcomplaint);
    }

    public FitnessTrainerSchedule getFitnessTrainerSchedule() {
        return fitnessTrainerSchedule;
    }
    
    
    public void addFitnessPlan(Patient p, ArrayList<String> plan,ArrayList<Excercise> e){    
        FitnessPlan fp= new FitnessPlan(p,this, plan,e);
        p.addFitnessPlan(fp);
    }
    
    @Override
    public PersonDetails getPersonDetails() {
        return fitnessTrainerDetails;
    }

    @Override
    public String toString() {
        return "" + fitnessTrainerDetails.getFullName();
    }

    public PersonDetails getFitnessTrainerDetails() {
        return fitnessTrainerDetails;
    }

    @Override
    public long getOrganizationId() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         return getPersonDetails().getOrganizationId();
    }
    
    @Override
    public void updateDetails(PersonDetails newFitnessTrainerDetails) {
        this.fitnessTrainerDetails = newFitnessTrainerDetails;
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
