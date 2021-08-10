/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

/**
 *
 * @author Ankur Bywar
 */
public enum Role {
    SYSTEM_ADMIN("SysAdmin"),
    PATIENT("Patient"),
    DOCTOR("Doctor"),
    DELIVERY_MAN("DeliveryMan"),
    PHARMACIST("Pharmacist"),
    DIETITIAN("Dietitian"),
    TRAINER("FitnessTrainer"),
    COUNSELOR("Counselor")
    // Add more roles here and create corresponding 
    // classes which extends Person class
    , INVALID("Invalid");
    
    private String value;
    
    private Role(String value) {
        this.value = value;
    }
    
    public String toString() {
        return value;
    }
}
