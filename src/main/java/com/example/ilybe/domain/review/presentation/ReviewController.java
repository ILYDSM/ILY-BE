package com.example.ilybe.domain.review.presentation;

import com.example.ilybe.domain.review.presentation.dto.request.ReviewRequest;
import com.example.ilybe.domain.review.service.ReviewCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/review")
@RequiredArgsConstructor
@RestController
public class ReviewController {
    private final ReviewCreateService reviewCreateService;

    @PostMapping("/{id}")
    public void reviewCreate(@PathVariable("id") Long meetId, @RequestBody @Valid ReviewRequest request) {
        reviewCreateService.execute(meetId, request);
    }
}
