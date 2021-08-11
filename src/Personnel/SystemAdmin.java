/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

import Personnel.PersonDetails.Gender;
import java.time.LocalDate;
import javax.swing.Icon;

/**
 *
 * @author Ankur Bywar
 */
public class SystemAdmin implements Person {
    private PersonDetails sysAdminDetails;
    
    public SystemAdmin(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber,
            Icon logoImage,
            UserAccount account) {
        
        sysAdminDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, logoImage, Role.SYSTEM_ADMIN);
    }

    @Override
    public UserAccount getUserAccount() {
        return sysAdminDetails.getUserAccount();
    }

    @Override
    public Role getRole() {
        return sysAdminDetails.getRole();
    }

    @Override
    public PersonDetails getPersonDetails() {
        return sysAdminDetails;
    }
}
