package com.artur.ClinicApp.controller;

import com.artur.ClinicApp.domain.Review;
import com.artur.ClinicApp.domain.dto.ReviewDto;
import com.artur.ClinicApp.mapper.ReviewMapper;
import com.artur.ClinicApp.service.ReviewDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewMapper mapper;
    private final ReviewDbService dbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addReview(@RequestBody ReviewDto reviewDto) throws ObjectNotFoundException {
        Review review = mapper.mapToReview(reviewDto);
        dbService.saveReview(review);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value="{id}")
    public ResponseEntity<List<ReviewDto>>getAllDoctorReviews(@PathVariable Long id) {
        List<Review> reviews = dbService.allDoctorReviews(id);
        return ResponseEntity.ok(mapper.mapToReviewDtoList(reviews));
    }

}
