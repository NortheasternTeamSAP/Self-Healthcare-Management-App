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
    public GenericDirectory<String, Medicine> medicineCatalogMap; //map of <String medID, Medicine medDetails>
    private int id;

    public MedicineDirectory(){
        /**
         * example usage:
         * 
         * MedicineDirectory.medicineCatalog.add(str, medicine);
         */
        this.medicineCatalogMap = new GenericDirectory<String, Medicine>();
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
            LocalDate mfgDate
    ){
        
        Medicine medicine = new Medicine(medicineName, price, expiryDate, mfgDate);
        String medicineId = "Med" + Integer.toString(id);
        medicine.setMedicineId(medicineId);
        medicineCatalogMap.add(medicineId, medicine);
        id += 1;
        return medicine;
    }
    
    /**
     * Method to delete medicine from medicineCatalogMap.
     * @param medicine 
     */
    public void deleteMedicine(Medicine medicine){
        medicineCatalogMap.remove(Integer.toString(id));
    }

    public GenericDirectory<String, Medicine> getMedicineCatalogMap() {
        return medicineCatalogMap;
    }
    
    public void setMedicinePrice(Medicine medicine, int newPrice){
        medicine.setPrice(newPrice);
    }

}
