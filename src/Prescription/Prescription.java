/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import DataStore.GenericDirectory;
import Medicine.Medicine;
import java.time.LocalDate;
import java.util.Map;

/**
 *
 * @author Sravya
 */
public class Prescription implements Comparable<Prescription> {
    private GenericDirectory<Medicine, Dosage> prescriptionMap; //map of <Medicine medDetails, Dosage dosage>
    private LocalDate prescriptionDate;
    private int id;
    private int appointmentId; // appointment associated with this prescription
    
    static int count = 1;

    public Prescription(int appointmentId) {
        this.prescriptionMap = new GenericDirectory<>();
        this.appointmentId = appointmentId;
        this.id = count++;
    }

    public GenericDirectory<Medicine, Dosage> getPrescriptionMap() {
        return prescriptionMap;
    }

    public void setPrescriptionDate(LocalDate prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public LocalDate getPrescriptionDate() {
        return prescriptionDate;
    }
    
    public void addMedicine(Medicine medicine, Dosage dosage) {
        prescriptionMap.add(medicine, dosage);
    }

    public int getId() {
        return id;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    @Override
    public int compareTo(Prescription prescription) {
        return this.getPrescriptionDate().compareTo(prescription.getPrescriptionDate());
    }

    // Merges meds from prescription into this.prescriptionMap
    public void mergePrescription(Prescription prescription) {
        Map<Medicine, Dosage> newPrescriptionMap = prescription.getPrescriptionMap().getIntermalMap();
        for (Map.Entry<Medicine, Dosage> entry : newPrescriptionMap.entrySet()) {
            this.prescriptionMap.add(entry.getKey(), entry.getValue());
        }
    }
}
