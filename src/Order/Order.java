/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Doctor.Doctor;
import Medicine.MedicineDirectory;
import Pharmacy.Pharmacy;
import WorkQueue.WorkRequest;

/**
 *
 * @author Sravya
 */
public class Order extends WorkRequest {
    private String orderUUID;
    private String orderStatus;
    private Pharmacy pharmacy;
    private Doctor doctor;
    private String deliveryMan;
    private int quantity;
    private MedicineDirectory medicineCatalog;
    private String result;
    private boolean assign;

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

    public MedicineDirectory getMedicineCatalog() {
        return medicineCatalog;
    }

    public void setMedicineCatalog(MedicineDirectory medicineCatalog) {
        this.medicineCatalog = medicineCatalog;
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

    public String getOrderUUID() {
        return orderUUID;
    }

    public void setOrderUUID(String orderUUID) {
        this.orderUUID = orderUUID;
    } 
    
    @Override
    public String toString() {
        return orderUUID;
    }
}
