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
public interface Person {
   
    
    public UserAccount getUserAccount();
    public Role getRole();
    public PersonDetails getPersonDetails();
    public int getOrganizationId();
    public void updateDetails(PersonDetails newPersonalDetails);

}
