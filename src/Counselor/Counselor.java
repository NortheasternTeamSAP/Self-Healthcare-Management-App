/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counselor;

import Dietitian.DietPlan;
import Dietitian.DietitianAppointment;
import Dietitian.DietitianSchedule;
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
public class Counselor implements Person{
    
    
     private PersonDetails counselorDetails;
    private CounselorSchedule counselorSchedule;
    
    public Counselor(
            String fullName, 
            LocalDate dob, 
            PersonDetails.Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        counselorDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.COUNSELOR);
        counselorSchedule = new CounselorSchedule();
    }

    @Override
    public UserAccount getUserAccount() {
        return counselorDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return counselorDetails.getRole();
    }
    
    public CounselorAppointment scheduleAppointment (LocalDate d,Patient p ){
        return counselorSchedule.ScheduleAppointment(d, p, this);
    }

    public CounselorSchedule getCounselorSchedule() {
        return counselorSchedule;
    }
    
    
    public void addCounsellingNote(Patient p, String CounsellingNote){    
        CounsellingNote dp= new CounsellingNote(p,this, CounsellingNote);
        p.addCounsellingNotes(dp);
    }

    @Override
    public PersonDetails getPersonDetails() {
        return counselorDetails;
    }
    
}
