/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessTrainer;


import Patient.Patient;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class FitnessTrainerSchedule {
       ArrayList<FitnessTrainerAppointment> fitnessTrainerAppointments;
    
    
    public FitnessTrainerSchedule(){
        fitnessTrainerAppointments=new ArrayList<FitnessTrainerAppointment>();
     }

    public ArrayList<FitnessTrainerAppointment> getFitnessTrainerAppointments() {
        return fitnessTrainerAppointments;
    }

    public FitnessTrainerAppointment ScheduleAppointment(LocalDate date,Patient p, FitnessTrainer d,String restriction,String medication,String cheifcomplaint){
        FitnessTrainerAppointment appointment=new FitnessTrainerAppointment(date,p,d,restriction,medication,cheifcomplaint);
        fitnessTrainerAppointments.add(appointment);
        return appointment;
    }
}
