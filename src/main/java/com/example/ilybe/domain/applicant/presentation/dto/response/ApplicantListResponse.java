package com.example.ilybe.domain.applicant.presentation.dto.response;

import com.example.ilybe.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ApplicantListResponse {
    private String nickname;
    private Long userId;

    public static ApplicantListResponse from(User user) {
        return ApplicantListResponse.builder()
                .nickname(user.getNickname())
                .userId(user.getId())
                .build();
    }
}
