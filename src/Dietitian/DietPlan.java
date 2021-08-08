/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dietitian;

import Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class DietPlan {
    private Patient patient ;
    private Dietitian dietitian;
    ArrayList<String> mealplans;

    @Override
    public String toString() {
        return "DietPlan{" + "patient=" + patient + ", dietitian=" + dietitian + ", mealplans=" + mealplans + '}';
    }
    
    public DietPlan(Patient patient, Dietitian dietitian, ArrayList<String> mealplans)
    {        
        this.patient = patient;
        this.dietitian = dietitian;
        this.mealplans = mealplans;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dietitian getDietitian() {
        return dietitian;
    }

    public void setDietitian(Dietitian dietitian) {
        this.dietitian = dietitian;
    }   
}
