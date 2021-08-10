/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessTrainer;

import Dietitian.Dietitian;
import Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class FitnessPlan {
     private Patient patient ;
    private FitnessTrainer fitnessTrainer;
    ArrayList<String> fitnessplans;

    @Override
    public String toString() {
        return "" + fitnessplans ;
    }


    
    public FitnessPlan(Patient patient, FitnessTrainer fitnessTrainer, ArrayList<String> fitnessplans)
    {        
        this.patient = patient;
        this.fitnessTrainer = fitnessTrainer;
        this.fitnessplans = fitnessplans;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ArrayList<String> getFitnessplans() {
        return fitnessplans;
    }

   
}
