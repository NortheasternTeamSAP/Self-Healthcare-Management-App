/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine;

import java.time.LocalDate;

/**
 *
 * @author Sravya 
 */
public class Medicine {
    private String medicineId;
    private String medicineName;
    private double price;
    LocalDate expiryDate;
    LocalDate mfgDate;
   
    public Medicine(
            String medicineName,
            double price, 
            LocalDate expiryDate, 
            LocalDate mfgDate) {
        this.medicineName = medicineName;
        this.price = price;
        this.expiryDate = expiryDate;
        this.mfgDate = mfgDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate(LocalDate mfgDate) {
        this.mfgDate = mfgDate;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @Override
    public String toString(){
        return medicineName;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }
}
