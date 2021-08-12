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
    private ArrayList<String> mealplans;
    private int carbohydrates;
    private int protein;
    private int fat;
    private int fiber;
    @Override
    public String toString() {
        return "DietPlan{" + "patient=" + patient + ", dietitian=" + dietitian + ", mealplans=" + mealplans + '}';
    }
    
    public DietPlan(Patient patient, Dietitian dietitian, ArrayList<String> mealplans,int carb,int fat ,int protein, int fiber)
    {        
        this.patient = patient;
        this.dietitian = dietitian;
        this.mealplans = mealplans;
        this.fat=fat;
        this.carbohydrates=carb;
        this.fiber=fiber;
        this.protein=protein;
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

    public ArrayList<String> getMealplans() {
        return mealplans;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }
       
    
}
