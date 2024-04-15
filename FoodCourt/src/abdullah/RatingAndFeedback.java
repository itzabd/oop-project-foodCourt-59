/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abdullah;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class RatingAndFeedback implements Serializable {
    String feedback, stallCB,review;

    public RatingAndFeedback(String feedback, String stallCB, String review) {
        this.feedback = feedback;
        this.stallCB = stallCB;
        this.review = review;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getStallCB() {
        return stallCB;
    }

    public void setStallCB(String stallCB) {
        this.stallCB = stallCB;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "RatingAndFeedback{" + "feedback=" + feedback + ", stallCB=" + stallCB + ", review=" + review + '}';
    }
    
    
}
