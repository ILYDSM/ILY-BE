package com.example.ilybe.domain.applicant.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ApplicantListResponse {
    private String nickname;
    private Long userId;
}
