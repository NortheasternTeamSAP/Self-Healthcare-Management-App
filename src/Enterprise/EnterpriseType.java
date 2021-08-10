/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enterprise;

/**
 *
 * @author Ankur Bywar
 */
public enum EnterpriseType {
    HEALTH_MANAGEMENT_APP("HealthApp"), // the app itself is an enterprise
    HOSPITAL("Hospital"),
    INSURANCE_COMPANY("InsuranceCompany"),
    PHARMACY("Pharmacy"),
    PHYSICAL_WELLNESS("PhysicalWellness"),
    MENTAL_HEALTH("MentalHealth"),
    // Add more types here
    INVALID("Invalid");
    
    private String value;
    
    private EnterpriseType(String value) {
        this.value = value;
    }
    
    public String toString() {
        return value;
    }
}