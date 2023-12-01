package com.example.ilybe.domain.review.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class ReviewDetailsResponse {
    private final Long id;
    private final String writerName;
    private final String content;
    private final LocalDateTime createDate;
}
