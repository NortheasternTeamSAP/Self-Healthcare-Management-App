/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import DataStore.GenericDirectory;
import Enterprise.Enterprise;
import java.util.List;

/**
 *
 * @author mrs.katey
 */
public class PrescriptionDirectory {
    GenericDirectory<Long /* appointment id */, Prescription> directory;
    
    public PrescriptionDirectory() {
        directory = new GenericDirectory<>();
    }
    
    public void addPrescription(long appointmentId, Prescription prescription) {
        directory.add(appointmentId, prescription);
    }
    
    public Prescription getPrescription(long appointmentId) {
        return directory.get(appointmentId);
    }
}
