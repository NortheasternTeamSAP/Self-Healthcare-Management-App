/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Organization;

/**
 *
 * @author Ankur Bywar
 */
public enum OrganizationType {
    // Health management app enterprise
    ADMIN_ORGANIZATION("AdminOrg"), // will contain system admin role
    PATIENT_ORGANIZATION("PatientOrg"), // will contain patient roles
    
    // Hospital enterprise
    PRIMARY_CARE("PrimaryCare"), // Will contain doctor roles
    LABORATORY("Laboratory"), // Will contain lab assistant roles
    
    // Insurance Company enterprise
    HEALTH_INSURANCE_DEPARTMENT("HealthInsuranceDepartment"), // Will contain insurance company representative roles
    
    // Pharmacy enterprise
    MEDICINE_INVENTORY("MedicineInventory"), // Will contain pharmacist/pharmacy manager roles
    LOGISTICS("Logistics"), // Will contain delivery man roles
    
    // Physical wellness enterprise
    NUTRITION_DEPARTMENT("NutritionDepartment"), // Will contain dietitian roles
    GYM("Gym"), // will contain gym trainer roles
    
    // Mental health enterprise
    PSYCHIATRY_DEPARTMENT("PsychiatryDepartment"), // Will contain psychiatrist roles
    
    // Add more types here
    INVALID("Invalid");
    
    private String value;
    
    private OrganizationType(String value) {
        this.value = value;
    }
    
    public String toString() {
        return value;
    }
}
