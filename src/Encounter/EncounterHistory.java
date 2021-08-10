/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encounter;

import VitalSign.VitalSigns;
import java.util.ArrayList;

/**
 *
 * @author Ankur Bywar
 */
public class EncounterHistory {
    private ArrayList<VitalSigns> encounter;
    public EncounterHistory(ArrayList<VitalSigns> encounter) {
        this.encounter = encounter;
    }

    public ArrayList<VitalSigns> getEncounter() {
        return encounter;
    }

    public void setEncounter(ArrayList<VitalSigns> encounter) {
        this.encounter = encounter;
    }
    
}
