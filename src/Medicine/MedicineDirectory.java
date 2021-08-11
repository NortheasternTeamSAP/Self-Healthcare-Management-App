/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine;
import java.time.LocalDate;
import DataStore.GenericDirectory;

/**
 *
 * @author Sravya
 */
public class MedicineDirectory{
    
    public GenericDirectory<String, Medicine> medicineCatalog; //map of <String medID, Medicine medDetails>
    private int id;

    public MedicineDirectory(){
        /**
         * example usage:
         * 
         * MedicineDirectory.medicineCatalog.add(str, medicine);
         */
        this.medicineCatalog = new GenericDirectory<String, Medicine>();
        id = 0;
    }

    /**
     * Method to add medicines.
     * @param medicineName
     * @param price
     * @param expiryDate
     * @param mfgDate
     * @param dosage
     * @return medicine
     */
    public Medicine addMedicine(
            String medicineName,
            double price, 
            LocalDate expiryDate, 
            LocalDate mfgDate, 
            String dosage,
            int quantity){
        
        Medicine medicine = new Medicine(medicineName, price, expiryDate, mfgDate, dosage, quantity);
        medicineCatalog.add(Integer.toString(id), medicine);
        id += 1;
        return medicine;
    }
    
    /**
     * Method to delete medicine from medicineCatalog.
     * @param medicine 
     */
    public void deleteMedicine(Medicine medicine){
        medicineCatalog.remove(Integer.toString(id));
    }

    public GenericDirectory<String, Medicine> getMedicineCatalog() {
        return medicineCatalog;
    }

}
