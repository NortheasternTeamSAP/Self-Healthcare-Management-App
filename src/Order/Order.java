/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import DataStore.Appointment;
import DeliveryMan.DeliveryMan;
import Doctor.Doctor;
import Medicine.Medicine;
import Medicine.MedicineDirectory;
import Patient.Patient;
import WorkQueue.WorkRequest;
import java.util.UUID;
import Enterprise.PharmacyEnterprise;
import Prescription.Dosage;
import WorkQueue.WorkRequest;

/**
 *
 * @author Sravya
 */
public class Order extends WorkRequest {

    public enum OrderStatus{
        INPROCESS,
        ACCEPTED,
        DELIVERY_REQUESTED,
        SHIPPED,
        DELIVERED,
    }

    private OrderStatus orderStatus;
    private PharmacyEnterprise pharmacy;
    private Doctor doctor;
    private Patient patient;
    private DeliveryMan deliveryMan;
    private int quantity;
    private Medicine medicine;
    private Dosage dosage;
    private String result;
    private boolean assign;
    private String orderId;
    private Appointment appointment;

    public Order(
            PharmacyEnterprise pharmacy, 
            Doctor doctor, 
            Patient patient,
            int quantity, 
            Medicine medicine,
            Dosage dosage,
            Appointment appointment) {
        
        this.orderStatus = OrderStatus.INPROCESS;
        this.pharmacy = pharmacy;
        this.doctor = doctor;
        this.patient = patient;
        this.quantity = quantity;
        this.medicine = medicine;
        this.dosage = dosage;
        this.appointment = appointment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PharmacyEnterprise getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(PharmacyEnterprise pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isAssign() {
        return assign;
    }

    public void setAssign(boolean assign) {
        this.assign = assign;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    } 
}
