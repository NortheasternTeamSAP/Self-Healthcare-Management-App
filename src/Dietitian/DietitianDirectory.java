/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dietitian;

import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class DietitianDirectory {
    
    ArrayList<Dietitian> dietitians;

    public DietitianDirectory() {
        dietitians = new ArrayList<Dietitian> ();
    }
    
    public void AddDietitian(Dietitian d)
    {
    dietitians.add(d);
 
    }
     public void deleteDeititian(Dietitian d)
            
    {        
        dietitians.remove(d);
    
      }

    public ArrayList<Dietitian> getDietitians() {
        return dietitians;
    }
    
    
    
}
