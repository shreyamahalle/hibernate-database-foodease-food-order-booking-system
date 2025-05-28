package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.Review;
import com.shreya.hibernate.repository.ReviewRepository;

import java.util.List;

public class ReviewRepositoryImpl implements ReviewRepository{


    @Override
    public void addReview(Review review) {

    }

    @Override
    public List<Review> retrieveReviews() {
        return List.of();
    }

    @Override
    public Review findById(long id) {
        return null;
    }

    @Override
    public boolean deleteReview(long id) {
        return false;
    }

    @Override
    public boolean updateReview(Review review) {
        return false;
    }
}
