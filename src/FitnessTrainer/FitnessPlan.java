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
    ArrayList<Excercise> excercises;
    int weightstaken;
    int cardiotaken;
    int crosstrainingtaken;
    

    public FitnessTrainer getFitnessTrainer() {
        return fitnessTrainer;
    }

    public ArrayList<Excercise> getExcercises() {
        return excercises;
    }
    
    
    
 public enum Excercise{
        Cardio("Cardio"),
        Weight("Weight"),
        CrossTraining("CrossTraining");
        private String value;
        
        private Excercise(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
        return value;
    }
    }

    @Override
    public String toString() {
        return "" + fitnessplans ;
    }


    
    public FitnessPlan(Patient patient, FitnessTrainer fitnessTrainer, ArrayList<String> fitnessplans,ArrayList<Excercise> e)
    {        
        this.patient = patient;
        this.fitnessTrainer = fitnessTrainer;
        this.fitnessplans = fitnessplans;
        this.excercises=e;
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

    public int getWeightstaken() {
        return weightstaken;
    }

    public int getCardiotaken() {
        return cardiotaken;
    }

    public int getCrosstrainingtaken() {
        return crosstrainingtaken;
    }

    public void setWeightstaken(int weightstaken) {
        this.weightstaken = weightstaken;
    }

    public void setCardiotaken(int cardiotaken) {
        this.cardiotaken = cardiotaken;
    }

    public void setCrosstrainingtaken(int crosstrainingtaken) {
        this.crosstrainingtaken = crosstrainingtaken;
    }

   
}
