package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.Feedback;
import com.shreya.hibernate.repository.FeedbackRepository;

import java.util.List;
import java.util.Optional;

public class FeedbackRepositoryImpl implements FeedbackRepository {
    @Override
    public boolean addFeedback(Feedback feedback) {
        return false;
    }

    @Override
    public List<Feedback> retrieveFeedbacks() {
        return List.of();
    }

    @Override
    public Optional<Feedback> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteFeedback(Long id) {
        return false;
    }

    @Override
    public boolean updateFeedback(Feedback feedback) {
        return false;
    }
}
