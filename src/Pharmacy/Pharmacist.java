/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pharmacy;

/**
 *
 * @author Sravya
 */
public class Pharmacist implements Person{
    private PersonDetails pharmacistDetails;
    
    public Pharmacist(
            String fullName,
            LocalDate dob,
            Gender gender,
            Address address,
            String phoneNumber,
            UserAccount account){
        
        pharmacistDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, Role.PHARMACIST);
    }
    
    @Override
    public UserAccount getUserAccount(){
        return pharmacistDetails.getUserAccount();
    }
    
    @Override
    public Role getRole(){
        return pharmacistDetails.getRole();
    }
    
}
