/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

/**
 *
 * @author sravy
 */
public class Dosage {
    int medicineDosage;
    int intervalInHours;
    String prescriptionNotes;

    public Dosage(
                int medicineDosage, 
                int intervalInHours, 
                String prescriptionNotes
            ){
        this.medicineDosage = medicineDosage;
        this.intervalInHours = intervalInHours;
        this.prescriptionNotes = prescriptionNotes;
    }

    public int getMedicineDosage() {
        return medicineDosage;
    }

    public void setMedicineDosage(int medicineDosage) {
        this.medicineDosage = medicineDosage;
    }

    public int getIntervalInHours() {
        return intervalInHours;
    }

    public void setIntervalInHours(int intervalInHours) {
        this.intervalInHours = intervalInHours;
    }

    public String getPrescriptionNotes() {
        return prescriptionNotes;
    }

    public void setPrescriptionNotes(String prescriptionNotes) {
        this.prescriptionNotes = prescriptionNotes;
    }
}
