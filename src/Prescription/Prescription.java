/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import DataStore.Appointment;
import DataStore.GenericDirectory;
import Medicine.Medicine;
import Utils.IdProvider;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Sravya
 */
public class Prescription implements Comparable<Prescription> {
    private GenericDirectory<Medicine, Dosage> prescriptionMap; //map of <Medicine medDetails, Dosage dosage>
    private LocalDate prescriptionDate;
    private long id;
    private Appointment appointment; // appointment associated with this prescription
    private DeliveryMan.DeliveryMan deliveryMan;
    boolean deliveryReviewProvided;
    private Date deliveryDate;
    private String pharmacyName;

    public String getFormattedString() {
        return "\nPrescription issued on date: " + prescriptionDate.toString() +
                "\n Patient: " + appointment.getPatient().getPersonDetails().getFullName() +
                "\n Primary Care doctor: " + appointment.getDoctor().getPersonDetails().getFullName() +
                "\n Pharmacy Name: " + pharmacyName +
                "\n Prescription Details: " + getFormattedPrescriptionEntries() + 
                "\n ***********************************************************************************************";
    }
    
    private String getFormattedPrescriptionEntries() {
        StringBuilder sb = new StringBuilder();
        Map<Medicine, Dosage> map = prescriptionMap.getIntermalMap();
        for (Map.Entry<Medicine, Dosage>  entry : map.entrySet()) {
            Medicine med = entry.getKey();
            Dosage dosage = entry.getValue();
            sb.append("\n   Medicine: " + med.getMedicineName() + ", dosage: " + dosage.getMedicineDosage() + ", timing: " + dosage.getDosageTimingDetails());
            sb.append("\n   Notes: " + dosage.getPrescriptionNotes());
        }
        return sb.toString();
    }
    
    public DeliveryMan.DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan.DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public void setDeliveryReviewProvided(boolean deliveryReviewProvided) {
        this.deliveryReviewProvided = deliveryReviewProvided;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    public boolean isDeliveryReviewProvided() {
        return this.deliveryReviewProvided;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Prescription(Appointment appointment) {
        this.prescriptionMap = new GenericDirectory<>();
        this.prescriptionDate = appointment.getDate();
        this.appointment = appointment;
        this.deliveryReviewProvided = false;
        this.deliveryDate = null;
        this.pharmacyName = null;
        this.id = IdProvider.getUUID();
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

    public long getId() {
        return id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    @Override
    public int compareTo(Prescription prescription) {
        return prescription.getPrescriptionDate().compareTo(this.getPrescriptionDate()); // descending order
    }

    // Merges meds from prescription into this.prescriptionMap
    public void mergePrescription(Prescription prescription) {
        Map<Medicine, Dosage> newPrescriptionMap = prescription.getPrescriptionMap().getIntermalMap();
        for (Map.Entry<Medicine, Dosage> entry : newPrescriptionMap.entrySet()) {
            this.prescriptionMap.add(entry.getKey(), entry.getValue());
        }
    }
}
