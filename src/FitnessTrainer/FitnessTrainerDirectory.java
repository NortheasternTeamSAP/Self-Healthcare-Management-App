/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FitnessTrainer;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class FitnessTrainerDirectory {
    ArrayList<FitnessTrainer> fitnessTrainers;

    public FitnessTrainerDirectory() {
        fitnessTrainers = new ArrayList<FitnessTrainer> ();
    }
    
    public void AddFitnessTrainer(FitnessTrainer d)
    {
    fitnessTrainers.add(d);
 
    }
     public void deleteFitnessTrainer(FitnessTrainer d)
            
    {        
        fitnessTrainers.remove(d);
    
      }

    public ArrayList<FitnessTrainer> getFitnessTrainers() {
        return fitnessTrainers;
    }  
}
