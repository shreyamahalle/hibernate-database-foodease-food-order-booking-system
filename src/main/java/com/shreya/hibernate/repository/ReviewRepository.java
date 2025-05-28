package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.Review;

import java.util.List;

public interface ReviewRepository {

    void addReview(Review review);

    List<Review> retrieveReviews();

    Review findById(long id);

    boolean deleteReview(long id);

    boolean updateReview(Review review);

}