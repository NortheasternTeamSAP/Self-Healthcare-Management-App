/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counselor;

import Dietitian.Dietitian;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class CounselorDirectory {
      ArrayList<Counselor> counselors;

    public CounselorDirectory() {
        counselors = new ArrayList<Counselor> ();
    }
    
    public void AddCounselor(Counselor c)
    {
    counselors.add(c);
 
    }
     public void deleteDCounselor(Counselor c)
            
    {        
        counselors.remove(c);
    
      }

    public ArrayList<Counselor> getCounselors() {
        return counselors;
    }
    
}
