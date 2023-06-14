package com.artur.ClinicApp.service;

import com.artur.ClinicApp.domain.entity.Review;
import com.artur.ClinicApp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewDbService {

    private final ReviewRepository repository;

    public Review saveReview(final Review review) {
        return repository.save(review);
    }

    public List<Review> allDoctorReviews(final Long id) {
        return repository.findReviewByDoctorId(id);
    }
}
