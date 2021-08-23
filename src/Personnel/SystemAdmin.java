/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

import Personnel.PersonDetails.Gender;
import Utils.Rating;
import java.time.LocalDate;
import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author Ankur Bywar
 */
public class SystemAdmin implements Person {
    private PersonDetails sysAdminDetails;
    private String emailPassword = "SreePreetiAnkur";
    
    public SystemAdmin(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber,
            Icon logoImage,
            UserAccount account) {
        
        sysAdminDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, 
                Role.SYSTEM_ADMIN, logoImage);
    }
    
    public SystemAdmin(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber,
            Icon logoImage,
            UserAccount account,
            long organizationId,
            String emailId) {
        
        sysAdminDetails = new PersonDetails(fullName, dob, gender, address, phoneNumber, account, 
                Role.SYSTEM_ADMIN, logoImage, organizationId, emailId);
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

    @Override
    public long getOrganizationId() {
       return getPersonDetails().getOrganizationId();
    }

    @Override
    public void updateDetails(PersonDetails newPersonalDetails) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addRating(Rating rating) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rating> getAllRatings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getEmailPassword() {
        return this.emailPassword;
    }
    
}
