/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prescription;

import DataStore.Appointment;
import DataStore.GenericDirectory;
import Medicine.Medicine;
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
    private int id;
    private Appointment appointment; // appointment associated with this prescription
    private DeliveryMan.DeliveryMan deliveryMan;
    boolean deliveryReviewProvided;
    private Date deliveryDate;

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
    
    static int count = 1;

    public Prescription(Appointment appointment) {
        this.prescriptionMap = new GenericDirectory<>();
        this.prescriptionDate = appointment.getDate();
        this.appointment = appointment;
        this.deliveryReviewProvided = false;
        this.deliveryDate = null;
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
