/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

import java.time.LocalDate;

/**
 *
 * @author Ankur Bywar
 */
public class SystemAdmin extends Person {
    public SystemAdmin(
            String fullName, 
            LocalDate dob, 
            Gender gender, 
            Address address, 
            String phoneNumber, 
            UserAccount account) {
        super(null, null, null, null, null, account, Role.SYSTEM_ADMIN);
    }
}
