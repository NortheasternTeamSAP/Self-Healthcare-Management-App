/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personnel;

import Utils.Rating;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mrs.katey
 */
public class PersonRatings {
    List<Rating> ratings;
    
    public PersonRatings() {
        ratings = new ArrayList<>();
    }
    
    public void addRating(Rating rating) {
        ratings.add(rating);
    }
    
    public List<Rating> getAllRatings() {
        Collections.sort(ratings);
        return ratings;
    }
}
