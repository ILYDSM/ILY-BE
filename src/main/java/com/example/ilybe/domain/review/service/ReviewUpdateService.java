package com.example.ilybe.domain.review.service;

import com.example.ilybe.domain.review.domain.Review;
import com.example.ilybe.domain.review.domain.repository.ReviewRepository;
import com.example.ilybe.domain.review.facade.ReviewFacade;
import com.example.ilybe.domain.review.presentation.dto.request.ReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReviewUpdateService {
    private final ReviewRepository reviewRepository;
    private final ReviewFacade reviewFacade;

    public void execute(Long reviewId, ReviewRequest request) {
        Review review = reviewFacade.findByReviewId(reviewId);
        reviewFacade.checkWriter(review);

        review.reviewUpdate(request.getContent(), LocalDateTime.now());

        reviewRepository.save(review);
    }
}
