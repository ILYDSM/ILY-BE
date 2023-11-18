package com.example.ilybe.domain.review.service;

import com.example.ilybe.domain.review.domain.Review;
import com.example.ilybe.domain.review.domain.repository.ReviewRepository;
import com.example.ilybe.domain.review.facade.ReviewFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewDeleteService {
    private final ReviewRepository reviewRepository;
    private final ReviewFacade reviewFacade;

    @Transactional
    public void execute(Long reviewId) {
        Review review = reviewFacade.findByReviewId(reviewId);
        reviewFacade.checkWriter(review);

        reviewRepository.delete(review);
    }

}
