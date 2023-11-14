package com.example.ilybe.domain.review.presentation;

import com.example.ilybe.domain.review.presentation.dto.request.ReviewRequest;
import com.example.ilybe.domain.review.presentation.dto.response.ReviewDetailsResponse;
import com.example.ilybe.domain.review.service.ReviewCreateService;
import com.example.ilybe.domain.review.service.ReviewDeleteService;
import com.example.ilybe.domain.review.service.ReviewDetailsService;
import com.example.ilybe.domain.review.service.ReviewUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/review")
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewCreateService reviewCreateService;
    private final ReviewUpdateService reviewUpdateService;
    private final ReviewDeleteService reviewDeleteService;
    private final ReviewDetailsService reviewDetailsService;

    @PostMapping("/{id}")
    public void reviewCreate(@PathVariable("id") Long meetId, @RequestBody @Valid ReviewRequest request) {
        reviewCreateService.execute(meetId, request);
    }

    @PatchMapping("/{id}")
    public void reviewUpdate(@PathVariable("id") Long reviewId, @RequestBody @Valid ReviewRequest request) {
        reviewUpdateService.execute(reviewId, request);
    }

    @DeleteMapping("/{id}")
    public void reviewDelete(@PathVariable("id") Long reviewId) {
        reviewDeleteService.execute(reviewId);
    }

    @GetMapping("/{id}")
    public List<ReviewDetailsResponse> reviewDetails(@PathVariable("id") Long meetId) {
        return reviewDetailsService.execute(meetId);
    }
}
