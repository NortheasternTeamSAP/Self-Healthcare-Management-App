/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessTrainer;
import Patient.Patient;
import Personnel.Address;
import Personnel.Person;
import Personnel.PersonDetails;
import Personnel.Role;
import Personnel.UserAccount;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class FitnessTrainer implements Person{
    
    private PersonDetails fitnessTrainerDetails;
    private FitnessTrainerSchedule fitnessTrainerSchedule;
    
    public FitnessTrainer(
            String fullName, 
            LocalDate dob, 
            PersonDetails.Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        fitnessTrainerDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.TRAINER);
        fitnessTrainerSchedule = new FitnessTrainerSchedule();
    }

    @Override
    public UserAccount getUserAccount() {
        return fitnessTrainerDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return fitnessTrainerDetails.getRole();
    }
    
    public FitnessTrainerAppointment scheduleAppointment (LocalDate d,Patient p ){
        return fitnessTrainerSchedule.ScheduleAppointment(d, p, this);
    }

    public FitnessTrainerSchedule getFitnessTrainerSchedule() {
        return fitnessTrainerSchedule;
    }
    
    
    public void addFitnessPlan(Patient p, ArrayList<String> fitnessplans){    
        FitnessPlan fp= new FitnessPlan(p,this, fitnessplans);
        p.addFitnessPlan(fp);
    }
    
    @Override
    public PersonDetails getPersonDetails() {
        return fitnessTrainerDetails;
    }
}
