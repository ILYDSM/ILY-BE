package com.example.ilybe.domain.review.facade;

import com.example.ilybe.domain.board.exception.WriterMismatchedException;
import com.example.ilybe.domain.meet.domain.Meet;
import com.example.ilybe.domain.review.domain.Review;
import com.example.ilybe.domain.review.domain.repository.ReviewRepository;
import com.example.ilybe.domain.review.exception.ReviewNotFoundException;
import com.example.ilybe.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ReviewFacade {
    private final ReviewRepository reviewRepository;
    private final UserFacade userFacade;

    public Review findByReviewId(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> ReviewNotFoundException.EXCEPTION);
    }

    public void checkWriter(Review review) {
        if(!userFacade.getCurrentUser().equals(review.getUser()))
            throw WriterMismatchedException.EXCEPTION;
    }

    public List<Review> findByMeet(Meet meet) {
        return reviewRepository.findByMeet(meet)
                .orElseThrow(() -> ReviewNotFoundException.EXCEPTION);
    }
}
