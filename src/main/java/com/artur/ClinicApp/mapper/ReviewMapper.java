package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.controller.ObjectNotFoundException;
import com.artur.ClinicApp.domain.entity.Review;
import com.artur.ClinicApp.domain.dto.ReviewDto;
import com.artur.ClinicApp.service.DoctorDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewMapper {

    DoctorDbService doctorDbService;

    public Review mapToReview(final ReviewDto reviewDto) throws ObjectNotFoundException {
        return new Review(
                reviewDto.getId(),
                reviewDto.getOpinion(),
                reviewDto.getDate(),
                reviewDto.getAuthor(),
                doctorDbService.getDoctorById(reviewDto.getDoctorId())
        );
    }

    public ReviewDto mapToReviewDto(Review review) {
        return new ReviewDto(
                review.getId(),
                review.getOpinion(),
                review.getDate(),
                review.getAuthor(),
                review.getDoctor().getId()
        );
    }

    public List<ReviewDto> mapToReviewDtoList(final List<Review> reviews) {
        return reviews.stream()
                .map(this::mapToReviewDto)
                .toList();
    }
}
