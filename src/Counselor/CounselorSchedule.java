/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counselor;

import Dietitian.Dietitian;
import Dietitian.DietitianAppointment;
import Patient.Patient;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class CounselorSchedule {
    
    ArrayList<CounselorAppointment> counselorAppointments;
    
    
    public CounselorSchedule(){
        counselorAppointments=new ArrayList<CounselorAppointment>();
     }



    public CounselorAppointment ScheduleAppointment(LocalDate date,Patient p, Counselor c){
        CounselorAppointment appointment=new CounselorAppointment(date,p,c);
        counselorAppointments.add(appointment);
        return appointment;
    }  

    public ArrayList<CounselorAppointment> getCounselorAppointments() {
        return counselorAppointments;
    }
}
