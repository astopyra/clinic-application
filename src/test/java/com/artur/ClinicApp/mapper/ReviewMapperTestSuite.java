package com.artur.ClinicApp.mapper;

import com.artur.ClinicApp.domain.dto.ReviewDto;
import com.artur.ClinicApp.domain.entity.Doctor;
import com.artur.ClinicApp.domain.entity.Review;
import com.artur.ClinicApp.service.DoctorDbService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ReviewMapperTestSuite {

    @Autowired
    ReviewMapper reviewMapper;

    @MockBean
    private DoctorDbService doctorDbService;
//todo
//    @Test
//    void testMapToReview() throws ObjectNotFoundException {
//        //given
//        ReviewDto reviewDto = new ReviewDto(1L, "doctor fully recomended", LocalDateTime.now(), "anonim", 1L);
//        Doctor doctor = new Doctor(1L, "Jan", "Pyś", "janp@o2.pl", "chirurg");
//        when(doctorDbService.getDoctorById(1L)).thenReturn(doctor);
//        //when
//        Review review = reviewMapper.mapToReview(reviewDto);
//        //then
//        assertEquals("doctor fully recomended", review.getOpinion());
//        assertEquals(1L, review.getDoctor().getId());
//    }

    @Test
    void testMapToReviewDto() {
        //given
        Review review = new Review(1L, "doctor fully recomended", LocalDateTime.now(), "anonim",
                new Doctor(1L, "Jan", "Pyś", "janp@o2.pl", "chirurg"));

        //when
        ReviewDto reviewDto = reviewMapper.mapToReviewDto(review);

        //then
        assertEquals("anonim", reviewDto.getAuthor());
        assertEquals(1L, reviewDto.getDoctorId());
    }

    @Test
    void testMapToReviewDtoList() {
        //given
        Review review = new Review(1L, "doctor fully recomended", LocalDateTime.now(), "anonim",
                new Doctor(1L, "Jan", "Pyś", "janp@o2.pl", "chirurg"));
        List<Review> reviews = List.of(review);

        //when
        List<ReviewDto> reviewsDto = reviewMapper.mapToReviewDtoList(reviews);

        //then
        assertEquals(1, reviewsDto.size());
        assertEquals("doctor fully recomended", reviewsDto.get(0).getOpinion());
    }

}
