/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

import Utils.Rating;
import java.util.List;

/**
 *
 * @author Ankur Bywar
 */
public interface Person {
   
    
    public UserAccount getUserAccount();
    public Role getRole();
    public PersonDetails getPersonDetails();
    public long getOrganizationId();
    public void updateDetails(PersonDetails newPersonalDetails);
    
    public void addRating(Rating rating);
    public List<Rating> getAllRatings();
}
