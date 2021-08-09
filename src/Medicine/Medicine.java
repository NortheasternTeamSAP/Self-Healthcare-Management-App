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
    String medicineName;
    private double price;
    LocalDate expiryDate;
    LocalDate mfgDate;
    //String medicineID;
    String dosage;
    

    public Medicine(
            String medicineName,
            double price, 
            LocalDate expiryDate, 
            LocalDate mfgDate, 
            String dosage) {
        this.medicineName = medicineName;
        this.price = price;
        this.expiryDate = expiryDate;
        this.mfgDate = mfgDate;
        //this.medicineID = medicineID;
        this.dosage = dosage;
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

//    public String getMedicineID() {
//        return medicineID;
//    }
//
//    public void setMedicineID(String medicineID) {
//        this.medicineID = medicineID;
//    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }  
}
