/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import static Utils.Rating.RatingStatus.RATING_NOT_PROVIDED;
import static Utils.Rating.RatingStatus.RATING_PROVIDED;
import java.time.Instant;
import java.time.LocalDate;

/**
 *
 * @author mrs.katey
 */
public class Rating implements Comparable<Rating> {
    
    public enum RatingStatus {
        RATING_NOT_PROVIDED,
        RATING_PROVIDED
    }
    
    long ratingId;
    int rating;
    String feedBack;
    LocalDate ratingDate;
    RatingStatus status;

    // ONLY FOR TESTING and mocking data
    public Rating(int rating, String feedBack, LocalDate ratingDate) {
        this.rating = rating;
        this.feedBack = feedBack;
        this.ratingDate = ratingDate;
        this.status = RATING_PROVIDED;
        this.ratingId = Instant.now().toEpochMilli();
    }
    
    public Rating() {
        this.status = RATING_NOT_PROVIDED;
        this.ratingId = Instant.now().toEpochMilli();
    }

    public long getRatingId() {
        return ratingId;
    }

    public int getRating() {
        return rating;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public LocalDate getRatingDate() {
        return ratingDate;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public void setRatingDate(LocalDate ratingDate) {
        this.ratingDate = ratingDate;
    }

    public void setStatus(RatingStatus status) {
        this.status = status;
    }

    public RatingStatus getStatus() {
        return status;
    }

    @Override
    public int compareTo(Rating rating) {
        return this.ratingDate.compareTo(rating.getRatingDate());
    }
}
