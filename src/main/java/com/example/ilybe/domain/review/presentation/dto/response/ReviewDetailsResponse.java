package com.example.ilybe.domain.review.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
public class ReviewDetailsResponse {
    private Long id;
    private String writerName;
    private String content;
    private LocalDateTime createDate;
}
