/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dietitian;

import Patient.Patient;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class DietitianSchedule {
    
    ArrayList<DietitianAppointment> dietitianAppointments;
    
    
    public DietitianSchedule(){
        dietitianAppointments=new ArrayList<DietitianAppointment>();
     }

    public ArrayList<DietitianAppointment> getDietitianAppointments() {
        return dietitianAppointments;
    }

    public DietitianAppointment ScheduleAppointment(LocalDate date,Patient p, Dietitian d,String r,String m,String c){
        DietitianAppointment appointment=new DietitianAppointment(date,p,d,r,m,c);
        dietitianAppointments.add(appointment);
        return appointment;
    }
}
