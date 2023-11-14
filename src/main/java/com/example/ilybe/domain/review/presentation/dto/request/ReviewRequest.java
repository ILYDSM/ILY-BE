package com.example.ilybe.domain.review.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
public class ReviewRequest {
    @NotNull(message = "내용을 입력해주세요.")
    private String content;
}
