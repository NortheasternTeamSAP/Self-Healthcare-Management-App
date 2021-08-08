/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counselor;

import Dietitian.Dietitian;
import Patient.Patient;
import java.util.ArrayList;

/**
 *
 * @author preet
 */
public class CounsellingNote {
    private Patient patient ;
    private Counselor counselor;
    String counsellingNote;

    @Override
    public String toString() {
        return "CounsellingNote{" + "patient=" + patient + ", counselor=" + counselor + ", counsellingNote=" + counsellingNote + '}';
    }

   
    public CounsellingNote(Patient patient, Counselor counselor,String note)
    {        
        this.patient = patient;
        this.counselor = counselor;
        this.counsellingNote = note;
    }

    public Counselor getCounselor() {
        return counselor;
    }

    public void setCounselor(Counselor counselor) {
        this.counselor = counselor;
    }

    public String getCounsellingNote() {
        return counsellingNote;
    }

    public void setCounsellingNote(String counsellingNote) {
        this.counsellingNote = counsellingNote;
    }

   

  
}
