/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine;
import java.time.LocalDate;
import DataStore.GenericDirectory;
import java.time.Instant;

/**
 *
 * @author Sravya
 */
public class MedicineDirectory{
    public GenericDirectory<String, Medicine> medicineCatalogMap; //map of <String medID, Medicine medDetails>

    public MedicineDirectory(){
        /**
         * example usage:
         * 
         * MedicineDirectory.medicineCatalog.add(str, medicine);
         */
        this.medicineCatalogMap = new GenericDirectory<String, Medicine>();
    }
    /**
     * Method to add medicines.
     * @param medicineName
     * @param price
     * @param expiryDate
     * @param mfgDate
     * @return medicine
     */
    public Medicine addMedicine(
            String medicineName,
            double price, 
            LocalDate expiryDate, 
            LocalDate mfgDate
    ){
        
        Medicine medicine = new Medicine(medicineName, price, expiryDate, mfgDate);
        long id = Instant.now().toEpochMilli();
        String medicineId = "Med" + Long.toString(id);
        medicine.setMedicineId(medicineId);
        medicineCatalogMap.add(medicineId, medicine);
        System.out.println("*** Added med : " + medicineId + "  in medicineCatalogMap");
        return medicine;
    }

    /**
     * Method to delete medicine from medicineCatalogMap.
     * @param medicine 
     */
    public void deleteMedicine(String medicineId){
        medicineCatalogMap.remove(medicineId);
    }

    public GenericDirectory<String, Medicine> getMedicineCatalogMap() {
        return medicineCatalogMap;
    }
    
    public Medicine getMedicine(String medicineId) {
        return medicineCatalogMap.get(medicineId);
    }
    
    public void setMedicinePrice(Medicine medicine, int newPrice){
        medicine.setPrice(newPrice);
    }

}
