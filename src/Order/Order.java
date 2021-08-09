/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Doctor.Doctor;
import Medicine.Medicine;
import Medicine.MedicineDirectory;
import Pharmacy.Pharmacy;
import WorkQueue.WorkRequest;
import java.util.UUID;
import Pharmacy.Pharmacy;
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

    private String orderId;  //= UUID.randomUUID().toString();
    private String orderStatus;
    private Pharmacy pharmacy;
    private Doctor doctor;
    private String deliveryMan;
    private int quantity;
    private String result;
    private boolean assign;
    private Medicine medicine;

    public Order(
            Pharmacy pharmacy, 
            Doctor doctor, 
            Patient patient,
            int quantity, 
            Medicine medicine) {
        
        this.orderStatus = OrderStatus.INPROCESS;
        this.pharmacy = pharmacy;
        this.doctor = doctor;
        this.patient = patient;
        this.quantity = quantity;
        this.medicine = medicine;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(String deliveryMan) {
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
    
}
