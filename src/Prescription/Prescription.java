/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import DataStore.GenericDirectory;
import Medicine.Medicine;

/**
 *
 * @author Sravya
 */
public class Prescription {
    public GenericDirectory<Medicine, Dosage> prescriptionMap; //map of <Medicine medDetails, Dosage dosage>

    public Prescription() {
        this.prescriptionMap = new GenericDirectory<>();
    }

    public GenericDirectory<Medicine, Dosage> getPrescriptionMap() {
        return prescriptionMap;
    }
}
