package com.example.ilybe.domain.review.exception;

import com.example.ilybe.global.error.CustomException;
import com.example.ilybe.global.error.ErrorCode;

public class ReviewNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new ReviewNotFoundException();

    private ReviewNotFoundException() {
        super(ErrorCode.REVIEW_NOT_FOUND);
    }
}
